package SeleniumPractice.Utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageScreenShot {

	WebDriver driver;
	@BeforeMethod
	public void OpenBrowser() {
		driver = BaseClass.BaseWebDriver();
	}

	@Test(alwaysRun = true)
	public void TakeScreenShot() throws IOException {
		driver.get("https://github.com/");
		BaseClass.TakeScreenShot(driver);		
			
	}

	@AfterMethod
	public void CloseBrowser() {
		driver.close();
	}

}
