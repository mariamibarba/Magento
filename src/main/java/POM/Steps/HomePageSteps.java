package POM.Steps;

import POM.Pages.HomePage;
public class HomePageSteps  {

    public HomePage homePage;

    public HomePageSteps() {

        homePage = new HomePage();
    }

    public void clickCreateAccount() {
        homePage.clickCreateAccount();
    }

    public void navigateToTops() {
        homePage.navigateToTops();
    }


    public void search(){
        homePage.sendTextToSearch("");
    }
}
