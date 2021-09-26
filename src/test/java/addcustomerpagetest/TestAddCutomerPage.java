package addcustomerpagetest;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pages.AddCustomerPage;
import pages.ManagerHomepage;
import utils.GetTestData;

public class TestAddCutomerPage extends TestBase {

	@Test
	public void testAddCutomerHeader() {
		// login into system 
		ManagerHomepage manager = loginIntoBank();
		
		AddCustomerPage addctmr = manager.clickNewCustomerLink();
		logger.info("Clicked on Add New Customer");
		
		String actHeader = addctmr.getHeader();
		Assert.assertEquals(actHeader, "Add New Customer123", "Invalid Header");
		logger.info("testAddCutomerHeader Pass");
	}

	@Test(dataProvider = "AddCustomerData", dataProviderClass = GetTestData.class)
	public void testAddCutomer(String cname, String gender, String dob, String add, String city, String state,
			String pinno, String mobile, String email, String pwd) {

		// login into system 
		ManagerHomepage manager = loginIntoBank();
		
		AddCustomerPage addctmr = manager.clickNewCustomerLink();
		logger.info("Clicked on Add New Customer");
		
		addctmr.enterName(cname);
		logger.info("Entered customer name");
		
		addctmr.enterGender(gender);
		logger.info("Entered customer gender");
		
		addctmr.enterDob(dob);
		logger.info("Entered customer DOB");
		
		addctmr.enterAdd(add);
		logger.info("Entered customer address");
		
		addctmr.enterCity(city);
		logger.info("Entered customer city");
		
		addctmr.enterState(state);
		logger.info("Entered customer state");
		
		addctmr.enterPinno(pinno);
		logger.info("Entered customer pinno");
		
		addctmr.enterTelephoneno(mobile);
		logger.info("Entered customer mobileno");
		
		addctmr.enterEmailid(email+randomeNum());
		logger.info("Entered customer email");
		
		addctmr.enterPassword(pwd);
		logger.info("Entered customer password");
		
		addctmr.clickSubmit();
		logger.info("Click on Submit Button");
		
		String actMsg = addctmr.getSuccessMsg();
		String customerId = addctmr.getCustomerID();
		logger.info("Customer ID : "+customerId);
		
		Assert.assertEquals(actMsg, "Customer Registered Successfully!!!", "Error while Adding Cutomer.");
		logger.info("testAddCutomer Pass");
	}
}
