package SeleniumPractice.Utilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinks {
	WebDriver driver;
	String url;
	HttpsURLConnection huc;
	int responseCode;
	String Homepage = "https://www.gmail.com/";

	@BeforeMethod
	public void openPage() {
		driver = Basedriver.BaseWebDriver();
	}
	
	@Test
	public void ValidateBrokenLinks() {
		driver.get(Homepage);

		List<WebElement> links = driver.findElements(By.tagName("a"));
		Iterator<WebElement> It = links.iterator();
		while (It.hasNext()) {
			url = It.next().getAttribute("href");
			System.out.println(url);

			if (url.isEmpty() || url == null) {
				System.out.println("url is empty or null");
			}
			if (!url.startsWith(Homepage)) {
				System.out.println("url belongs to other domain or not configured well");
			}

			try {
				huc = (HttpsURLConnection) (new URL(url).openConnection());

				huc.setRequestMethod("HEAD");
				huc.connect();
				
				responseCode = huc.getResponseCode();
				String message = huc.getResponseMessage();
				if (responseCode >= 400) {
					System.out.println(message + " " + url + " is broken \n");
				} else {
					System.out.println(message + " " + url + " is valid \n");
				}

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
