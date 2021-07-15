package Com.Qa.ParaBankDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParaBankDemoAutomation {

	WebDriver driver;

	@BeforeTest
	public void setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");			
	}

	@Test

	public void verifypagetitlebefore() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	@Test

	public void verifyCredentialsTest() {

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("pavanggowda28@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("@Bail123");
		driver.findElement(By.xpath("//input[@type='submit']")).sendKeys(Keys.ENTER);

		String Hometitle = driver.getTitle();
		System.out.println(Hometitle);
		Assert.assertEquals(Hometitle, "ParaBank | Accounts Overview","The title is properly displayed" );

	}

	@Test
	public void logoutLinkTest() {
		Assert.assertTrue(driver.findElement(By.linkText("Services")).isDisplayed());
	}

	@Test
	public void searchBarTest() {
		Assert.assertTrue(driver.findElement(By.xpath("//img[@title='ParaBank']")).isDisplayed());

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}






}
