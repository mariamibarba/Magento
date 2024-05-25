package Tests;
import POM.Utils.WebDriverManager;
import POM.Utils.workingJson;
import com.fasterxml.jackson.databind.JsonNode;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.annotations.*;
import java.io.IOException;


public class ConfigTest {
    protected JsonNode data;
    @BeforeTest
    @Story("Opening url for all tests")
    @Description("Maximize browsers windows")
    public void setup() throws IOException {
        data= workingJson.getResourcesFromJson();
        WebDriverManager.getDriver().manage().window().maximize();

        WebDriverManager.getDriver().get("https://magento.softwaretestingboard.com/");
    }


    @AfterTest
    public void teardown() {
        WebDriverManager.getDriver().quit();

    }
}

