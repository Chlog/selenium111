package ActionPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class secondSeleniumClass {


        public static void main(String[] args) {

            WebDriverManager.chromedriver().setup();
            WebDriver driver=new ChromeDriver();
            driver.manage().window().maximize();


            driver.get("https://www.expedia.com");
            WebElement searchDest= driver.findElement(By.xpath("//input[@id='package-destination-hp-package']"));
            searchDest.sendKeys("Tampa");


        }


    }


