package cn.glory.api4.js;

/*
 * 使用Title属性识别和操作新弹出的浏览器窗口
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

public class IdentifyPopUpWindowByTitle {
	
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
	    
	    //获取当前所有打开窗口的Handle,把它们存储到一个Set集合中
	    Set<String> allWindowHandles = driver.getWindowHandles();
	    try {
			if(allWindowHandles.isEmpty()) {
				for(String windowHandle: allWindowHandles) {
					if(driver.switchTo().window(windowHandle)
							.getTitle().equals("搜狗搜索引擎 - 上网从搜狗开始")) {
						driver.findElement(By.id("query")).sendKeys("搜狗首页的浏览器窗口被找到");
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
