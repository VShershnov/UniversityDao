package com.foxminded.dao;

import java.util.List;

import com.foxminded.dao.DaoFactory;
import com.foxminded.dao.PersistException;
import com.foxminded.dao.PostgreSqlRoomDao;
import com.foxminded.dao.PostgreSqlScheduleSlotDao;
import com.foxminded.dao.PostgreSqlTimeUnitDao;
import com.foxminded.schedule.Schedule;
import com.foxminded.schedule.ScheduleSlot;
import com.foxminded.schedule.TimeUnit;
import com.foxminded.university.Course;
import com.foxminded.university.Group;
import com.foxminded.university.Room;
import com.foxminded.university.person.Professor;
import com.foxminded.university.person.Student;

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
			prof = daoFactory.getProfessorDao().getByPK(3);
			group = daoFactory.getGroupDao().getByPK(3);
			scheduleSlot = dao.create(time, room, course, prof, group);
						
		    Assert.assertNotNull(scheduleSlot.getId());
		    dao.delete(scheduleSlot);
		    
	    } catch (Exception e) {
            throw new PersistException(e);
        }		
	}

	
	@Test
	public void testGetByPK() throws PersistException {
		time = daoFactory.getTimeUnitDao().getByPK(4);
		room = daoFactory.getRoomDao().getByPK(4);
		course = daoFactory.getCourseDao().getByPK(3);
		prof = daoFactory.getProfessorDao().getByPK(3);
		group = daoFactory.getGroupDao().getByPK(3);
		
		 int id = dao.create(time, room, course, prof, group).getId();
		 scheduleSlot = dao.getByPK(id);
	     
		 Assert.assertNotNull(scheduleSlot);
		 dao.delete(scheduleSlot);	     
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
		try {
			time = daoFactory.getTimeUnitDao().getByPK(7);
			room = daoFactory.getRoomDao().getByPK(4);
			course = daoFactory.getCourseDao().getByPK(3);
			prof = daoFactory.getProfessorDao().getByPK(3);
			group = daoFactory.getGroupDao().getByPK(3);			
			scheduleSlot = new ScheduleSlot(57, time, room, course, prof, group);
			
			
			dao.update(scheduleSlot);
			
			Assert.assertTrue("not the same timeUnit", scheduleSlot.equals(dao.getByPK(scheduleSlot.getId())));
	    } catch (Exception e) {
	        throw new PersistException(e);
	    }		
	}

	@Test
	public void testDelete() throws PersistException {
		try {
			time = daoFactory.getTimeUnitDao().getByPK(1);
			room = daoFactory.getRoomDao().getByPK(5);
			course = daoFactory.getCourseDao().getByPK(3);
			prof = daoFactory.getProfessorDao().getByPK(3);
			group = daoFactory.getGroupDao().getByPK(3);
			scheduleSlot = dao.create(time, room, course, prof, group);	    

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
}
