package TestCases;

import org.testng.annotations.Test;

import pageObjects.LoginObjects;
import pageObjects.SearchObjects;

public class Search extends BaseClass {
	Login login;
	SearchObjects search;

	@Test
	public void SearchAll() throws InterruptedException {
		login = new Login();
		login.LoginWithNo();
		Thread.sleep(1000);
		search = new SearchObjects();
		search.SearchForCatalogue();
		search.SearchForProduct();
		search.SearchINOrderSummary();
		search.SearchInRegularOrder();
		search.SearchInCustomOrder();
		search.SearchInManageInvetory();
		search.BuyerSearch();

	}

}
