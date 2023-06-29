package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.bean.ItemBean;

public class ItemDAO2 extends Dao{
	
	//商品情報確認
	public boolean itemCheck(String item_name) throws Exception{
		Connection con= getConnection();
		PreparedStatement st = con.prepareStatement(
				"SELECT * FROM item_list WHERE item_name = ?"
				);
			st.setString(1, item_name);
			ResultSet rs = st.executeQuery();
			boolean exists = rs.next();
			
			rs.close();
			st.close();
			closeConnection(con);
			 return exists;
	}
	
	//商品情報登録処理
	public boolean registerItem(ItemBean item)throws Exception {
		
		Connection con= getConnection();
		
		PreparedStatement st = con.prepareStatement(
					"INSERT INTO ITEM_LIST(ITEM_NAME, PRICE, CATEGORY, RELEASE_YEAR, RELEASE_MONTH, RELEASE_DAY, LEVEL, STOCK) "
					+ "VALUES(?,?,?,?,?,?,?,?);"
					);
			st.setString(1, item.getItem_name());
			st.setInt(2, item.getPrice());
			st.setString(3, item.getCategory());
			st.setInt(4, item.getRelease_year());
			st.setInt(5, item.getRelease_month());
			st.setInt(6, item.getRelease_day());
			st.setString(7, item.getLevel());
			st.setInt(8, item.getStock());
			int i = st.executeUpdate();
			
			if (i > 0) {
				System.out.println("商品情報の登録に成功しました。");
				return true;
			} else {
				System.out.println("登録中に問題が発生しました。");
				return false;
			}
	}
	
	//商品の表示
	public List<ItemBean> getItemList() throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("SELECT * FROM ITEM_LIST");
		ResultSet rs = st.executeQuery();
		List<ItemBean> itemList = new ArrayList<>();
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
			itemList.add(item);
		}
		rs.close();
		st.close();
		closeConnection(con);
		return itemList;
	}

	//商品の検索
	public List<ItemBean> search(String item_name) throws Exception {
		List<ItemBean> itemList = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
				"SELECT * FROM item_list WHERE item_name LIKE ?");
		st.setString(1, "%" + item_name + "%");
		ResultSet rs = st.executeQuery();
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
			itemList.add(item);
		}
		rs.close();
		st.close();
		closeConnection(con);
		return itemList;
	}
	
	//商品の更新
	public boolean updateItem(ItemBean item) throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
				"UPDATE ITEM_LIST SET ITEM_NAME=?, PRICE=?, CATEGORY=?, RELEASE_YEAR=?, RELEASE_MONTH=?, RELEASE_DAY=?, LEVEL=?, STOCK=? WHERE ITEM_ID=?"
				);
		st.setString(1, item.getItem_name());
		st.setInt(2, item.getPrice());
		st.setString(3, item.getCategory());
		st.setInt(4, item.getRelease_year());
		st.setInt(5, item.getRelease_month());
		st.setInt(6, item.getRelease_day());
		st.setString(7, item.getLevel());
		st.setInt(8, item.getStock());
		st.setInt(9, item.getItem_id());
		int i = st.executeUpdate();
		st.close();
		closeConnection(con);
		System.out.println(item.getItem_id());
		System.out.println(item.getItem_name());
		System.out.println(item.getStock());
		return i > 0;
	}
	
	//商品IDの取得
	public ItemBean getItemById(int item_id) throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("SELECT * FROM item_list WHERE item_id = ?");
		st.setInt(1, item_id);
		ResultSet rs = st.executeQuery();
		ItemBean item = null;
		if (rs.next()) {
			int itemId = rs.getInt("item_id");
			String item_name = rs.getString("item_name");
			int price = rs.getInt("price");
			String category = rs.getString("category");
			int release_year = rs.getInt("release_year");
			int release_month = rs.getInt("release_month");
			int release_day = rs.getInt("release_day");
			String level = rs.getString("level");
			int stock = rs.getInt("stock");
			item = new ItemBean(itemId, item_name, price, category, release_year, release_month, release_day, level, stock, 0);
		}
		rs.close();
		st.close();
		closeConnection(con);
		return item;
	}

	//商品の削除
	public boolean deleteItem(int item_id) throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("DELETE FROM item_list WHERE item_id = ?");
		st.setInt(1, item_id);
		int i = st.executeUpdate();
		st.close();
		closeConnection(con);
		return i > 0;
	}
	
	//ジャンル絞る
	public List<ItemBean> searchCategory(String category) throws Exception {
		List<ItemBean> itemList = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
				"SELECT * FROM item_list WHERE category = ?");
		st.setString(1, category );
		ResultSet rs = st.executeQuery();
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
			itemList.add(item);
		}
		rs.close();
		st.close();
		closeConnection(con);
		return itemList;
	}
	
	//全検索
	public List<ItemBean> searchall() throws Exception {
		List<ItemBean> itemList = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
				"SELECT * FROM item_list");
		ResultSet rs = st.executeQuery();
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
			itemList.add(item);
		}
		rs.close();
		st.close();
		closeConnection(con);
		return itemList;
	}
	
	//価格絞り込み
	public List<ItemBean> searchPrice(int pricemin, int pricemax) throws Exception {
		List<ItemBean> itemList = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
				"SELECT * FROM item_list WHERE price between ? and ?");
		st.setInt(1, pricemin);
		st.setInt(2, pricemax);
		ResultSet rs = st.executeQuery();
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
			itemList.add(item);
		}
		rs.close();
		st.close();
		closeConnection(con);
		return itemList;
	}
}
