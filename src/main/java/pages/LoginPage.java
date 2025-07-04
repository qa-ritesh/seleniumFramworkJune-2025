package pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.Utility;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	By userName = By.id("email1");
	By password = By.id("password1");
	By loginButton = By.xpath("//button[text()='Sign in']");
	By signIn = By.className("header");
	By footersocialIconList = By.xpath("//div[@class='footer-inside-div']//a");
	By footerSocialIcon = By.xpath("//div[@class='footer-inside-div']//a[1]");
	By facebookPopup = By.id("login_popup_cta_form");

	public DashboardPage loginToApplication(String username, String pw) {
		driver.findElement(userName).sendKeys(username);
		driver.findElement(password).sendKeys(pw);
		driver.findElement(loginButton).click();

		return new DashboardPage(driver);
	}

	public String getSuccessMsgOnLogout() {
		return driver.findElement(signIn).getText();
	}

	public int countFooterSocialIcon() {
		return driver.findElements(footersocialIconList).size();
	}

	public void clicklickOnSocialIcons() {
		Utility.scrollToElement(driver, driver.findElement(footerSocialIcon));
		Utility.pause(2);
		List<WebElement> socialIconsList = driver.findElements(footersocialIconList);
		for (WebElement webElement : socialIconsList) {
			webElement.click();
		}

	}

	public void isSocialWIndowDisplayed(String exp_title) {
		String parentHandle = driver.getWindowHandle();
		Set<String> childWindowHandles = driver.getWindowHandles();
		for (String childHandle : childWindowHandles) {
			if (!childHandle.equals(parentHandle)) {
				driver.switchTo().window(childHandle);
				Utility.pause(2);
				String windowTitle = driver.getTitle();
				if (windowTitle.equalsIgnoreCase(exp_title)) {

					System.out.println(driver.findElement(facebookPopup).isDisplayed());
				} else {
					driver.close();
				}

			}

		}

	}

}
