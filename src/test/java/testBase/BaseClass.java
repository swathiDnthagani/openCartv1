
	
	
	package testBase;

	import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Parameters;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass {
		public WebDriver driver;
		public Logger logger; //for logging 
		public ResourceBundle rb;
		
		@BeforeClass()
		@Parameters({"browser"})
		public void setup(String br) {
			rb = ResourceBundle.getBundle("config");
			//logging
			logger=LogManager.getLogger(this.getClass()); //for Logging
			//Drivers
					if(br.equals("chrome"))
					{
						WebDriverManager.chromedriver().setup();
						driver=new ChromeDriver();
						
				
						logger.info("Launched Chrome Browser");
					}
					else if(br.equals("edge"))
					{
						WebDriverManager.edgedriver().setup();
						driver=new EdgeDriver();
						//System.setProperty("webdriver.edge.driver","C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
						 //driver=new EdgeDriver();
						
						 
						logger.info("Launched Edge Browser");
					
					}
					else if(br.equals("firefox"))
					{	
						WebDriverManager.firefoxdriver().setup();
						driver=new FirefoxDriver();
						//System.setProperty("webdriver.gecko.driver","C:\\Drivers\\geckodriver-v0.29.0-win64\\geckodriver.exe");
						 //driver=new FirefoxDriver();
						logger.info("Launched Firefox Browser");
					
					}
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				}
				

		@AfterClass
		public void tearDown() {
				driver.close();				
			}
		//To create a random Test data.....
		public String randomestring() {
		String	generatedString=RandomStringUtils.randomAlphabetic(5);
		return(generatedString);
		}

		//for integer values
		public int Randomestring2() {
			String generatednumericString=RandomStringUtils.randomNumeric(5);
		return(Integer.parseInt( generatednumericString));
		}
		
		public void captureScreen(WebDriver driver, String tname) throws IOException {
			TakesScreenshot ts= (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target= new File(System.getProperty("User.dir")+tname);
			FileUtils.copyFile(source,target);
			
		

		}
	}
