import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.*;

public class AddDeleteGroupTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @BeforeEach
  public void setUp() {

    var options = new FirefoxOptions();
    options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");

    System.out.println(System.getProperty("user.dir"));
    System.out.println(System.getProperty("user.dir") + "\\geckodriver.exe");
    //driver.quit();
    //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
    driver = new FirefoxDriver(options);
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @AfterEach
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void addNewGroup() throws InterruptedException {
    driver.get("http://localhost/addressbook/addressbook/group.php");
    driver.manage().window().setSize(new Dimension(1296, 688));
    driver.findElement(By.name("user")).sendKeys("admin");
    driver.findElement(By.name("pass")).sendKeys("secret");
    driver.findElement(By.xpath("/html/body/div/div[4]/form/input[3]")).click();
    System.out.println("Login successful");

    driver.findElement(By.name("new")).click();
    driver.findElement(By.name("group_name")).click();
    driver.findElement(By.name("group_name")).sendKeys("test group");
    driver.findElement(By.name("group_header")).click();
    driver.findElement(By.name("group_header")).sendKeys("foo");
    driver.findElement(By.name("group_footer")).click();
    driver.findElement(By.name("group_footer")).sendKeys("bar");
    driver.findElement(By.name("submit")).click();
    System.out.println("Group created successful");
    driver.findElement(By.linkText("Logout")).click();

  }

  @Test
  public void deleteGroup() throws InterruptedException {
    driver.get("http://localhost/addressbook/addressbook/group.php");
    driver.manage().window().setSize(new Dimension(1296, 688));
    driver.findElement(By.name("user")).sendKeys("admin");
    driver.findElement(By.name("pass")).sendKeys("secret");
    driver.findElement(By.xpath("/html/body/div/div[4]/form/input[3]")).click();
    System.out.println("Login successful");

    //check if there is no group - create it

    if (!isElementPresent(By.name("Selected[]"))) {
      driver.findElement(By.name("new")).click();
      driver.findElement(By.name("group_name")).sendKeys("test group");
      driver.findElement(By.name("group_header")).sendKeys("foo");
      driver.findElement(By.name("group_footer")).sendKeys("bar");
      driver.findElement(By.name("submit")).click();
      System.out.println("Group created successful");
    }

    driver.findElement(By.linkText("group page")).click();  // go to groups page
    driver.findElement(By.cssSelector(".group:nth-child(6) > input")).click();
    driver.findElement(By.cssSelector("input:nth-child(9)")).click();
    driver.findElement(By.cssSelector("html")).click();
    driver.findElement(By.linkText("Logout")).click();

  }

  private boolean isElementPresent(By locator) {

    try {
      driver.findElement(locator);
      return true;
    } catch (NoSuchElementException exception) {
      return false;
    }
  }
}