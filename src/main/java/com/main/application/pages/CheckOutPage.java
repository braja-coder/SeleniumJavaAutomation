package com.main.application.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.main.allvariables.AllVariables;
import com.main.coreframework.Base;

public class CheckOutPage extends Base {
	WebDriver driver = AllVariables.driver;
	public CheckOutPage() {
		PageFactory.initElements(driver, this);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 2), this);
	}
	
	@FindBy (xpath="//div[@class='buttons']//input[contains(@id,'button-shipping')]")
	public WebElement continueButtonDelivaryMethod;
	
	@FindBy (xpath="//div[@class='buttons']//input[contains(@id,'button-payment')]")
	public WebElement continueButtonPaymentMethod;
	
	@FindBy (xpath="//input[@name='agree']")
	public WebElement termsAndConditions;
	
	@FindBy (xpath="//input[@value='Confirm Order']")
	public WebElement confirmOrder;
	
	@FindBy (xpath="//div[@id='content']/h1")
	public WebElement orderPlacedMessage;
	
	public void waitForPageToLoad(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	 public static void highLightElement(WebDriver driverHighLightElement, WebElement element) throws InterruptedException {
	        JavascriptExecutor driver = (JavascriptExecutor) driverHighLightElement;
	        driver.executeScript("arguments[0].setAttribute('style',arguments[1]);",element, "border: 2px solid red;");
	    }
}

