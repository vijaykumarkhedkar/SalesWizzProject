package TestCases;

import java.time.Duration;

import org.testng.annotations.Test;

import pageObjects.ForwardedOrderObjects;
import pageObjects.LoginObjects;
import pageObjects.RegularOrder;

public class RegularOrders extends BaseClass {
	Login login;
	RegularOrder order;
	ForwardedOrderObjects forward;

	@Test
	public void RegularOrderAction() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		login = new Login();
		login.LoginWithNo();
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

	@Test
	public void RejectNewOrder() throws InterruptedException {
		login = new Login();
		login.LoginWithNo();
		order = new RegularOrder();
		forward = new ForwardedOrderObjects();
		order.ClickOnOrdersButton();
		order.ClickOnRegularOrders();
		order.SelectAllOrders();
		order.RejectOrder();
		forward.SelectReasonToCancel();
		forward.ClickOnConifrmButton();
	}

}
