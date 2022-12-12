package nopComm;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReadConfig;

public class BaseTest {
	 WebDriver driver;
	    ReadConfig conf;
	    Logger log;
	    //ctrl+Shoift+O ----- autoimport
	    //pre-condition    ----- @BeforeSuite-----
	    //Test
	    //post-condition   ----- @AfterSuite
	    
	    @Parameters("ibm_br")
	    @BeforeTest
	    public void launchApp(String ibm_browser) throws Exception {
	    
	        
	        /*System.out.println("launching application");
	        
	        
	        //create an Object on ReadConfig file
	        conf = new ReadConfig();
	        System.out.println(conf.get_NOP_URL());
	        
//	        WebDriverManager.chromedriver().setup();
//	        driver = new ChromeDriver();
	        System.out.println("Execution on browser : " + ibm_browser);
	        
	        if(ibm_browser.equalsIgnoreCase("CHROME")) {
	            
	            driver = new ChromeDriver();
	            
	        }
	        else if(ibm_browser.equalsIgnoreCase("edge")) {
	            
	            driver = new EdgeDriver();
	        }
	        else {
	            
	            System.out.println("Execution on deafult browser");
	            driver = new ChromeDriver();
	        }
	        driver.get(conf.get_NOP_URL());
	        driver.manage().window().maximize();*/
	            
	            log = Logger.getLogger("NOP Comm Application Module");
	            PropertyConfigurator.configure(".\\testdata\\log4j.properties");
	            
	            
	            log.info("launching application");
	            //System.out.println("launching application");
	            
	            
	            //create an Object on ReadConfig file
	            conf = new ReadConfig();
	            //System.out.println(conf.get_NOP_URL());
	            log.info("Application URL: "+ conf.get_NOP_URL());
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	            driver.get(conf.get_NOP_URL());
	            log.info("Application launched successfully into chrome browser "+ conf.get_NOP_URL());
	            //driver.get(conf.get_sampleApp_URL());
	            driver.manage().window().maximize();
	        
	    }
	    
	    @AfterTest
	    public void closeApp() throws Exception {
	        
	        Thread.sleep(5000);
	        driver.close();
	        log.info("Closing application");
//	        System.out.println("closing application");
	    }

}
