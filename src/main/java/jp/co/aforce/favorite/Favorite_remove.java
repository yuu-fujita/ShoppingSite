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
 * Servlet implementation class Favorite_remove
 */
@WebServlet("/views/favorite_remove")
public class Favorite_remove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Favorite_remove() {
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
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		HttpSession session = request.getSession();
		
		MemberBean member = (MemberBean)session.getAttribute("member");
		
		FavoriteDAO fav = new FavoriteDAO();
		
		int line;

			try {
				line = fav.delete(member, id);
			
			List<ItemBean> favorite = (List<ItemBean>)session.getAttribute("list");
			for(ItemBean i : favorite) {
			
			if(i.getItem_id() == id) {
				favorite.remove(i);
				break;
			}
			}
		if(favorite == null || favorite.size() == 0) {
			request.getRequestDispatcher("favorite_null.jsp").forward(request, response);
		}else {
		
		if(line > 0) {
			System.out.println("お気に入りから削除しました");
			request.getRequestDispatcher("favorite_view.jsp").forward(request, response);
	}
		}
	}catch (Exception e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}
			}
}