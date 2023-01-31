package SeleniumPractice.Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	static WebDriver driver;

	public static WebDriver BaseWebDriver() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		return driver;
	}
	
	public static String TakeScreenShot(WebDriver driver) throws IOException {

		String fileName = BaseClass.GetRandomFileName(10) + ".png";
		String directory = System.getProperty("user.dir")+ "\\ScreenShots\\";
		
		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File(directory + fileName));
		String fileDestination = directory + fileName;
		return fileDestination;
	}

	public static String GetRandomFileName(int length) {

		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		for (int i = 0; i <=length; i++) {
			int index = (int) ((Math.random()) * characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}

	
}
