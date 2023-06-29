package jp.co.aforce.cart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.ItemBean;

/**
 * Servlet implementation class CartAdd
 */
@WebServlet("/views/cartgetreduce")
public class CartGetReduce extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartGetReduce() {
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
		String item_name = request.getParameter("item_name");
		int price = Integer.parseInt(request.getParameter("price"));
		int item_id = Integer.parseInt(request.getParameter("item_id"));
		
		HttpSession session = request.getSession();
		
		List<ItemBean> cart = (List<ItemBean>)session.getAttribute("cart");
		int n = 0;
		
		if(cart == null || cart.size() == 0) {
			cart = new ArrayList<ItemBean>();
			ItemBean i = new ItemBean();
			i.setItem_name(item_name);
			i.setPrice(price);
			i.setItem_id(item_id);
			i.setCount(1);
			cart.add(i);	
			session.setAttribute("cart", cart);
			
			System.out.println("商品を追加しました");
			
			request.getRequestDispatcher("cart-get.jsp").forward(request,response);
		}else {
			
		
		
	
		for(ItemBean i : cart) {
			if(i.getItem_name().equals(item_name)) {
			n++;
			if(i.getCount() > 1) {
			i.setCount(i.getCount()-1);
			break;
			}else {
				break;
			}
			}
		}
		    if(n == 0) {
		    ItemBean i = new ItemBean();
		
			i.setItem_name(item_name);
			i.setPrice(price);
			i.setItem_id(item_id);
			i.setCount(1);
			cart.add(i);	
			session.setAttribute("cart", cart);
			
			System.out.println("商品を追加しました");
			
			request.getRequestDispatcher("cart-get.jsp").forward(request,response);
		    }else {
		    	
		    request.getRequestDispatcher("cart-get.jsp").forward(request,response);
		    	
		    }
		}
		
	}
		

}
