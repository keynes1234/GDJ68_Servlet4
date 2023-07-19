package com.iu.main.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.iu.main.util.DBConnector;

public class MemberDAO {
	
	public MemberDTO login(MemberDTO memberDTO)throws Exception{
		//1
		Connection con = DBConnector.getConnection();
		
		//2
		String sql = "SELECT ID, NAME FROM MEMBER WHERE ID=? AND PW=?";
	
		//3
		PreparedStatement st = con.prepareStatement(sql);
		
		//4
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
	
		//5
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			memberDTO = new MemberDTO();
			memberDTO.setId(rs.getString("ID"));
			memberDTO.setName(rs.getString("NAME"));
		}else {
			memberDTO=null;
		}
		
		//6
		DBConnector.disConnect(rs,st, con);
		
		return memberDTO;
	}
	
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
