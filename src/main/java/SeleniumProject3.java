import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumProject3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/oyatsirojev/Documents/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //1.Navigate to carfax.com

        driver.get("https://www.carfax.com/");

        //2.Click on Find a Used Car

        driver.findElement(By.xpath("//a[@class='button button--green']")).click();

        //3.Verify the page title contains the word “Used Cars”

        driver.getPageSource().contains("Used Cars");

        //4.Choose “Tesla” for Make.

        WebElement selectBoxMake = driver.findElement(By.xpath("//select[@class='form-control search-make search-make--lp']"));

        Thread.sleep(2000);
        Select dropDownBoxMake = new Select(selectBoxMake);
        Thread.sleep(2000);
        dropDownBoxMake.selectByValue("Tesla");

        //5. Verify that the Select Model dropdown box contains 4 current Tesla models - (Model 3, Model S, Model X, Model Y).

        List<String> expectedmod = Arrays.asList( "Model X", "Model S","Model 3", "Model Y", "Roadster");

        List<WebElement> options = driver.findElements(By.xpath("//option[@class='model-option']"));

        List<String> actualmod = new ArrayList<>();

        for (WebElement mod : options) {

            actualmod.add(mod.getText().trim());

        }


        Collections.sort(actualmod);
        Collections.sort(expectedmod);

        Assert.assertEquals(actualmod, expectedmod);
        // new Select(driver.findElement(By.xpath()))

        //6.Choose “Model S” for Model.

        new Select (driver.findElement(By.xpath("//select[@class='form-control search-model  search-model--lp']"))).selectByValue("Model S");

       //7. Enter the zip code 22182 and click Next

        driver.findElement(By.xpath("//input[@name='zip']")).sendKeys("22033", Keys.ENTER);

        //8. Verify that the page contains the text “Step 2 – Show me cars with”

        driver.getPageSource().contains("Step 2 – Show me cars with");

        //9.Check all 4 checkboxes.

        List<WebElement> checkBoxesHis = driver.findElements(By.xpath("//ul[@class='checkbox-list checkbox-list--left checkbox-list--large list-unstyled']//li"));

        //"//div[@class='four-pillar-form form-padding']//input[@type='checkbox']"
////ul[@class='checkbox-list checkbox-list--left checkbox-list--large list-unstyled']//li
        System.out.println("checkbox list"+ checkBoxesHis.size());
        for ( WebElement checkboxhistory : checkBoxesHis ) {
            if(!checkboxhistory.isSelected()){
                checkboxhistory.click();

            }


            }
        //10.Save the count of results from “Show me X Results” button. In this case it is 10.

        String searchcount =(driver.findElement(By.xpath("//span[@class='totalRecordsText']")).getText());
        System.out.println(searchcount);
     //11.Click on “Show me x Results” button.

        driver.findElement(By.xpath("//button[@class='button large primary-green show-me-search-submit']")).click();
      //12Verify the results count by getting the actual number of results displayed in the page by getting the count of WebElements that represent each result
        String resultCount= driver.findElement(By.xpath("//span[@id='totalResultCount']")).getText().split(" ")[0];
        System.out.println(resultCount);

        Assert.assertEquals(searchcount,resultCount);


       //13 Verify that each result header contains “Tesla Model S”.

        List<WebElement> headerResult = driver.findElements(By.xpath("//h4[@class='srp-list-item-basic-info-model']"));

        for(WebElement headers : headerResult){

            System.out.println(headers.getText().contains("Tesla Model S"));
        }

        System.out.println("Count of Tesla Model S links are "+ headerResult.size());

        //14.Get the price of each result and save them into a List in the order of their appearance. (You can exclude “Call for price” options)
        List<String> priceList = new ArrayList<>();
         List<WebElement> priceLists = driver.findElements(By.xpath("//span[@class='srp-list-item-price']"));

         for(WebElement price : priceLists ){
             if(price.getText().contains("$"))
                 priceList.add(price.getText().substring(7));

            // System.out.println(price.getText().replaceAll("^A-Z",""));
         }
        System.out.println(priceList);



         //15.Choose “Price - High to Low” option from the Sort By menu

        List<String> sortedPrices = new ArrayList<String>(priceList);

// sort the list
        Collections.sort(sortedPrices);

// true if the prices are sorted


        new Select (driver.findElement(By.xpath("//select[@class='srp-header-sort-select srp-header-sort-select-desktop--srp']"))).selectByValue("PRICE_DESC");
        System.out.println(!sortedPrices.equals(priceList));

        //16.Choose “Mileage - Low to High” option from Sort By menu
        new Select (driver.findElement(By.xpath("//select[@class='srp-header-sort-select srp-header-sort-select-desktop--srp']"))).selectByValue("MILEAGE_ASC");

        //17.Choose “Year - New to Old” option from Sort By menu
        new Select (driver.findElement(By.xpath("//select[@class='srp-header-sort-select srp-header-sort-select-desktop--srp']"))).selectByValue("YEAR_DESC");

        //Sorry couldnt of  the last two  Verification :) I will do later and resubmit it , gotta go and review little bit.






    }







    }


















/*












Verify that the results are displayed from high to low price.
Choose “Mileage - Low to High” option from Sort By menu
Verify that the results are displayed from low to high mileage.
Choose “Year - New to Old” option from Sort By menu
Verify that the results are displayed from new to old year.
Push the code to a new GitHub repo and share the link in a text file and submit.

 */
