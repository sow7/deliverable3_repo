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
		driver.get("http://halley.exp.sis.pitt.edu/comet/login.do");
	}

	@Test
	public void test() {
		// Enter username "wansongsong.jack@gmail.com", password "Ihave1dream"

		driver.findElement(By.name("userEmail")).sendKeys("wansongsong.jack@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Ihave1dream");

		// Look for the submit button (in the login div) and click
		// to attempt to login

		WebElement submitButton = driver.findElement(By.id("btnSignin"));
		submitButton.click();
		// Check that there is a link to reset password and it is visible

		try {
			WebElement resetPw = driver.findElement(By.cssSelector("td[style='font-size: 0.75em;color: red;font-weight: bold;']"));//driver.findElement(By.linkText("Your email or password is not correct!"));
			assertTrue(resetPw.isDisplayed());
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}

}
