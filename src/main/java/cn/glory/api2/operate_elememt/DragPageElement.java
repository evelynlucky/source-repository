package cn.glory.api2.operate_elememt;

/*
 * 拖拽页面元素
 * http://jqueryui.com/resources/demos/draggable/scroll.html
 */

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class DragPageElement {
	
	WebDriver driver;
	String baseUrl = "http://jqueryui.com/resources/demos/draggable/scroll.html";
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "F:\\devsoft\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
	  }
	
    @Test
    public void visitSogouByChrome() throws InterruptedException {
	    driver.get(baseUrl);
	    WebElement draggable = driver.findElement(By.xpath("//div[2]"));
//	    向下拖动十个像素，共拖动五次,0代表横坐标不变，10代表向下移动10个像素
	    for(int i = 0; i < 5; i++) {
	    	new Actions(driver).dragAndDropBy(draggable, 0, 10).build().perform();
	    }
	    Thread.sleep(3000);
//	    向右拖动8个像素,共拖动5次
	    for(int i = 0; i < 5; i++) {
	    	new Actions(driver).dragAndDropBy(draggable, 8, 0).build().perform();
	    }
	    Thread.sleep(3000);
    }
  
  

    @AfterMethod
    public void teardown() {
	    driver.quit();
    }

}
