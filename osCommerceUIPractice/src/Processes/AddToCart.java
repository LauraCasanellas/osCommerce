package Processes;

import org.openqa.selenium.WebDriver;

import Screens.ShoppingCart;

public class AddToCart {

	private AddToCart() {
		throw new IllegalStateException("Utility class");
	}

	public static void addToCart(WebDriver driver, String quantity) {
		ShoppingCart.clickAddToCartBtn(driver);
		ShoppingCart.setQuantityField(driver, quantity);
		ShoppingCart.updatePriceClickBtn(driver);
	}

}