import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WarmUpSelenium {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","/Users/oyatsirojev/Documents/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx"); //step 1


        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");

        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test"+ Keys.ENTER);

        String title= driver.getTitle();

       // assertTrue(title.contains("Web Orders"));


    }

}
