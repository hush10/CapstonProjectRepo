package tek.sdet.framework.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class RetailHomeSteps extends CommonUtility{
	POMFactory factory = new POMFactory();
	
	
	 @When ("User click on All section")
	 
	 public void userClickOnAllSection() {
		 click(factory.homePage().allElements);
		 logger.info("User click on All section link");
	 }
	   
	 @And ("User on {string}")
	 public void userOnDepartment(String department) {
		 List <WebElement> dept = factory.homePage().sideBar;
		 
		 for (WebElement element:dept) {
			 if(element.getText().equals(department)) {
				 element.click();
			 }
		 }
	 }
	  
	 @Then ("below options are present in department")
	 public void belowOptionsArePresentInDepartment(DataTable dataTable) {
		 List<List<String>> departementSection = dataTable.asLists(String.class);
		 List<WebElement> dept = factory.homePage().sideBar;
		 
		 for (int i= 0; i < departementSection.get(0).size(); i++) {
			 for (WebElement element:dept) {
				 if(element.getText().equals(departementSection.get(0).get(i))) {
					 Assert.assertTrue(element.isDisplayed());
					 logger.info(element.getTagName()+"The idem is present");
					 
				 }
				 
			 }
				 
				 
			 
			 
		 }
		 
	 }
	
	

}
