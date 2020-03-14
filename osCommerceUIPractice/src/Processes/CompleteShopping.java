package processes;

import org.openqa.selenium.WebDriver;

import screens.CheckoutPayment;
import screens.Login;
import screens.ShoppingCart;

public class CompleteShopping {

	private CompleteShopping() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Process to complete the shopping.
	 * @param driver WebDriver used to browse the web.
	 * @param emailAddress User email address who complete the shopping.
	 * @param pw User password from who complete the shopping.
	 */
	public static void completeShopping(WebDriver driver, String emailAddress, String pw) {
		ShoppingCart.clickCheckoutBtn(driver);
		Login.writeCredentials(driver, emailAddress, pw);
		Login.signInClickBtn(driver);
		Login.continueClickBtn(driver);
		CheckoutPayment.selectCashOnDeliveryOption(driver);
		CheckoutPayment.continueClickBtn(driver);
		CheckoutPayment.payNowClickBtn(driver);
	}

	public static String getLastMessage(WebDriver driver) {
		return CheckoutPayment.getSucessMsg(driver);
	}

}
