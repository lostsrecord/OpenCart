package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class LoginTest extends BaseClass {

	@Test(groups = {"Regression","Master"})
	public void validateLogin() {

		logger.info("********* Starting Login Test *********");
		logger.debug("capturing application debug logs......");

		try {
			// Homepage
			HomePage homePage = new HomePage(driver);
			homePage.clickOnMyAccount();
			homePage.clickOnLogin();
			logger.info("********* Clicked On Login Link Under My Account *********");

			// LoginPage
			LoginPage loginPage = new LoginPage(driver);
			logger.info("********* Adding Credentials *********");
			loginPage.setEmail(prop.getProperty("email"));
			loginPage.setPassword(prop.getProperty("password"));
			loginPage.clicklogin();
			logger.info("********* Clicked On Login Button *********");

			// My Account Page
			MyAccountPage myAcctPage = new MyAccountPage(driver);
			boolean displayStatusMyAcctPage = myAcctPage.isMyAccountPageExist();

			Assert.assertEquals(displayStatusMyAcctPage, true, "Login Failed");
		} catch (Exception e) {
			Assert.fail();
		} finally {
			logger.info("******* Login Test Completed *********");
		}

	}

}
