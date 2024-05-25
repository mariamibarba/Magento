package POM.Pages;

import POM.Utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

    By createAccountLink = By.linkText("Create an Account");
    By menMenu = By.linkText("Men");
    By topsMenu = By.linkText("Tops");
    By cartButton = By.cssSelector(".action.showcart");
    public By searchInput = By.id("search");


    public HomePage() {

    }
    public void clickCreateAccount() {
        WebDriverManager.getDriver().findElement(createAccountLink).click();
    }
    public void navigateToTops() {
        WebDriverManager.getDriver().findElement(menMenu).click();
        WebDriverManager.getDriver().findElement(topsMenu).click();

    }
    public void openCart() {
        WebDriverManager.getDriver().findElement(cartButton).click();
    }
    public void sendTextToSearch(String search){
        WebDriverManager.getDriver().findElement(searchInput).sendKeys(search);
        new Actions(WebDriverManager.getDriver()).keyDown(Keys.ENTER).perform();


    }
}
