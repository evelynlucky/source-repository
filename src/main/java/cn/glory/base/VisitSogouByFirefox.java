package cn.glory.base;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class VisitSogouByFirefox {
	
	WebDriver driver;
	String baseUrl;
	
  @Test
  public void visitSogouByFirefox() {
	  driver.get(baseUrl + "/");
  }
  
  @BeforeMethod
  public void setUp() {
	  
	  baseUrl = "http://www.sogou.com";
	  //firefox48以下版本必须有gecko驱动
	  //新的 FirefoxDriver,Marionette
	  System.setProperty("webdriver.firefox.marionette", "F:\\devsoft\\browserDriver\\geckodriver.exe");
	  System.setProperty("webdriver.firefox.bin", "E:\\Program files\\Mozilla Firefox\\firefox.exe");
	  driver = new FirefoxDriver();
  }

  @AfterMethod
  public void tearDown() {
	  driver.quit();
  }

}
