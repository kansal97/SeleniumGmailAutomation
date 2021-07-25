package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

public class GmailLoginPage {
	WebDriver driver;
	By gmailUserName = By.xpath("//input[@id='identifierId']");
	By gmailUserNameNextButton = By.xpath("//div[@id='identifierNext']");

	By gmailPassword = By.xpath("//input[@name='password']");
	By gmailPasswordNextButton = By.xpath("//div[@id='passwordNext']");

	public GmailLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Set user name in textbox
	private void setUserName(String strUserName) {
		driver.findElement(gmailUserName).sendKeys(strUserName);
	}

	// Click Next button after entering username
	private void clickUserNameNextButton() {
		driver.findElement(gmailUserNameNextButton).click();
	}

	// Set password in password textbox
	private void setPassword(String strPassword) {
		WebElement passwordInput = driver.findElement(gmailPassword);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
		passwordInput.sendKeys(strPassword);
	}

	// Click Next button after entering password
	private void clickPasswordNextButtonToLogin() {
		driver.findElement(gmailPasswordNextButton).click();
	}

	public void loginToGmail(String userName, String password) {

		// Fill user name
		setUserName(userName);
		//Click Next
		clickUserNameNextButton();

		// Fill password
		setPassword(password);
		//Click Next to login
		clickPasswordNextButtonToLogin();

	}
}
