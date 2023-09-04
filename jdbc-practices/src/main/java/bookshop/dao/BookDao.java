package bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookshop.vo.BookVo;
import hr.dao.vo.EmployeesVo;

public class BookDao {
	

	public void updateRent(int keyno) {
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		try {
			//1. JDBC Driver Class 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			//2. 연결하기
			String url = "jdbc:mariadb://192.168.0.180:3307/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			//3. Statement 객체 생성
			String sql = 
					"update book"+
					" set rent='Y'"+ 
					" where no=" + keyno;
			pstmt = conn.prepareStatement(sql);
			
			//5. SQL 실행
			rs = pstmt.executeQuery();

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				//7. 자원정리
				if(rs != null) {
					rs.close();
				}
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

	public List<BookVo> findAll() {
		
		List<BookVo> result = new ArrayList<>();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		try {
			//1. JDBC Driver Class 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			//2. 연결하기
			String url = "jdbc:mariadb://192.168.0.180:3307/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			//3. Statement 객체 생성
			String sql = 
					"select * from book";
			pstmt = conn.prepareStatement(sql);
			
			//5. SQL 실행
			rs = pstmt.executeQuery();
			
			//6. 결과 처리
			while(rs.next()) {
				int no = rs.getInt(1);
				String title = rs.getString(2);
				String rent = rs.getString(3);
				int author_no = rs.getInt(4);
				
				BookVo vo = new BookVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setRent(rent);
				vo.setAuthor_no(author_no);
				
				result.add(vo);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				//7. 자원정리
				if(rs != null) {
					rs.close();
				}
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
		return result;
	}

}
