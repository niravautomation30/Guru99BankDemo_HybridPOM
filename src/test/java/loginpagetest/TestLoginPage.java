package loginpagetest;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.Assert;
import base.TestBase;
import pages.ManagerHomepage;

public class TestLoginPage extends TestBase {

	@Test
	public void testLoginWithValidCredential() throws InterruptedException, IOException {		
		logger.info("URL is opened");
		
		loginpage.enterUsername(cpr.getUsername());
		logger.info("Entered username");
		
		loginpage.enterPassword(cpr.getPassword());
		logger.info("Entered password");
		
		ManagerHomepage manager = loginpage.clickLoginBtn();
		
		String actManagerID = manager.getManagerID();
		
		Assert.assertEquals(actManagerID, "Manger Id : mngr355479", "Invalid Manager Id");
		
		manager.clickLogout();
	}
	
	@Test
	public void testLoginWithInvalidCredential() {	
		loginpage.enterInvalidCredential("asd","123");
		loginpage.clickLoginBtn();
	}
}
