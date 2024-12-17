package pageObjects;

import org.openqa.selenium.By;

import TestCases.BaseClass;

public class RegularOrder extends BaseClass {
	String value;
	By ManageOrders = By.xpath("//span[.='Manage orders']");
	By RegularOrders = By.xpath("(//span[@class='drop-down ng-star-inserted'])[1]");
	By SearchCatalogue = By.xpath("//input[@placeholder='Search catalogue by name']");
	By SelectAll = By.xpath("(//input[@type='checkbox'])[1]");
	By AcceptButton = By.xpath("//button[.='Accept']");
	By EDD = By.cssSelector("input[id='edd']");
	By AcceptEDD = By.xpath("//p[.='Accept']");
	By OpenOrders = By.xpath("//div[contains(text(), 'Open orders')]");
	By OpenOrderDetail = By.xpath("//div[@class='rightArrow ng-star-inserted']");
	By MarkAsDelivered = By.xpath("//button[.='Mark as delivered']");
	By OrderedQnt = By.xpath("//p[contains(text(),'Ordered value')]");
	By DeliveredQnt = By.xpath("//input[@placeholder='Enter the deliver value']");
	By ConfirmButton = By.xpath("//button[.='Confirm']");
	By RejectButton = By.xpath("//button[.='Reject']");
	By ForwardedOrderDetail = By.xpath("(//i[@class='fa fa-angle-right primaryColor'])[2]");
	By BackButton = By.cssSelector("img[src='../../assets/salesWizz/images/backicon.png']");


	public void ClickOnOrdersButton() {
		driver.findElement(ManageOrders).click();
	}

	public void ClickOnRegularOrders() {
		driver.findElement(RegularOrders).click();
	}

	public void SelectAllOrders() {
		driver.findElement(SelectAll).click();
	}

	public void AcceptOrder() {
		driver.findElement(AcceptButton).click();
	}

	public void EnterEDD() {
		driver.findElement(EDD).sendKeys("17062024");
	}

	public void ClickAcceptEDD() throws InterruptedException {
		driver.findElement(AcceptEDD).click();
		Thread.sleep(2000);

	}

	public void ClickOpenOrders() {
		driver.findElement(OpenOrders).click();
	}

	public void ClickOpenOrderDetail() {
		driver.findElement(OpenOrderDetail).click();
	}

	public void GetOrderedQnt() {
		String Qnt = driver.findElement(OrderedQnt).getText();
//		System.out.println("Extracted text: " + Qnt); // Debugging: Print the extracted text

		String[] parts = Qnt.split(": ");

		if (parts.length > 1) {
			// Further split the second part by space to isolate the number
			String[] subParts = parts[1].split(" ");

			if (subParts.length > 0) {
				// The number we need is the first part of the subParts
				value = subParts[0];

				// Print the extracted value
//				System.out.println("Extracted value: " + value);
			} else {
				System.out.println("No value found after the colon.");
			}
		} else {
			System.out.println("Colon not found in the sentence.");
		}
	}

	public void ClickMarkAsDelivered() {
		driver.findElement(MarkAsDelivered).click();

	}

	public void EnterDeliveredQnt() {
		driver.findElement(DeliveredQnt).sendKeys(value);
	}

	public void ClickConfirmButton() {
		driver.findElement(ConfirmButton).click();
	}

	public void RejectOrder() {
		driver.findElement(RejectButton).click();

	}
	public void NavigateBack() {
		driver.findElement(BackButton).click();

	}
	

}
