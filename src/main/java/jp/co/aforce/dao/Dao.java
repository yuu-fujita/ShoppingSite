package jp.co.aforce.dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Dao {
	static DataSource ds;

	public Connection getConnection() throws Exception {
		if (ds == null) {
			InitialContext ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:/comp/env/jdbc/ksj_shoppingsite");
		}
		return ds.getConnection();
	}
	
	public void closeConnection(Connection connection) {
		// TODO 自動生成されたメソッド・スタブ
	}
}
