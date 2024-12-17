package TestCases;

import java.time.Duration;

import org.testng.annotations.Test;

import pageObjects.Catalogue;
import pageObjects.LoginObjects;

public class Login extends BaseClass {
	LoginObjects login;
	Catalogue add;
	
	

	@Test
	public void LoginWithNo() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		login = new LoginObjects();
		login.EnterMobileNumber();
		Thread.sleep(2000);
		login.EntrOTP();
		

	}

}
