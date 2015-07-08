package deliverable3_repo;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SharethoughtTest {
	
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

	@Test
	public void postTest() {
		new WebDriverWait(driver, 15).until(
			    ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[onclick*='tdlikecid418']"))
			);//since the share throught part is load slower than the other parts, so it need wait until it diplayed then commit the test
		
		//input the idea
		driver.findElement(By.id("txtShare")).sendKeys("Unique@@");
		//click share button
		driver.findElement(By.id("btnShareComment")).click();
		//look for the lastest idea shared
		WebElement shareContent=driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div[1]/table/tbody/tr/td/div/div/table/tbody/tr/td/table/tbody/tr[8]/td/table/tbody/tr[2]/td[2]"));
		try {
			//the lastest on post should be the one above
			assertTrue(shareContent.getText().contains("Unique@@"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
	
	@Test
	public void unlikeTest() {
		new WebDriverWait(driver, 15).until(
			    ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[onclick*='tdlikecid418']"))
			);//since the share throught part is load slower than the other parts, so it need wait until it diplayed then commit the test
		
		//look for the like button
		WebElement likeButton = driver.findElement(By.cssSelector("a[onclick*='tdlikecid418']"));
		//click the like button
		likeButton.click();
		try{
			//the like button should be changed to unlike button
			assertTrue(likeButton.getText().equals("Unlike"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
	
	@Test
	public void likeTest() {
		new WebDriverWait(driver, 15).until(
			    ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[onclick*='tdlikecid418']"))
			);//since the share throught part is load slower than the other parts, so it need wait until it diplayed then commit the test
		
		//look for the unlike button
		WebElement unlikeButton = driver.findElement(By.cssSelector("a[onclick*='tdlikecid418']"));
		//click the unlike button
		unlikeButton.click();
		try{
			//the unlike button should be changed back to like button
			assertTrue(unlikeButton.getText().equals("Like"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
}
