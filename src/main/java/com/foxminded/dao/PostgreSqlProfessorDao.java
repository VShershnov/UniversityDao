package main.java.com.foxminded.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import main.java.com.foxminded.university.Group;
import main.java.com.foxminded.university.person.Professor;

public class PostgreSqlProfessorDao extends AbstractJDBCDao<Professor, Integer> {

	public PostgreSqlProfessorDao(DaoFactory daoFactory) {
		super(daoFactory);
	}

	@Override
	public String getSelectQuery() {
		return "SELECT id, name FROM \"Professors\"";
	}

	/**
	 * ¬озвращает sql запрос дл€ получени€ всех id св€занного обьекта из таблицы св€зей ForeignKey.
	 * <p/>
	 * SELECT dependentObj_id FROM [FK_Table] WHERE Instance_id = ?;
	 *  
	 */
	@Override
	public String getSelectDependentObjQuery(Class<?> K1, Class<?> T){
		return "SELECT " + K1.getSimpleName() + "_id FROM " + T.getSimpleName() + "s_" 
						+ K1.getSimpleName() + "s WHERE " + T.getSimpleName() + "_id = ?";
	}
	
	/**
	 * ¬озвращает sql запрос дл€ добавлени€ записи о id св€занного обьекта в таблицу св€зей ForeignKey.
	 * <p/>
	 * INSERT INTO PROFESSORS_COURSES (professor_id, course_id) VALUES (?, ?);
	 *  
	 */
	@Override
	public String getInsertDependentObjQuery(Class<?> K1, Class<?> T) {		
		return "INSERT INTO " + T.getSimpleName() + "s_" 
				+ K1.getSimpleName() + "s (" + K1.getSimpleName() + "_id, " + T.getSimpleName() + "_id) VALUES (?, ?);";
	}
	
	/**
	 * ¬озвращает sql запрос дл€ добавлени€ записи о id св€занного обьекта в таблицу св€зей ForeignKey.
	 * <p/>
	 * INSERT INTO PROFESSORS_COURSES (professor_id, course_id) VALUES (?, ?);
	 *  
	 */
	@Override
	public String getDeleteDependentObjQuery(Class<?> K1, Class<?> T) {		
		return "DELETE FROM " + T.getSimpleName() + "s_"  + K1.getSimpleName() + "s WHERE " 
				+ K1.getSimpleName() + "_id=? AND " + T.getSimpleName() + "_id=? ;";
	}
	
	@Override
	public String getCreateQuery() {
		return "INSERT INTO \"Professors\" (fuulname) \n" +
                "VALUES (?);";
	}

	@Override
	public String getUpdateQuery() {
		return "UPDATE \"Professors\" SET fuulname = ? WHERE id= ?;";
	}

	@Override
	public List<String> getDeleteQuery() {
		List<String> sql = new ArrayList<>();		
		sql.add("DELETE FROM Professors_Courses WHERE professor_id = ?;");
		sql.add("DELETE FROM \"Professors\" WHERE id= ?;");
		return sql;
	}

	public Professor create(String name) throws PersistException{
		Professor prof = new Professor(null, name);
        return persist(prof);
	}
	
	@Override
	protected List<Professor> parseResultSet(ResultSet rs)
			throws PersistException {
		List<Professor> result = new ArrayList<Professor>();
        try {
            while (rs.next()) {
            	Professor prof = new Professor();
            	prof.setId(rs.getInt("id"));
            	prof.setFullName(rs.getString("name"));               
                result.add(prof);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
	}

	@Override
	protected void prepareStatementForInsert(PreparedStatement statement,
			Professor object) throws PersistException {
		try {
            statement.setString(1, object.getFullName());
        } catch (Exception e) {
            throw new PersistException(e);
        }	
	}

	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement,
			Professor object) throws PersistException {
		try {
			statement.setString(1, object.getFullName());            
            statement.setInt(2, object.getId());
        } catch (Exception e) {
            throw new PersistException(e);
        }	
	}
}
