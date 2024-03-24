package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Paymentpage {

    WebDriver ldriver;
    public Paymentpage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }



    @FindBy(xpath = "//*[@id=\"learn-press-payment\"]/ul/li/label")
    WebElement radiobut_paywith;
    @FindBy(xpath = "//*[@id=\"learn-press-checkout-place-order\"]") WebElement placeorder_but;
    //@FindBy(name = "__privateStripeFrame2896")    WebElement frame1;
    @FindBy(xpath="//*[@id=\"card-element\"]/div/iframe") WebElement frame1;
    @FindBy(name="cardnumber") WebElement cardnum;
    @FindBy(name = "exp-date") WebElement expiry;
    @FindBy(name="cvc") WebElement cvv;

    public void enter_cardnum(String y){
        ldriver.switchTo().frame(frame1);
        cardnum.sendKeys(y);
    }
    public void enter_exp(String y){
        expiry.sendKeys(y);
    }
    public void enter_cvv(String y){
        cvv.sendKeys(y);
    }
}
