package seleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1 {

   static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");
       // driver.navigate().to("www.amazon.com");   different way how to navigate to webpage.
//driver.getTitle method will return to us title of current page/
            Assert.assertEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs &amp; more",driver.getTitle());//Assert is a static method
//       <TagName>[@Attribute='Attribute value']--> this is Xpath ,how to check uniq element or no.

        // Absolute xpath->searching elements from the beginning one by one!its very difficult inefficiant  way to find an elements
        // Relative xpath->searching elements starting from slash /.


    }
}
