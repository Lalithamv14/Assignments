package Marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookmyShow {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://in.bookmyshow.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//03) Type the city as "Hyderabad" in Select City
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hyderabad");
		driver.findElement(By.xpath("//li[@class='sc-dTLGrV eqBsHh']")).click();
		
//04) Confirm the URL has got loaded with Hyderabad 
	System.out.println("The current URL : "  +	driver.getCurrentUrl());
	
	//05) Search for your favorite movie 
	driver.findElement(By.xpath("//img[@alt='Oke Oka Jeevitham']")).click();
	
	//06) Click Book Tickets
	driver.findElement(By.xpath("//div[@class='sc-1vmod7e-2 iBonLL']")).click();
		
	//07) Print the name of the theater displayed first
	String theater = driver.findElement(By.xpath("//a[@class='__venue-name']")).getText();
	System.out.println("Name of the theater first :" +theater);
	driver.findElement(By.xpath("//button[contains(@class,'Sign me')]")).click();
	
	//08) Click on the info of the theater
	driver.findElement(By.xpath("//div[text()='INFO']")).click();
	
	//09) Confirm if there is a parking facility in the theater
	String parking=driver.findElement(By.xpath("//div[@class='venue-facility-item']")).getText();
	System.out.println(parking);
	 boolean parking1=driver.findElement(By.xpath("//div[@class='venue-facility-item']")).isEnabled();
	System.out.println("Availability of parking : " +parking1);
	Thread.sleep(200);
	
	//10) Close the theater popup
	driver.findElement(By.xpath("//div[@class='cross-container']")).click();
	
	//11) Click on the first green (available) timing
	driver.findElement(By.xpath("(//div[@class='__text'])[3]")).click();
	
	// Choose 1 Seat and Click Select Seats
	driver.findElement(By.id("pop_1")).click();
	driver.findElement(By.id("proceed-Qty")).click();
	
	//14) Choose any available ticket and Click Pay
	driver.findElement(By.xpath("//table[@class='setmain']/tbody[1]/tr[7]/td[2]/div[11]/a[1]")).click();
	driver.findElement(By.xpath("//a[@id='btmcntbook']")).click();
	Thread.sleep(5000);
	
	//15) Print the sub total
	String subtotal=driver.findElement(By.xpath("//span[@id='subTT']")).getText();
	System.out.println("Subtotal " +subtotal);
	Thread.sleep(5000);
	
	//16) Take screenshot and close browser
	File source=driver.getScreenshotAs(OutputType.FILE);
	File dest=new File("./Image/shot.jpg");
	FileUtils.copyFile(source, dest);

	Thread.sleep(200);
	
	
	}

}
