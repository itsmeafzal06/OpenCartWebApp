package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC004_SearchTest extends BaseClass {
	
	@Test(groups = {"Sanity","Master"})
	public void searchTest() {
	
		logger.info("*** Test Starts TC004_SearchTest *****");
		try {
		HomePage hp = new HomePage(driver);
		
		logger.info("*** Clicked On the Search bar ***");
		
		hp.txt_SearchBar("iphone");
		hp.click_SearchIcon();
		
		SearchPage sp = new SearchPage(driver);
		
		logger.info("**Validating Expected Message**");
		
		if(sp.item_iphone().equalsIgnoreCase("iphone"))
		{
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
		logger.info("**Finished TC004_SearchTest **");
	}
	

}
