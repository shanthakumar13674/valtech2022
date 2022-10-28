package com.valtech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

	static {
		try {
//		Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static final String TABLE_NAME = "employee";
	
	public int getNextId(int currId)throws Exception	{
		int id = -1;
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement
				("select id from "+TABLE_NAME+" where id > ? limit 1"); // mysql
//				("select id from "+TABLE_NAME+" where id > ? fetch next 1 row only");
		ps.setInt(1, currId);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) id = rs.getInt(1);
		con.close();
		return id;
	}
	
	public int getPreviousId(int currId)throws Exception	{
		int id = -1;
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement
				("select max(id) from "+TABLE_NAME+" where id < ? limit 1"); // mysql
//		("select id from "+TABLE_NAME+" where id < ? fetch next 1 row only");
		ps.setInt(1, currId);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) id = rs.getInt(1);
		con.close();
		return id;
	}
	
	public void deleteEmployee(int id)throws Exception	{
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement
				("delete from "+TABLE_NAME+" where id = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		con.close();
	}
	
	public List<Employee> getEmployees()throws Exception	{
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement
				("select id,name,age,gender,salary from "+TABLE_NAME);
		ResultSet rs = ps.executeQuery();
		List<Employee> employees = new ArrayList<>();
		while(rs.next()) {
			employees.add(employeeFromResultSet(rs));
		}
		con.close();
		return employees;
		
	}

	public Employee getEmployee(int id) throws Exception {
		Connection conn = getConnection();
		PreparedStatement ps = conn
				.prepareStatement("SELECT id,name,age,gender,salary from " 
						+ TABLE_NAME + " where id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Employee e = employeeFromResultSet(rs);
			conn.close();
			return e;
		}	else	{
			return null;
		}
	}

	private Employee employeeFromResultSet(ResultSet rs) throws SQLException {
		Employee e = new Employee();
		e.setId(rs.getInt(1));
		e.setName(rs.getString(2));
		e.setAge(rs.getInt(3));
		e.setGender(rs.getInt(4));
		e.setSalary(rs.getFloat(5));
		return e;
	}

	public void saveEmployee(Employee e) throws Exception {
		Connection con = getConnection();
		PreparedStatement ps = con
				.prepareStatement("insert into " + TABLE_NAME + " (id,name,age,gender,salary) values (?,?,?,?,?)");

		ps.setInt(1, e.getId());
		ps.setString(2, e.getName());
		ps.setInt(3, e.getAge());
		ps.setInt(4, e.getGender());
		ps.setDouble(5, e.getSalary());

		int rowsAffected = ps.executeUpdate();
		con.close();
	}

	public int count() throws Exception {
		Connection con = getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("Select count(id) from " + TABLE_NAME);
		if (rs.next()) {
			int count = rs.getInt(1);
			con.close();
			return count;
		} else {
			con.close();
			return -1;
		}
	}

	public Connection getConnection() throws Exception {
		return DriverManager.getConnection
//				("jdbc:oracle:thin:@localhost:1521/xe","username","password");
		("jdbc:mysql://localhost:3306/valtech", "root", "tiger123");
	}

}
