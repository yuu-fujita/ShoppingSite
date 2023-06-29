package jp.co.aforce.favorite;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.ItemBean;
import jp.co.aforce.bean.MemberBean;
import jp.co.aforce.dao.FavoriteDAO;

/**
 * Servlet implementation class CartView
 */
@WebServlet("/views/favoriteview")
public class Favorite_view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Favorite_view() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
//		List<ItemBean> favorite = (List<ItemBean>)session.getAttribute("favorite");
		MemberBean member_id = (MemberBean)session.getAttribute("member");
		if(member_id == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
		FavoriteDAO fav = new FavoriteDAO();
		
		List<ItemBean> item;
		try {
			item = fav.search(member_id);
			session.setAttribute("list", item);
			
			if(item == null) {
				request.getRequestDispatcher("favorite_null.jsp").forward(request, response);
			}else {
			if(item.size() != 0) {
				request.getRequestDispatcher("favorite_view.jsp").forward(request, response);		
				}else {
				request.getRequestDispatcher("favorite_null.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		}
		
	}
}