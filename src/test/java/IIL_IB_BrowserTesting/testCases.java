package IIL_IB_BrowserTesting;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testCases {
	  private WebDriver driver;
	  private String baseUrl;

	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "https://secure.sbx-stalla.test/";
	    driver.manage().window().maximize();	    
	  }
	  
	  @Test(groups={"Smoke"})
	  public void verifyHomePage() throws Exception {
	    driver.get(baseUrl + "/");
		driver.findElement(By.id("client")).clear();
		driver.findElement(By.id("client")).sendKeys("A00578");
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("bdml");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("XWXVH2jjRf9AiTftzoBJ");
		driver.findElement(By.xpath("//button[@type='submit']")).click();	
	    assertEquals(driver.findElement(By.xpath("//*[@id='sub-mast']/div[1]/span[2]/h2")).getText(), "Insurance initiatives Ltd.");
	  } 
	  
	  @Test(groups={"Smoke"})
	  public void verifyIILAdvisorMotorPage() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.id("client")).clear();
		driver.findElement(By.id("client")).sendKeys("A00578");
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("bdml");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("XWXVH2jjRf9AiTftzoBJ");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000); 
	    driver.findElement(By.cssSelector("span.has-icon.right")).click();
	    driver.findElement(By.linkText("Motor")).click();
	    assertEquals(driver.findElement(By.xpath("//div[@id='sub-mast']/div/span[2]/h2")).getText(), "IIL Advisor (Motor)");
	  } 
	  
	  @Test(groups={"Smoke"})
	  public void verifyReviewTransactionsMotorPage() throws Exception {
		driver.get(baseUrl + "/");
		driver.findElement(By.id("client")).clear();
		driver.findElement(By.id("client")).sendKeys("A00578");
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("bdml");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("XWXVH2jjRf9AiTftzoBJ");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);   
	    driver.findElement(By.xpath("//*[@id='menu-id-0-232-0']/a/span[3]/img")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@id='menu-id-232-8-1']/a/span")).click();
	    Thread.sleep(3000);
	    assertEquals(driver.findElement(By.xpath("//div[@id='sub-mast']/div/span[2]/h2")).getText(), "Review Transactions (Motor)");
	  }
	  

	  @AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();
	    }
}
