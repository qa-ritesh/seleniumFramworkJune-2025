package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginApplication extends BaseClass {

	LoginPage login = null;

	@Test(priority = 1)
	public void loginWithValidCreds() {

		login = new LoginPage(driver);
		DashboardPage dashboard = login.loginToApplication("admin@email.com", "admin@123");

		Assert.assertTrue(dashboard.isWelcomeMsgDisplayed(), "*** Login Failed ***");

		dashboard.logoutFromApplication();

		Assert.assertTrue(login.getSuccessMsgOnLogout().contains("Sign In"), "*** Logout Failed ***");
	}

	@Test(priority = 2)
	public void validateFooterSocialIcons() {
		Assert.assertEquals(login.countFooterSocialIcon(), 4, "*** Footer Icons Mismatch ***");

	}

	@Test(priority = 3)
	public void clickOnFooterLink() {
		/*
		 * Get the icon via List Iterate and Perform Click Use getWindowHnadlws and
		 * capture all window id Iterate Window Handles and capture Some text from each
		 * window to Assert correct landing close
		 */
		login.clicklickOnSocialIcons();
		login.isSocialWIndowDisplayed("Selenium Webdriver questions and answers | Facebook");

	}

}
