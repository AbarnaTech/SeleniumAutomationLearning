package iFrameExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReadConfig;

public class SwitchModel {
	public WebDriver driver;
    public ReadConfig conf;
    
    
    @BeforeTest
    public void launchApp() throws Exception {
        
        System.out.println("launching application");
        
        conf = new ReadConfig();
        
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("http://www.uitestpractice.com/Students/Switchto");
        driver.manage().window().maximize();
        
    }
    
    @AfterTest
    public void closeApp() throws Exception {
        
        Thread.sleep(5000);
        driver.close();
        System.out.println("closing application");
    }
    
    @Test
    public void switchModel() throws Exception {
    	Thread.sleep(5000);
    	driver.findElement(By.xpath("//button[contains(text(), 'Launch modal')]")).click();
    	Thread.sleep(4000);
    	//WebElement dialog=driver.findElement(By.className("modal-content"));
    	String title= driver.findElement(By.xpath("//h4[@class='modal-title']")).getText();
    	System.out.println(title);
    	String content = driver.findElement(By.xpath("//div[@class='modal-body']")).getText();
    	System.out.println(content);
    	driver.findElement(By.xpath("(//button[@data-dismiss='modal'])[3]")).click();
    	//dialog.findElement(By.xpath("//button[text(),'Ok']")).click();
    }

	
	

}
