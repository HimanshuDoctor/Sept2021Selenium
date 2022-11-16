package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegPageTest2 {

	public static void main(String[] args) throws InterruptedException {
		
		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.launchBrowser("Chrome");
		brUtil.enterUrl("https://demo.opencart.com/index.php?route=account/register");
		String title = brUtil.getPageTitle();
		System.out.println(title);
		
		By firstName = By.id("input-firstname");
		By lastName = By.id("input-lastname");
		By emailId = By.id("input-email");
		By passWord = By.id("input-password");
			
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(firstName, "Ashish");
		eleUtil.doSendKeys(lastName, "Doctor");
		eleUtil.doSendKeys(emailId, "Ashish@gmail.com");
		eleUtil.doSendKeys(passWord, "Ashish12345");
		
		Thread.sleep(5000);
		
		brUtil.closeBrowser();
	}

}
