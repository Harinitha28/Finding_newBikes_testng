package selenium;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Utilities.ExcelUtils;

public class login {
	public  static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions opt = new ChromeOptions();
		driver= new ChromeDriver(opt);
				driver.get("https://www.zigwheels.com/");
			driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			  
			  
		
			  
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
      
      
      
      /*  public void validate_HondaBike_under_4L() throws IOException {
    	
    
    	
    	 JavascriptExecutor js = (JavascriptExecutor)driver;
           js.executeScript("arguments[0].click();", ubp.BikeListViewmore());
           
           
           System.out.println("Honda bikes under 4Lakh");
           
          
           
   	 for(int i=0;i<ubp.bikeName.size();i++)
	 {  
	 String bkPrice=ubp.bikePrice.get(i).getText();
	 if(bkPrice.contains("Lakh"))
	 {
	 String price[]=bkPrice.split(" ");
	   float val = Float.parseFloat(price[1]);
	   if(val<=4.0  ) {

        System.out.println(ubp.bikeName.get(i).getText()+"  -----   "+ubp.bikePrice.get(i).getText()+ "  -----  "+ubp.launchDate.get(i).getText());
       //span[@class='zw-cmn-loadMore']
	   }	
	 }
         
       
 else {
		 System.out.println(ubp.bikeName.get(i).getText()+"    ||   "+ubp.bikePrice.get(i).getText()+ "  ||  "+ubp.launchDate.get(i).getText());
	 } 
	                   

	 }} 
    	 */
       
      
      
      /*
        ubp.BikeListViewmore();
           
           
           List<WebElement> bikeNames=ubp.BikeNameList();
   		List<WebElement> bikePrices=ubp.BikePriceList();
   		List<WebElement> bikeLaunch=ubp.BikeLaunchDateList();
   		
   		System.out.println("======================================================================");
   		System.out.println("New Honda Bikes Under 4.0 lakh");
   		System.out.println();
   		
   		ExcelUtilst excel=new ExcelUtilst();
   		excel.createSheets();
   		int j=1;
   		for(int i=0;i<bikeNames.size();i++) {
   			
   			String bkname=bikeNames.get(i).getText();
   			String bkprice=bikePrices.get(i).getText();
   			String bklaunch=bikeLaunch.get(i).getText();
   			
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
   		

       */

	}
        
	
}
