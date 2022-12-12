package nopHRMlogin;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class NopCommerceLogin {
	WebDriver driver;
	@Test
	public void noplogin() throws Exception {
		try {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		String url="https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F";
		driver.get(url);
		Thread.sleep(5000);
		WebElement username=driver.findElement(By.id("Email"));
		WebElement password=driver.findElement(By.name("Password"));
		WebElement rememberme=driver.findElement(By.id("RememberMe"));
		WebElement login=driver.findElement(By.tagName("button"));
		username.clear();
		username.sendKeys("admin@yourstore.com");
		password.clear();
		password.sendKeys("admin");
		rememberme.click();
		login.click();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		List<WebElement> optionslist = driver.findElements(By.tagName("li"));
		System.out.println(optionslist.size());
		driver.findElement(By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a/p")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p")).click();
        
		
		Thread.sleep(4000);
		WebElement logout=driver.findElement(By.linkText("Logout"));
		logout.click();
		}finally {
		
		driver.close();
		driver.quit();
		}
	}
	
}
