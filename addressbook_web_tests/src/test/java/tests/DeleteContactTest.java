package tests;

import manager.LoginHelper;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class DeleteContactTest extends TestBase {

    @Test
    public void deleteContact() {

        driver.get("http://localhost/addressbook/addressbook/");
        LoginHelper.login();

        if (driver.findElement(By.xpath("/html/body/div/div[3]/ul/li[2]/a")).isDisplayed()) { // if second contact in the list exists
            driver.findElement(By.xpath("//*[@id=\"2\"] ")).click(); // click checkbox
            driver.findElement(By.xpath("/html/body/div/div[4]/form[2]/div[2]/input")).click(); // click delete button
        }
    }
}
