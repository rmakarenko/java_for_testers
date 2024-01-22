package manager;

import org.openqa.selenium.By;
import static tests.TestBase.driver;

public class LoginHelper extends HelpersBase {

    private final ApplicationManager manager;

    public LoginHelper(ApplicationManager manager) {
        this.manager = manager;

    }


    public static void login() {
        driver.findElement(By.name("user")).sendKeys("admin");
        driver.findElement(By.name("pass")).sendKeys("secret");
        driver.findElement(By.xpath("/html/body/div/div[4]/form/input[3]")).click();
    }



}
