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

public class HandleFrame {
	
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
	    WebElement leftFrameText = driver.findElement(By.xpath("//p"));
	    Assert.assertEquals(leftFrameText.getText(), "这是左侧frame页面上的文字");
//	    从左侧Frame中返回到Frameset页面
	    driver.switchTo().defaultContent();
	    
	    driver.switchTo().frame("middleframe");
	    WebElement middleFrameText = driver.findElement(By.xpath("//p"));
	    Assert.assertEquals(middleFrameText.getText(), "这是中间frame页面上的文字");
	    
	    driver.switchTo().defaultContent();
	    
	    driver.switchTo().frame("rightframe");
	    WebElement rightFrameText = driver.findElement(By.xpath("//p"));
	    Assert.assertEquals(rightFrameText.getText(), "这是右侧frame页面上的文字");
	    
	    driver.switchTo().defaultContent();
	    
//	    使用索引方式进入指定的frame页面，索引号从0开始，想进入中间的frame页面，要使用1
	    
	    driver.switchTo().frame(1);
	    middleFrameText = driver.findElement(By.xpath("//p"));
	    Assert.assertEquals(middleFrameText.getText(), "这是中间frame页面上的文字");
	    
    }
  
  

    @AfterMethod
    public void teardown() {
	    driver.quit();
    }

}
