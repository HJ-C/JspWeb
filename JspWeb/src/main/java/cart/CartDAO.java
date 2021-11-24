package cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cart.CartDTO;
import util.DatabaseUtil;

import javax.servlet.http.HttpServletRequest;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class CartDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<CartDTO> ctList() {
		ArrayList<CartDTO> ctList = new ArrayList<CartDTO>();
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM cart");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String cartId = rs.getString("cartId");
				String cartImg = rs.getString("cartImg");
				String cartName = rs.getString("cartName");
				int cartPrice = rs.getInt("cartPrice");
				int cartCount = rs.getInt("cartCount");
				int cartSum = rs.getInt("cartSum");
				
				CartDTO data = new CartDTO();
				data.setCartId(cartId);
				data.setCartImg(cartImg);
				data.setCartName(cartName);
				data.setCartPrice(cartPrice);
				data.setCartCount(cartCount);
				data.setCartSum(cartSum);
				ctList.add(data);
			}
			pstmt.close();
			conn.close();
		} catch(Exception e) {
			System.out.println("cartDAO ctList Error");
			e.printStackTrace();
		}
		return ctList;
	}
	
	
	public CartDTO getCart(String id) {
		CartDTO ctDto = null;
		
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM cart where cartId = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ctDto = new CartDTO();
				ctDto.setCartId(rs.getString("cartId"));
				ctDto.setCartImg(rs.getString("cartImg"));
				ctDto.setCartName(rs.getString("cartName"));
				ctDto.setCartPrice(rs.getInt("cartPrice"));
				ctDto.setCartCount(rs.getInt("cartCount"));
				ctDto.setCartSum(rs.getInt("cartSum"));
				
			}		
		} catch (Exception e) {
			System.out.println("getCartError" + e);
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) {e.printStackTrace();}
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) {e.printStackTrace();}
			try { if(rs != null) rs.close(); } catch (Exception e) {e.printStackTrace();}
		}
		return ctDto;
	}
	
	public boolean insertProduct(HttpServletRequest request) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean b = false;
		try {
			//업로드할 이미지 경로(절대 경로)
			String uploadDir = "C:\\Users\\apem5\\git\\jspWeb\\JspWeb\\WebContent\\images";
			 //MultipartRequest multi=new MultipartRequest(request, savePath, sizeLimit, new DefaultFileRenamePolicy());
            MultipartRequest multi = new MultipartRequest(request, uploadDir, 5*1024*1024, "utf-8", new DefaultFileRenamePolicy());
            conn = DatabaseUtil.getConnection();
            String SQL = "INSERT INTO product (productId, productName, companyId, price, soldCount, detail, imgUrl_1) values (?, ?, ?, ?, ?, ?, ?)";
            
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, multi.getParameter("productId"));
            pstmt.setString(2, multi.getParameter("productName"));
            pstmt.setString(3, multi.getParameter("companyId"));
            pstmt.setString(4, multi.getParameter("price"));
            pstmt.setString(5, multi.getParameter("soldCount"));
            pstmt.setString(6, multi.getParameter("detail"));
            if(multi.getParameter("imgUrl_1") == null) {
            	//이미지가 없을경우 디폴트 이미지 선택
            	pstmt.setString(7, "../images/#");
            } else {
            	pstmt.setString(7, multi.getFilesystemName("imgUrl_1"));
            }
            if (pstmt.executeUpdate() > 0) b = true;
		} catch (Exception e){
			System.out.println("insertProduct Error" + e);
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) {e.printStackTrace();}
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) {e.printStackTrace();}
			try { if(rs != null) rs.close(); } catch (Exception e) {e.printStackTrace();}
		}
		return b;
	}
	

	
	public boolean deleteCart(String cartId) {
		boolean b = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			String SQL = "DELETE FROM cart WHERE cartId = ?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, cartId);
			if(pstmt.executeUpdate() > 0) b = true;
		} catch (Exception e) {
			System.out.println("deleteCart Error" + e);
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) {e.printStackTrace();}
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) {e.printStackTrace();}
			try { if(rs != null) rs.close(); } catch (Exception e) {e.printStackTrace();}
		}
		return b;
	}
}
