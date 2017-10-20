package test.java.com.foxminded.dao;

import java.util.List;

import main.java.com.foxminded.dao.DaoFactory;
import main.java.com.foxminded.dao.PersistException;
import main.java.com.foxminded.dao.PostgreSqlRoomDao;
import main.java.com.foxminded.dao.PostgreSqlScheduleSlotDao;
import main.java.com.foxminded.dao.PostgreSqlTimeUnitDao;
import main.java.com.foxminded.schedule.Schedule;
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

public class SheduleSlotDAOTest {
	
	private DaoFactory daoFactory;
	
	private PostgreSqlScheduleSlotDao dao;
	
	private ScheduleSlot scheduleSlot;
	
	private Group group;	
	
	private Room room;
	
	private Professor prof;	
	
	private Course course;
	
	private TimeUnit time;
	
	@Before
	public void setUpBefore() throws PersistException{
		try {   
			daoFactory = new DaoFactory();
	        dao = daoFactory.getScheduleSlotDao();
	    } catch (Exception e) {
	    	System.err.println("Could not setup logger configuration: " + e.toString());
            throw new PersistException(e);
        }		
	}
	
	@After
	public void tearDown(){
		daoFactory = null;
		dao = null;	
		group = null;
		room = null;
		course = null;
		prof = null;
		time = null;
	}

	@Test
	public void testCreate() throws PersistException {
		try {
			time = daoFactory.getTimeUnitDao().getByPK(4);
			room = daoFactory.getRoomDao().getByPK(3);
			course = daoFactory.getCourseDao().getByPK(3);
			prof = new Professor(3, "Stepanova");
			group = daoFactory.getGroupDao().getByPK(3);
			scheduleSlot = dao.create(time, room, course, prof, group);
			
			Assert.assertNotNull(scheduleSlot);
		    Assert.assertNotNull(scheduleSlot.getId());
	    } catch (Exception e) {
            throw new PersistException(e);
        }		
	}

	/*
	@Test
	public void testGetByPK() throws PersistException {
		 int id = dao.create(10, 18, 10).getId();
		 scheduleSlot = dao.getByPK(id);
	        Assert.assertNotNull(scheduleSlot);
	}

	@Test
	public void testGetAll() throws PersistException{
		
	    List<ScheduleSlot> list;
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
		ScheduleSlot ss = new ScheduleSlot(13, 12, 5, 10);
		try {
			dao.update(ss);
			
			Assert.assertTrue("not the same timeUnit", ss.equals(dao.getByPK(ss.getId())));
	    } catch (Exception e) {
	        throw new PersistException(e);
	    }		
	}

	@Test
	public void testDelete() throws PersistException {
		try {
			scheduleSlot = dao.create(11, 18, 10);	    

	        List<ScheduleSlot> list = dao.getAll();
	        Assert.assertNotNull(list);

	        int oldSize = list.size();
	        Assert.assertTrue(oldSize > 0);

	        dao.delete(scheduleSlot);

	        list = dao.getAll();
	        Assert.assertNotNull(list);

	        int newSize = list.size();
	        Assert.assertEquals(1, oldSize - newSize);
	        
		} catch (Exception e) {
            throw new PersistException(e);
        }
	}
*/
}
