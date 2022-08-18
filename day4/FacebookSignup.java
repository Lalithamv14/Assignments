package day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookSignup {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.findElement(By.xpath("//a[contains(text(),'Create New Account')]")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Lalitha");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("M");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9999999999");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("password");
		//dropdown
		WebElement bday = driver.findElement(By.id("day"));
		Select option=new Select(bday);
		option.selectByIndex(2);
		
		WebElement bmonth =driver.findElement(By.id("month"));
		Select option1=new Select(bmonth);
		option1.selectByValue("7");
		
		WebElement byear=driver.findElement(By.id("year"));
		Select option2=new Select(byear);
		option2.selectByVisibleText("2002");
		
	
		driver.findElement(By.xpath("(//input[@name='sex'])[1]")).click();
		
		Thread.sleep(5000);
		driver.close();
		

	}


}
