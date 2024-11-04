package project.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class CreateBusinessTripPage extends BasePage {

    @FindBy(xpath = "//h1[contains(text(), 'Создать командировку')]")
    private WebElement headerCreateBusinessTrip;

    @FindBy(xpath = "//select[@data-name='field__business-unit']/option[@value='7']")
    private WebElement fieldDropDawnMenuInternalDevelopmentDepartment;

    @FindBy(xpath = "//div/a[contains(text(),'Открыть список')]")
    private WebElement openLinkHostOrganizationList;

    @FindBy(xpath = "//a/span[@class='select2-chosen']")
    private WebElement dropDawnMenuHostOrganization;

    @FindBy(xpath = "//div[contains(text(),'(Хром) Призрачная Организация Охотников')]")
    private WebElement selectOrganizationChromFromDropDawnMenuHostOrganization;

    @FindBy(xpath = "//div/a/span[contains(text(),'(Хром) Призрачная Организация Охотников')]")
    private WebElement checkSelectOrganization;

    @FindBy(xpath = "//input[@type='checkbox'][@data-name='field__1']")
    private WebElement checkBoxTaskForOrderTickets;

    @FindBy(xpath = "//input[@data-name='field__arrival-city']")
    private WebElement fieldArrivalCity;

    @FindBy(xpath = "//parent::div/span/input[@placeholder='Планируемая дата выезда']/../../input[@placeholder='Укажите дату']")
    private WebElement fieldDayOfDeparture;

    @FindBy(xpath = "//td[@data-handler='selectDay']/a[contains(text(),'27')]")
    private WebElement dayOfDeparture;

    @FindBy(xpath = "//parent::div/span/input[@placeholder='Планируемая дата возвращения']/../../input[@placeholder='Укажите дату']")
    private WebElement fieldDayOfReturn;

    @FindBy(xpath = "//td[@data-handler='selectDay']/a[contains(text(),'29')]")
    private WebElement dayOfReturn;

    @FindBy(xpath = "//button[contains(text(), 'Сохранить и закрыть')]")
    private WebElement buttonSaveAndClose;

    @FindBy(xpath = "//li[contains(text(), 'CSRF значение недопустимо. Пожалуйста, попробуйте повторить отправку формы.')]")
    private WebElement errorMessage;


    public void assertHeaderCreateBusinessTripIsDisplayed() {
        wait.until(visibilityOf(headerCreateBusinessTrip));
        Assertions.assertTrue(headerCreateBusinessTrip.isDisplayed());
    }

    public void fieldDropDawnMenuInternalDevelopmentDepartmentClickAndAssert() {
        wait.until(visibilityOf(fieldDropDawnMenuInternalDevelopmentDepartment));
        fieldDropDawnMenuInternalDevelopmentDepartment.click();
        Assertions.assertTrue(fieldDropDawnMenuInternalDevelopmentDepartment.isSelected());
    }

    public void openListLinkSelectOrganizationAndAssert() {
        openLinkHostOrganizationList.click();
        dropDawnMenuHostOrganization.click();
        wait.until(visibilityOf(selectOrganizationChromFromDropDawnMenuHostOrganization));
        selectOrganizationChromFromDropDawnMenuHostOrganization.click();
        Assertions.assertEquals("(Хром) Призрачная Организация Охотников", checkSelectOrganization.getText());
    }

    public void selectCheckBoxOrderTicketsAndAssert() {
        checkBoxTaskForOrderTickets.click();
        Assertions.assertTrue(checkBoxTaskForOrderTickets.isSelected());
    }

    public void setFieldArrivalCityAndAssert(String countryAndCity) {
        fieldArrivalCity.sendKeys(countryAndCity);
        Assertions.assertEquals(fieldArrivalCity.getAttribute("value"), countryAndCity);
    }

    public void setDayOfDeparture() {
        wait.until(visibilityOf(fieldDayOfDeparture));
        fieldDayOfDeparture.click();
        wait.until(visibilityOf(dayOfDeparture));
        dayOfDeparture.click();
    }

    public void setDayOfReturn() {
        wait.until(visibilityOf(fieldDayOfReturn));
        fieldDayOfReturn.click();
        wait.until(visibilityOf(dayOfReturn));
        dayOfReturn.click();
    }

    public void saveAndClose() {
        buttonSaveAndClose.click();
    }

    public void assertHasBlockerElement() {
        List<WebElement> listOfWebElementByXpath = getArrayOfWebElementByXpath(
                "//span[@class='validation-failed'][contains(text(),'Список командируемых сотрудников не может быть пустым')]"
        );
//        wait.until(visibilityOf(errorMessage));
//        Assertions.assertTrue(errorMessage.isDisplayed(),"Элементы не были найдены");
        Assertions.assertEquals(2, listOfWebElementByXpath.size(), "ERROR");
    }
}
