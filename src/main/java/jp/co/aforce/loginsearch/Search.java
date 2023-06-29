package jp.co.aforce.loginsearch;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.MemberBean;
import jp.co.aforce.dao.MemberDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/views/search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		HttpSession session =request.getSession();
		session.removeAttribute("register");
		
        String member_id = request.getParameter("member_id");
        String password = request.getParameter("password");
		   
        MemberDao memberDao = new MemberDao();
	    MemberBean bean;
	   
		try {
			if(member_id.equals("admin") && password.equals("admin")) {
				request.getRequestDispatcher("admin_index.jsp").forward(request,response);
			} else {
			bean = memberDao.search(member_id, password);
			if(bean != null) {
				session.setAttribute("member", bean);
				request.getRequestDispatcher("itemsearch.jsp").forward(request,response);
			} else {
				request.setAttribute("error", "<h4>※IDまたはパスワードが間違っています</h4>");
				request.getRequestDispatcher("login.jsp").forward(request,response);			
			}
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		   
		
		
	}

}
