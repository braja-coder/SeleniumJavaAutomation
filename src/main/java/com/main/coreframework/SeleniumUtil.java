/*
 * Creation : 1 août 2017
 */
package com.main.coreframework;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumUtil extends Base {

    public void mouseHover(WebElement mouseHoverToelement) {
        Actions action = new Actions(driver);
        action.moveToElement(mouseHoverToelement).build().perform();
    }

    public void maximize() {
        driver.manage().window().maximize();
    }

    public static String captureScreenshot(WebDriver driver, String screenshotName) throws Exception {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        // after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "/test-output/FailedTestsScreenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }

    public boolean isElementPresent(WebElement element) {
        if (element.isDisplayed()) {
            return true;
        }
        return false;
    }

    public static void selectValuedropDownText(WebElement element, String text) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(text);
    }

    public void selectValuedropDownValue(WebElement element, String value) {
        Select dropdown = new Select(element);
        dropdown.selectByValue(value);
    }

    public void entervalueEditField(WebElement element, String value) {
        element.sendKeys(value);
    }

    public void clickonElement(WebElement element) {
        element.click();
    }

    public void clickElementByCssSelector(WebElement element) {
        driver.findElement(By.cssSelector("")).click();
    }

    public void waitUntilPageLoads() {
        driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
    }

    public void pageDown() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
    }

    public void pageUp() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_UP);
    }

    public String getCurrentWindowHandle() {
        return driver.getWindowHandle();

    }

    public boolean switchToWindow(String parentwindow) {
        boolean b = false;
        Set<String> handles = driver.getWindowHandles();
        for (String windowHandle : handles) {
            if (!windowHandle.equals(parentwindow)) {
                try {
                    driver.switchTo().window(windowHandle);
                    System.out.println("##################################################################" + windowHandle);
                    b = true;
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("************************Not able to switch to child window*************************");
                    b = false;
                }
            }
        }
        return b;
    }

    public void switchToParentWindow(String windowhandle) {
        driver.switchTo().window(windowhandle);
    }

    public void switchToFrame() {
        driver.switchTo().frame(0);
    }

    public void javaScriptClick(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.getElementById(element).click();");
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    public void acceprtAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    public void cancelAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();

    }
    
    public String getText(WebElement element) {
    
    	return element.getText();
    }
    
   
}
