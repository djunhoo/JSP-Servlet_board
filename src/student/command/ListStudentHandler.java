package student.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.service.StudentPage;
import student.service.ListStudentService;

import mvc.command.CommandHandler;


public class ListStudentHandler implements CommandHandler {
	private ListStudentService listService = new ListStudentService();
	
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String subject = req.getParameter("subject");
		
		StudentPage studentPage = listService.getStudentPage(subject);
		req.setAttribute("studentPage", studentPage);
		return "/WEB-INF/view/listStudent.jsp";
	}
}
