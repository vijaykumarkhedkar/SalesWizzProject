package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;

import TestCases.BaseClass;

public class CatalogueShare extends BaseClass {

	By ShareCatalogue = By.xpath("(//img[@src='../assets/salesWizz/images/sharebtn.svg'])[1]");
	By description = By.xpath("//textarea[@placeholder=\"Write any description that buyer needs to know\"]");
	By ExpiresIn = By.xpath("//input[@text='text']");
	By ShareButton = By.xpath("//p[.='Share']");
	By CopyLink = By.xpath("//img[@src='../assets/salesWizz/images/copyLink.svg']");

	public void ShareCatalogueLink() {
		driver.findElement(ShareCatalogue).click();
		driver.findElement(description)
				.sendKeys("Hi, look at our products and Place an Order if you intersted, Thank you");
		driver.findElement(ExpiresIn).sendKeys("30");
		driver.findElement(ShareButton).click();
		driver.findElement(CopyLink).click();

	}


	public void OpenNewTab() {
		driver.switchTo().newWindow(WindowType.TAB);
		String Catalogue1 = "https://saleswizz-catalog.dizital360.com/catalog/Qa123@gmail.com/66684fb714691918a8bd8920";
		driver.get(Catalogue1);
	}

}
