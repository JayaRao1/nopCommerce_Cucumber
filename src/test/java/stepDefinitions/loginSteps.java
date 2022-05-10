package stepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import PageObjects.AddNewCustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchCustomerPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class loginSteps extends BaseClass
{
	//	method to seperate all configurations

	@Before
	public void setup() throws IOException
	{   

		//Added Logger and property with project name and path of log4j 
		logger=Logger.getLogger("nopCommerce");
		PropertyConfigurator.configure("log4j.properties");


		//reading properties
		prop=new Properties();
		FileInputStream file=new FileInputStream("config.properties");
		prop.load(file);

		String br=prop.getProperty("browser");

		if(br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		

		logger.info("*********Launching Browser***********");

	}


	@Given("User launch Chrome Browser")
	public void user_lavunch_chrome_browser() 
	{

		lp=new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) 
	{logger.info("*********opening URL***********");
	driver.get(url);
	}

	@And("user enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String pwd) 
	{
		logger.info("*********Entering username and password***********");
		lp.setUserName(email);
		lp.setPassword(pwd);
	}

	@And("clicks on login")
	public void clicks_on_login() throws InterruptedException 
	{
		logger.info("*********clicking on login button***********");
		lp.clickOnLogIn();
		Thread.sleep(2000);
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be1(String title) throws InterruptedException 
	{
		if(driver.getPageSource().contains("Login was unsucessful."))
		{
			driver.close();
			logger.info("*********login Passed***********");
			Assert.assertTrue(false);	
		}
		else 
		{
			logger.info("*********login failed***********");

			Assert.assertEquals(title, driver.getTitle());

		}	Thread.sleep(2000);
	}
	@When("clicks in logout")
	public void clicks_in_logout() throws InterruptedException {
		logger.info("*********clicks on log0ut**********");
		lp.clickOnLogOut();
		Thread.sleep(2000);

	}
	
	@And("close Browser")
	public void close_browser() 
	{
		logger.info("*********closing browser**********");
		driver.quit();
	}


	//Add New Customer Details

	@Then("user can view Dashboard")
	public void user_can_view_dashboard() {

		addCust=new AddNewCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());

	}

	@When("user clicks on Customer Menu")
	public void user_clicks_on_customer_menu() throws InterruptedException {
		Thread.sleep(2000);
		addCust.clickOnCustomerMenu();
	}

	@When("clicks on Customer Menu Item")
	public void clicks_on_customer_menu_item() throws InterruptedException {
		Thread.sleep(2000);
		addCust.clickOnCustomerMenuItem();
	}

	//		@And("clear customer roles")
	//		public void clear_customer_roles() 
	//		{
	//		   addCust.clearCustomerRole();
	//		}



	@And("click on Add New Button")
	public void click_on_add_new_button() throws InterruptedException {
		addCust.clickAddBtn();
		Thread.sleep(2000);
	}

	@Then("user can view add new customer page")
	public void user_can_view_add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	}

	@When("user enters customer Info")
	public void user_enters_customer_info() throws InterruptedException 
	{
		//this method is created for generating random string for unique email id
		String email=randomstring()+"@gmail.com";
		addCust.enterEmaiID(email);

		addCust.enterPassword("test123");
		addCust.enterFirstName("Jaya");
		addCust.enterLastName("Bharathi");
		addCust.setGender("Female");
		Thread.sleep(2000);
		addCust.enterDateOfBirth("8/10/1989");

		addCust.enterCompanyName("busyQA");


		addCust.selectCustomerRole("Guest");
		Thread.sleep(2000);
		addCust.selectManagerOfVendor("Vendor 1");
		addCust.enterAdminContent("This is for testing.....");
	}

	@And("clicks on save button")
	public void clicks_on_save_button() throws InterruptedException {
		addCust.clickOnSaveBtn();
		Thread.sleep(2000);
	}

	@Then("uer can view confirmation message {string}")
	public void uer_can_view_confirmation_message(String confirmationMeassage) 
	{
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added sucessfully"));
	}

	//	@When("clicks in logout")
	//	public void clicks_in_logout() throws InterruptedException 
	//	{
	//		lp.clickOnLogOut();
	//		Thread.sleep(2000);
	//	}



	//steps to search customer by using email id
	@And("Entes customer EmailId")
	public void entes_customer_email_id() 
	{
		searchCustomer=new SearchCustomerPage(driver);
		searchCustomer.enterEmaidToSearch("victoria_victoria@nopCommerce.com");
	}

	@When("Clicks on search button")
	public void clicks_on_search_button() throws InterruptedException 
	{
		searchCustomer.clickOnSearch();
		Thread.sleep(2000);
	}

	@Then("user should found particular email id details in the search table")
	public void user_should_found_particular_email_id_details_in_the_search_table() throws InterruptedException 
	{
		boolean status=searchCustomer.enterEmaidToSearch("victoria_victoria@nopCommerce.com");

		Assert.assertEquals(true, status);
		Thread.sleep(3000);
	}

	//Steps for searing customer by using firstname and lastname


	@When("Enter customer FirstName")
	public void enter_customer_first_name() 
	{
		//new scenario so need to initialise obj again
		searchCustomer=new SearchCustomerPage(driver);

		searchCustomer.enterfirstNameToSearch("Victoria");
	}

	@When("Enter customer LastName")
	public void enter_customer_last_name() 
	{
		searchCustomer.enterLastNameToSearch("Terces");
	}

	@Then("user should found Name in the search table")
	public void user_should_found_name_in_the_search_table() throws InterruptedException 
	{
		searchCustomer.searchCustomerByName("VictoriaTerces");
		
		Thread.sleep(2000);
	}

}

