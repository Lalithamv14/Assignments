package assig.week4day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		
		driver.findElement(By.xpath("//input[@class='db']")).sendKeys("Madiwala Bangalore",Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys(" Koyambedu Chennai",Keys.ENTER);
		driver.findElement(By.xpath("//span[@class='fl icon-calendar_icon-new icon-onward-calendar icon']")).click();
		
		Thread.sleep(200);
		
		driver.findElement(By.xpath("//td[@class='next']")).click();
		driver.findElement(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr[7]/td[5]")).click();
		Thread.sleep(20);
		
		
		String title=driver.getTitle();
		System.out.println(title);

	}

}
