package com.main.application.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.main.allvariables.AllVariables;
import com.main.coreframework.Base;


public class HomePage{
 private WebDriver driver = AllVariables.driver;
	public HomePage() {
		PageFactory.initElements(driver, this);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 2), this);
	}
	@FindBy (xpath="//li/a[text()='Tablets']")
	public WebElement tabletLink;
	
	@FindBy (xpath="//div[@class='list-group']//a[contains(text(),'Laptops & Notebooks')]")
	public WebElement LaptopNotebookLink;
	
	@FindBy (xpath="//img[contains(@title,'LP3065')]")
	public WebElement LaptopLink;

	public void waitForPageToLoad(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
}
