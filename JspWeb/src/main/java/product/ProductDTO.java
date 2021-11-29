package product;

public class ProductDTO {
	private int productId;
	private String productName;
	private int companyId;
	private int price;
	private int soldCount;
	private String detail;
	private String imgUrl_1;
	
	public ProductDTO() {
	}
	
	public ProductDTO(int productId, String productName, int companyId, int price, int soldCount,
			String detail, String imgUrl_1) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.companyId = companyId;
		this.price = price;
		this.soldCount = soldCount;
		this.detail = detail;
		this.imgUrl_1 = imgUrl_1;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSoldCount() {
		return soldCount;
	}

	public void setSoldCount(int soldCount) {
		this.soldCount = soldCount;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getImgUrl_1() {
		return imgUrl_1;
	}

	public void setImgUrl_1(String imgUrl_1) {
		this.imgUrl_1 = imgUrl_1;
	}
}
