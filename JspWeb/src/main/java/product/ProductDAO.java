package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import product.ProductDTO;
import util.DatabaseUtil;

public class ProductDAO {
	
	public ArrayList<ProductDTO> pdList() {
		ArrayList<ProductDTO> pdList = new ArrayList<ProductDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM product");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("id");
				String productName = rs.getString("productName");
				int companyId = rs.getInt("companyId");
				int price = rs.getInt("price");
				int soldCount = rs.getInt("soldCount");
				String detail = rs.getString("detail");
				String imgUrl_1 = rs.getString("imgUrl_1");
				
				ProductDTO data = new ProductDTO();
				data.setId(id);
				data.setProductName(productName);
				data.setCompanyId(companyId);
				data.setPrice(price);
				data.setSoldCount(soldCount);
				data.setDetail(detail);
				data.setImgUrl_1(imgUrl_1);
				pdList.add(data);
			}
			pstmt.close();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return pdList;
	}
	
	public int getProductId() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT id FROM product ORDER BY product ASCE");
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("productDAO getProductId Error");
			e.printStackTrace();
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) {e.printStackTrace();}
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) {e.printStackTrace();}
			try { if(rs != null) rs.close(); } catch (Exception e) {e.printStackTrace();}
		}
		
		return -1; // 데이터베이스 오류
	}
	
	public int getPrice() {
		String SQL = "SELECT price FROM product WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(4, getProductId());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {				
				return rs.getInt(4);
			}
		} catch (Exception e) {
			System.out.println("ProductDAO getPrice Error");
			e.printStackTrace();
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) {e.printStackTrace();}
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) {e.printStackTrace();}
			try { if(rs != null) rs.close(); } catch (Exception e) {e.printStackTrace();}
		}
		return -1; // 데이터베이스 오류
	}
	
	public int getProductName() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT productName FROM product WHERE id = ?");
			pstmt.setInt(2, getProductId());
			rs = pstmt.executeQuery();
			
			return rs.getInt(2);
		} catch (Exception e) {
			System.out.println("ProductDAO getProductName Error");
			e.printStackTrace();
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) {e.printStackTrace();}
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) {e.printStackTrace();}
			try { if(rs != null) rs.close(); } catch (Exception e) {e.printStackTrace();}
		}
		return -1; // 데이터베이스 오류
	}
	
	public int getProductDetail() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT detail FROM product WHERE id = ?");
			pstmt.setInt(6, getProductId());
			rs = pstmt.executeQuery();
			
			return rs.getInt(6);
		} catch (Exception e) {
			System.out.println("ProductDAO getProductDetail Error");
			e.printStackTrace();
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) {e.printStackTrace();}
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) {e.printStackTrace();}
			try { if(rs != null) rs.close(); } catch (Exception e) {e.printStackTrace();}
		}
		return -1; // 데이터베이스 오류
	}

}
