package ru.ibs.appline.extension;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static project.driver.DriverManager.getWebDriver;
import static project.driver.DriverManager.closeDriver;

public class DriverExtension implements BeforeAllCallback, AfterAllCallback {

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        getWebDriver();
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        closeDriver();
    }
}
