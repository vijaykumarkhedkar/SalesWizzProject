package TestCases;

import org.testng.annotations.Test;

import pageObjects.ForwardedOrderObjects;
import pageObjects.LoginObjects;

public class ForwardedOrder extends BaseClass {
	Login login;
	ForwardedOrderObjects forward;

	@Test
	public void ForwardedOrderAction() throws InterruptedException {
	
		login = new Login();
		login.LoginWithNo();
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
		forward.PartialOrderQnt();


	}

	@Test
	public void CancelOrder() throws InterruptedException {

		login = new Login();
		login.LoginWithNo();
		forward.ClickONToast();
		forward.ClickOnOrdersButton();
		forward.ClickOnRegularOrders();
		forward.SupplierOrdersButtonCLick();
		forward.ListViewToggleClick();
		forward.ForwardedOrderDetailClick();
		forward.ClickOnModifyDropDown();
		forward.CancelOrderClick();
		forward.ClickPopupYesButton();
		forward.SelectReasonToCancel();
		forward.ClickOnConifrmButton();

	}
	
	@Test
	public void PartialOrder() throws InterruptedException {

		
		login = new Login();
		login.LoginWithNo();
		forward = new ForwardedOrderObjects();;
		forward.ClickONToast();
		forward.ClickOnOrdersButton();
		forward.ClickOnRegularOrders();
		forward.SupplierOrdersButtonCLick();
		forward.ListViewToggleClick();
		forward.ForwardedOrderDetailClick();
		forward.ClickOnModifyDropDown();
		forward.PartiallyReceivedClick();
		forward.PartialOrderQnt();
		forward.ClickOnConfirm();
		forward.SelectReasonToCancel();
		forward.ClickOnConifrmButton();
		forward.MarkAsRecievedButtonClick();
		forward.PartialOrderQnt();
		forward.ClickOnConfirm();
		forward.SelectReasonToCancel();
		forward.ClickOnConifrmButton();

		
		
	}

}
