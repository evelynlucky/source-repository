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

public class Checkbox {
	public WebDriver driver;
	public String baseUrl = "file:///H:/testing/checkbox.html";
	
	@BeforeMethod
	public void BeforeTest() {
		System.setProperty("webdriver.firefox.marionette", "F:\\devsoft\\browserDriver\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "E:\\firefox\\firefox.exe");
		driver = new FirefoxDriver();
	}
	
	@Test
	public void operateBrowserWindow() {
		driver.get(baseUrl);
//		查找属性为orange的对象
		WebElement checkboxOption = driver.findElement(By.xpath("//input[@value='orange']"));
//		如果此按钮属于未选中状态，则调用click方法选中此单选按钮
		if(!checkboxOption.isSelected()) {
			checkboxOption.click();
		}
//		断言orange是否选中状态
		Assert.assertTrue(checkboxOption.isSelected());
//		查找name属性值为"fruit"的所有单选按钮对象，并存储到一个list容器中
		List<WebElement> fruits = driver.findElements(By.xpath("//input[@name='fruit']"));
		System.out.println(fruits.size());
//		for循环遍历复选框，全部选中复选框
		for(WebElement w : fruits) {
			w.click();
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
