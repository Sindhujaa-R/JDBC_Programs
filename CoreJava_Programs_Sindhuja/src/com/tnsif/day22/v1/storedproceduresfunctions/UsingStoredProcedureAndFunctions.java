//Program to demonstrate stored procedure and functions
package com.tnsif.day22.v1.storedproceduresfunctions;

import java.sql.SQLException;

public class UsingStoredProcedureAndFunctions {

	public static void main(String[] args) {
		try {
			//StoredProcedureFunctionService.deleteStudents();
			//StoredProcedureFunctionService.deleteStudentsByCity("coimbatore");
			
			String name=StoredProcedureFunctionService.getstudentName(3);
			System.out.println("Student name is "+name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
