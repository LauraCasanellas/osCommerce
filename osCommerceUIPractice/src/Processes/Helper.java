package Processes;

public class Helper {
	
	public static double getPriceAsDouble(String price) {
		price = price.replace("$", "").replace(",", "");
		return Double.valueOf(price);
	}

}
