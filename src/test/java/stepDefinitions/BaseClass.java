package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObjects.AddNewCustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchCustomerPage;

public class BaseClass {
	
	public WebDriver driver;
	public LoginPage lp;
	public AddNewCustomerPage addCust;
	public SearchCustomerPage searchCustomer;
	public static Logger logger;
	public Properties prop;
	
	
	//this method is created for generating random string for unique email id (eg: xyz@gmail.com)

	public static String randomstring()
	{
		String generatedString1=RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}
	
	
}
