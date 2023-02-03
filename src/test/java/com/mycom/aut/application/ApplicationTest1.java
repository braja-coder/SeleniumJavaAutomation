/*
 * Creation : 4 janv. 2018
 */
package com.mycom.aut.application;

import java.util.logging.Logger;

import org.testng.annotations.Test;

import com.google.common.base.Verify;
import com.main.allvariables.AllVariables;
import com.main.application.pages.CheckOutPage;
import com.main.application.pages.HomePage;
import com.main.application.pages.PlaceOrderPage;
import com.main.application.pages.SelectCartPage;
import com.main.application.popups.CartPopup;
import com.main.coreframework.Base;
import com.main.coreframework.SeleniumUtil;
import com.main.properties.Commonconfig;
import com.mycom.aut.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;


public class ApplicationTest1 extends BaseTest {
 
    
    @Test(priority=0)
    public void untilHomePage() {
        HomePage homePage = new HomePage();
    try {
       test = report.startTest("in home page");
       test.log(LogStatus.INFO, "launched url");
       log.info("launched URL");
       homePage.tabletLink.click();
       test.log(LogStatus.INFO, "clicked on tablet");
       homePage.LaptopNotebookLink.click();
       test.log(LogStatus.INFO, "clicked on laptopnotebook");
       homePage.LaptopLink.click();
       log.info("Test case passed");
       test.log(LogStatus.INFO, "clicked on laptop");
    }catch(Exception e) {
    	e.printStackTrace();
    	Verify.verify(false, "Testc case failed");
    	log.info("Test case failed");
       	test.log(LogStatus.ERROR, "testcase failed");
      }
    }
    
    @Test(priority=1)
    public void untilSelectCartPage() throws InterruptedException {
        SelectCartPage selectCartPage =  new SelectCartPage();
    try {
       test = report.startTest("in selct cart page");
       selectCartPage.delivaryDate.clear();
       selectCartPage.waitForPageToLoad(selectCartPage.delivaryDate);
       selectCartPage.delivaryDate.sendKeys(Commonconfig.delivarydate);
       test.log(LogStatus.INFO, "entered Delivary date");
       selectCartPage.addToCartButton.click();
       test.log(LogStatus.INFO, "clicked on add to cart");
       selectCartPage.cartButton.click();
       test.log(LogStatus.INFO, "clicked on cart");
       selectCartPage.waitForPageToLoad(selectCartPage.cartButton);
       CartPopup cartPopup = new CartPopup(driver);
       cartPopup.checkoutLink.click();
       test.log(LogStatus.INFO, "clicked on checkout");
    }catch(Exception e) {
    	e.printStackTrace();
    	Verify.verify(false, "Testc case failed");
    	test.log(LogStatus.ERROR, "testcase failed");
    }
    }
    
    @Test(priority=2)
    public void untilPlaceOrderPage() {
    	   PlaceOrderPage placeOrderPage = new PlaceOrderPage();
    try {
       test = report.startTest("in place order page");
  //     Thread.sleep(1000);
       placeOrderPage.guestRadioButton.click();
       test.log(LogStatus.INFO, "clicked guest");
       placeOrderPage.continueButtonCheckOutOptions.click();
     //  Thread.sleep(1000);
       placeOrderPage.checkOutFirstName.sendKeys(Commonconfig.firstname);
       placeOrderPage.checkOutLastName.sendKeys(Commonconfig.lastname);
       placeOrderPage.checkOutEmail.sendKeys(Commonconfig.email);
       placeOrderPage.checkOutPhone.sendKeys(Commonconfig.telephone);
       placeOrderPage.checkOutAddress1.sendKeys(Commonconfig.address1);
       placeOrderPage.checkOutCity.sendKeys(Commonconfig.city);
       test.log(LogStatus.INFO, "entered address details");
       SeleniumUtil seleniumUtil = new SeleniumUtil();
       seleniumUtil.selectValuedropDownText(placeOrderPage.selectCountry, Commonconfig.country);
     //  Thread.sleep(1000);
       seleniumUtil.selectValuedropDownText(placeOrderPage.selectState, Commonconfig.state);
     //  Thread.sleep(1000);
       placeOrderPage.continueCheckOutBillingDetails.click();
       Thread.sleep(1000);
    }catch(Exception e) {
    	e.printStackTrace();
    	test.log(LogStatus.ERROR, "testcase failed");
    	Verify.verify(false, "Test case failed");
    	
    }
     
    }
    
    @Test(priority=3)
    public void untilCheckOutPage() throws InterruptedException {
    	 CheckOutPage checkoutPage = new CheckOutPage();
    try {
    	 test = report.startTest("in place order page");
         checkoutPage.continueButtonDelivaryMethod.click();
      //   Thread.sleep(1000);
         checkoutPage.termsAndConditions.click();
      //   Thread.sleep(1000);
         checkoutPage.continueButtonPaymentMethod.click();
         Thread.sleep(1000);
         checkoutPage.confirmOrder.click();
     //    Thread.sleep(1000);
         SeleniumUtil seleniumUtil = new SeleniumUtil();
         String requiredMessage = seleniumUtil.getText(checkoutPage.orderPlacedMessage);
         Assert.assertEquals(Commonconfig.orderplacemessage, requiredMessage);
       }catch(Exception e) {
    	 checkoutPage.highLightElement(driver, element);
    	test.log(LogStatus.ERROR, e.getMessage());
    	Verify.verify(false, "Test case failed");
    	
    }
    
    }
}
