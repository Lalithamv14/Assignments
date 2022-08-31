package assig.week4day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
        driver.get("http://leaftaps.com/opentaps/control/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
        
        driver.findElement(By.id("username")).sendKeys("demosalesmanager");
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        driver.findElement(By.className("decorativeSubmit")).click();
        driver.findElement(By.linkText("CRM/SFA")).click();
        driver.findElement(By.linkText("Contacts")).click();
        driver.findElement(By.linkText("Merge Contacts")).click();
        
        driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
        Set<String>whandles=driver.getWindowHandles();
        List<String>swi=new ArrayList<String>(whandles);
        driver.switchTo().window(swi.get(1));
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@class='linktext']")).click();
        driver.switchTo().window(swi.get(0));
        driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
        Set<String>whandles1=driver.getWindowHandles();
        List<String>swi1=new ArrayList<String>(whandles1);
        driver.switchTo().window(swi1.get(1));
       driver.manage().window().maximize();
       driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();
       driver.switchTo().window(swi1.get(0));
       
       driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
       driver.switchTo().alert().accept();   
       
       String title=driver.getTitle();
       System.out.println(title);
       driver.close();
        
	}

}
