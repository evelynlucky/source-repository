package cn.glory.api2.operate_elememt;

/*
 * 执行JavaScript脚本
 */

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ExecuteJavaScript {
	
	WebDriver driver;
	String baseUrl = "http://www.sogou.com/";
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "F:\\devsoft\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
	  }
	
    @Test
    public void executeJavaScript() throws IOException {
    	driver.get(baseUrl);
//	    声明一个javaScript执行器对象
	    JavascriptExecutor js = (JavascriptExecutor) driver;
//	    调用执行器的executeScript方法来执行JavaScript脚本的return documents.title
	    String title = (String) js.executeScript("return document.title");
//	    return document.title是javaScript代码，表示返回当前浏览器窗口的Title值
//	    断言获得的title是否符合期望文字
	    Assert.assertEquals(title, "搜狗搜索引擎 - 上网从搜狗开始");
//	    document.getElementById('stb') 是JavaScript代码，表示获取页面的搜索按钮对象
//	    return button.value 表示返回搜索按钮上的文字
	    js.executeScript("var button = document.getElementById('stb');return button.value");
    }
  
  

    @AfterMethod
    public void teardown() {
	    driver.quit();
    }

}
