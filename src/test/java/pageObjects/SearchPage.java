package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

	WebDriver driver;
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[.='iPhone']") WebElement item_iphone; 
	
	public String item_iphone() {
		String text=item_iphone.getText();
		return text;
	}

}
