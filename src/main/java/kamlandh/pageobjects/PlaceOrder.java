package kamlandh.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import kamlandh.AbstractComponents.AbstarctClass;

public class PlaceOrder extends AbstarctClass{
	WebDriver driver;
	
	public PlaceOrder(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement EnterCountry;
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	List<WebElement >selectCountry;
	@FindBy(xpath="//div[@class='actions']/a")
	WebElement palceorder;
	@FindBy(xpath="//h1[@class='hero-primary']")
	WebElement message;
	
	
	By countryList=By.xpath("//section[@class='ta-item list-group-item ng-star-inserted']");
	//By message=By.xpath("//h1[@class='hero-primary']");
	
	public void placeeorderr (String Country)
	
	{
		Actions a=new Actions(driver);
		a.sendKeys(EnterCountry,Country).build().perform();
		
		//WaitforElementToAppear(countryList);
		selectCountry.stream().filter(s->s.getText().equalsIgnoreCase(Country)).forEach(s->s.click());
		palceorder.click();
		
		
		
	}
	
	public String Conformation()
	
	{
		WaitforWebElementToAppear(message);
		String Conformation=message.getText();
		return Conformation;
	}

	 
	 
	 
	 
	 
	 
	

}
