package cn.glory.api2.operate_elememt;

/*
 * 杀掉Windows的浏览器进程
 */

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class KillWindowsProcess {
	
	public WebDriver driver;
	String baseUrl = "http://www.sogou.com/";
	Point point;
	Dimension dimension= new Dimension(650, 400);
	
	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String browser) {
		//测试前的准备工作，打开浏览器
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.marionette", "F:\\devsoft\\browserDriver\\geckodriver.exe");
			System.setProperty("webdriver.firefox.bin", "E:\\firefox\\firefox.exe");
			point = new Point(0, 0);
			driver = new FirefoxDriver();
			driver.manage().window().setPosition(point);
			driver.manage().window().setSize(dimension);
		} else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "F:\\devsoft\\browserDriver\\chromedriver.exe");
			point = new Point(650, 0);
			driver = new ChromeDriver();
			driver.manage().window().setPosition(point);
			driver.manage().window().setSize(dimension);
		} else {
			System.setProperty("webdriver.ie.driver", "F:\\devsoft\\browserDriver\\IEDriverServer.exe");
			point = new Point(0, 400);
			driver = new InternetExplorerDriver();
			driver.manage().window().setPosition(point);
			driver.manage().window().setSize(dimension);
		}
	}
	
	@Test
	public void operateWindowsProcess() throws InterruptedException {
		driver.get(baseUrl + "/");
		Thread.sleep(8000);
		WindowsUtils.killByName("firefox.exe");
		Thread.sleep(3000);
		WindowsUtils.killByName("iexplore.exe");
		Thread.sleep(3000);
		WindowsUtils.killByName("chrome.exe");
		Thread.sleep(3000);
	}
	
	@AfterClass
	public void afterTest() {
//		driver.quit();
	}
	

}
