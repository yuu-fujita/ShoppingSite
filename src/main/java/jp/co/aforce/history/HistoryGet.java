package jp.co.aforce.history;

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
import jp.co.aforce.dao.HistoryDAO;

/**
 * Servlet implementation class ItemSearch
 */
@WebServlet("/views/historyget")
public class HistoryGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryGet() {
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
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session = request.getSession();
		
		HistoryDAO dao = new HistoryDAO();
		MemberBean member = (MemberBean)session.getAttribute("member");
		String member_id = member.getMember_id();

		List<ItemBean> list;
		try {
			list = dao.getHistoryList(member_id);
			if(list != null && list.size() != 0) {
			session.setAttribute("list", list);
			request.getRequestDispatcher("history_view.jsp").forward(request,response);
			} else if(list == null || list.size() == 0){
				request.getRequestDispatcher("history_null.jsp").forward(request,response);
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}	
	}
}
