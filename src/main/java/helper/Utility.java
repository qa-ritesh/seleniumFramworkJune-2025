package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Utility {

	public static void pause(int n) {
		try {
			Thread.sleep(n * 1000);
		} catch (InterruptedException e) {
			System.out.println("Exception at pause ===> " + e.getMessage());
		}
	}

	// Actions Class Method

	public static void scrollToElement(WebDriver driver, WebElement element) {
		new Actions(driver).scrollToElement(element).perform();
	}

}
