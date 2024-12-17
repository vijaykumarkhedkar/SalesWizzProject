package pageObjects;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestCases.BaseClass;

public class Catalogue extends BaseClass {

	By SearchCatalogue = By.xpath("//input[@placeholder='Search catalogue by name']");
	By AddNewcatalogue = By.xpath("//div//button[@class='submitBtn primaryButton']");
	By AddCtalogueName = By.xpath("//input[@placeholder='Enter group name']");
	By SaveButton = By.xpath("//p[@class='primaryColor']");
	By Upload = By.xpath("//input[@type='file' and @placeholder='Upload file' ]");
	By AddProduct = By.xpath("//button[@class='submitBtn primaryButton']");
	By Select1 = By.xpath("(//input[@type='checkbox'])[1]");
	By Select2 = By.xpath("(//input[@type='checkbox'])[2]");
	By DeleteIcon = By.xpath("//div[@class='icons ng-star-inserted']");
	By YesButton = By.xpath("//div[@class='mat-dialog-actions']//span[.='Yes']");
	By BackButton = By.xpath("//img[@src='../../assets/salesWizz/images/backicon.svg']");
	By SelectAllCatalogue = By.xpath("(//input[@type='checkbox'])[1]");
	By EditIcon = By.xpath("(//img[@src='../assets/salesWizz/images/EditCat.svg'])[1]");
	By CatalogueName = By.xpath("//input[@formcontrolname='name']");

     	public void AddCatalogueName() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(SearchCatalogue).sendKeys("helooo vijay");
		driver.findElement(AddNewcatalogue).click();
		driver.findElement(AddCtalogueName).sendKeys("CarCollections12");
		driver.findElement(SaveButton).click();

	}

	public void UploadImage() {

		String imagePath = "C:\\Users\\mrk\\Desktop\\mala.jpg";
		driver.findElement(Upload).sendKeys(imagePath);

	}

	public void AddNewProduct() {
		driver.findElement(AddProduct).click();
		driver.findElement(Upload).sendKeys("C:\\Users\\mrk\\Desktop\\item55\\model.jpg");

	}

	public void DeleteProducts() {
		driver.findElement(Select1).click();
//		driver.findElement(Select2).click();
		driver.findElement(DeleteIcon).click();
		driver.findElement(YesButton).click();
	}

	public void DeleteAllCatalogue() {
		driver.findElement(BackButton).click();
		driver.findElement(SelectAllCatalogue).click();
		driver.findElement(DeleteIcon).click();
		driver.findElement(YesButton).click();
	}

	public void EditCatalogueName() {
		driver.findElement(EditIcon).click();
		driver.findElement(CatalogueName).clear();
		driver.findElement(CatalogueName).sendKeys("jewellaryCollections");
		driver.findElement(SaveButton).click();

	}
}