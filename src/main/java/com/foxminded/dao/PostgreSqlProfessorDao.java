package main.java.com.foxminded.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import main.java.com.foxminded.university.person.Professor;

public class PostgreSqlProfessorDao extends AbstractJDBCDao<Professor, Integer> {

	public PostgreSqlProfessorDao(DaoFactory daoFactory) {
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

	@Override
	protected List<Professor> parseResultSet(ResultSet rs)
			throws PersistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void prepareStatementForInsert(PreparedStatement statement,
			Professor object) throws PersistException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement,
			Professor object) throws PersistException {
		// TODO Auto-generated method stub
		
	}

}
