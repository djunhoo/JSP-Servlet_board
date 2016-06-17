package student.service;

import java.util.List;
import student.model.Student;

public class StudentPage {
	private List<Student> content;
	private String subject;
	private int total;
	
	public StudentPage(int total, List<Student> content, String subject) {
		this.total = total;
		this.content = content;
		this.subject = subject;
	}
	
	public int getTotal() {
		return total;
	}
	
	public boolean hasNoStudent() {
		return total == 0;
	}
	
	public boolean hasStudents() {
		return total > 0;
	}
	
	public List<Student> getContent() {
		return content;
	}
	
	public String getSubject() {
		return subject;
	}
}
