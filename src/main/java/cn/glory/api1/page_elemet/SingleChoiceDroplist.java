package cn.glory.api1.page_elemet;

/*
 * 下拉列表操作
 */

import java.util.List;

import org.openqa.selenium.By;

/*
 * 操作单选下拉列表
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SingleChoiceDroplist {
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
		Select nation = new Select(driver.findElement(By.id("nationality")));
		//断言是否单选下拉列表
		Assert.assertFalse(nation.isMultiple());
		
		//获取全部下拉列表选项值
		List<WebElement> nations = nation.getOptions();
		for(WebElement w: nations) {
			System.out.println(w.getText());
		}
		
		//selectByValue方法表示使用下拉列表选项的value属性值进行集中操作，<option value="shanzha">"山楂"</>
		//selectByVisibleValue才是使用下拉列表文字值
		//检查默认项是否符合预期，可用getFirstSelectedOption()
		Assert.assertEquals(nation.getFirstSelectedOption().getText(), "请选择您的国家/地区");
		nation.selectByValue("AF");
		Assert.assertEquals(nation.getFirstSelectedOption().getText(), "阿富汗");
		
		//selectByIndex(3) 表示选中下拉列表的第四个选项，0表示第一个选项
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
