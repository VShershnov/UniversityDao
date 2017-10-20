package test.java.com.foxminded.dao;

import java.util.List;

import main.java.com.foxminded.dao.DaoFactory;
import main.java.com.foxminded.dao.PersistException;
import main.java.com.foxminded.dao.PostgreSqlGroupDao;
import main.java.com.foxminded.dao.PostgreSqlProfessorDao;
import main.java.com.foxminded.dao.PostgreSqlScheduleSlotDao;
import main.java.com.foxminded.schedule.ScheduleSlot;
import main.java.com.foxminded.schedule.TimeUnit;
import main.java.com.foxminded.university.Course;
import main.java.com.foxminded.university.Group;
import main.java.com.foxminded.university.Room;
import main.java.com.foxminded.university.person.Professor;
import main.java.com.foxminded.university.person.Student;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProfessorDAOTest {
	
	private DaoFactory daoFactory;
	
	private PostgreSqlProfessorDao dao;
	
	private Professor prof;
	
	@Before
	public void setUpBefore() throws PersistException{
		try {   
			daoFactory = new DaoFactory();
	        dao = daoFactory.getProfessorDao();
	    } catch (Exception e) {
	    	System.err.println("Could not setup logger configuration: " + e.toString());
            throw new PersistException(e);
        }		
	}
	
	@After
	public void tearDown(){
		daoFactory = null;
		dao = null;
		prof = null;
	}

	@Test
	public void testCreate() throws PersistException {
		try {
			prof = dao.create("Stetina");			
			Assert.assertNotNull(prof);
		    Assert.assertNotNull(prof.getId());
		    
		    dao.delete(prof);
		    
	    } catch (Exception e) {
            throw new PersistException(e);
        }
	}
	 
	@Test
	public void testGetByPK() throws PersistException {
		 int id = dao.create("Stetina").getId();
		 prof = dao.getByPK(id);
	     
		 Assert.assertNotNull(prof);
	        
		 dao.delete(prof);   
	}
	
	@Test
	public void testGetAll() throws PersistException {
		
	    List<Professor> list;
	    try {	        
	        list = dao.getAll();
	    } catch (Exception e) {
	        throw new PersistException(e);
	    }
	    
	    Assert.assertNotNull(list);
	    Assert.assertTrue(list.size() > 0);		
	}

	@Test
	public void testGetInstanceAllDependentCourseObj() throws PersistException {
		prof = new Professor(1,"Stepanov");
		
		List<Integer> list = dao.getInstanceAllDependentObj(prof, Course.class);

		Assert.assertNotNull(list);
	    Assert.assertTrue(list.size() > 0);
	}	
	
	@Test
	public void testAddRemoveInstanceDependentCourse() throws PersistException {
		Professor prof = dao.getByPK(5);
		Course course = new Course(4, "Math", 12);
		
		try {
			dao.addInstanceDependentObj(prof, course);
			List<Integer> list = dao.getInstanceAllDependentObj(prof, Course.class);
			Assert.assertTrue("not the same course", list.contains(course.getId()));
			
			dao.removeInstanceDependentObj(prof, course);
			list = dao.getInstanceAllDependentObj(prof, Course.class);
			Assert.assertFalse("not the same course", list.contains(course.getId()));
	    } catch (Exception e) {
            throw new PersistException(e);
        }
	}
	
	
	@Test
	public void testUpdate() throws PersistException {
		Professor p = new Professor(1,"Petrov");
		try {
			dao.update(p);
			
			prof = dao.getByPK(p.getId());
			Assert.assertTrue("not the same professor", p.equals(prof));
	    } catch (Exception e) {
            throw new PersistException(e);
        }	    
	}

	
	@Test
	public void testDelete() throws PersistException {
		try {
			TimeUnit time = daoFactory.getTimeUnitDao().getByPK(2);
			Room room = daoFactory.getRoomDao().getByPK(1);
			Course course = daoFactory.getCourseDao().getByPK(3);
			Group group = daoFactory.getGroupDao().getByPK(3);
			
			prof = dao.create("Vasiliev");
			
			PostgreSqlScheduleSlotDao daoSS = daoFactory.getScheduleSlotDao();
			ScheduleSlot scheduleSlot = daoSS.create(time, room, course, prof, group);
			Assert.assertNotNull(scheduleSlot.getId());

	        List<Professor> list = dao.getAll();
	        Assert.assertNotNull(list);

	        int oldSize = list.size();
	        Assert.assertTrue(oldSize > 0);

	        dao.delete(prof);


	        list = dao.getAll();
	        Assert.assertNotNull(list);

	        int newSize = list.size();
	        Assert.assertEquals(1, oldSize - newSize);
	        
	        ScheduleSlot newSS = daoSS.getByPK(scheduleSlot.getId());
	        Assert.assertEquals(null, newSS.getProfessor());
	        
	        daoSS.delete(scheduleSlot);	        
	        
		} catch (Exception e) {
            throw new PersistException(e);
        }
	}
	
	@Test
	public void testDeletefromProfessorCourse() throws PersistException {
		try {
			Course c = new Course(8, "JavaEE", 10);
			prof = dao.create("Sidorov");
						
			dao.addInstanceDependentObj(prof, c);
						
	        List<Professor> listProfessors = dao.getAll();
	        Assert.assertNotNull(listProfessors);

	        List<Integer> listCourses = dao.getInstanceAllDependentObj(prof, c.getClass());
	        Assert.assertNotNull(listCourses);
	        
	        
	        int oldSizeProfessors = listProfessors.size();
	        Assert.assertTrue(oldSizeProfessors > 0);
	        int oldSizeCourses = listCourses.size();
	        Assert.assertTrue(oldSizeCourses > 0);	        
	        	        
	        dao.delete(prof);

	        listProfessors = dao.getAll();
	        Assert.assertNotNull(listProfessors);
	        listCourses = dao.getInstanceAllDependentObj(prof, c.getClass());
	        Assert.assertNotNull(listCourses);
	       
	        
	        int newSizeProfessors = listProfessors.size();
	        Assert.assertEquals(1, oldSizeProfessors - newSizeProfessors);
	        int newSizeCourses = listCourses.size();
	        Assert.assertEquals(1, oldSizeCourses - newSizeCourses);              
	        
		} catch (Exception e) {
            throw new PersistException(e);
        }
	}
}
