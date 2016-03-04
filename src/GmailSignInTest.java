import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GmailSignInTest {
	WebDriver driver= new FirefoxDriver();

	@Test
	
	public void GmailLoginSucess()
	{
		
	
		driver.get("https://www.gmail.com");
		driver.manage().window().maximize();

		WebElement Username= driver.findElement(By.id( "Email"));
		Username.clear();
		Username.sendKeys("learnselenium7@gmail.com");
		
		
		
		WebElement NextButton= driver.findElement(By.id("next"));
		NextButton.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));
		
		WebElement passwordTextBox = driver.findElement(By.id("Passwd")); 
		passwordTextBox.clear(); 
		passwordTextBox.sendKeys("selenium123");
		
		
		
		WebElement SignInButton= driver.findElement(By.id("signIn"));
		SignInButton.click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
		
		Assert.assertTrue("Inbox should exist",driver.findElements(By.partialLinkText("Inbox")).size()>0);
		
		WebElement ProfileButton = driver.findElement(By.cssSelector("span[class='gb_Za gbii']"));
				ProfileButton.click();
				
		WebElement SignOut = driver.findElement(By.id("gb_71"));
				SignOut.click();
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signIn")));
				
		Assert.assertTrue("SignButton should exist",driver.findElements(By.id("signIn")).size()>0);		
			}
@After
public void tearDown()
{
	driver.quit();
}

}
