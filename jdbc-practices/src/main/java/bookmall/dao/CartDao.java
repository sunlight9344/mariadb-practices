package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bookmall.connection.BookMallConnection;
import bookmall.vo.CartVo;

public class CartDao extends BookMallConnection{
	
	public void findAll() {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//1. JDBC Driver Class 로딩
			
			conn = getConnection();
			
			//3. ready SQL
			String sql = 
					"select c.no, title, b.name, c.quantity*a.price"
					+ " from book a, member b, cart c"
					+ " where a.no = c.book_no"
					+ " and b.no = c.member_no"
					+ " order by c.no";
			pstmt = conn.prepareStatement(sql);
			
			//5. SQL 실행
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int empNo = rs.getInt(1);
				String title = rs.getString(2);
				String name = rs.getString(3);
				int price = rs.getInt(4);
				
				System.out.println(empNo + " - " + title
						+ " " + name + " " + price);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				//6. 자원정리
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void insert(CartVo cartVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {

			conn = getConnection();
			
			//3. ready SQL
			String sql = 
					"insert into cart values(null,?,?,?);";
			pstmt = conn.prepareStatement(sql);
			
			//4. 값 binding
			pstmt.setInt(1, cartVo.getBookNo());
			pstmt.setInt(2, cartVo.getMemberNo());
			pstmt.setInt(3, cartVo.getQuantity());
			
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				//6. 자원정리
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
