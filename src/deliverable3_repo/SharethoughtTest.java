package deliverable3_repo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class SharethoughtTest {

	static WebDriver driver = new HtmlUnitDriver();

	@Before
	public void setUp() throws Exception {
		// get into the main page of the web site
		driver.get("http://halley.exp.sis.pitt.edu/comet/login.do");

		// click the link of sign in and get into the sign in page for next
		// testing

		driver.findElement(By.name("userEmail")).sendKeys(
				"lanzhang.lemon@gmail.com");
		driver.findElement(By.name("password")).sendKeys("lzhang11");
		WebElement loginButton = driver.findElement(By.id("btnSignin"));
		loginButton.click();
	}

	@Test
	public void test() {
		driver.findElement(By.tagName("textarea")).sendKeys(
				"test11");
		
		WebElement ShareButton = driver.findElement(By.id("btnShareComment"));
		ShareButton.click();
		
//		find the content of this path:
		WebElement shareContent=driver.findElement(By.xpath("//*[@id='tdRecentActivity']/table[1]/tbody/tr[2]/td[2]/text()[1]"));
		String content=shareContent.getText();
		try {
			
			assertEquals(content.contains("test11"),true);
		} catch (NoSuchElementException nseex) {
			fail();
		}
		
	}

}
