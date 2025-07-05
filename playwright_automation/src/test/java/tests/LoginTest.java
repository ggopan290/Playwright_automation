package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;

import Constants.AppConstants;
import baseTest.BaseTestclass;
import pages.Loginpage;

public class LoginTest extends BaseTestclass {

	@Test
	public void testLoginPageTitle() {
		String actualTitle = loginPage.getLoginpageTitle();
		Assert.assertEquals(AppConstants.TITLE, actualTitle);
	}

	@Test
	public void testLoginfunctionality() {

		Loginpage loginPage = new Loginpage(page);

		// Actions
		loginPage.goToLoginPage();
		loginPage.login("testmnop", "testmnop");

		Locator accountWelcome = page.getByText("Welcome back Test123");
		{
			if (accountWelcome.isVisible()) {
				System.out.println("✅ Login successful. Welcome message: " + accountWelcome.textContent());
			} else {
				System.out.println("❌ Login failed.");
			}
		}
	}
}
