package com.bit2020.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bit2020.mysite.vo.UserVo;


public class UserRepository {
	public boolean save(UserVo vo) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1. 연결하기
			connection = getConnection();

			// 2. SQL 준비
			String sql = 
				"     insert" +
				"  into user" + 
				"     values(null, ?, ?, password(?), ?, now())"; 
			pstmt = connection.prepareStatement(sql);
			
			// 3. 바인딩(binding)
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getGender());
			
			// 4. sql 실행	
			int count = pstmt.executeUpdate();
			result = (count == 1);
			
		} catch (SQLException e) {
			System.out.println("에러:" + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}	
	private Connection getConnection() throws SQLException {
		Connection connection = null;
		
		// 1. jdbc 라이브러리 로딩 Driver loading -> mariaDB
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3307/webdb?characterEncoding=utf8";
			// 2. db 연결하기
			connection = DriverManager.getConnection(url, "webdb", "webdb");
			
		}  catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("드라이버 로딩 실패");
		}

		System.out.println("연결 성공");
		return connection;
	}
	public UserVo findByEmailAndPassWord(String email, String password) {
		UserVo result = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			// 1. 연결하기
			connection = getConnection();

			// 2. SQL 준비
			String sql = "select no,name from user where email=? and password = password(?)"; 
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			
			rs = pstmt.executeQuery();
			
			// 3. 바인딩(binding)
		
			if(rs.next()) {
				Long no =rs.getLong(1);
				String name = rs.getString(2);
				
				result = new UserVo();
				result.setNo(no);
				result.setName(name);
			}
			
			
		} catch (SQLException e) {
			System.out.println("에러:" + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null) {
					connection.close();
				}

				if(rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		return result;
	}
}
