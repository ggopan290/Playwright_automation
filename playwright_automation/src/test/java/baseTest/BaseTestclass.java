package baseTest;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;

import Base.PlaywrightFactory;
import pages.Loginpage;

public class BaseTestclass {
	
	PlaywrightFactory pf;
	
	protected static Page page;
	Properties prop;
	
	protected Loginpage loginPage;

	@BeforeTest
	public void setup() {
		pf= new PlaywrightFactory(); // creating object of base_class
		prop= pf.init_prop();
		page = pf.initBrowser(prop); // calling initializing browser()
		loginPage = new Loginpage(page); // creating object of loginpage class
	}
	
	@AfterTest
	public static void tearDownAll() {
		try {
			try {
				page.context().browser().close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Teardown complete.");
	}


	
	
	
	
	
	
	
	
	
}
