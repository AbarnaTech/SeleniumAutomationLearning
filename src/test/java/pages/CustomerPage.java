package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import tests.BaseTest;

public class CustomerPage extends BaseTest {
	WebDriver driver;

    public CustomerPage(WebDriver rdriver) {

        // this.driver = driver;
        driver = rdriver;
    }

    By cust_0 = By.xpath("//a[@href=\"#\"]//child::p[contains(text(),'Customers')]");
    By cust_1 = By.xpath("//a[@href='/Admin/Customer/List']//child::p[contains(text(),'Customers')]");
    By btnaddnew = By.xpath("//a[@class='btn btn-primary']");
    
    public void clickcust_0(){
    	driver.findElement(cust_0).click();
    }
    
    public void cliccust_1() {
    	driver.findElement(cust_1).click();
    }
    
    public void clickaddnew() {
    	driver.findElement(btnaddnew).click();
    }

}
