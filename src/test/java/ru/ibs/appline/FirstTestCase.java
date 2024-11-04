package ru.ibs.appline;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import project.properties.TestProperties;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class FirstTestCase {
    WebDriver testDriver = new ChromeDriver();

    private Properties properties = TestProperties.getInstance().getProperties();

    @BeforeEach
    public void setTestProperties() {
        System.setProperty(properties.getProperty("WEB_DRIVER"), properties.getProperty("WEB_DRIVER_PATH"));
        testDriver.get(properties.getProperty("HOSTNAME"));
        testDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        testDriver.manage().timeouts().setScriptTimeout(Duration.ofMillis(500));
        testDriver.manage().window().maximize();
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

        testDriver.findElement(By.xpath("//input[@placeholder='Имя пользователя или Email']"))
                .sendKeys(properties.getProperty("LOGIN"));
        testDriver.findElement(By.xpath("//input[@placeholder='Пароль']"))
                .sendKeys(properties.getProperty("PASS"));
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
