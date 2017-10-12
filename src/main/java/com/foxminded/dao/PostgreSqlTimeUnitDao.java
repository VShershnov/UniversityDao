package main.java.com.foxminded.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.foxminded.schedule.TimeUnit;

public class PostgreSqlTimeUnitDao extends AbstractJDBCDao<TimeUnit, Integer> {
	
	private final  Logger log = LogManager.getLogger(this.getClass().getPackage().getName());

	public PostgreSqlTimeUnitDao(DaoFactory daoFactory) {
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

	public TimeUnit create() throws PersistException {
		TimeUnit tu = new TimeUnit();
        return persist(tu);
	}
	
	@Override
	protected List<TimeUnit> parseResultSet(ResultSet rs) throws PersistException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected void prepareStatementForInsert(PreparedStatement statement,
			TimeUnit object) throws PersistException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement,
			TimeUnit object) throws PersistException {
		// TODO Auto-generated method stub
		
	}

}
