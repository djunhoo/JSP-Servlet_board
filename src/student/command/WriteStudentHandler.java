package student.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.model.Student;
import student.service.WriteStudentService;
import student.service.StudentRequest;
import mvc.command.CommandHandler;

public class WriteStudentHandler implements CommandHandler  {
	private static final String FORM_VIEW = "/WEB-INF/view/newStudentForm.jsp";
	private WriteStudentService studentService = new WriteStudentService();
	
	public String process(HttpServletRequest req, HttpServletResponse res) {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		StudentRequest studentReq = createStudentRequest(req);
		studentReq.validate(errors);
		
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		int newStudentNo = studentService.write(studentReq);	
		req.setAttribute("newStudentNo", newStudentNo);
		
		return "/WEB-INF/view/newStudentSuccess.jsp";
	
	}
	
	private StudentRequest createStudentRequest(HttpServletRequest req) {
		int attend = Integer.parseInt(req.getParameter("attend"));
		int assignment = Integer.parseInt(req.getParameter("assignment"));
		int midTerm = Integer.parseInt(req.getParameter("mid_term"));
		int finalTerm = Integer.parseInt(req.getParameter("final_term"));
		int total = attend + assignment + midTerm + finalTerm;
		double avg = total / 4.0;
		return new StudentRequest(new Student(null, req.getParameter("subject"),
				Integer.parseInt(req.getParameter("student_number")),
				req.getParameter("department"),
				req.getParameter("name"),
				attend,
				assignment,
				midTerm,
				finalTerm,
				total, 
				avg,
				"0",
				0));
	}

}
