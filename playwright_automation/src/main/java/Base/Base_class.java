package Base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Base_class {

	protected static Playwright playwright;
	protected static Browser browser;
	protected Page page;

	@BeforeAll
	static void setupAll() {
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	}

	@BeforeEach
	void setup() {
		page = browser.newPage();
	}

	@AfterEach
	void tearDown() {
		page.close();
	}

	@AfterAll
	static void tearDownAll() {
		browser.close();
		playwright.close();
		System.out.println("Teardown complete.");
	}
}
