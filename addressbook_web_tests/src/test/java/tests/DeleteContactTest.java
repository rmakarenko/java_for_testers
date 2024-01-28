package tests;

import manager.LoginHelper;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class DeleteContactTest extends TestBase {

    @Test
    public void deleteContact() {

        openMainPage();
        LoginHelper.login();

        if (checkIfCOntactExists()) { // if second contact in the list exists
            clickContactCheckbox(); // click checkbox
            clickDeleteContactButton(); // click delete button
        }
    }

    private static void clickDeleteContactButton() {
        driver.findElement(By.xpath("/html/body/div/div[4]/form[2]/div[2]/input")).click();
    }

    private static void clickContactCheckbox() {
        driver.findElement(By.xpath("//*[@id=\"2\"] ")).click();
    }

}
