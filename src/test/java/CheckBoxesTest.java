import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;

public class CheckBoxesTest {
    ChromeDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--ignore-popup-blocking");
        chromeOptions.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    public void checkBoxes() {
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("[type=checkbox]"));
        Assert.assertFalse(checkBoxes.get(0).isSelected(), "unchecked");
        Assert.assertTrue(checkBoxes.get(1).isSelected(), "checked 2");
        checkBoxes.get(1).click();
        checkBoxes.get(0).click();
        Assert.assertTrue(checkBoxes.get(0).isSelected(), "checked 1");
        Assert.assertFalse(checkBoxes.get(1).isSelected(), "uncheck 2");

        {
            driver.quit();
        }
    }
}
