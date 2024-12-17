package TestCases;

import java.time.Duration;

import org.testng.annotations.Test;

import buyerSide.BuyerSideObjects;
import pageObjects.Catalogue;
import pageObjects.CatalogueShare;
import pageObjects.LoginObjects;

public class BuyerSide extends BaseClass {
	BuyerSideObjects buyer;
	Catalogue add;
	CatalogueShare share;
	Login login;

	@Test
	public void BuyerPlaceOrder() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
		login = new Login();
		login.LoginWithNo();
		CatalogueShare share = new CatalogueShare();
		share.ShareCatalogueLink();
		share.OpenNewTab();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		BuyerSideObjects buyer = new BuyerSideObjects();
		buyer.EnterBuyerMobileNumber();
		Thread.sleep(2000);
		buyer.EntrOTP();
	}

//	public void LoginBuyer() throws InterruptedException {
//
//
//	}

}
