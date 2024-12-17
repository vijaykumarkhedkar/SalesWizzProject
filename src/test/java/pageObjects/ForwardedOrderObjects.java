package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestCases.BaseClass;

public class ForwardedOrderObjects extends BaseClass {
	String Qnt;

	By ManageOrders = By.xpath("//span[.='Manage orders']");
	By RegularOrders = By.xpath("(//span[@class='drop-down ng-star-inserted'])[1]");
	By SupplierOrdersButton = By.xpath("//button[.='Supplier orders']	");
	By ForwardedOrderDetail = By.xpath("(//i[@class='fa fa-angle-right primaryColor'])[2]");
	By OrderValue = By.xpath("//p[contains(text(),'Ordered value')]");
	By MarkAsRecievedButton = By.xpath("//button[.='Mark as recieved']");
	By QNTfield = By.xpath("//input[@formcontrolname='deliveredgrams']");
	By ConfirmButton = By.xpath("//button[.='Confirm']");
	By ModifyOrderDropdown = By.xpath("//button[@class='mat-menu-trigger secondaryButton modifyBtn ng-star-inserted']");
	By CancelOrderButton = By.xpath("//p[normalize-space()='Cancel order']");
	By PartiallyReceived = By.xpath("//p[normalize-space()='Partially received']");
	By PopupYesButton = By.xpath("//span[.='Yes']");
	By SelectReason = By.xpath("(//span[@class='mat-radio-outer-circle'])[2]");
	By ConfirmButtonforReasonToCancel = By.xpath("//button[.='Confirm!']");
	By ToastMessage = By.xpath("//div[@id='toast-container']");
	By ListViewToggle = By.xpath("//span[@class='lever']");

	public void ClickONToast() {
		driver.findElement(ToastMessage).click();
	}

	public void ClickOnOrdersButton() {
		driver.findElement(ManageOrders).click();
	}

	public void ClickOnRegularOrders() {
		driver.findElement(RegularOrders).click();
	}

	public void SupplierOrdersButtonCLick() {
		driver.findElement(SupplierOrdersButton).click();
	}

	public void ForwardedOrderDetailClick() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ForwardedOrderDetail)).click();
//		driver.findElement(ForwardedOrderDetail).click();
	}

	public String GetOrderValue() {
		String text = driver.findElement(OrderValue).getText();
//		System.out.println(text);

		String[] Split1 = text.split(":");
		if (Split1.length > 1) {
			// Further split the second part by space to isolate the number
			String[] subParts = Split1[1].split(" ");
//			System.out.println("split1" + subParts);

			if (subParts.length > 0) {
				// The number we need is the first part of the subParts
				Qnt = subParts[1];

//				System.out.println("Quantity is: " + Qnt);
			} else {
				System.out.println("No value found after the colon.");
			}
		} else {
			System.out.println("Colon not found in the sentence.");
		}
		return Qnt;
	}

	public void MarkAsRecievedButtonClick() {
		driver.findElement(MarkAsRecievedButton).click();
	}

	public void EnterQnt() {
		driver.findElement(QNTfield).sendKeys(Qnt);

	}

	public void ClickOnConfirm() {
		driver.findElement(ConfirmButton).click();
	}

	public void ClickOnModifyDropDown() {
		driver.findElement(ModifyOrderDropdown).click();

	}

	public void CancelOrderClick() {
		driver.findElement(CancelOrderButton).click();
	}

	public void ClickPopupYesButton() {
		driver.findElement(PopupYesButton).click();
	}

	public void SelectReasonToCancel() {
		driver.findElement(SelectReason).click();
	}

	public void ClickOnConifrmButton() {
		driver.findElement(ConfirmButtonforReasonToCancel).click();
	}

	public void ListViewToggleClick() {
		driver.findElement(ListViewToggle).click();
	}

	public void PartiallyReceivedClick() {
		driver.findElement(PartiallyReceived).click();
	}

	public void PartialOrderQnt() throws InterruptedException {
		String text = driver.findElement(OrderValue).getText();
		System.out.println(text);

		String[] Split1 = text.split(":");
		if (Split1.length > 1) {
			// Further split the second part by space to isolate the number
			String[] subParts = Split1[1].split(" ");
			System.out.println("split1" + subParts);

			if (subParts.length > 0) {
				// The number we need is the first part of the subParts
				Qnt = subParts[1];

				System.out.println("Quantity is: " + Qnt);
			} else {
				System.out.println("No value found after the colon.");
			}
		} else {
			System.out.println("Colon not found in the sentence.");
		}

		// Convert the String to a integer
//		int INTQnt = Integer.parseInt(Qnt);
		Double DobleQNT = Double.parseDouble(Qnt);
		System.out.println("Double Value:" + DobleQNT);
		Double PartialQnt = (DobleQNT / 2);
		System.out.println(PartialQnt);
		// Convert the integer to a string
		String stringValue = String.valueOf(PartialQnt);
		System.out.println(stringValue);
		driver.findElement(QNTfield).sendKeys(stringValue);
//		System.out.println("qnttttttttttt"+stringValue);

	}
}
