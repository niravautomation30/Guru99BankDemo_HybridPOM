package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import configreader.ConfigPropReader;

public class LoginPage {

	private WebDriver driver;
	private By username = By.xpath("//input[@name='uid']");
	private By password = By.xpath("//input[@name='password']");
	private By login = By.xpath("//input[@name='btnLogin']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUsername(String uname) {
		driver.findElement(username).sendKeys(uname);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void enterInvalidCredential(String un,String  pass) {
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pass);
	}

	public ManagerHomepage clickLoginBtn() {
		driver.findElement(login).click();
		boolean alert = isAlertPresent();
		if (alert) {
			driver.switchTo().alert().accept();
		}
		return new ManagerHomepage(driver);
	}
	
	public boolean isAlertPresent() {
		boolean flag = false;
		try {
			String altText = driver.switchTo().alert().getText();
			System.out.println("Alert Text : "+altText);
			flag = true;
		} catch (Exception e) {
			flag=false;
		}
		
		return flag;
	}
}
