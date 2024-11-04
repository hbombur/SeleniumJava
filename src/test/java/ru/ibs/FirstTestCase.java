package ru.ibs;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FirstTestCase {
    WebDriver testDriver;
    WebDriverWait testWait;
    static String LOGIN = "Taraskina Valeriya";
    static String PASS = "testing";



    @BeforeEach
    public void setTestProperties() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        this.testDriver = new ChromeDriver();
        testDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        this.testWait = new WebDriverWait(testDriver, Duration.ofSeconds(2));
    }

    public void clickOnElementByXpath(String xpath) {
        testDriver.findElement(By.xpath(xpath)).click();
    }

    public void clickOnWebElement(WebElement webElement) {
        webElement.click();
    }

    public void sendTextByXpath(String xpath, String text) {
        testDriver.findElement(By.xpath(xpath)).sendKeys(text);
    }

    public WebElement getElementByXpath(String xpath) {
        return testDriver.findElement(By.xpath(xpath));
    }

    public List<WebElement> getArrayOfWebElementByXpath(String xpath) {
        return testDriver.findElements(By.xpath(xpath));
    }

    @Test
    public void firstTestCase() {
        testDriver.manage().window().maximize();
        testDriver.get("http://training.appline.ru/user/login");
        testDriver.findElement(By.xpath("//input[@placeholder='Имя пользователя или Email']")).sendKeys(LOGIN);
        testDriver.findElement(By.xpath("//input[@placeholder='Пароль']")).sendKeys(PASS);
        testDriver.findElement(By.xpath("//button[contains(text(), 'Войти')]")).click();
        Assertions.assertTrue(testDriver.findElement(By.xpath("//h1[contains(text(), 'Панель быстрого запуска')]")).isDisplayed());
        testDriver.findElement(By.xpath("//li/a/span[contains(text(), 'Расходы')]/..")).click();
        WebElement element = testDriver.findElement(By.xpath("//a/span[contains(text(), 'Командировки')]"));
        element.click();
        testDriver.navigate().refresh();
        testDriver.switchTo().activeElement().findElement(By.xpath("//a[contains(text(),'Создать командировку')][@class]")).click();
        Assertions.assertTrue(testDriver.findElement(By.xpath("//h1[contains(text(), 'Создать командировку')]")).isDisplayed());
        WebElement departament = testDriver.findElement(By.xpath("//select[@data-name='field__business-unit']/option[@value='7']"));
        departament.click();
        Assertions.assertTrue(departament.isSelected());
        clickOnElementByXpath("//div/a[contains(text(),'Открыть список')]");
        clickOnElementByXpath("//a/span[@class='select2-chosen']");
        WebElement hostOrganization = getElementByXpath("//div[contains(text(),'(Хром) Призрачная Организация Охотников')]");
        clickOnWebElement(hostOrganization);
        Assertions.assertTrue(getElementByXpath("//a/span[@class='select2-chosen']").getText().equals("(Хром) Призрачная Организация Охотников"));
        clickOnElementByXpath("//input[@type='checkbox'][@data-name='field__1']");
        Assertions.assertTrue(getElementByXpath("//input[@type='checkbox'][@data-name='field__1']").isSelected());
        sendTextByXpath("//input[@data-name='field__arrival-city']", "Россия, Саратов");
        Assertions.assertTrue(getElementByXpath("//input[@data-name='field__arrival-city']").getAttribute("value").toString().equals("Россия, Саратов"));
        clickOnElementByXpath("//parent::div/span/input[@placeholder='Планируемая дата выезда']/../../input[@placeholder='Укажите дату']");
        clickOnElementByXpath("//td[@data-handler='selectDay']/a[contains(text(),'27')]");
        clickOnElementByXpath("//parent::div/span/input[@placeholder='Планируемая дата возвращения']/../../input[@placeholder='Укажите дату']");
        clickOnElementByXpath("//td[@data-handler='selectDay']/a[contains(text(),'29')]");
        clickOnElementByXpath("//button[contains(text(), 'Сохранить и закрыть')]");
        List<WebElement> listOfWebElementByXpath = getArrayOfWebElementByXpath(
                "//span[contains(text(), 'Список командируемых сотрудников не может быть пустым')]"
        );
        Assertions.assertFalse(listOfWebElementByXpath.isEmpty(), "Элементы не были найдены");
    }

    @AfterEach
    public void finishTest() {
        testDriver.close();
    }
}
