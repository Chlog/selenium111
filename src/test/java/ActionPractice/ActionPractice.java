package ActionPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionPractice {
    static WebDriver driver;
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        driver=new ChromeDriver();

        driver.manage().window().fullscreen();

        String url="http://the-internet.herokuapp.com/";
                driver.get(url);
        WebElement fileUpload=driver.findElement(By.linkText("File Upload"));

        fileUpload.click();
                                                  //Alt+tab switching window in intelij
                                               //Ctrl+tab --switch application to application

        WebElement chooseFile=driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("C:\\Users\\golan\\Pictures\\upload.png");
        WebElement uploadButton=driver.findElement(By.id("file-submit"));

        uploadButton.click();
        //Write the code if filled  name is matching, print true,if not print false.

        String expectedMessage1="upload.png";
        String actualMessage1=driver.findElement(By.id("uploaded-files")).getText();

        if(expectedMessage1.equals(actualMessage1)){
            System.out.println("TRUE");
        }else{
            System.out.println("FALSE");
        }


        driver.get("https://www.primefaces.org/showcase/ui/misc/effect.xhtml");
        WebElement slide=driver.findElement(By.id("slide_content"));

        Actions action=new Actions(driver);//Action using with perform() every time!!!
        action.doubleClick(slide).perform();//perform this is last step  what we need to use to perform our actions.


        driver.navigate().to("http://demo.guru99.com/test/simple_context_menu.html");
        WebElement rightClick=driver.findElement(new By.ByCssSelector(".context-menu-one"));
        // contextClick- is RIGHT mouse CLICK IN SELENIUM!!!
        action.contextClick(rightClick).perform();


        driver.get("https://www.toolsqa.com/automation-practice-form/");

        WebElement tools=driver.findElement(By.xpath("//a[@data-level='1'])[33]"));

        action.moveToElement(tools).perform();

        action.sendKeys(Keys.ARROW_DOWN).perform();//moving our scroll down ,same with (Keys.ARROW_UP).perform();

        //RESPONSIVE WEBSITE-this is term which mean that any desktop,mobil or other website what  you are minimizing
        //page its still be able to show all page elements with low zoom size.


        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droptarget"));

        action.dragAndDrop(source, target).perform();


        //WebElement uploadButton=driver.findElement(By.id(""))





    }
}
