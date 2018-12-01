package cn.glory.api4.js;

/*
 * 使用页面的文字内容识别和处理新弹出的浏览器窗口
 *  1. String parentWindowHandle = driver.getWindowHandle();
 *  2. 弹出窗口后，Set<String> allWindowHandles = driver.getWindowHandles();
 *  3. driver.switchTo().window(parentWindowHandle);
 */

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class IdentifyPopUpWindowByPageSource {
	
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
	    String parentWindowHandle = driver.getWindowHandle();
	    WebElement sogouLink = driver.findElement(By.xpath("//a"));
	    sogouLink.click();
	    Set<String> allWindowHandles = driver.getWindowHandles();
	    try {
			if(!allWindowHandles.isEmpty()) {
				for(String windowHandle:allWindowHandles) {
					if(driver.switchTo().window(windowHandle).getPageSource().contains("搜狗搜索")) {
						driver.findElement(By.id("query")).sendKeys("sogou首页的浏览器窗口被找到");
					}
				}
			}
		} catch (NoSuchWindowException e) {
			e.printStackTrace();
		}
	    //返回到最开始的浏览器页面
	    driver.switchTo().window(parentWindowHandle);
	    //断言Title，以判断页面的切换是否符合期望
	    Assert.assertEquals(driver.getTitle(), "你喜欢的水果");
    }
  
  

    @AfterMethod
    public void teardown() {
	    driver.quit();
    }

}
