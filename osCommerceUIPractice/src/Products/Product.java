package products;

public class Product {
	private String productName;
	private Double unitPrice;
	private Integer quantity;
	
	public Product(String name) {
		productName = name;
		unitPrice = 0.0;
		quantity = 1;
	}
	
	public Product(String name, Integer quantity) {
		productName = name;
		this.quantity = quantity;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public Double getTotalPrice() {
		return unitPrice * quantity;
	}
	
	public void setUnitPrice(double price) {
		unitPrice = price;
	}

}
