package student.service;

public class StudentDeleteRequest {
	private int studentNumber;
	
	
	public StudentDeleteRequest(int studentNumber) {
		this.studentNumber = studentNumber;
	}
	
	public int getStudentNumber() {
		return studentNumber;
	}
}
