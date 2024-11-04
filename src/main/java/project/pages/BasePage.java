package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.PageFactory.*;
import static project.driver.DriverManager.getWebDriver;

public class BasePage {
    public BasePage() {
        initElements(testDriver, this);
    }

    protected static WebDriver testDriver = getWebDriver();
    protected static WebDriverWait wait = new WebDriverWait(testDriver, Duration.ofSeconds(20));

    public List<WebElement> getArrayOfWebElementByXpath(String xpath) {
        return testDriver.findElements(By.xpath(xpath));
    }

    public void refreshPage() { testDriver.navigate().refresh(); }
}
