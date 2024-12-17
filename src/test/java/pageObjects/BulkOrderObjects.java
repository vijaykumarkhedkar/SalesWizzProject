package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestCases.BaseClass;
import Utilities.FetchData;
import buyerSide.BuyerSideObjects;

public class BulkOrderObjects extends BaseClass {

	By BulkOrder = By.xpath("//span[.='Bulk order']");
	By Search = By.xpath("//input[@type='text']");
	By Catalogue1 = By.xpath("(//img[@alt='catalogImage'])[1]");
	By Catalogue2 = By.xpath("(//img[@alt='catalogImage'])[2]");
	By AddToCart = By.xpath("(//button[.= 'Add to cart'])[2]");
	By SelectVariantButton = By.xpath("//button[.= 'Select Variants']");
	By SelectVariant = By.xpath("//span[@class='valueList ng-star-inserted']");
	By BackButton = By.xpath("//img[@src='../../assets/salesWizz/images/backicon.svg']");
	By CartIcon = By.xpath("//button[@class='primaryButton cartBtn1']");
	By ContinueButton = By.xpath("//button[.='Continue']");
	By QntField1 = By.xpath("(//input[@type='text'])[1]");
	By QntField2 = By.xpath("(//input[@type='text'])[2]");
	By BuyerName = By.xpath("//input[@formcontrolname='name']");
	By BuyerNumber = By.xpath("//input[@formcontrolname='mobileNumber']");
	By BuyerCompanyName = By.xpath("//input[@formcontrolname='companyName']");
	By BuyerLocation = By.xpath("//input[@formcontrolname='location']");
	By SubmitButton = By.xpath("//button[.='Submit']");

	FetchData data;
	Actions action;
	BuyerSideObjects buyer;

	public void BulkPlaceOrder() throws InterruptedException {

		data = new FetchData();
		String catalogueName = data.GetCatalogueName();
		driver.findElement(BulkOrder).click();
		driver.findElement(Search).sendKeys(catalogueName);
		action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(Catalogue1).click();
		driver.findElement(AddToCart).click();
		driver.findElement(SelectVariantButton).click();
		driver.findElement(SelectVariant).click();
		driver.findElement(AddToCart).click();
		driver.findElement(BackButton).click();
		Thread.sleep(2000);
//	    WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(CartIcon)).click();
		driver.findElement(CartIcon).click();
		driver.findElement(QntField1).clear();
		driver.findElement(QntField2).sendKeys("2");
		driver.findElement(ContinueButton).click();
		driver.findElement(QntField2).clear();
		driver.findElement(QntField2).sendKeys("3");
		driver.findElement(ContinueButton).click();

	}

	public void AddOneProductToCart() throws InterruptedException {
		data = new FetchData();
		String catalogueName = data.GetCatalogueName();
		driver.findElement(BulkOrder).click();
		driver.findElement(Search).sendKeys(catalogueName);
		action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(Catalogue2).click();
		driver.findElement(AddToCart).click();
		Thread.sleep(1500);
		driver.findElement(CartIcon).click();
		Thread.sleep(1500);
		driver.findElement(QntField1).clear();
		driver.findElement(QntField1).sendKeys("5");
		driver.findElement(ContinueButton).click();

	}

	public void AddBulkOrderBuyerdetails() {
		driver.findElement(BuyerName).sendKeys("Axar patel");
		driver.findElement(BuyerNumber).sendKeys("8904959239");
		driver.findElement(BuyerCompanyName).sendKeys("Ninja");
		driver.findElement(BuyerLocation).sendKeys("Kalaburagi");
		driver.findElement(SubmitButton).click();

	}

}
