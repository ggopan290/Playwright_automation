package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {

	protected static Playwright playwright;
	protected static Browser browser;
	protected BrowserContext context;
	protected Page page;

	Properties prop;

	@BeforeTest
	public Page initBrowser(Properties prop) {
		String browserName = prop.getProperty("browser");
		System.out.println("Browser name is :" + browserName);
		playwright = Playwright.create();
		switch (browserName.toLowerCase()) {
		case "chromium":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "firefox":
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "safari":
			browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "chrome":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		default:
			System.out.println("Please pss the right browser name....");
			break;

		}

		context = browser.newContext();
		page = context.newPage();
		page.navigate(prop.getProperty("url").trim());

		return page;

	}

	/**
	 * this method is used to initialize the properties from config file
	 * 
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public Properties init_prop() {

		try {
			FileInputStream ip = new FileInputStream("./src/test/resourcess/config/config.properties");
			prop = new Properties();
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

}
