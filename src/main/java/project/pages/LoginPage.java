package project.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Имя пользователя или Email']")
    private WebElement placeholderUserNameOrEmail;

    @FindBy(xpath = "//input[@placeholder='Пароль']")
    private WebElement placeholderPassword;

    @FindBy(xpath = "//button[contains(text(), 'Войти')]")
    private WebElement enterButton;

    @Step("Вводим логин")
    public void setLoginInField(String login) {
        placeholderUserNameOrEmail.sendKeys(login);
    }

    @Step("Вводим пароль")
    public void setPassInField(String pass) {
        placeholderPassword.sendKeys(pass);
    }

    @Step("Нажимаем кнопку \"Войти\"")
    public void enterButtonClick() {
        enterButton.click();
    }
}
