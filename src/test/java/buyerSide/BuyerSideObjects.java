package buyerSide;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mongodb.client.model.Windows;

import TestCases.BaseClass;
import Utilities.FetchData;
import Utilities.MongoDBUtil;

public class BuyerSideObjects extends BaseClass {
	FetchData data;
	MongoDBUtil DB;
	By MobNumber = By.xpath("//input[@placeholder='Mobile Number*']");
	By SubmitButton = By.xpath("//a[.='Submit']");
	By OTPfield = By.xpath("//input[@formcontrolname='otp']");
	By CartIcon = By.xpath("//img[@src='../../assets/cartImgNew.svg']");
	By SubmitOrderButton = By.xpath("//button[.='Submit order']");
	By QntField = By.xpath("//div[@class='quantity']//input[@type='text']");
	By BuyerName = By.xpath("//input[@formcontrolname='name']");
	By BuyerEmail = By.xpath("//input[@formcontrolname='email']");
	By BuyerCompanyName = By.xpath("//input[@formcontrolname='companyName']");
	By Submit = By.xpath("//a[.='Submit']");
	By AddToCartButton1 = By.xpath("(//img[@class=\"cartLogo\"])[1]");
	By AddToCartButton2 = By.xpath("//button[.='Add to cart']");
	By MyCatalogue = By.xpath("//span[.='My Catalogues']");
	By selectVariant = By.xpath("//button[@class='selectVariant ng-star-inserted']");
	By Varient = By.xpath("//span[@class='valueList ng-star-inserted']");

	public void EnterBuyerMobileNumber() {
		data = new FetchData();
		String number = data.GetMobileNo();
		driver.findElement(MobNumber).sendKeys(number);
		driver.findElement(SubmitButton).click();

	}

	public void EntrOTP() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String otp = MongoDBUtil.getOtpFromDb();
		driver.findElement(OTPfield).sendKeys(otp);
		driver.findElement(SubmitButton).click();

	}

	public void ClickOnCartIcon() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(CartIcon)).click();

	}

	public void EditQnt() throws InterruptedException {
		driver.findElement(QntField).clear();
		Thread.sleep(1000);
		driver.findElement(QntField).sendKeys("4");

	}

	public void ClickONSubmitOrderButton() {
		driver.findElement(SubmitOrderButton).click();
	}

	public void AddBuyerDetail() {
		driver.findElement(BuyerName).clear();
		driver.findElement(BuyerName).sendKeys("Bharath");
		driver.findElement(BuyerEmail).clear();
		driver.findElement(BuyerEmail).sendKeys("vijayQa@gmail.com");
		driver.findElement(BuyerCompanyName).clear();
		driver.findElement(BuyerCompanyName).sendKeys("Ninja");
	}

	public void SubmitClick() {
		driver.findElement(Submit).click();
	}

	public void AddToCartButtonClick() {
		driver.findElement(AddToCartButton1).click();
		driver.findElement(selectVariant).click();
		driver.findElement(Varient).click();
		driver.findElement(AddToCartButton2).click();

	}

	public void SwitchTab() throws InterruptedException {
		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> ittr = windows.iterator();
		String ParentTab = ittr.next();
		driver.switchTo().window(ParentTab);
	}

	public void RefresgPage() throws InterruptedException {
		driver.navigate().refresh();

	}

}
