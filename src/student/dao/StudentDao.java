package student.dao;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import student.model.Student;
import jdbc.JdbcUtil;

public class StudentDao {
	public Student insert(Connection conn, Student student) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("insert into student "
					+ "(subject, student_number, department, name, attend, assignment, mid_term, final_term, total, average, grade, ranking)"
					+ "values (?,?,?,?,?,?,?,?,?,?,?,0)");
			pstmt.setString(1, student.getSubject());
			pstmt.setInt(2, student.getStudent_number());
			pstmt.setString(3, student.getDepartment());
			pstmt.setString(4, student.getName());
			pstmt.setInt(5, student.getAttend());
			pstmt.setInt(6, student.getAssignment());
			pstmt.setInt(7, student.getMidterm());
			pstmt.setInt(8, student.getFinalterm());
			pstmt.setInt(9, student.getTotal());
			pstmt.setDouble(10, student.getAverage());
			pstmt.setString(11, student.getGrade());
			//pstmt.setInt(12, 0);
			int insertedCount = pstmt.executeUpdate();

			if (insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select last_insert_id() from student");
				if (rs.next()) {
					Integer newNum = rs.getInt(1);
					return new Student(newNum, student.getSubject(), student.getStudent_number(),
							student.getDepartment(), student.getName(), student.getAttend(), student.getAssignment(),
							student.getMidterm(), student.getFinalterm(), student.getTotal(), student.getAverage(),
							student.getGrade(), 0);
				}
			}
			return null;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);

		}
	}
	
	public int selectCount(Connection conn, String subject) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select count(*) from student where subject = " +
								'?');
			pstmt.setString(1, subject);
			rs = pstmt.executeQuery(); //where subject = " + subject);
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public List<Student> select(Connection conn, String subject) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from student where subject = " +
											'?');// where subject = ?");
			pstmt.setString(1, subject);
			rs = pstmt.executeQuery();
			List<Student> result = new ArrayList<>();
			while(rs.next()) {
				result.add(convertStudent(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	private Student convertStudent(ResultSet rs) throws SQLException {
		return new Student(rs.getInt("student_no"),
							rs.getString("subject"),
							rs.getInt("student_number"),
							rs.getString("department"),
							rs.getString("name"),
							rs.getInt("attend"),
							rs.getInt("assignment"),
							rs.getInt("mid_term"),
							rs.getInt("final_term"),
							rs.getInt("total"),
							rs.getDouble("average"),
							"0",
							0);
	}
	
	public void delete(Connection conn, int no) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement(
						"delete from student where student_no = ?")){
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		}
	}
	
	public int updateGrade(Connection conn, int no, String grade, int ranking) throws SQLException {
		try(PreparedStatement pstmt = conn.prepareStatement("update student set grade = ?, ranking = ?" + 
															"where student_no = ?")) {
			pstmt.setString(1, grade);
			pstmt.setInt(2, ranking);
			pstmt.setInt(3, no);
			return pstmt.executeUpdate();
		}
	}
	
	public Student selectById(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("select * from student where student_no = ?");
			pstmt.setInt(1,  no);
			rs = pstmt.executeQuery();
			Student student = null;
			if(rs.next())
			{
				student = convertStudent(rs);
			}
			return student;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
}