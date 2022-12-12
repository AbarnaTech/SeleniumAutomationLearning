package nopHRMlogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonLogin {
	WebDriver driver;
	@Test
	public void Amazonlogin() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//String url="https://www.amazon.in/";
		String url="https://www.hyrtutorials.com/p/add-padding-to-containers.html";
		driver.get(url);
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//h2[text()='Shop for your baby by age']//parent::div//following-sibling::div[@class=\"a-cardui-footer\"]//child::a[text()='See more']")).click();
		WebElement checkbox=driver.findElement(By.xpath("//td[text()='Helen Bennett']//preceding-sibling::td//input[@type='checkbox']"));
		checkbox.click();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.quit();
	}

}
