package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Loginpage {

	private Page page;

	// Locators

	private Locator loginLink;
	private Locator usernameInput;
	private Locator passwordInput;
	private Locator loginButton;

	// Constructor
	public Loginpage(Page page) {
		this.page = page;

		// Initialize locators
		loginLink = page.locator("a:has-text(\"Login or register\")");
        usernameInput = page.locator("input[name='loginname']");
		passwordInput = page.locator("input[name='password']");
		loginButton = page.locator("button[title='Login']");

	}

	// Navigate to login page
	public void goToLoginPage() {
		loginLink.click();
	}

	// Perform Login
	public void login(String username, String password) {
		usernameInput.fill(username);
		passwordInput.fill(password);
		loginButton.click();

	}
}
