package cn.glory.api3.process;

/*
 * 单击鼠标右键
 */

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class RightClickMouse {
	
	WebDriver driver;
	String baseUrl = "http://www.sogou.com/";
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "F:\\devsoft\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
	  }
	
    @Test
    public void visitSogouByChrome() {
	    driver.get(baseUrl);
	    Actions action = new Actions(driver);
//	    contextClick方法单击鼠标右键
	    action.contextClick(driver.findElement(By.id("query"))).perform();;
    }
  
  

    @AfterMethod
    public void teardown() {
	    driver.quit();
    }

}
