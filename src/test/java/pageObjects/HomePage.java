package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	//Elements
	//WebElement title= driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a"));
	@FindBy(xpath="//*[@id=\'top-links\']/ul/li[2]/a")
	WebElement lnkMyaccount;
	
	@FindBy(xpath="//*[@id=\'top-links\']/ul/li[2]/ul/li[1]/a")
	WebElement lnkRegister;
	
	@FindBy(linkText="Login")
	WebElement lnkLogin;
	
	
	
	//Action Methods
	public void clickMyAccount() {
		lnkMyaccount.click();
	}
	public void reqistclickRegister() {
		lnkRegister.click();
	}
	public void clickLogin()
	{
		lnkLogin.click();
	}
	
	
}

