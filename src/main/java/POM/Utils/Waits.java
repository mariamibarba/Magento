package POM.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    public static void waitUnits(By locator, WebDriver driver, int timeInSecs) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecs));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
