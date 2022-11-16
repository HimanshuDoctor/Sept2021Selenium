package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegPageTest {

	public static void main(String[] args) throws InterruptedException {
		
		BrowserUtil brUtil = new BrowserUtil(); // Broesrutil(Lesson_2(C))
		WebDriver driver = brUtil.launchBrowser("Chrome");
		brUtil.enterUrl("https://demo.opencart.com/index.php?route=account/register");
		String title =  brUtil.getPageTitle();
		System.out.println(title);
		
		By firstName = By.id("input-firstname");
		By lastName =  By.id("input-lastname");
		By email =  By.id("input-email");
		By Password =  By.id("input-password");
		
		// to Entrect this elements, which class responsible for that,
		// responsible is ElementUtil class
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(firstName, "Himanshu");
		eleUtil.doSendKeys(lastName, "Dctr");
		eleUtil.doSendKeys(email, "Himanshu@gmail.com");
		eleUtil.doSendKeys(Password, "Himanshu");
		
		Thread.sleep(5000);
		
		brUtil.closeBrowser();		

	}

}
