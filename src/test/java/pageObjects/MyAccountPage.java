package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	WebDriver driver;
	
	public MyAccountPage(WebDriver driver) {
		super(driver);	
	}

	@FindBy(xpath="//h2[.='My Account']") WebElement title_MyAcc;
	@FindBy(xpath="//aside[@id='column-right']//a[13]") WebElement btn_logout;
	
	public String validation() {
		String title=title_MyAcc.getText();
		return title;
	}
	
	public void clickLogout() {
		btn_logout.click();
	}
	
}
