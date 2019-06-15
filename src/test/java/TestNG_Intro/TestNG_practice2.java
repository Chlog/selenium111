package TestNG_Intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG_practice2 {
  static  WebDriver driver;
    @BeforeClass

    public void setUp(){


        WebDriverManager.chromedriver().setup();

        driver=new ChromeDriver();

        driver.manage().window().maximize();
    }

    @Test(priority=2)
    public static void test1(){

        WebElement firstName=driver.findElement(By.xpath("input[@name='fistname']"));
        firstName.sendKeys("Muammer");

        WebElement lastName=driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Turan");
    }
    @Test(priority=1)//priority=1 ,giving us chance to run method first with =1.
    public static void test2(){
        WebElement onlineTraining=driver.findElement(By.xpath("(//span[@class='menu-text'])[55]"));

        Actions action=new Actions(driver);


        action.moveToElement(onlineTraining);

        if(onlineTraining.isDisplayed()){
            System.out.println("online training is displayed");
        }else{
            System.out.println("online training is not displayed");
        }


        WebElement selTraining=driver.findElement(By.xpath("(//span[@class='menu-text'])[56]"));

        System.out.println(selTraining.getText());

        System.out.println(selTraining.getText());
        //"isDisplayed "method is returning true, if out element is dispayed,if not will return false;
        System.out.println("this is respond from isDisplayed method "+selTraining.isDisplayed());
    }
}
