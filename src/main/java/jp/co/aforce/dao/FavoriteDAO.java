package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.bean.ItemBean;
import jp.co.aforce.bean.MemberBean;

public class FavoriteDAO extends Dao{

	public int register( MemberBean member_id,int item_id) throws Exception{
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"insert into favorite values(null, ? , ? )");
		st.setString(1, member_id.getMember_id());
		st.setInt(2, item_id);
		int line = st.executeUpdate();
		
		st.close();
		con.close();
		return line;
		}
	
	public ItemBean registerSearch(ItemBean regs) throws Exception{
		Connection con = getConnection();
		ItemBean r = null;
		PreparedStatement st = con.prepareStatement(
				"select * from favorite where "
				+ "i_name = ? ");

		st.setString(1, regs.getItem_name());
//		st.setString(2, regs.getPass());
//		st.setString(3, regs.getMail());
//		st.setString(4, regs.getPhone());
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			r= new ItemBean();
		}
		
		st.close();
		con.close();
		return r;
	}
	
	public List<ItemBean> search(MemberBean member_id) throws Exception{
	List<ItemBean> list = new ArrayList<>();
	int n = 0;
	Connection con = getConnection();
	
	PreparedStatement st = con.prepareStatement(
			"select * from favorite JOIN member_list ON favorite.m_id=member_list.member_id LEFT JOIN item_list ON favorite.i_id=item_list.item_id WHERE member_id = ?");
	st.setString(1, member_id.getMember_id());
	ResultSet rs = st.executeQuery();
	
	while(rs.next()) {
		//list = new ArrayList<>();
		ItemBean i =  new ItemBean();
		i.setItem_id(rs.getInt("item_id"));
		i.setItem_name(rs.getString("item_name"));
		i.setPrice(rs.getInt("price"));
		i.setCategory(rs.getString("category"));
		i.setRelease_year(rs.getInt("release_year"));
		i.setRelease_month(rs.getInt("release_day"));
		i.setRelease_day(rs.getInt("release_day"));
		i.setLevel(rs.getString("level"));
		i.setStock(rs.getInt("stock"));
		list.add(i);
		n += 1;		
	}
	if(n == 0) {
		list = null;
	}			
	st.close();
	con.close();
	return list;
	}
	
	public int registerSearch(MemberBean member_id,int item_id) throws Exception{
		Connection con = getConnection();
		int f = 0;
		PreparedStatement st = con.prepareStatement(
				"select * from favorite JOIN member_list ON favorite.m_id=member_list.member_id LEFT JOIN item_list ON favorite.i_id=item_list.item_id WHERE m_id = ? AND i_id = ?");
	
		st.setString(1, member_id.getMember_id());
		st.setInt(2, item_id);
//		st.setString(3, regs.getMail());
//		st.setString(4, regs.getPhone());
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			f +=1;
		}
		
		st.close();
		con.close();
		return f;
	}
	
	public int delete(MemberBean member_id,int item_id) throws Exception{
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"delete from favorite where m_id = ? and i_id = ? ");
		st.setString(1, member_id.getMember_id());
		st.setInt(2, item_id);
		
		int line = st.executeUpdate();
		
		st.close();
		con.close();
		return line;
	}

}
