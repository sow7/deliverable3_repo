package deliverable3_repo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubscribeTest {
	
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
		
		//redirect to a speakerlist page
		driver.get("http://halley.exp.sis.pitt.edu/comet/speakerlist.do");
	}

	@Test
	public void subscribetest() {
		try {
			new WebDriverWait(driver, 15).until(
				    ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[onclick*='spansubrspid6783']"))
				);//wait until subcribeButton diplayed then commit the test
			
			//look for the subcribeButton
			WebElement subcribeButton = driver.findElement(By.cssSelector("a[onclick*='spansubrspid6783']"));
			//the subcribeButton should equals Subscribe
			assertTrue(subcribeButton.getText().equals("Subscribe"));
			//click subcribeButton to subscribe
			driver.findElement(By.cssSelector("a[onclick*='spansubrspid6783']")).click();
			//after subscribe it should be changed to Unsubscribe
			assertTrue(subcribeButton.getText().equals("Unsubscribe"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
	
	
	//the reason why I do this test like this, because there is a defect, the subscirbed speaker won't be recorded by the website
	@Test
	public void unsubscribetest() {
		try {
			new WebDriverWait(driver, 15).until(
				    ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[onclick*='spansubrspid6783']"))
				);//wait until subcribeButton diplayed then commit the test
			
			//look for the subcribeButton
			WebElement unsubcribeButton = driver.findElement(By.cssSelector("a[onclick*='spansubrspid6783']"));
			//the subcribeButton should equals Subscribe
			assertTrue(unsubcribeButton.getText().equals("Subscribe"));
			//click subcribeButton to subscribe
			driver.findElement(By.cssSelector("a[onclick*='spansubrspid6783']")).click();
			//after subscribe it should be changed to Unsubscribe
			assertTrue(unsubcribeButton.getText().equals("Unsubscribe"));
			//click unsubcribeButton to unsubscribe
			driver.findElement(By.cssSelector("a[onclick*='spansubrspid6783']")).click();
			//after unsubscribe it should be changed to Subscribe
			assertTrue(unsubcribeButton.getText().equals("Subscribe"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
}
