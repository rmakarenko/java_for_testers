package tests;

import manager.LoginHelper;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static manager.ContactHelper.clickContactCheckbox;
import static manager.ContactHelper.clickDeleteContactButton;

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



}
