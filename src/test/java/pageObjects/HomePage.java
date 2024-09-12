package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		super(driver);	
	}
	
	@FindBy(xpath="//span[.='My Account']")	WebElement btn_MyAccount;
	@FindBy(xpath="//a[.='Register']") WebElement btn_Register;
	@FindBy(xpath="//a[.='Login']") WebElement btn_Login;
	@FindBy(xpath="//input[@name='search']") WebElement txt_search;
	@FindBy(xpath="//div[@id='search']//button") WebElement btn_search;
	
	public void click_MyAccount() {
		btn_MyAccount.click();
	}
	
	public void click_Register() {
		btn_Register.click();
	}
	
	public void click_Login() {
		btn_Login.click();
	}
	
	public void txt_SearchBar(String item) {
		txt_search.sendKeys(item);
	}
	
	public void click_SearchIcon() {
		btn_search.click();
	}
	
}
