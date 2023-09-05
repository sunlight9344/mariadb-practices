package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bookmall.connection.BookMallConnection;
import bookmall.vo.MemberVo;

public class MemberDao extends BookMallConnection{

	public void findAll() {
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "select * from member";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int empNo = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				String pw = rs.getString(5);
				
				System.out.println(empNo + " - " + name + " " + phone
						+ " " + email + " " + pw);
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

	public void insert(MemberVo memberVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "insert into member values(null,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberVo.getName());
			pstmt.setString(2, memberVo.getPhone());
			pstmt.setString(3, memberVo.getEmail());
			pstmt.setString(4, memberVo.getPw());
			
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