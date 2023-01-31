package SeleniumPractice.Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basedriver {
	static WebDriver driver;
    public static WebDriver BaseWebDriver(){
    	 driver = new ChromeDriver();
    	 driver.manage().window().maximize();
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    	 return driver;
    }
    
}
