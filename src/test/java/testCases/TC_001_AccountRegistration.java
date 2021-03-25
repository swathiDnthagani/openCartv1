package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass{
		
	
	@Test//(groups={"regression","master"})
	public void test_account_Registration() {
	
	try {	
		driver.get(rb.getString("appURL"));
		logger.info("HomePage Displayed");		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on Title");
		hp.reqistclickRegister();
		logger.info("Clicked on Register");
		
		RegistrationPage regpage=new RegistrationPage(driver);
		logger.info("personal details");
		regpage.setFirstName("John");
		regpage.setLastName("Canedy");
		regpage.setEmail(randomestring()+"@gmail.com");
		regpage.setTelephone("65656565");
		regpage.setPassword("abcxyz");
		regpage.setConfirmPassword("abcxyz");
		regpage.setPrivacyPolicy();
		
		regpage.clickContinue();
		
		String confmsg=regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("Accout Registation " + "Success");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Accout Registation " + "Fail");
			Assert.assertTrue(false);
		}	
		
	}
	catch(Exception e) {
		logger.fatal("Accout Registation Failed");
		Assert.fail();
	}
  }
	
}
