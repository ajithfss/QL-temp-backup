package experiment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.qlearning.uat.utils.Utilities;

public class LoginWithGoogle {
	@Test
	public void verifyLoginWithGoogleFunctionality() {
		

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_WAIT_TIME));
		driver.get("https://uat.qlearning.academy/login");
		driver.findElement(By.xpath("//button[text()='Log in With Google']")).click();
		driver.findElement(By.id("identifierId")).sendKeys();
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.findElement(By.name("password")).sendKeys();
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		
	}

}
