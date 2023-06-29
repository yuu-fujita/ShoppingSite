package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.bean.ItemBean;

public class ItemDao extends Dao{
	public List<ItemBean> search(String keyword) throws Exception {
		List<ItemBean> list = new ArrayList<>();
		int n = 0;
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"select * from item_list where item_name like ?");
		st.setString(1, "%"+keyword+"%");
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			ItemBean i = new ItemBean();
			i.setItem_id(rs.getInt("item_id"));
			i.setItem_name(rs.getString("item_name"));
			i.setPrice(rs.getInt("price"));
			i.setCategory(rs.getString("category"));
			i.setRelease_year(rs.getInt("release_year"));
			i.setRelease_month(rs.getInt("release_month"));
			i.setRelease_day(rs.getInt("release_day"));
			i.setLevel(rs.getString("level"));
			i.setStock(rs.getInt("stock"));
			list.add(i);
			n  += 1;
		}
		
		if(n == 0) {
			list = null;
		}
		st.close();
		con.close();
		return list;
	}
public int updateStock(int id, int count, int stock) throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
				"UPDATE ITEM_LIST SET STOCK=? WHERE ITEM_ID=?"
				);
		st.setInt(1, stock - count);
		st.setInt(2, id);
		int line = st.executeUpdate();
		st.close();
		closeConnection(con);		
		return line;
	}
}
