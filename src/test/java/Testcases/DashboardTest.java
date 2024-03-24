package Testcases;

import PageObjects.DashboardPage;
import PageObjects.Loginpage;
import PageObjects.SearchPage;
import Utility.XLutils;
import org.testng.annotations.Test;

import java.io.IOException;

public class DashboardTest extends baseclass {
    private DashboardPage dp;
    String fileName = System.getProperty("user.dir") + "/src/test/java/Utility/testdata.xlsx";

    @Test
    public void Dashboard_test() throws IOException {

        dp = new DashboardPage(driver);
        Loginpage lp = new Loginpage(driver);
        String uname = XLutils.getCellData(fileName, "LoginData", 1, 0);
        String pwd = XLutils.getCellData(fileName, "LoginData", 1, 1);
        lp.click_login();
        lp.enter_name(uname);
        lp.enter_pwd(pwd);
        lp.click_submit();
        String coursename = XLutils.getCellData(fileName, "SearchData", 0, 0);
        dp.click_dashboardbut();
        dp.click_acadamies();
        dp.click_Testing();
        scroll_screen();
        dp.click_paybut();
    }
}



