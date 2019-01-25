package com.qa.Dave.Test.fridayMorningAssessment;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.Dave.Test.fridayMorningAssessment.Runner;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.AtForm;
import pages.Home;
import utility.Constant;

public class Steps {

	WebDriver driver;
	static ExtentTest test;
	
	@Before
	public void setup() {
	System.setProperty("webdriver.chrome.driver", Constant.driverLocation); 
	driver = new ChromeDriver();
	test = Runner.report.startTest("Friday Morning Assessment");
	}
	
	@Given("^I navigate to the React Application$")
	public void i_navigate_to_the_React_Application(){
	    driver.get(Constant.siteLocation);
	}

	@When("^I click the Link to Automated Testing Exercise Form$")
	public void i_click_the_Link_to_Automated_Testing_Exercise_Form(){
		Home page = PageFactory.initElements(driver, Home.class);
	    page.linkToAutomationPage();
	    test.log(LogStatus.INFO, "Testing the Automation link");
	}

	@When("^I fill click the \"([^\"]*)\" dropdown menu$")
	public void i_fill_click_the_dropdown_menu(String arg1){
	    AtForm page1 = PageFactory.initElements(driver, AtForm.class);
	    page1.dropDown(driver, arg1);
	    test.log(LogStatus.INFO, "Does the drop down show?");
	}

	@When("^I fill out the email field with \"([^\"]*)\"$")
	public void i_fill_out_the_email_field_with(String arg1){
		AtForm page2 = PageFactory.initElements(driver, AtForm.class);
	    page2.emailInput(arg1);
	    test.log(LogStatus.INFO, "Does the input work");
	}

	@When("^I fill out the first password field with \"([^\"]*)\"$")
	public void i_fill_out_the_first_password_field_with(String arg1){
		AtForm page3 = PageFactory.initElements(driver, AtForm.class);
	    page3.password1(arg1);
	    test.log(LogStatus.INFO, "Does the input for password work");
	}

	@When("^I fill out the second password field with \"([^\"]*)\"$")
	public void i_fill_out_the_second_password_field_with(String arg1){
		AtForm page4 = PageFactory.initElements(driver, AtForm.class);
	    page4.password2(arg1);
	    test.log(LogStatus.INFO, "Does the input for password verification work");
	}

	@Then("^I should see a Success! Message$")
	public void i_should_see_a_Success_Message(){
		AtForm page5 = PageFactory.initElements(driver, AtForm.class);
		try {
		    assertEquals("Success!", page5.successful(driver));
		    test.log(LogStatus.PASS, "Successfully created an account");
		} catch (Exception E) {
			test.log(LogStatus.FAIL, "Unable to create an account");
			
		}
	}

	@When("^I fill out the second password field with the wrong password \"([^\"]*)\"$")
	public void i_fill_out_the_second_password_field_with_the_wrong_password(String arg1){
		AtForm page4 = PageFactory.initElements(driver, AtForm.class);
	    page4.password2(arg1);
	    test.log(LogStatus.INFO, "Does the input for password verification work");
	}

	@Then("^I should see a message stating that the passwords do not match\\.$")
	public void i_should_see_a_message_stating_that_the_passwords_do_not_match(){
		AtForm page6 = PageFactory.initElements(driver, AtForm.class);
		try {
		    assertEquals("The passwords do not match", page6.unsuccessful(driver));
		    test.log(LogStatus.PASS, "Successfully created an account");
		} catch (Exception E) {
			test.log(LogStatus.FAIL, "Unable to create an account");
			
		}
		}
	
	@After
	public void teardown() {
		Runner.report.endTest(test);
		driver.quit();
	}
	
}
