package PageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testcase.BaseClass;
import selenium.BaseClassBike;

public class PopularModel extends BasePage {

	
	
	public PopularModel (WebDriver driver) 
	{
		super(driver);
		
	}
	
	
	
	@FindBy (xpath ="//span[@onclick=\"goToUrl('/used-car/Chennai')\"]")
	public WebElement chennai;
	
	@FindBy (xpath=	"//*[@class='zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10']//label")
	public List<WebElement> popularmodel;
	
	@FindBy (xpath ="//a[@class='zw i-b mt-10 pt-2 zw-srch-logo']")
	public WebElement zigwheelslogo;
	
	
	//Action
		public void selectChennai() {
			chennai.click();
		}
	    public List<WebElement> popularModelList(){
			return popularmodel;
		}
	    public void selectLogo() {
			zigwheelslogo.click();
		}
	    
	    public void scroll() {
			  JavascriptExecutor js= (JavascriptExecutor)BaseClass.driver;
	          js.executeScript("window.scrollBy(0,300)","");
		}
	
	
	
	
	

}
