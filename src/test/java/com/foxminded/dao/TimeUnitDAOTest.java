package test.java.com.foxminded.dao;

import java.util.List;

import main.java.com.foxminded.dao.DaoFactory;
import main.java.com.foxminded.dao.PersistException;
import main.java.com.foxminded.dao.PostgreSqlRoomDao;
import main.java.com.foxminded.dao.PostgreSqlTimeUnitDao;
import main.java.com.foxminded.schedule.TimeUnit;
import main.java.com.foxminded.university.Room;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TimeUnitDAOTest {
	
	private DaoFactory daoFactory;
	
	private PostgreSqlTimeUnitDao dao;
	
	private TimeUnit timeUnit;
	
	@Before
	public void setUpBefore() throws PersistException{
		try {   
			daoFactory = new DaoFactory();
	        dao = daoFactory.getTimeUnitDao();
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
			timeUnit = dao.create(9, 18, 10);
			
			Assert.assertNotNull(timeUnit);
		    Assert.assertNotNull(timeUnit.getId());
	    } catch (Exception e) {
            throw new PersistException(e);
        }		
	}

	
	@Test
	public void testGetByPK() throws PersistException {
		 int id = dao.create(10, 18, 10).getId();
		 timeUnit = dao.getByPK(id);
	        Assert.assertNotNull(timeUnit);
	}

	@Test
	public void testGetAll() throws PersistException{
		
	    List<TimeUnit> list;
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
			timeUnit = dao.create(11, 18, 10);	    

	        List<TimeUnit> list = dao.getAll();
	        Assert.assertNotNull(list);

	        int oldSize = list.size();
	        Assert.assertTrue(oldSize > 0);

	        dao.delete(timeUnit);

	        list = dao.getAll();
	        Assert.assertNotNull(list);

	        int newSize = list.size();
	        Assert.assertEquals(1, oldSize - newSize);
	        
		} catch (Exception e) {
            throw new PersistException(e);
        }
	}

	@Test
	public void testUpdate() throws PersistException {
		TimeUnit tu = new TimeUnit(4, 12, 5, 10);
		try {
			dao.update(tu);
			
			Assert.assertTrue("not the same timeUnit", tu.equals(dao.getByPK(tu.getId())));
	    } catch (Exception e) {
            throw new PersistException(e);
        }		
	}
}
