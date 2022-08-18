package day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafCheckbox {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		   ChromeDriver driver = new ChromeDriver();
		  driver.get("https://www.leafground.com/checkbox.xhtml");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		boolean text=  driver.findElement(By.xpath("//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']")).isSelected();
		System.out.println("Checked Box is " +text);
		
	     WebElement text1 = driver.findElement(By.xpath("//label[@for='j_idt87:basic:0']"));
	    
	    	 text1.click();
	    	 System.out.println("Checkbox is "+text1.isDisplayed());
	     
	     WebElement toggle =driver.findElement(By.xpath("//div[@class='ui-toggleswitch-slider']"));
	     toggle.click();
	     System.out.println("Toggle is on");
	     
	     WebElement disabled=driver.findElement(By.xpath("(//h5[text()='Verify if check box is disabled']//following::div)[5]"));
	     System.out.println("Disabled Button " + disabled.isDisplayed());
	     
	     

	}

}
