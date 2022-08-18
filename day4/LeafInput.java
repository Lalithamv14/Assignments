package day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafInput {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://www.leafground.com/input.xhtml;jsessionid=node0tmb2389go0xlxjvuy66xu9p668024.node0");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		
		String text= driver.findElement(By.xpath("//input[@class='ui-inputfield ui-inputtext ui-widget ui-state-default ui-corner-all']")).getAttribute("placeholder");
System.out.println("Name is " + text);
       
        String text1=driver.findElement(By.xpath("//input[@class='ui-inputfield ui-inputtext ui-widget ui-state-default ui-corner-all city ui-state-filled']")).getAttribute("value");
System.out.println("City" + text1);
       
        WebElement text2=driver.findElement(By.xpath("//input[@class='ui-inputfield ui-inputtext ui-widget ui-state-default ui-corner-all ui-state-disabled']"));
System.out.println("The Text box is Disabled"  +   text2.isDisplayed());
      
     WebElement c=  driver.findElement(By.name("j_idt88:j_idt95"));

     System.out.println("Value before clear : " + c.getAttribute("value"));

     c.clear();
       System.out.println("Value after clear : " + c.getAttribute("value"));

       
    String  retrieved= driver.findElement(By.xpath("//h5[text()='Retrieve the typed text.']/following::input")).getAttribute("value");
System.out.println("Retrieved text is " + retrieved);

     WebElement email=  driver.findElement(By.xpath("//h5[text()='Type email and Tab. Confirm control moved to next element.']//following::input"));
       email.sendKeys("mvlalitha");
       System.out.println("Entered email is " + email.getAttribute("value"));
       
       Thread.sleep(2000);
       
       driver.close();
	}

	}


