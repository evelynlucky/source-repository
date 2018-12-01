package cn.glory.api3.process;

/*
 * 显示等待 Expected Condition类
 * 
 * 元素可用（enabled）和可被单击  elementToBeClickable(By locator)
 * 元素可被选择  elementToBeSelected(WebElement element)
 * 元素存在  presenceOfElementLocated(By locator)
 * 元素包含特定文本  textToBePresentInElement(By locator)
 * 页面元素值  textToBePresentInElementValue(By locator, java.lang.String.text)
 * 标题包含  titleContains(java.lang.String title)
 */

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class ExplicitWait {
	
	WebDriver driver;
	String baseUrl = "http://www.sogou.com/";
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "F:\\devsoft\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
	  }
	
    @Test
    public void visitSogouByChrome() {
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.titleContains("水果"));
	    System.out.println("网页标题出现了“水果”关键字");
	    WebElement select = driver.findElement(By.xpath("//option[@id='peach']"));
	    wait.until(ExpectedConditions.elementToBeSelected(select));
	    System.out.println("下拉列表中的桃子目前处于选中状态");
//	    其它类似 不写了…… 重点在ExpectedConditons类的用法
    }
  
  

    @AfterMethod
    public void teardown() {
	    driver.quit();
    }

}
