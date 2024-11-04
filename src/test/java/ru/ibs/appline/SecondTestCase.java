package ru.ibs.appline;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.steps.CreateBusinessTripSteps;
import project.steps.LoginSteps;
import project.steps.MainSteps;
import ru.ibs.appline.extension.DriverExtension;

import java.time.Duration;
import java.util.Properties;

import static project.driver.DriverManager.getWebDriver;
import static project.properties.TestProperties.getInstance;

@ExtendWith(DriverExtension.class)
public class SecondTestCase {
    private final Properties properties = getInstance().getProperties();
    private final WebDriver testDriver = getWebDriver();
    private final WebDriverWait wait = new WebDriverWait(testDriver, Duration.ofSeconds(20));
    private final LoginSteps loginSteps = new LoginSteps();
    private final MainSteps mainSteps = new MainSteps();
    private final CreateBusinessTripSteps createBusinessTripSteps = new CreateBusinessTripSteps();

    @Test
    public void secondTestCase() {

        loginSteps.login(properties.getProperty("LOGIN"), properties.getProperty("PASS"));
        mainSteps.findAndClickCreateBusinessTripButton();
        createBusinessTripSteps.createBusinessTrip("Россия, Саратов");



    }
}
