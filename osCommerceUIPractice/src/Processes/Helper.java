package processes;

public class Helper {
	
	private Helper() {
		throw new IllegalStateException("Utility class");
	}
	
	public static double getPriceAsDouble(String price) {
		price = price.replace("$", "").replace(",", "");
		return Double.valueOf(price);
	}

}
