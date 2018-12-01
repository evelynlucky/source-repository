package cn.glory.api1.page_elemet;

/*
 * 操作单选框radio
 */
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Radio {
	public WebDriver driver;
	public String baseUrl = "file:///H:/testing/radio.html";
	
	@BeforeMethod
	public void BeforeTest() {
		System.setProperty("webdriver.firefox.marionette", "F:\\devsoft\\browserDriver\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "E:\\firefox\\firefox.exe");
		driver = new FirefoxDriver();
	}
	
	@Test
	public void operateBrowserWindow() {
		driver.get(baseUrl);
//		查找属性为strawberry的对象
		WebElement radioOption = driver.findElement(By.xpath("//input[@value='strawberry']"));
//		如果此按钮属于未选中状态，则调用click方法选中此单选按钮
		if(!radioOption.isSelected()) {
			radioOption.click();
		}
//		断言strawberry是否选中状态
		Assert.assertTrue(radioOption.isSelected());
//		查找name属性值为"fruit"的所有单选按钮对象，并存储到一个list容器中
		List<WebElement> fruits = driver.findElements(By.xpath("//input[@name='fruit']"));
		System.out.println(fruits.size());
//		for循环遍历单选按钮，查找value属性值为watermelon的单选按钮，如果未选中，则选中
		for(WebElement w : fruits) {
			if(w.getAttribute("value").equalsIgnoreCase("watermelon")) {
				if(!w.isSelected()) {
					w.click();
				}
				Assert.assertTrue(w.isSelected());
//				成功选中后，退出for循环
				break;
			}
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@AfterMethod
	public void afterTest() {
		driver.quit();
	}
}
