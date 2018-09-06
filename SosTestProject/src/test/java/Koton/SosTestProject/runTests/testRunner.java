package Koton.SosTestProject.runTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Koton.SosTestProject.runTests.DriverFactory;

public class testRunner {

	public static void main(String[] args) {
		
		DriverFactory driverFactory = new DriverFactory();
		WebDriver  driver =   driverFactory.getDriver();
		
		driver.get("http://sostest.koton.com");
		driver.findElement(By.xpath("//a[@class='button button1']")).click();

		//driver.findElement(By.xpath(""))
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.close();
		driver.quit();
		System.out.println("OK");
		
	}

}

