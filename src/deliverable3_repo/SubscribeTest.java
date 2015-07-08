package deliverable3_repo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SubscribeTest {
	
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
		driver.get("http://halley.exp.sis.pitt.edu/comet/speakerlist.do");
	}

	@Test
	public void subscribetest() {
		try {
			WebElement UnsubcribeButton = driver.findElement(By.cssSelector("a[onclick*='spansubrspid6783']"));
			assertTrue(UnsubcribeButton.getText().equals("Subscribe"));
			driver.findElement(By.cssSelector("a[onclick*='spansubrspid6783']")).click();
			assertTrue(UnsubcribeButton.getText().equals("Unsubscribe"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
	
	@Test
	public void unsubscribetest() {
		try {
			WebElement subcribeButton = driver.findElement(By.cssSelector("a[onclick*='spansubrspid6783']"));
			assertTrue(subcribeButton.getText().equals("Subscribe"));
			driver.findElement(By.cssSelector("a[onclick*='spansubrspid6783']")).click();
			assertTrue(subcribeButton.getText().equals("Unsubscribe"));
			driver.findElement(By.cssSelector("a[onclick*='spansubrspid6783']")).click();
			assertTrue(subcribeButton.getText().equals("Subscribe"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
}
