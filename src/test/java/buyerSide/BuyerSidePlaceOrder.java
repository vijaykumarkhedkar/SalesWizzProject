package buyerSide;

import java.time.Duration;

import org.testng.annotations.Test;

import TestCases.BaseClass;
import pageObjects.Catalogue;
import pageObjects.CatalogueShare;
import pageObjects.LoginObjects;
import pageObjects.ManageInventory;
import pageObjects.RegularOrder;

public class BuyerSidePlaceOrder extends BaseClass {
	LoginObjects login;
	Catalogue add;
	CatalogueShare share;
	BuyerSideObjects buyer;
	RegularOrder order;

	@Test
	public void BuyerPlaceOrder() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		login = new LoginObjects();
		login.EnterMobileNumber();
		Thread.sleep(2000);
		login.EntrOTP();
		CatalogueShare share = new CatalogueShare();
		share.ShareCatalogueLink();
		share.OpenNewTab();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		BuyerSideObjects buyer = new BuyerSideObjects();
		buyer.EnterBuyerMobileNumber();
		Thread.sleep(2000);
		buyer.EntrOTP();
		buyer.AddToCartButtonClick();
		buyer.ClickOnCartIcon();
		buyer.EditQnt();
		buyer.ClickONSubmitOrderButton();
		buyer.AddBuyerDetail();
		buyer.SubmitClick();
		buyer.SwitchTab();
		buyer.RefresgPage();
		order = new RegularOrder();
		order.ClickOnOrdersButton();
		order.ClickOnRegularOrders();
		order.SelectAllOrders();
		order.AcceptOrder();
		order.EnterEDD();
		order.ClickAcceptEDD();
		order.ClickOpenOrders();
		order.ClickOpenOrderDetail();
		order.GetOrderedQnt();
		order.ClickMarkAsDelivered();
		order.EnterDeliveredQnt();
		order.ClickConfirmButton();

	}

}
