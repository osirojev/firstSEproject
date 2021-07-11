import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class WarmUpTaskJuly10 {

    public static void main(String[] args) {

            System.setProperty("webdriver.chrome.driver", "/Users/oyatsirojev/Documents/drivers/chromedriver");
            WebDriver driver = new ChromeDriver();
        driver.get("https://www.bloomberg.com/markets/stocks");

        List <String> expectedHead= Arrays.asList("NAME" ,"VALUE", "NET CHANGE", "% CHANGE", "1 MONTH", "1 YEAR", "TIME (EDT)");

        //String tableHead = driver.findElements(By.xpath(""));
    }
    }

