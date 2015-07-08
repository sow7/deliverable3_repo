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

		// get into the main page of the web site
		driver.get("http://halley.exp.sis.pitt.edu/comet/login.do");

	}

	@Test
	public void bookmarkTest() {
		// Look for the sign in button (in the login div) and click
		// to attempt to login

		// click the link of sign in and get into the sign in page for next
		// testing
		

		driver.findElement(By.name("userEmail")).sendKeys(
				"lanzhang.lemon@gmail.com");
		driver.findElement(By.name("password")).sendKeys("lzhang11");
		WebElement loginButtion = driver.findElement(By.id("btnSignin"));
		loginButtion.click();
		
		WebElement bookmark = driver.findElement(By.xpath("//*[@id='divTalkContent']/table/tbody/tr[3]/td/table/tbody/tr[1]/td/table/tbody/tr/td[2]/a"));
//		 WebElement bookmark =
//		 driver.findElement(By.cssSelector("a[onclick*='spanbookcolid8402']"));
		bookmark.click();

		try {
			String content = bookmark.getText();
			assertEquals(content, "Unbookmark");
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}

}
