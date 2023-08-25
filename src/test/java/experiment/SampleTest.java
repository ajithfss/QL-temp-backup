package experiment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qlearning.uat.utils.Utilities;

public class SampleTest {
	
    //recorded course uploading complete flow.
	@Test
	public void recordedCourseUpload() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_WAIT_TIME));
		driver.get("https://uat.qlearning.academy/login");
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email ']")).sendKeys("qltestingteam382@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Testing@123");
		driver.findElement(By.xpath("//button[text()='Log In']")).click();
		driver.findElement(By.xpath("//button[text()='Courses']")).click();
		driver.findElement(By.xpath("//button[text()='+ Create New Course']")).click();
		driver.findElement(By.name("courseName")).sendKeys("Automation Testing");
		driver.findElement(By.cssSelector("div.App div.container-fluid div.row div.col div.container div.d-block:nth-child(1) div.login-col div.quill.rich-h:nth-child(5) div.ql-container.ql-snow div.ql-editor.ql-blank > p:nth-child(1)")).sendKeys("hi");
		//driver.findElement(By.xpath("//div[@class='ql-container ql-snow']")).sendKeys("course description");
		driver.findElement(By.name("catogory")).click();
		driver.findElement(By.xpath("//option[text()='programming']")).click();
		driver.findElement(By.xpath("(//div[@class='tag-ajus mb-2']//select)[2]")).click();
		driver.findElement(By.xpath("//option[text()='python']")).click();
		driver.findElement(By.xpath("//div[text()='Next']")).click();
		driver.findElement(By.name("fee")).click();
		driver.findElement(By.xpath("//option[text()='999']")).click();
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		String projectPath = System.getProperty("user.dir");
		//driver.findElement(By.id("change_image")).sendKeys("C:\\Users\\ajith\\OneDrive\\Desktop\\QL COURSE creation\\AJAX PNG.png");
		driver.findElement(By.id("change_image")).sendKeys(projectPath+"\\courseUploadFiles\\courseimage.jpg");
		driver.findElement(By.id("change_video")).sendKeys(projectPath+"\\courseUploadFiles\\coursevideo.mp4");
		driver.findElement(By.xpath("//button[text()='Create Course']")).click();
			
	}
	@Test
	public void recordedCourseSubmitForReview() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_WAIT_TIME));
		driver.get("https://uat.qlearning.academy/login");
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email ']")).sendKeys("qltestingteam382@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Testing@123");
		driver.findElement(By.xpath("//button[text()='Log In']")).click();
		driver.findElement(By.xpath("//button[text()='Courses']")).click();
		driver.findElement(By.xpath("//button[text()='+ Create New Course']")).click();
		driver.findElement(By.name("courseName")).sendKeys("Automation Testing");
		driver.findElement(By.cssSelector("div.App div.container-fluid div.row div.col div.container div.d-block:nth-child(1) div.login-col div.quill.rich-h:nth-child(5) div.ql-container.ql-snow div.ql-editor.ql-blank > p:nth-child(1)")).sendKeys("hi");
		//driver.findElement(By.xpath("//div[@class='ql-container ql-snow']")).sendKeys("course description");
		driver.findElement(By.name("catogory")).click();
		driver.findElement(By.xpath("//option[text()='programming']")).click();
		driver.findElement(By.xpath("(//div[@class='tag-ajus mb-2']//select)[2]")).click();
		driver.findElement(By.xpath("//option[text()='python']")).click();
		driver.findElement(By.xpath("//div[text()='Next']")).click();
		driver.findElement(By.name("fee")).click();
		driver.findElement(By.xpath("//option[text()='999']")).click();
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		String projectPath = System.getProperty("user.dir");
		//driver.findElement(By.id("change_image")).sendKeys("C:\\Users\\ajith\\OneDrive\\Desktop\\QL COURSE creation\\AJAX PNG.png");
		driver.findElement(By.id("change_image")).sendKeys(projectPath+"\\courseUploadFiles\\courseimage.jpg");
		driver.findElement(By.id("change_video")).sendKeys(projectPath+"\\courseUploadFiles\\coursevideo.mp4");
		driver.findElement(By.xpath("//button[text()='Create Course']")).click();
		/////////////////////////////////////////////////////////////////////////////////////////
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//span[text()='Dashboard']")).click();
		driver.findElement(By.xpath("//button[text()='Courses']")).click();
		driver.findElement(By.xpath("(//p[text()='Edit'])[1]")).click();
		
		driver.findElement(By.linkText("Videos")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//button[text()='+ Create New Chapter']")).click();
		//driver.findElement(By.name("chapterName")).sendKeys("chapter 1");
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		driver.findElement(By.xpath("//input[@placeholder='Chapter Name']")).sendKeys("chapter 1");
		driver.findElement(By.xpath("//button[text()='Done']")).click();
		driver.findElement(By.xpath("(//h1[text()='chapter 1']/following-sibling::div)[2]")).click();
//		driver.findElement(By.xpath("//button[text()='+ Create New Lesson']")).click();
//		driver.findElement(By.name("lessonName")).sendKeys("lesson 1");
//		driver.findElement(By.id("change_video")).sendKeys(projectPath+"\\courseUploadFiles\\coursevideo.mp4");
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//driver.findElement(By.xpath("//label[@for='uploadFile']")).sendKeys(projectPath+"\\courseUploadFiles\\ajax.txt");
//		driver.findElement(By.xpath("//button[text()='Save']")).click();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		driver.findElement(By.xpath("//button[text()='+ Create Assessment']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Assessment Name Here*']")).sendKeys("assessment 1");
		driver.findElement(By.xpath("//button[text()='+ Create New']")).click();
		driver.findElement(By.xpath("//textarea[@placeholder='Enter Question here*']")).sendKeys("q");
		driver.findElement(By.name("option1")).sendKeys("a");
		driver.findElement(By.name("option2")).sendKeys("b");
		driver.findElement(By.name("option3")).sendKeys("c");
		driver.findElement(By.name("option4")).sendKeys("d");
		driver.findElement(By.tagName("select")).click();
		driver.findElement(By.xpath("(//select[@name='answer']//option)[2]")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.linkText("Live Videos")).click();
		driver.findElement(By.xpath("//button[text()='Schedule a Live']")).click();
		driver.findElement(By.name("topicName")).sendKeys("recorded course live video");
		
		driver.findElement(By.xpath("//input[@type='date']")).click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		driver.findElement(By.xpath("//input[@type='time']")).sendKeys("1810");
		driver.findElement(By.name("duration")).click();
		driver.findElement(By.xpath("//option[text()='30mins']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.linkText("FAQ")).click();
		driver.findElement(By.xpath("//button[text()='Create New']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.name("question")).sendKeys("what is an FAQ?");
		driver.findElement(By.name("answer")).sendKeys("Frequently Asked Questions");
		driver.findElement(By.xpath("//button[text()='Done']")).click();
		driver.findElement(By.xpath("//button[text()='Submit For Review']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//button[text()='Yes']")).click();
	}
//	@Test
//	public void loginWithGoogle() {
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_WAIT_TIME));
//		driver.get("https://uat.qlearning.academy/login");
//		driver.findElement(By.xpath("//button[text()='Log in With Google']")).click();
//		driver.findElement(By.id("identifierId")).sendKeys("ajithkumarb107@gmail.com");
//		driver.findElement(By.xpath("//span[text()='Next']")).click();	
//	}
	@Test
	public void verifyForgotPasswordWithNotRegisteredEmailId() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_WAIT_TIME));
		driver.get("https://uat.qlearning.academy/login");
		driver.findElement(By.xpath("//label[text()='Forgot Password?']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Type Your Email']")).sendKeys("ajithaadhav@mail.com");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		String warningText = driver.findElement(By.xpath("//small[text()='Unable to find this user']")).getText();
		Assert.assertEquals(warningText, "Unable to find this user");
		
	}
	
	public void enableDemo() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_WAIT_TIME));
		driver.findElement(By.xpath("//button[text()='Enable Demo']")).click();
	}
	
	
	
	
	
	
	
	
	@Test
