package PageObjects;


import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage 
{
	public WebDriver ldriver;

	WaitHelper waithelper;

	public SearchCustomerPage(WebDriver rdriver)   //Constructor page factory
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		waithelper=new WaitHelper(ldriver);
	}

	@FindBy(id="SearchEmail")
	WebElement searchByEmail;

	@FindBy(id="SearchLastName")
	WebElement searchByLName;

	@FindBy(id="SearchFirstName")
	WebElement searchByFName;

	//	@FindBy(id="SearchMonthOfBirth")
	//	WebElement searchByMonthOfBirth;
	//
	//	@FindBy(id="SearchDayOfBirth")
	//	WebElement searchByDayOfBirth;
	//
	//
	//	@FindBy(id="SearchIpAddress")
	//	WebElement searchIpAddress;
	//
	//	@FindBy(id="SearchCompany")
	//	WebElement searchByCompany;
	//
	//
	//	@FindBy(xpath="//div[@class='k-multiselect-wrap k-floatwrap']")
	//	WebElement searchByCustomerRole;
	//
	//
	//	@FindBy(xpath="//li[contains(text(),'Administrators')]")
	//	WebElement searchByCustomerRoleAsAdmin;
	//
	//	@FindBy(xpath="//li[contains(text(),'Forum Moderators')]")
	//	WebElement searchByCustomerRoleAsModerators;
	//
	//	@FindBy(xpath="//li[contains(text(),'Registered')]")
	//	WebElement searchByCustomerRoleAsRegistered;
	//
	//	@FindBy(xpath="//li[contains(text(),'Guests')]")
	//	WebElement searchByCustomerRoleAsGuests;
	//
	//	@FindBy(xpath="//li[contains(text(),'Vendors')]")
	//	WebElement searchByCustomerRoleAsVendors;

	@FindBy(id="search-customers")
	WebElement clickOnSearch;


	@FindBy(xpath="//table[@role='grid']")
	WebElement table;

	@FindBy(xpath="//table[@id='customers-grid']/tbody/tr")
	List<WebElement> tableRows;

	@FindBy(xpath="//table[@id='customers-grid']/tbody/tr/td")
	List<WebElement> tableColumns;


	public boolean enterEmaidToSearch(String email)
	{
		waithelper.ExplicitWaitForElement(searchByEmail, 30);
		searchByEmail.clear();
		searchByEmail.sendKeys(email);
		return true;

	}
	public void enterfirstNameToSearch(String fName)
	{
		waithelper.ExplicitWaitForElement(searchByFName, 30);
		searchByFName.clear();
		searchByFName.sendKeys(fName);
	}
	public void enterLastNameToSearch(String LName)
	{
		waithelper.ExplicitWaitForElement(searchByLName, 30);
		searchByLName.clear();
		searchByLName.sendKeys(LName);
	}

	public void clickOnSearch() 
	{
		clickOnSearch.click();
		waithelper.ExplicitWaitForElement(clickOnSearch, 30);
	}

	public int getNoofRows() 
	{
		return tableRows.size();
	}

	public int getNoofCols() 
	{
		return tableColumns.size();

	}
	//search customer by email in row +i+, col [2]
	public boolean searchCustomerByEmail(String email)
	{
		boolean flage=false;
		for(int i=1; i<=getNoofRows();i++)
		{
			String emailid=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(emailid);
			if(emailid.equals("victoria_victoria@nopCommerce.com"));
			{
				flage=true;
			}
		}
		return flage;
	}


	//search customer by name	
	public boolean searchCustomerByName(String Name)
	{
		boolean flage=false;
		for(int i=1; i<=getNoofRows();i++)
		{
			String name=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
			System.out.println(name);
			//separate 1st name and last name by split()
			String names[]=name.split("");
			if(names[0].equals("Victoria") && names[1].equals("Terces"))
			{
				flage=true;
			}
		}
		return flage;
	}
}









