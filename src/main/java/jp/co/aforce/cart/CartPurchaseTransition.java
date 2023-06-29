package jp.co.aforce.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartPurchase
 */
@WebServlet("/views/cartpurchasetransition")
public class CartPurchaseTransition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartPurchaseTransition() {
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
	//@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	//	HttpSession session = request.getSession();
		
//		List<MemberBean> cart2 = (List<MemberBean>)session.getAttribute("cart2");
//		if(cart2 == null) {
//			cart2 = new ArrayList<MemberBean>();
//		}
//		
//		MemberBean i = new MemberBean();
//		i.setMember_name(member_name);
//		i.setHome_address(home_address);
//		
//		session.setAttribute("cart2", cart2);
		
		request.getRequestDispatcher("cartpurchase.jsp").forward(request,response);
	}

}
