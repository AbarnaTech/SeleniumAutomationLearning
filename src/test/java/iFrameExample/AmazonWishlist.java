package iFrameExample;

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

public class AmazonWishlist {
	 WebDriver driver;
	    
	    @BeforeTest
	    public void loadPage() throws Exception {
	         String url = "https://www.amazon.in/";
	         WebDriverManager.chromedriver().setup();
	         driver= new ChromeDriver();
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
	    public void alertHandle() throws Exception {
	        
	        
	        WebElement SignIn = driver.findElement(By.xpath("//span[text()='Hello, sign in']"));
	        
	        WebElement WishList = driver.findElement(By.xpath("//span[text()='Create a Wish List']"));
	        
	        
	        //Create an Object of Actions class
	        
	        Actions act = new Actions(driver);
	        
//	      //app1
//	      act.moveToElement(SignIn).perform();
//	      act.moveToElement(WishList).perform();
//	      act.click().perform();
//	      
//	      //app2
//	      act.moveToElement(SignIn).moveToElement(WishList).click().perform();
	        
	        //app3
	        act.moveToElement(SignIn).click(WishList).perform();

	        
	        //validation step
	        Assert.assertTrue(driver.getTitle().contains("Wish"));
	        
	    }

}
