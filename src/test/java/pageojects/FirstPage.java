package pageojects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FirstPage extends Basepage 
{
	WebDriver driver;
	
	//constructor
	public FirstPage(WebDriver driver)
	{
		super(driver);
	}
	
	//elements
	@FindBy(xpath = "//input[@data-input-box-id=\"omni-searchbox-locality\"]") WebElement locality_loc;
	@FindBy(xpath = "//div[@data-qa-id=\"omni-suggestion-main\"]") List<WebElement> locality_list_loc;
	@FindBy(xpath = "//input[@data-input-box-id=\"omni-searchbox-keyword\"]") WebElement speciality_loc;
	@FindBy(xpath = "//div[@class=\"c-omni-suggestion-item__content__title\"]") List<WebElement> Specialities_loc;
	
	//methods
	
	//select locality
	public void selectlocality() throws InterruptedException
	{
		Thread.sleep(1000);
		locality_loc.clear();
		Thread.sleep(1000);
		locality_loc.sendKeys("Chennai");
		Thread.sleep(1000);
		for(WebElement loc:locality_list_loc)
		{
			String locality = loc.getText();
			if(locality.equalsIgnoreCase("chennai"))
			{
				loc.click();
				return;
			}
		}
	}
	
	//select specialty
	
	public void selectspecialty() throws InterruptedException
	{
		Thread.sleep(1000);
		speciality_loc.click();
		Thread.sleep(2000);
		for(WebElement ele: Specialities_loc)
		{
			String elementtext = ele.getText();
			if(elementtext.equalsIgnoreCase("Dentist"))
			{
				ele.click();
				return;
			}
		}
	}
	

}
