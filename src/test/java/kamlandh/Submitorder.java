package kamlandh;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import kamlandh.pageobjects.LandingPage;
import kamlandh.pageobjects.Orderpage;
import kamlandh.pageobjects.productCatalogue;
import kamlandh.pageobjects.cartpage;
import kamlandh.pageobjects.PlaceOrder;
import java.util.HashMap;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

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

public class Submitorder extends BaseTest{
	String proudctname="IPHONE 13 PRO";
	String Country="India";
	@Test(dataProvider="GetData",groups= {"purchase"})
		 public void submitorder(HashMap<String,String> input) throws IOException,InterruptedException
		 //public void submitorder(String email,String pwd,String proudctname,String Country)
		 {
				
				productCatalogue productCatalogue= lp.Login(input.get("Email"), input.get("Pssword")); 
				List<WebElement> k= productCatalogue.GetProductList();
				productCatalogue.addproducttocart(input.get("proudctname"));
				cartpage cpage=productCatalogue.gotocartpage();
				boolean t=cpage.verifyproduct(proudctname);
				AssertJUnit.assertTrue(t);
				PlaceOrder placeorder=cpage.gotocheckout();
				placeorder.placeeorderr(input.get("country"));
			    //String Conformation =placeorder.Conformation();
				//AssertJUnit.assertTrue(Conformation.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
				
				 
								 
			}
	
	@Test(dependsOnMethods= {"submitorder"})
	
	public void VerifyorderList()
	{
		productCatalogue productCatalogue= lp.Login("kamal12@gmail.com", "Kunal@121"); 
		Orderpage orderpage=productCatalogue.gotoorderpage();
		Assert.assertTrue(orderpage.verifyorder(proudctname));
	}
	
	
	
	@DataProvider
	public Object[][] GetData()
	{
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("Email", "kamal12@gmail.com");
		map.put("Pssword","Kunal@121");
		map.put("proudctname", "IPHONE 13 PRO");
		map.put("country", "India");
		
		return new Object[][] {{map}};
	}
	
//	@DataProvider
//	public Object[][] getdata()
//	{
//		
//		
//		return new Object[][] {{"kamal12@gmail.com", "Kunal@121"}};
//	}

}


