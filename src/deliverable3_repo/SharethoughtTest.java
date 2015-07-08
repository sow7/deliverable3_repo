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
	public void postTest() {
		new WebDriverWait(driver, 15).until(
			    ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[onclick*='tdlikecid418']"))
			);//since the share throught part is load slower than the other parts, so it need wait until it diplayed then commit the test
		driver.findElement(By.id("txtShare")).sendKeys("Unique@@");
		driver.findElement(By.id("btnShareComment")).click();
		WebElement shareContent=driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div[1]/table/tbody/tr/td/div/div/table/tbody/tr/td/table/tbody/tr[8]/td/table/tbody/tr[2]/td[2]"));
		try {
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
		WebElement likeButton = driver.findElement(By.cssSelector("a[onclick*='tdlikecid418']"));
		likeButton.click();
		try{
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
		WebElement unlikeButton = driver.findElement(By.cssSelector("a[onclick*='tdlikecid418']"));
		unlikeButton.click();
		try{
			assertTrue(unlikeButton.getText().equals("Like"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
}
