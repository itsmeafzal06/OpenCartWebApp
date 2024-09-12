package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_UserRegistration extends BaseClass {
	

	@Test(groups = {"Sanity","Master"})
	public void TestRegistration() {
		
		logger.info("*** Test Starts TC001_UserRegistration *****");
		try {
		HomePage hp = new HomePage(driver);
		
		hp.click_MyAccount();
		logger.info("*** Clicked On the MyAccount link ***");
		
		hp.click_Register();
		logger.info("*** Clicking On the Registeration user link ***");
		
		RegistrationPage rp = new RegistrationPage(driver);
		
		logger.info("*** Providing new user details ***");
		
		rp.firstName(randomString().toUpperCase());
		rp.lastName(randomString().toUpperCase());
		rp.email(randomString()+"@gmail.com");
		rp.telephone(randomNumber());
		
		String pw=randomAlphaNumber();

		rp.password(pw);
		rp.cnfmPassword(pw);
		rp.click_policy();
		rp.click_continue();
		
		logger.info("**Validating Expected Message**");
		
		if(rp.validation().equals("Your Account Has Been Created!")) {
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
		logger.info("**Finished TC001_UserRegistration **");
	}

}
