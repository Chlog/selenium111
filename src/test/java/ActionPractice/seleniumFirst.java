package ActionPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumFirst {

static WebDriver driver;
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();

        driver=new ChromeDriver();

        driver.manage().window().maximize();
        String expectedUrl="https://the-internet.herokuapp.com";

        driver.get(expectedUrl);
      WebElement forgotPass =driver.findElement(By.linkText("Forgot Password"));
      forgotPass.click();//<---same ,look upper line.

        String actualUrl=driver.getCurrentUrl();
        if(expectedUrl.equals(actualUrl)){
            System.out.println("expected and actual url is matching");
        }else{
            System.out.println("test case is failed.Expected url is"+expectedUrl+"\n actual url is"+actualUrl);

            WebElement forgotPass1=driver.findElement(By.linkText("Forgot Password"));
            forgotPass.click();

            String expextedAfterForgotPAsswordPass="https://the-internet.herokuapp.com/forgot_password";
            String afterForgotPasword = driver.getCurrentUrl();

            if (expectedUrl.equals(afterForgotPasword)) {
                System.out.println("the expected and actual url is matching. after clicking forgot password");
            } else {
                System.out.println("actual and expected url is not matching after clicking forgot password");

                driver.findElement(By.id("email")).sendKeys("muammerturan@gmail.com");
                driver.findElement(By.id("form_submit")).click();

                //always for expected conditions is comming from business requarment.
                //1-do not ask the developer.
                //2-do not copy from application itself.
                //-possible scenario to get business requrement:
                //1-you can ask your Scrum Master.
                //2-you can ask the Business Analyst.
                //3-you can ask Product Owner.
                //4-you can find it under user story.
                //5-you can find it on confluence page.

                String expectedUrl1="http://the-internet.herokuapp.com/email_sent";
                String actualUrl1=driver.getCurrentUrl();

                if(expectedUrl1.equals(actualUrl1)){
                    System.out.println("expected and actual url is matching--Passed");
                }else{
                    System.out.println("Failled");
                    throw new Exception();
                }
                WebElement message=driver.findElement(By.id("content"));

                String expectedMessage="Your e=mail'seen sent!";
               String actualMessage= message.getText();

               if(expectedMessage.equals(actualMessage)){
                   System.out.println("TRUE");
               }else{
                   System.out.println("FALSE");
               }
               driver.navigate().back();//      <--this method to be able go back to previous page.
                driver.navigate().forward();//  <-method how to come forward .
                driver.navigate().refresh();//   <-method how to refresh page.

              //  driver.quit();  <-method will close ALL the opened tabs before.
              // driver.close(); <-method will close only one LAST tab,which was opened before .
            }
        }

        }


    }

