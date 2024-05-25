package POM.Pages;

import POM.Utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyAccauntPage {
    By assertsuccsess = By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div");
    By logOutButtonMenu;
    By logOut;
    public List<WebElement> asserTests() {
        return WebDriverManager.getDriver().findElements(assertsuccsess);
    }

    public void loGout()  {


        logOutButtonMenu = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button");
        WebDriverManager.getDriver().findElement(logOutButtonMenu).click();
        logOut = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a");
        WebDriverManager.getDriver().findElement(logOut).click();
    }
}
