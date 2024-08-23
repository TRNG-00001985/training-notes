package dto;

public class ProductRequest {
	
	private String name;
	private String skuCode;
	private float price;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public ProductRequest(String name, String skuCode, float price) {
		super();
		this.name = name;
		this.skuCode = skuCode;
		this.price = price;
	}
	@Override
	public String toString() {
		return "ProductRequest [name=" + name + ", skuCode=" + skuCode + ", price=" + price + "]";
	}
	
	

}
