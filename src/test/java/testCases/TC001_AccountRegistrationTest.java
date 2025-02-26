package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups = "Sanity")
	public void verify_account_registration() throws InterruptedException {
		logger.info("***** Starting TC001_AccountRegistrationTest*****");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("***** Clicked on My Account *****");
		Thread.sleep(6000);
		hp.clickRegister();
		logger.info("***** Clicked on Registered link *****");
		
		
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		logger.info("***** Providing customer Details *****");
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		
		String password = randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setPrivacyPolicy();
		regpage.setContinue();
		logger.info("***** Validating Expected Message.. *****");
		String msg = regpage.getConfirmationMsg();
		Assert.assertEquals(msg, "Your Account Has Been Created!");
		
		}
		catch(Exception e) {
			logger.error("Test Failed...");
			logger.debug("Debug logs...");
			Assert.fail();
		}
		logger.info("***** Finished *****");
	}
	
	
	
	
}
