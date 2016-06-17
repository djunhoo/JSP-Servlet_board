package student.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.service.StudentNotFoundException;
import student.service.DeleteStudentService;
import student.service.StudentDeleteRequest;
import article.service.PermissionDeniedException;


import mvc.command.CommandHandler;

public class DeleteStudentHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/";
	
	private DeleteStudentService deleteService = new DeleteStudentService();
	
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processSubmit(req, res);
		} else if( req.getMethod().equalsIgnoreCase("POST")) {
			return processForm(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	private String processForm(HttpServletRequest req, HttpServletResponse res) throws IOException {
		return null;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String noVal = req.getParameter("no");
		
		int no = Integer.parseInt(noVal);
		
		StudentDeleteRequest delReq = new StudentDeleteRequest(no);
		req.setAttribute("delReq", delReq);
		
		try {
			deleteService.delete(delReq);
			return "/WEB-INF/view/deleteStudentSuccess.jsp";
		} catch (StudentNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		} catch(PermissionDeniedException e) {
			res.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
	}
}
