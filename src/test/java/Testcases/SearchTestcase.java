package Testcases;

import PageObjects.Loginpage;
import PageObjects.SearchPage;
import Utility.XLutils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchTestcase extends baseclass{
    private SearchPage sp;
    String fileName=System.getProperty("user.dir") + "/src/test/java/Utility/testdata.xlsx";
    @Test
    public void search_tets() throws IOException {
        Loginpage lp=new Loginpage(driver);
        String uname= XLutils.getCellData(fileName,"LoginData",1,0);
        String pwd=XLutils.getCellData(fileName,"LoginData",1,1);
        //System.out.println(lp);
        lp.click_login();

        lp.enter_name(uname);
        lp.enter_pwd(pwd);
        lp.click_submit();
        //lt.login_test();
        sp=new SearchPage(driver);
        String coursename=XLutils.getCellData(fileName,"SearchData",0,0);
        sp.enter_searchinput(coursename);
    }

}
