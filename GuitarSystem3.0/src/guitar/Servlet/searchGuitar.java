package guitar.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
import guitar.Model.Inventory;

/**
 * Servlet implementation class searchGuitar
 */
@WebServlet("/searchGuitar")
public class searchGuitar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchGuitar() {
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
		   String builder=request.getParameter("builder");
		   String model=request.getParameter("model");
		   String type=request.getParameter("type");
		   String backWood=request.getParameter("backWood");
	       String topWood=request.getParameter("topWood");
	       //参数构成的吉他对象
		    Guitar guitar1 = new Guitar();
			GuitarSpec spec1 = new GuitarSpec();
		   if(builder!=null&&!builder.equals("")){
			   System.out.print("builder");
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
			Inventory inventory = new Inventory();
			
			
		   try{
			 GuitarIDao guitar=new GuitarIDaoImpl();
			 List guitars = guitar.findAll();
			 List gt= new ArrayList();
			for (int i = 0; i < guitars.size(); i++) {
				Guitar guitar2 = new Guitar();
				GuitarSpec spec2= new GuitarSpec();
				spec2.setBuilder(Builder.valueOf(((Guitar) guitars.get(i)).getSpec().getBuilder().toString()));
				spec2.setBackWood(Wood.valueOf(((Guitar) guitars.get(i)).getSpec().getBackWood().toString()));
				spec2.setTopWood(Wood.valueOf(((Guitar) guitars.get(i)).getSpec().getTopWood().toString()));
				spec2.setModel(((Guitar) guitars.get(i)).getSpec().getModel());
				spec2.setType(Type.valueOf(((Guitar) guitars.get(i)).getSpec().getType().toString()));
				guitar2.setPrice(((Guitar) guitars.get(i)).getPrice());
				guitar2.setSerialNumber(((Guitar) guitars.get(i)).getSerialNumber());
				
				guitar2.setGuitarSpec(spec2);
				gt.add(guitar2);
			}
			inventory.setGuitar(gt);
			inventory.search(guitar1);
			inventory.setGuitar(inventory.search(guitar1));
		    request.setAttribute("result", inventory);
		    request.getRequestDispatcher("guitar.jsp").forward(request, response);
		   }
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
