package week2.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lead {

	public static void main(String[] args) {
	WebDriverManager .chromedriver().setup();
	ChromeDriver driver =new ChromeDriver();
	driver.get("http://leaftaps.com/opentaps/control/main");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	driver.findElement(By.id("username")).sendKeys("demosalesmanager");
	driver.findElement(By.id("password")).sendKeys("crmsfa");
	driver.findElement(By.className("decorativeSubmit")).click();
	driver.findElement(By.linkText("CRM/SFA")).click();
	driver.findElement(By.linkText("Leads")).click();
	driver.findElement(By.linkText("Create Lead")).click();
	driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");
	driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Lalitha");
	driver.findElement(By.id("createLeadForm_lastName")).sendKeys("M");
	driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Lali");
	driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("C.Sc");
	driver.findElement(By.id("createLeadForm_description")).sendKeys("Hi I am Lalitha");
	driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("mvlalitha89@gmail.com");
	driver.findElement(By.className("smallSubmit")).click();
	String title=driver.getTitle();
	System.out.println(title);
	
	
	
		
	
	
	

	}

}
