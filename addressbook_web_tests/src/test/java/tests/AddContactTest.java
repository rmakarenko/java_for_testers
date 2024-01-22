package tests;

import manager.LoginHelper;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static manager.ContactHelper.*;

public class AddContactTest extends TestBase {

    @Test
    public void addNewContact() {
        driver.get("http://localhost/addressbook/addressbook/");
        LoginHelper.login();
        driver.findElement(By.xpath("/html/body/div/div[3]/ul/li[2]/a")).click(); // clicks 'add new' button
        fillInFirstName("/html/body/div/div[4]/form/input[3]", "Obi");
        fillInMiddleName(" /html/body/div/div[4]/form/input[4]", "Van");
        fillInLastName("/html/body/div/div[4]/form/input[5]", "Kenobi");
        driver.findElement(By.name("submit")).click();
    }
}
