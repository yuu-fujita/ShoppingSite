package jp.co.aforce.cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.ItemBean;

/**
 * Servlet implementation class CartRemoveAction
 */
@WebServlet("/views/cartremoveaction")
public class CartRemoveAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartRemoveAction() {
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
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session = request.getSession();
		
		int item_id = Integer.parseInt(request.getParameter("item_id"));
		
		List<ItemBean> cart = (List<ItemBean>)session.getAttribute("cart");
	
		for(ItemBean i : cart) {
			if(i.getItem_id() == item_id) {
				cart.remove(i);
				break;
			}
		}

		if(cart == null || cart.size() == 0) {
			request.getRequestDispatcher("cart-null.jsp").forward(request,response);
		} else {
			request.getRequestDispatcher("cart-get.jsp").forward(request,response);
		}
	
	}

}
