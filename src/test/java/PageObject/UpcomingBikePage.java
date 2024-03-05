package PageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Testcase.BaseClass;
import selenium.BaseClassBike;

public class UpcomingBikePage extends BasePage {

	
	
	//constructor 
	public UpcomingBikePage  (WebDriver driver) 
	{
		super(driver);
		
	}
	
	//WebElement locator+idenfication
	
	@FindBy (xpath="//option[normalize-space()='-- Manufacturers --']")
	WebElement manufacturer;
	
	@FindBy (xpath="//option[normalize-space()='Honda']")
	WebElement Honda;
	
	@FindBy (xpath=	"//*[@data-track-label='model-name']")
	public List<WebElement> bikeName;
	
	@FindBy (xpath=	"//*[@class='b fnt-15']")
	public List<WebElement> bikePrice;
	
	@FindBy (xpath=	"//div[@class='clr-try fnt-14']")
    public 	List<WebElement> launchDate;
	
	@FindBy (xpath=	"//span[@class='zw-cmn-loadMore']")
	WebElement viewmore;
	
	@FindBy (xpath=	"//a[normalize-space()='Used Cars']")
	WebElement usedcar;
	
	
	
	//Action
	public void selectManufacturer() {
		manufacturer.click();
	}
	public void selectHonda() {
		
		Honda.click();
	}
	public List<WebElement> BikeNameList(){
		return bikeName;
	}
	public List<WebElement> BikePriceList(){
		return bikePrice;
	}
	public List<WebElement> BikeLaunchDateList(){
		return launchDate;
	}
	public void BikeListViewmore(){
		JavascriptExecutor js = (JavascriptExecutor)BaseClass.driver;
        js.executeScript("arguments[0].click();",  viewmore);
	}
	public void hoverUsedcar() {
		 Actions act1= new Actions(BaseClass.driver);
		 act1.moveToElement(usedcar).perform();
	}
	
			
			
}
