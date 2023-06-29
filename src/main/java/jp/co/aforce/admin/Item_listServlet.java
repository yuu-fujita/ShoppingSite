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

	@WebServlet("/views/Item_listServlet")
	public class Item_listServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        response.setContentType("text/html; charset=UTF-8");
	        request.setCharacterEncoding("UTF-8");
	        ItemDAO2 itemDAO2 = new ItemDAO2();
	        try {
	            List<ItemBean> itemList = itemDAO2.getItemList();
	            request.setAttribute("itemList", itemList);
	            request.getRequestDispatcher("/views/admin_itemList.jsp").forward(request, response);
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.getWriter().println("商品一覧の取得に失敗しました。");
	        }
		}
	}
	
