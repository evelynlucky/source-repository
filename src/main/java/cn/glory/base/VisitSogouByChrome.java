package cn.glory.base;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class VisitSogouByChrome {
	
	WebDriver driver;
	String baseUrl;
	
  @Test
  public void visitSogouByChrome() {
	  driver.get(baseUrl + "/");
  }
  
  @BeforeMethod
  public void setup() {
	  baseUrl = "http://www.sogou.com";
	  System.setProperty("webdriver.chrome.driver", "F:\\devsoft\\browserDriver\\chromedriver.exe");
	  driver = new ChromeDriver();
  }

  @AfterMethod
  public void teardown() {
	  driver.quit();
  }

}
