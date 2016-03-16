package org.oecm4.postApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResgisterServ extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		String eid=req.getParameter("id");
		int id=Integer.parseInt(eid);
		String name=req.getParameter("nm");
		String dept=req.getParameter("dp");
		String salary=req.getParameter("sal");
		double actsal=Double.parseDouble(salary);
		PrintWriter out=resp.getWriter();
		out.println("<html><body bgcolor='green'>"
				+ "<h1> welcome"+name+"</h1>"
						+ "</body></html>");
		out.flush();
		out.close();
		
		
	}

}
