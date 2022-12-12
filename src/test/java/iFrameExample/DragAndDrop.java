package iFrameExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {
    WebDriver driver;
    
    @BeforeTest
    public void loadPage() throws Exception {
         String url = "https://www.globalsqa.com/demo-site/draganddrop/";
         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.get(url);
         driver.manage().window().maximize();
         Thread.sleep(1000);
         
    }
    
    @AfterTest
    public void closePage() throws Exception {
        Thread.sleep(5000);
        driver.close();
    }

        
    
    @Test
    public void dragdrop() throws Exception {
        
        WebElement iframe_img = driver.findElement(By.xpath("//iframe[contains(@data-src,'photo')]"));
        driver.switchTo().frame(iframe_img);
        WebElement img3 = driver.findElement(By.cssSelector("img[src*='tatras3']"));
        WebElement img4 = driver.findElement(By.cssSelector("img[src*='tatras4']"));
        WebElement trash = driver.findElement(By.cssSelector("div#trash"));
        
        //Create an Object of Actions class
        Actions act = new Actions(driver);
        act.dragAndDrop(img3, trash).perform();
        Thread.sleep(4000);
        act.clickAndHold(img4).moveToElement(trash).release().perform();

        
    }
}
