package CapstonesTesting;

import java.io.File;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//*************Created by SRINIVAS TALLA****************

public class JohnLewisFS_QCT {
	  private WebDriver driver;
	  private String baseUrl;
	  
	  @BeforeTest(alwaysRun = true)
	  public void setUp() throws Exception {
		//driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", "W:/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		baseUrl = "https://qct.iil.co.uk";
		
		// In Order to run the Tests in particular environment. Change the above URLs accordingly  
		// DEV Environment: https://dev.insuranceinitiatives.co.uk/
		// QCT Environment: https://qct.iil.co.uk
		// UAT Environment: https://uat.insuranceinitiatives.co.uk/
		// LIVE Environment: https://secure.iil.co.uk/
		
		driver.manage().window().maximize();
		
	  }	  
	  
	    @Test(groups={"Smoke"})
	    public void personExistInKeysearch() throws Exception {	  
	    	
	    driver.get(baseUrl + "/");
		driver.findElement(By.id("client")).clear();
		driver.findElement(By.id("client")).sendKeys("000000");
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Waltersolo72?");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.id("menu-4")).click();
	    String requestXml = "W:/Capstones Testing/John Lewis/QCT/Request XML/Request1.xml";
	    String contents = FileUtils.readFileToString(new File(requestXml), "UTF-8");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//*[@id='form_motor_input']")).clear();
	    driver.findElement(By.xpath("//*[@id='form_motor_input']")).sendKeys(contents);
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//*[@id='form_button_submit']")).click();
	    Thread.sleep(1000);
	    String responseXml = driver.findElement(By.xpath("//*[@id='form_motor_output']")).getText();
	    File file = new File("W:/Capstones Testing/John Lewis/QCT/Response XML/Response1.xml");
	    FileUtils.writeStringToFile(file,responseXml);
	    //Thread.sleep(1000);
	    assertEquals(true, responseXml.contains("600A0000"));
	  }
	  
	    @Test(groups={"Regression"})
	    public void personDoesNotExistInKeysearch() throws Exception {
	    driver.get(baseUrl + "/");
		driver.findElement(By.id("client")).clear();
		driver.findElement(By.id("client")).sendKeys("000000");
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Waltersolo72?");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.id("menu-4")).click();
	    String requestXml = "W:/Capstones Testing/John Lewis/QCT/Request XML/Request2.xml";
	    String contents = FileUtils.readFileToString(new File(requestXml), "UTF-8");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//*[@id='form_motor_input']")).clear();
	    driver.findElement(By.xpath("//*[@id='form_motor_input']")).sendKeys(contents);
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//*[@id='form_button_submit']")).click();
	    Thread.sleep(2000);
	    String responseXml = driver.findElement(By.xpath("//*[@id='form_motor_output']")).getText();
	    File file = new File("W:/Capstones Testing/John Lewis/QCT/Response XML/Response2.xml");
	    FileUtils.writeStringToFile(file,responseXml);
	    assertEquals(true, responseXml.contains("00000000"));
	    }	    
	    
	        @Test(groups={"Regression"})
		    public void multiplePeopleWithSameFirstname() throws Exception {
	        driver.get(baseUrl + "/");
	    	driver.findElement(By.id("client")).clear();
	    	driver.findElement(By.id("client")).sendKeys("000000");
	    	driver.findElement(By.id("username")).clear();
	    	driver.findElement(By.id("username")).sendKeys("Admin");
	    	driver.findElement(By.id("password")).clear();
	    	driver.findElement(By.id("password")).sendKeys("Waltersolo72?");
	    	driver.findElement(By.xpath("//button[@type='submit']")).click();
	    	driver.findElement(By.id("menu-4")).click();
	    	String requestXml = "W:/Capstones Testing/John Lewis/QCT/Request XML/Request3.xml";
		    String contents = FileUtils.readFileToString(new File(requestXml), "UTF-8");
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//*[@id='form_motor_input']")).clear();
		    driver.findElement(By.xpath("//*[@id='form_motor_input']")).sendKeys(contents);
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//*[@id='form_button_submit']")).click();
		    Thread.sleep(2000);
		    String responseXml = driver.findElement(By.xpath("//*[@id='form_motor_output']")).getText();
		    File file = new File("W:/Capstones Testing/John Lewis/QCT/Response XML/Response3.xml");
		    FileUtils.writeStringToFile(file,responseXml);
		    assertEquals(true, responseXml.contains("600B0000"));
	        }    
	    
