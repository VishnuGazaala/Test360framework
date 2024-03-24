package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    WebDriver ldriver;
    public SearchPage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }
    @FindBy(xpath="//*[@id=\"primary_menu\"]/nav[1]/form/button")
    WebElement searchbut;
    @FindBy(name="search_course") WebElement search_input;
    public void enter_searchinput(String courseName){
        search_input.sendKeys(courseName);
        searchbut.click();
    }
}
