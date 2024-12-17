package pageObjects;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestCases.BaseClass;
import Utilities.FetchData;
import ch.qos.logback.core.joran.action.Action;

public class OrderSummaryObjects extends BaseClass {
	FetchData data;
	Actions action;
	String OpenOrderValue1;
	String OpenOrderValue2;
	String OpenOrderFinalValue;

	By OrderSummaryButton = By.xpath("(//span[.='Order summary'])[1]");
	By SelectOrder1 = By.xpath("(//input[@type=\"checkbox\"])[1]");
	By SelectOrder2 = By.xpath("(//input[@type=\"checkbox\"])[2]");
	By ForwardButton = By.xpath("//button[.='Forward']");
	By MultiForwardButton = By.xpath("//button[.='Forward your order']");
	By SupplierButton = By.xpath("//button[.='Add supplier']");
	By SupplierName = By.xpath("//input[@formcontrolname='name']");
	By CompanyName = By.xpath("//input[@formcontrolname='companyName']");
	By MobileNumber = By.xpath("//input[@formcontrolname='mobileNumber']");
	By Email = By.xpath("//input[@formcontrolname='email']");
	By PinCode = By.xpath("//input[@formcontrolname='pincode']");
	By AdressLine1 = By.xpath("//input[@formcontrolname='addressLine1']");
	By AdressLine2 = By.xpath("//input[@formcontrolname='addressLine2']");
	By SaveButton = By.xpath("//button[.='Save']");
	By Quantity1 = By.xpath("(//input[@type='number'])[1]");
	By Quantity2 = By.xpath("(//input[@type='number'])[2]");
	By EDD = By.xpath("//input[@type='date']");
	By SearchSupplier = By.xpath("//input[@role='combobox']");
	By SearchSuggestion = By.xpath("//mat-option[@class='mat-option mat-focus-indicator ng-star-inserted']");
	By BackButton = By.cssSelector("img[src='../../assets/salesWizz/images/backicon.png']");
	By ItemOrderDetail = By.xpath("(//td[@class='lastColumn'])[1]");
	By OrderDetail = By.xpath(
			"//td[normalize-space(text())='Men Ring']//following-sibling::td//*[@src='../assets/salesWizz/images/rightCircleArrow.svg']");
	By ForwardedValue = By.xpath("(//span[@class='greenColor'])[2]");
	By ForwardedValueInDetail = By.xpath("(//p[@class='textWeight4 greenColor'])[2]");
	By InStock = By.xpath("(//p[@class='textWeight4 greenColor'])[1]");
	By SearchOrderSummary = By.xpath("//input[@class='searchInput ng-untouched ng-pristine ng-valid']");
	By GoHomeButton = By.xpath("//button[.='Go Home']");
	By OpenOrders = By.xpath("//tbody/tr[1]/td[7]");
	By ShortORSurplus = By.xpath("//tbody/tr/td[9]");

	public void ClickOnOrderSummaryButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(OrderSummaryButton)).click();
//		driver.findElement(OrderSummaryButton).click();
	}

	public void SelectOrder() {
		driver.findElement(SelectOrder1).click();
	}

	public void SelectMultiOrder() {
		driver.findElement(SelectOrder1).click();
		driver.findElement(SelectOrder2).click();
	}

	public void CLickOnForwardButton() {
		driver.findElement(ForwardButton).click();
	}

	public void CLickOnAddSupplierButton() {
		driver.findElement(SupplierButton).click();
	}

	public void NavigateBack() {
		driver.findElement(BackButton).click();

	}

	public void AddSupplierDetails() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		data = new FetchData();
		String SName = data.GetSupplierName();
		System.out.println("Supplier Name is:" + SName);
		driver.findElement(SupplierName).sendKeys(SName);
		data = new FetchData();
		String CName = data.GetCompanyName();
		System.out.println(CName);
		driver.findElement(CompanyName).sendKeys(CName);
		data = new FetchData();
		String MNO = data.GetMobileNumber();
		driver.findElement(MobileNumber).sendKeys(MNO);
		data = new FetchData();
		String mail = data.GetEmail();
		driver.findElement(Email).sendKeys(mail);
		data = new FetchData();
		String Pincode = data.GetPinCode();
		driver.findElement(PinCode).sendKeys(Pincode);
		data = new FetchData();
		String Address1 = data.GetAdressLine1();
		driver.findElement(AdressLine1).sendKeys(Address1);
		data = new FetchData();
		String Address2 = data.GetAdressLine2();
		driver.findElement(AdressLine2).sendKeys(Address2);
		driver.findElement(SaveButton).click();
		Thread.sleep(3000);

	}

	public void SupplierForwardDetails() throws InterruptedException {
		driver.findElement(Quantity1).sendKeys("5");

	}

	public void SupplierForwardMultiDetails() throws InterruptedException {
		driver.findElement(Quantity1).sendKeys("5");
		driver.findElement(Quantity2).sendKeys("4");
		driver.findElement(MultiForwardButton).click();

	}

	public void SearchForSupplier() throws InterruptedException {
		driver.findElement(SearchSupplier).sendKeys("Divya");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(SearchSuggestion)).click();

	}

	public void ItemOrderDetail() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ItemOrderDetail)).click();
