package test.java.com.foxminded.dao;

import java.util.List;

import main.java.com.foxminded.dao.DaoFactory;
import main.java.com.foxminded.dao.PersistException;
import main.java.com.foxminded.dao.PostgreSqlScheduleSlotDao;
import main.java.com.foxminded.dao.PostgreSqlStudentDao;
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

public class StudentDAOTest {
	
	private DaoFactory daoFactory;
	
	private PostgreSqlStudentDao dao;
	
	private Student student;
	
	private Group group;
	
	@Before
	public void setUpBefore() throws PersistException{
		try {   
			daoFactory = new DaoFactory();
	        dao = daoFactory.getStudentDao();
	        group = daoFactory.getGroupDao().getByPK(3);
	    } catch (Exception e) {
	    	System.err.println("Could not setup logger configuration: " + e.toString());
            throw new PersistException(e);
        }		
	}
	
	@After
	public void tearDown(){
		daoFactory = null;
		dao = null;	
		student = null;
		group = null;
	}

	@Test
	public void testCreate() throws PersistException {
		try {			
			student = dao.create("Andrej", group);		
		    Assert.assertNotNull(student.getId());
		    
		    dao.delete(student);		    
	    } catch (Exception e) {
            throw new PersistException(e);
        }		
	}
	
	@Test
	public void testGetByPK() throws PersistException {
		int id = dao.create("Andrej", group).getId();
		 student = dao.getByPK(id);
	     Assert.assertNotNull(student);
	     dao.delete(student);	
	}

	@Test
	public void testGetAll() throws PersistException{
		
	    List<Student> list;
	    try {
	    	list = dao.getAll();
	    } catch (Exception e) {
            throw new PersistException(e);
        }
	    Assert.assertNotNull(list);
	    Assert.assertTrue(list.size() > 0);	
	}

	@Test
	public void testUpdate() throws PersistException {
		Group gr = daoFactory.getGroupDao().getByPK(4);
		Student st = new Student(5, "Igor", gr);
		try {
			dao.update(st);
			
			Assert.assertTrue("not the same Student", st.equals(dao.getByPK(st.getId())));
	    } catch (Exception e) {
	        throw new PersistException(e);
	    }		
	}

	
	@Test
	public void testDelete() throws PersistException {
		try {
			student = dao.create("Laslo", group);
			
	        List<Student> list = dao.getAll();
	        Assert.assertNotNull(list);

	        int oldSize = list.size();
	        Assert.assertTrue(oldSize > 0);

	        dao.delete(student);

	        list = dao.getAll();
	        Assert.assertNotNull(list);

	        int newSize = list.size();
	        Assert.assertEquals(1, oldSize - newSize);
	        
		} catch (Exception e) {
            throw new PersistException(e);
        }
	}
}
