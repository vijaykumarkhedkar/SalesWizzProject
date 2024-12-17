package TestCases;

import java.time.Duration;

import org.testng.annotations.Test;

import pageObjects.Catalogue;
import pageObjects.LoginObjects;

public class AddCatalogue extends BaseClass {

	Login login;
	Catalogue add;

	@Test
	public void CreateNewCatalogue() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		login = new Login();
		login.LoginWithNo();
		add = new Catalogue();
		add.AddCatalogueName();
		add.UploadImage();
		Thread.sleep(2000);
		add.AddNewProduct();

	}

	@Test
	public void DeleteCatalogue() throws InterruptedException {
		login = new Login();
		login.LoginWithNo();
		add = new Catalogue();
		add.DeleteProducts();
		add.DeleteAllCatalogue();

	}

	@Test

	public void EditCatalogueName() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		login = new Login();
		login.LoginWithNo();
		Catalogue add = new Catalogue();
		add.EditCatalogueName();
	}
		
		@Test
		public void m() {
			
		}

	}
