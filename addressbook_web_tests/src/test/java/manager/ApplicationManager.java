package manager;

import model.groupData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
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

    public void createGroup(groupData groupData, AddDeleteGroupTest testBase) {
      driver.findElement(By.name("new")).click();
      driver.findElement(By.name("group_name")).sendKeys(groupData.name());
      driver.findElement(By.name("group_header")).sendKeys(groupData.header());
      driver.findElement(By.name("group_footer")).sendKeys(groupData.footer());
      driver.findElement(By.name("submit")).click();
      System.out.println("Group created successful");
    }

    public void init(FirefoxOptions options, TestBase testBase) {

        if (driver == null) {

            driver = new FirefoxDriver(options);

            testBase.js = (JavascriptExecutor) driver;

            testBase.vars = new HashMap<String, Object>();

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
