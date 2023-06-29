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
 * Servlet implementation class Item_editServlert
 */
@WebServlet("/views/Item_editServlet")
public class Item_editServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Item_editServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		// 編集対象の商品IDを取得
		int itemId = Integer.parseInt(request.getParameter("item_id"));
		// 商品情報をデータベースから取得
		ItemDAO2 itemDAO2 = new ItemDAO2();
		ItemBean item = null;
		try {
			item = itemDAO2.getItemById(itemId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (item != null) {
			
			request.setAttribute("item", item);

			request.getRequestDispatcher("admin_itemUpdate.jsp").forward(request, response);
		} else {
			response.getWriter().println("商品情報の取得に失敗しました。");
		}
	}
	
}
