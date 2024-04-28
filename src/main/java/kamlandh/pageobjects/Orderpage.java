package kamlandh.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kamlandh.AbstractComponents.AbstarctClass;

public class Orderpage extends AbstarctClass{
	WebDriver driver;
	
	public Orderpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
@FindBy(css="tr td:nth-child(3)")
List<WebElement> Ordername;
	
	

	 
	 //page factory use chesi web elements initilize cheyali 
	 
	
	public boolean verifyorder (String proudctname)
	{
		boolean match=Ordername.stream().anyMatch(s->s.getText().equalsIgnoreCase(proudctname));
		return match;
	}
	 
	
	 
	

}
