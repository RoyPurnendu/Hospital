package pageojects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demopage extends Basepage
{
	//CONSTRUCTOR
	WebDriver driver;
	
	public Demopage(WebDriver driver)
	{
		super(driver);
	}
	
	//WEBELEMENT
	@FindBy(xpath = "//span[text() = \"For Corporates\"]") WebElement corporate_loc;
	@FindBy(xpath = "//a[text() = \"Health & Wellness Plans\"]") WebElement health_loc;
	@FindBy(xpath = "//button[@class=\"u-text--bold u-border-radius--8 text-white text-center u-m-t--5 u-p-v--12 width-per--100 u-cur--ptr bg-blue\"]") WebElement demo_button_loc;
	@FindBy(id="name") WebElement name_loc;
	@FindBy(id="organizationName") WebElement org_name_loc;
	@FindBy(id="contactNumber") WebElement number_loc;
	@FindBy(id="officialEmailId") WebElement email_loc;
	@FindBy(id="organizationSize") WebElement orgsize_loc;
	@FindBy(id="interestedIn") WebElement interest_loc;
	@FindBy(xpath = "//div[text() = \"THANK YOU\"]") WebElement thank_loc;
	
	
	//methods
	public void form()
	{
		corporate_loc.click();
		health_loc.click();
	}
	
	public void getdemonegetive()
	{
		try
		{
			name_loc.sendKeys("Roy");
			org_name_loc.sendKeys("Roycomp");
			number_loc.sendKeys("9876544567");
			email_loc.sendKeys("roycomp@");
			Select orgsize = new Select(orgsize_loc);
			orgsize.selectByVisibleText("10001+");
			Select interest = new Select(interest_loc);
			interest.selectByVisibleText("Taking a demo");
			WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10000));
			mywait.until(ExpectedConditions.elementToBeClickable(demo_button_loc));
			if(demo_button_loc.isDisplayed())
			{
				System.out.println("demo button is enabled.");
				demo_button_loc.click();
				Thread.sleep(5000);
				if(thank_loc.isDisplayed())
				{
					System.out.println("Thank you massage is displayed.");
				}
				else
				{
					System.out.println("Thank you massage is not displayed.");
				}
				
			}
			else
			{
				System.out.println("Enter valid input.");
			}
		}
		catch(Exception e)
		{
			System.out.println("Invalid input");
		}
		
	}
	
	public void getdemopositive()
	{
		try
		{
			name_loc.clear();;
			name_loc.sendKeys("Roy");
			org_name_loc.clear();;
			org_name_loc.sendKeys("Roycomp");
			number_loc.clear();;
			number_loc.sendKeys("9876544567");
			email_loc.clear();
			email_loc.sendKeys("roycomp@gamil.com");
			Select orgsize = new Select(orgsize_loc);
			orgsize.selectByVisibleText("10001+");
			Select interest = new Select(interest_loc);
			interest.selectByVisibleText("Taking a demo");
			WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10000));
			mywait.until(ExpectedConditions.elementToBeClickable(demo_button_loc));
			if(demo_button_loc.isEnabled())
			{
				System.out.println("demo button is enabled.");
				demo_button_loc.click();
				Thread.sleep(10000);
				if(thank_loc.isDisplayed())
				{
					System.out.println("Thank you massage is displayed.");
				}
				else
				{
					System.out.println("Thank you massage is not displayed.");
				}
				
			}
		}
		catch(Exception e)
		{
			System.out.println("Invalid input");
		}
		
	}
}
