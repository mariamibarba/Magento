package POM.Pages;



import POM.Utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegistrationPage {


    By firstNameField = By.id("firstname");
    By lastNameField = By.id("lastname");
    By emailField = By.id("email_address");
    By passwordField = By.id("password");
    By confirmPasswordField = By.id("password-confirmation");
    By submitButton = By.xpath("//button[@title='Create an Account']");
    By assertsuccsess = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div");

    public RegistrationPage() {

    }

    public void register(String firstName, String lastName, String email, String password) {
        WebDriverManager.getDriver().findElement(firstNameField).sendKeys(firstName);
        WebDriverManager.getDriver().findElement(lastNameField).sendKeys(lastName);
        WebDriverManager.getDriver().findElement(emailField).sendKeys(email);
        WebDriverManager.getDriver().findElement(passwordField).sendKeys(password);
        WebDriverManager.getDriver().findElement(confirmPasswordField).sendKeys(password);
        WebDriverManager.getDriver().findElement(submitButton).click();

    }
    public List<WebElement> asserTests() {
        return WebDriverManager.getDriver().findElements(assertsuccsess);
    }

}
