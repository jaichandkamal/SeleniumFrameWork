package kamlandh;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import kamlandh.pageobjects.LandingPage;
import kamlandh.pageobjects.productCatalogue;
import kamlandh.pageobjects.cartpage;
import kamlandh.pageobjects.PlaceOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import java.util.stream.Collectors;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import kamlanadh.TestComponents.BaseTest;
import kamlanadh.TestComponents.Retry;

public class ErrorValidations extends BaseTest{

	@Test(groups= {"ErrorValidation"},retryAnalyzer=Retry.class)
		 public void LoginErrorValidation() throws IOException,InterruptedException
		 {
				lp.Login("kmal12@gmail.com", "unal@121"); 
				String errormessage=lp.errormessage();
				AssertJUnit.assertEquals("Incorrect email or Password", errormessage);	 
								 
			}
	@Test
	public void productvalidation()
	{
	String proudctname="IPHONE 13 PRO";
	String Country="India";
	productCatalogue productCatalogue= lp.Login("kamal12@gmail.com", "Kunal@121"); 
	List<WebElement> k= productCatalogue.GetProductList();
	productCatalogue.addproducttocart(proudctname);
	cartpage cpage=productCatalogue.gotocartpage();
	boolean t=cpage.verifyproduct("Iphone");
	AssertJUnit.assertFalse(t);
	}

}


