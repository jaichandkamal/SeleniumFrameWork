package kamlandh.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kamlandh.AbstractComponents.AbstarctClass;

public class cartpage extends AbstarctClass{
	WebDriver driver;
	
	public cartpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//*[@class='cartSection']/h3")
	List<WebElement> cartitems;
	
	@FindBy(css=".totalRow button")
	WebElement checkout;

	 
	 //page factory use chesi web elements initilize cheyali 
	 
	
	public boolean verifyproduct (String proudctname)
	{
		boolean match=cartitems.stream().anyMatch(s->s.getText().equalsIgnoreCase(proudctname));
		return match;
	}
	 
	public PlaceOrder gotocheckout()
	{
		checkout.click();
		PlaceOrder placeorder=new PlaceOrder(driver);
		return placeorder;
		
	}
	 
	

}
