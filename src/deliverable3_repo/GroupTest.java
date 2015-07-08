package deliverable3_repo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
//import org.openqa.selenium.JavascriptExecutor;

public class GroupTest {
	
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
		driver.get("http://halley.exp.sis.pitt.edu/comet/community.do?comm_id=4");
	}

	@Test
	public void joinTest() {
		driver.findElement(By.cssSelector("input[onclick*='spanmemrcid4']")).click();
		try {
			WebElement leaveButton = driver.findElement(By.id("spanmemrcid4"));
			assertTrue(leaveButton.getText().contains("Joined"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
	
	@Test
	public void leaveTest() {
		driver.findElement(By.cssSelector("input[onclick*='spanmemrcid4']")).click();
		try {
			WebElement leaveButton = driver.findElement(By.cssSelector("input[onclick*='spanmemrcid4']"));
			assertTrue(leaveButton.getAttribute("value").equals("Join"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
}
