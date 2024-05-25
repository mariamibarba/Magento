package Tests;
import POM.Utils.WebDriverManager;
import POM.Utils.workingJson;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.*;
import java.io.IOException;


public class ConfigTest {
    protected JsonNode data;
    @BeforeTest
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

