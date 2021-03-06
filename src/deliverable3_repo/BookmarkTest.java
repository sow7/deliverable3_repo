package deliverable3_repo;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * As a user, I would like to mark the talks that I am interested in. 
 * So that I can easy find my favorite talks in the bookmark.
 *
 */

public class BookmarkTest {
	
	static WebDriver driver = new FirefoxDriver();
	
	// Start at the login page for CoMeT for each test
	@Before
	public void setUp() throws Exception {
		driver.get("http://halley.exp.sis.pitt.edu/comet/login.do");
		
		//input userEmail: lanzhang.lemon@gmail.com and password:lzhang11
		driver.findElement(By.name("userEmail")).sendKeys("lanzhang.lemon@gmail.com");
		driver.findElement(By.name("password")).sendKeys("lzhang11");

		// Look for the login button (in the login div) and click to login
		WebElement submitButton = driver.findElement(By.id("btnSignin"));
		submitButton.click();
	}

	//	Given that I have logged in and see a favorite talk
	//	When I click on link of "Bookmark"
	//	Then I see that "Unbookmark" displays in the link.
	@Test
	public void unbookMarktest() {
		try {
			WebElement bookmarkButton = driver.findElement(By.cssSelector("a[onclick*='spanbookcolid8402']"));
			//before click the button should be Bookmark, since user doesn't bookmark it before.
			assertTrue(bookmarkButton.getText().contains("Bookmark")); 
			bookmarkButton.click();
			//after click the button should be Unbookmark, since user bookmark it already.
			assertTrue(bookmarkButton.getText().contains("Unbookmark")); 
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
	
	//	Given that I have logged in and don't like one talk in my bookmark
	//	When I click on link of "Unbookmark"
	//	Then I see that "Bookmark" displays in the link.
	@Test
	public void bookMarktest() {
		try {
			WebElement unbookmarkButton = driver.findElement(By.cssSelector("a[onclick*='spanbookcolid8402']"));
			//before click the unbookmarkButtonbutton should be Unbookmark, since user has bookmarked it.
			assertTrue(unbookmarkButton.getText().contains("Unbookmark")); 
			unbookmarkButton.click();
			//after click the unbookmarkButtonbutton should be Bookmark, since user unbookmark it already.
			assertTrue(unbookmarkButton.getText().contains("Bookmark"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
}
