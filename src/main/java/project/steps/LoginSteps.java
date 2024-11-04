package project.steps;

import project.pages.LoginPage;

public class LoginSteps {

    public void login(String login, String pass) {
        LoginPage loginPage = new LoginPage();
        loginPage.setLoginInField(login);
        loginPage.setPassInField(pass);
        loginPage.enterButtonClick();
    }
}
