package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import product.ProductDTO;
import util.DatabaseUtil;

public class ProductDAO {
	
	public int getProductId(ProductDTO pd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT id FROM product WHERE productName LIKE %?%");
			pstmt.setInt(1, pd.getId());
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
	
	public int getPrice(ProductDTO pd) {
		String SQL = "SELECT price FROM product WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(4, pd.getPrice());
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
	
	public String getProductName(ProductDTO pd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT productName FROM product WHERE id LIKE ?");
			pstmt.setString(2, pd.getProductName());
			rs = pstmt.executeQuery();
			
			return rs.getString(2);
		} catch (Exception e) {
			System.out.println("ProductDAO getProductName Error");
			e.printStackTrace();
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) {e.printStackTrace();}
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) {e.printStackTrace();}
			try { if(rs != null) rs.close(); } catch (Exception e) {e.printStackTrace();}
		}
		return null; // 데이터베이스 오류
	}
	
	public String getProductDetail(ProductDTO pd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT detail FROM product WHERE id LIKE ?");
			pstmt.setString(6, pd.getDetail());
			rs = pstmt.executeQuery();
			
			return rs.getString(6);
		} catch (Exception e) {
			System.out.println("ProductDAO getProductDetail Error");
			e.printStackTrace();
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) {e.printStackTrace();}
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) {e.printStackTrace();}
			try { if(rs != null) rs.close(); } catch (Exception e) {e.printStackTrace();}
		}
		return null; // 데이터베이스 오류
	}

}
