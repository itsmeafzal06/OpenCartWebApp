package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.loginPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	public Properties p;
	
	@Test(groups = "Master")
	void loginTest() throws IOException {
		
		logger.info("**Test TC002_LoginTest Start**");
		try {
			
			logger.info("**clicking on the login link**");
		HomePage hp = new HomePage(driver);
		hp.click_MyAccount();
		hp.click_Login();
		
		logger.info("**Reading file from the properties file**");
		
		p= new Properties();
		FileInputStream file= new FileInputStream("./src//test//resources//confi.properties");
		p.load(file);
		
		logger.info("**Entering valid credientials**");
		
		loginPage lp = new loginPage(driver);
		lp.email(p.getProperty("email"));
		lp.password(p.getProperty("password"));
		lp.clickLogin();
		
		MyAccountPage myacc= new MyAccountPage(driver);
		
		logger.info("**valadiating expected message**");
		
		if(myacc.validation().equals("My Account")) {
			Assert.assertTrue(true);
			
		}
		else {
			logger.error("**Test Failed**");
			logger.debug("Debug logs...");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("**TC002_LoginTest finished**");
		
	}
}
