package iFrameExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReadConfig;

public class IFrame_Ex {
    public WebDriver driver;
    public ReadConfig conf;
    //ctrl+Shoift+O ----- autoimport
    //pre-condition    ----- @BeforeSuite-----
    //Test
    //post-condition   ----- @AfterSuite
    
    
    @BeforeTest
    public void launchApp() throws Exception {
        
        System.out.println("launching application");
        
        
        //create an Object on ReadConfig file
        conf = new ReadConfig();
        
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        //driver.get(conf.get_NOP_URL());
        //driver.get("https://paytm.com/");
        driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?org/openqa/selenium/support/ui/Select.html");
        driver.manage().window().maximize();
        
    }
    
    @AfterTest
    public void closeApp() throws Exception {
        
        Thread.sleep(5000);
        driver.close();
        System.out.println("closing application");
    }

    @Test
    public void verifypayTMAccount() throws Exception {
    	//WebElement frame_1 = driver.findElement(By.cssSelector("iFrame[title*='All classes and interfaces']"));
    	
    	Thread.sleep(3000);
    	driver.switchTo().frame(1);
    	WebElement frame1= driver.findElement(By.cssSelector("[href*='Actions.html']"));
    	frame1.click();
    	
    	driver.switchTo().defaultContent();    	
    	
    	Thread.sleep(3000);
    	WebElement frame_2=driver.findElement(By.xpath("//*[contains(@src,'overview-summary.html')]"));
    	driver.switchTo().frame(frame_2);
//    	driver.switchTo().frame("classFrame");
    	driver.findElement(By.cssSelector("[href*='perform']")).click();
        
        /*Thread.sleep(3000);
        driver.findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
        Thread.sleep(3000);
        
        
        //Alert/frame/window    ----- driver.switchTo()
        //handle frame
        //Index
        //Name/ID
        //WebElement
        
        //driver.switchTo().frame(0);
        //driver.switchTo().frame("name/id");
        
        //WebElement myFrame = driver.findElement(By.tagName("iframe"));
        //WebElement myFrame = driver.findElement(By.xpath("//*[contains(@src,'login')]"));
        WebElement myFrame = driver.findElement(By.cssSelector("[src*='login']"));
        
        
        driver.switchTo().frame(myFrame);
        
        
        String PaytmHeading = driver.findElement(By.cssSelector(".heading")).getText();
        
        System.out.println(PaytmHeading);
        Assert.assertTrue(PaytmHeading.contains("Paytm Web account"));
        
        driver.findElement(By.xpath("//span[contains(text(),'Watch')]")).click();
        
        Thread.sleep(3000);*/
    }

}
