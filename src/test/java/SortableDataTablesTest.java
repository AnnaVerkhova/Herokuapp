import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SortableDataTablesTest {
    ChromeDriver driver;
    String tables1 = "Smith";
    String tables2 = "John";
    String tabkes3 = "jsmith@gmail.com";
    String tables4 = "$50.00";
    String tables5 = "http://www.jsmith.com";

    String stroka2Tables1 ="Bach";
    String stroka2Tables2 = "Frank";
    String stroka2Tables3 = "fbach@yahoo.com";
    String stroka2Tables4 = "$51.00";
    String stroka2Tables5 = "http://www.frank.com";

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--ignore-popup-blocking");
        chromeOptions.addArguments("--ignore-certificate-errors");
//        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://the-internet.herokuapp.com/tables");
    }

    public void dataTables(String xpath, String Tables) {
        WebElement tablesValid = driver.findElement(By.xpath(xpath));
        Assert.assertEquals(tablesValid.getText(), Tables);
    }

    @Test
    public void dataTablesTest() {
        dataTables( "//*[@id=\"table1\"]/tbody/tr[1]/td[1]",tables1);
        dataTables( "//*[@id=\"table1\"]/tbody/tr[1]/td[2]",tables2);
        dataTables( "//*[@id=\"table1\"]/tbody/tr[1]/td[3]",tabkes3);
        dataTables("//*[@id=\"table1\"]/tbody/tr[1]/td[4]",tables4);
        dataTables("//*[@id=\"table1\"]/tbody/tr[1]/td[5]",tables5);

        dataTables("//*[@id=\"table1\"]/tbody/tr[2]/td[1]",stroka2Tables1);
        dataTables("//*[@id=\"table1\"]/tbody/tr[2]/td[2]", stroka2Tables2);
        dataTables("//*[@id=\"table1\"]/tbody/tr[2]/td[3]",stroka2Tables3);
        dataTables("//*[@id=\"table1\"]/tbody/tr[2]/td[4]",stroka2Tables4);
        dataTables("//*[@id=\"table1\"]/tbody/tr[2]/td[5]",stroka2Tables5);
    }

    @AfterClass(alwaysRun = true)
   public void tearDown() {
     driver.quit();
   }
}
