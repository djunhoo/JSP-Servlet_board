package student.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;



public class SelectHandler implements CommandHandler {
	
		private static final String FORM_VIEW = "/WEB-INF/view/select.jsp";
		
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
			return FORM_VIEW;
		}
		
		private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
			return FORM_VIEW;
		}
}
