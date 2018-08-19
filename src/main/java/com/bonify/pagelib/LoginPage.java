package com.bonify.pagelib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.bonify.genericlib.SolventSelenium;


/**
 * This is the Page Object class for Login Page of Bonify.de
 * 
 * @author pankhurisharma
 *
 */
public class LoginPage extends SolventSelenium {

	@FindBy(name = "email")
	public WebElement emailTextBox;

	@FindBy(name = "password")
	public WebElement passwordTextBox;

	@FindBy(xpath = "//div[@class='login-panel']/h1")
	public WebElement welcomeText;

	@FindBy(className = "ico-logo-bonify")
	public WebElement bonifyLogo;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement registrationButton;

	@FindBy(linkText = "/register/email")
	public WebElement registerButton;

	@FindBy(xpath = "//a[@href='/recover']")
	public WebElement forgotPasswordLink;

	@FindBy(xpath = "//footer[@class='security-logos paper']")
	public WebElement securityLogos;

	@FindBy(xpath = "//a[@href='http://bonify.de/impressum']")
	public WebElement conditionsLink;

	@FindBy(xpath = "//a[@href='http://bonify.de/agb']")
	public WebElement imprintLink;

	@FindBy(xpath = "//a[@href='http://bonify.de/datenschutz']")
	public WebElement dataProtectionLink;

	@FindBy(xpath = "//div[@class='message']")
	public WebElement successfulLoginMessage;

	@FindBy(xpath = "//p[@class='general-error']")
	public WebElement failureLoginMessage;

	/**
	 * Initializing Page Factory elements in the constructor 
	 *
	 * @since August 2018
	 * @author pankhurisharma
	 */
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to enter the email in email text box
	 *
	 * @since August 2018
	 * @author pankhurisharma
	 */
	public void enterEmail(String email) {
		emailTextBox.sendKeys(email);
	}

	/**
	 * This method is used to enter the password in password text box
	 *
	 * @since August 2018
	 * @author pankhurisharma
	 */
	public void enterPassword(String password) {
		passwordTextBox.sendKeys(password);
	}

	/**
	 * This method is used to click on Registration Button
	 *
	 * @since August 2018
	 * @author pankhurisharma
	 */
	public void clickOnRegistrationButton() {
		registrationButton.click();
	}

	/**
	 * This method is used to click on Registration Button
	 *
	 * @since August 2018
	 * @author pankhurisharma
	 */
	public void clickOnRegisterButton() {
		registerButton.click();
	}

	/**
	 * This method is used to verify elements of Login Page
	 *
	 * @since August 2018
	 * @author pankhurisharma
	 */
	public void verifyLoginPage() {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(bonifyLogo.isDisplayed(), "Bonify logo is not displayed on the login page");
		softAssert.assertTrue(welcomeText.getText().equals("Willkommen bei bonify!"), "Welcome Text is not displayed on the login page");
		softAssert.assertTrue(forgotPasswordLink.isDisplayed(), "Forgot Password link is not displayed on the login page");
		softAssert.assertTrue(imprintLink.isDisplayed(), "Imprint Link is not displayed on the login page");
		softAssert.assertTrue(conditionsLink.isDisplayed(), "Conditions Link is not displayed on the login page");
		softAssert.assertTrue(dataProtectionLink.isDisplayed(), "Data Protection Link is not displayed on the login page");
		softAssert.assertTrue(securityLogos.isDisplayed(), "Bonify logo is not displayed on the login page");
		softAssert.assertAll();
	}

	/**
	 * This method is used to verify successful Login Message
	 *
	 * @since August 2018
	 * @author pankhurisharma
	 */
	public void validateSuccessfulLogin(String name) {
		successfulLoginMessage.getText().equals("Hey " + name + ", schön Dich zu sehen!");
	}

	/**
	 * This method is used to verify unsuccessful Login Message
	 *
	 * @since August 2018
	 * @author pankhurisharma
	 */
	public void validateUnsuccessfulLogin() {
		failureLoginMessage.getText().equals("Leider passen Benutzername und Passwort nicht zusammen.");
	}
}