package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class DisplayConfig extends GenericServlet {

	
	public int count; //for servletConfig
	public ServletContext ctx=null; //for servletContext
	
	public void init(ServletConfig sc) {
		count=Integer.parseInt(sc.getInitParameter("count"));//for servletConfig
		ctx=sc.getServletContext(); //for servletContex
	}
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("Value of count is: "+count);
		
		int countVar = Integer.parseInt(ctx.getInitParameter("count"));
		out.println("<br> Context value is: "+countVar);
		out.close();
		
	}
}
