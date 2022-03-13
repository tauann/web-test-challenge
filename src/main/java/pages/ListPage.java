package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListPage {

	WebDriverWait wait;

	@FindBy(id = "switch-version-select")
	private WebElement switchTheme;

	@FindBy(partialLinkText = "Add Record")
	private WebElement addRecord;

	@FindBy(css = "input[name='customerName']")
	private WebElement searchCustomerName;

	@FindBy(css = "i[class='fa fa-times el el-remove clear-search']")
	private WebElement clearSearch;

	@FindBy(className = "select-all-none")
	private WebElement actionsRadioAll;

	@FindBy(linkText = "Delete")
	private WebElement delete;

	@FindBy(className = "modal-content")
	private WebElement deleteAlert;

	@FindBy(className = "alert-delete-multiple-one")
	private WebElement deleteAlertMessage;

	@FindBy(xpath = "//*[@class='btn btn-danger delete-multiple-confirmation-button']")
	private WebElement deleteDelete;
	
	@FindBy(xpath = "//span[@data-growl='message']")
	private WebElement message;
	
	public ListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}

	public ListPage setSwitchTheme(String option) {
		new Select(switchTheme).selectByVisibleText(option);
		return this;
	}

	public ListPage setAddRecord() {
		addRecord.click();
		return this;
	}

	public ListPage setSearchCustomerName(String text) {
		searchCustomerName.sendKeys(text);
		wait.until(ExpectedConditions.elementToBeClickable(clearSearch));
		return this;
	}

	public ListPage setActionsRadioAll() {
		actionsRadioAll.click();
		return this;
	}

	public ListPage setDelete() {
		delete.click();
		return this;
	}

	public String getDeleteAlertMessage() {
		wait.until(ExpectedConditions.visibilityOf(deleteAlertMessage));
		return deleteAlertMessage.getText();
	}

	public ListPage setDeleteDelete() {
		deleteDelete.click();
		return this;
	}
	
	public String getMessage() {
		wait.until(ExpectedConditions.visibilityOf(message));
		return message.getText();
	}
}
