package cn.glory.api4.js;

/*
 * 操作浏览器的cookie
 */

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;

public class BrowserCookie {
	
	WebDriver driver;
	String baseUrl = "http://www.sogou.com/";
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.ie.driver", "F:\\devsoft\\browserDriver\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
	  }
	
    @Test
    public void visitSogouByChrome() {
	    driver.get(baseUrl);
//	    得到当前页面下所有Cookie
	    Set<Cookie> cookies = driver.manage().getCookies();
	    Cookie newCookie = new Cookie("cookieName", "cookieValue");
	    System.out.println(String.format("Domain -> name -> value -> expiry -> path"));
	    for(Cookie cookie : cookies) {
	    	System.out.println(String.format("%s -> %s -> %s -> %s -> %s", 
	    			cookie.getDomain(),cookie.getName(),cookie.getValue(),
	    			cookie.getExpiry(), cookie.getPath()));
	    }
	    
//	    删除Cookie有三种方法
	    driver.manage().deleteCookieNamed("CookieName");
	    driver.manage().deleteCookie(newCookie);
	    driver.manage().deleteAllCookies();
	    
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }

    @AfterMethod
    public void teardown() {
	    driver.quit();
    }

}
