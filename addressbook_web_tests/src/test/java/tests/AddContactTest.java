package tests;

import manager.LoginHelper;
import org.junit.jupiter.api.Test;

import static manager.ContactHelper.*;

public class AddContactTest extends TestBase {

    @Test
    public void addNewContact() {
        
        openMainPage();
        LoginHelper.login();
        clickAddNewButton(); // clicks 'add new' button
        fillInFirstName("/html/body/div/div[4]/form/input[3]", "Obi");
        fillInMiddleName(" /html/body/div/div[4]/form/input[4]", "Van");
        fillInLastName("/html/body/div/div[4]/form/input[5]", "Kenobi");
        clickSubmit();
    }

}
