import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GetCountWebSearch {
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "/Users/oyatsirojev/Documents/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.dice.com/");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.id("typeaheadInput")).sendKeys("SDET");

        driver.findElement(By.id("google-location-search")).sendKeys("Fairfax,VA"+ Keys.ENTER);

        List<WebElement> elements = driver.findElements(By.xpath("//a[@class='card-title-link bold']"));

        for(WebElement element : elements){

            System.out.println(element.getText().contains("SDET"));
        }

        System.out.println("Count of SDET links are "+ elements.size());




    }

}
