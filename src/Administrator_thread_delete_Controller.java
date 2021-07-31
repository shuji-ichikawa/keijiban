package keijiban;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Administrator_thread_delete_Controller
 */
@WebServlet("/Administrator_thread_delete_Controller")
public class Administrator_thread_delete_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Administrator_thread_delete_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
//		HttpSession session = request.getSession();
//		ArrayList<newthreadBean> newthreadlist = new ArrayList<newthreadBean>();
		int thread_id = Integer.parseInt(request.getParameter("thread_id"));
		newthreadBean.deletelist(thread_id);
//		newthreadlist = newthreadBean.selectList(thread_id);
//		session.setAttribute("newthreadlist", newthreadlist);
		response.sendRedirect("/keijiban/jsp/Administrator_threadList.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
