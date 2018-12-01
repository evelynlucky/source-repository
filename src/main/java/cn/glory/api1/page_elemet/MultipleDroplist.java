package cn.glory.api1.page_elemet;

/*
 * 操作所选的下拉列表，不是复选框checkbox
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleDroplist {
	public WebDriver driver;
	public String baseUrl = "file:///H:/testing/droplist.html";
	
	@BeforeMethod
	public void BeforeTest() {
		System.setProperty("webdriver.firefox.marionette", "F:\\devsoft\\browserDriver\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "E:\\firefox\\firefox.exe");
		driver = new FirefoxDriver();
	}
	
	@Test
	public void operateBrowserWindow() {
		driver.get(baseUrl);
		Select droplist = new Select(driver.findElement(By.name("fruit")));
//		断言是否复选框
		Assert.assertTrue(droplist.isMultiple());
		
		droplist.selectByIndex(3);
		droplist.selectByValue("shanzha");
		droplist.selectByVisibleText("荔枝");
		
		droplist.deselectAll();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		droplist.selectByIndex(3);
		droplist.selectByValue("shanzha");
		droplist.selectByVisibleText("荔枝");
		
		droplist.deselectByIndex(3);
		droplist.deselectByValue("shanzha");
		droplist.deselectByVisibleText("荔枝");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@AfterMethod
	public void afterTest() {
		driver.quit();
	}
}
