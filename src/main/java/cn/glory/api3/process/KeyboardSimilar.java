package cn.glory.api3.process;

/*
 * 
 */

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class KeyboardSimilar {
	
	WebDriver driver;
	String baseUrl = "http://www.sogou.com/";
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "F:\\devsoft\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
	  }
	
    @Test
    public void clickKeyboards() {
	    driver.get(baseUrl);
	    Actions action = new Actions(driver);
//	    按下ctrl键
	    action.keyDown(Keys.CONTROL);
	    action.keyDown(Keys.SHIFT);
	    action.keyDown(Keys.ALT);
//	    释放ctrl键
	    action.keyUp(Keys.CONTROL);
	    action.keyUp(Keys.SHIFT);
	    action.keyUp(Keys.ALT);
	    
    }
  
  

    @AfterMethod
    public void teardown() {
	    driver.quit();
    }

}
