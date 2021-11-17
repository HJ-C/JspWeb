package productDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IndexDto {
	private int productId;
	private String productName;
	private String companyName;
	private long price;
	private int soldCount;
	private String imgUrl_1;
}
