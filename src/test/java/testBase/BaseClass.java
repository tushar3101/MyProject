package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

//this class is made for achieve re-usability 
public class BaseClass {
	
	public org.apache.logging.log4j.Logger logger;
	public  WebDriver driver;
	public Properties p;	
	 
	
	@BeforeClass(groups = {"Sanity","Master","Regression"})
	
	public void setup() throws IOException {
			
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
				
		logger = LogManager.getLogger(this.getClass());
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("appURL")); //Reading properties from File
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	public void tearDown() {
		driver.quit();
	}
	
	

	public String randomString() {
		//RandomStringUtils is pre defined class which is present in common library
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
	public String randomNumber() {
		//RandomStringUtils is pre defined class which is present in common library
		String generatednumber=RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}
	
	public String randomAlphaNumeric() {
		//RandomStringUtils is pre defined class which is present in common library
		String generatednumber=RandomStringUtils.randomNumeric(5);
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return (generatednumber+"%"+generatedstring);
	}
}
