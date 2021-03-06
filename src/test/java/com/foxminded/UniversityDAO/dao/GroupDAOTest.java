package com.foxminded.UniversityDAO.dao;

import java.util.List;

import com.foxminded.UniversityDAO.dao.DaoFactory;
import com.foxminded.UniversityDAO.dao.PersistException;
import com.foxminded.UniversityDAO.dao.PostgreSqlGroupDao;
import com.foxminded.UniversityDAO.dao.PostgreSqlScheduleSlotDao;
import com.foxminded.UniversityDAO.schedule.ScheduleSlot;
import com.foxminded.UniversityDAO.schedule.TimeUnit;
import com.foxminded.UniversityDAO.university.Course;
import com.foxminded.UniversityDAO.university.Group;
import com.foxminded.UniversityDAO.university.Room;
import com.foxminded.UniversityDAO.university.person.Professor;
import com.foxminded.UniversityDAO.university.person.Student;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GroupDAOTest {
	
	private DaoFactory daoFactory;
	
	private PostgreSqlGroupDao dao;
	
	private Group group;
	
	@Before
	public void setUpBefore() throws PersistException{
		try {   
			daoFactory = new DaoFactory();
	        dao = daoFactory.getGroupDao();
	    } catch (Exception e) {
	    	System.err.println("Could not setup logger configuration: " + e.toString());
            throw new PersistException(e);
        }		
	}
	
	@After
	public void tearDown(){
		daoFactory = null;
		dao = null;		
	}

	@Test
	public void testCreate() throws PersistException {
		try {
			group = dao.create("IPSA");			
			Assert.assertNotNull(group);
		    Assert.assertNotNull(group.getId());
	    } catch (Exception e) {
            throw new PersistException(e);
        }
	}
	
	@Test
	public void testGetByPK() throws PersistException {
		 int id = dao.create("FL").getId();
		 group = dao.getByPK(id);
	        Assert.assertNotNull(group);
	}
	
	@Test
	public void testGetAll() throws PersistException {
		
	    List<Group> list;
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
		group = new Group(1,"FIOT");
		
		List<Integer> list = dao.getInstanceAllDependentObj(group, Course.class);

		Assert.assertNotNull(list);
	    Assert.assertTrue(list.size() > 0);
	}
	
	@Test
	public void testGetInstanceAllDependentStudentObj() throws PersistException {
		group = new Group(1,"FIOT");
		
		List<Integer> list = dao.getInstanceAllDependentObj(group, Student.class);

		Assert.assertNotNull(list);
	    Assert.assertTrue(list.size() > 0);
	}
	
	@Test
	public void testAddRemoveInstanceDependentCourse() throws PersistException {
		Group g = dao.getByPK(3);
		Course course = new Course(4, "Math", 12);
		
		try {
			dao.addInstanceDependentObj(g, course);
			List<Integer> list = dao.getInstanceAllDependentObj(g, Course.class);
			Assert.assertTrue("not the same course", list.contains(course.getId()));
			
			dao.removeInstanceDependentObj(g, course);
			list = dao.getInstanceAllDependentObj(g, Course.class);
			Assert.assertFalse("not the same course", list.contains(course.getId()));
	    } catch (Exception e) {
            throw new PersistException(e);
        }
	}
	
	@Test
	public void testAddRemoveInstanceDependentStudent() throws PersistException {
		Group g = dao.getByPK(4);
		Student st = new Student(5, "Vitaly Shershnov");
		
		try {
			dao.addInstanceDependentObj(g, st);
			List<Integer> list = dao.getInstanceAllDependentObj(g, Student.class);
			Assert.assertTrue("not the same student", list.contains(st.getId()));
			
			dao.removeInstanceDependentObj(g, st);
			list = dao.getInstanceAllDependentObj(g, Student.class);
			Assert.assertFalse("not the same student", list.contains(st.getId()));
	    } catch (Exception e) {
            throw new PersistException(e);
        }
	}

	@Test
	public void testUpdate() throws PersistException {
		Group g = new Group(3,"FTZI");
		try {
			dao.update(g);
			
			group = dao.getByPK(g.getId());
			Assert.assertTrue("not the same group", g.equals(group));
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
			Professor prof = daoFactory.getProfessorDao().getByPK(3);
			
			group = dao.create("IPSA");
			
			PostgreSqlScheduleSlotDao daoSS = daoFactory.getScheduleSlotDao();
			ScheduleSlot scheduleSlot = daoSS.create(time, room, course, prof, group);
			Assert.assertNotNull(scheduleSlot.getId());

	        List<Group> list = dao.getAll();
	        Assert.assertNotNull(list);

	        int oldSize = list.size();
	        Assert.assertTrue(oldSize > 0);

	        dao.delete(group);

	        list = dao.getAll();
	        Assert.assertNotNull(list);

	        int newSize = list.size();
	        Assert.assertEquals(1, oldSize - newSize);
	        
	        ScheduleSlot newSS = daoSS.getByPK(scheduleSlot.getId());
	        Assert.assertEquals(null, newSS.getGroup());	        
	        daoSS.delete(scheduleSlot);
	        
		} catch (Exception e) {
            throw new PersistException(e);
        }
	}
	
	
	@Test
	public void testDeletefromGroupCourse() throws PersistException {
		try {
			Course c = new Course(8, "JavaEE", 10);
			group = dao.create("FTZI");
			Student st = new Student(5, "Vitaly Shershnov");
			
			dao.addInstanceDependentObj(group, c);
			dao.addInstanceDependentObj(group, st);
			
	        List<Group> listGroups = dao.getAll();
	        Assert.assertNotNull(listGroups);

	        List<Integer> listCourses = dao.getInstanceAllDependentObj(group, c.getClass());
	        Assert.assertNotNull(listCourses);
	        
	        List<Integer> listStudents = dao.getInstanceAllDependentObj(group, st.getClass());
	        Assert.assertNotNull(listStudents);
	        
	        
	        int oldSizeGroups = listGroups.size();
	        Assert.assertTrue(oldSizeGroups > 0);
	        int oldSizeCourses = listCourses.size();
	        Assert.assertTrue(oldSizeCourses > 0);	        
	        int oldSizeStudents = listStudents.size();
	        Assert.assertTrue(oldSizeStudents > 0);
	        
	        dao.delete(group);

	        listGroups = dao.getAll();
	        Assert.assertNotNull(listGroups);
	        listCourses = dao.getInstanceAllDependentObj(group, c.getClass());
	        Assert.assertNotNull(listCourses);
	        listStudents = dao.getInstanceAllDependentObj(group, st.getClass());
	        Assert.assertNotNull(listStudents);
	        
	        int newSizeGroups = listGroups.size();
	        Assert.assertEquals(1, oldSizeGroups - newSizeGroups);
	        int newSizeCourses = listCourses.size();
	        Assert.assertEquals(1, oldSizeCourses - newSizeCourses);
	        int newSizeStudents = listStudents.size();
	        Assert.assertEquals(1, oldSizeStudents - newSizeStudents);	        
	        
		} catch (Exception e) {
            throw new PersistException(e);
        }
	}
}
