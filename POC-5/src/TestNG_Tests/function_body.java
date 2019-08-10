package TestNG_Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class function_body {

	WebDriver chrome;
	String v_email="mandal0927@gmail.com";
	String v_pass="satty0927";
	String iv_email="mandal0@#$927@gmail.com";
	String iv_pass="satty00000927";
	String verify;
	Logger log;
	WebDriverWait wait;
	
	@Given("^User launches browser$")
	public void user_launches_browser() throws Throwable {
	    System.setProperty("webdriver.chrome.driver", "chromedriver_version_75.exe");
	    chrome=new ChromeDriver();
	    chrome.get("http://demowebshop.tricentis.com/");
	    log=Logger.getLogger("devpinoyLogger");
	    log.info("Browser Launched");
	    wait=new WebDriverWait(chrome, 2);
	}

	@When("^Clicks on the Login link$")
	public void clicks_on_the_Login_link() throws Throwable {
	   chrome.findElement(By.xpath("//a[text()='Log in']")).click();
	   log.info("Login link clicked");
	}

	@When("^Enters valid login data$")
	public void enters_valid_login_data() throws Throwable {
	    chrome.findElement(By.xpath("//input[@id='Email']")).sendKeys(v_email);
	    verify=v_email;
	    log.info("Valid Email Entered");
	}

	@When("^Enters valid password$")
	public void enters_valid_password() throws Throwable {
		chrome.findElement(By.xpath("//input[@id='Password']")).sendKeys(v_pass);
		log.info("Valid password Entered");
		log.info("\t\t\t\t\t\t Enters_Valid_password method is invoked");
	}

	@When("^Clicks Login button$")
	public void clicks_Login_button() throws Throwable {
	    chrome.findElement(By.xpath("//input[@value='Log in']")).click();
	    log.info("Button Clicked Login");
	    log.info("\t\t\t\t\t\t clicks_Login_button method is invoked");
	}

	@Then("^User name is in link text$")
	public void user_name_is_in_link_text() throws Throwable {
		log.info("Explicit wait for 2 sec");
		By x=By.xpath("//a[text()='mandal0927@gmail.com']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(x));
	    boolean k=chrome.findElement(By.xpath("//a[text()='mandal0927@gmail.com']")).isDisplayed();
	    if(k) {
	    	System.out.println("Verification Successful");
	    	log.info("Expected Result: "+ verify+"|| Actual Result:"+chrome.findElement(By.xpath("//a[text()='"+verify+"']")).getText()+"||Login_Attempt: SUCCESS");
	    	log.info("\t\t\t\t\t\t user_name_is_in_link_text method is invoked");
	    }
	}

	@Then("^Redirects to home page$")
	public void redirects_to_home_page() throws Throwable {
	    
	    System.out.println("Rdirected to "+chrome.getTitle());
	    log.info("Redirected to "+chrome.getTitle());
	    log.info("\t\t\t\t\t\t redirects_to_home_page method is invoked");
	    chrome.close();
	}

	@When("^Enters invalid login$")
	public void enters_invalid_login() throws Throwable {
		chrome.findElement(By.xpath("//input[@id='Email']")).sendKeys(iv_email);
	    verify=v_email;
	    log.info("Invalid info email");
	    log.info("\t\t\t\t\t\t enters_invalid_login method is invoked");
	}

	@When("^Enters invalid password$")
	public void enters_invalid_password() throws Throwable {
		chrome.findElement(By.xpath("//input[@id='Password']")).sendKeys(iv_pass);
		log.info("Invalid password");
		log.info("\t\t\t\t\t\t enters_invalid_password method is invoked");
	}

	@Then("^User login fails$")
	public void user_login_fails() throws Throwable {
		System.out.println("Stuck to "+chrome.getTitle());
		log.info("Stuck to "+chrome.getTitle());
		log.info("\t\t\t\t\t\t user_login_fails method is invoked");
	}

	@Then("^A specific error is displayed$")
	public void a_specific_error_is_displayed() throws Throwable {
		
		
		
		boolean b=false,c=false;
		try {
		b=chrome.findElement(By.xpath("//*[text()='Please enter a valid email address.']")).isDisplayed();}catch(Exception e) {}
		try{c=chrome.findElement(By.xpath("//*[text()='No customer account found']")).isDisplayed();}catch(Exception e) {}
		
	    
	    	if(b) {
	    		By x=By.xpath("//*[text()='Please enter a valid email address.']");
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(x));
	    		log.info("Explicit wait for 2 sec");
	    		System.out.println(chrome.findElement(By.xpath("//*[text()='Please enter a valid email address.']")).getText());
		    	log.info("Expected Result: "+ verify+"|| Actual Result:"+chrome.findElement(By.xpath("//*[text()='Please enter a valid email address.']")).getText()+"||Login Attempt: FAILED");
		    	log.info("\t\t\t\t\t\t a_specific_error_is_displayed method is invoked");
		    	chrome.close();
		    }	
	    
	    
	    	if(c) {
	    		By x=By.xpath("//*[text()='No customer account found']");
	    		wait.until(ExpectedConditions.visibilityOfElementLocated(x));
	    		log.info("Explicit wait for 2 sec");
		    	System.out.println(chrome.findElement(By.xpath("//*[text()='No customer account found']")).getText());
		    	log.info("Expected Result: "+ verify+"|| Actual Result:"+chrome.findElement(By.xpath("//*[text()='No customer account found']")).getText()+"||Login Attempt: FAILED");
		    	log.info("\t\t\t\t\t\t a_specific_error_is_displayed method is invoked");
		    	chrome.close();
		    }	
	    
	    
	}
	
}
