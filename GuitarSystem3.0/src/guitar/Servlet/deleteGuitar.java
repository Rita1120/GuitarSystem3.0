package guitar.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guitar.IDao.GuitarIDao;
import guitar.IDaoImpl.GuitarIDaoImpl;

/**
 * Servlet implementation class deleteGuitar
 */
@WebServlet("/deleteGuitar")
public class deleteGuitar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteGuitar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String serialNumber=request.getParameter("serialNumber");
		boolean as = false;
		try {
			GuitarIDao guitar=new GuitarIDaoImpl();
			as = guitar.doDelete(serialNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
			if(as){
				response.sendRedirect("findGuitar.jsp?msg=1");
			}
			else{
				response.sendRedirect("findGuitar.jsp?msg=2");
			
			}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
