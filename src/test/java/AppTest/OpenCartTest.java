package AppTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartTest extends BaseTest{
	
		
    @Test(priority = 1)
    public void registerLinkTest() {
//    	   driver.get("https://demo.opencart.com/index.php?route=account/register");	
           boolean flag = driver.findElement(By.linkText("Register")).isDisplayed();
           Assert.assertTrue(flag);           
    }
    
    @Test(priority = 2)
    public void urlTest() {
           String url = driver.getCurrentUrl();
           Assert.assertTrue(url.contains("account/register"));
    }	
			

}
