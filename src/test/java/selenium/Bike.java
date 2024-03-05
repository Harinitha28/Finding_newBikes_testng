package selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Bike {
	public   WebDriver driver;
@BeforeClass

	public  void setUp() throws InterruptedException, AWTException 
	{	 
		
	
	  
	  		
	driver= new ChromeDriver();
		driver.get("https://www.zigwheels.com/");
	driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  
	}
	
	 @Test(priority=1)
    public void upcomingbike() {
	  WebElement newBike=driver.findElement(By.xpath("//a[normalize-space()='New Bikes']"));
	 Actions act= new Actions(driver);
	 act.moveToElement(newBike).perform();
	 //driver.findElement(By.xpath("//span[normalize-space()='Upcoming Bikes']")).click();
	 
	 WebElement upcomingBike=driver.findElement(By.xpath("//span[normalize-space()='Upcoming Bikes']"));
	 upcomingBike.click();
	 
	 WebElement manufacturer=driver.findElement(By.xpath("//option[normalize-space()='-- Manufacturers --']"));
	//option[normalize-space()='-- Manufacturers --']
	 manufacturer.click();	
	 WebElement honda=driver.findElement(By.xpath("//option[normalize-space()='Honda']")); 
	//option[normalize-space()='Honda']
	 honda.click();



     JavascriptExecutor js = (JavascriptExecutor)driver;
 
    WebElement viewmore= driver.findElement(By.xpath("//span[@class='zw-cmn-loadMore']"));
      js.executeScript("arguments[0].click();", viewmore);
	 
 List<WebElement> bikeName= driver.findElements(By.xpath("//*[@data-track-label='model-name']"));
	 List<WebElement> bikePrice= driver.findElements(By.xpath("//*[@class='b fnt-15']"));
	 List<WebElement> launchDate= driver.findElements(By.xpath("//div[@class='clr-try fnt-14']"));
	 System.out.println("Honda bikes under 4Lakh");
	
	 
	 
	 for(int i=0;i<bikeName.size();i++)
	 {  
	 String bkPrice=bikePrice.get(i).getText();
	 if(bkPrice.contains("Lakh"))
	 {
	 String price[]=bkPrice.split(" ");
	   float val = Float.parseFloat(price[1]);
	   if(val<=4.0  ) {

        System.out.println(bikeName.get(i).getText()+"  -----   "+bikePrice.get(i).getText()+ "  -----  "+launchDate.get(i).getText());
       //span[@class='zw-cmn-loadMore']
	   }	
	 }
         
       
 else {
		 System.out.println(bikeName.get(i).getText()+"    ||   "+bikePrice.get(i).getText()+ "  ||  "+launchDate.get(i).getText());
	 } }
	
	 
	  
	  
	 
	 
	 }
	 
	 @Test(priority=2)
	 public void usedcar() {
	 
	 WebElement usedcar=driver.findElement(By.xpath("//a[normalize-space()='Used Cars']"));
	Actions act1= new Actions(driver);
	 act1.moveToElement(usedcar).perform();
	 
	 
	
	 WebElement chennai=driver.findElement(By.cssSelector("span[onclick=\"goToUrl('/used-car/Chennai')\"]"));
	 chennai.click();
	 
	 
	 List<WebElement> popularCar= driver.findElements(By.xpath("//*[@class='zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10']//label"));
	 System.out.println("popular models in used car...");
	 for(int i=0;i<popularCar.size();i++)
	 {
		 System.out.println(popularCar.get(i).getText());
	 }
	  
	 }
	 
	 
	 @Test(priority=3)
	 
	 public void Home() throws AWTException, InterruptedException {
	
	  WebElement logo=driver.findElement(By.xpath("//a[@class='zw i-b mt-10 pt-2 zw-srch-logo']"));
	 logo.click(); 
	 Thread.sleep(5000);
	 }
	 
	 @Test(priority=4)
	 public void loginInvalidEmail() throws InterruptedException
	 {
		 WebElement login=driver.findElement(By.id("forum_login_title_lg"));
	 
     login.click();	
     WebElement google=driver.findElement(By.xpath("//div[@class='newgf-login']//div[@class='lgn-sc c-p txt-l pl-30 pr-30 googleSignIn']"));
     google.click();
     
       
     Set<String> allWindowHandles = driver.getWindowHandles();
     String[] windowId=allWindowHandles.toArray(new String[allWindowHandles.size()] );
     
   
             
     driver.switchTo().window(windowId[1]);
     driver.findElement(By.id("identifierId")).sendKeys("abc@gmail.com");
     WebElement next=driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 qIypjc TrZEUc lw1w4b']//div[@class='VfPpkd-RLmnJb']"));

  
  
  
  JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("arguments[0].click();", next);
    Thread.sleep(10000);
   System.out.println("Error Message: "+ driver.findElement(By.xpath("//div[@class='o6cuMc Jj6Lae']")).getText() );
   
	 }

	 @AfterClass
	 public void tearDown() {
	driver.quit();
	  }
		

}