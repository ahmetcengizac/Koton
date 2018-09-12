package sosTest.steps;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import sosTest.run.DriverFactory;

public class Packaging extends DriverFactory {

	@Given("^I login sostestKoton website with correct supplier user$")
	public void i_login_sostestKoton_website_with_correct_supplier_user(DataTable dataTable) throws Throwable {

		List<List<String>> data = dataTable.raw();
		this.getDriver();

		driver.get("http://sostest.koton.com/");
		driver.findElement(By.xpath("//a[@class='button button1']")).click();
		driver.findElement(By.xpath("//input[@name='login']")).sendKeys(data.get(0).get(0));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(data.get(0).get(1));
		;
		driver.findElement(By.xpath("//input[@value='Tamam']")).click();
		// System.out.println("Click OK Button.");
	}

	@When("^I click OrderManagement module in the OrderManagement menu$")
	public void i_click_OrderManagement_module_in_the_OrderManagement_menu() throws Throwable {

		WebElement frme = driver.findElement(By.xpath("//frame[@name='header']"));

		driver.switchTo().frame(frme);
		Actions act = new Actions(driver);

		act.moveToElement(driver.findElement(By.xpath("//div[@id='el1']"))).perform();

		driver.switchTo().defaultContent();

		WebElement frmM = driver.findElement(By.xpath("//frame[@name='main']"));
		driver.switchTo().frame(frmM);

		WebElement myElement = driver.findElement(By.xpath("//div[@id='menu1']"));
		myElement.findElement(By.id("lnk0")).click(); // Order Management
	}

	@When("^I filter order to \"([^\"]*)\"$")
	public void i_select_order_to(String pOrderNumber) throws Throwable {

		driver.switchTo().defaultContent();
		WebElement frmM = driver.findElement(By.xpath("//frame[@name='main']"));
		driver.switchTo().frame(frmM);

		driver.findElement(By.id("orderNumber")).sendKeys(pOrderNumber);

		driver.findElement(By.xpath("//button[@onclick='find();']")).click();
//			driver.findElement(By.xpath("//button[@class='button button-vedi']")).click();
	}

	@When("^I select the order$")
	public void i_select_the_order() throws Throwable {

		WebElement elTable = driver.findElement(By.xpath("//table[@id='table']"));
		elTable.findElement(By.xpath("//td[@class='details-control']")).click();
		elTable.findElement(By.xpath("//input[@name='detailId']")).click();
		driver.findElement(By.xpath("//button[@onclick='startPackaging(true);']")).click();
	}

	@When("^I click Start Packaging button$")
	public void i_click_Start_Packaging_button() throws Throwable {
		String mainwindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[@onclick='partWeightEntry();']")).click();
		Set<String> windows = driver.getWindowHandles();

		for (String s : windows) {
			if (s.equals(mainwindow) == false) {
				driver.switchTo().window(s);
			}
		}

	}

	@When("^I enter Weight of Part$")
	public void i_enter_Weight_of_Part(DataTable dataTable) throws Throwable {
		List<List<String>> data = dataTable.raw();
		Thread.sleep(3000);

		/// WebElement weightForm=driver.findElement(By.name("fOrderWeightInfo"));

		// System.out.println(weightForm.getAttribute("innerHTML"));

		Integer i = 0;
		for (List<String> weight : data) {
			driver.findElement(By.id("0_" + weight.get(0) + "_" + i.toString())).sendKeys(weight.get(1));
			i++;
		}
		Thread.sleep(3000);
	}
	
	@When("^I click submit button$")
	public void i_click_submit_button() throws Throwable {
		String mainwindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[@onclick='fApply();']")).click();
		Set<String> windows = driver.getWindowHandles();

		for (String s : windows) {
			if (s.equals(mainwindow) == false) {
				driver.switchTo().window(s);
			}
		}
	}

	@Then("^The part weight should successfully be submitted via the order weight info form$")
	public void the_part_weight_should_successfully_be_submitted_via_the_order_weight_info_form() throws Throwable {

	}

}
