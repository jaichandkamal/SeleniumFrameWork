package kamlanadh.TestComponents;

import java.time.Duration;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import kamlandh.pageobjects.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage lp;
	
	public WebDriver initilizedriver() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//kamlanadh//resources//GlobalData.properties");
	
		prop.load(fis);
		String BrowserName=System.getProperty("browser")!=null ? System.getProperty("browser"): prop.getProperty("browser");  //ternery operator
				
				//prop.getProperty("browser");
		
		if(BrowserName.contains("chrome"))
		{
			ChromeOptions options=new ChromeOptions();
			
		
			WebDriverManager.chromedriver().setup();
			if(BrowserName.contains("headless"))
			{
				options.addArguments("headless");
			}
			  driver=new ChromeDriver(options);
			  //driver.manage().window().setSize(new Dimension(1440,900));
			 
		}
		
		else if(BrowserName.equalsIgnoreCase("firefox"))
		{
		
			System.setProperty("webdriver.geko.driver","/Users/kamalnadh/Documents/geckodriver");
			 driver=new FirefoxDriver();
			
		}
		else if(BrowserName.equalsIgnoreCase("Edge"))
		{
			//edge code (system.setproperty
			
		}
		
		driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		 return driver;
			
	}
	
	public String getscreenshot(String testcaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File filess=ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty(("user.dir")+"/reports"+testcaseName+".png"));
		FileUtils.copyFile(filess, file );
		return System.getProperty(("user.dir")+"//reports"+testcaseName+".png");
	}
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchapplication() throws IOException
	{
		driver=initilizedriver();
		 lp=new LandingPage(driver);
		 lp.Goto();
		 return lp;
	}
	
	@AfterMethod(alwaysRun=true)
	public void closebrowser()
	{
		driver.close();
	}
	

}
