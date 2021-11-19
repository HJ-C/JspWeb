package product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {
	private int id;
	private String productName;
	private int companyId;
	private int price;
	private int soldCount;
	private String detail;
	private String imgUrl_1;
}
