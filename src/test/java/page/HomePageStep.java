package page;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import selectors.HomePageSelectors;


public class HomePageStep extends PageBase {
    public HomePageStep(WebDriver driver) {
        super(driver);
    }


    public HomePageSelectors homePageSelectors = PageFactory.initElements(driver, HomePageSelectors.class);

    @Step(value = "открыть url")
    public HomePageStep goTo(){
        driver.get(SITE_URL);
        return this;
    }
    @Step(value = "Нажать на кнопку Log in")
    public HomePageStep clickLinkLogin(){
        click(homePageSelectors.LINK_LOGIN);
        return this;
    }
    @Step(value = "Заполнить поле Email")
    public HomePageStep fillEmail(String email){
        writeText(homePageSelectors.EMAIL, email);
        return this;
    }
    @Step(value = "Заполнить поле Password")
    public HomePageStep fillPassword(String password){
        writeText(homePageSelectors.PASSWORD, password);
        return this;
    }
    @Step(value = "Нажать на кнопку Log in")
    public HomePageStep clickBtnLogin(){
        click(homePageSelectors.BUTTON_LOGIN);
        return this;
    }
    @Step(value = "Отображается ссылка Log out")
    public HomePageStep linkLogout(){
        isElementDisplayed(homePageSelectors.LINK_LOGOUT);
        return this;
    }
    @Step(value = "Сообщение об ошибке")
    public HomePageStep errorMessage(){
        isElementDisplayed(homePageSelectors.ERROR_MESSAGE);
        return this;
    }
    @Step(value = "Нажать на ссылку Log out")
    public HomePageStep clickLinkLogout(){
        click(homePageSelectors.LINK_LOGOUT);
        return this;
    }
    @Step(value = "Отображается ссылка Log in")
    public HomePageStep linkLogin(){
        isElementDisplayed(homePageSelectors.LINK_LOGIN);
        return this;
    }


    @Step(value = "Авторизация с правильными email и password")
    public HomePageStep auth(){
        goTo();
        clickLinkLogin();
        fillEmail("test_web_shop@mail.ru");
        fillPassword("Selenium123");
        clickBtnLogin();
        linkLogout();
        return this;
    }

    @Step(value = "Выйти из системы")
    public HomePageStep logout(){
        clickLinkLogout();
        linkLogin();
        return this;
    }

}
