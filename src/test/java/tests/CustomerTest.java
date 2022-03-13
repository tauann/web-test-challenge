package tests;

import static core.CoreDriver.getDriver;
import static core.CoreDriver.tearDown;

import java.util.Random;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pages.AddPage;
import pages.ListPage;

public class CustomerTest {

	ListPage list = new ListPage(getDriver());
	AddPage add = new AddPage(getDriver());

	@Before
	public void navigate() {
		getDriver().get("https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap");
	}
	
	@After
	public void kill() {
		tearDown();
	}

	@Test
	public void challengeOneTest() {
		addCustomer();
	}

	@Test
	public void challengeTwoTest() {
		String name = addCustomer();

		add.setGoBackToList();
		list
			.setSearchCustomerName(name)
			.setActionsRadioAll()
			.setDelete();
		Assert.assertEquals("Are you sure that you want to delete this 1 item?", list.getDeleteAlertMessage());
		list.setDeleteDelete();
		Assert.assertEquals("Your data has been successfully deleted from the database.", list.getMessage());
	}

	private String addCustomer() {
		String name = "Teste Sicredi " + new Random().nextInt(100); 
		
		list
			.setSwitchTheme("Bootstrap V4 Theme")
			.setAddRecord();
		add
			.setCostumerName(name)
			.setContactLastName("Teste")
			.setContactFirstName("Tauan")
			.setPhone("51 9999-9999")
			.setAddressLine1("Av Assis Brasil, 3970")
			.setAddressLine2("Torre D")
			.setCity("Porto Alegre")
			.setState("RS")
			.setPostalCode("91000-000")
			.setCountry("Brasil")
			.setSalesRepEmployeeNumber("Fixter")
			.setCreditLimit("200")
			.setSave();
		Assert.assertEquals("Your data has been successfully stored into the database. Edit Record or Go back to list", add.getSuccess());
		return name;
	}
}
