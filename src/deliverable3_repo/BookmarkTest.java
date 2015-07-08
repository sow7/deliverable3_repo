package deliverable3_repo;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BookmarkTest {
	
	static WebDriver driver = new FirefoxDriver();
	@Before
	public void setUp() throws Exception {
		driver.get("http://halley.exp.sis.pitt.edu/comet/login.do");
		driver.findElement(By.name("userEmail")).sendKeys("lanzhang.lemon@gmail.com");
		driver.findElement(By.name("password")).sendKeys("lzhang11");

		// Look for the submit button (in the login div) and click
		// to attempt to login
		WebElement submitButton = driver.findElement(By.id("btnSignin"));
		submitButton.click();
	}

	@Test
	public void unbookMarktest() {
		WebElement bookmarkButton = driver.findElement(By.cssSelector("a[onclick*='spanbookcolid8402']"));
		bookmarkButton.click();
		try {
			//WebElement unbookmarkButton = driver.findElement(By.cssSelector("a[onclick*='spanbookcolid8402']"));
			assertTrue(bookmarkButton.getText().contains("Unbookmark"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
	
	@Test
	public void bookMarktest() {
		WebElement unbookmarkButton = driver.findElement(By.cssSelector("a[onclick*='spanbookcolid8402']"));
		unbookmarkButton.click();
		try {
			assertTrue(unbookmarkButton.getText().contains("Bookmark"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
}
