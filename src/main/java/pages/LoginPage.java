package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
	By socialIcon = By.xpath("//div[@class='footer-inside-div']//a");

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
		return driver.findElements(socialIcon).size();
	}

}
