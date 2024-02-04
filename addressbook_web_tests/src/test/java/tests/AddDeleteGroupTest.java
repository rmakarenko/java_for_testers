package tests;

import manager.GroupHelper;
import manager.LoginHelper;
import model.groupData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

public class AddDeleteGroupTest extends TestBase {


  public static void openGroupsPage() {
    driver.findElement(By.linkText("group page")).click();  // go to groups page
  }

  @Test
  public void addNewGroup() throws InterruptedException {
    driver.get("http://localhost/addressbook/addressbook/group.php");
    driver.manage().window().setSize(new Dimension(1296, 688));
    LoginHelper.login();
    GroupHelper.createGroup(new groupData("hello", "general", "kenobi"), AddDeleteGroupTest.this);
    driver.findElement(By.linkText("Logout")).click();

  }

  @Test
  public void deleteGroup() throws InterruptedException {
    driver.get("http://localhost/addressbook/addressbook/group.php");
    driver.manage().window().setSize(new Dimension(1296, 688));
    LoginHelper.login();
    //check if there is no group - create it

    if (!app.isElementPresent(By.name("Selected[]"), AddDeleteGroupTest.this)) {
      GroupHelper.createGroup(new groupData("nu", "pri", "vet"), AddDeleteGroupTest.this);
    }

    openGroupsPage();
    driver.findElement(By.cssSelector(".group:nth-child(6) > input")).click();
    driver.findElement(By.cssSelector("input:nth-child(9)")).click();
    driver.findElement(By.cssSelector("html")).click();
    driver.findElement(By.linkText("Logout")).click();

  }

}