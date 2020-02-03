package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class ReportsPageElements extends CommonMethods {

	@FindBy(id = "search_search")
	public WebElement reportName;

	@FindBy(className = "searchBtn")
	public WebElement searchBtn;
	
	@FindBy(className="_reset")
	public WebElement resetBtn;
	
	@FindBy(id="btnAdd")
	public WebElement addBtn;
	
	@FindBy(id="btnDelete")
	public WebElement deleteBtn;
	

	@FindBy(xpath = "//table[@id='resultTable']/tbody/tr/td")
	public WebElement noRecordMsg;
	
	
	@FindBy(xpath = "//table[@id='resultTable']/tbody/tr/td[2]")
	public WebElement SampleReportMsg;
	
	public ReportsPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
