package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Map;

public class TestBase {

    public static ApplicationManager app;
    public static WebDriver driver;
    public JavascriptExecutor js;
    public Map<String, Object> vars;

    @BeforeEach


    public void setUp() {

        if (app == null) {

            app = new ApplicationManager();

        }

      var options = new FirefoxOptions();
      options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
      System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
        app.init(options, this);
    }

    @AfterEach
    public void tearDown() {
      driver.quit();
    }

}
