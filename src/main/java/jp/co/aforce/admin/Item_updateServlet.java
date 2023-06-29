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
 * Servlet implementation class Item_updateServlet
 */
@WebServlet("/views/Item_updateServlet")
public class Item_updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Item_updateServlet() {
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
		
		int itemId = Integer.parseInt(request.getParameter("item_id"));
		String itemName = request.getParameter("item_name");
		int price = Integer.parseInt(request.getParameter("price"));
		String category = request.getParameter("category");
		int releaseYear = Integer.parseInt(request.getParameter("release_year"));
		int releaseMonth = Integer.parseInt(request.getParameter("release_month"));
		int releaseDay = Integer.parseInt(request.getParameter("release_day"));
		String level = request.getParameter("level");
		int stock = Integer.parseInt(request.getParameter("stock"));
		
		ItemBean item = new ItemBean();
		item.setItem_id(itemId);
		item.setItem_name(itemName);
		item.setPrice(price);
		item.setCategory(category);
		item.setRelease_year(releaseYear);
		item.setRelease_month(releaseMonth);
		item.setRelease_day(releaseDay);
		item.setLevel(level);
		item.setStock(stock);
		ItemDAO2 itemDAO2 = new ItemDAO2();
		boolean success = false;
		try {
			 success = itemDAO2.updateItem(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (success) {
			request.getRequestDispatcher("admin_itemUpdate_ok.jsp").forward(request, response);
        } else {
            response.getWriter().println("商品情報の更新に失敗しました。");
        }
    }
}