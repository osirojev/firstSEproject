import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SeleniumProject2 {

    public static void main(String[] args) throws Exception {


        System.setProperty("webdriver.chrome.driver", "/Users/oyatsirojev/Documents/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx"); //step 1

        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");

        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test" + Keys.ENTER);

        driver.findElement(By.xpath("//a[text()='Order']")).click();


        Random numGen = new Random();
        int rand = numGen.nextInt(100);


        //  WebElement element1 = driver.findElement(By.id("input_name"));
        // String elementval = element1.getAttribute("value");

        driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys(Keys.BACK_SPACE);

        driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys(Integer.toString(rand) + Keys.ENTER);
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

        String actualVal = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal")).getAttribute("value");

       String expectedVal= Integer.parseInt(String.valueOf(rand)) > 10 ?
                "" + (int) (Integer.parseInt(String.valueOf(rand)) * 0.92 * 100) : "" + (Integer.parseInt(String.valueOf(rand)) * 100);

        Assert.assertEquals(actualVal, expectedVal);

        Faker faker =new Faker();
        String zipCode= faker.address().zipCode().substring(0,5);



String name=faker.name().fullName();
        String address=faker.address().streetAddress();
       String city=faker.address().city();
        String state=faker.address().state();

        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys(name);
        driver.findElement(By.xpath("//input[@name=\"ctl00$MainContent$fmwOrder$TextBox2\"]")).sendKeys(address);
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys(city);
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys(state);
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(zipCode);

        String visa= "//input[@id=\"ctl00_MainContent_fmwOrder_cardList_0\"]";
        String masterCard= "//input[@id=\"ctl00_MainContent_fmwOrder_cardList_1\"]";
        String americanExpress="//input[@id=\"ctl00_MainContent_fmwOrder_cardList_2\"]";

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String inputDate= formatter.format(date);


        long creditCardMaster = 5200000000000000L + (long) (Math.random() *  100000000000000L );
        long creditCardVisa= 4200000000000000L + (long) (Math.random() *  100000000000000L );
        long creditCardAmex= 320000000000000L + (long) (Math.random() *  100000000000000L );

         List<String> radioList= Arrays.asList(visa,masterCard,americanExpress);

       String randomCardType= radioList.get(new Random().nextInt(radioList.size()));

       driver.findElement(By.xpath(randomCardType)).click();
        String cardtype="";
        String cardnum="";

       if(randomCardType.equals(visa)){

           cardtype="Visa";
           cardnum=String.valueOf(creditCardVisa);

           driver.findElement(By.xpath("//input[@type=\"text\" and @name=\"ctl00$MainContent$fmwOrder$TextBox6\"]")).sendKeys(Long.toString(creditCardVisa));
       }
        else if(randomCardType.equals(masterCard)){

            cardtype="MasterCard";
           cardnum=String.valueOf(creditCardMaster);

            driver.findElement(By.xpath("//input[@type=\"text\" and @name=\"ctl00$MainContent$fmwOrder$TextBox6\"]")).sendKeys(Long.toString(creditCardMaster));
        } else if(randomCardType.equals(americanExpress)){

           cardtype="American Express";
           cardnum=String.valueOf(creditCardAmex);

           driver.findElement(By.xpath("//input[@type=\"text\" and @name=\"ctl00$MainContent$fmwOrder$TextBox6\"]")).sendKeys(Long.toString(creditCardAmex));
       }

        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("03/25");

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();

        assertTrue(driver.getPageSource().contains("New order has been successfully added"));

        driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[1]/a")).click();

        String actualData = driver.findElements(By.tagName("tr")).get(2).getText();

        String expectedData= name+" "+"MyMoney"+" "+rand+ " "+inputDate+ " "+ address+ " "+city+" "+state+" "+zipCode+" "+cardtype+" "+cardnum+" "+ "03/25";
           assertEquals(actualData,expectedData);

                //Ismael Rogahn MyMoney 54 07/06/2021 83766 Streich Shore New Cristopher Missouri 70428 American Express 392567715522069 03/25






       driver.findElement(By.id("ctl00_logout")).click();









    }







        }











/*Launch Chrome browser.
Navigate to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
Login using username Tester and password test
Click on Order link
Enter a random product quantity between 1 and 100
Click on Calculate and verify that the Total value is correct. Price per unit is 100. The discount of 8 % is applied to quantities of 10+. So for example, if the quantity is 8, the Total should be 800. If the quantity is 20, the Total should be 1840. If the quantity is 77, the Total should be 7084. And so on.
Generate and enter random first name and last name.
Generate and Enter random street address
Generate and Enter random city
Generate and Enter random state
Generate and Enter a random 5 digit zip code
EXTRA: As an extra challenge, for steps 6-10 download 1000 row of corresponding realistic data from mockaroo.com in a csv format and load it to your program and use the random set of data from there each time.

Select the card type randomly. On each run your script should select a random type.
Generate and enter the random card number: If Visa is selected, the card number should start with 4. If MasterCard is selected, card number should start with 5. If American Express is selected, card number should start with 3. Card numbers should be 16 digits for Visa and MasterCard, 15 for American Express.
Enter a valid expiration date (newer than the current date)
Click on Process
Verify that “New order has been successfully added” message appeared on the page.
Click on View All Orders link.
The placed order details appears on the first row of the orders table. Verify that the entire information contained on the row (Name, Product, Quantity, etc) matches the previously entered information in previous steps.
Log out of the application.
Push your code to GitHub, and share the repo link in the given repo.txt file
*/
