import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TyposTest {
    ChromeDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--ignore-popup-blocking");
        chromeOptions.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://the-internet.herokuapp.com/typos");
    }

    @Test
    public void typosTest() {
        String typos = driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(typos,"  Sometimes you'll see a typo, other times you won,t.",
                "неверно написано won,t");
        driver.quit();

    }
}
