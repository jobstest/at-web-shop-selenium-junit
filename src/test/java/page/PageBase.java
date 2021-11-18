package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selectors.HomePageSelectors;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class PageBase {
    /**
     * Абстрактные методы
     * Справка:
     * https://www.selenium.dev/documentation/en/
     */

    public WebDriver driver;
    public WebDriverWait wait;



    public PageBase(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    //Ожидание загрузки элемента
    public void waitVisibility(By elementBy){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    //Нажать на элемент
    public void click(By elementBy){
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    //Заполнить поле текстом
    public void writeText(By elementBy, String text){
        waitVisibility(elementBy);
        WebElement element = driver.findElement(elementBy);
        element.clear();
        element.sendKeys(text);
    }

    //Получить текст со страницы
    public String readText(By elemetnBy){
        waitVisibility(elemetnBy);
        return driver.findElement(elemetnBy).getText();
    }

    //Отображается ли элемент на странице
    public void isElementDisplayed(By elementBy){
        waitVisibility(elementBy);
        assertTrue(driver.findElement(elementBy).isDisplayed());
    }

    //Элемент не отображается на странице
    public void isElementNotDisplayed(By elementBy){
        assertFalse(driver.findElements(elementBy).size() > 0);
    }

    //Отобржается ли алерт
    public void isAlertText(String message){
        assertEquals(message, driver.switchTo().alert().getText());
    }

    //Заполнить поле текстом из случайных символов
    public String writeRandomText(By elementBy, int lenght){
        waitVisibility(elementBy);
        WebElement element = driver.findElement(elementBy);
        element.clear();
        Random random = new Random();
        String rus = "абвгдеёжзийклмнопрстуфхцчъыьэюя";
        String eng = "abcdefghijklmnopqrstuvwxyz";
        String digit = "0123456789";
        String sum = rus + rus.toUpperCase() + eng + eng.toUpperCase() + digit;
        StringBuilder sb = new StringBuilder(lenght);
        for (int i = 0; i < lenght; i++) sb.append(sum.charAt(random.nextInt(sum.length())));
        element.sendKeys(sb);
        return sb.toString();
    }

    //Нажатие на клавишу на клавиатуре
    public static void pressButtonKeyBoard(int event){
        try {
            Robot robot = new Robot();
            robot.keyPress(event);
            robot.keyRelease(event);
            }
        catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    

}
