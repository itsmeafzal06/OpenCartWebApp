package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.loginPage;
import testBase.BaseClass;
import utilities.DDTUtility;

public class TC003_LoginTestDDT extends BaseClass {
	
	@Test(dataProvider = "LoginData", dataProviderClass = DDTUtility.class)
	public void TestloginDDT(String email,String password,String exp) {
		logger.info("**Test TC002_LoginTest Start**");
		try {
			
			logger.info("**clicking on the login link**");
		HomePage hp = new HomePage(driver);
		hp.click_MyAccount();
		hp.click_Login();
		
		logger.info("**Entering valid credientials**");
		
		loginPage lp = new loginPage(driver);
		lp.email(email);
		lp.password(password);
		lp.clickLogin();
		
		MyAccountPage myacc= new MyAccountPage(driver);
		
		logger.info("**valadiating expected message**");
		
		if(exp.equalsIgnoreCase("valid")) {
			if(myacc.validation().equals("My Account")) {
				myacc.clickLogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("invalid")) {
			if(myacc.validation().equals("My Account")) {
				myacc.clickLogout();
				Assert.assertTrue(false);
			}
			else {
				
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("**TC002_LoginTest finished**");
		
	}
		
}


