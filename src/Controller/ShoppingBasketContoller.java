package Controller;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.AddToCart;
import Model.ProductBean;
import Model.PurchaseProductBean;
import Model.RemoveFromCart;
import Model.ShoppingBasketDBInteractions;

/**
 * Servlet implementation class ShoppingBasketContoller
 */
@WebServlet("/ShoppingBasketContoller")
public class ShoppingBasketContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<Integer,ProductBean> productsHm = new HashMap<>();

    /**
     * Default constructor. 
     * 
     */
    public ShoppingBasketContoller() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    public void init(){
    	try {
			productsHm = new ShoppingBasketDBInteractions().getAllProductDetails();
			
			getServletContext().setAttribute("products", productsHm);
		} catch (SQLException | IOException |PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd=null;
		
		String checkAction=request.getParameter("submitButton");
		
		if(checkAction!=null)
		{
			if(checkAction.startsWith("Add")){
				
				 int count=AddToCart.execute(request,response);//To add product in session
				 request.setAttribute("quantity", count);
				 rd=request.getRequestDispatcher("view.jsp");
				 rd.forward(request, response);
				
			}
			else if(checkAction.startsWith("Remove") ){
				
				 String removedProductId=RemoveFromCart.execute(request, response);
				 request.setAttribute("removedProductId", removedProductId);
				 rd=request.getRequestDispatcher("view.jsp");
				 rd.forward(request, response);
			}
			else if(checkAction.startsWith("View")){
				 
				  rd=request.getRequestDispatcher("view.jsp");
				  rd.forward(request, response);
			
			}
		
		}//end of if 
		else{
			
			  int checkCheckout=Model.ConfirmedOrder.execute(request, response);
			  request.setAttribute("checkoutStatus", checkCheckout);
			  rd=request.getRequestDispatcher("checkout.jsp");
			  rd.forward(request, response);
			
		}
		
		
	}
	

}
