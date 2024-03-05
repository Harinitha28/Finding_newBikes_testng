package selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.PopularModel;
import PageObject.UpcomingBikePage;
import Utilities.ExcelUtils;



public class BaseClassBike extends ExcelUtils{
	public static   WebDriver driver;
	HomePage hp;
	UpcomingBikePage ubp;
	PopularModel pm;
	int i;
	 String bkPrice;
	 ExcelUtils excel;
		
	
    @BeforeClass
    @Parameters({"browser","url"})
	public  void setUp(String browser, String url) 
	{	 
		
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
	  driver.get(url);
      driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  
	}
    
    
    
    
	
	 @Test(priority=1)
	 public void select_Newbikes_upcomingBikes() throws InterruptedException {

		 //for authenication 
			try {
				hp.signIn();
				hp.clickNext();
				hp.clickNo();
			}
			catch (Exception e){
				
			}
			Thread.sleep(6000);
		 hp= new HomePage(BaseClassBike.driver);// creating object for home page 
		 screenShot("HomePage");
		 hp.hoverNewBikes() ; //to hover new Bikes
		 hp.clickUpcomingBikes();  System.out.println("Upcoming Bikes Clicked");//to click upcoming bikes
		
	
	 }
	 
	 
	 
	 
	 @Test(priority=2)
	public void select_manufac_Honda() {  
		 ubp= new UpcomingBikePage(driver);  //creating object for upcoming Bike page 
		 ubp.selectManufacturer();         
		 ubp.selectHonda(); System.out.println("Honda selected ");
		 screenShot("HondaSelection");
	}
	 
	 
	 
	 
	 @Test(priority=3)
    public void validate_HondaBike_under_4L() throws IOException {
    	 ubp.BikeListViewmore();
         
        System.out.println("======================================================================");
   		System.out.println("New Honda Bikes Under 4.0 lakh.....");
   		System.out.println();
   		
   		 excel=new ExcelUtils();
   		excel.createSheets();
   		int j=1;
   		for(int i=0;i<ubp.BikeNameList().size();i++) {
   			
   			String bkname=ubp.BikeNameList().get(i).getText();
   			String bkprice=ubp.BikePriceList().get(i).getText();
   			String bklaunch=ubp.BikeLaunchDateList().get(i).getText();
   			
   			if(bkprice.contains("Lakh")) {
   				String[] price=bkprice.split(" ");
   				float value=Float.parseFloat(price[1]);
   				if(value<=4.0) {
   					System.out.println(bkname+"  ---  "+bkprice+"  ---  "+bklaunch);
   					excel.writeData("Honda Bikes <4L", j, 0, bkname);
   					excel.writeData("Honda Bikes <4L", j, 1, bkprice);
   					excel.writeData("Honda Bikes <4L", j, 2, bklaunch);
   					j=j+1;
   				}
   			}
   			else {
   				System.out.println(bkname+"  ---  "+bkprice+"  ---  "+bklaunch);
   				excel.writeData("Honda Bikes <4L", j, 0, bkname);
   				excel.writeData("Honda Bikes <4L", j, 1, bkprice);
   				excel.writeData("Honda Bikes <4L", j, 2, bklaunch);
   				j=j+1;
   			}
   			
   		}
   		System.out.println("======================================================================");
   		
   		
   	}
	 
         
       

    	 
    	 
    	 
    @Test(priority=4)
	 public void hoverusedcar_popularModels() throws IOException {
    	ubp.hoverUsedcar();
    	pm= new PopularModel(driver);
	    pm.selectChennai() ;
	    System.out.println("popular models in used car...");
		pm.scroll();
	   int j=1;
	    
	    for( i=0;i< pm.popularModelList().size();i++)
		 {
	    	String bklaunch=pm.popularModelList().get(i).getText();
			 System.out.println(bklaunch);
			 excel.writeData("Popular Model Cars", j, 0, bklaunch);
				j=j+1;
			 }
	    screenShot("usedCar");
	   
   		
	  
	  }
    
    
	 
	 
	 @Test(priority=5)
	 
	 public void navigateToHome() throws AWTException, InterruptedException
	 {	
	  pm.selectLogo();
	 Thread.sleep(5000);
	 }
	 
	 
	 
	 
	 @Test(priority=6)
	 public void LoginWithInvalidEmail() throws InterruptedException {
		 hp.clickLogin();
		hp.clickGoogle();
		 screenShot("GoogleClick");
		 Set<String> allWindowHandles = driver.getWindowHandles(); // to handle multiple windows
	      String[] windowId=allWindowHandles.toArray(new String[allWindowHandles.size()] );
	      driver.switchTo().window(windowId[1]);
	      hp.email(); 
	     JavascriptExecutor js = (JavascriptExecutor)driver;
	       js.executeScript("arguments[0].click();", hp.next);// to click next using javascript excecutor 
	      try {
	    	  Thread.sleep(10000);
	    	  
	      }
	      catch(Exception e) {
	    	  
	      }
	       screenShot("Login error");
	       System.out.println("Error Message: "+ hp.errormsg.getText());
	     
	      
	   		
	       
	      
	       
	 }	 
	 
	 

	 @AfterClass
	 public void tearDown() {
	driver.quit();
	  }
	 
	 
	 
	 
	 
    public static String screenShot(String name) { //screenshot 
    	String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			File scrFile = ((TakesScreenshot)BaseClassBike.driver).getScreenshotAs(OutputType.FILE);
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
