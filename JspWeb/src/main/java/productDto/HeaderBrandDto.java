package productDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HeaderBrandDto {
	private int id;
	private String name;
}
