package jp.co.aforce.itemsearch;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.ItemBean;
import jp.co.aforce.dao.ItemDao;

/**
 * Servlet implementation class ItemSearch
 */
@WebServlet("/views/itemsearch")
public class ItemSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String keyword = request.getParameter("item_name");
		HttpSession session = request.getSession();
		ItemDao itemDao = new ItemDao();

		List<ItemBean> list;
		try {
			list = itemDao.search(keyword);
			if(list != null) {
			session.setAttribute("list", list);
			request.getRequestDispatcher("itemsearchsuccess.jsp").forward(request,response);
			} else {
				request.getRequestDispatcher("itemsearchfail.jsp").forward(request,response);
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		

		

		
		
	}

}
