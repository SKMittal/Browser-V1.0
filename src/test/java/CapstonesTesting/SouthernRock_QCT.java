package CapstonesTesting;

import static org.testng.Assert.assertEquals;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

//*************Created by SRINIVAS TALLA****************

public class SouthernRock_QCT {
	 private WebDriver driver;
	 private String baseUrl;
	
	  
	  @BeforeTest(alwaysRun = true)
	  public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://qct.iil.co.uk/";
		    
		// In Order to run the Tests in particular environment. Change the above URLs accordingly  
		// DEV Environment: https://dev.insuranceinitiatives.co.uk/
		// QCT Environment: https://qct.iil.co.uk
		// UAT Environment: https://uat.insuranceinitiatives.co.uk/
		// LIVE Environment: https://secure.iil.co.uk/
		    
		driver.manage().window().maximize();    
		driver.get(baseUrl + "/");
		driver.findElement(By.id("client")).clear();
		driver.findElement(By.id("client")).sendKeys("000000");
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Waltersolo72?");
		driver.findElement(By.xpath("//button[@type='submit']")).click(); 
		    
		    }
	  
	    @Test(groups={"Smoke"})
	    public void sN_Corr_DOB_InCorr_Qua_Corr() throws Exception {
		
		driver.findElement(By.id("menu-4")).click();
	    String requestXml = "W:/Capstones Testing/Southern Rock/QCT/Request XML/Request1.xml";
	    String contents = FileUtils.readFileToString(new File(requestXml), "UTF-8");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//*[@id='form_motor_input']")).clear();
	    driver.findElement(By.xpath("//*[@id='form_motor_input']")).sendKeys(contents);
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//*[@id='form_button_submit']")).click();
	    Thread.sleep(2000);
	    String responseXml = driver.findElement(By.xpath("//*[@id='form_motor_output']")).getText();
	    File file = new File("W:/Capstones Testing/Southern Rock/QCT/Response XML/Response1.xml");
	    FileUtils.writeStringToFile(file,responseXml);
	    //Thread.sleep(1000);
	    assertEquals(true, responseXml.contains("888"));
	    }
	  
	    @Test(groups={"Regression"})
	    public void sN_InCorr_DOB_Corr_Qua_Corr() throws Exception {
    	
		driver.findElement(By.id("menu-4")).click();
	    String requestXml = "W:/Capstones Testing/Southern Rock/QCT/Request XML/Request2.xml";
	    String contents = FileUtils.readFileToString(new File(requestXml), "UTF-8");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//*[@id='form_motor_input']")).clear();
	    driver.findElement(By.xpath("//*[@id='form_motor_input']")).sendKeys(contents);
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//*[@id='form_button_submit']")).click();
	    Thread.sleep(2000);
	    String responseXml = driver.findElement(By.xpath("//*[@id='form_motor_output']")).getText();
	    File file = new File("W:/Capstones Testing/Southern Rock/QCT/Response XML/Response2.xml");
	    FileUtils.writeStringToFile(file,responseXml);
	    assertEquals(true, responseXml.contains("888"));
	    }
	        
	    @Test(groups={"Regression"})
		  public void sN_Corr_DOB_Corr_Qua_InCorr() throws Exception {
	    	
		    driver.findElement(By.id("menu-4")).click();
	    	String requestXml = "W:/Capstones Testing/Southern Rock/QCT/Request XML/Request3.xml";
		    String contents = FileUtils.readFileToString(new File(requestXml), "UTF-8");
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//*[@id='form_motor_input']")).clear();
		    driver.findElement(By.xpath("//*[@id='form_motor_input']")).sendKeys(contents);
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//*[@id='form_button_submit']")).click();
		    Thread.sleep(3000);
		    String responseXml = driver.findElement(By.xpath("//*[@id='form_motor_output']")).getText();
		    File file = new File("W:/Capstones Testing/Southern Rock/QCT/Response XML/Response3.xml");
		    FileUtils.writeStringToFile(file,responseXml);
		    assertEquals(true, responseXml.contains("888"));
	    }
	    	    
	    @Test(groups={"Regression"})
		  public void sN_Corr_DOB_Corr_Qua_Corr1() throws Exception {
	    	
		    driver.findElement(By.id("menu-4")).click();
		    String requestXml = "W:/Capstones Testing/Southern Rock/QCT/Request XML/Request4.xml";
		    String contents = FileUtils.readFileToString(new File(requestXml), "UTF-8");
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//*[@id='form_motor_input']")).clear();
		    driver.findElement(By.xpath("//*[@id='form_motor_input']")).sendKeys(contents);
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//*[@id='form_button_submit']")).click();
		    Thread.sleep(2000);
		    String responseXml = driver.findElement(By.xpath("//*[@id='form_motor_output']")).getText();
		    File file = new File("W:/Capstones Testing/Southern Rock/QCT/Response XML/Response4.xml");
		    FileUtils.writeStringToFile(file,responseXml);
		    assertEquals(true, responseXml.contains("DA4"));
		  }
		  		  
		  @Test(groups={"Regression"})
		  public void sN_Corr_DOB_Corr_Qua_Corr2() throws Exception { 
		    
			driver.findElement(By.id("menu-4")).click();
		    String requestXml = "W:/Capstones Testing/Southern Rock/QCT/Request XML/Request5.xml";
		    String contents = FileUtils.readFileToString(new File(requestXml), "UTF-8");
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//*[@id='form_motor_input']")).clear();
		    driver.findElement(By.xpath("//*[@id='form_motor_input']")).sendKeys(contents);
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//*[@id='form_button_submit']")).click();
		    Thread.sleep(2000);
		    String responseXml = driver.findElement(By.xpath("//*[@id='form_motor_output']")).getText();
		    File file = new File("W:/Capstones Testing/Southern Rock/QCT/Response XML/Response5.xml");
		    FileUtils.writeStringToFile(file,responseXml);
		    assertEquals(true, responseXml.contains("EA5"));		   
		  }
		  	  
		  @Test(groups={"Regression"})
		  public void sN_Corr_DOB_Corr_Qua_Corr3() throws Exception {
		    
			driver.findElement(By.id("menu-4")).click();
		    String requestXml = "W:/Capstones Testing/Southern Rock/QCT/Request XML/Request6.xml";
		    String contents = FileUtils.readFileToString(new File(requestXml), "UTF-8");
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//*[@id='form_motor_input']")).clear();
		    driver.findElement(By.xpath("//*[@id='form_motor_input']")).sendKeys(contents);
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//*[@id='form_button_submit']")).click();
		    Thread.sleep(2000);
		    String responseXml = driver.findElement(By.xpath("//*[@id='form_motor_output']")).getText();
		    File file = new File("W:/Capstones Testing/Southern Rock/QCT/Response XML/Response6.xml");
		    FileUtils.writeStringToFile(file,responseXml);
		    assertEquals(true, responseXml.contains("FA6"));
		  } 


	  @AfterTest(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();	    
	  } 
}
