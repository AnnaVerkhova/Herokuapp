import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InputTest {
    ChromeDriver driver;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--ignore-popup-blocking");
        chromeOptions.addArguments("--ignore-certificate-errors");
//        chromeOptions.addArguments("start-maximized");
        driver= new ChromeDriver(chromeOptions);
        driver.get("http://the-internet.herokuapp.com/inputs");
    }
    @Test
    public void inputTest(){
        int inputValue=3;
        valideitInputIncreased(inputValue);
        valideitInputDecreased(inputValue);
    }

    public void valideitInputIncreased( int inputValue){
        chengeValideitInput(inputValue, Keys.ARROW_UP, 1, "Неверное значение input после увеличения");
    }
    public void valideitInputDecreased( int inputValue){
        chengeValideitInput(inputValue, Keys.ARROW_DOWN, -1, "Неверное значение input после уменьшения");
    }

    public void chengeValideitInput(int inputValue,Keys key,int delta, String message){
        WebElement input = driver.findElement(By.tagName("input"));
        input.clear();
        input.sendKeys(String.valueOf(inputValue));
        input.sendKeys(key);
        Assert.assertEquals(input.getAttribute("value"),String.valueOf(inputValue + delta), message);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
