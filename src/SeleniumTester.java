import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sun.jvm.hotspot.utilities.Assert;
import static org.testng.Assert.*;

public class SeleniumTester {

    public static void main(String[] args) throws InterruptedException {

       System.setProperty("webdriver.chrome.driver","/Users/oyatsirojev/Documents/drivers/chromedriver");
       WebDriver driver = new ChromeDriver();
       driver.get("http://duotifyapp.us-east-2.elasticbeanstalk.com/register.php"); //step 1

       String currentTitleName= driver.getTitle();

       String expectedTitleName="Welcome to Duotify!"; //  step 2

       if(currentTitleName.equals(expectedTitleName)){
           System.out.println("Title name matches!");
       }else{
           System.err.println("Title name does not match!");
       }

        String s = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPGTSTIVWXYZ";
        String username = "";
        for (int i = 0; i < 8; i++) {
            username += s.charAt((int) (Math.random() * s.length()));
        }

       driver.findElement(By.id("hideLogin")).click(); //step 3

        driver.findElement(By.id("username")).sendKeys(username);

        driver.findElement(By.id("firstName")).sendKeys("Oyatullo");

        driver.findElement(By.id("lastName")).sendKeys("Sirojev");

        driver.findElement(By.id("email")).sendKeys(username+"@gmail.com");

        driver.findElement(By.id("email2")).sendKeys(username+"@gmail.com");

        driver.findElement(By.id("password")).sendKeys("Ago060707");

        driver.findElement(By.id("password2")).sendKeys("Ago060707"+ Keys.ENTER);

       // driver.findElement(By.xpath("//*[@id='registerForm']")).submit();






       // driver.findElement(By.xpath("//*[@id=\"loginForm\"]/button")).submit();

       String URL = driver.getCurrentUrl();
       assertTrue(URL.contains("http://duotifyapp.us-east-2.elasticbeanstalk.com/browse.php?"));


        driver.findElement(By.id("nameFirstAndLast")).click();

        assertTrue(driver.getPageSource().contains("Oyatullo Sirojev"));

        Thread.sleep(2000);

        driver.findElement(By.id("rafael")).click();

        Thread.sleep(2000);

        String URL2 = driver.getCurrentUrl();
        assertTrue(URL2.contains("http://duotifyapp.us-east-2.elasticbeanstalk.com/register.php"));

        Thread.sleep(2000);



        driver.findElement(By.id("loginUsername")).sendKeys(username);

        driver.findElement(By.id("loginPassword")).sendKeys("Ago060707"+Keys.ENTER);
        Thread.sleep(2000);

        driver.findElement(By.id("nameFirstAndLast")).click();

        String source= driver.getPageSource();

        assertTrue(source.contains("You Might Also Like"));


        Thread.sleep(2000);



        driver.findElement(By.id("rafael")).click();

        driver.quit();





//        System.setProperty("webdriver.gecko.driver","/Users/oyatsirojev/Documents/drivers/geckodriver");
//        WebDriver driver = new FirefoxDriver();
//       driver.get("https://www.duotech.io/");

       // System.setProperty("webdriver.edge.driver","/Users/oyatsirojev/Documents/drivers/msedgedriver");
      //  WebDriver driver = new EdgeDriver();
       // driver.get("http://duotifyapp.us-east-2.elasticbeanstalk.com/register.php");
    }
}
