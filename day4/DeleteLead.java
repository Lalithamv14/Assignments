package day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
	

		public static void main(String[] args) throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver=new ChromeDriver();
			driver.get("http://leaftaps.com/opentaps/control/login");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demosalesmanager");
		    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		    driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		    driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		    driver.findElement(By.xpath("//a[text()='Leads']")).click();
		    driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		    driver.findElement(By.xpath("(//span[@class='x-tab-strip-text '])[2]")).click();
		    driver.findElement(By.xpath("//span[text()='Find by']/following::input[@name='phoneNumber']")).sendKeys("987456");
		    
		    driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		    Thread.sleep(2000);
		   driver.findElement(By.xpath("//div[text()='Lead ID']/following::a[text()[normalize-space()='10338']]")).click();
		   Thread.sleep(3000);
		    driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']")).click();
		    Thread.sleep(3000);
		   
		    
		    driver.findElement(By.xpath("//a[text()='Leads']")).click();
		    driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//div[contains(@class,'x-panel-header x-panel-header-noborder')]/following::input")).sendKeys("10338");
		    
		    driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		    Thread.sleep(3000);
		    
		    WebElement disabled=driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
			System.out.println( "No Records Found" + disabled.isDisplayed());
			Thread.sleep(2000);
			
			driver.close();

		}

	}
