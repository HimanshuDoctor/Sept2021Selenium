package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OtherLocator {
	
	static WebDriver driver; // (44:30)
	

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
//		driver.get("https://classic.crmpro.com/index.html");
		driver.get("https://demo.opencart.com/index.php?route=account/register");
//		driver.get("https://www.orangehrm.com/hris-hr-software-demo/");
//		driver.get("https://www.freshworks.com/");
		 // id,name,className are attribute.
		
		//1. id: (its a unique attribute)  -- I
		
		// 2.Name:		                  -- II
		
//		driver.findElement(By.name("username")).sendKeys("Test@gmail.com");
//		driver.findElement(By.name("password")).sendKeys("Test@123");
		
//		By emailId =  By.name("username");
		ElementUtil elutil = new ElementUtil(driver);
//		elutil.doSendKeys(emailId, "Himanshu@gmail.com");
		
		// 3. className:                -- III
		
		/* its not unique.
		 * we can have same class name for different elements 
		 */
//		driver.findElement(By.className("form-control")).sendKeys("Himanshu");
		
		/* selenium start checking from the top of the dome( page) , and keep checking,  
		 where is the class = "form-control" , find the first element that having a  
		form-control. here is search element,immediately try to enter the value here,
		instead of entering value inside the first name, it is problem.not give you any 
		exception. this is Problem in is class name,multiple element having same class 
		name is same class name, so we don't prefer class name as much.
		
		 class name use in different way., we will see advance topic later. 
		    
		*/ 
		
		//4. Xpath :(16:58)                
		
		/* xpath is not an attribute.
		 * Xpath is address of the element inside the HTML Dome.		 * 
		 * 
		 * ( this is realtive xpath)--I
		 * 
		 * //*[@id="input-email"] <--- Xpath  ( this is realtive xpath)
		 * ( input --> Right Click --> copy --> Copy Xpath.  (and past proper place.)
		 * 
		 * ( this is absolute xpath)--II
		 * 
		 * /html/body/main/div[2]/div/div/form/fieldset[1]/div[4]/div/input
		 * ( input --> Right Click --> copy --> Copy full Xpath.  (and past proper place.)
		 * 
		 * we should not use absolute xparth...(22:40)
		 * we will never use absolute xpath. 
		 */
		/*How to create xpath :- we have to use attribute to create the xpath		 * 
		 */
		
//		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("test@gmail.com");
		
//		driver.findElement(By.xpath("/html/body/main/div[2]/div/div/form/fieldset[2]/div/div/input"))
//		.sendKeys("test123"); //we will never use absolute xpath.
		 
		// can i use xpath with elementUtil --> "yes"
		// can i use By locator stetarge here -- > "yes"
			
		
		//5. cssSelector:
		
		/* What is cssSelector ?
		 * ccsSelector also not an attribute.
		 * we have to use attributes to create the cssSelector.		 * 
		 */
		// How to create cssSelector?
//		driver.findElement(By.cssSelector("#input-email")).sendKeys("test@567.com");
		
		/*Q.. Between xpath and cssSelector which one you have to prefer.
		 * An.. we will see later...(35:00)	
		 * Both are have own Specific use cases. on the base of that we will conclude 
		 * which one is batter( both are better, both are having own uniqueness. 
		 */
		
		//6. linkTeext:  only for links (37:00)
		// html tag always = a 
//		driver.findElement(By.linkText("Register")).click();
		
		// by locater doclick method
		
//		By registrLink = By.linkText("Register");
//		doClick(registrLink);
		
		 // String locator..
		
//		String register = "Register";
//		elutil.doClick("linktext", register);
		
		//7. partialLinkText : only for links, but its not attibute
		// text of the link
		//html tag = a
		// this is app  "privacy Policy" ( it long that time use )
		// Privacy Policy
		// User Policy
		//reset pwd
		//forgot pwd
		// better use is 'linktext' 
		
//		driver.findElement(By.partialLinkText("Policy")).click();
		
		//8. tagName: html tag
		
//		String header = driver.findElement(By.tagName("h1")).getText();
//		System.out.println(header);
		
//		if(header.contains("Love your software")) {
//			System.out.println("hi headwe is correct");
//		}
		
		// getText()--> gettext Methods use to capture text of the element ( Any  Element )
		/* which cash i can use gettext() --> links,headers, any kind of label available
		 * on page, any kind of error massage, any kind of worrying massage on the page
		 *  that time using gettext method
		 */
		
		By header = By.tagName("hi"); //****
		if(doGetText(header).contains("Love your software")){
			System.out.println("h1 header is correct");
		}		

	}
	// Do create Method for click also.
	
	public static WebElement getElement(By locator){		
		return driver.findElement(locator);			
	}
	
	
	// Create other Method ( custom Method ). ( Generic Custom Method )
	/* doClick method we will be using for clicking on the specific element.
	 This is my own custom method that i have created, 
	 and inside that we are using selenium click method only, 
	 But this is my own generic Custom Method.    
	 
	*/
	
	public static void doClick(By locator) {
		getElement(locator).click();		
		
	}
	
	// Generic Method for getText() /1:11
	
	public static String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	

}
