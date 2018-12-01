package cn.glory.api1.page_elemet;

/*
 * 检查下拉列表选项是否符合预期
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;

/*
 * 检查单选列表的选项文字是否符合期望
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DroplistExpectedValue {
	public WebDriver driver;
	public String baseUrl = "https://www.hongkongairlines.com/member/users/registration";
	
	@BeforeMethod
	public void BeforeTest() {
		System.setProperty("webdriver.firefox.marionette", "F:\\devsoft\\browserDriver\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "E:\\firefox\\firefox.exe");
		driver = new FirefoxDriver();
	}
	
	@Test
	public void operateBrowserWindow() {
		driver.get(baseUrl);
		Select monthes = new Select(driver.findElement(By.id("birthMonth")));
		List<WebElement> options = monthes.getOptions();
		System.out.println(options.size());
		List<String> expected_options = Arrays.asList(new String[]{"月","01","02","03","04","05","06","07",
				"08","09","10","11","12"});
		System.out.println(expected_options.size());
		//声明一个新的List对象，用于存取从页面上获取的所有选项文字
		List<String> actual_option = new ArrayList<String>();
		for(WebElement w : options) {
			System.out.println(w.getText());
			actual_option.add(w.getText());
			//断言数组值是否完全一致
			
		}
		Assert.assertEquals(actual_option.toArray(), expected_options.toArray());
		
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