//		driver.findElement(ItemOrderDetail).click();

	}

	public void GetBeforeINStockValueInDetailPage() {
		System.out.println("InStock value after making order as Mark as Received");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		String InStockValue = wait.until(ExpectedConditions.visibilityOfElementLocated(InStock)).getText();
//				String InStockValue driver.findElement(InStock).getText();
		System.out.println("Before INStock Value is" + " " + InStockValue);

	}

	public void GetAfterINStockValueInDetailPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		String InStockValue = wait.until(ExpectedConditions.visibilityOfElementLocated(InStock)).getText();
//		String InStockValue = driver.findElement(InStock).getText();
		System.out.println("After INStock Value is" + " " + InStockValue);
		Assert.assertEquals("rgjkwrpgij", InStockValue);

	}

	public void GetInStockValueBeforeUpdating() throws InterruptedException {
		driver.findElement(SearchOrderSummary).sendKeys("Men ring");
		Thread.sleep(2000);
		driver.findElement(OrderDetail).click();
		String InStockValue = driver.findElement(InStock).getText();
		System.out.println("Before updating inventory InStock value is  " + " " + InStockValue);
	}

	public void GetInStockValueAfterUpdating() {
		driver.findElement(OrderDetail).click();
		String InStockValue = driver.findElement(InStock).getText();
		System.out.println("After updating inventory InStock value is" + " " + InStockValue);
	}

	public void GetForwardedValueBeforeUpdating() {
//		driver.findElement(OrderDetail).click();
		String ForwardedValue = driver.findElement(By.xpath("(//span[@class='greenColor'])[2]")).getText();
		System.out.println("Forwarding Quantity is 5");
		System.out.println("Before Value" + " " + ForwardedValue);
	}

	public String GetBeforeForwardedValueInDetail() {
		String FrdVlaue1 = driver.findElement(ForwardedValueInDetail).getText();
//		System.out.println("Before forwarding, value is" + " " + FrdVlaue1);
		return FrdVlaue1;
	}

	public String GetForwardedValueAfterUpdating(String FrdVlaue1) {
//		driver.findElement(OrderDetail).click();
		String ForwardedValue = driver.findElement(By.xpath("(//span[@class='greenColor'])[2]")).getText();
//		System.out.println("After forwading order, value is " + " " + ForwardedValue);
		Assert.assertNotEquals(FrdVlaue1, ForwardedValue);
//		System.out.println("" + "," + "Before Forwarding value was" + " " + FrdVlaue1 + "," + " "
//				+ "After Forwarding value is" + " " + ForwardedValue);
		return ForwardedValue;
	}

	public void GetAfterForwardedValueInDetail(String FrdVlaue1, String Qnt, String ForwardedValue) {
		String FrdVlaue2 = driver.findElement(ForwardedValueInDetail).getText();
//		System.out.println("After Mark as received, value is" + " " + FrdVlaue2);
		Assert.assertEquals(FrdVlaue1, FrdVlaue2);
		System.out.println("SUCCESS" + " " + "Forwarding Quantity is" + " " + Qnt
				+ ", Before Forwarding an order, Forwarding Value is" + " " + FrdVlaue1 + "."
				+ "After Forwarding an order, Forwarding Value is" + " " + ForwardedValue + ". "
				+ "After Marking Order as received, Forwarded Value is" + " " + FrdVlaue2);

	}

	public void SearchForOrderSummary() {
		driver.findElement(SearchOrderSummary).sendKeys("Krishna");
		action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
	}

	public void ClickOnGoHomeButton() {
		driver.findElement(GoHomeButton).click();
	}

	public String GetBeforeOpenOrdersValue() {

		driver.findElement(SearchOrderSummary).sendKeys("Krishna");
		action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		OpenOrderValue1 = driver.findElement(OpenOrders).getText();
		System.out.println("Before Open Order Value" + " " + OpenOrderValue1);
		return OpenOrderValue1;

	}

	public void GetAfterOpenOrdersValue() {
		System.out.println("Order value is 5 ");
		OpenOrderValue2 = driver.findElement(OpenOrders).getText();
		System.out.println("After accepting the order, Open Order Value" + " " + OpenOrderValue2);
	}

	public void GetAfterDeliver_OpenOrdersValue() {
		OpenOrderFinalValue = driver.findElement(OpenOrders).getText();
		System.out.println("Open Order Value after Delivery the Order" + " " + OpenOrderFinalValue);

	}

	public void ValidateOpenOrder(String openOrderValue1) {
		Assert.assertEquals(openOrderValue1, OpenOrderFinalValue);
		System.out.println("RESULT: Open Order is Working");

	}

	public void GetBeforeShortORSurplus() {
		String ShortORSurplusValue = driver.findElement(ShortORSurplus).getText();
		System.out.println("ShortORSurplusValue Before is" + " " + ShortORSurplusValue);

	}

	public void GetAfterShortORSurplus() {
		String ShortORSurplusValue = driver.findElement(ShortORSurplus).getText();
		System.out.println("ShortORSurplusValue After is" + " " + ShortORSurplusValue);

	}

}
