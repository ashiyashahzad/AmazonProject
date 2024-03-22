package basePackageAmazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.TimeUtils;

public class BaseAmazonClass {
	

		public static Properties prop=new Properties();
		public static WebDriver driver;
		
		//step 1: creating constructor
		public BaseAmazonClass() {
			try
			{
				FileInputStream file=new FileInputStream("C:\\Users\\shahz\\eclipse-workspace\\Amazon\\src\\test\\java\\environmentvariables\\Config.properties");
				prop.load(file);
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			catch(IOException a) {
				a.printStackTrace();
			}
		}
		//step 2: creating a method to keep all common commands
		public static void initiate() {
			System.out.println("Initiate");
			
			String browsername=prop.getProperty("browser");//getting browser name from config file
			if(browsername.contentEquals("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
				driver=new FirefoxDriver();
			}
			else if(browsername.contentEquals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				driver=new ChromeDriver();
			}
			driver.manage().window().maximize(); // to maximize the window
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeUtils.timepage));
			driver.get(prop.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			}
		public void screenshot(String filename) {
			File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try
			{
			FileUtils.copyFile(file, new File("C:\\Users\\shahz\\eclipse-workspace\\Amazon\\src\\test\\java\\screenshots\\Screenshots"+filename+".jpg"));
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			}
		}




