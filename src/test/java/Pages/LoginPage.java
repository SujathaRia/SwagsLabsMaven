package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testcases.BaseClass;

public class LoginPage {

	WebDriver pageDriver;

	// ================================objects===================================

	@FindBy(name = "user-name")
	WebElement userName;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(name = "login-button")
	WebElement loginBtn;

	// =====================================Methods==========================================

	public LoginPage(WebDriver driver) {
		pageDriver = driver;
		PageFactory.initElements(pageDriver, this);
	}

	public void LoginFunction(String UserNameVal, String PwdVal) {

		userName.sendKeys(UserNameVal);
		password.sendKeys(PwdVal);
		loginBtn.click();

	}

}
