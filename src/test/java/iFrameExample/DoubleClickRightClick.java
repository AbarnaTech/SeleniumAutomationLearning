package iFrameExample;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DoubleClickRightClick {
WebDriver driver;
    
    @BeforeTest
    public void loadPage() throws Exception {
    	 WebDriverManager.chromedriver().setup();
    	 driver=new ChromeDriver();
         String url = "https://demo.guru99.com/test/simple_context_menu.html";
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
    public void RightClickTest() throws Exception {
        
        
        WebElement rightButton = driver.findElement(By.xpath("//span[text()='right click me']"));
        
        WebElement deleteButton = driver.findElement(By.xpath("//span[text()='Delete']"));
        
        
        //Create an Object of Actions class
        
        Actions act = new Actions(driver);
        act.contextClick(rightButton).perform();
        
        Thread.sleep(5000);
        deleteButton.click();
        //act.click(deleteButton).perform();
        
        //handle alert
        Alert alert_delete=driver.switchTo().alert();
        
        //validation step
        //Assert.assertTrue(driver.switchTo().alert().getText().contains("delete"));
        Assert.assertTrue(alert_delete.getText().contains("delete"));
        
        
        //dismiss
        alert_delete.accept();
        
    }
    
    
    @Test
    public void DoubleClickTest() throws Exception {
        
        WebElement doubleButton = driver.findElement(By.tagName("button"));
        
        //Create an Object of Actions class
        Thread.sleep(5000);
        Actions act = new Actions(driver);
        act.doubleClick(doubleButton).perform();
        
        //handle alert
        Alert alert_doubleclick = driver.switchTo().alert();
        
        
        //validation step  ---- alert Text
        Assert.assertTrue(alert_doubleclick.getText().contains("double"));
        
        
        //dismiss
        alert_doubleclick.dismiss();
        
    }

}
