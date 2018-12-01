package cn.glory.api2.operate_elememt;

/*
 * 将当前浏览器窗口截屏
 * (TakesScreenshot)driver
 * FileUtils.copyFile(,)
 */

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Screenshots {
	
	WebDriver driver;
	String baseUrl = "http://www.sogou.com/";
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "F:\\devsoft\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
	  }
	
    @Test
    public void captureScreenInCurrentWindow() {
	    driver.get(baseUrl);
//	        调用getScreenAs方法把当前浏览器打开的页面进行截图，保存到一个File对象中
	    File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//	        把File对象另存为图片文件, FileUtils类需要导包org.apache.commons.io.FileUtils
	    try {
			FileUtils.copyFile(screenshot,new File("H:\\testing\\screenshots\\test.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
  
  

    @AfterMethod
    public void teardown() {
	    driver.quit();
    }

}
