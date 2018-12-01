package cn.glory.api1.page_elemet;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

/*
 * 1. 获取页面的Title属性 getTitle()
 * 2. 获取页面源代码 getPageSource()
 * 3. 获取当前页面的URL地址 getCurrentUrl()
 * 4. 在输入框清除原有的文字内容 clear()
 * 5. 在输入框输入指定内容 sendKeys()
 * 6. 单击按钮 click()
 * 7. 双击某个元素 doubleClick()
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetSource {
	public WebDriver driver;
	public String baseUrl = "http://www.sogou.com";
	
	@BeforeMethod
	public void BeforeTest() {
		System.setProperty("webdriver.firefox.marionette", "F:\\devsoft\\browserDriver\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "E:\\firefox\\firefox.exe");
		driver = new FirefoxDriver();
	}
	
	@Test
	public void operateBrowserWindow() {
		driver.get(baseUrl);
		
//		 1. 获取页面的Title属性
//		String title = driver.getTitle();
//		System.out.println(title);
//		断言页面title是否是“搜狗搜索引擎-上网从搜狗开始”
//		Assert.assertEquals(title, "搜狗搜索引擎 - 上网从搜狗开始");
		
//		2. 获取页面源代码 getPageSource()
//		String pageSource = driver.getPageSource();
//		System.out.println(pageSource);
//		Assert.assertTrue(pageSource.contains("购物"));
		
//		3. 获取当前页面的URL地址 getCurrentUrl()
//		4. 在输入框清除原有的文字内容 clear()
//		5. 在输入框输入指定内容 sendKeys()
//		6. 单击按钮 click()
//		7. 双击某个元素 doubleClick()
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		assertEquals(currentUrl, "https://www.sogou.com/");
		WebElement inputbox = driver.findElement(By.id("query"));
		inputbox.sendKeys("你好");
		inputbox.clear();
		inputbox.sendKeys("我爱你");
		driver.findElement(By.id("stb")).click();
		
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@AfterMethod
	public void afterTest() {
		driver.quit();
	}
}
