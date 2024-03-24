package Testcases;

import Utility.Browserfactory;
import Utility.ReadConfig;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

import static Utility.ItestListener.extent;

public class baseclass {
    public WebDriver driver;
    ReadConfig rc=new ReadConfig();
    public String br= rc.browser();
    public String baseURL=rc.Read_URL();
    @BeforeClass
    public void setup(){

        driver= Browserfactory.setup(driver,br,baseURL);

//Extent report code
        ExtentSparkReporter spark=new ExtentSparkReporter("target/spark.html");
        extent.attachReporter(spark);
        extent.setSystemInfo("Machine", "VishnuPC");
        extent.setSystemInfo("OS","Windows11");
        spark.config().setDocumentTitle("Extent Listener Report Demo");
        spark.config().setReportName("This is my first Report");
        spark.config().setTheme(Theme.DARK);
    }
    public void capturescreenshot(WebDriver driver,String testname) {
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File srcpath = new File("." + "//screenshots//" + testname + ".png");
        try {
            FileUtils.copyFile(src, srcpath);
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void scroll_screen(){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,300)");
    }
    @AfterClass
    public void Tear_down() {
        driver.close();
        extent.flush();
    }
}
