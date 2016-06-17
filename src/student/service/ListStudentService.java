package student.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import student.dao.StudentDao;
import student.model.Student;
import jdbc.connection.ConnectionProvider;

public class ListStudentService {
	private StudentDao studentDao = new StudentDao();
	
	public StudentPage getStudentPage(String subject) {
		try(Connection conn = ConnectionProvider.getConnection()) {
			int total = studentDao.selectCount(conn, subject);
			List<Student> content = studentDao.select(conn, subject);
			return new StudentPage(total, content, subject);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
