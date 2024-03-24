package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
    WebDriver ldriver;
    public Loginpage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }
    By login=By.id("loginlabel");
    By uname=By.name("log");
    By pass=By.name("pwd");
    By submit=By.name("wp-submit");
    By toggle=By.xpath("//*[@id=\"gk-login-toggle\"]/i");
    By logout=By.xpath("//*[@id=\"login_drop_panel\"]/div/ul/li[3]/a");
    public void click_login(){
        ldriver.findElement((By)login).click();
    }
    public void enter_name(String str){
        ldriver.findElement((By)uname).sendKeys(str);
    }
    public void enter_pwd(String str){
        ldriver.findElement((By)pass).sendKeys(str);
    }
    public void click_submit(){
        ldriver.findElement((By)submit).click();
    }
    public void click_toggle(){
        ldriver.findElement(toggle).click();
        ldriver.findElement(logout).click();
    }
}
