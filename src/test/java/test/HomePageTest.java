package test;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

public class HomePageTest extends TestBase{
    String url = "http://demowebshop.tricentis.com/";
    @Test
    @Description("Авторизация с правильной почтой и паролем")
    public void authorization(){
        homePageStep.goTo()
                    .auth();
    }
    @Test
    @Description("Авторизация с неправильной почтой")
    public void signInvalidEmail(){
        homePageStep.goTo()
                .clickLinkLogin()
                .fillEmail("test_web_shop@gmail.com")
                .fillPassword("Selenium123")
                .clickBtnLogin()
                .errorMessage();
    }
    @Test
    @Description("Авторизация с неправильным паролем")
    public void signInvalidPassword(){
        homePageStep.goTo()
                .clickLinkLogin()
                .fillEmail("test_web_shop@mail.ru")
                .fillPassword("Selenide1234")
                .clickBtnLogin()
                .errorMessage();
    }




}
