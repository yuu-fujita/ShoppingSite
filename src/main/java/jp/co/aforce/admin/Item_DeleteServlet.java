		package jp.co.aforce.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.dao.ItemDAO2;

/**
 * Servlet implementation class Item_DeleteServlet
 */
@WebServlet("/views/Item_DeleteServlet")
public class Item_DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Item_DeleteServlet() {
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
		 	int item_id = Integer.parseInt(request.getParameter("item_id"));
		 	ItemDAO2 itemDAO2 = new ItemDAO2();
		 	try {
		 		boolean success = itemDAO2.deleteItem(item_id);
		 		if (success) {
		 			request.getRequestDispatcher("admin_itemUpdate_ok.jsp").forward(request, response);
		 		} else {
		 			response.getWriter().println("商品の削除に失敗しました。");
		 		}
		 	} catch (Exception e) {
		 		e.printStackTrace();
		 		response.getWriter().println("商品の削除に失敗しました。");
		 	}
		}
	}