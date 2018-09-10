package sosTest.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sosTest.run.DriverFactory;

public class Packaging extends DriverFactory {

		@Given("^I login sostestKoton website with correct supplier user$")
		public void i_login_sostestKoton_website_with_correct_supplier_user(DataTable dataTable) throws Throwable {
			
			List<List<String>> data = dataTable.raw();
			this.getDriver();
			
			driver.get("http://sostest.koton.com/");
			driver.findElement(By.xpath("//a[@class='button button1']")).click();
			driver.findElement(By.xpath("//input[@name='login']")).sendKeys(data.get(0).get(0));
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(data.get(0).get(1));;
			driver.findElement(By.xpath("//input[@value='Tamam']")).click();
			System.out.println("Click OK Button.");
		}

		@When("^I click OrderManagement module in the OrderManagement menu$")
		public void i_click_OrderManagement_module_in_the_OrderManagement_menu() throws Throwable {

			WebElement frme = driver.findElement(By.xpath("//frame[@name='header']"));

			driver.switchTo().frame(frme);
			Actions act =new Actions(driver);

			act.moveToElement(driver.findElement(By.xpath("//div[@id='el1']"))).perform();

			driver.switchTo().defaultContent();
			
			WebElement frmM = driver.findElement(By.xpath("//frame[@name='main']"));
			driver.switchTo().frame(frmM);

			WebElement myElement = driver.findElement(By.xpath("//div[@id='menu1']"));		
			myElement.findElement(By.id("lnk0")).click(); //Order Management
		}

		@When("^I navigate OrderManagement page$")
		public void i_navigate_OrderManagement_page() throws Throwable {
			driver.switchTo().defaultContent();
			WebElement frmM = driver.findElement(By.xpath("//frame[@name='main']"));
			driver.switchTo().frame(frmM);
			
			WebElement elTable = driver.findElement(By.xpath("//table[@id='table']"));			
			elTable.findElement(By.cssSelector("#detailRow_788 > td:nth-child(2)")).click();
			
			//System.out.println( elTable.getAttribute("innerHTML"));
			
			
			//myElement.findElement(By.id("lnk0")).click(); //Order Management			
		}

		@When("^I select a job order$")
		public void i_select_a_job_order() throws Throwable {
			WebElement elTable = driver.findElement(By.xpath("//table[@id='table']"));	
			elTable.findElement(By.xpath("//input[@id='788']")).click();
		}

		@When("^I click Start Packaging button$")
		public void i_click_Start_Packaging_button() throws Throwable {
			WebElement elButtondiv = driver.findElement(By.className("button-grp-wrp"));	
			System.out.println( elButtondiv.getAttribute("innerHTML"));
			
			
			//elButtondiv.findElement(By.className("button button-vedi success")).click();	
		}
		

		@When("^I click Part Weight Entry button$")
		public void i_click_Part_Weight_Entry_button() throws Throwable {
			driver.findElement(By.className("button button-vedi warning")).click();
		}

		@When("^I navigate Order Weight Info page$")
		public void i_navigate_Order_Weight_Info_page() throws Throwable {
			
			/*String winHandlerBefore = driver.getWindowHandle();
			
			for(String winHandler: driver.getWindowHandles()) {
				driver.switchTo().window(winHandler);
			}
			
			driver.findElement(By.id("text")).sendKeys("webdriver");*/
		    
		}

		@When("^I enter weight unit type gram$")
		public void i_enter_weight_unit_type_gram() throws Throwable {
		  
		}

		@When("^I click submit button$")
		public void i_click_submit_button() throws Throwable {
		    
		}

		@Then("^The part weight should successfully be submitted via the order weight info form$")
		public void the_part_weight_should_successfully_be_submitted_via_the_order_weight_info_form() throws Throwable {
		   
		}

	}


