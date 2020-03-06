package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class JdbcDemo {

	// Create connection to db and retrieve all job titles and store them inside
	// arraylist

	String dbUsername = "syntax_hrm";

	String dbPassword = "syntaxhrm123";

	// jdbc:type driver:host:port/name of the database

	String dbUrl = "jdbc:mysql://3.90.45.91:3306/syntaxhrm_mysql";

	@Test
	public void getDataFromDataBAse() throws SQLException {

		Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

		System.out.println("Connection is created");

		Statement st = connection.createStatement();

		ResultSet rset = st.executeQuery("select * from ohrm_nationality");

		rset.next();
		String firstRowData = rset.getString("name");
		System.out.println(firstRowData);

		rset.next();
		String secondRowData = rset.getObject("name").toString();
		System.out.println(secondRowData);

		String data;
		while (rset.next()) {
			data = rset.getObject("name").toString();
			System.out.println(data);

			rset.close();
			st.close();
			connection.close();
		}

	}

}
