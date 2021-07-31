package keijiban;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class newthread_Controller
 */
@WebServlet("/newthread_Controller")
public class newthread_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public newthread_Controller() {
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
		response.sendRedirect("jsp/keijiban.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		ArrayList<newthreadBean> newthreadlist = new ArrayList<newthreadBean>();
		String Path = null;

		try{
			String title = request.getParameter("title");
			String name = request.getParameter("name");
			String contents = request.getParameter("contents");
			boolean check = false;

			if(title.length() == 0) {
				String msg1 = "・タイトルが入力されていません。";
				request.setAttribute("msg1", msg1);
				check = true;
			}

			if(name.length() == 0) {
				String msg2 = "・名前が入力されていません。";
				request.setAttribute("msg2", msg2);
				check = true;
			}

			if(contents.length() == 0) {
				String msg3 = "・本文が入力されていません。";
				request.setAttribute("msg3", msg3);
				check = true;
			}

			if(check) {
				Path = "/jsp/newthread.jsp";
			}else {
				newthreadBean newthreadbean = new newthreadBean();
				newthreadbean.setTitle(title);
				newthreadbean.setName(name);
				newthreadbean.setContents(contents);
				newthreadlist.add(newthreadbean);
				newthreadBean.insertData(newthreadlist);
				newthreadlist = newthreadBean.selectAllList();
				session.setAttribute("newthreadlist", newthreadlist);
				Path = "/jsp/newthreaddone.jsp";
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher(Path);
		dispatcher.forward(request, response);
	}
}
