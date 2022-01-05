import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class AddRemoveElementsTest {
    ChromeDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--ignore-popup-blocking");
        chromeOptions.addArguments("--ignore-certificate-errors");
//        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }

    @Test
    public void AddRemoveTest() {
        WebElement add = driver.findElement(By.xpath("//button[text()='Add Element']"));
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.className("added-manually")).click();
        int checkElements = driver.findElements(By.className("added-manually")).size();
        Assert.assertEquals(checkElements, 1, " Неверное количество элементов");

    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }

}
