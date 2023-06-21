package Testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import Pages.LoginPage;

public class LoginTest extends BaseClass {

	
	@Test
	public void ValidLogin(Method method) throws FilloException, InterruptedException {
		
		LoginPage login = new LoginPage(driver);
		
		Recordset recordset = connection.executeQuery("select * from data where TestName='"+method.getName()+"'");
		recordset.next();
			
		String UserName = recordset.getField("UserName");
		String Password = recordset.getField("Password");
		
		login.LoginFunction(UserName, Password);
		
		WebElement ValidMesg = driver.findElement(By.xpath("//span[@class='title']"));
		Thread.sleep(3000);

		String ActError = ValidMesg.getText();
		String ExpError = "Products";

		AssertJUnit.assertEquals(ActError, ExpError);
		
	}
		@Test
		public void InvalidLogin(Method method) throws FilloException, InterruptedException {
			
			LoginPage login = new LoginPage(driver);
			
			Recordset recordset = connection.executeQuery("select * from data where TestName='"+method.getName()+"'");
			recordset.next();
				
			String UserName = recordset.getField("UserName");
			String Password = recordset.getField("Password");
			
			login.LoginFunction(UserName, Password);
			
			WebElement errorMesg = driver.findElement(By.xpath("//h3[@data-test='error']"));
			Thread.sleep(3000);

			String ActError = errorMesg.getText();
			String ExpError = recordset.getField("ExpError");

			AssertJUnit.assertEquals(ActError, ExpError);
			
		}
}
		
	

		
		
	

