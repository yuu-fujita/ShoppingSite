package jp.co.aforce.admin;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.bean.ItemBean;
import jp.co.aforce.dao.ItemDAO2;
/**
 * Servlet implementation class Item_searchServlet
 */
@WebServlet("/views/Item_searchServlet")
public class Item_searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Item_searchServlet() {
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
		String itemName = request.getParameter("item_name");
		ItemDAO2 itemDAO2 = new ItemDAO2();
		try {
			List<ItemBean> item = itemDAO2.search(itemName);
			request.setAttribute("item", item);
			request.getRequestDispatcher("/views/admin_itemList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("商品の検索に失敗しました。");
		}
	}
}