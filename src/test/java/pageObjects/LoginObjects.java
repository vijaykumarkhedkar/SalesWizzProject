package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import TestCases.BaseClass;
import Utilities.FetchData;
import Utilities.MongoDBUtil;

public class LoginObjects extends BaseClass {

	FetchData data;
	MongoDBUtil DB;

	By MobileNumber = By.xpath("//input[@placeholder='Mobile Number']");
	By NextButton = By.xpath("//button[.='Next']");
	By OTPfield = By.xpath("//input[@formcontrolname='otpValue']");
	By Submit = By.xpath("//button[.='Submit']");

	public void EnterMobileNumber() {
		data = new FetchData();
		String number = data.GetMobileNo();
		driver.findElement(MobileNumber).sendKeys(number);
		driver.findElement(NextButton).click();

	}

	public void EnterNewMobileNumber() {
		data = new FetchData();
		String Newnumber = data.GetNewMobNumber();
		driver.findElement(MobileNumber).sendKeys(Newnumber);
		driver.findElement(NextButton).click();

	}

	public void EntrOTP() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String otp = MongoDBUtil.getOtpFromDb();
		driver.findElement(OTPfield).sendKeys(otp);
		driver.findElement(Submit).click();

	}

}