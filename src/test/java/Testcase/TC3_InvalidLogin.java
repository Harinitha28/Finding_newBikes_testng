package Testcase;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import PageObject.HomePage;

public class TC3_InvalidLogin {
HomePage hp;

@Test(priority=7,groups= {"smoke","regression","master"})
	 public void LoginWithInvalidEmail() throws InterruptedException {
		hp=new HomePage(BaseClass.driver);
		hp.clickLogin();
		hp.clickGoogle();
		 
		 Set<String> allWindowHandles = BaseClass.driver.getWindowHandles(); // to handle multiple windows
	      String[] windowId=allWindowHandles.toArray(new String[allWindowHandles.size()] );
	      BaseClass.driver.switchTo().window(windowId[1]);
	      hp.email(); 
}

@Test(priority=8,groups= {"regression","master"})
public void capturingErrorMessage() {
	JavascriptExecutor js = (JavascriptExecutor)BaseClass.driver;
	js.executeScript("arguments[0].click();", hp.next);// to click next using javascript excecutor 
	try {
		  Thread.sleep(10000);
		  
	}
	catch(Exception e) {
		  
	}
	
	System.out.println("Error Message: "+ hp.errormsg.getText());

}
}
