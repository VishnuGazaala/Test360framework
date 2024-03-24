package Utility;

import Testcases.baseclass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ItestListener implements ITestListener{
    //ExtentSparkReporter htmlReporter;
    //ExtentReports reports=new ExtentReports();
    public static ExtentReports extent=new ExtentReports();

   WebDriver driver;
    ExtentTest test;

    public void configureReport()
    {
//        ExtentSparkReporter spark=new ExtentSparkReporter("target/spark.html");
//        extent.attachReporter(spark);
//        //htmlReporter= new ExtentSparkReporter("ExtentListenerReportDemo.html");
//
//        //reports.attachReporter(htmlReporter);
//
//        //add system information/environments info to reports
//        extent.setSystemInfo("Machine", "VishnuPC");
//        extent.setSystemInfo("OS","Windows11");
//
//
//        spark.config().setDocumentTitle("Extent Listener Report Demo");
//        spark.config().setReportName("This is my first Report");
//        spark.config().setTheme(Theme.DARK);

    }


    public void onTestStart(ITestResult result) {

    }


    public void onTestSuccess(ITestResult result) {
        System.out.println("Name of the test method successfully excuted "+result.getName());
        test=extent.createTest(result.getName());
        test.log(Status.PASS, MarkupHelper.createLabel("Name of the test case passed is: "+result.getName(), ExtentColor.GREEN));
    }


    public void onTestFailure(ITestResult result) {
        System.out.println("Name of test method failed:"+result.getName());
        test=extent.createTest(result.getName());
        test.log(Status.FAIL, MarkupHelper.createLabel("Name of the test case failed is: "+result.getName(),ExtentColor.RED));
    }


    public void onTestSkipped(ITestResult result) {
        System.out.println("Name of test method skipped "+result.getName());
        test=extent.createTest(result.getName());
        test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip test case is: "+result.getName(),ExtentColor.YELLOW));
    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

}
