package week.week6day2;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CreateLead extends CommonClass1{

		@Test//mandatory step to execute the Testcase
		public void runCreat() {
			
			driver.findElement(By.linkText("Create Lead")).click();
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Hari");
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys("R");
			driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("99");
			driver.findElement(By.name("submitButton")).click();
}
}
