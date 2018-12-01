package cn.glory.api2.operate_elememt;

/*
 * 把网页源代码保存为本地文件
 */

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class OutputSourceCodeToFile {
	
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
	    String pageSource = driver.getPageSource();
	    try {
			FileWriter fw = new FileWriter(new File("H:\\testing\\source\\1.sogou-homepage.html"));
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(pageSource);
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
  
  

    @AfterMethod
    public void teardown() {
	    driver.quit();
    }

}
