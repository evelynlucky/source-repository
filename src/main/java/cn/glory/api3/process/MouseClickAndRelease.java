package cn.glory.api3.process;

/*
 * 在指定元素上进行鼠标单击（不释放，区别click()）左键和释放的操作
 *  clickAndHold()方法, release()方法
 */

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class MouseClickAndRelease {
	
	WebDriver driver;
	String baseUrl = "http://www.sogou.com/";
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "F:\\devsoft\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
	  }
	
    @Test
    public void visitSogouByChrome() throws InterruptedException {
	    driver.get(baseUrl);
	    WebElement div = driver.findElement(By.xpath(""));
	    Actions action = new Actions(driver);
//	    clickAndHold()方法，单击鼠标不释放
	    action.clickAndHold(div).perform();
	    Thread.sleep(3000);
//	    release方法，释放鼠标左键
	    action.release(div).perform();
	    Thread.sleep(3000);
	    
    }
  
  

    @AfterMethod
    public void teardown() {
	    driver.quit();
    }

}
