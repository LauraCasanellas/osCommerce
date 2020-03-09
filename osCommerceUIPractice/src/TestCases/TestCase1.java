package TestCases;

import org.junit.*;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import Processes.AddToCart;
import Processes.CompleteShopping;
import Products.Product;
import Screens.*;

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
	public void setUp() throws Exception {
		createAndStartService();
		createDriver();
		driver.manage().window().maximize();
		galaxyTabProduct = new Product("Samsung Galaxy Tab", 2);
		emailAddress = "lauracasanellas46@mailinator.com";
		password = "Test123@";

	}

	@After
	public void tearDown() throws Exception {
		quitDriver();
	}

	@Test
	public void test1() {
		driver.get("https://demo.oscommerce.com/");
		SelectProduct.selectProduct(driver, galaxyTabProduct.getProductName());
		
		galaxyTabProduct.setUnitPrice(SelectProduct.getUnitaryPrice(driver));
		//add the items to cart
		AddToCart.addToCart(driver, String.valueOf(galaxyTabProduct.getQuantity()));
		
		//check total price
		Double totalPrice = ShoppingCart.getTotalPrice(driver);
		assertEquals(galaxyTabProduct.getTotalPrice(), totalPrice);
		
		//check total items
		int productItems = ShoppingCart.getItemsForProduct(driver);
		assertEquals(galaxyTabProduct.getQuantity(), productItems);
		
		//complete shopping
		CompleteShopping.completeShopping(driver, emailAddress, password);
		
		//check last message
		String lastMsg = CompleteShopping.getLastMessage(driver);
		assertEquals("Your Order Has Been Processed!", lastMsg);
	}
}



