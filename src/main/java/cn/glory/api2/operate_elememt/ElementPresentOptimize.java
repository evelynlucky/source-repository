package cn.glory.api2.operate_elememt;

/*
 * 检查页面元素的文本内容是否出现
 */

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class ElementPresentOptimize {
	
	WebDriver driver;
	String baseUrl = "file:///H:/testing/webElement.html";
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "F:\\devsoft\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
	  }
	
	private Boolean isElementPresent(By by) {
		 try {
			 driver.findElement(by);
			 return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
    @Test
    public void isElementTextPresent() throws InterruptedException {
	    driver.get(baseUrl);
	    if(isElementPresent(By.id("query"))) {
	    	WebElement text = driver.findElement(By.id("query"));
	    	if(text.isEnabled()==true) {
	    		text.sendKeys("搜狗首页的搜索输入框被成功找到");
	    	}
	    }
    }

    @AfterMethod
    public void teardown() {
	    driver.quit();
    }

}
