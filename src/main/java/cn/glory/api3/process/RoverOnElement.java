package cn.glory.api3.process;

/*
 * 在指定元素上方进行鼠标悬浮
 */

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class RoverOnElement {
	
	WebDriver driver;
	String baseUrl = "http://www.xinhuanet.com/";
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "F:\\devsoft\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
	  }
	
    @Test
    public void visitSogouByChrome() throws InterruptedException {
	    driver.get(baseUrl);
	    WebElement target = driver.findElement(By.xpath("//a[text()=\" 时政 \"]"));
	    WebElement target2 = driver.findElement(By.xpath("//a[text()=\" 地方 \"]"));
	    Actions action = new Actions(driver);
	    action.moveToElement(target).perform();
	    Thread.sleep(5000);
	    action.moveToElement(target2).perform();
	    Thread.sleep(5000);
    }
  
  

    @AfterMethod
    public void teardown() {
	    driver.quit();
    }

}
