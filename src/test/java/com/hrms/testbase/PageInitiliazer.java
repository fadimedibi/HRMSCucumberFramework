package com.hrms.testbase;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LeaveListPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;
import com.hrms.pages.ReportsPageElements;

public class PageInitiliazer extends BaseClass {
	protected static LoginPageElements login;
	protected static DashboardPageElements dashboard;
	protected static AddEmployeePageElements addEmp;
	protected static PersonalDetailsPageElements pdetails;
	protected static ReportsPageElements report;
	protected static LeaveListPageElements leave;

	public static void initiliazeAllPage() {
		login = new LoginPageElements();
		dashboard = new DashboardPageElements();
		addEmp = new AddEmployeePageElements();
		pdetails = new PersonalDetailsPageElements();
		report = new ReportsPageElements();
		leave = new LeaveListPageElements();
	}
}
