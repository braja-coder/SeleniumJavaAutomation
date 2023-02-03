package com.main.application.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.main.allvariables.AllVariables;
import com.main.application.popups.CartPopup;
import com.main.coreframework.Base;

public class SelectCartPage extends Base {
	WebDriver driver = AllVariables.driver;
	public SelectCartPage() {
		PageFactory.initElements(driver, this);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 2), this);
	}
	@FindBy (xpath="//div[@class='input-group date']/input[@id='input-option225']")
	public WebElement delivaryDate;
	
	@FindBy (xpath="//button[@id='button-cart']")
	public WebElement addToCartButton;
	
	@FindBy (xpath="//div[@id='cart']/button")
	public WebElement cartButton;
	
	@FindBy (xpath="//ul[@class='dropdown-menu pull-right']")
	public CartPopup cartPopup;
	
//	public CartPopup cartPopup;
	
	public void waitForPageToLoad(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
