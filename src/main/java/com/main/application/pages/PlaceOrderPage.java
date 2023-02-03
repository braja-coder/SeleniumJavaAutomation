package com.main.application.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaceOrderPage {
	WebDriver driver;
	public PlaceOrderPage() {
		PageFactory.initElements(driver, this);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 2), this);
	}
	@FindBy (xpath="//input[@value='guest']")
	public WebElement guestRadioButton;
	
	@FindBy (xpath="//input[@id='button-account']")
	public WebElement continueButtonCheckOutOptions;
	
	@FindBy (xpath="//input[@id='input-payment-firstname']")
	public WebElement checkOutFirstName;
	
	@FindBy (xpath="//input[@id='input-payment-lastname']")
	public WebElement checkOutLastName;
	
	@FindBy (xpath="//input[@id='input-payment-email']")
	public WebElement checkOutEmail;
	
	@FindBy (xpath="//input[@id='input-payment-telephone']")
	public WebElement checkOutPhone;
	
	@FindBy (xpath="//input[@id='input-payment-address-1']")
	public WebElement checkOutAddress1;
	
	@FindBy (xpath="//input[@id='input-payment-city']")
	public WebElement checkOutCity;
	
	@FindBy (xpath="//input[@id='input-payment-postcode']")
	public WebElement checkOutPostalCode;
	
	@FindBy (xpath="//select[@id='input-payment-country']")
	public WebElement selectCountry;
	
	@FindBy (xpath="//select[@id='input-payment-zone']")
	public WebElement selectState;
	
	@FindBy (xpath="//input[@id='button-guest']")
	public WebElement continueCheckOutBillingDetails;
	
	public void waitForPageToLoad(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
}
