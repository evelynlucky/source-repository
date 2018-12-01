package cn.glory.api2.operate_elememt;

/*
 * 检查页面元素的文本内容是否出现
 */

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ElementPresent {
	
	WebDriver driver;
	String baseUrl = "file:///H:/testing/webElement.html";
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "F:\\devsoft\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
	  }
	
    @Test
    public void isElementTextPresent() throws InterruptedException {
	    driver.get(baseUrl);
//	    使用xpath找到第一个p元素
	    WebElement text = driver.findElement(By.xpath("//p[1]"));
//	    获取p元素标签的文字内容
	    String textContext = text.getText();
//	    判断文字内容完全匹配
	    Assert.assertEquals(textContext, "《光荣之路》这个电影真的很棒！");
//	    判断文字内容是否包含“光荣之路”这几个字
	    Assert.assertTrue(textContext.contains("光荣之路"));
//	    判断是否以“《光荣”开始
	    Assert.assertTrue(textContext.startsWith("《光荣"));
//	    判断是否以“很棒”结尾
	    Assert.assertTrue(textContext.endsWith("很棒！"));
	    Thread.sleep(3000);
    }

    @AfterMethod
    public void teardown() {
	    driver.quit();
    }

}
