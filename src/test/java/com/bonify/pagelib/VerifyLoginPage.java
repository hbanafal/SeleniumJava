package com.bonify.pagelib;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.bonify.genericlib.SolventSelenium;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;

public class VerifyLoginPage {
	
	private LoginPage loginPage = null;
	
	/**
	 * This is the setup method to launch the browser and open Bonify Login page.
	 * Initializing Page Objects 
	 *
	 * @since August 2018
	 * @author pankhurisharma
	 */
	@BeforeMethod
	public void launchBrowser() {
		SolventSelenium.launchBrowser();
		loginPage = new LoginPage();
	}
	
	/**
	 * This is first test to verify the Login Page elements. 
	 *
	 * @since August 2018
	 * @author pankhurisharma
	 */
	@Test
	@Ignore
	public void verifyLoginPageElements() {
		loginPage.verifyLoginPage();
	}
	
	/**
	 * This is test to verify the Successful Login Functionality. 
	 *
	 * @since August 2018
	 * @author pankhurisharma
	 */
	@Test
	@Ignore
	public void verifyLoginWithCorrectCreds() {
		loginPage.enterEmail("pankhuri1110@yahoo.com");
		loginPage.enterPassword("pankhuri@1");
		loginPage.clickOnRegistrationButton();
		loginPage.validateSuccessfulLogin("Pankhuri");
	}
	
	/**
	 * This is test to verify the UnSuccessful Login with incorrect password. 
	 *
	 * @since August 2018
	 * @author pankhurisharma
	 */
	@Test
	@Ignore
	public void verifyLoginWithIncorrectPassword() {
		loginPage.enterEmail("pankhuri1110@yahoo.com");
		loginPage.enterPassword("pankhuri@123");
		loginPage.clickOnRegistrationButton();
		loginPage.validateUnsuccessfulLogin();;
	}
	
	/**
	 * This is test to verify the UnSuccessful Login with incorrect email. 
	 *
	 * @since August 2018
	 * @author pankhurisharma
	 */
	@Test
	@Ignore
	public void verifyLoginWithIncorrectEmail() {
		loginPage.enterEmail("pankhuri11101@yahoo.com");
		loginPage.enterPassword("pankhuri@1");
		loginPage.clickOnRegistrationButton();
		loginPage.validateUnsuccessfulLogin();;
	}
	
	@AfterMethod
	public void tearDown() {
		SolventSelenium.driver.quit();
	}
}