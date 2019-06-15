package TestNG_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class xpedia_waits {


    static WebDriver driver;

    @BeforeClass
    public static void setUp() throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        driver=new ChromeDriver();

        driver.manage().window().fullscreen();

        driver.get("https://www.expedia.com/");

        //After 5 sec if page elements on the page is not displayed not loaded yet. It will throw NoSuchElementException.
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @Test
    public static void test1() throws InterruptedException {

        WebElement flight=driver.findElement(By.id("tab-flight-tab-hp"));

        flight.click();

        WebElement flyingFrom=driver.findElement(By.xpath("//input[@id='flight-origin-hp-flight']"));

        flyingFrom.sendKeys("Chicago");

        flyingFrom.sendKeys(Keys.ARROW_DOWN);

        flyingFrom.sendKeys(Keys.ENTER);

        WebElement flyingTo=driver.findElement(By.xpath("//input[@id='flight-destination-hp-flight']"));

        flyingTo.sendKeys("Los Angeles");
        Thread.sleep(1000);

        flyingTo.sendKeys(Keys.ARROW_DOWN);
        flyingTo.sendKeys(Keys.ENTER);

        WebElement returning=driver.findElement(By.xpath("//input[@id='flight-returning-hp-flight']"));

        returning.sendKeys("06/29/2019");
        Thread.sleep(1000);


        WebElement departing=driver.findElement(By.xpath("//input[@id='flight-departing-hp-flight']"));

        departing.sendKeys("06/27/2019");
        Thread.sleep(1000);

        WebElement search=driver.findElement(By.xpath("(//button[@class='btn-primary btn-action gcw-submit'])[1]"));

        Thread.sleep(1000);

        WebElement traveler=driver.findElement(By.id("traveler-selector-hp-flight"));
        traveler.click();
        Thread.sleep(1000);


        search.click();

        WebElement nonStop=driver.findElement(By.id("stopFilter_stops-0"));

        nonStop.click();

    }
}