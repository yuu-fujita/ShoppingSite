package jp.co.aforce.bean;

import java.io.Serializable;

public class ItemBean implements Serializable{
    
	private int item_id;
	private String item_name;
	private int price;
	private String category;
	private int release_year;
	private int release_month;
	private int release_day;
	private String level;
	private int stock;
	private int count;
		
	public ItemBean(int item_id, String item_name, int price, String category, int release_year, int release_month, int release_day, String level, int stock, int count) {
		this.item_id = item_id;
		this.item_name = item_name;
		this.price = price;
		this.category = category;
		this.release_year = release_year;
		this.release_month = release_month;
		this.release_day = release_day;
		this.level = level;
		this.stock = stock;
		this.count = count;
	}

	public int getItem_id() {
		return item_id;
	}
	
	public ItemBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}


	public String getItem_name() {
		return item_name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getCategory() {
		return category;
	}
	
	public int getRelease_year() {
		return release_year;
	}
	
	public int getRelease_month() {
		return release_month;
	}
	
	public int getRelease_day() {
		return release_day;
	}
	
	public String getLevel() {
		return level;
	}
	
	public int getStock() {
		return stock;
	}
	
	public int getCount() {
		return count;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	
	public void setPrice(int price) {
		this.price =price;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public void setRelease_year(int release_year) {
		this.release_year = release_year;
	}
	
	public void setRelease_month(int release_month) {
		this.release_month = release_month;
	}
	
	public void setRelease_day(int release_day) {
		this.release_day = release_day;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotal_price() {
		// TODO 自動生成されたメソッド・スタブ
		return price * count;
	}

}