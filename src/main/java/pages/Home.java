package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home {

	@FindBy(xpath = "//*[@id=\"root\"]/div/ul/li[10]/a")
	private WebElement linkToAuto;
	
	public void linkToAutomationPage() {

		linkToAuto.click(); 
		
	}
	
}
