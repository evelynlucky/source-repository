package cn.glory.api4.js;

/*
 * 使用Frame中的HTML源码内容来操作Frame
 */

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class HandleFrameByPageSource {
	
	WebDriver driver;
	String baseUrl = "http://localhost:8080/gloryroad-base/frameset.html";
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "F:\\devsoft\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
	  }
	
    @Test
    public void testHandleFrameByPageSource() {
	    driver.get(baseUrl);
	   List<WebElement> frames = driver.findElements(By.tagName("frame"));
	   for(WebElement frame:frames) {
		   driver.switchTo().frame(frame);
		   if(driver.getPageSource().contains("中间frame")) {
			   WebElement middleFrameText = driver.findElement(By.xpath("//p"));
			   Assert.assertEquals(middleFrameText.getText(), "这是中间frame页面上的文字");
			   break;
		   } else {
			   driver.switchTo().defaultContent();
		   }
	   }
	   driver.switchTo().defaultContent();
    }
  
  

    @AfterMethod
    public void teardown() {
	    driver.quit();
    }

}
