package cn.glory.api4.js;

/*
 * 
 */

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class HandleIFrame {
	
	WebDriver driver;
	String baseUrl = "http://localhost:8080/gloryroad-base/frameset.html";
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "F:\\devsoft\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
	  }
	
    @Test
    public void handleFrame() {
	    driver.get(baseUrl);
	    driver.switchTo().frame("leftframe");
	    WebElement iframe = driver.findElement(By.tagName("iframe"));
	    
	    driver.switchTo().frame(iframe);
	    WebElement p = driver.findElement(By.xpath("//p"));
	    Assert.assertEquals(p.getText(), "这是iframe页面上的文字");
	    
	    driver.switchTo().defaultContent();
	    
	    driver.switchTo().frame("middleframe");
	    
	    
    }
  
  

    @AfterMethod
    public void teardown() {
	    driver.quit();
    }

}
