package TestCases;

import java.time.Duration;

import org.testng.annotations.Test;

import pageObjects.LoginObjects;
import pageObjects.ManageInventory;

public class InventoryCheck extends BaseClass {
	ManageInventory inventory;
	Login login;

	
	@Test
	public void Inventory() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		login = new Login();
		login.LoginWithNo();
		inventory = new ManageInventory();
//		inventory.ClickOnMyCatalogue();
		inventory.GotoProductList();
		Thread.sleep(2000);
		inventory.ClickOnMore();
		inventory.ClickOnManageInventory();
		inventory.UpdateInventory();
		Thread.sleep(2000);
		inventory.ClickOnSaveButton();
		

	}
}
