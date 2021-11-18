package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import page.HomePageStep;
import selectors.HomePageSelectors;

import java.util.concurrent.TimeUnit;

public class TestBase {
    /**
     * Справка:
     * WebDriverManager
     * https://github.com/bonigarcia/webdrivermanager
     * https://github.com/bonigarcia/selenium-jupiter
     * https://www.selenium.dev/documentation/en/
     */

    WebDriver driver;
    public HomePageStep homePageStep;


    @BeforeEach
    public void start(){
        WebDriverManager.chromedriver().setup();
        //ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);
        //options.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
        //driver = new ChromeDriver(options);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        homePageStep = PageFactory.initElements(driver, HomePageStep.class);
    }

    @AfterEach
    public void finish(){
        driver.quit();
    }
}
