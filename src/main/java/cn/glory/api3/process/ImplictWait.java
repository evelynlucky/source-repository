package cn.glory.api3.process;

/*
 * 隐式等待
 * 使用implicitlyWait方法设定查找页面元素的最大等待时间
 * 调用findElement方法是没有立刻找到元素
 * 则程序会每隔一段时间后不断尝试判断页面的DOM中是否出现被查找元素
 * 超过时长，跑出NoSuchElementException异常
 */

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ImplictWait {
	
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
//		隐式等待方法 implicitlyWait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		try {
			WebElement searchInput = driver.findElement(By.id("query"));
			WebElement searchButton = driver.findElement(By.id("stb"));
			searchInput.sendKeys("输入框被成功找到了");
			searchButton.click();
		} catch (NoSuchElementException e) {
			Assert.fail("没有找到搜索的输入框");
		}
	    
    }

    @AfterMethod
    public void teardown() {
	    driver.quit();
    }

}
