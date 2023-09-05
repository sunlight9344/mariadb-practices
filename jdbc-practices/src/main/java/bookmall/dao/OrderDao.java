package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bookmall.connection.BookMallConnection;
import bookmall.vo.OrderBookVo;
import bookmall.vo.OrderVo;

public class OrderDao extends BookMallConnection{
	
	public void findAllOrder() {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			//3. ready SQL
			String sql = "select a.no, b.name, b.phone, b.email, a.orders_no, a.orders_price, a.address"
					+ " from orders a, member b"
					+ " where a.member_no = b.no";
			pstmt = conn.prepareStatement(sql);
			
			//5. SQL 실행
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				String orders_no = rs.getString(5);
				int orders_price = rs.getInt(6);
				String address = rs.getString(7);
				
				System.out.println(no + " - " + name + " " + phone
						+ " " + email + " " + orders_no + " " + orders_price + " " + address);
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

	public void insertOrder(OrderVo orderVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "insert into orders values(null,1,'202301010001',20000,'서울시 이촌동')";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, orderVo.getNo());
			pstmt.setString(2, orderVo.getOrders_no());
			pstmt.setInt(3, orderVo.getOrders_price());
			pstmt.setString(4, orderVo.getAddress());
			
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
	
	public void findAllOrderBook() {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			//3. ready SQL
			String sql = "select c.no, c.orders_no, b.title, b.price, a.quantity, d.name, c.orders_price, c.address"
					+ " from orders_book a, book b, orders c, member d"
					+ " where a.book_no = b.no"
					+ " and a.orders_no = c.no"
					+ " and c.member_no = d.no";
			pstmt = conn.prepareStatement(sql);
			
			//5. SQL 실행
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt(1);
				String orders_no = rs.getString(2);
				String title = rs.getString(3);
				int price = rs.getInt(4);
				int quantity = rs.getInt(5);
				String name = rs.getString(6);
				int order_price= rs.getInt(7);
				String address = rs.getString(8);
				
				System.out.println(no + " - " + name + " " + orders_no
						+ " " + title + " " + price + " " + quantity + " " + name + " " + order_price + " " + address);
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
	
	public void insertOrderBook(OrderBookVo orderbookVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "insert into orders_book values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, orderbookVo.getOrders_no());
			pstmt.setInt(2, orderbookVo.getBook_no());
			pstmt.setInt(3, orderbookVo.getQuantity());
			
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
