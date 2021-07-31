package keijiban;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Administrator_newthread_Controller
 */
@WebServlet("/Administrator_newthread_Controller")
public class Administrator_newthread_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Administrator_newthread_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		ArrayList<newthreadBean> newthreadlist = new ArrayList<newthreadBean>();
		int thread_id = Integer.parseInt(request.getParameter("thread_id"));
		session.setAttribute("thread_id", thread_id);
		newthreadlist = newthreadBean.selectList(thread_id);
		session.setAttribute("newthreadlist1", newthreadlist);
		response.sendRedirect("jsp/Administrator_keijiban.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
