package Utility;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

import java.util.concurrent.TimeUnit;

public class Browserfactory {
    public static WebDriver setup(WebDriver driver,String br,String url){

        if(br.equals("chrome")){
            driver=new ChromeDriver();
        }
        else if(br.equals("Edge")){
            driver=new EdgeDriver();
        }
        else if(br.equals("Firefox")){
            driver=new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }
}
