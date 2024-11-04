package project.steps;

import project.pages.CreateBusinessTripPage;

public class CreateBusinessTripSteps {
    public void createBusinessTrip(String city) {
        CreateBusinessTripPage createBusinessTripPage = new CreateBusinessTripPage();
        createBusinessTripPage.assertHeaderCreateBusinessTripIsDisplayed();
        createBusinessTripPage.fieldDropDawnMenuInternalDevelopmentDepartmentClickAndAssert();
        createBusinessTripPage.openListLinkSelectOrganizationAndAssert();
        createBusinessTripPage.selectCheckBoxOrderTicketsAndAssert();
        createBusinessTripPage.setFieldArrivalCityAndAssert(city);
        createBusinessTripPage.setDayOfDeparture();
        createBusinessTripPage.setDayOfReturn();
        createBusinessTripPage.saveAndClose();
        createBusinessTripPage.assertHasBlockerElement();
    }
}
