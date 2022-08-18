package day4;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

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
	    driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("a");
	    driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	    driver.navigate().refresh();
	    
	    driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a")).click();
	    String title=driver.getTitle();
	    System.out.println(title);
	    driver.findElement(By.xpath("//a[@class='subMenuButton']//following-sibling::a[2]")).click();
	    String title1=driver.getTitle();
	    System.out.println(title1);
	    
	    driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
	    driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys("xyz");
	    boolean update=driver.findElement(By.xpath("//input[@class='smallSubmit']")) != null;
	 
	    if(update==true) {
	    System.out.println("Company Name is changed");
	    }
	    else
	    {
	    	System.out.println("not change");
	    }
	    
	    driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
	    Thread.sleep(2000);
	    driver.close();
		}

	}



