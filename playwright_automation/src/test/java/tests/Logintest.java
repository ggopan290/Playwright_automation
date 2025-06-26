package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Locator;

import Base.Base_class;
import pages.Loginpage;

public class Logintest extends Base_class {

	@Test
	public void testLoginPageTitle() {
		page.navigate("https://automationteststore.com/");
		System.out.println("Page Title: " + page.title());
		Assertions.assertEquals("A place to practice your automation skills!", page.title());
	}

	@Test
	public void testLoginfunctionality() {
		page.navigate("https://automationteststore.com/");
		// Create the LoginPage object
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
