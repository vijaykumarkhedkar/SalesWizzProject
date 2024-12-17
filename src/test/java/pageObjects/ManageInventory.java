package pageObjects;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestCases.BaseClass;

public class ManageInventory extends BaseClass {

	By ProductList = By.xpath("//td[contains(text(),'Ordersummarycheck')]");
	By More = By.xpath("//img[@src='../assets/salesWizz/images/moreOption.png']");
	By ManageInventory = By.xpath("//*[contains(text(),'Manage Inventory')]");
	By Inventory = By.xpath("(//input[@class='inputQty'])[2]");
	By SaveButton = By.xpath("//button[.='Save']");
	By MyCatalogue = By.xpath("//span[.='My Catalogues']");

	public void GotoProductList() {
		driver.findElement(ProductList).click();
	}

	public void ClickOnMore() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(More)).click();
//		driver.findElement(More).click();
	}

	public void ClickOnManageInventory() {
		driver.findElement(ManageInventory).click();
	}

	public void UpdateInventory() {

		System.out.println("Updating inventory as 10");
		driver.findElement(Inventory).click();
		driver.findElement(Inventory).clear();
		driver.findElement(Inventory).sendKeys("10");

//		System.out.println("iiiiiiiiiiiiii"+inventoryValue);
//		int intValue = Integer.parseInt(inventoryValue) + 5;
//		CharSequence charSequenceValue = Integer.toString(intValue);
//		System.out.println("uuuuuuuuuuuuuuuuuuuuu"+charSequenceValue);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(Inventory)).clear();
//		driver.findElement(Inventory).sendKeys(charSequenceValue);
//		System.out.println("After vallllll" + charSequenceValue); 
//		System.out.println("Updating inventory as" + " " + charSequenceValue);

	}

	public void ClickOnSaveButton() {
		driver.findElement(SaveButton).click();
	}

	public void ClickOnMyCatalogue() {
		driver.findElement(MyCatalogue).click();
	}

}
