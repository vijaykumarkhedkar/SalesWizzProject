package pageObjects;

import org.openqa.selenium.By;

import TestCases.BaseClass;
import Utilities.FetchData;

public class EditProductObjects extends BaseClass {
	
	FetchData data;

	By EditIcon = By.xpath("(//img[@alt='edit'][1])");
	By ProductTitle = By.xpath("//input[@formcontrolname='title']");
	By SKU = By.xpath("//input[@formcontrolname='sku']");
	By UOM = By.xpath("//input[@formcontrolname='unitOfMeasureValue']");
	By Carats = By.xpath("//input[@formcontrolname='carats']");
	By Price = By.xpath("//input[@formcontrolname='price']");
	By Category = By.xpath("//input[@formcontrolname='catagorie']");
	By Description = By.xpath("//textarea[@formcontrolname='description']");
	By SaveButton= By.xpath("//Button[.='Save']");
	By CloseIcon= By.xpath("//i[@class='fa fa-close']");

	public void ClickOnEditIcon() {
		data= new FetchData();
		String ProductDescp=data.GetProdescrp();
		driver.findElement(EditIcon).click();
		driver.findElement(ProductTitle).sendKeys("Sample Product");
		driver.findElement(UOM).sendKeys("5.99");
		driver.findElement(SKU).sendKeys("ABCD1234");
		driver.findElement(Carats).sendKeys("12");
		driver.findElement(Price).sendKeys("12999");
		driver.findElement(Category).sendKeys("Gold ring");
		driver.findElement(Description).sendKeys(ProductDescp);
		driver.findElement(SaveButton).click();
		driver.findElement(CloseIcon).click();
			
	}

}
