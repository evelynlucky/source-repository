package cn.glory.api1.page_elemet;

/* 1. 访问网页地址
 * 2. 网页回退
 * 3. 网页前进
 * 4. 网页刷新
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageManipulate {
	public WebDriver driver;
	public String baseUrl = "http://www.sogou.com";
	
	@BeforeMethod
	public void BeforeTest() {
		System.setProperty("webdriver.firefox.marionette", "F:\\devsoft\\browserDriver\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "E:\\firefox\\firefox.exe");
		driver = new FirefoxDriver();
	}
	
	@Test
	public void pageTest() {
		
		//1.访问某网页地址
		 //方法1： get()
//		driver.get(baseUrl + "/");
		 //方法2：navigate().to()
//		driver.navigate().to(baseUrl);
		
//		2.返回上一个访问的网页（模拟单击浏览器的后退功能）
//		driver.get(baseUrl);
//		driver.get("http://www.baidu.com");
//		driver.navigate().back();
		
//		3.从上次访问网页前进到下一个网页（模拟单击浏览器的前进功能）
//		driver.get(baseUrl);
//		driver.get("http://www.baidu.com");
//		driver.navigate().back();
//		driver.navigate().forward();
		
//		4.刷新网页
//		Navigation类： An abstraction allowing the driver to access the browser's history 
//		and to navigate to a given URL.
//		driver.get(baseUrl);
//		driver.navigate().refresh();
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void afterTest() {
		driver.quit();
	}
}
