package TestCases;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Utilities.FetchData;

public class BaseClass {

	public static WebDriver driver;
	FetchData data = new FetchData();
	public String url = data.GetURL();

	public WebDriver initializeDriver() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;

	}

	@BeforeMethod
	public void LaunchApp() throws IOException {
		driver = initializeDriver();

	}

}

/*
 * public List<HashMap<String, String>> getJsonData(String filepath) throws
 * IOException { // read JSON to String String jsondata =
 * FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
 * 
 * // String to Hashmap jackson databind
 * 
 * ObjectMapper mapper = new ObjectMapper(); List<HashMap<String, String>> data
 * = mapper.readValue(jsondata, new TypeReference<List<HashMap<String,
 * String>>>() {
 * 
 * }); return data;
 */
