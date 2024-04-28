package kamlandh.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import kamlandh.pageobjects.cartpage;
import kamlandh.pageobjects.Orderpage;

public class AbstarctClass {
	
	WebDriver driver;
	
	
	public AbstarctClass(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		// TODO Auto-generated constructor stub
	}

	@FindBy(css="[routerlink*='cart']")
	WebElement CartHeader;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement OrderHeader;
	
	
	

	public void WaitforElementToAppear(By findBy) {
		
	
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	 wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	
	public void WaitforWebElementToAppear(WebElement findBy) {
		
		
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.visibilityOf(findBy));
		}
	
	public void waitforElementToDisappear(WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public Orderpage gotoorderpage()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(OrderHeader));
		OrderHeader.click();
		Orderpage orderpage=new Orderpage(driver);
		return orderpage;
	}
	public cartpage gotocartpage()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(CartHeader));
		CartHeader.click();
		cartpage cpage=new cartpage(driver);
		return cpage;
	}

}
