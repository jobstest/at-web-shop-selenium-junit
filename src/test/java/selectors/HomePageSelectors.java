package selectors;

import org.openqa.selenium.By;

public class HomePageSelectors {

    /**
     * Ссылка Log in
     */
    public By LINK_LOGIN = By.xpath("//a[text()='Log in']");
    /**
     * Поле Email
     */
    public By EMAIL = By.id("Email");
    /**
     * Поле Password
     */
    public By PASSWORD = By.id("Password");
    /**
     * Кнопка Log in
     */
    public By BUTTON_LOGIN = By.xpath("//input[@value='Log in']");
    /**
     * Ссылка Log out
     */
    public By LINK_LOGOUT = By.xpath("//a[text()='Log out']");
    /**
     * Сообщение об ошибке
     */
    public By ERROR_MESSAGE = By.xpath("//div[@class='message-error']");
}
