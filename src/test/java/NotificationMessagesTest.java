import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NotificationMessagesTest {
    ChromeDriver driver;
    String text = "Action successful\n" +
            "×";
    String text1 = "Action unsuccesful, please try again\n" +
            "×";

    @BeforeClass
    public void set() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--ignore-popup-blocking");
        chromeOptions.addArguments("--ignore-certificate-errors");
//        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
    }

    @Test
    public void NotificationMessages() {
        WebElement messages = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p/a"));
        messages.click();
        if (driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText().equals(text) ||
                (driver.findElement(By.xpath("//*[@id=\"flash\"]")).getText().equals(text1))) {
            assert true;

        } else{
            assert false;
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}

