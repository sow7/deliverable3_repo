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
 * As a user, I would like to see reddit links in all sorts of ways, So that I
 * can know what is happening in the world
 * 
 * @author wss
 *
 */

public class LoginTest {

	static WebDriver driver = new FirefoxDriver();

	@Before
	public void setUp() throws Exception {
		driver.get("http://halley.exp.sis.pitt.edu/comet/login.do");
	}
	
	@Test
	public void rightLoginTest() {
		// Enter username "lanzhang.lemon@gmail.com", password "lzhang11"

		driver.findElement(By.name("userEmail")).sendKeys("lanzhang.lemon@gmail.com");
		driver.findElement(By.name("password")).sendKeys("lzhang11");

		// Look for the submit button (in the login div) and click
		// to attempt to login

		WebElement submitButton = driver.findElement(By.id("btnSignin"));
		submitButton.click();
		// Check that there is a link to reset password and it is visible

		try {
			WebElement logoutButton = driver.findElement(By.cssSelector("a[href='/comet/logout.do']"));
			assertTrue(logoutButton.isDisplayed());
			logoutButton.click();
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
	
	@Test
	public void wrongLoginTest() {
		// Enter username "lanzhang.lemon@gmail.com", password "lzhang"

		driver.findElement(By.name("userEmail")).sendKeys("lanzhang.lemon@gmail.com");
		driver.findElement(By.name("password")).sendKeys("lzhang");

		// Look for the submit button (in the login div) and click
		// to attempt to login

		WebElement submitButton = driver.findElement(By.id("btnSignin"));
		submitButton.click();
		// Check that there is a link to reset password and it is visible

		try {
			WebElement resetPw = driver.findElement(By.cssSelector("td[style='font-size: 0.75em;color: red;font-weight: bold;']"));
			assertTrue(resetPw.isDisplayed());
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
}
