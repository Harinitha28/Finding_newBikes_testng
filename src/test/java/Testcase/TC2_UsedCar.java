package Testcase;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import PageObject.PopularModel;
import PageObject.UpcomingBikePage;
import Utilities.ExcelUtils;

public class TC2_UsedCar  {
	UpcomingBikePage ubp;
	PopularModel pm;
	ExcelUtils excel;
	
	@Test(priority=4,groups= {"smoke","regression","master"})
	 public void hoverusedcar_clickChennai1()  {
		 ubp= new UpcomingBikePage(BaseClass.driver);
    	ubp.hoverUsedcar();
    	pm= new PopularModel(BaseClass.driver);
	    pm.selectChennai() ;
	 }
	 
	 
	 
	@Test(priority=5,groups= {"regression","master"})
	 public void printing_popularmodel() throws IOException {
	    System.out.println("popular models in used car...");
		pm.scroll();
	   int j=1;
	   excel=new ExcelUtils();
	    for(int  i=0;i< pm.popularModelList().size();i++)
		 {
	    	String bklaunch=pm.popularModelList().get(i).getText();
			 System.out.println(bklaunch);
			 excel.writeData("Popular Model Cars", j, 0, bklaunch);
				j=j+1;
			 }
	   
	   }
	 
	 
	@Test(priority=6,groups= {"smoke","regression","master"})
	 
	 public void navigateToHome() throws InterruptedException
	 {	
	  pm.selectLogo();
	 Thread.sleep(5000);
	 }
	 
	 

}
