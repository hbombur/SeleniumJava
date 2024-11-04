package project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Имя пользователя или Email']")
    private WebElement placeholderUserNameOrEmail;

    @FindBy(xpath = "//input[@placeholder='Пароль']")
    private WebElement placeholderPassword;

    @FindBy(xpath = "//button[contains(text(), 'Войти')]")
    private WebElement enterButton;

    public void setLoginInField(String login) {
        placeholderUserNameOrEmail.sendKeys(login);
    }

    public void setPassInField(String pass) {
        placeholderPassword.sendKeys(pass);
    }

    public void enterButtonClick() {
        enterButton.click();
    }
}
