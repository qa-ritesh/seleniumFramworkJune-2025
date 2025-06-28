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

}
