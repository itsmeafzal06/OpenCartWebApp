package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

	WebDriver driver;
	
	public RegistrationPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txt_firstName;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txt_lastName;
	@FindBy(xpath="//input[@id='input-email']") WebElement txt_email;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txt_telephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement txt_password;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txt_cnfmPassword;
	@FindBy(xpath="//input[@type='checkbox']") WebElement chkd_policy;
	@FindBy(xpath="//input[@type='submit']") WebElement btn_continue;
	@FindBy(xpath="//div[@id='content']/h1") WebElement txt_forValidation;
	//@FindBy(xpath="//a[normalize-space()='Continue']") WebElement btn_AfterContinue;
	
	public void firstName(String fName) {
		txt_firstName.sendKeys(fName);
	}
	
	public void lastName(String lName) {
		txt_lastName.sendKeys(lName);
	}
	
	public void email(String Email) {
		txt_email.sendKeys(Email);
	}
	
	public void telephone(String Telephone) {
		txt_telephone.sendKeys(Telephone);
	}
	
	public void password(String PW) {
		txt_password.sendKeys(PW);
	}
	
	public void cnfmPassword(String CPW) {
		txt_cnfmPassword.sendKeys(CPW);
	}
	
	public void click_policy() {
		chkd_policy.click();
	}
	
	public void click_continue() {
		btn_continue.click();
	}
	
	public String validation() {
		try{
			return(txt_forValidation.getText());
		}
		catch(Exception e) {
			return(e.getMessage());
		}
	}
	
	
	
	
	
}
