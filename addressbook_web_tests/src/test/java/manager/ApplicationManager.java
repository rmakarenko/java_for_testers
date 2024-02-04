package manager;

import model.groupData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import tests.AddDeleteGroupTest;
import tests.TestBase;

import java.util.HashMap;

import static tests.TestBase.driver;


public class ApplicationManager {

    private LoginHelper session;
    private GroupHelper groups;
    public boolean isElementPresent(By locator, AddDeleteGroupTest testBase) {
      try {
          driver.findElement(locator);
        return true;
      } catch (NoSuchElementException exception) {
        return false;
      }
    }



    public void init(String browser) {

    // public void init(FirefoxOptions options, TestBase testBase, String browser)

        if (driver == null) {

            if ("firefox".equals(browser)) {

                driver = new FirefoxDriver();

            } else if ("chrome".equals(browser)) {

                driver = new ChromeDriver();

            } else {

                throw new IllegalArgumentException(String.format("unknown browser %s", browser));
            }



            //testBase.js = (JavascriptExecutor) driver;

            //testBase.vars = new HashMap<String, Object>();

            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
        }
    }

    public LoginHelper session(ApplicationManager manager) {

        if (session == null) {
            session = new LoginHelper(this);

        }
        return session;
    }

    public GroupHelper groups(ApplicationManager manager) {

        if (groups == null) {
            groups = new GroupHelper(this);

        }
        return groups;
    }


}
