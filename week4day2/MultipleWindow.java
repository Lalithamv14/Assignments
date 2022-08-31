package assig.week4day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindow {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/window.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		Set<String>whandle=driver.getWindowHandles();
		int size=whandle.size();
		System.out.println("The Size of available Window :" + size);
	
		List<String>swi=new ArrayList<String>(whandle);
		driver.switchTo().window(swi.get(2));
		String title=driver.getTitle();
		System.out.println(title);
		
		driver.switchTo().window(swi.get(1));
		driver.close();
		
		driver.switchTo().window(swi.get(0));
		driver.close();
		
		
		
		

	}

}
