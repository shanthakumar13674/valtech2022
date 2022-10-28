package com.valtech.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FirstServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer count = (Integer)session.getAttribute("count");
		if(count == null)	{
			session.setAttribute("count",1 );
			count = 1;
		}else	{
			session.setAttribute("count", count+1);
		}
		ServletContext ctx = session.getServletContext();
		Integer globalCount = (Integer)ctx.getAttribute("count");
		if(globalCount == null)	{
			ctx.setAttribute("count",1);
			globalCount =1;
		}else	{
			ctx.setAttribute("count", globalCount+1);
		}
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.print("<head>");
		out.print("<title>");
		out.print("Counter with Http Session");
		out.print("</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h2>");
		out.print("First Servlet<br/>");
		
		out.print(request.getAttribute("info")+"<br/>");
		
		out.print("You have visited  this page "+count+" Times<br/>");
		out.print("This site was visited "+globalCount+"Times");
		out.print("</h2>");
		out.print("</body>");
		out.print("</html>");
	}


}







