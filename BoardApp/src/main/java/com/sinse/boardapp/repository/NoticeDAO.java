package com.sinse.boardapp.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sinse.boardapp.exception.NoticeException;
import com.sinse.boardapp.model.Notice;

//CRUD
public class NoticeDAO {
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/spring4";
	String user="spring4";
	String pass="1234";
	
	//모든 레코드 
	public List selectAll() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List list = new ArrayList();
		
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, pass); //접속시도
			StringBuffer sql=new StringBuffer();
			sql.append("select * from notice order by notice_id desc");
			
			pstmt=con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Notice notice = new Notice();
				notice.setNotice_id(rs.getInt("notice_id"));
				notice.setTitle(rs.getString("title"));
				notice.setContent(rs.getString("content"));
				notice.setRegdate(rs.getString("regdate"));
				notice.setHit(rs.getInt("hit"));
				
				list.add(notice);
			}			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}			
		}		
		
		return list;
	}
	
	//한건 가져오기 
	public Notice select() {
		return null;
	}
	
	//한건 넣기 
	public void insert(Notice notice) throws NoticeException{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, pass); //접속시도
			StringBuffer sql=new StringBuffer();
			sql.append("insert into notice(title, writer, content) values(?,?,?)");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, notice.getTitle());
			pstmt.setString(2, notice.getWriter());
			pstmt.setString(3, notice.getContent());
			
			int result = pstmt.executeUpdate(); //DML 수행
			
			if(result<1) {
				throw new NoticeException("글 등록 실패");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	//수정 
	public void update() {
	}
	
	//삭제 
	public void delete() {
	}
}










