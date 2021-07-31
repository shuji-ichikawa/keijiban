package keijiban;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Administrator_keijiban_Controller
 */
@WebServlet("/Administrator_keijiban_Controller")
public class Administrator_keijiban_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Administrator_keijiban_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		try{
			HttpSession session = request.getSession();
			int thread_id = Integer.parseInt(request.getParameter("thread_id"));
			int No = Integer.parseInt(request.getParameter("No"));
			ResBean resmodel = new ResBean();
			resmodel.setThread_id(thread_id);
			resmodel.setNo(No);
			ResBean.deletelist(thread_id, No);
			List<ResBean> reslist = ResBean.selectAllList(thread_id);
			session.setAttribute("reslist", reslist);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/jsp/Administrator_keijiban.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
