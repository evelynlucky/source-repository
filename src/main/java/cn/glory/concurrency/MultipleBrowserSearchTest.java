package cn.glory.concurrency;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultipleBrowserSearchTest {
	
	public WebDriver driver;
	String baseUrl = "http://www.sogou.com/";
	
	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String browser) {
		//测试前的准备工作，打开浏览器
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.marionette", "F:\\devsoft\\browserDriver\\geckodriver.exe");
			System.setProperty("webdriver.firefox.bin", "E:\\firefox\\firefox.exe");
			driver = new FirefoxDriver();
		} else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "F:\\devsoft\\browserDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.ie.driver", "F:\\devsoft\\browserDriver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
	}
	
	@Test
	public void testSogouSearch() {
		driver.get(baseUrl + "/");
		WebElement inputBox = driver.findElement(By.id("query"));
		//断言判定输入框存在
		Assert.assertTrue(inputBox.isDisplayed());
		inputBox.sendKeys("光荣之路自动化测试");
		//单击搜索按钮
		driver.findElement(By.id("stb")).click();
		//等待五秒钟
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(driver.getPageSource().contains("光荣之路"));
	}
	
	@AfterClass
	public void afterTest() {
		driver.quit();
	}
	

}
