package student.service;

import java.sql.Connection;
import java.sql.SQLException;

import student.dao.StudentDao;
import student.model.Student;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;


public class WriteStudentService {
   private StudentDao studentDao = new StudentDao();
   
   public Integer write(StudentRequest req) {
      Connection conn = null;
      try {
         conn = ConnectionProvider.getConnection();
         conn.setAutoCommit(false);
         
         Student student = toStudent(req);
         Student savedStudent = studentDao.insert(conn, student);
         if(savedStudent == null ){
            throw new RuntimeException("fail to insert student");
         }
         
         conn.commit();
         
         return savedStudent.getNumber();
      } catch(SQLException e) {
         JdbcUtil.rollback(conn);
         throw new RuntimeException(e);
      } catch(RuntimeException e) {
         JdbcUtil.rollback(conn);
         throw e;
      } finally {
         JdbcUtil.close(conn);
      }
   }
   
   private Student toStudent(StudentRequest req) {
      return new Student(null, req.getStudent().getSubject(),
    		  req.getStudent().getStudent_number(),
    		  req.getStudent().getDepartment(),
    		  req.getStudent().getName(),
    		  req.getStudent().getAttend(),
    		  req.getStudent().getAssignment(),
    		  req.getStudent().getMidterm(),
    		  req.getStudent().getFinalterm(),
    		  req.getStudent().getTotal(),
    		  req.getStudent().getAvg(),
    		  req.getStudent().getGrade(),
    		  req.getStudent().getRanking());
   }
}