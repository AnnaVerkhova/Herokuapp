import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;


public class DropdownTest {
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
        driver.get("http://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void dropDownTest() {
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select dropdownSelect = new Select(dropdown);
        assertFalse(dropdownSelect.getAllSelectedOptions().isEmpty());
        dropdownSelect.selectByVisibleText("Option 1");
        assertTrue(dropdownSelect.getAllSelectedOptions().get(0).isSelected());
        assertEquals(dropdownSelect.getFirstSelectedOption().getText(), "Option 1");
        dropdownSelect.selectByVisibleText("Option 2");
        assertEquals(dropdownSelect.getFirstSelectedOption().getText(), "Option 2");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
