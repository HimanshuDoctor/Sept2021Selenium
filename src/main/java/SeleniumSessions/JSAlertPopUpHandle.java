package SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSAlertPopUpHandle {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.name("proceed")).click();
		
		Thread.sleep(5000); 
		
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text); // ans;- Please enter a valid user name
		
		if(text.equals("Please enter a valid user name")) {
			System.out.println("correct validation massage");
		}
		
		//alert.accept(); // click on ok buttton ( under standing )
		alert.dismiss(); // press esc//click on cancle / dismiss the alert ( under standing)
		
		

	}

}
