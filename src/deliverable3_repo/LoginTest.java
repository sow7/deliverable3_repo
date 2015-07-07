package deliverable3_repo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class LoginTest {

	static WebDriver driver = new HtmlUnitDriver();

	@Before
	public void setUp() throws Exception {
		// get into the main page of the webset
		driver.get("http://halley.exp.sis.pitt.edu/comet/index.do");

		// click the link of sign in and get into the sign in page for next testing
		WebElement signinButtion = driver.findElement(By.linkText("sign in"));
		signinButtion.click();

	}

	

	// Given that I am on the log in page
	// And I am not logged in
	// When I try to login with an valid username and invalid password
	// Then I am given the opportunity to reset the password
	@Test
	public void testBadPasswordResetLink() {

		// Enter username "meow", password "meow"

		driver.findElement(By.name("userEmail")).sendKeys(
				"lanzhang.lemon@gmail.com");
		driver.findElement(By.name("password")).sendKeys("lzhang");

		// Look for the sign in button (in the login div) and click
		// to attempt to login

		WebElement loginButtion = driver.findElement(By.id("btnSignin"));
		loginButtion.click();

		// Check that there is a link to reset password and it is visible

		try {
			WebElement resetPw = driver
					.findElement(By
							.cssSelector("td[style='font-size: 0.75em;color: red;font-weight: bold;']"));
			assertTrue(resetPw.isDisplayed());
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}

}
