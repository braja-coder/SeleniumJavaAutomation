/*
 * Creation : 13 nov. 2017
 */
package com.main.report;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.main.coreframework.Base;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReport extends Base {

    public static ExtentReports initializeReportConfig() {
        if (report == null) {
            DateFormat dateformat = new SimpleDateFormat("dd_MMM_yyyy__hh_mm_ssaa");
            new File(customReportslocation).mkdir();
            java.lang.String fileName = customReportslocation + customReportName + dateformat.format(new Date()) + ".html";
            report = new ExtentReports(fileName, true, DisplayOrder.NEWEST_FIRST);
            report.loadConfig(new File(System.getProperty("user.dir") + extentconfigfile));
            report.addSystemInfo("Selenium version", "4.1.2").addSystemInfo("Environment", "X86_PREPROD");
    
        }
        return report;
    }
}
