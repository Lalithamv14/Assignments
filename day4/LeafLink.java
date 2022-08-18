package day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafLink {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://www.leafground.com/link.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		
		System.out.println("The URL is "+ driver.getCurrentUrl());
		
		int numberOfLinks = driver.findElements(By.tagName("a")).size();
        // count no of links on page
        System.out.println("Number of links on Web Page :" +numberOfLinks );
		
		driver.findElement(By.xpath("//a[@class='ui-link ui-widget']")).click();;
		System.out.println("The title is" + driver.getTitle());
		Thread.sleep(3000);
		driver.close();


	}

}
