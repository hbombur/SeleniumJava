package project.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class MainPage extends BasePage {

    @FindBy(xpath = "//li/a/span[contains(text(), 'Расходы')]/..")
    private WebElement buttonExpenses;

    @FindBy(xpath = "//a/span[contains(text(), 'Командировки')]")
    private WebElement buttonBusinessTrip;

    @FindBy(xpath = "//a[contains(text(),'Создать командировку')][@class]")
    private WebElement buttonCreateBusinessTrip;

    @FindBy(xpath = "//h1[contains(text(), 'Панель быстрого запуска')]")
    private WebElement headerPanelOfQuickStart;

    @Step("Проверяем отображение header'а \"Панель быстрого запуска\"")
    public void assertHeaderPanelOfQuickStart() {
        Assertions.assertTrue(headerPanelOfQuickStart.isDisplayed());
    }

    @Step("Нажимаем на выпадающее меню \"Расходы\"")
    public void clickDropMenuExpenses() {
        wait.until(visibilityOf(buttonExpenses));
        buttonExpenses.click();
    }

    @Step("Выбираем в выпадающем меню вариант \"Командировки\"")
    public void clickButtonBusinessTrip() {
        wait.until(visibilityOf(buttonBusinessTrip));
        buttonBusinessTrip.click();
    }

    @Step("В открывшемся окне нажимаем кнопку \"Создать командировку\"")
    public void clickButtonCreateBusinessTrip() {
        wait.until(visibilityOf(buttonCreateBusinessTrip));
        buttonCreateBusinessTrip.click();
    }
}
