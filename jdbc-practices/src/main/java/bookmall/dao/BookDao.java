package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bookmall.connection.BookMallConnection;
import bookmall.vo.BookVo;

public class BookDao extends BookMallConnection {
	
	public void findAll() {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			//3. ready SQL
			String sql = 
					"select a.no, b.name, a.title, a.price"
					+ " from book a, category b"
					+ " where a.category_no = b.no";
			pstmt = conn.prepareStatement(sql);
			
			//5. SQL 실행
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int empNo = rs.getInt(1);
				String category_no = rs.getString(2);
				String title = rs.getString(3);
				int price = rs.getInt(4);
				
				System.out.println(empNo + " - " + category_no
						+ " " + title + " " + price);
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

	public void insert(BookVo bookVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "insert into book values(null,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			//4. 값 binding
			pstmt.setInt(1, bookVo.getCategory_no());
			pstmt.setString(2, bookVo.getTitle());
			pstmt.setInt(3, bookVo.getPrice());
			
			//5. SQL 실행
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
