package com.foxminded.UniversityDAO.dao;

import java.util.List;

import com.foxminded.UniversityDAO.dao.DaoFactory;
import com.foxminded.UniversityDAO.dao.PersistException;
import com.foxminded.UniversityDAO.dao.PostgreSqlRoomDao;
import com.foxminded.UniversityDAO.dao.PostgreSqlScheduleSlotDao;
import com.foxminded.UniversityDAO.schedule.ScheduleSlot;
import com.foxminded.UniversityDAO.schedule.TimeUnit;
import com.foxminded.UniversityDAO.university.Course;
import com.foxminded.UniversityDAO.university.Group;
import com.foxminded.UniversityDAO.university.Room;
import com.foxminded.UniversityDAO.university.person.Professor;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class RoomDAOTest {
	
	private DaoFactory daoFactory;
	
	private PostgreSqlRoomDao dao;
	
	private Room room;
	
	@Before
	public void setUpBefore() throws PersistException{
		try {   
			daoFactory = new DaoFactory();
	        dao = daoFactory.getRoomDao();
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
			room = dao.create(40, "Lviv");
	    } catch (Exception e) {
            throw new PersistException(e);
        }
	    
		Assert.assertNotNull(room);
	    Assert.assertNotNull(room.getId());
	}

	
	@Test
	public void testGetByPK() throws PersistException {
		 int id = dao.create(43, "Lviv").getId();
	     room = dao.getByPK(id);
	        Assert.assertNotNull(room);
	}

	@Test
	public void testGetAll() throws PersistException{
		
	    List<Room> list;
	    try {
	    	list = dao.getAll();
	    } catch (Exception e) {
            throw new PersistException(e);
        }
	    Assert.assertNotNull(list);
	    Assert.assertTrue(list.size() > 0);	
	}

	@Test
	public void testDelete() throws PersistException {
		try {
			TimeUnit time = daoFactory.getTimeUnitDao().getByPK(2);			
			Course course = daoFactory.getCourseDao().getByPK(3);
			Group group = daoFactory.getGroupDao().getByPK(3);			
			Professor prof = daoFactory.getProfessorDao().getByPK(3);
			
			room = dao.create(30, "Rivne");	    

			PostgreSqlScheduleSlotDao daoSS = daoFactory.getScheduleSlotDao();
			ScheduleSlot scheduleSlot = daoSS.create(time, room, course, prof, group);
			Assert.assertNotNull(scheduleSlot.getId());
			
	        List<Room> list = dao.getAll();
	        Assert.assertNotNull(list);

	        int oldSize = list.size();
	        Assert.assertTrue(oldSize > 0);

	        dao.delete(room);

	        list = dao.getAll();
	        Assert.assertNotNull(list);

	        int newSize = list.size();
	        Assert.assertEquals(1, oldSize - newSize);
	        
	        ScheduleSlot newSS = daoSS.getByPK(scheduleSlot.getId());
	        Assert.assertEquals(null, newSS.getRoom());	        
	        daoSS.delete(scheduleSlot);	        
	        
		} catch (Exception e) {
            throw new PersistException(e);
        }
	}

	@Test
	public void testUpdate() throws PersistException {
		Room r = new Room(4, 15, "Chernivtsi");
		try {
			dao.update(r);
	    } catch (Exception e) {
            throw new PersistException(e);
        }
	    
		Assert.assertTrue("not the same room", r.equals(dao.getByPK(r.getId())));
	}

}
