package POM.Steps;

import POM.Pages.ProductPage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPageSteps {

    private ProductPage productPage;


    public ProductPageSteps() {

        productPage = new ProductPage();
    }

    public void selectSize() {
        productPage.selectSize();
    }

    public void selectColor() {
        productPage.selectColor();
    }

    public void setQuantity(String quantity) {
        productPage.setQuantity(quantity);
    }

    public void addToCart() {
        productPage.addToCart();
    }


    public void sortByPriceLowToHigh() {
        WebElement priceSortDropdown = productPage.getPriceSortDropdown();
        priceSortDropdown.sendKeys("Price");
    }

    public List<WebElement> getProductPrices() {
        return productPage.getProductPrices();
    }

    public void addToWishlist() {
        productPage.addToWishlist();
    }

}
