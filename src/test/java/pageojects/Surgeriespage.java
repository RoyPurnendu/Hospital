package pageojects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Surgeriespage extends Basepage
{
	WebDriver driver;
	
	//constructor
	public Surgeriespage(WebDriver driver)
	{
		super(driver);
		
	}
	
	//elements
	@FindBy(xpath = "//p[@data-qa-id=\"surgical-solution-ailment-name\"]") List<WebElement> surgerie_list_loc ;
	
	@FindBy (xpath = "//div[text()=\"Surgeries\"]") WebElement surgeries_loc;
	
	//methods
	
	//print surgeries
	
	public void printsurgeries() throws InterruptedException
	{
		surgeries_loc.click();
		Thread.sleep(4000);
		System.out.println("The List of surgeries displayed in the website:");
		for(WebElement surgerie :surgerie_list_loc)
		{
			System.out.println(surgerie.getText());
		}
	}
}
