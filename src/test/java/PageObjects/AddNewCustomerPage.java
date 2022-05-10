package PageObjects;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage 
{
	public WebDriver ldriver;


	public AddNewCustomerPage(WebDriver rdriver)   //Constructor page factory
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}


	By lnkCustomer_menu=By.xpath("//a[@href=\"#\"]//i[@class=\"nav-icon far fa-user\"]");
	By lnkCustomers_menuItem=By.xpath("//a[@href=\"/Admin/Customer/List\"]//i[@class=\"nav-icon far fa-dot-circle\"]");
//	By clearCustomerRole=By.xpath("//div[@class=\"k-multiselect-wrap k-floatwrap\"]");
	By AddNew=By.xpath("//a[@class=\"btn btn-primary\"]");
	By txtEmail=By.id("Email");
	By txtPassword=By.id("Password");


	By rdMaleGender=By.id("Gender_Male");
	By rdFemaileGender=By.id("Gender_Female");

	By txtDob=By.id("DateOfBirth");

	By txtCompanyName= By.id("Company");
	//	By newsLetter= By.xpath("//div[@class=\"k-widget k-multiselect k-multiselect-clearable\"]");


	By txtCustomerRoles= By.xpath("//div[@class=\"input-group-append input-group-required\"]");
	By listItemAdministrators=By.xpath("//li[contains(text(),'Administrators')]");
	By listItemFourmModerator=By.xpath("//li[contains(text(),'Forum Moderators')]");
	By listItemRegistered=By.xpath("//li[contains(text(),'Registered')]");
	By listItemGuests=By.xpath("//li[contains(text(),'Guests')]");
	By listItemVendors=By.xpath("//li[contains(text(),'Vendors')]");

	By drpmgrOfVendor=By.xpath("//*[@id='VendorId']"); //Select class

	By txtFirstName=By.id("FirstName");
	By txtLastName=By.id("LastName");

	By txtAdminContent=By.id("AdminComment");
	By btnSave=By.xpath("//button[@type=\"submit\" and @name=\"save\"]");

	//Actions Methods

	public String getPageTitle()
	{
		return ldriver.getTitle();

	}

	public void clickOnCustomerMenu()
	{

		ldriver.findElement(lnkCustomer_menu).click();
	}

	public void clickOnCustomerMenuItem()
	{

		ldriver.findElement(lnkCustomers_menuItem).click();
	}
	
//	public void clearCustomerRole()
//	{
//
//		ldriver.findElement(clearCustomerRole).clear();
//	}
//	
	

	public void clickAddBtn()
	{

		ldriver.findElement(AddNew).click();
	}

	public void enterEmaiID(String email)
	{
		ldriver.findElement(txtEmail).sendKeys(email);
	}

	public void enterPassword(String pwd)
	{
		ldriver.findElement(txtPassword).sendKeys(pwd);
	}


	public void enterFirstName(String fname)
	{
		ldriver.findElement(txtFirstName).sendKeys(fname);
	}


	public void enterLastName(String lName)
	{
		ldriver.findElement(txtLastName).sendKeys(lName);
	}


	public void setGender(String gender)
	{
		if(gender.equals("Male"))
		{
			ldriver.findElement(rdMaleGender).click();
		}
		else if(gender.equals("Female"))
		{
			ldriver.findElement(rdFemaileGender).click();

		}

	}


	public void enterDateOfBirth(String Dob)
	{
		ldriver.findElement(txtDob).sendKeys(Dob);	

	}


	public void enterCompanyName(String Cmpy)
	{
		ldriver.findElement(txtCompanyName).sendKeys(Cmpy);

	}




	public void selectCustomerRole(String role) throws InterruptedException
	{
				if(!role.equals("Vendors"))
				{
					ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[1]")).click();
				}	
				
				
		ldriver.findElement(txtCustomerRoles).click();
		
		WebElement listItem = null;
		Thread.sleep(2000);


		if(role.equals("Administrator"))
		{ 
			listItem=ldriver.findElement(listItemAdministrators);
		}

		else if(role.equals("Fourm Moderator"))
		{ 
			listItem=ldriver.findElement(listItemFourmModerator);
		}

		else if(role.equals("Guests"))
		{ 
			listItem=ldriver.findElement(listItemGuests);
		}
		else if(role.equals("Registered"))
		{ 
			listItem=ldriver.findElement(listItemRegistered);
		}
		else if(role.equals("Vendors"))
		{ 
			listItem=ldriver.findElement(listItemVendors);

		}	

		else
		{
			listItem=ldriver.findElement(listItemGuests);
		}

		listItem.click();
	}


//		JavascriptExecutor jse=(JavascriptExecutor)ldriver;
//	jse.executeScript("arguments[0].click();",listItem);



	public void selectManagerOfVendor(String mngrVendor) throws InterruptedException
	{

		Select select=new Select(ldriver.findElement(drpmgrOfVendor));
		java.util.List<WebElement> vendors=select.getOptions();
		for(WebElement vendor: vendors)
		{
			System.out.println(vendor.getText());
		}
		
		select.selectByVisibleText(mngrVendor);
		Thread.sleep(2000);
	}


	public void enterAdminContent(String adminContent)
	{
		ldriver.findElement(txtAdminContent).sendKeys(adminContent);

	}


	public void clickOnSaveBtn()
	{

		ldriver.findElement(btnSave).click();
	}


}