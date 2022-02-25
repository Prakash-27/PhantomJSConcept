package com.PhanthomJS.Concept;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

/**
 * Hello world!
 *
 */
public class PhanthomDriverConcept {

	public static void main( String[] args ) throws InterruptedException {
		
		// phantomJS driver internally users GhostDriver
		// GhostDriver---> is used as a JSON Wire protocol -- HTTP REST call
		//Headless Browser Testing: 1. no browser will be launched
		//                          2. Testing is happening Behind the Scene
		//                          3. its very fast
		//                          4. its Directly interacts with your application HTML DOM
		
		
//      System.setProperty("webdriver.chrome.driver", 
//      "C:\\Users\\Prakash\\eclipse-workspace\\PhanthomJSConcept\\ChromeDriver\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		
		System.setProperty("phantomjs.binary.path", 
		"C:\\Users\\Prakash\\eclipse-workspace\\PhanthomJSConcept\\PhantomjsDriver\\phantomjs.exe");
		WebDriver driver = new PhantomJSDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));

		driver.get("http://automationpractice.com/index.php");

		String BeforeLoginTitle = driver.getTitle();

		System.out.println("Before login title----->" +BeforeLoginTitle);
		
		Thread.sleep(10000);

		WebElement SigninBtn = driver.findElement(By.xpath("//a[normalize-space()='Sign in']"));
		SigninBtn.click();

		WebElement EmailAddress = driver.findElement(By.id("email"));
		EmailAddress.sendKeys("prakashs23007@gmail.com");

		WebElement Password = driver.findElement(By.id("passwd"));
		Password.sendKeys("test123");
		
		Thread.sleep(10000);
		
		WebElement SubmitLogin = driver.findElement(By.id("SubmitLogin"));
		SubmitLogin.click();
		
		Thread.sleep(5000);
		
		String AfterLoginTitle = driver.getTitle();  

		System.out.println("After login title----->" +AfterLoginTitle);
		
		Thread.sleep(10000);

		WebElement SignOut = driver.findElement(By.xpath("//a[@title='Log me out']"));
		SignOut.click();
		
		Thread.sleep(5000);

		String SignOutTitle = driver.getTitle();
		System.out.println("SignOut Page Title---->" + SignOutTitle); 
		
		Thread.sleep(10000);
		
		WebElement ReturnToHome = driver.findElement(By.xpath("//a[@title='Return to Home']"));
		ReturnToHome.click();
		
		driver.quit();
		

	}

}
