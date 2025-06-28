package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import helper.ConfigUtility;

public class BaseClass {

	public WebDriver driver = null;

	@BeforeClass
	public void setup() {
		Reporter.log("*** Chrome Browser Initiating ***", true);
		driver = new ChromeDriver();
		Reporter.log("*** Chrome Browser Started ***", true);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Reporter.log("*** Reading Config File For QA Env Setup ***", true);
		driver.get(ConfigUtility.getPropertyValue("qaenv"));
	}

	@AfterClass
	public void tearDown() {
		Reporter.log("*** Chrome Browser Closing ***", true);
		driver.quit();
		Reporter.log("*** Chrome Browser Closed ***", true);
	}

}
