package day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafButton {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager. chromedriver().setup();
	    ChromeDriver driver=new ChromeDriver();
	    driver.get("https://www.leafground.com/button.xhtml");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
       
        WebElement disabled = driver.findElement(By.xpath("//h5[text()='Confirm if the button is disabled.']/parent::div"));
        System.out.println("The Button is Disabled"+ disabled.isDisplayed());
     
        
       String color = driver.findElement(By.xpath("(//h5[text()='Find the Save button color']/following::span)[2]")).getCssValue("background");
	
	System.out.println(color);
	
	org.openqa.selenium.Dimension size=driver.findElement(By.xpath("//h5[text()='Find the height and width of this button']//following::button")).getSize();
	System.out.println("The height and width is"+size);
	boolean color1=driver.findElement(By.xpath("//h5[text()='Mouse over and confirm the color changed']/following::span")).getCssValue("background-color") != null;
	System.out.println("The Color gets changed"+ color1);
	
	 driver.findElement(By.xpath("//span[@class='ui-button-text ui-c']//preceding::button")).click();
      String title=driver.getTitle();
       System.out.println(title);
      

	}

}
