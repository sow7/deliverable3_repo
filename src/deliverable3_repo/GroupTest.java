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
 * As a user, I would like to join my favorite group. 
 * So that I can see the updated information about my favorite talks.
 *
 */

public class GroupTest {
	
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
		
		//redirect to a group page
		driver.get("http://halley.exp.sis.pitt.edu/comet/community.do?comm_id=4");
	}

	//	Given that I have logged in and see my prefered group in the group list
	//  When I click on the join button
	//  Then I see that join button changes to joined button
	@Test
	public void joinTest() {
		driver.findElement(By.cssSelector("input[onclick*='spanmemrcid4']")).click(); //click the join button to join a group
		try {
			WebElement joinButton = driver.findElement(By.id("spanmemrcid4"));
			// after click the join button, a Joined mark should show behand the group
			assertTrue(joinButton.getText().contains("Joined")); 
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
	
	//	Given that I have logged in and want to leave my joined group
	//  When I click on the leave button
	//  Then I see that leave button changes to join button
	@Test
	public void leaveTest() {
		driver.findElement(By.cssSelector("input[onclick*='spanmemrcid4']")).click();//click the leave button to leave a group
		try {
			WebElement leaveButton = driver.findElement(By.cssSelector("input[onclick*='spanmemrcid4']"));
			// after click the leave button, it should be changed to join button
			assertTrue(leaveButton.getAttribute("value").equals("Join")); 
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
}
