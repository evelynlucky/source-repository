package cn.glory.api1.page_elemet;

/*
 * 操纵窗口位置和大小
 */

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OperateBrowserWindow {

	public WebDriver driver;
	public String baseUrl = "http://www.sogou.com";
	
	@BeforeMethod
	public void BeforeTest() {
		System.setProperty("webdriver.firefox.marionette", "F:\\devsoft\\browserDriver\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "E:\\firefox\\firefox.exe");
		Point point = new Point(0, 505);
		Dimension dimension = new Dimension(600, 500);
		driver = new FirefoxDriver();
		driver.manage().window().setPosition(point);
		driver.manage().window().setSize(dimension);
	}
	
	@Test
	public void operateBrowserWindow() {
//		Point对象，两个150表示浏览器的位置相对于屏幕的左上角（0，0）的横坐标和纵坐标距离
//		Point point = new Point(0, 505);
//		Dimension对象，两个500表示浏览器窗口的长度和宽度
//		Dimension dimension = new Dimension(600, 500);
//		setPosition()方法表示设定浏览器在屏幕上的位置为point对象的坐标（150，150），在某些浏览器版本下此方法失效
//		driver.manage().window().setPosition(point);
//		setSize()方法表示设定浏览器窗口的大小为长500个单位和宽500个单位
//		driver.manage().window().setSize(dimension);
//		getPosition()方法表示获取浏览器在屏幕的位置，在某些浏览器版本下此方法失效
//		System.out.println(driver.manage().window().getPosition());
		driver.get(baseUrl);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@AfterMethod
	public void afterTest() {
		driver.quit();
	}
}
