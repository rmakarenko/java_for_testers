package manager;

import org.openqa.selenium.By;
import static tests.TestBase.driver;

public class ContactHelper {

    public static void fillInFirstName(String xpathExpression, String Obi) {
        driver.findElement(By.xpath(xpathExpression)).sendKeys(Obi);
    }

    public static void fillInMiddleName(String xpathExpression, String Van) {
        driver.findElement(By.xpath(xpathExpression)).sendKeys(Van);
    }

    public static void fillInLastName(String xpathExpression, String Kenobi) {
        driver.findElement(By.xpath(xpathExpression)).sendKeys(Kenobi);
    }

    public static void clickDeleteContactButton() {
        driver.findElement(By.xpath("/html/body/div/div[4]/form[2]/div[2]/input")).click();
    }

    public static void clickContactCheckbox() {
        driver.findElement(By.xpath("//*[@id=\"2\"] ")).click();
    }


}
