package Testcases;

import PageObjects.Loginpage;
import org.testng.annotations.Test;

public class Logintest extends baseclass{
    private Loginpage lp;
    @Test
    public void login_test(){
        lp=new Loginpage(driver);
        lp.click_login();
        lp.enter_name("Demo12");
        lp.enter_pwd("Test123456$");
        lp.click_submit();
    }
}