public void LiveCourseUpload() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_WAIT_TIME));
		driver.get("https://uat.qlearning.academy/login");
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email ']")).sendKeys("qltestingteam382@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Testing@123");
		driver.findElement(By.xpath("//button[text()='Log In']")).click();
		driver.findElement(By.xpath("//button[text()='Courses']")).click();
		driver.findElement(By.linkText("Live Courses")).click();
		driver.findElement(By.xpath("//button[text()='+ Create New Course']")).click();
		driver.findElement(By.xpath("//label[text()='Course Title']/following-sibling::input")).sendKeys("live course automation");
		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/form[1]/div[2]/div[2]/div[1]/p[1]")).sendKeys("courseeeeee");
		//driver.findElement(By.xpath("//select[@fdprocessedid='4fyp05']")).click();
		//driver.findElement(By.xpath("//select[@fdprocessedid='jy120l']")).click();
		driver.findElement(By.xpath("(//div[@class='tag-ajus mb-2']//select)[1]")).click();
		driver.findElement(By.xpath("//option[text()='programming']")).click();
		driver.findElement(By.xpath("(//div[@class='tag-ajus mb-2']//select)[2]")).click();
		//driver.findElement(By.xpath("//select[@fdprocessedid='q3brza']")).click();
		driver.findElement(By.xpath("//option[text()='python']")).click();
		driver.findElement(By.xpath("(//button[text()='Next'])[1]")).click();
		driver.findElement(By.xpath("(//div[@class='tag-ajus']//select)[2]")).click();
		//driver.findElement(By.xpath("//select[@fdprocessedid='i8b54m']")).click();
		driver.findElement(By.xpath("//option[text()='1000']")).click();
		String projectPath = System.getProperty("user.dir");
		driver.findElement(By.id("change_image")).sendKeys(projectPath+"\\courseUploadFiles\\courseimage.jpg");
		driver.findElement(By.id("change_video")).sendKeys(projectPath+"\\courseUploadFiles\\coursevideo.mp4");
		driver.findElement(By.xpath("(//button[text()='Next'])[2]")).click();
		driver.findElement(By.xpath("(//div[@class='tag-ajus']//select)[3]")).click();
		//driver.findElement(By.xpath("//select[@fdprocessedid='j37j1']")).click();
		driver.findElement(By.xpath("//option[text()='1 month']")).click();
		//driver.findElement(By.xpath("//input[@placeholder=' ']")).click();
		driver.findElement(By.xpath("//input[@type='date']")).click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		driver.findElement(By.id("sunday")).click();
		driver.findElement(By.xpath("(//input[@name='startTime'])[1]")).sendKeys("1700");
		driver.findElement(By.xpath("(//input[@name='endTime'])[1]")).sendKeys("1800");
		driver.findElement(By.id("monday")).click();
		driver.findElement(By.xpath("(//input[@name='startTime'])[2]")).sendKeys("1700");
		driver.findElement(By.xpath("(//input[@name='endTime'])[2]")).sendKeys("1800");
		driver.findElement(By.id("tuesday")).click();
		driver.findElement(By.xpath("(//input[@name='startTime'])[3]")).sendKeys("1700");
		driver.findElement(By.xpath("(//input[@name='endTime'])[3]")).sendKeys("1800");
		driver.findElement(By.id("wednesday")).click();
		driver.findElement(By.xpath("(//input[@name='startTime'])[4]")).sendKeys("1700");
		driver.findElement(By.xpath("(//input[@name='endTime'])[4]")).sendKeys("1800");
		driver.findElement(By.id("thursday")).click();
		driver.findElement(By.xpath("(//input[@name='startTime'])[5]")).sendKeys("1700");
		driver.findElement(By.xpath("(//input[@name='endTime'])[5]")).sendKeys("1800");
		driver.findElement(By.id("friday")).click();
		driver.findElement(By.xpath("(//input[@name='startTime'])[6]")).sendKeys("1700");
		driver.findElement(By.xpath("(//input[@name='endTime'])[6]")).sendKeys("1800");
		driver.findElement(By.id("saturday")).click();
		driver.findElement(By.xpath("(//input[@name='startTime'])[7]")).sendKeys("1700");
		driver.findElement(By.xpath("(//input[@name='endTime'])[7]")).sendKeys("1800");
		driver.findElement(By.xpath("//button[text()='Create']")).click();			
	}
	
	@Test
	public void assessmentUpload() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_WAIT_TIME));
		driver.get("https://uat.qlearning.academy/login");
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email ']")).sendKeys("qltestingteam382@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Testing@123");
		driver.findElement(By.xpath("//button[text()='Log In']")).click();
		driver.findElement(By.xpath("//button[text()='Courses']")).click();
		driver.findElement(By.linkText("Assessments")).click();
		driver.findElement(By.xpath("//button[text()='+ Create New Assessment']")).click();
		driver.findElement(By.tagName("input")).sendKeys("Automated assessment");
		driver.findElement(By.xpath("(//div[@class='tag-ajus mb-2']//select)[1]")).click();
		driver.findElement(By.xpath("//option[text()='programming']")).click();
		driver.findElement(By.xpath("(//div[@class='tag-ajus mb-2']//select)[2]")).click();
		driver.findElement(By.xpath("//option[text()='python']")).click();
		driver.findElement(By.xpath("(//div[@class='tag-ajus']//select)[2]")).click();
		driver.findElement(By.xpath("//option[text()='1000']")).click();
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		driver.findElement(By.xpath("//button[text()='+ Create New']")).click();
		driver.findElement(By.name("question")).sendKeys(" In which process, a local variable has the same name as one of the instance variables?");
		driver.findElement(By.name("option1")).sendKeys("Serialization");
		driver.findElement(By.name("option2")).sendKeys("Variable Shadowing");
		driver.findElement(By.name("option3")).sendKeys("Abstraction");
		driver.findElement(By.name("option4")).sendKeys("Multi-threading");
		driver.findElement(By.tagName("select")).click();
		driver.findElement(By.xpath("(//select[@name='answer']//option)[2]")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();	
	}
	
	@Test
	 public void verifyCouponCreationFunctionality() {
		 
		 WebDriver driver = new ChromeDriver();
		 
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_WAIT_TIME));
			driver.get("https://uat.qlearning.academy/login");
			driver.findElement(By.xpath("//input[@placeholder='Enter your Email ']")).sendKeys("qltestingteam382@gmail.com");
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Testing@123");
			driver.findElement(By.xpath("//button[text()='Log In']")).click();
			driver.findElement(By.xpath("(//img[@alt='Profile Image'])[2]")).click();
			driver.findElement(By.linkText("Coupon")).click();
			driver.findElement(By.name("couponName")).sendKeys("Test10");
			driver.findElement(By.tagName("select")).click();
			driver.findElement(By.xpath("//option[text()='10%']")).click();
			driver.findElement(By.name("noOfCoupon")).sendKeys("10");
			driver.findElement(By.name("startDate")).sendKeys("09-08-2023");
			driver.findElement(By.name("expiryDate")).sendKeys("09-09-2023");
			driver.findElement(By.xpath("//button[text()='Submit']")).click();
	 }
	
	@Test
	public void activateTheRecordedCourseFromAdminDashBoard() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_WAIT_TIME));
		driver.get("https://uat.qlearning.academy/login");
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email ']")).sendKeys("qltestingteam382@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Testing@123");
		driver.findElement(By.xpath("//button[text()='Log In']")).click();
		driver.findElement(By.xpath("//button[text()='Courses']")).click();
		driver.findElement(By.xpath("//button[text()='+ Create New Course']")).click();
		driver.findElement(By.name("courseName")).sendKeys("Automation Testing");
		driver.findElement(By.cssSelector("div.App div.container-fluid div.row div.col div.container div.d-block:nth-child(1) div.login-col div.quill.rich-h:nth-child(5) div.ql-container.ql-snow div.ql-editor.ql-blank > p:nth-child(1)")).sendKeys("hi");
		driver.findElement(By.name("catogory")).click();
		driver.findElement(By.xpath("//option[text()='programming']")).click();
		driver.findElement(By.xpath("(//div[@class='tag-ajus mb-2']//select)[2]")).click();
		driver.findElement(By.xpath("//option[text()='python']")).click();
		driver.findElement(By.xpath("//div[text()='Next']")).click();
		driver.findElement(By.name("fee")).click();
		driver.findElement(By.xpath("//option[text()='999']")).click();
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		String projectPath = System.getProperty("user.dir");
		
		driver.findElement(By.id("change_image")).sendKeys(projectPath+"\\courseUploadFiles\\courseimage.jpg");
		driver.findElement(By.id("change_video")).sendKeys(projectPath+"\\courseUploadFiles\\coursevideo.mp4");
		driver.findElement(By.xpath("//button[text()='Create Course']")).click();
		/////////////////////////////////////////////////////////////////////////////////////////
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//span[text()='Dashboard']")).click();
		driver.findElement(By.xpath("//button[text()='Courses']")).click();
		driver.findElement(By.xpath("(//p[text()='Edit'])[1]")).click();
		
		driver.findElement(By.linkText("Videos")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//button[text()='+ Create New Chapter']")).click();
	
		driver.findElement(By.xpath("//input[@placeholder='Chapter Name']")).sendKeys("chapter 1");
		driver.findElement(By.xpath("//button[text()='Done']")).click();
		driver.findElement(By.xpath("(//h1[text()='chapter 1']/following-sibling::div)[2]")).click();
		
		driver.findElement(By.xpath("//button[text()='+ Create Assessment']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Assessment Name Here*']")).sendKeys("assessment 1");
		driver.findElement(By.xpath("//button[text()='+ Create New']")).click();
		driver.findElement(By.xpath("//textarea[@placeholder='Enter Question here*']")).sendKeys("q");
		driver.findElement(By.name("option1")).sendKeys("a");
		driver.findElement(By.name("option2")).sendKeys("b");
		driver.findElement(By.name("option3")).sendKeys("c");
		driver.findElement(By.name("option4")).sendKeys("d");
		driver.findElement(By.tagName("select")).click();
		driver.findElement(By.xpath("(//select[@name='answer']//option)[2]")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.linkText("Live Videos")).click();
		driver.findElement(By.xpath("//button[text()='Schedule a Live']")).click();
		driver.findElement(By.name("topicName")).sendKeys("recorded course live video");
		
		driver.findElement(By.xpath("//input[@type='date']")).click();
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		driver.findElement(By.xpath("//input[@type='time']")).sendKeys("1810");
		driver.findElement(By.name("duration")).click();
		driver.findElement(By.xpath("//option[text()='30mins']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.findElement(By.linkText("FAQ")).click();
		driver.findElement(By.xpath("//button[text()='Create New']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.name("question")).sendKeys("what is an FAQ?");
		driver.findElement(By.name("answer")).sendKeys("Frequently Asked Questions");
		driver.findElement(By.xpath("//button[text()='Done']")).click();
		driver.findElement(By.xpath("//button[text()='Submit For Review']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//button[text()='Yes']")).click();
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.findElement(By.xpath("//button[text()='Yes']")).click();
		///////////////////////////////////////////////////////////////////
		
		driver.get("https://uat-admin.qlearning.academy/login");
		driver.findElement(By.name("email")).sendKeys("qlearninga@gmail.com");
		driver.findElement(By.name("password")).sendKeys("qlearninga@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("(//span[text()=' All Courses'])[1]")).click();
		driver.findElement(By.xpath("(//div[@class='col-lg-2 m-auto']//button)[1]")).click();
		driver.findElement(By.xpath("(//a[contains(@class,'rounded-1 fz-14px')])[2]")).click();
		driver.findElement(By.xpath("(//div[@class='ms-auto'])[2]")).click();
		driver.findElement(By.xpath("//div[text()='Approve']")).click();
		driver.findElement(By.linkText("Uploaded Videos")).click();
		driver.findElement(By.xpath("(//div[@role='button']//div)[3]")).click();
		driver.findElement(By.className("text-capitalize")).click();
		driver.findElement(By.xpath("//div[text()='Approve']")).click();
		driver.findElement(By.xpath("//h6[@class='text-dark d-inline-block']")).click();
		driver.findElement(By.linkText("FAQ")).click();
		driver.findElement(By.xpath("//div[text()='Approve']")).click();
		driver.findElement(By.xpath("//button[text()='Activate']")).click();
			
		
	}
	
	@Test
	public void verifyadminUrlCheck() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_WAIT_TIME));
		driver.get("https://uat.qlearning.academy/login");
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email ']")).sendKeys("qltestingteam382@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Testing@123");
		driver.findElement(By.xpath("//button[text()='Log In']")).click();
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.findElement(By.xpath("//button[text()='Yes']")).click();
		driver.get("https://uat-admin.qlearning.academy/login");
		driver.findElement(By.name("email")).sendKeys("qlearninga@gmail.com");
		driver.findElement(By.name("password")).sendKeys("qlearninga@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("(//span[text()=' All Courses'])[1]")).click();
		driver.findElement(By.xpath("(//div[@class='col-lg-2 m-auto']//button)[1]")).click();
//		driver.findElement(By.xpath("(//a[contains(@class,'rounded-1 fz-14px')])[2]")).click();
//		driver.findElement(By.xpath("(//div[@class='ms-auto'])[2]")).click();
//		driver.findElement(By.xpath("//div[text()='Approve']")).click();
//		driver.findElement(By.linkText("Uploaded Videos")).click();
//		driver.findElement(By.xpath("(//div[@role='button']//div)[3]")).click();
//		driver.findElement(By.className("text-capitalize")).click();
//		driver.findElement(By.xpath("//div[text()='Approve']")).click();
//		driver.findElement(By.xpath("//h6[@class='text-dark d-inline-block']")).click();
//		driver.findElement(By.linkText("FAQ")).click();
//		driver.findElement(By.xpath("//div[text()='Approve']")).click();
//		driver.findElement(By.xpath("//button[text()='Activate']")).click();
			
	}
	
	@Test
	public void activateLiveCourseFromAdminDashboard() {
		

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_WAIT_TIME));
		driver.get("https://uat.qlearning.academy/login");
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email ']")).sendKeys("qltestingteam382@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Testing@123");
		driver.findElement(By.xpath("//button[text()='Log In']")).click();
		driver.findElement(By.xpath("//button[text()='Courses']")).click();
		driver.findElement(By.linkText("Live Courses")).click();
		driver.findElement(By.xpath("//button[text()='+ Create New Course']")).click();
		driver.findElement(By.xpath("//label[text()='Course Title']/following-sibling::input")).sendKeys("live course automation");
		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/form[1]/div[2]/div[2]/div[1]/p[1]")).sendKeys("courseeeeee");
		
		driver.findElement(By.xpath("(//div[@class='tag-ajus mb-2']//select)[1]")).click();
		driver.findElement(By.xpath("//option[text()='programming']")).click();
		driver.findElement(By.xpath("(//div[@class='tag-ajus mb-2']//select)[2]")).click();
		
		driver.findElement(By.xpath("//option[text()='python']")).click();
		driver.findElement(By.xpath("(//button[text()='Next'])[1]")).click();
		driver.findElement(By.xpath("(//div[@class='tag-ajus']//select)[2]")).click();
		
		driver.findElement(By.xpath("//option[text()='1000']")).click();
		String projectPath = System.getProperty("user.dir");
		driver.findElement(By.id("change_image")).sendKeys(projectPath+"\\courseUploadFiles\\courseimage.jpg");
		driver.findElement(By.id("change_video")).sendKeys(projectPath+"\\courseUploadFiles\\coursevideo.mp4");
		driver.findElement(By.xpath("(//button[text()='Next'])[2]")).click();
		driver.findElement(By.xpath("(//div[@class='tag-ajus']//select)[3]")).click();
		
		driver.findElement(By.xpath("//option[text()='1 month']")).click();
		driver.findElement(By.xpath("//input[@type='date']")).click();
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		driver.findElement(By.id("sunday")).click();
		driver.findElement(By.xpath("(//input[@name='startTime'])[1]")).sendKeys("1700");
		driver.findElement(By.xpath("(//input[@name='endTime'])[1]")).sendKeys("1800");
		driver.findElement(By.id("monday")).click();
		driver.findElement(By.xpath("(//input[@name='startTime'])[2]")).sendKeys("1700");
		driver.findElement(By.xpath("(//input[@name='endTime'])[2]")).sendKeys("1800");
		driver.findElement(By.id("tuesday")).click();
		driver.findElement(By.xpath("(//input[@name='startTime'])[3]")).sendKeys("1700");
		driver.findElement(By.xpath("(//input[@name='endTime'])[3]")).sendKeys("1800");
		driver.findElement(By.id("wednesday")).click();
		driver.findElement(By.xpath("(//input[@name='startTime'])[4]")).sendKeys("1700");
		driver.findElement(By.xpath("(//input[@name='endTime'])[4]")).sendKeys("1800");
		driver.findElement(By.id("thursday")).click();
		driver.findElement(By.xpath("(//input[@name='startTime'])[5]")).sendKeys("1700");
		driver.findElement(By.xpath("(//input[@name='endTime'])[5]")).sendKeys("1800");
		driver.findElement(By.id("friday")).click();
		driver.findElement(By.xpath("(//input[@name='startTime'])[6]")).sendKeys("1700");
		driver.findElement(By.xpath("(//input[@name='endTime'])[6]")).sendKeys("1800");
		driver.findElement(By.id("saturday")).click();
		driver.findElement(By.xpath("(//input[@name='startTime'])[7]")).sendKeys("1700");
		driver.findElement(By.xpath("(//input[@name='endTime'])[7]")).sendKeys("1800");
		driver.findElement(By.xpath("//button[text()='Create']")).click();
		//////////////////////////
		driver.findElement(By.xpath("(//p[text()='Edit'])[1]")).click();
		driver.findElement(By.xpath("//button[text()='Submit For Review']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//button[text()='Yes']")).click();
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		/////////////
		driver.get("https://uat-admin.qlearning.academy/login");
		driver.findElement(By.name("email")).sendKeys("qlearninga@gmail.com");
		driver.findElement(By.name("password")).sendKeys("qlearninga@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("(//span[text()=' All Courses'])[1]")).click();
		driver.findElement(By.xpath("(//div[@class='col-lg-2 m-auto']//button)[1]")).click();
		driver.findElement(By.linkText("Course Duration")).click();
		driver.findElement(By.xpath("//div[text()='Approve']")).click();
		driver.findElement(By.xpath("//button[text()='Activate']")).click();	
		
	}
}
