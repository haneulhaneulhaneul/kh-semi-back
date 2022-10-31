package com.kh.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.common.Common;
import com.kh.vo.FreeBoardVO;

public class FreeBoardDAO {
	private Connection conn = null;
	private Statement stmt = null; //표준 SQL문을 수행하기 위한 Statement 객체 얻기
	private ResultSet rs = null; // Statement의 수행 결과를 여러행으로 받음
	// SQL문을 미리 컴파일해서 재 사용하므로 Statement 인터페이스보다 훨씬 빨르게 데이터베이스 작업을 수행
	private PreparedStatement pstmt = null; 

	public List<FreeBoardVO> BoardRead() {
		List<FreeBoardVO> list = new ArrayList<>();
		try {
			conn = Common.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM FREE_BOARD";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int fb_id = rs.getInt("FB_ID");
				String fb_category = rs.getString("FB_CATEGORY");
				String fb_user_id = rs.getString("FB_USER_ID");
				String fb_title = rs.getString("FB_TITLE");
				String fb_content = rs.getString("FB_CONTENT");
				Date fb_c_date = rs.getDate("FB_C_DATE");
				Date fb_u_date = rs.getDate("FB_U_DATE");
				int fb_recommend = rs.getInt("FB_RECOMMEND");
				int fb_hit = rs.getInt("FB_HIT");
				
				FreeBoardVO vo = new FreeBoardVO();
				vo.setFb_id(fb_id);
				vo.setFb_category(fb_category);
				vo.setFb_user_id(fb_user_id);
				vo.setFb_title(fb_title);
				vo.setFb_content(fb_content);
				vo.setFb_c_date(fb_c_date);
				vo.setFb_u_date(fb_u_date);
				vo.setFb_recommend(fb_recommend);
				vo.setFb_hit(fb_hit);
				list.add(vo);
				
			}
			Common.close(rs);
			Common.close(stmt);
			Common.close(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public boolean BoardWrite(String fb_category, String fb_user_id, String fb_title, String fb_content) {
		int result = 0;
		String sql = "INSERT INTO FREE_BOARD(FB_ID, FB_CATEGORY, FB_USER_ID, FB_TITLE, FB_CONTENT, FB_C_DATE, FB_U_DATE, FB_RECOMMEND, FB_HIT)"
				+ " VALUES(FB_ID_SEQ.NEXTVAL, ?, ?, ?, ?, SYSDATE, NULL, DEFAULT, DEFAULT)";
		try {
			conn = Common.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fb_category);
			pstmt.setString(2, fb_user_id);
			pstmt.setString(3, fb_title);
			pstmt.setString(4, fb_content);
			result = pstmt.executeUpdate();	
			System.out.println("글 등록 결과 확인 : " + result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Common.close(pstmt);
		Common.close(conn);
		
		if(result == 1) return true;
		else return false;
	}

	public boolean BoardWrite(String getFb_category, String getFb_title, String getFb_content) {
		// TODO Auto-generated method stub
		return false;
	}
	
}