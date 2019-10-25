import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\eclipse-workspace\\Hudl\\drivers\\chromedriver.exe");
	}
	
	@Test
	public void successfulLogin() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://hudl.com");
		WebElement loginHomePage = driver.findElement(By.xpath("//*[@id=\"nav\"]/ul/li[6]/a"));
		loginHomePage.click();
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys("nshull16@iastate.edu");
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("Qwerty1234");
		WebElement loginButton = driver.findElement(By.id("logIn"));
		loginButton.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.close();
		//System.out.println("Login success test completed successfully");
		Boolean loginSuccess = driver.findElements(By.xpath("//*[@id=\"ssr-webnav\"]/div/div[1]/nav[1]/div[4]/a[1]")).size() > 0;
		assertEquals(loginSuccess, true);
		driver.close();
	}
	
	@Test
	public void unsuccessfulLogin() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://hudl.com");
		WebElement loginHomePage = driver.findElement(By.xpath("//*[@id=\"nav\"]/ul/li[6]/a"));
		loginHomePage.click();
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys("nshull16@iastate.edu");
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("incorrectPassword");
		WebElement loginButton = driver.findElement(By.id("logIn"));
		loginButton.click();
		Boolean incorrectPassword = driver.findElements(By.className("login-error-container")).size() > 0;
		assertEquals(incorrectPassword, true);
		driver.close();
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}


}
