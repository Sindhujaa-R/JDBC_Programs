//Program to demonstrate PreparedStatement Interface
package com.tnsif.day23.client;

import com.tnsif.day23.service.PreparedStatementDemo;

public class Executor {

	public static void main(String[] args) {
		PreparedStatementDemo.showEmp();
		
		  PreparedStatementDemo.updateEmpName(3, "kalai");
		  PreparedStatementDemo.updateEmpSalary(3,150000);
		  PreparedStatementDemo.showEmp(); if(!PreparedStatementDemo.deleteEmp(4));
		  System.err.println("No such employee...");
		  PreparedStatementDemo.showEmp();
		
	}

}
