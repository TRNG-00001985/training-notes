package entity;

public class Product {
	
	private long id;
	private String name;
	private String skuCode;
	private double price;
	
	
	public Product(long id, String name, String skuCode, float price) {
		super();
		this.id = id;
		this.name = name;
		this.skuCode = skuCode;
		this.price = price;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSkuCode() {
		return skuCode;
	}
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

}
