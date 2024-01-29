package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Map;

public class TestBase {

    public static ApplicationManager app;
    public static WebDriver driver;
    public JavascriptExecutor js;
    public Map<String, Object> vars;

    protected static void openMainPage() {
        driver.get("http://localhost/addressbook/addressbook/");
    }

    protected static void clickAddNewButton() {
        driver.findElement(By.xpath("/html/body/div/div[3]/ul/li[2]/a")).click();
    }

    protected static void clickSubmit() {
        driver.findElement(By.name("submit")).click();
    }

    protected static boolean checkIfCOntactExists() {
        return driver.findElement(By.xpath("/html/body/div/div[3]/ul/li[2]/a")).isDisplayed();
    }

    @BeforeEach


    public void setUp() {

        if (app == null) {

            app = new ApplicationManager();

            app.init(System.getProperty("browser", "firefox"));

        }



    //  var options = new FirefoxOptions();
      //options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
      //System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
       // app.init(options, this, "firefox");
    }

    @AfterEach
    public void tearDown() {
      driver.quit();
    }

}
