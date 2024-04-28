package kamlandh.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kamlandh.AbstractComponents.AbstarctClass;

public class LandingPage extends AbstarctClass{
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	 
	 //page factory use chesi web elements initilize cheyali 
	 
	 @FindBy(id="userEmail")
	 WebElement UserEmail;
	 
	 @FindBy(id="userPassword")
	 WebElement Password;
	 
	 @FindBy(id="login")
	 WebElement submit;
	 
	 @FindBy(css="[class*='flyInOut']")
	 WebElement Errormessage;
	 
	 
	 public productCatalogue Login(String email,String pwd)
	 {
		 UserEmail.sendKeys(email);
		 Password.sendKeys(pwd);
		 submit.click();
		 productCatalogue productCatalogue=new productCatalogue(driver);
		 return productCatalogue;
		 
	 }
	 public String errormessage()
	 {
		 
		 WaitforWebElementToAppear(Errormessage);
		return Errormessage.getText();
	 }
	 public void Goto()
	 {
		 driver.get("https://rahulshettyacademy.com/client");
	 }
	 
	 
	

}
