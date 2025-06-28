package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {

		this.driver = driver;

	}

	// Locator
	By menu = By.xpath("//img[@alt='menu']");
	By signout = By.xpath("//button[text()='Sign out']");
	By welcomeMsg = By.cssSelector(".welcomeMessage");

	public void logoutFromApplication() {
		driver.findElement(menu).click();
		driver.findElement(signout).click();
	}
	
	public boolean isWelcomeMsgDisplayed() {
		return driver.findElement(welcomeMsg).isDisplayed();
	}

}