	        @Test(groups={"Regression"})
		    public void usePersonsInitial() throws Exception {
	        driver.get(baseUrl + "/");
	    	driver.findElement(By.id("client")).clear();
	    	driver.findElement(By.id("client")).sendKeys("000000");
	    	driver.findElement(By.id("username")).clear();
	    	driver.findElement(By.id("username")).sendKeys("Admin");
	    	driver.findElement(By.id("password")).clear();
	    	driver.findElement(By.id("password")).sendKeys("Waltersolo72?");
	    	driver.findElement(By.xpath("//button[@type='submit']")).click();
	    	driver.findElement(By.id("menu-4")).click();
		    String requestXml = "W:/Capstones Testing/John Lewis/QCT/Request XML/Request4.xml";
		    String contents = FileUtils.readFileToString(new File(requestXml), "UTF-8");
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//*[@id='form_motor_input']")).clear();
		    driver.findElement(By.xpath("//*[@id='form_motor_input']")).sendKeys(contents);
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//*[@id='form_button_submit']")).click();
		    Thread.sleep(2000);
		    String responseXml = driver.findElement(By.xpath("//*[@id='form_motor_output']")).getText();
		    File file = new File("W:/Capstones Testing/John Lewis/QCT/Response XML/Response4.xml");
		    FileUtils.writeStringToFile(file,responseXml);
		    assertEquals(true, responseXml.contains("520A0000"));
		    }
		  		  
		    @Test(groups={"Regression"})
		    public void multiplePeopleWithSameSurname() throws Exception { 
		    driver.get(baseUrl + "/");
			driver.findElement(By.id("client")).clear();
			driver.findElement(By.id("client")).sendKeys("000000");
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys("Admin");
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys("Waltersolo72?");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			driver.findElement(By.id("menu-4")).click();
		    String requestXml = "W:/Capstones Testing/John Lewis/QCT/Request XML/Request5.xml";
		    String contents = FileUtils.readFileToString(new File(requestXml), "UTF-8");
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//*[@id='form_motor_input']")).clear();
		    driver.findElement(By.xpath("//*[@id='form_motor_input']")).sendKeys(contents);
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//*[@id='form_button_submit']")).click();
		    Thread.sleep(2000);
		    String responseXml = driver.findElement(By.xpath("//*[@id='form_motor_output']")).getText();
		    File file = new File("W:/Capstones Testing/John Lewis/QCT/Response XML/Response5.xml");
		    FileUtils.writeStringToFile(file,responseXml);
		    assertEquals(true, responseXml.contains("60000A00"));
		    }
		  		
		  
		    @Test(groups={"Regression"})
		    public void multiplePeopleWithSameFullNameUseInitial() throws Exception {
		    driver.get(baseUrl + "/");
			driver.findElement(By.id("client")).clear();
			driver.findElement(By.id("client")).sendKeys("000000");
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys("Admin");
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys("Waltersolo72?");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			driver.findElement(By.id("menu-4")).click();
		    String requestXml = "W:/Capstones Testing/John Lewis/QCT/Request XML/Request6.xml";
		    String contents = FileUtils.readFileToString(new File(requestXml), "UTF-8");
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//*[@id='form_motor_input']")).clear();
		    driver.findElement(By.xpath("//*[@id='form_motor_input']")).sendKeys(contents);
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//*[@id='form_button_submit']")).click();
		    Thread.sleep(2000);
		    String responseXml = driver.findElement(By.xpath("//*[@id='form_motor_output']")).getText();
		    File file = new File("W:/Capstones Testing/John Lewis/QCT/Response XML/Response6.xml");
		    FileUtils.writeStringToFile(file,responseXml);
		    assertEquals(true, responseXml.contains("520C0000"));
		    } 
               
	         @AfterTest(alwaysRun = true)
	         public void tearDown() throws Exception {
		     driver.quit();
		     //System.out.println("-----Report Creation Completed: " + System.currentTimeMillis());	
		     //Thread.sleep(3000)
	         } 
 }  
	  

