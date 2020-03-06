package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Task {
String dbUsername="syntax_hrm";
	
	String dbPassword="syntaxhrm123";
	
	//jdbc:type driver:host:port/name of the database
	
	String dbUrl="jdbc:mysql://3.90.45.91:3306/syntaxhrm_mysql";
	
	
	@Test
	public void getDataFromDataBAse() throws SQLException {

	
		Connection connection2=DriverManager.getConnection(dbUrl, dbUsername,dbPassword);
		
		System.out.println("Connection1 created");
		
		Statement st2=connection2.createStatement();
		ResultSet rset2= st2.executeQuery("select * from ohrm_job_title");

		String data2;
		List<String> list=new ArrayList<>();
		while (rset2.next()) {
			data2=rset2.getString("job_title");
			list.add(data2);
		
		}
		
		
		for (String data : list) {
			System.out.println(data);
		}
		rset2.close();
		st2.close();
		connection2.close();
		
	
	
	
	
	
	}

}