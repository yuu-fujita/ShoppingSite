package jp.co.aforce.itemsearch;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class SearchAll
 */
@WebServlet("/views/searchall")
public class SearchAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAll() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		HttpSession session = request.getSession();
		ItemDAO2 itemDAO2 = new ItemDAO2();
		
		PrintWriter out = response.getWriter();

		List<ItemBean> category;
		try {
			category = itemDAO2.searchall();
			if(category != null) {
			session.setAttribute("list", category);
			request.getRequestDispatcher("searchcategory.jsp").forward(request,response);
			} else {
				request.getRequestDispatcher("itemsearchfail.jsp").forward(request,response);
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace(out);
		}
	}

}
