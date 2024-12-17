package TestCases;

import java.time.Duration;

import org.testng.annotations.Test;

import pageObjects.BulkOrderObjects;
import pageObjects.ForwardedOrderObjects;
import pageObjects.LoginObjects;
import pageObjects.ManageInventory;
import pageObjects.OrderSummaryObjects;
import pageObjects.RegularOrder;

public class OrderSummary extends BaseClass {
	Login login;
	OrderSummaryObjects summary;
	ManageInventory inventory;
	BulkOrderObjects bulk;
	RegularOrder order;
	ForwardedOrderObjects forward;

	@Test	

	// Forwarding To NEW Supplier
	public void ForwardOrder1() throws InterruptedException {

		login = new Login();
		login.LoginWithNo();
		summary = new OrderSummaryObjects();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		summary.ClickOnOrderSummaryButton();
		summary.SelectOrder();
		summary.CLickOnForwardButton();
		summary.CLickOnAddSupplierButton();
		summary.AddSupplierDetails();
		summary.SupplierForwardDetails();

	}

	@Test
	// Forwarding To EXISTING Supplier
	public void ForwardOrder2() throws InterruptedException {

		login = new Login();
		login.LoginWithNo();
		summary = new OrderSummaryObjects();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		summary.ClickOnOrderSummaryButton();
		summary.SelectOrder();
		summary.CLickOnForwardButton();
		summary.SearchForSupplier();
		summary.SupplierForwardDetails();
		// Going to OrderSummary detail and forwarding order
		summary.ItemOrderDetail();
		summary.CLickOnForwardButton();
		summary.SearchForSupplier();
		summary.SupplierForwardDetails();
	}

	@Test
	public void MultiOrderForward() throws InterruptedException {

		summary = new OrderSummaryObjects();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		login = new Login();
		login.LoginWithNo();
		summary.ClickOnOrderSummaryButton();
		summary.SelectMultiOrder();
		summary.CLickOnForwardButton();
		summary.SupplierForwardMultiDetails();
		summary.SearchForSupplier();
		summary.CLickOnForwardButton();

	}

	@Test

	public void CheckInStock1() throws InterruptedException {
		// Checking InStock by updating Inventory
		summary = new OrderSummaryObjects();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		login = new Login();
		login.LoginWithNo();
		summary.ClickOnOrderSummaryButton();
		summary.GetInStockValueBeforeUpdating();
		inventory = new ManageInventory();
		inventory.ClickOnMyCatalogue();
		inventory.GotoProductList();
		Thread.sleep(2000);
		inventory.ClickOnMore();
		inventory.ClickOnManageInventory();
		Thread.sleep(2000);
		inventory.UpdateInventory();
		inventory.ClickOnSaveButton();
		summary.ClickOnOrderSummaryButton();
		summary.GetInStockValueAfterUpdating();

	}

	@Test
	// Check InStock By MARK AS RECEIVED in supplier orders
	public void CheckInStock2() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		login = new Login();
		login.LoginWithNo();
		summary = new OrderSummaryObjects();
		summary.ClickOnOrderSummaryButton();
		Thread.sleep(2000);
		summary.SearchForOrderSummary();
		summary.ItemOrderDetail();
		Thread.sleep(3000);
		summary.GetBeforeINStockValueInDetailPage();
		summary.CLickOnForwardButton();
		summary.SearchForSupplier();
		summary.SupplierForwardDetails();
		summary.CLickOnForwardButton();
		forward = new ForwardedOrderObjects();
		forward.ClickOnOrdersButton();
		forward.ClickOnRegularOrders();
		forward.SupplierOrdersButtonCLick();
		forward.ListViewToggleClick();
		forward.ForwardedOrderDetailClick();
		forward.GetOrderValue();
		forward.MarkAsRecievedButtonClick();
		forward.EnterQnt();
		forward.ClickOnConfirm();
		summary.ClickOnOrderSummaryButton();
		summary.SearchForOrderSummary();
		summary.ItemOrderDetail();
		summary.GetAfterINStockValueInDetailPage();

	}

	@Test
	public void CheckForwaredValue() throws InterruptedException {

		summary = new OrderSummaryObjects();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		login = new Login();
		login.LoginWithNo();
		summary.ClickOnOrderSummaryButton();
		Thread.sleep(2000);
		summary.SearchForOrderSummary();
		summary.ItemOrderDetail();
		String Qnt = summary.GetBeforeForwardedValueInDetail();
		summary.CLickOnForwardButton();
		summary.SearchForSupplier();
		summary.SupplierForwardDetails();
		summary.CLickOnForwardButton();
		Thread.sleep(2000);
		summary.ClickOnOrderSummaryButton();
		String ForwardedValue = summary.GetForwardedValueAfterUpdating(Qnt);
		forward = new ForwardedOrderObjects();
		forward.ClickOnOrdersButton();
		forward.ClickOnRegularOrders();
		forward.SupplierOrdersButtonCLick();
		forward.ListViewToggleClick();
		forward.ForwardedOrderDetailClick();
		String Qnt2 = forward.GetOrderValue();
		forward.MarkAsRecievedButtonClick();
		forward.EnterQnt();
		forward.ClickOnConfirm();
		summary.ClickOnOrderSummaryButton();
		summary.SearchForOrderSummary();
		summary.ItemOrderDetail();
		summary.GetAfterForwardedValueInDetail(Qnt, Qnt2, ForwardedValue);

	}

	@Test
	public void CheckOpenOrders() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		login = new Login();
		login.LoginWithNo();
		summary = new OrderSummaryObjects();
		summary.ClickOnOrderSummaryButton();
		String openOrderValue1 = summary.GetBeforeOpenOrdersValue();
		bulk = new BulkOrderObjects();
		bulk.AddOneProductToCart();
		bulk.AddBulkOrderBuyerdetails();
		summary = new OrderSummaryObjects();
		summary.ClickOnGoHomeButton();
		order = new RegularOrder();
		order.ClickOnOrdersButton();
		order.ClickOnRegularOrders();
		order.SelectAllOrders();
		order.AcceptOrder();
		order.EnterEDD();
		order.ClickAcceptEDD();
		summary.ClickOnOrderSummaryButton();
		summary.GetAfterOpenOrdersValue();
//		order.ClickOnOrdersButton();
		order.ClickOnRegularOrders();
		order.ClickOpenOrders();
		order.ClickOpenOrderDetail();
		Thread.sleep(2000);
		order.GetOrderedQnt();
		order.ClickMarkAsDelivered();
		order.EnterDeliveredQnt();
		order.ClickConfirmButton();
		summary.ClickOnOrderSummaryButton();
		summary.GetAfterDeliver_OpenOrdersValue();
		summary.ValidateOpenOrder(openOrderValue1);

	}

	@Test
	public void CheckShortORSurplus() throws InterruptedException {
		summary = new OrderSummaryObjects();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		login = new Login();
		login.LoginWithNo();
		summary.ClickOnOrderSummaryButton();
		summary.SearchForOrderSummary();
		summary.GetBeforeShortORSurplus();
		inventory = new ManageInventory();
		inventory.ClickOnMyCatalogue();
		inventory.GotoProductList();
		Thread.sleep(2000);
		inventory.ClickOnMore();
		inventory.ClickOnManageInventory();
		Thread.sleep(2000);
		inventory.UpdateInventory();
		inventory.ClickOnSaveButton();
		summary.ClickOnOrderSummaryButton();
		summary.GetAfterShortORSurplus();

	}

}
