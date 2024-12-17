package AbstractClass;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import TestCases.BaseClass;

public class AbstractClass extends BaseClass {
	
	
	public static void ImplicitWait () {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	public class MultiTabs {
		public void SwitchNewTab(WebDriver driver, String ParentTab) {
			Set<String> NewTabs = driver.getWindowHandles();
			for (String Tab : NewTabs) {
				if (!Tab.equals(ParentTab)) {
					driver.switchTo().window(Tab);

				}
			}
		}

		public void main(String[] args) throws InterruptedException {
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			Actions ac = new Actions(driver);
			String ParentTab = driver.getWindowHandle();
			SwitchNewTab(driver, ParentTab);
			driver.switchTo().window(ParentTab);
			SwitchNewTab(driver, ParentTab);
}
	}
}
