package student.model;

public class Student {
   private Integer number;
   private String subject;
   private int student_number;
   private String department;
   private String name;
   private int attend;
   private int assignment;
   private int mid_term;
   private int final_term;
   private int total;
   private double average;
   private String grade;
   private int ranking;
   
   
   public Student(Integer number, String subject, int student_number,
         String department, String name, int attend, int assignment, int mid_term, int final_term,
         int total, double average, String grade, int ranking) {
      this.number = number;
      this.subject = subject;
      this.student_number = student_number;
      this.department = department;
      this.name = name;
      this.attend = attend;
      this.assignment = assignment;
      this.mid_term = mid_term;
      this.final_term = final_term;
      this.total = total;
      this.average = average;
      this.grade = grade;
      this.ranking = ranking;
   }
   
   public Student(Integer number, String subject, int student_number,
	         String department, String name, int attend, int assignment, int mid_term, int final_term,
	         int total, double average) {
	      this.number = number;
	      this.subject = subject;
	      this.student_number = student_number;
	      this.department = department;
	      this.name = name;
	      this.attend = attend;
	      this.assignment = assignment;
	      this.mid_term = mid_term;
	      this.final_term = final_term;
	      this.total = total;
	      this.average = average;
	   }
   
   public Integer getNumber() {
      return number;
   }
   
   public String getSubject() {
      return subject;
   }
   
   public int getStudent_number() {
      return student_number;
   }
   
   public String getDepartment() {
      return department;
   }
   
   public String getName() {
      return name;
   }
   
   public int getAttend() {
      return attend;
   }
   
   public int getAssignment() {
      return assignment;
   }
   
   public int getMidterm() {
      return mid_term;
   }
   
   public int getFinalterm() {
      return final_term;
   }
   
   public int getTotal() {
      return total;
   }
   
   public String getGrade() {
      return grade;
   }
   
   public double getAvg() {
      return average;
   }
   
   public int getRanking() {
      return ranking;
   }
}