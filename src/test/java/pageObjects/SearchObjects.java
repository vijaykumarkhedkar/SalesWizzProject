package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestCases.BaseClass;

public class SearchObjects extends BaseClass {
	Actions action;

	By search = By.xpath("//input[@class='searchInput ng-untouched ng-pristine ng-valid']");
	By ProductName = By.xpath("//td[contains(text(), 'Newcollections')]");
	By OrderSummaryButton = By.xpath("(//span[.='Order summary'])[1]");
	By ManageOrders = By.xpath("//span[.='Manage orders']");
	By RegularOrders = By.xpath("(//span[@class='drop-down ng-star-inserted'])[1]");
	By OrderSearch = By.xpath("//input[@class='searchInput ng-untouched ng-pristine ng-valid']");
	By Order_ID = By.xpath("(//p[contains(text(), 'Order #RO8022082')])[1]");
	By CustomOrder = By.xpath("//span[.='Custom Orders']");
	By CustomOrderID = By.xpath("(//td[contains(text(),'CO8022082')])[1]");
	By ManageInventory = By.xpath("//span[.='Manage inventory']");
	By BuyerButton = By.xpath("//span[.='Buyers']");
	By BuyerNumber = By.xpath("(//td[contains(text(), '+91')])[1]");
	By ActiveBuyers = By.xpath("//div[contains(text(),'Active buyers')]");
	By ActiveBuyerSearch = By.xpath("//input[@class='searchInput ng-valid ng-dirty ng-touched']");
	By SupplierList = By.xpath("//span[.='Supplier list']");

	public void SearchForCatalogue() {
		driver.findElement(search).sendKeys("Newcollections");
		action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		WebElement productname = driver.findElement(ProductName);
		if (productname.isDisplayed()) {
			System.out.println("Catalogue Search is Working");
		} else {
			System.out.println("Catalogue Search failed");

		}
	}

	public void SearchForProduct() {
		driver.findElement(ProductName).click();
		driver.findElement(search).sendKeys("Bracelet for men");
		action.sendKeys(Keys.ENTER).build().perform();
		WebElement ProductName = driver.findElement(By.xpath("(//p[.=' Bracelet for men '])[1]"));
		if (ProductName.isDisplayed()) {
			System.out.println("Product Search Is Working");
		} else {
			System.out.println("Product Search not Working");

		}

	}

	public void SearchINOrderSummary() {

		driver.findElement(OrderSummaryButton).click();
		driver.findElement(search).sendKeys("Men Ring");
		action.sendKeys(Keys.ENTER).build().perform();
		WebElement SearchResult = driver.findElement(By.xpath("(//td[.='Men Ring '])[1]"));
		if (SearchResult.isDisplayed()) {
			System.out.println("OrderSummary Search is Working");

		} else {
			System.out.println("OrderSummary Search is not working");
		}

	}

	public void SearchInRegularOrder() {
		driver.findElement(ManageOrders).click();
		driver.findElement(RegularOrders).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(OrderSearch));
		String ID = driver.findElement(Order_ID).getText();
		String[] split1 = ID.split("Order");
		String split2 = split1[1];
//		System.out.println(split2);
		String[] split3 = split2.split("#");
		String OrderID = split3[1];
//		System.out.println(OrderID);
		driver.findElement(OrderSearch).sendKeys(OrderID);
		action.sendKeys(Keys.ENTER).build().perform();
		WebElement OrderId = driver.findElement(Order_ID);
		if (OrderId.isDisplayed()) {
			System.out.println("RegularOrder search is working ");
		} else {
			System.out.println("RegularOrder search not working ");
		}

	}

	public void SearchInCustomOrder() throws InterruptedException {
		driver.findElement(CustomOrder).click();
		Thread.sleep(1000);
		String ID = driver.findElement(CustomOrderID).getText();
		driver.findElement(OrderSearch).sendKeys(ID);
		action.sendKeys(Keys.ENTER).build().perform();
		WebElement CustomOrder_ID = driver.findElement(CustomOrder);
		if (CustomOrder_ID.isDisplayed()) {
			System.out.println("Custom Order Search is Working");
		} else {
			System.out.println("Custom Order Search is not Working");
		}

	}

	public void SearchInManageInvetory() throws InterruptedException {
		driver.findElement(ManageInventory).click();
		driver.findElement(OrderSearch).sendKeys("Dont delete");
		Thread.sleep(2000);
		action.sendKeys(Keys.ENTER).build().perform();
		WebElement InventoryName = driver.findElement(By.xpath("(//td[.='Dont delete'])[1]"));
		if (InventoryName.isDisplayed()) {
			System.out.println("Manage Inventory search is working");
		} else {
			System.out.println("Manage Inventory search not working");
		}

	}

	public void BuyerSearch() throws InterruptedException {
		driver.findElement(BuyerButton).click();
		String No = driver.findElement(BuyerNumber).getText();
		String[] Split1 = No.split("-");
		String number = Split1[1];
		driver.findElement(OrderSearch).sendKeys(number);
		Thread.sleep(2000);
		action.sendKeys(Keys.ENTER).build().perform();
		WebElement n = driver.findElement(BuyerNumber);
		if (n.isDisplayed()) {
			System.out.println("New request buyer search is working");

		} else {
			System.out.println("New request buyer search is not working");
		}

		driver.findElement(ActiveBuyers).click();
		Thread.sleep(2000);
		WebElement ActiveElement = driver.findElement(BuyerNumber);
		String A_No = driver.findElement(BuyerNumber).getText();
		String[] split1 = A_No.split("-");
		String number2 = split1[1];
		driver.findElement(ActiveBuyerSearch).sendKeys(number2);
		action.sendKeys(Keys.ENTER).build().perform();
		if (ActiveElement.isDisplayed()) {
			System.out.println("Active buyer search is working");

		} else {
			System.out.println("Active buyer search is not working");
		}

	}

}
