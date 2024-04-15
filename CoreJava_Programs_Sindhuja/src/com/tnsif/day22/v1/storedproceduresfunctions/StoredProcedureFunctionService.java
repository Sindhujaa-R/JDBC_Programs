//Program to define student service class using stored procedure and functions
package com.tnsif.day22.v1.storedproceduresfunctions;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import com.tnsif.day22.v1.usingpreparedstatement.DBUtil;



public class StoredProcedureFunctionService {
	static Connection con;
	static Statement st;
	static PreparedStatement pst;
	static CallableStatement cst;
	static 
	{
		con=DBUtil.getCn();
		try {
			st=con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deleteStudents() throws SQLException
	{
		boolean result=st.execute("call deleteStudent()");
		if (!result) // result==false
		{
			System.out.println(st.getUpdateCount()+" record(s) Deleted");
		}		
	}
	
	public static void deleteStudentsByCity(String city) throws SQLException
	{
		//boolean result=st.execute("call deleteStudentBycity('"+city+"')"); //static query
		pst=con.prepareStatement("call deleteStudentBycity(?)"); //dynamic query
		pst.setString(1, city);
		boolean result=pst.execute();
		if (!result) // result==false
		{
			System.out.println(pst.getUpdateCount()+" record(s) Deleted");
		}		
	}
	
	public static String getstudentName(int id) throws SQLException
	{
		cst = con.prepareCall("{CALL getStudentNameById(?, ?)}");
		cst.setInt(1, id);
		cst.registerOutParameter(2, Types.VARCHAR);
		cst.execute();
		String name=cst.getString(2);
		return name;
	}
	
}
