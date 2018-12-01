package cn.glory.api3.process;

/*
 * 查看页面元素的属性 webElement.getAttribute()
 * 获取页面元素的CSS属性值 webElement.getCssAttribute()
 */

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class GetElementAttribute {
	
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
	    
    }
  
  

    @AfterMethod
    public void teardown() {
	    driver.quit();
    }

}
