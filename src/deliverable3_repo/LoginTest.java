package deliverable3_repo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * As a user, I would like to log in CoMet. 
 * So that I can do the personal operations.
 *
 */

public class LoginTest {

	static WebDriver driver = new FirefoxDriver();
	
	// Start at the login page for CoMeT for each test
	@Before
	public void setUp() throws Exception {
		driver.get("http://halley.exp.sis.pitt.edu/comet/login.do");
	}
	
	//	Given that I have a right account and a right password
	//	When I log into the website
	//	Then I see that the logout button displays in the page.
	@Test
	public void rightLoginTest() {
		
		// Enter username "lanzhang.lemon@gmail.com", password "lzhang11"
		driver.findElement(By.name("userEmail")).sendKeys("lanzhang.lemon@gmail.com");
		driver.findElement(By.name("password")).sendKeys("lzhang11");

		// Look for the login button (in the login div) and click to login
		WebElement submitButton = driver.findElement(By.id("btnSignin"));
		submitButton.click();
		
		// Check whether or not it login successfully, if successful, the logout button should show
		try {
			WebElement logoutButton = driver.findElement(By.cssSelector("a[href='/comet/logout.do']"));
			assertTrue(logoutButton.isDisplayed());
			logoutButton.click();
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
	
	//	Given that I have a right account and a wrong password
	//	When I log into the website
	//	Then I see that the website provides an error information about this wrong account.
	@Test
	public void wrongLoginTest() {
		
		// Enter username "lanzhang.lemon@gmail.com", wrong password "lzhang"
		driver.findElement(By.name("userEmail")).sendKeys("lanzhang.lemon@gmail.com");
		driver.findElement(By.name("password")).sendKeys("lzhang");

		// Look for the login button (in the login div) and click to login
		WebElement submitButton = driver.findElement(By.id("btnSignin"));
		submitButton.click();
		
		// Check that wrong password instruction shows.
		try {
			WebElement resetPw = driver.findElement(By.cssSelector("td[style='font-size: 0.75em;color: red;font-weight: bold;']"));
			assertTrue(resetPw.isDisplayed());
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
}
