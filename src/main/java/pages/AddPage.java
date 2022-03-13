package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddPage {

	WebDriverWait wait;

	@FindBy(id = "field-customerName")
	private WebElement costumerName;

	@FindBy(id = "field-contactLastName")
	private WebElement contactLastName;

	@FindBy(id = "field-contactFirstName")
	private WebElement contactFirstName;

	@FindBy(id = "field-phone")
	private WebElement phone;

	@FindBy(id = "field-addressLine1")
	private WebElement addressLine1;

	@FindBy(id = "field-addressLine2")
	private WebElement addressLine2;

	@FindBy(id = "field-city")
	private WebElement city;

	@FindBy(id = "field-state")
	private WebElement state;

	@FindBy(id = "field-postalCode")
	private WebElement postalCode;

	@FindBy(id = "field-country")
	private WebElement country;

	@FindBy(id = "field-salesRepEmployeeNumber")
	private WebElement salesRepEmployeeNumber;

	@FindBy(id = "field-creditLimit")
	private WebElement creditLimit;

	@FindBy(id = "form-button-save")
	private WebElement save;

	@FindBy(id = "report-success")
	private WebElement success;

	@FindBy(linkText = "Go back to list")
	private WebElement goBackToList;

	public AddPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}

	public AddPage setCostumerName(String text) {
		costumerName.sendKeys(text);
		return this;
	}

	public AddPage setContactLastName(String text) {
		contactLastName.sendKeys(text);
		return this;
	}

	public AddPage setContactFirstName(String text) {
		contactFirstName.sendKeys(text);
		return this;
	}

	public AddPage setPhone(String text) {
		phone.sendKeys(text);
		return this;
	}

	public AddPage setAddressLine1(String text) {
		addressLine1.sendKeys(text);
		return this;
	}

	public AddPage setAddressLine2(String text) {
		addressLine2.sendKeys(text);
		return this;
	}

	public AddPage setCity(String text) {
		city.sendKeys(text);
		return this;
	}

	public AddPage setState(String text) {
		state.sendKeys(text);
		return this;
	}

	public AddPage setPostalCode(String text) {
		postalCode.sendKeys(text);
		return this;
	}

	public AddPage setCountry(String text) {
		country.sendKeys(text);
		return this;
	}

	public AddPage setSalesRepEmployeeNumber(String text) {
		salesRepEmployeeNumber.sendKeys(text);
		return this;
	}

	public AddPage setCreditLimit(String text) {
		creditLimit.sendKeys(text);
		return this;
	}

	public AddPage setSave() {
		save.click();
		return this;
	}

	public String getSuccess() {
		wait.until(ExpectedConditions.visibilityOf(success));
		return success.getText();
	}

	public AddPage setGoBackToList() {
		goBackToList.click();
		return this;
	}
}
