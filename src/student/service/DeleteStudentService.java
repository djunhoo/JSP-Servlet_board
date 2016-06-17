package student.service;

import java.sql.Connection;
import java.sql.SQLException;
import article.service.PermissionDeniedException;
import student.dao.StudentDao;
import student.model.Student;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class DeleteStudentService {
	private StudentDao studentDao = new StudentDao();
	
	public void delete(StudentDeleteRequest delReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Student student = studentDao.selectById(conn, delReq.getStudentNumber());
			if(student == null) {
				throw new StudentNotFoundException();
			}
			studentDao.delete(conn, delReq.getStudentNumber());
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);;
			throw new RuntimeException(e);
		} catch(PermissionDeniedException e) {
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
