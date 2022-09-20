package Marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Type "Chennai" in the FROM text box
		
		driver.findElement(By.id("src")).sendKeys("Chennai");
		driver.findElement(By.xpath("//li[@class='sub-city']")).click();
		
		
		//04) Type "Bangalore" in the TO text box
		driver.findElement(By.id("dest")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//li[@data-id='66008']")).click();
		
		
		//05) Select tomorrow's date in the Date field
        driver.findElement(By.xpath("//span[@class='fl icon-calendar_icon-new icon-onward-calendar icon']")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//td[@class='monthTitle']")).click();
		driver.findElement(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr[4]/td[4]")).click();
		
		
		//06) Click Search Buses
		driver.findElement(By.xpath("//button[@class='fl button']")).click();
		
		//07) Print the number of buses shown as results
		String buses = driver.findElement(By.xpath("//span[text()='found']")).getText();
		System.out.println("Buses " +buses);
		
		//08) Choose SLEEPER in the left menu 
		driver.findElement(By.xpath("//label[@for='bt_SLEEPER']")).click();
		
		//09) Print the name of the second resulting bus 
		String name = driver.findElement(By.xpath("//div[text()='V2K Travels']")).getText();
		System.out.println("Name of the second result " +name);
		
		//10) Click the VIEW SEATS of that bus
		driver.findElement(By.xpath("(//div[text()='View Seats'])[2]")).click();
		Thread.sleep(200);
		
		////Take a screen shot
		File source=driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Image/shot.jpg");
		FileUtils.copyFile(source, dest);

		
		Thread.sleep(200);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
