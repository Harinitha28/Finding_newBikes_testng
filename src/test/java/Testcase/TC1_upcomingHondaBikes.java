package Testcase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.UpcomingBikePage;
import Utilities.ExcelUtils;

public class TC1_upcomingHondaBikes  {
HomePage hp;
UpcomingBikePage ubp;
ExcelUtils excel;
WebDriver driver;	

	 @Test(priority=1,groups= {"smoke","regression","master"})
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
		 hp= new HomePage(BaseClass.driver);// creating object for home page 
		
		 hp.hoverNewBikes() ; //to hover new Bikes
		// screenShot("HomePage");
		 hp.clickUpcomingBikes();  System.out.println("Upcoming Bikes Clicked");//to click upcoming bikes
		
	
	 }
	 
	 @Test(priority=2,groups= {"smoke","regression","master"})
	
		public void select_manufac_Honda() {  
			 ubp= new UpcomingBikePage(BaseClass.driver);  //creating object for upcoming Bike page 
			 ubp.selectManufacturer();         
			 ubp.selectHonda(); System.out.println("Honda selected ");
		
		}
	 
	 @Test(priority=3,groups= {"regression","master"})
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
		 
	         
	       
	 
	 
}
