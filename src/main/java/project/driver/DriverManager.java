package project.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Properties;

import static project.properties.TestProperties.getInstance;

public class DriverManager {

    private static final Properties properties = getInstance().getProperties();
    private static WebDriver driver;

    public static WebDriver getWebDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public static void initDriver() {
        System.setProperty(properties.getProperty("WEB_DRIVER"), properties.getProperty("WEB_DRIVER_PATH"));
        driver = new ChromeDriver();
        driver.get(properties.getProperty("HOSTNAME"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().setScriptTimeout(Duration.ofMillis(500));
        driver.manage().window().maximize();
    }

    public static void closeDriver() {
        driver.quit();
    }
}
