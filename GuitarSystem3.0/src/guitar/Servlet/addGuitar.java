package guitar.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guitar.IDao.GuitarIDao;
import guitar.IDaoImpl.GuitarIDaoImpl;
import guitar.Model.Builder;
import guitar.Model.Guitar;
import guitar.Model.GuitarSpec;
import guitar.Model.Type;
import guitar.Model.Wood;

/**
 * Servlet implementation class addGuitar
 */
@WebServlet("/addGuitar")
public class addGuitar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addGuitar() {
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
		   response.setCharacterEncoding("utf-8");
		   request.setCharacterEncoding("utf-8");
		   String serialNumber=request.getParameter("serialNumber");
		   String builder=request.getParameter("builder");
		   String model=request.getParameter("model");
		   String type=request.getParameter("type");
		   String backWood=request.getParameter("backWood");
	       String topWood=request.getParameter("topWood");
	       
		   double price=0.0;
		
	        Guitar guitar1 = new Guitar();
			GuitarSpec spec1 = new GuitarSpec();
			  if(serialNumber!=null&&!serialNumber.equals("")){
				  guitar1.setSerialNumber(serialNumber);
			   }
			 if(!request.getParameter("price").equals("")){
					price=Double.parseDouble(request.getParameter("price"));
			        guitar1.setPrice(price);
			 }
			   
		   if(builder!=null&&!builder.equals("")){
			 //  System.out.print("builder");
			    spec1.setBuilder(Builder.valueOf(builder.toUpperCase()));
		   }
		   if(model!=null&&!model.equals("")){
			    spec1.setModel(model);
		   }
		   if(type!=null&&!type.equals("")){
			    spec1.setType(Type.valueOf(type.toUpperCase()));
		   }
		   if(backWood!=null&&!backWood.equals("")){
			    spec1.setBackWood(Wood.valueOf(backWood.toUpperCase()));
		   }
		   if(topWood!=null&&!topWood.equals("")){
			    spec1.setTopWood(Wood.valueOf(topWood.toUpperCase()));
		   }
		    guitar1.setGuitarSpec(spec1);
		    
		    boolean as = false;
			try {
				GuitarIDao gt =new GuitarIDaoImpl();
				as = gt.doCreate(guitar1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(as){		
				response.sendRedirect("addGuitar.jsp?msg=1");
			} else {
				response.sendRedirect("addGuitar.jsp?msg=2");
			}
	}

}
