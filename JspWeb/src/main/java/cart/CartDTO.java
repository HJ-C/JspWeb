package cart;

public class CartDTO {
	private int cartId;
	private String cartImg;
	private String cartName;
	private int cartPrice;
	private int cartCount;
	private int cartSum;

	public CartDTO() {
		
	}
	
	public CartDTO(int cartId, String cartImg, String cartName, int cartPrice, int cartCount, int cartSum) {
		super();
		this.cartId = cartId;
		this.cartImg = cartImg;
		this.cartName = cartName;
		this.cartPrice = cartPrice;
		this.cartCount = cartCount;
		this.cartSum = cartSum;
	}
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getCartImg() {
		return cartImg;
	}
	public void setCartImg(String cartImg) {
		this.cartImg = cartImg;
	}
	public String getCartName() {
		return cartName;
	}
	public void setCartName(String cartName) {
		this.cartName = cartName;
	}
	public int getCartPrice() {
		return cartPrice;
	}
	public void setCartPrice(int cartPrice) {
		this.cartPrice = cartPrice;
	}
	public int getCartCount() {
		return cartCount;
	}
	public void setCartCount(int cartCount) {
		this.cartCount = cartCount;
	}
	public int getCartSum() {
		return cartSum;
	}
	public void setCartSum(int cartSum) {
		this.cartSum = cartSum;
	}
	
	
}
	