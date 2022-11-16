package MyTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();		
		driver.get("https://googal.com");		
	}
	
	@Test
	public void serchTest() {
		boolean flag = driver.findElement(By.name("q")).isDisplayed();
		Assert.assertTrue(flag);
	}
	
    @Test
    public void gooleSearchBtnTest() {
           boolean flag = driver.findElement(By.name("btnK")).isDisplayed();
           Assert.assertTrue(flag);
    }
    
    @Test
    public void urlTest() {
           String url = driver.getCurrentUrl();
           Assert.assertTrue(url.contains("google"));
    }


	
	@AfterMethod
	public void tearDown() {		
		driver.quit();		
	}
		

}
