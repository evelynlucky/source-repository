package cn.glory.api3.process;

/*
 * 自定义的显示等待
 * 
 * 自定义一个ExpectedCondition
 */

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class CustomExplicitWait {
	
	WebDriver driver;
	String baseUrl = "http://www.sogou.com/";
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "F:\\devsoft\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
	  }
	
    @Test
    public void visitSogouByChrome() {
	    driver.get(baseUrl);
//	    显示等待判断是否可以从页面获取文字输入框对象，如果可以获取，则执行后续测试逻辑
//	  自定义一个ExpectedCondition
	    try {
			WebElement textInputBox = (new WebDriverWait(driver, 10))
					.until(new ExpectedCondition<WebElement>() {
						@Override
						public WebElement apply(WebDriver input) {
							return input.findElement(By.xpath("//*[type='@text']"));
						}
			});
//	    断言获取的页面输入框中是否包含“今年西瓜相当甜！”这几个关键字
			Assert.assertEquals(textInputBox.getAttribute("value"), "今年夏天西瓜相当甜");
//	    显示等待判断页面的p标签中是否包含“爱吃”两个关键字，若包含则执行后续测试逻辑
			Boolean conditionTextFlag = (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {

				@Override
				public Boolean apply(WebDriver input) {
					return input.findElement(By.xpath("//p")).getText().contains("爱吃");
				}
			});
//	    断言显示等待的判断逻辑为True(p标签元素即包含“爱吃”两个字)
			Assert.assertTrue(conditionTextFlag);
//	    显示等待判断页面的文本输入框是否可见，若可见则执行后续的测试逻辑
			Boolean inputTextVisibleFlag = new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {

				@Override
				public Boolean apply(WebDriver input) {
					return input.findElement(By.xpath("//*[@type='text']")).isDisplayed();
				}
			});
//	    断言显示等待的判断逻辑为true
			assertTrue(inputTextVisibleFlag);
		} catch (NoSuchElementException e) {
//			如果显示等待的条件未被满足，则使用fail函数将此测试用例设定为执行失败
			Assert.fail("页面上的输入框元素未被找到");
			e.printStackTrace();
		}
    }
  
  

    @AfterMethod
    public void teardown() {
	    driver.quit();
    }

}
