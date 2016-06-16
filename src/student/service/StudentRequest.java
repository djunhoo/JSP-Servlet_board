package student.service;

import java.util.Map;

import student.model.Student;


public class StudentRequest {
   private Student student;
   
   public StudentRequest(Student student) {
      this.student = student;
   }
   
   public Student getStudent() {
      return student;
   }
   
   public void validate(Map<String, Boolean> errors) {
      if(student.getDepartment() == null || student.getDepartment().trim().isEmpty()) {
         errors.put("title", Boolean.TRUE);
      }
   }
}