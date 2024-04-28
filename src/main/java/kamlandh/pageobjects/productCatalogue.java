package kamlandh.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kamlandh.AbstractComponents.AbstarctClass;

public class productCatalogue extends AbstarctClass{
	
	WebDriver driver;
	
	public productCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	 
	 //page factory use chesi web elements initilize cheyali 
	 
	 @FindBy(xpath="//div[contains(@class,'col-lg-4')]")
	List< WebElement> Products;
	 @FindBy(css=".ng-animating")
	 WebElement Loader;
	 
	 By prodwait=By.xpath("/div[contains(@class,'col-lg-4')]");
	 By addtocart=By.cssSelector(".card-body button:last-of-type");
	 By Toster=By.id("toast-container");
	
	 
	 public List<WebElement> GetProductList()
	 {
		 WaitforElementToAppear(prodwait);
		 return Products;
		 
	 }
	 
	 public WebElement getproducttoadd(String proudctname)
	 {
		 WebElement product=GetProductList().stream().filter(s->s.findElement(By.xpath(".//b")).getText().equals(proudctname)).findFirst().orElse(null);
		 return product;
			 
	 }
	 
	 public void addproducttocart(String Productname)
	 {
		 
		 WebElement product=getproducttoadd(Productname);
		 product.findElement(addtocart).click(); 
		 WaitforElementToAppear(Toster);
		 waitforElementToDisappear(Loader);
		 

	 }
	 
	
	 
	
	 
	 
	

}
