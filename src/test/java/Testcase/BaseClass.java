package Testcase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {
public static WebDriver driver;

public static org.apache.logging.log4j.Logger logger;
	
	@BeforeTest(groups={"smoke","regression","master"})
    @Parameters({"browser","url"})
	public  void setUp(String browser, String url) throws IOException 
	{	 

		
		//loading logger file
		logger=LogManager.getLogger(this.getClass());
		
		//launching browser
	 if(browser.equalsIgnoreCase("chrome")) {
		 ChromeOptions opt = new ChromeOptions();
		 opt.addArguments("--disable-notifications");
		 
	  driver=new ChromeDriver(opt);
	  System.out.println("Chrome Browser Launched.....");

	  }
	  else if (browser.equalsIgnoreCase("Edge")){
		 EdgeOptions opt = new EdgeOptions();
		  driver=new EdgeDriver(opt);
		  System.out.println("Edge Browser Launched.....");
	  }
	  else  {
		  driver=new FirefoxDriver();
		  System.out.println("Firefox Browser Launched.....");
	  }
	 logger.info("******Driver Launched****");
	  driver.get(url);
      driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  
	}
	 @AfterTest(groups={"smoke","regression","master"})
	 public void tearDown() {
	driver.quit();
	logger.info("****Driver closed******");
	  }
	 
	 @AfterMethod
	   public String screenShot(String name) { //screenshot 
	    	String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				File scrFile = ((TakesScreenshot)BaseClass.driver).getScreenshotAs(OutputType.FILE);
				//The below method will save the screen shot in d drive with name "screenshot.png"
				String screenshotpath=System.getProperty("user.dir")+"\\screenshots\\"+name+"timestamp"+".png";
				File screenShotName = new File(screenshotpath);
				try {
					FileUtils.copyFile(scrFile, screenShotName);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return screenshotpath;
			
	    }
    
}
