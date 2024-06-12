package testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pageojects.Demopage;
import pageojects.FirstPage;
import pageojects.SearchPage;
import pageojects.Surgeriespage;

public class Basetest 
{
	WebDriver driver;
	FirstPage fp;
	SearchPage sp;
	Surgeriespage surp;
	Demopage dp;
	
	
	@BeforeClass
	@Parameters({"Browser"})
	public void Driversetup(String browser)
	
	{
		//creating the driver
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Wrong browser parameter in test xml");
		}
		//opening the webpage
		driver.get("https://www.practo.com/");
		//delete all cookies
		driver.manage().deleteAllCookies();
		//maximizing the window
		driver.manage().window().maximize();
		//assigning an implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//assigning driver to the first page
		fp = new FirstPage(driver);
		sp = new SearchPage(driver);
		surp = new Surgeriespage(driver);
		dp = new Demopage(driver);
		
		
	}
	
	@AfterClass
	public void close()
	{
		driver.quit();
	}
	
}
