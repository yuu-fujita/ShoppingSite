package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.bean.HistoryBean;
import jp.co.aforce.bean.ItemBean;

//購入管理
public class HistoryDAO extends Dao{
	public void insert(HistoryBean his, List<ItemBean> items) throws Exception {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = getConnection();
			st = con.prepareStatement(
					"INSERT INTO HISTORY_LIST (MEMBER_ID, ITEM_ID, BUY_DATE, COUNT, TOTAL_PRICE) VALUES (?, ?, CURDATE(), ?, ?)");
			st.setString(1, his.getMember_id());
			st.setInt(2, his.getItem_id());
			st.setInt(3, his.getCount());
			st.setInt(4, his.getTotal_price());
			st.executeUpdate();
		} finally {
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}
	
	public List<ItemBean> getHistoryList(String id) throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("select * from history_list JOIN item_list ON history_list.item_id=item_list.item_id where member_id = ? ");
		st.setString(1, id);
		ResultSet rs = st.executeQuery();
		List<ItemBean> historyList = new ArrayList<>();
		while (rs.next()) {
			ItemBean item = new ItemBean();
			item.setItem_id(rs.getInt("ITEM_ID"));
			item.setItem_name(rs.getString("ITEM_NAME"));
			item.setPrice(rs.getInt("PRICE"));
			item.setCategory(rs.getString("CATEGORY"));
			item.setRelease_year(rs.getInt("RELEASE_YEAR"));
			item.setRelease_month(rs.getInt("RELEASE_MONTH"));
			item.setRelease_day(rs.getInt("RELEASE_DAY"));
			item.setLevel(rs.getString("LEVEL"));
			item.setStock(rs.getInt("STOCK"));
			historyList.add(item);
		}
		rs.close();
		st.close();
		closeConnection(con);
		return historyList;
	}

}
