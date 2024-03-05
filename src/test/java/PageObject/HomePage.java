package PageObject;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


import Testcase.BaseClass;


public class HomePage extends BasePage {
	

	
	
	//constructor 
	public HomePage  (WebDriver driver) 
	{
		super(driver);
		
	}
	
	//WebElement locator+idenfication

	@FindBy(xpath="//input[@id='i0118']")
	WebElement signIn;
	
	@FindBy(xpath="//input[@id='idSIButton9']")
	WebElement nextsignin;
	
	@FindBy(xpath="//div[@data-bind=\\\"css: { 'inline-block': true }, externalCss: { 'button-item': true }\\\"]")
	WebElement no;
	
	@FindBy (xpath="//a[normalize-space()='New Bikes']")
	WebElement newBikes;
	
	@FindBy (xpath="//span[@onclick=\"goToUrl('/upcoming-bikes')\"]")
	WebElement upcomingBikes;
	
	@FindBy (id="forum_login_title_lg")
	WebElement login;
	
	@FindBy (xpath="//div[@class='newgf-login']//div[@class='lgn-sc c-p txt-l pl-30 pr-30 googleSignIn']")
	WebElement google;
	

	@FindBy (id="identifierId")
	WebElement input;

	@FindBy (xpath="//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 qIypjc TrZEUc lw1w4b']//div[@class='VfPpkd-RLmnJb']")
	public WebElement next;
	
	@FindBy (xpath="//div[@class='o6cuMc Jj6Lae']")
	public WebElement errormsg;
	
	
	
	//Action
	 public void signIn()
	    {
	    	signIn.sendKeys(Keys.RETURN);
	    }
	    
	    public void clickNext()
	    {
	    	nextsignin.click();
	    }
	    
	    public void clickNo()
	    {
	    	no.click();
	    }
	public void  hoverNewBikes() {
		 Actions act= new Actions(BaseClass.driver);
		 act.moveToElement(newBikes).perform();
	}
	
	public void clickUpcomingBikes()
	{
		upcomingBikes.click();
	}
	
	public void clickLogin()
	{
		login.click();
	}
	public void clickGoogle()
	{
		google.click();
	}
	public void email()
	{
		input.sendKeys("abc@gmail.com");
	}
	public void clickEmailnext()
	{
		next.click();
	}
	public void captureErrorMessage()
	{
		errormsg.click();
	}

}
