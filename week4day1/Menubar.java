package assig.week4day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Menubar {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/menu.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		
		Actions act=new Actions(driver);
		
		driver.findElement(By.xpath("(//a[@class='ui-menuitem-link ui-submenu-link ui-corner-all'])[4]")).click();
		

		WebElement track=driver.findElement(By.xpath("//span[text()='Tracker']"));
		act.moveToElement(track).perform();
	
		
	WebElement right=driver.findElement(By.xpath("//span[text()='Tracker']"));
		act.contextClick(right).perform();
		
		
	WebElement order=driver.findElement(By.xpath("(//a[contains(@class,'ui-menuitem-link ui-submenu-link ui-corner-all')])[last()]"));
	act.click(order).perform();

	
	driver.findElement(By.xpath("//div[text()='Back']")).click();
	
	
	

	}

}
