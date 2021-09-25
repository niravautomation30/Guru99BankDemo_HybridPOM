package base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import configreader.ConfigPropReader;
import factory.DriverFactory;
import pages.LoginPage;

public class TestBase {

	public DriverFactory df;
	public ConfigPropReader cpr;
	public WebDriver driver;
	public LoginPage loginpage;
	public static Logger logger;

	@BeforeClass
	public void setup() {
		// this two line for log4j
		logger = Logger.getLogger("Guru99BankDemo");
		PropertyConfigurator.configure("./src/test/resources/log4j.properties");

		cpr = new ConfigPropReader();
		df = new DriverFactory();
		driver = df.initDriver(cpr.getBrowser());
	}

	@BeforeMethod
	public void goToLoginPage() {
		driver.get(cpr.getURL());
		loginpage = new LoginPage(driver);
	}

//	@AfterMethod
//	public void takeScreenshotWhenFail(ITestResult result) throws IOException {
//		if (result.getStatus() == ITestResult.FAILURE) {
//			captureScreen(driver, result.getName());
//		}
//	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	public static String randomestring() {
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return (generatedstring);
	}

	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
}
