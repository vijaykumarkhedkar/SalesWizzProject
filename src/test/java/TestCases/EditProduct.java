package TestCases;

import org.testng.annotations.Test;

import Utilities.FetchData;
import pageObjects.Catalogue;
import pageObjects.EditProductObjects;
import pageObjects.LoginObjects;

public class EditProduct extends BaseClass {


	Catalogue add;
	EditProductObjects edit;
	FetchData data;
	Login login;

	@Test
	public void Edit() throws InterruptedException {

	
		login = new Login();
		login.LoginWithNo();
		add = new Catalogue();
		add.AddCatalogueName();
		add.UploadImage();
		Thread.sleep(2000);
		edit = new EditProductObjects();
		edit.ClickOnEditIcon();

	}
}