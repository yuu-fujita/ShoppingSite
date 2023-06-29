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
import jp.co.aforce.dao.ItemDAO2;

/**
 * Servlet implementation class SearchPrice
 */
@WebServlet("/views/searchprice")
public class SearchPrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPrice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int pricemax = Integer.parseInt(request.getParameter("pricemax"));
		int pricemin = Integer.parseInt(request.getParameter("pricemin"));
		HttpSession session = request.getSession();
		ItemDAO2 itemDAO2 = new ItemDAO2();
		
		try {
			List<ItemBean> searchPrice = itemDAO2.searchPrice(pricemin, pricemax);
			if(searchPrice != null || searchPrice.size() == 0) {
				session.setAttribute("list", searchPrice);
				request.getRequestDispatcher("searchprice.jsp").forward(request,response);
			}else {
				request.getRequestDispatcher("itemsearchfail.jsp").forward(request,response);
			}
		    }catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
		    }
		    
		    
		
	}

}
