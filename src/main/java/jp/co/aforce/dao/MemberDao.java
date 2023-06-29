package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.bean.MemberBean;

public class MemberDao extends Dao{
	public int delete(String member_id) 
		    throws Exception{
			
		
			Connection con = getConnection();
			
			PreparedStatement st = con.prepareStatement(
					"delete from member_list where member_id=?");
			st.setString(1, member_id);
			//st.setString(2, password);	
			int line = st.executeUpdate();
			
			
			st.close();
			con.close();
			
			return line;
		}
	
	public MemberBean search(String member_id, String password) 
		    throws Exception{
			
			MemberBean p = null;
			Connection con = getConnection();
			
			PreparedStatement st = con.prepareStatement(
					"select * from member_list where member_id=? and password=? ");
			st.setString(1, member_id);
			st.setString(2, password);	
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
			    p = new MemberBean();
				p.setMember_id(rs.getString("member_id"));
				p.setPassword(rs.getString("password"));
				p.setMember_name(rs.getString("member_name"));
				p.setHome_address(rs.getString("Home_address"));
				p.setBirth_year(rs.getInt("Birth_year"));
				p.setBirth_month(rs.getInt("Birth_month"));
				p.setBirth_day(rs.getInt("Birth_day"));
				p.setJob(rs.getString("Job"));
				p.setPhone_number(rs.getString("Phone_number"));
				p.setMail_address(rs.getString("Mail_address"));
			}
			st.close();
			con.close();
			return p;
		}
	
     public int insert(MemberBean bean) throws Exception {
        
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"INSERT INTO member_list VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		st.setString(1, bean.getMember_id());
		st.setString(2, bean.getPassword());
		st.setString(3, bean.getMember_name());
		st.setString(4, bean.getHome_address());
		st.setInt(5, bean.getBirth_year());
		st.setInt(6, bean.getBirth_month());
		st.setInt(7, bean.getBirth_day());
		st.setString(8, bean.getJob());
		st.setString(9, bean.getPhone_number());
		st.setString(10, bean.getMail_address());
		int line = st.executeUpdate();
		
		st.close();
		con.close();
		return line;		
 }
     
     public int updateMember(MemberBean member, String origin_id) throws Exception {
  		Connection con = getConnection();
  		PreparedStatement st = con.prepareStatement(
  				"UPDATE MEMBER_LIST SET member_id=?, password=?, member_name=?, home_address=?, birth_year=?, birth_month=?, birth_day=?, job=?, phone_number=?, mail_address=? WHERE member_id=?"
  				);
  		st.setString(1, member.getMember_id());
 		st.setString(2, member.getPassword());
 		st.setString(3, member.getMember_name());
 		st.setString(4, member.getHome_address());
 		st.setInt(5, member.getBirth_year());
 		st.setInt(6, member.getBirth_month());
 		st.setInt(7, member.getBirth_day());
 		st.setString(8, member.getJob());
 		st.setString(9, member.getPhone_number());
 		st.setString(10, member.getMail_address());
 		st.setString(11, origin_id);
  		int i = st.executeUpdate();
  		st.close();
  		closeConnection(con);
  		return i;
  	}
     
     public boolean memberCheck(String member_id) throws Exception{
 		Connection con= getConnection();
 		PreparedStatement st = con.prepareStatement(
 				"SELECT * FROM member_list WHERE member_id = ?"
 				);
 			st.setString(1, member_id);
 			ResultSet rs = st.executeQuery();
 			boolean exists = rs.next();
 			
 			rs.close();
 			st.close();
 			closeConnection(con);
 			 return exists;
 	}
     
}
