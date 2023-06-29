package jp.co.aforce.updatetransition;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.MemberBean;
import jp.co.aforce.dao.MemberDao;

/**
 * Servlet implementation class Update3
 */
@WebServlet("/views/update3")
public class Update3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update3() {
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
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		try {
			String origin_id =request.getParameter("origin_id");	
			String member_id =request.getParameter("member_id");
			String password =request.getParameter("password");
			String member_name =request.getParameter("member_name");
			String home_address =request.getParameter("home_address");
			int birth_year = Integer.parseInt(request.getParameter("birth_year"));
			int birth_month = Integer.parseInt(request.getParameter("birth_month"));
			int birth_day  = Integer.parseInt(request.getParameter("birth_day"));
			String job = request.getParameter("job");
			String phone_number = request.getParameter("phone_number");
			String mail_address =request.getParameter("mail_address");
		
        MemberBean p = new MemberBean();
		
		p.setMember_id(member_id);
		p.setPassword(password);
		p.setMember_name(member_name);
		p.setHome_address(home_address);
		p.setBirth_year(birth_year);
		p.setBirth_month(birth_month);
		p.setBirth_day(birth_day);
		p.setJob(job);
		p.setPhone_number(phone_number);
		p.setMail_address(mail_address);
	    MemberDao memberDao = new MemberDao();
		int line = memberDao.updateMember(p,origin_id);
		
		if(line > 0) {
			session.setAttribute("member", p);
			request.getRequestDispatcher("update_success.jsp").forward(request,response);
		}else {
		    out.println("登録できませんでした。");
		}
		
		
		}catch (Exception e) {
			// TODO 自動生成された catch ブロック
			out.println(e.toString());
		}
	}

}
