package kamalnadh.stepDefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kamlanadh.TestComponents.BaseTest;
import kamlandh.pageobjects.LandingPage;
import kamlandh.pageobjects.PlaceOrder;
import kamlandh.pageobjects.cartpage;
import kamlandh.pageobjects.productCatalogue;

public class StepDefinationImple extends BaseTest {
	
	public LandingPage landingpage;
	public productCatalogue pc;
	public cartpage cpage;
	public PlaceOrder placeorder;
	
	
	@Given("I landed on e commerce page")
	
	public void I_Landed_on_ecommercepage() throws IOException
	{
		landingpage=launchapplication();
		//code
	}
	
	@Given("^Login with username (.+) and passowrd (.+)$")
	
	public void Login_with_user_name(String name,String password)
	
	{
	        pc = lp.Login(name,password); 
	}
	
	@When("^I add the product (.+) to cart$")
	
	public void I_add_product_to_cart(String Productname)
	{
		List<WebElement> k= pc.GetProductList();
		pc.addproducttocart(Productname);
	}
	
	@When("^checkout (.+) and submit the order$")
	
	public void checkout_submitorder(String Productname)
	{
		 cpage=pc.gotocartpage();
		boolean t=cpage.verifyproduct(Productname);
		AssertJUnit.assertTrue(t);
		 placeorder=cpage.gotocheckout();
		placeorder.placeeorderr("india");
	}
	
	@Then("{string}message is displayed on coformationpage")
	
	public void message_displayed(String string)
	{
		
		String Conformation =placeorder.Conformation();
		AssertJUnit.assertTrue(Conformation.equalsIgnoreCase(string));
	}
	
	
	

}
