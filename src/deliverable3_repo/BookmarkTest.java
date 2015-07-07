package deliverable3_repo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class BookmarkTest {

	static WebDriver driver = new HtmlUnitDriver();

	@Before
	public void setUp() throws Exception {

		// get into the main page of the webset
		driver.get("http://halley.exp.sis.pitt.edu/comet/index.do");

		// click the link of register and get into the register page for next testing
		WebElement signinButtion = driver.findElement(By.linkText("sign in"));
		signinButtion.click();

		driver.findElement(By.name("userEmail")).sendKeys(
				"lanzhang.lemon@gmail.com");
		driver.findElement(By.name("password")).sendKeys("lzhang11");

	}

	@Test
	public void BookmarkTest() {
		// Look for the sign in button (in the login div) and click
		// to attempt to login
		WebElement loginButtion = driver.findElement(By.id("btnSignin"));
		loginButtion.click();
		
		WebElement bookmark = driver.findElement(By.linkText("Bookmark"));
		bookmark.click();

		try {
			WebElement isbookmark = driver.findElement(By
					.linkText("Unbookmark"));
			assertTrue(isbookmark.isDisplayed());
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}

}
