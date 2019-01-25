package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AtForm {

	WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/button")
	private WebElement country;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[1]")
	private WebElement uk;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[2]")
	private WebElement fr;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[3]")
	private WebElement gr;
	
	
	@FindBy(id = "nameInput")
	private WebElement email;
	
	@FindBy(id = "passInput")
	private WebElement password1;
	
	@FindBy(id = "passInput2")
	private WebElement password2;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/button")
	private WebElement submit;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/h1")
	private WebElement success; 
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/p[10]")
	private WebElement unSuccess;
	
	public void dropDown(WebDriver driver, String arg1) {
		country.click();
		
		if(arg1.equals(uk.getText())) {
			uk.click();
		} else if(arg1.equals(fr.getText())) {
			fr.click();
		} else {
			gr.click();
		}
		
	} 
//		
//		country.click();
//		WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(diffCountry));
//		
//		//		action.moveToElement(driver.findElement(By.linkText(arg1))).click().build().perform();
//		
//	}
	
	public void emailInput( String arg1) {
		
		email.sendKeys(arg1);
		
	}
	
	public void password1(String arg1) {
		
		password1.click();
		password1.sendKeys(arg1);
		
	}
	
	public void password2(String arg1) {
		
		password2.click();
		password2.sendKeys(arg1);
		submit.click();
		
		
	}
	
	public String successful(WebDriver driver) {
		return success.getText();
	}
	
	public String unsuccessful(WebDriver driver) {
		return unSuccess.getText();
	}
	

}
