package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	public WebDriver ldriver;


	public LoginPage(WebDriver cdriver)   //Constructor page factory
	{
		ldriver=cdriver;
		PageFactory.initElements(cdriver, this);
	}


	@FindBy(id="Email")
	WebElement txtEmail;

	@FindBy(id="Password")
	WebElement txtPassword;

	@FindBy(xpath="//button[@class='button-1 login-button']")
	WebElement btnLogIn;

	@FindBy(linkText="Logout")
	WebElement btnLogOut;


	public void setUserName(String uname)
	{
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}

	public void setPassword(String pwd)
	{
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
	}

	public void clickOnLogIn()
	{
		btnLogIn.click();
	}
	public void clickOnLogOut()
	{
		btnLogOut.click();
	}
}