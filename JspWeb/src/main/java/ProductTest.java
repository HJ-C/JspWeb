import java.util.ArrayList;
import product.ProductDAO;
import product.ProductDTO;

public class ProductTest {
	public static void main(String[] args) {
		ProductDAO pdDao = new ProductDAO();
		ArrayList<ProductDTO> pdList = pdDao.pdList();
		
		for(int i=0; i<pdList.size(); i++) {
			ProductDTO data = (ProductDTO) pdList.get(i);
			int id = data.getId();
			String productName = data.getProductName();
			int companyId = data.getCompanyId();
			int price = data.getPrice();
			int soldCount = data.getSoldCount();
			String detail = data.getDetail();
			String imgUrl_1 = data.getImgUrl_1();
			
			System.out.println("���̵�� :" + id + "��ǰ�̸��� :" + productName +
					"ȸ����̵�� :" + companyId + "������ :" + price + "�󼼼����� :" +
					detail);
		}
		
	}
}
