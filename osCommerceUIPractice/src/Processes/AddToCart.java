package Processes;

import org.openqa.selenium.WebDriver;

import Screens.ShoppingCart;

public class AddToCart {
	
	public static void addToCart(WebDriver driver, String quantity) {
		ShoppingCart.clickAddToCartBtn(driver);
		ShoppingCart.setQuantityField(driver, quantity);
		ShoppingCart.updatePriceClickBtn(driver);
	}

}