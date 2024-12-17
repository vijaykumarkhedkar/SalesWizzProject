package TestCases;

import org.testng.annotations.Test;

import buyerSide.BuyerSideObjects;
import pageObjects.BulkOrderObjects;

public class BulkOrder extends BaseClass {

	BulkOrderObjects bulk;
	Login login;
    @Test
	public void bulkorder() throws InterruptedException {

		login = new Login();
		login.LoginWithNo();
		bulk = new BulkOrderObjects();
		bulk.BulkPlaceOrder();
		bulk.AddBulkOrderBuyerdetails();

	}

}
