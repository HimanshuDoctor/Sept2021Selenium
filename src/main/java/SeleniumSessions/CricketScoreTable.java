package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricketScoreTable {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.espncricinfo.com/series/icc-men-s-t20-world-cup-2021-22-1267897/australia-vs-pakistan-2nd-semi-final-1273755/full-scorecard");
	
		System.out.println(getWicketTakerName("Asif Ali"));
		System.out.println(getPlayerScoreCard("Asif Ali"));
		System.out.println(getWicketTakerName("Glenn Maxwell"));
		System.out.println(getPlayerScoreCard("Glenn Maxwell"));
	}
	
	public static String getWicketTakerName(String PlayerName) {
		String xpath = "//span[text() = '"+PlayerName+"']/../../parent::td/following-sibling::td/span/span";
        return driver.findElement(By.xpath(xpath)).getText(); 		
	}
	
	public static List<String> getPlayerScoreCard(String PlayerName) {
		String xpath = "//span[text()='"+PlayerName+"']/../../parent::td/following-sibling::td";
//		String xpath = "//span[text()='"+PlayerName+"']/../parent::td/following-sibling::td"; 
		List<WebElement> scoreList = driver.findElements(By.xpath(xpath));
		List<String> scoreValList = new ArrayList<String>();    //empty ArraList
        for(int i=1; i<scoreList.size(); i++) {
			String text = scoreList.get(i).getText();
			scoreValList.add(text);
		
//		for(WebElement e : scoreList) {
//			String text= e.getText();
//			scoreValList.add(text);
		}
		return scoreValList;
	}    
	

}
