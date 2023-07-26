package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class DisContext extends GenericServlet {

	public ServletContext ctx=null;
	
	public void init(ServletConfig sc) {
		ctx=sc.getServletContext(); //getting reference of servlet context from web.xml
	}
	
	
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		int countVar = Integer.parseInt(ctx.getInitParameter("contextVar"));
		out.println("<br> Context value is: "+countVar);
	}

}
