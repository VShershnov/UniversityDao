package main.java.com.foxminded.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.foxminded.schedule.ScheduleSlot;

public class PostgreSqlScheduleSlotDao extends
		AbstractJDBCDao<ScheduleSlot, Integer> {
	
	private final  Logger log = LogManager.getLogger(this.getClass().getPackage().getName());

	public PostgreSqlScheduleSlotDao(DaoFactory daoFactory) {
		super(daoFactory);		
	}

	@Override
	public String getSelectQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCreateQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUpdateQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getDeleteQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	public ScheduleSlot create() throws PersistException {
		ScheduleSlot ss = new ScheduleSlot();
        return persist(ss);
	}
	
	@Override
	protected List<ScheduleSlot> parseResultSet(ResultSet rs)
			throws PersistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void prepareStatementForInsert(PreparedStatement statement,
			ScheduleSlot object) throws PersistException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement,
			ScheduleSlot object) throws PersistException {
		// TODO Auto-generated method stub

	}

}
