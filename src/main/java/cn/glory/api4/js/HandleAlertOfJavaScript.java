package cn.glory.api4.js;

/*
 * 1. 操作JavaScript的Alert弹窗
 * Alert alert = driver.switchTo().alert();
 * alert.accept();
 * 
 * 2. 操作JavaScript的Confirm弹窗
 * 比上述多了个alert.dismiss() 单击取消按钮的方法
 * 
 * 3. 操作JavaScript的prompt弹窗
 * 能够在JavaScript的prompt弹窗中输入自定义的字符串，单击“确定”按钮和“取消”按钮
 */

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class HandleAlertOfJavaScript {
	
	WebDriver driver;
	String baseUrl = "http://www.sogou.com/";
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "F:\\devsoft\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
	  }
	
//	操作JavaScript的Alert弹窗
    @Test
    public void handleAlert() {
	    driver.get(baseUrl);
	    WebElement button = driver.findElement(By.xpath("//input"));
	    button.click();
//	    获取Alert对象
	    try {
			Alert alert = driver.switchTo().alert();
			Assert.assertEquals(alert.getText(), "这是一个alert弹出框");
//	    单击Alert框上的确定按钮，关闭Alert窗口
			alert.accept();
//	  NoAlertPresentException
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}  
    }
    
//    操作JavaScript的Confirm弹窗
    @Test
    public void handleConfirm() {
	    driver.get(baseUrl);
	    WebElement button = driver.findElement(By.xpath("//input"));
	    button.click();
//	    获取Alert对象
	    try {
			Alert alert = driver.switchTo().alert();
			Assert.assertEquals(alert.getText(), "这是一个confirm框");
//	    单击Alert框上的确定按钮，关闭Alert窗口
//			alert.dismiss()是模拟单击confirm框上的取消按钮
			alert.accept();
//	  NoAlertPresentException
		} catch (NoAlertPresentException e) {
			Assert.fail("尝试操作的confirm框未被找到");
			e.printStackTrace();
		}  
    }
  
//  操作JavaScript的prompt弹窗
	  @Test
	  public void handlePrompt() {
	    driver.get(baseUrl);
	    WebElement button = driver.findElement(By.xpath("//input"));
	    button.click();
//	    获取Alert对象
	    try {
			Alert alert = driver.switchTo().alert();
			Assert.assertEquals(alert.getText(), "这是一个prompt弹出框");
//	  可以在prompt弹出框输入内容
			alert.sendKeys("要想改变命运，必须每天学习两小时！");
//	    单击Alert框上的确定按钮，关闭Alert窗口
			alert.accept();
//	  NoAlertPresentException
		} catch (NoAlertPresentException e) {
			Assert.fail("尝试操作的confirm框未被找到");
			e.printStackTrace();
		}  
  }

    @AfterMethod
    public void teardown() {
	    driver.quit();
    }

}
