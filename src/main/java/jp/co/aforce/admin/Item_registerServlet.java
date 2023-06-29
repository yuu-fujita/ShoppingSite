package jp.co.aforce.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.bean.ItemBean;
import jp.co.aforce.dao.ItemDAO2;

/**
 * Servlet implementation class Item_set
 */
@WebServlet("/views/Item_registerServlet")
public class Item_registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Item_registerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		int itemId = 0;
		String itemName = request.getParameter("item_name");
		int price = Integer.parseInt(request.getParameter("price"));
		String category = request.getParameter("category");
		int releaseYear = Integer.parseInt(request.getParameter("release_year"));
		int releaseMonth = Integer.parseInt(request.getParameter("release_month"));
		int releaseDay = Integer.parseInt(request.getParameter("release_day"));
		String level = request.getParameter("level");
		int stock = Integer.parseInt(request.getParameter("stock"));
		
		ItemDAO2 itemDAO2 = new ItemDAO2();
		boolean itemChecks = false;
		try {
			itemChecks = itemDAO2.itemCheck(itemName);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		if(itemChecks) {
			response.getWriter().println("商品情報が既に存在します。");
			return;
		}
		
		//商品情報の登録
		ItemBean item = new ItemBean(itemId, itemName, price, category, releaseYear, releaseMonth, releaseDay, level, stock, 0);
		boolean success = false;
		try {
			success = itemDAO2.registerItem(item);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		if (success) {
			request.getRequestDispatcher("admin_register_ok.jsp").forward(request, response);
		} else {
			response.getWriter().println("商品情報の登録に失敗しました。");
		}
	}
}
