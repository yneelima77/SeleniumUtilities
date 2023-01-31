package SeleniumPractice.Utilities;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownSelection {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver =  BaseClass.BaseWebDriver();
		
		driver.get("https://courses.letskodeit.com/practice");
		
		WebElement cars_dropDown = driver.findElement(By.id("carselect"));
		
		//selecting single select
		Select dropDown = new Select(cars_dropDown);
		
		dropDown.selectByVisibleText("BMW");
		dropDown.selectByIndex(2);
		dropDown.selectByValue("honda");
				
		//getting all options in dropdown
		List<WebElement> getAlloptions = dropDown.getOptions();
		for(WebElement option: getAlloptions) {
			System.out.println(option.getText());
		}
		
		//multi select
		Select multiSelect = new Select(driver.findElement(By.id("multiple-select-example")));
		
		List<WebElement> options = multiSelect.getOptions();
		
		for(int i=0;i<options.size();i++) {
			multiSelect.selectByIndex(i);
			List<WebElement> deselect = multiSelect.getAllSelectedOptions();
			for(WebElement ds : deselect) {
				System.out.println("selected Option: "+ds.getText());
			}
			Thread.sleep(2000);
			multiSelect.deselectByIndex(i);
		}
		
		Thread.sleep(3000);
		driver.close();

	}

}
