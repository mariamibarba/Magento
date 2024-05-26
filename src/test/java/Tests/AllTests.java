package Tests;

import POM.Pages.HomePage;
import POM.Pages.MyAccauntPage;
import POM.Pages.ProductPage;
import POM.Pages.RegistrationPage;
import POM.Steps.HomePageSteps;
import POM.Steps.ProductPageSteps;
import POM.Steps.RegistrationPageSteps;
import POM.Utils.GenerateRandom;
import POM.Utils.Waits;
import POM.Utils.WebDriverManager;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.qameta.allure.Feature;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class AllTests extends ConfigTest{

    HomePageSteps homeSteps = new HomePageSteps();
    ProductPageSteps productPageSteps = new ProductPageSteps();
    ProductPage productPage = new ProductPage();
    HomePageSteps homePageSteps = new HomePageSteps();
    HomePage homePage = new HomePage();
    RegistrationPageSteps registerSteps = new RegistrationPageSteps();
    MyAccauntPage myAccauntPage = new MyAccauntPage();

    @Test(priority = 0,groups = "positive")
    @Story("positive registration case")
    @Feature("Create an account rendom mail, Check it and log out ")
    public void userRegistration() throws InterruptedException, IOException {
        HomePageSteps homeSteps = new HomePageSteps();
        RegistrationPageSteps registerSteps = new RegistrationPageSteps();
        MyAccauntPage myAccauntPage = new MyAccauntPage();

        homeSteps.
                clickCreateAccount();


        ((ObjectNode) data).put("email", GenerateRandom.randomEmail());

        registerSteps.
                register("Mariam",
                        "Barbakadze",
                        data.get("email").asText(),
                        "Password123");


        Assert.assertFalse(myAccauntPage.asserTests().isEmpty(), "წარმატებით გაიარეთ რეგისტრაცია");
        myAccauntPage
                .loGout();
    }



    @Test(groups ="negative", priority = 0)
    @Story("Negatve registration")
    @Feature("Create an account used mail, Check it ")


    public void userRegistration2() throws InterruptedException, IOException {
        HomePageSteps homeSteps = new HomePageSteps();
        RegistrationPageSteps registerSteps = new RegistrationPageSteps();
        RegistrationPage registrationPage = new RegistrationPage();

        homeSteps.
                clickCreateAccount();



        registerSteps.
                register("Mariam",
                        "Barbakadze",
                        data.get("UsedMail").asText(),
                        "Password123");

        Assert.assertFalse(registrationPage.asserTests().isEmpty(), "არსებული მეილი გამოყენებულია");

    }


    @Test(groups = "positive", priority = 2)
    @Story(" ITEM has been added to your Wish List")
    @Feature("serch products, filter by price, choose first product and add in whishlist, next check it ")
    public void searchItemsSuccssesfuladdtoWishlist()  {
        homeSteps.
                clickCreateAccount();


        ((ObjectNode) data).put("email", GenerateRandom.randomEmail());

        registerSteps.
                register("Mariam",
                        "Barbakadze",
                        data.get("email").asText(),
                        "Password123");


        Assert.assertFalse(myAccauntPage.asserTests().isEmpty(), "წარმატებით გაიარეთ რეგისტრაცია");
        homePage.sendTextToSearch(data.get("SearchWord").asText());

//        Waits.waitUnits(homePage.sendTextToSearch(searchInput), WebDriverManager.getDriver(),3000);
        productPageSteps
                .sortByPriceLowToHigh();
        List<WebElement> prices = productPageSteps.getProductPrices();

        Assert.assertTrue(prices.size() > 1,
                "There should be more than one product.");


        for (int i = 1; i < prices.size()-1; i++) {
            double previousPrice = Double.parseDouble(prices.get(i+1).getText());
            double currentPrice =Double.parseDouble(prices.get(i).getText());
            Assert.assertTrue(previousPrice <= currentPrice,
                    "Prices are not sorted correctly: " + previousPrice + " > " + currentPrice);

            previousPrice = currentPrice;
        }

        productPage.getProductList().get(0).click();

        productPage.addToWishlist();
        Assert.assertTrue(productPage.addProcuctWishList(), "Adrienne Trek Jacket has been added to your Wish List. Click here to continue shopping.");

    }

    @Test(groups = "negative", priority = 2)
    @Story("Add product in whishist when user is not log in")
    @Feature("serch products, filter by price, choose first product and add in whishlist, " +
            "but you You must login or register to add items to your wishlist ")
    public void searchItems()  {
        homePage.sendTextToSearch(data.get("SearchWord").asText());

        Waits.waitUnits(homePage.searchInput, WebDriverManager.getDriver(),3);
        productPageSteps
                .sortByPriceLowToHigh();


        List<WebElement> prices = productPageSteps.getProductPrices();

        Assert.assertTrue(prices.size() > 1,
                "There should be more than one product.");


        for (int i = 1; i < prices.size()-1; i++) {
            double previousPrice = Double.parseDouble(prices.get(i+1).getText());
            double currentPrice =Double.parseDouble(prices.get(i).getText());
            Assert.assertTrue(previousPrice <= currentPrice,
                    "Prices are not sorted correctly: " + previousPrice + " > " + currentPrice);

            previousPrice = currentPrice;
        }
        productPage.getProductList().get(0).click();

        productPage.addToWishlist();
        Assert.assertTrue(productPage.dontaddProcuctWishList(), "You must login or register to add items to your wishlist.");


        Waits.waitUnits(homePage.searchInput, WebDriverManager.getDriver(),3);


    }

    @Test(groups = "positive", priority = 1)
    @Story(" Add product to the cart")
    @Feature("navigate to Tops and sort product by price, choose first item check all filds and click add cart button" +
            "next check if product added successfully ")


    public void addCart() throws InterruptedException {
        HomePageSteps homeSteps = new HomePageSteps();
        ProductPageSteps productPageSteps = new ProductPageSteps();
        ProductPage productPage = new ProductPage();

        homeSteps
                .navigateToTops();

        productPageSteps
                .sortByPriceLowToHigh();

        List<WebElement> prices = productPageSteps.getProductPrices();

        Assert.assertTrue(prices.size() > 1,
                "There should be more than one product.");


        for (int i = 1; i < prices.size()-1; i++) {
            double previousPrice = Double.parseDouble(prices.get(i+1).getText());
            double currentPrice =Double.parseDouble(prices.get(i).getText());
            Assert.assertTrue(previousPrice <= currentPrice,
                    "Prices are not sorted correctly: " + previousPrice + " > " + currentPrice);

            previousPrice = currentPrice;
        }

        productPage.getProductList().get(0).click();

        productPage
                .selectSize();
        productPage
                .selectColor();
        productPage
                .setQuantity(data.get("Quantity").asText());
        productPage.addToCart();

        Waits.waitUnits(productPage.addProcuctSuccssesfullTitle, WebDriverManager.getDriver(), 3);

        Assert.assertTrue(productPage.addProcuctSuccssesfull(),"product added successfully");
    }


    @Test(groups = "negative", priority = 2)
    @Story("The product could not be added to the cart")
    @Feature("navigate to Tops and sort product by price, choose first item check all filds except quantity and click add cart button" +
            "next check if product could not be added to the cart successfully ")

    public void addCartByIncorrectData() throws InterruptedException {
        HomePageSteps homeSteps = new HomePageSteps();
        ProductPageSteps productPageSteps = new ProductPageSteps();
        ProductPage productPage = new ProductPage();

        homeSteps
                .navigateToTops();

        productPageSteps
                .sortByPriceLowToHigh();

        List<WebElement> prices = productPageSteps.getProductPrices();

        Assert.assertTrue(prices.size() > 1,
                "There should be more than one product.");


        for (int i = 1; i < prices.size()-1; i++) {
            double previousPrice = Double.parseDouble(prices.get(i+1).getText());
            double currentPrice =Double.parseDouble(prices.get(i).getText());
            Assert.assertTrue(previousPrice <= currentPrice,
                    "Prices are not sorted correctly: " + previousPrice + " > " + currentPrice);

            previousPrice = currentPrice;
        }

        productPage.getProductList().get(5).click();

        productPage
                .selectSize();
        productPage
                .selectColor();
        productPage
                .setQuantity(data.get("Negative_Quantity").asText());
        productPage.addToCart();
        Waits.waitUnits(productPage.quantityAssert, WebDriverManager.getDriver(), 3);

        Assert.assertTrue(productPage.addQuantitySuccssesfull(),"Please enter a quantity greater than 0.");
    }

}
