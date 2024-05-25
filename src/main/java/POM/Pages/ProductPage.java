package POM.Pages;

import POM.Utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage {

    By producSortButton = By.xpath("//*[@id=\"sorter\"]");
    By producSortByPrice = By.xpath("//*[@id=\"sorter\"]/option[3]");

    By productList =By.className("product-item");

    By sizeOption = By.id("option-label-size-143-item-168");
    By colorOption = By.id("option-label-color-93-item-50");
    By quantityField = By.id("qty");
    By addToCartButton = By.id("product-addtocart-button");
    By productName = By.cssSelector(".base");
    public By addProcuctSuccssesfullTitle = By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div");
    public By quantityAssert = By.id("qty-error");
    By WishListtityErrorAssert = By.className("message-error");
    By WishListtityAssert = By.className("message-success");

    By wishlist = By.xpath("//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[5]/div/a[1]");
//    By wishlist = By.linkText("Add to Wish List");

    public WebElement getPriceSortDropdown() {
        return WebDriverManager.getDriver().findElement(producSortButton);
    }

    public List<WebElement> getProductPrices() {
        return WebDriverManager.getDriver().findElements(producSortByPrice);
    }
    public List<WebElement> getProductList() {
        return WebDriverManager.getDriver().findElements(productList);
    }

    public ProductPage() {

    }

    public void selectSize() {
        WebDriverManager.getDriver().findElement(sizeOption).click();
    }

    public void selectColor() {
        WebDriverManager.getDriver().findElement(colorOption).click();
    }

    public void setQuantity(String quantity) {
        WebDriverManager.getDriver().findElement(quantityField).clear();
        WebDriverManager.getDriver().findElement(quantityField).sendKeys(quantity);
    }

    public void addToCart() {
        WebDriverManager.getDriver().findElement(addToCartButton).click();
    }

    public String getProductName() {
        return WebDriverManager.getDriver().findElement(productName).getText();
    }

    public boolean addProcuctSuccssesfull(){
        return !WebDriverManager.getDriver().findElements(addProcuctSuccssesfullTitle).isEmpty();
    }
    public boolean addQuantitySuccssesfull() {
        return !WebDriverManager.getDriver().findElements(quantityAssert).isEmpty();
    }

    public void addToWishlist(){
        WebDriverManager.getDriver().findElement(wishlist).click();
    }

    public boolean dontaddProcuctWishList(){
        return !WebDriverManager.getDriver().findElements(WishListtityErrorAssert).isEmpty();
    }
    public boolean addProcuctWishList(){
        return !WebDriverManager.getDriver().findElements(WishListtityAssert).isEmpty();
    }
}
