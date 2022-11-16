package SeleniumSessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public By getBy(String locatorType, String locatorValue){
		By locator = null;
		
		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;
		case "classname":
			locator = By.className(locatorValue);
			break;
		case "xpath":
			locator = By.xpath(locatorValue);
			break;
		case "cssselector":
			locator = By.cssSelector(locatorValue);
			break;
		case "linktext":   //52:06 ( LinkTex vedio )
			locator = By.linkText(locatorValue);
			break;	

		default:
			System.out.println("please pass the right locator type and value...."); 
			break;
		}
		
		return locator;	
		
	}	
	
	// 4th:( static Method (*1)
	// 01:15 to 01:19  see video ( Generic Method )
	// ( Single elements then use this one )
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator); 		
	}
	
	// lesson_17:- wait
	
	public WebElement getElement(By locator, int timeOut) {
		return doPresenceofElementLocated(locator, timeOut); 		
	}
	// Leson_7 // List ( Multipul elements then use this one )
	
	public List<WebElement> getElements(By locator){	
			return driver.findElements(locator);
	}					
	
	
	// 7th: 
	public WebElement getElement(String locatorType, String locatorValue){
		return driver.findElement(getBy(locatorType, locatorValue)); 		
	}
	
	// 5th:
	public void doSendKeys(By locator, String value){		
		getElement(locator).sendKeys(value);
		
	}
	// 7th:
	public void doSendKeys(String locatorType, String locatorValue, String value){		
		getElement(locatorType, locatorValue).sendKeys(value);
	}
	
	// 17th:- Wait
	
	public void doSendKeys(By locator, String value, int timeOut) {
		doPresenceofElementLocated(locator, timeOut).sendKeys(value);		
	}
	
	// -------------------------
	
	// LinkTeax : -- lesson_6(6_LinkTeax )--By Locator
		
	public void doClick(By locator) {
			getElement(locator).click();
				
	}
	
	// LinkTeax:- -- (lesson_6) --  String Value 
	// no need third value ("String value") because of click 
	// click not pass the value.
	
	public void doClick(String locatorType, String locatorValue){		
		getElement(locatorType, locatorValue).click();
	}
	
	// lesson_17:- wait
	
	public void doClick(By locator, int timeOut) {
		doPresenceofElementLocated(locator, timeOut).click();		
	}
	
	// Generic Method for getText() /1:11 lesson_6(8_tagName)--By Locator 
	
	public String doGetText(By locator) {
		return getElement(locator).getText();
	}
	// Lesson_8(A)
	
	public String getAttributeValue(By locator, String attrName) {
		String attrVal = getElement(locator).getAttribute(attrName);
		System.out.println(attrVal);
		return attrVal;
	}
	
	// Lesson_7(06:00 )
	
	public boolean doIsDisplayed(By locator) {
	    return getElement(locator).isDisplayed();
	}
	 
	public boolean isElementExist( By locator) {
			int elementCount = getElementsCount(locator);
			System.out.println("total elements found: " + elementCount);
			
			if(elementCount >= 1) {
				System.out.println("element is found..." + locator);
				return true;				
			}
			else {
				System.out.println("element is not found.." + locator);
				return false; 			
			}
			
		} 
	 
	public List<String> getElementsTextList(By locator) {
		 List<WebElement> eleList = getElements(locator);
		 List<String> eleTextList = new ArrayList<String>();
		 
		 for(WebElement e : eleList) {
			String eleText = e.getText();
			if( ! eleText.isEmpty()) {
				  eleTextList.add(eleText);
			}
		}
		return eleTextList;
			
	}
	
	public int getElementsCount(By locator) {  // 40:00 understand  code
	 	return getElements(locator).size();
	}
	 
			
	public void printElementValues(List<String> eleList){
		for(String e : eleList) {
			System.out.println(e);
		}		
			
	}
		
	public List<String> getAttributelist(By locator, String attributeName) {
		List<WebElement> eleList = getElements(locator);
		List<String> attrList = new ArrayList<String>();
			
		for(WebElement e : eleList) {
			String attrValue = e.getAttribute(attributeName);
			attrList.add(attrValue);
		}
		return attrList;
			
	}
	
	/************************ Drop Dowr Utils *************************/
	// Lesson_9
	
	// 1..selectByIndex()
	
	public void doDropDownSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	// 2..selectByVisibleText()
	
	public void doDropDownSelectByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}	
	
	// 3..selectByValue()
	
	public void doDropDownSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
    }
	
	// doSelectDropDownValue :- it is using select class, using getOptions() using it
	
	public void doSelectDropDownValue(By locator, String value ) {
		Select select = new Select(getElement(locator));		
		List<WebElement> optionsList = select.getOptions();		
		for(WebElement e:optionsList) {
			String text = e.getText();
			System.out.println(text);
			if(text.equals(value)) {
				e.click();		
				break;
			}
		}
	}
	
	/**** selectDropDownValueWithoutSelect:- here using without select class.
	
	public void selectDropDownValueWithoutSelect(By locator, String value) {		
		List<WebElement> optionsList = getElements(locator);		
		System.out.println(optionsList.size());		
		for(WebElement e: optionsList) {
			String text = e.getText();
//			System.out.println(text);
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
	}
	
	/****************Links utils ************/
	
	
	public List<String> getLinksTextList(By locator) {
		List<WebElement> linksList = getElements(locator);
		List<String> linksTextList = new ArrayList<String>();
		System.out.println(linksList.size());
		for (WebElement e : linksList) {
			String text = e.getText().trim();
			linksTextList.add(text);
		}
		return linksTextList;
	}

	public void clickOnElementFromSection(By locator, String linkText) {
		List<WebElement> langList = getElements(locator);
		System.out.println(langList.size());
		for (WebElement e : langList) {
			String text = e.getText().trim();
			System.out.println(text);
			if (text.equals(linkText)) {
				e.click();
				break;
			}
		}
	}
	
	/**************WebTable Util***************/
	
	public void printTable(By rowLocator, By colLocator, String beforeXpath, String afterXpath){
		int rowCount = getElements(rowLocator).size();
		int colCount = getElements(colLocator).size();
		for (int row = 2; row <= rowCount; row++) {
			for (int col = 1; col <= colCount; col++) {
				String xpath = beforeXpath + row + afterXpath + col + "]";
				String text = doGetText(By.xpath(xpath));
				System.out.print(text+"     |      ");
			}
			System.out.println();
		}

	}
	
	/***************Action Util************/
	
	public void doMoveToElement(By locator) {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(locator)).perform();
	}
	
	public void doClickOnChildMenu(By parentMenuLocator, By ChildMenuLocator ) throws InterruptedException {
		doMoveToElement(parentMenuLocator);
		Thread.sleep(3000);
		doClick(ChildMenuLocator);		
	}
	
	public void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator),value).build().perform();
	}	
	
	public void doActionsSendKeysOnActiveElement(By locator, String value) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).sendKeys(value).build().perform();
	}
	
	/*
	*Clicks in the middle of the given element. 
    *Equivalent to: Actions.moveToElement(onElement).click()
    *@param locator
    */ 	 
	
	public void doActionClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).build().perform();		
		
	}
	
	public void doActionMoveToElementClick(By locator) {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(locator)).click().build().perform();
	}
	
	/********************Wait Utils ******************************/
	
	// Without Interval Time 	
	public WebElement doPresenceofElementLocated(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));		
				
	}
	 // with Interval Time 
	public WebElement doPresenceofElementLocated(By locator, int timeout, long intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout),Duration.ofMillis(intervalTime));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));		
				
	}
	
	// 
	public WebElement waitForElementToBeVisible(By locator, int timeout, long intervalTime ) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout),Duration.ofMillis(intervalTime));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));				
	}
	
	// Ignore this Method // lesson-17(41:00)--
	public WebElement waitForElementToBeVisibleWithWebElement(By locator, int timeout, long intervalTime ) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout),Duration.ofMillis(intervalTime));
		return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
				
	}
	
	public List<WebElement> waitForElementsToBeVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
				
	}
	
	
	public List<WebElement> waitForElementsToBeVisible(By locator, int timeout, long intervalTime ) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout),Duration.ofMillis(intervalTime));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
				
	}
	
	public List<String> getElementsTextListWithWait(By locator, int timeOut) {
		List<WebElement>eleList = waitForElementsToBeVisible(locator, timeOut);
		List<String>eleTextList = new ArrayList<String>();
		for(WebElement e: eleList) {
			String text = e.getText();
			eleTextList.add(text);			
		}
		return eleTextList;
	}
	
	/*******************wait util for Non_WebElements *************/
	
	public boolean waitForURLToContain(String urlFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.urlContains(urlFraction));
	}
	
	public boolean waitForURLToBe(String url, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.urlToBe(url));
	}
	
		
	public String doGetTitleWithFraction(String titleFraction, int timeOut) {
		if(waitForTitleContains(titleFraction, timeOut)) {
			return driver.getTitle();
		}
		return null;
	}
	
	public String doGetTitle(String title, int timeOut) {
		if(waitForTitleToBe(title, timeOut)) {
			return driver.getTitle();
		}
		return null;
	}
		
	public boolean waitForTitleContains(String titleFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.titleContains(titleFraction));
		
	}
	
	public boolean waitForTitleToBe(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.titleIs(title));
		
	}
	
	public Alert waitForAlert(int timeOut) {
		WebDriverWait wait =  new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());			
	}
	
	public String getAlertText(int timeOut) {
		return waitForAlert(timeOut).getText();
		
	}
	
	public void doAlertAccept(int timeOut) {
		waitForAlert(timeOut).accept();
		
	}
	
	public void doAlertAcceptDissmiss(int timeOut) {
		waitForAlert(timeOut).dismiss();
		
	}
	
	public void enterAlertText(String text, int timeOut) {
		waitForAlert(timeOut).sendKeys(text);
		
	}
	
	public void waitForFrameByNameOrId(String nameOrID, int timeOut) {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrID));
	}
  
    public void waitForFrameByIndex(int frameIndex, int timeOut) {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
    }
  
    public void waitForFrameByLocator(By frameLocator, int timeOut) {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
    }
  
    public void waitForFrameByElement(WebElement frameElement, int timeOut) {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
    }
    
    public void clickElementWhenReady(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();		
	}
    
    public void clickElementWhenReady(By locator, int timeOut, long intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofMillis(intervalTime));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();		
	}
    
    public WebElement waitForElementPresntUsingFluentWait(By locator, int timeOut, int pollingTime) {
  	  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(timeOut))
				  .pollingEvery(Duration.ofSeconds(pollingTime))
				  .ignoring(NoSuchElementException.class)
				  .ignoring(StaleElementReferenceException.class)				 
				  .withMessage("Element is not found....");

  	  		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));  	
  	  		
    }
    
    public WebElement waitForElementUsingWebDriverWait(By locator, int timeOut, int pollingTime) {
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait
        .pollingEvery(Duration.ofSeconds(pollingTime))
        .ignoring(NoSuchElementException.class)        
        .ignoring(StaleElementReferenceException.class)        
        .withMessage("Element is not found....");

        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }  
	
	
}
		
		
		
		