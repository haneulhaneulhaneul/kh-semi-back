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

	// 게시판 목록 조회
	public List<FreeBoardVO> boardRead() {
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
	
	// 게시판(자유글) 목록 조회
	public List<FreeBoardVO> freeBoardRead() {
	      List<FreeBoardVO> list = new ArrayList<>();
	      try {
	         conn = Common.getConnection();
	         stmt = conn.createStatement();
	         String sql = "SELECT * FROM FREE_BOARD WHERE FB_CATEGORY = " + "'" + "[자유글]" + "'";
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
	
	// 게시판(양도/교환) 목록 조회
	public List<FreeBoardVO> tradeBoardRead() {
	      List<FreeBoardVO> list = new ArrayList<>();
	      try {
	         conn = Common.getConnection();
	         stmt = conn.createStatement();
	         String sql = "SELECT * FROM FREE_BOARD WHERE FB_CATEGORY = " + "'" + "[양도/교환]" + "'";
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
	
	// 게시판(테마추천) 목록 조회
	public List<FreeBoardVO> recommendBoardRead() {
	      List<FreeBoardVO> list = new ArrayList<>();
	      try {
	         conn = Common.getConnection();
	         stmt = conn.createStatement();
	         String sql = "SELECT * FROM FREE_BOARD WHERE FB_CATEGORY = " + "'" + "[테마추천]" + "'";
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
	
	// 게시판(방탈출팁) 목록 조회
	public List<FreeBoardVO> tipBoardRead() {
	      List<FreeBoardVO> list = new ArrayList<>();
	      try {
	         conn = Common.getConnection();
	         stmt = conn.createStatement();
	         String sql = "SELECT * FROM FREE_BOARD WHERE FB_CATEGORY = " + "'" + "[방탈출팁]" + "'";
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
	
	
	// 게시판 글 작성
	public boolean boardWrite(String fb_category, String fb_user_id, String fb_title, String fb_content) {
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
	
	// 글 상세 조회
//	public boolean boardDetail(int fb_id) {
//		boolean isDetailBoard = false;
//		try {
//			conn = Common.getConnection();
//			stmt = conn.createStatement(); // Statement 객체 얻기
//			String sql = "SELECT * FROM FREE_BOARD WHERE FB_ID = " + "'" + fb_id + "'";
//			rs = stmt.executeQuery(sql);
//			
//			while(rs.next()) { // 읽은 데이타가 있으면 true
////			int sqlFb_id = rs.getInt("FB_ID"); // 쿼리문 수행 결과에서 ID값을 가져 옴
//				String sqlFb_category = rs.getString("FB_CATEGORY");
//				String sqlFb_user_id = rs.getString("FB_USER_ID");
//				String sqlFb_title = rs.getString("FB_TITLE");
//				String sqlFb_content = rs.getString("FB_CONTENT");
//				Date sqlfb_c_date = rs.getDate("FB_C_DATE");
//				int sqlFb_hit = rs.getInt("FB_HIT");
//				
//				System.out.println("FB_CATEGORY : " + sqlFb_category);
//				System.out.println("FB_USER_ID : " + sqlFb_user_id);
//				System.out.println("FB_TITLE" + sqlFb_title);
//				System.out.println("FB_CONTENT : " + sqlFb_content);
//				System.out.println("FB_C_DATE : " + sqlfb_c_date);
//				System.out.println("FB_HIT : " + sqlFb_hit);
//				
//				if("FB_USER_ID".equals(sqlFb_user_id)) {
//					isDetailBoard = true;
//				}
//			}
//			Common.close(rs);
//			Common.close(stmt);
//			Common.close(conn);
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		return isDetailBoard;
//	}
	
//	public List<FreeBoardVO> boardDetail(int fb_id) {
//	      List<FreeBoardVO> list = new ArrayList<>();
//	      try {
//	         conn = Common.getConnection();
//	         stmt = conn.createStatement();
//	         String sql = "SELECT * FROM FREE_BOARD WHERE FB_ID = " + "'" + fb_id + "'";
//	         rs = stmt.executeQuery(sql);
//	         
//	         while(rs.next()) {
//	            int fb_id = rs.getInt("FB_ID");
//	            String fb_category = rs.getString("FB_CATEGORY");
//	            String fb_user_id = rs.getString("FB_USER_ID");
//	            String fb_title = rs.getString("FB_TITLE");
//	            String fb_content = rs.getString("FB_CONTENT");
//	            Date fb_c_date = rs.getDate("FB_C_DATE");
//	            Date fb_u_date = rs.getDate("FB_U_DATE");
//	            int fb_recommend = rs.getInt("FB_RECOMMEND");
//	            int fb_hit = rs.getInt("FB_HIT");
//	            
//	            FreeBoardVO vo = new FreeBoardVO();
//	            vo.setFb_id(fb_id);
//	            vo.setFb_category(fb_category);
//	            vo.setFb_user_id(fb_user_id);
//	            vo.setFb_title(fb_title);
//	            vo.setFb_content(fb_content);
//	            vo.setFb_c_date(fb_c_date);
//	            vo.setFb_u_date(fb_u_date);
//	            vo.setFb_recommend(fb_recommend);
//	            vo.setFb_hit(fb_hit);
//	            list.add(vo);
//	            
//	         }
//	         Common.close(rs);
//	         Common.close(stmt);
//	         Common.close(conn);
//	      } catch (Exception e) {
//	         e.printStackTrace();
//	      }
//	      
//	      return list;
//	   }
	
	
}