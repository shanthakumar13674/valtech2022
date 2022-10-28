package valtechWeb3;

import java.io.IOException;
import java.util.List;

import com.valtech.dao.Employee;
import com.valtech.dao.EmployeeDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/empCtlr" })
public class EmployeeControllerServlet extends HttpServlet {

	private EmployeeDAO dao;

	@Override
	public void init() throws ServletException {
		dao = new EmployeeDAO();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String submit = req.getParameter("submit");
		try {
			if("New Employee".equals(submit))	{
				req.getRequestDispatcher("createEmp.jsp").forward(req, resp);
				return;
			}
			if ("Save".equals(submit)) {
				Employee e= new Employee();
				e.setId(dao.getNextValidId());
				e.setName(req.getParameter("name"));
				e.setAge(Integer.parseInt(req.getParameter("age")));
				e.setGender(Integer.parseInt(req.getParameter("gender")));
				e.setSalary(Float.parseFloat(req.getParameter("salary")));
				dao.saveEmployee(e);
			} 
			loadEmpsAndGotoEmpsPage(req, resp);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	private void loadEmpsAndGotoEmpsPage(HttpServletRequest req, HttpServletResponse resp)
			throws Exception, ServletException, IOException {
		List<Employee> employees = dao.getEmployees();
		req.setAttribute("emps", employees);
		req.getRequestDispatcher("emps.jsp").forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// login here and fwd to jsp page
		try {
			String empId = req.getParameter("empId");
			String submit = req.getParameter("submit");
			if (empId == null) {
				loadEmpsAndGotoEmpsPage(req, resp);
				return;
			}
			int id = Integer.parseInt(req.getParameter("empId"));
			if("delete".equals(submit))	{
				dao.deleteEmployee(id);
				loadEmpsAndGotoEmpsPage(req, resp);
				return;
			}
			Employee e = dao.getEmployee(id);
			req.setAttribute("e", e);
			req.getRequestDispatcher("emp.jsp").forward(req, resp);
			;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

}
