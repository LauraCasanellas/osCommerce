package TestCases;

import org.junit.*;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import Products.Product;

public class TestCase1{

	private static WebDriver driver;
	private static ChromeDriverService service;

	Product galaxyTabProduct;
	String emailAddress;
	String password;

	public static void createAndStartService() throws IOException {
		service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File("chromedriver"))
				.usingAnyFreePort()
				.build();
		service.start();
	}

	public static void createDriver() {
		driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());	  
	}

	public static void quitDriver() {
		driver.quit();
	}

	@Before
	public void setUp() throws IOException {
		createAndStartService();
		createDriver();
		driver.manage().window().maximize();
		galaxyTabProduct = new Product("Samsung Galaxy Tab", 2);
		emailAddress = "lauracasanellas46@mailinator.com";
		password = "Test123@";

	}

	@After
	public void tearDown() {
		quitDriver();
	}

	@Test
	public void test1() {
		Helper.buyProduct(driver, galaxyTabProduct, emailAddress, password);
	}
}



