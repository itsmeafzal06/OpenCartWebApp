package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage {

	WebDriver driver;
	
	public loginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']") WebElement txt_Email;
	@FindBy(xpath="//input[@id='input-password']") WebElement txt_Password;
	@FindBy(xpath="//input[@value='Login']") WebElement btn_login;
	
	public void email(String email) {
		txt_Email.sendKeys(email);
	}
	
	public void password(String pw) {
		txt_Password.sendKeys(pw);
	}
	
	public void clickLogin() {
		btn_login.click();
	}
	
	
}
