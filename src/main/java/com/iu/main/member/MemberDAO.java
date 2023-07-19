package com.iu.main.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.iu.main.util.DBConnector;

public class MemberDAO {
	
	public int join(MemberDTO memberDTO) throws Exception {
		int result=0;
		
		//1. DB 연결
		Connection con = DBConnector.getConnection();
		
		//2. SQL문 생성
		String sql="INSERT INTO MEMBER (ID, PW, NAME, EMAIL, BIRTH) "
				+ "VALUES (?, ?, ?, ?, ?)";
		
		//3. 미리 보내기
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ? 세팅
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getName());
		st.setString(4, memberDTO.getEmail());
		st.setDate(5, memberDTO.getBirth());
		
		//5. 최종 전송 및 결과처리
		result = st.executeUpdate();
		
		//6. 연결 해제
		DBConnector.disConnect(st, con);
		
		return result;
	}

}
