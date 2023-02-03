/*
 * Creation : 3 août 2017
 */
package com.main.allvariables;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.reporter.ExtentReporter;
import com.main.properties.GetProperties;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class AllVariables {
	public static WebDriver driver;
	public static WebElement element;
    public static ExtentReports report;
    public static ExtentTest test;
 
    public static String customReportslocation = "target/customReports/";
    public static String customReportName = "extent-report";
    public static String extentconfigfile = "/Extent-Config.xml";
    public static String screenshotlocation = "target/customReports/screenshots/";
    public static String testdataInputPath="/src/test/resources/excelsheets/TestData.xls";

}
