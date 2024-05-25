package POM.Steps;

import POM.Pages.RegistrationPage;


public class  RegistrationPageSteps {

    private RegistrationPage registrationPage;

    public RegistrationPageSteps() {

        registrationPage = new RegistrationPage();

    }

    public void register(String firstName, String lastName, String email, String password) {
        registrationPage.register(firstName, lastName, email, password);
    }


}
