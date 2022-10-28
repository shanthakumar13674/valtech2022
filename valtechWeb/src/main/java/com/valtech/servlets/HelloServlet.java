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
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HelloServlet() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	System.out.println(getInitParameter("driverClassName"));
    	System.out.println(getInitParameter("dbUrl"));
    	System.out.println(getInitParameter("dbUsername"));
    	System.out.println(getInitParameter("dbPassword"));
    	System.out.println("Init method of Hello Servlet");
    }
    
    @Override
    public void destroy() {
    	System.out.println("Destroy Method of Hello Servlet");
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
		out.print("Hello with Http Session");
		out.print("</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h2>");
		out.print("Hello "+count+" Times<br/>");
		out.print("Hello Global Count "+globalCount+"Times");
		out.print("</h2>");
		out.print("</body>");
		out.print("</html>");
//		out.flush();
		request.setAttribute("info", "This works only for Forward!");
		response.sendRedirect("first");
//		request.getRequestDispatcher("/first").forward(request, response);
	}

	

}





