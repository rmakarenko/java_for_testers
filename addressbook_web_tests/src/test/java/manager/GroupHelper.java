package manager;

import model.groupData;
import org.openqa.selenium.By;
import tests.AddDeleteGroupTest;

import static tests.TestBase.driver;

public class GroupHelper extends HelpersBase {


    private final ApplicationManager manager;

    public GroupHelper(ApplicationManager manager) {
        this.manager = manager;

    }


    public static void createGroup(groupData groupData, AddDeleteGroupTest testBase) {
        driver.findElement(By.name("new")).click();
        driver.findElement(By.name("group_name")).sendKeys(groupData.name());
        driver.findElement(By.name("group_header")).sendKeys(groupData.header());
        driver.findElement(By.name("group_footer")).sendKeys(groupData.footer());
        driver.findElement(By.name("submit")).click();
        System.out.println("Group created successful");
    }


}
