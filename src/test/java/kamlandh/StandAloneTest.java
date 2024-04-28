package kamlandh;
import java.time.Duration;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 //WebDriverManager.chromedriver().setup();
		String proudctname="IPHONE 13 PRO";
		WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		 driver.get("https://rahulshettyacademy.com/client");
		 //LandingPage lp=new LandingPage(driver);
		 driver.findElement(By.id("userEmail")).sendKeys("kamal12@gmail.com");
		 driver.findElement(By.id("userPassword")).sendKeys("Kunal@121");
		 driver.findElement(By.id("login")).click();
		 List <WebElement> k=driver.findElements(By.xpath("//div[contains(@class,'col-lg-4')]"));
		 WebElement product=k.stream().filter(s->s.findElement(By.xpath(".//b")).getText().equals(proudctname)).findFirst().orElse(null);
		 
		 if (product != null) {
			 product.findElement(By.cssSelector(".card-body button:last-of-type")).click();  
	        } else {
	            System.out.println("Product not found");
	        }
		 
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		 //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		 //driver.findElement(By.xpath("//button[contains(@routerlink ,'cart')]")).click();
		
		 
		 List<WebElement> cartitems=driver.findElements(By.xpath("//*[@class='cartSection']/h3"));
		 boolean match=cartitems.stream().anyMatch(s->s.getText().equalsIgnoreCase(proudctname));
		 //Assert.assertTrue(match);
		 System.out.println(match);
		 
		 driver.findElement(By.cssSelector(".totalRow button")).click();
		 
		 Actions a=new Actions(driver);
		 
		 a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "India").build().perform();
		 
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//section[@class='ta-results list-group ng-star-inserted']")));		
        List<WebElement> country=driver.findElements(By.xpath("//button[contains(@class,'list-group')]"));	
        country.stream().filter(s->s.getText().equalsIgnoreCase("India")).forEach(s->s.click());
       System.out.println(driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).getText());
       driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).click();
       String Conformation=driver.findElement(By.className("hero-primary")).getText();
      Assert.assertTrue(Conformation.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
      driver.close();
       

		 
		 
	}

}
