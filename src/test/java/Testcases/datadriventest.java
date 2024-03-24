package Testcases;

import PageObjects.Loginpage;
import Utility.XLutils;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class datadriventest extends baseclass {
    @Test(dataProvider = "LoginData")
    public void loginDDT(String user, String pwd) throws InterruptedException {
        Loginpage lp = new Loginpage(driver);

        if (driver.getPageSource().contains("Error")) {

            lp.enter_name(user);
            lp.enter_pwd(pwd);
            lp.click_submit();
        }
        else
        {
            lp.click_login();
            lp.enter_name(user);
            lp.enter_pwd(pwd);
            lp.click_submit();
        }
        if(driver.getPageSource().contains("Dashboard")){
            lp.click_toggle();
            Assert.assertTrue(true);
        }
        else if(driver.getPageSource().contains("Error")){
            capturescreenshot(driver,"loginDDT");
            Assert.assertTrue(false);
        }
    }

    @DataProvider(name = "LoginData")
    String[][] getData() throws IOException {
        String path = System.getProperty("user.dir") + "/src/test/java/Utility/testdata.xlsx";
        int rownum = XLutils.getRowCount(path, "LoginData");
        int colcount = XLutils.getCellCount(path, "LoginData", 1);

        String logindata[][] = new String[rownum][colcount];
        for (int i = 1; i <= rownum; i++) {
            for (int j = 0; j < colcount; j++) {
                logindata[i - 1][j] = XLutils.getCellData(path, "LoginData", i, j);
            }
        }
        return logindata;
    }
}