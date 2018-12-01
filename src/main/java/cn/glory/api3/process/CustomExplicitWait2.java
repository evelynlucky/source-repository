package cn.glory.api3.process;

/*
 * 自定义显示等待，实际就是自定义一个ExpectedCondition
 * 
 * 显式等待判断页面的ajax请求是否加载完成，可以继续执行测试脚本进行后续测试逻辑的判断
 */

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class CustomExplicitWait2 {
	
	WebDriver driver;
	String baseUrl = "http://www.sogou.com/";
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "F:\\devsoft\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
	  }
	
    @Test
    public void customExplicitWait() {
	    driver.get(baseUrl);
	    (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver d) {
				JavascriptExecutor  js = (JavascriptExecutor) d;
//				ajax加载完成，jQuery.active=0 为true
				return (Boolean) js.executeScript("return jQuery.active=0");
			}
		});
    }
  
  

    @AfterMethod
    public void teardown() {
	    driver.quit();
    }

}
