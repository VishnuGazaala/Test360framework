package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    WebDriver ldriver;
    public DashboardPage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }
    @FindBy(linkText="Dashboard")
    WebElement dashboardbut;
    @FindBy(linkText="Offered Academies") WebElement academies;
    @FindBy(xpath = "//*[@id=\"tab-academies\"]/div/div/ul/li[4]/form/div/button") WebElement testing;
    @FindBy(xpath = "//*[@id=\"learn-press-payment\"]/ul/li/label") WebElement radiobut_paywith;
    @FindBy(xpath = "//*[@id=\"learn-press-checkout-place-order\"]") WebElement placeorder_but;

    public void click_dashboardbut(){
        dashboardbut.click();
    }
    public void click_acadamies(){
        academies.click();
    }
    public void click_Testing() {
        testing.click();
        radiobut_paywith.click();
    }
    public void click_paybut(){
        placeorder_but.click();
    }


}
