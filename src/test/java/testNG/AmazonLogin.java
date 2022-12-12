package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReadConfig;

public class AmazonLogin {

	 WebDriver driver;
	    ReadConfig conf;
	//Priority
    //by default priority : 0
    //If priority is same, execution of method as per naming con alphabetic order
    //highest negative number having highest priority 
    
    
    
    @BeforeTest
    public void launchApp() throws Exception {
        
    	System.out.println("launching application");
        
        
        //create an Object on ReadConfig file
        conf = new ReadConfig();
        System.out.println(conf.get_testURL());
        
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(conf.get_testURL());
        driver.manage().window().maximize();
        
    }
    
    @AfterTest
    public void closeApp() throws Exception {
        
    	Thread.sleep(5000);
        driver.close();
        System.out.println("closing application");
        
    }
   /* 
    @Test(priority = -1)
    public void login() {
        
        System.out.println("login test case");
        
    }
    
    @Test(priority = 2)
    public void logout() {
        
        System.out.println("logout test case");
        
    }
    
    @Test
    public void addItems() {
        
        System.out.println("addItems test case");
        
    }
    
    @Test
    public void payment() {
        
        System.out.println("payment test case");
        
    }*/

}
