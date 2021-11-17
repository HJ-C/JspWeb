package productDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InsertReqDto {
	private String productName;
	private int companyId;
	private long price;
	private String detail;
	private String imgUrl_1;
	private String imgUrl_2;
	private String imgUrl_3;
	private String imgUrl_4;
	private int writerId;
}
