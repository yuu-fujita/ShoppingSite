package jp.co.aforce.favorite;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.MemberBean;
import jp.co.aforce.dao.FavoriteDAO;

/**
 * Servlet implementation class Favorite_add
 */
@WebServlet("/views/itemdetail/favorite_add")
public class Favorite_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Favorite_add() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		
		HttpSession session = request.getSession();
		
		MemberBean member = (MemberBean)session.getAttribute("member");
		
		FavoriteDAO fav = new FavoriteDAO();
		int line2;
		
		try {
			line2 = fav.registerSearch(member, id);
		
		if(line2 == 0) {
		
			if(member != null) {
			int line = fav.register(member, id);
			
			if(line > 0) {
				System.out.println("お気に入りに追加しました");
				request.getRequestDispatcher(id + ".jsp").forward(request, response);
			}
			}else {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else {
			System.out.println("既に追加されています");
			request.getRequestDispatcher(id +".jsp").forward(request, response);
		}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		
	}
}
