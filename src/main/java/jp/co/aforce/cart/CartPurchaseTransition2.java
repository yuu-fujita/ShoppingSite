package jp.co.aforce.cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.HistoryBean;
import jp.co.aforce.bean.ItemBean;
import jp.co.aforce.bean.MemberBean;
import jp.co.aforce.dao.HistoryDAO;
import jp.co.aforce.dao.ItemDao;
/**
 * Servlet implementation class CartPurchaseTransition2
 */
@WebServlet("/views/cartpurchasetransition2")
public class CartPurchaseTransition2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartPurchaseTransition2() {
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
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		//カート情報
		List<ItemBean> cartItems = (List<ItemBean>) request.getSession().getAttribute("cart");
		if (cartItems == null || cartItems.isEmpty()) {
			response.getWriter().println("カートに商品がありません。");
		} else {
			//ユーザー情報の取得
			MemberBean member = (MemberBean) request.getSession().getAttribute("member");
			String memberId = member.getMember_id();
			//購入処理
			HistoryDAO historyDAO = new HistoryDAO();
			try {
				for (ItemBean item : cartItems) {
					int itemId = item.getItem_id();
					int count = item.getCount();
					int totalPrice = item.getTotal_price();
					// 購入履歴の保存
					HistoryBean p = new HistoryBean();
					p.setMember_id(memberId);
					p.setItem_id(itemId);
					p.setCount(count);
					p.setTotal_price(totalPrice);
					historyDAO.insert(p, cartItems);
				}
			//ストック減らす処理
				for(ItemBean i : cartItems) {
					int itemId = i.getItem_id();
					int count = i.getCount();
					int stock = i.getStock();
					
				ItemDao dao = new ItemDao();
				int line = dao.updateStock(itemId, count, stock);
				if(line > 0) {
				System.out.println("在庫管理に成功しました");
				}else {
				System.out.println("在庫管理に失敗しました");
				}
				}
				//カートの中身を全て削除
				HttpSession session = request.getSession();
				session.removeAttribute("cart");
				//購入完了画面へ
				request.getRequestDispatcher("cartpurchasesend.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				//例外
				response.getWriter().println("購入に失敗しました。");
			}
		}
	}
}







