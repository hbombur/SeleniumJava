package project.steps;

import project.pages.MainPage;

public class MainSteps {
    public void findAndClickCreateBusinessTripButton() {
        MainPage mainPage = new MainPage();
        mainPage.assertHeaderPanelOfQuickStart();
        mainPage.clickDropMenuExpenses();
        mainPage.clickButtonBusinessTrip();
        mainPage.clickButtonCreateBusinessTrip();
    }
}
