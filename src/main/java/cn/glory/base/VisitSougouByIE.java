package cn.glory.base;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;

public class VisitSougouByIE { 
	
	public WebDriver driver;
	public String baseUrl;

  @Test
  public void visitSogou() {
	  driver.get(baseUrl + "/");
  }
  
  
  @BeforeMethod
  public void setUp() {
	  baseUrl = "http://www.sogou.com";
	  System.setProperty("webdriver.ie.driver", "F:\\devsoft\\browserDriver\\IEDriverServer.exe");
	  driver = new InternetExplorerDriver();
  }

  @AfterMethod
  public void tearDown() {
	  driver.quit();
  }

}
