package productDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetailProdRespDto {
	private int prodId;
	private String imgUrl_1;
	private String imgUrl_2;
	private String imgUrl_3;
	private String imgUrl_4;
	private String url; // ?��?�� url
	private String companyName;
	private String productName;
	private long price;
	private int soldCount;
	private String detail;
}
