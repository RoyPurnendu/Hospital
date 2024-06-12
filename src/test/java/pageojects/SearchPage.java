package pageojects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends Basepage
{
	WebDriver driver;
	//constructor
	public SearchPage(WebDriver driver)
	{
		super(driver);
	}
	
	//WebElements
	@FindBy(xpath = "//div[@data-qa-id=\"doctor_review_count_section\"]") WebElement StoryButton_loc;
	@FindBy(xpath =  "//ul[@data-qa-id=\"doctor_review_count_list\"]//span") List<WebElement> stories_list;
	@FindBy(xpath = "//span[@data-qa-id=\"years_of_experience_selected\"]") WebElement experianceButton_loc;
	@FindBy(xpath = "//ul[@data-qa-id=\"years_of_experience_list\"]//span") List<WebElement> Experience_list;
	@FindBy(xpath = "//i[@class=\"u-transition--transform u-d-inlineblock icon-ic_dropdown\"]") WebElement filter_loc;
	@FindBy(xpath = "//span[@data-qa-id=\"Fees_title\"]/following-sibling :: label/span") List<WebElement> fees_list_loc;
	//String fees = fees_list.loc.getAttribute("value")
	@FindBy(xpath = "//span[@data-qa-id=\"Availability_title\"]/following-sibling::label/span") List<WebElement> availabily_loc;
	@FindBy(xpath = "//span[@class=\"c-sort-dropdown__selected c-dropdown__selected\"]") WebElement relevance_loc;
	@FindBy(xpath = "//ul[@data-qa-id=\"sort_by_list\"]/li") List<WebElement> sort_by_loc;
	@FindBy(xpath = "//div[@class=\"info-section\"]//h2[1]") List<WebElement> doc_name_loc;
	
	//methods
	
	//select number of stories
	public void storyselection() throws InterruptedException
	{
		StoryButton_loc.click();
		Thread.sleep(2000);
		for(WebElement element:stories_list)
		{
			String story = element.getText();
			if(story.equalsIgnoreCase("30+ Patient Stories"))
			{
				element.click();
				return;
				
			}
		}
		
	}
	
	//select experience
	
	public void selectexp() throws InterruptedException
	{
		experianceButton_loc.click();
		Thread.sleep(2000);
		for(WebElement experiance: Experience_list)
		{
			String ExperianceText = experiance.getText();
			if(ExperianceText.contains("5"))
			{
				experiance.click();
				return;
			}
		}
	}
	
	public void selectfees() throws InterruptedException 
	{
		filter_loc.click();
		Thread.sleep(2000);
		for(WebElement fees: fees_list_loc)
		{
			String fee = fees.getAttribute("data-qa-id");
			if(fee.contains("500"))
			{
				fees.click();
				return;
			}
		}
		
	}
	public void selectavailability() throws InterruptedException
	{
		filter_loc.click();
		Thread.sleep(2000);
		for(WebElement fees: availabily_loc)
		{
			String fee = fees.getAttribute("data-qa-id");
			if(fee.contains("Today"))
			{
				fees.click();
				return;
			}
		}
	}
	
	public void selectrelevance() throws InterruptedException
	{
		relevance_loc.click();
		Thread.sleep(1000);
		for(WebElement sort : sort_by_loc)
		{
			String sorting = sort.getAttribute("aria-label");
			if(sorting.contains("Experience"))
			{
				sort.click();
				return;
			}
		}
	}
	
	public void printdocname()
	{
		for(int i = 1; i<=5;i++)
		{
			WebElement doc = doc_name_loc.get(i);
			System.out.println(doc.getText());
		}
	}
	
	
	
	
}
