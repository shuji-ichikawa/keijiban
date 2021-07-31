package keijiban;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Administrator_Login_Controller
 */
@WebServlet("/Administrator_Login_Controller")
public class Administrator_Login_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Administrator_Login_Controller() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		try {
			AdministratorBean adminbean = new AdministratorBean();
			String msg;
			HttpSession session = request.getSession();
			adminbean.setID(request.getParameter("ID"));
			adminbean.setPass(request.getParameter("pass"));
			Pattern p1 = Pattern.compile("^([a-zA-Z0-9]{4,30})$");
			Matcher m1 = p1.matcher(adminbean.getID());
			Matcher m2 = p1.matcher(adminbean.getPass());
			if (m1.find() && m2.find() && AdministratorBean.CheckAdminPass(adminbean.getID(),adminbean.getPass())) {
				ServletContext context = getServletContext();
				ArrayList<newthreadBean> newthreadlist = newthreadBean.selectAllList();
				session.setAttribute("newthreadlist", newthreadlist);
				RequestDispatcher rd = context.getRequestDispatcher("/jsp/Administrator_threadList.jsp");
				rd.forward(request, response);
			} else {
				msg = "入力値が違います";
				request.setAttribute("msg", msg);
				ServletContext context = getServletContext();
				RequestDispatcher rd = context.getRequestDispatcher("/jsp/Administrator_Login.jsp");
				rd.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
