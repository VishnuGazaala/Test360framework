package Testcases;

import PageObjects.DashboardPage;
import PageObjects.Loginpage;
import PageObjects.Paymentpage;
import PageObjects.SearchPage;
import Utility.XLutils;
import org.testng.annotations.Test;

import java.io.IOException;

public class Paymenttest extends baseclass {
    private Paymentpage pp;
    private DashboardPage dp;
    String fileName = System.getProperty("user.dir") + "/src/test/java/Utility/testdata.xlsx";

    @Test
    public void payment_test() throws IOException {

        dp = new DashboardPage(driver);
        pp=new Paymentpage(driver);
        Loginpage lp = new Loginpage(driver);
        String uname = XLutils.getCellData(fileName, "LoginData", 1, 0);
        String pwd = XLutils.getCellData(fileName, "LoginData", 1, 1);
        lp.click_login();
        lp.enter_name(uname);
        lp.enter_pwd(pwd);
        lp.click_submit();
        String coursename = XLutils.getCellData(fileName, "SearchData", 0, 0);
        String cardnum= XLutils.getCellData(fileName, "Carddetails", 0, 0);
        String expiry= XLutils.getCellData(fileName, "Carddetails", 0, 1);
        String cvv=XLutils.getCellData(fileName, "Carddetails", 0, 2);

        dp.click_dashboardbut();
        dp.click_acadamies();
        dp.click_Testing();
        scroll_screen();
        dp.click_paybut();
        pp.enter_cardnum(cardnum);
        pp.enter_exp(expiry);
        pp.enter_cvv(cvv);
    }
}
