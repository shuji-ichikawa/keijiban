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
 * Servlet implementation class replyContents_Controller
 */
@WebServlet("/replyContents_Controller")
public class replyContents_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public replyContents_Controller() {
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
		int thread_id = (Integer)session.getAttribute("thread_id");
		int No = Integer.parseInt(request.getParameter("No"));
		String reply_id = request.getParameter("reply_id");
		String name = request.getParameter("name");
		String contents = request.getParameter("contents");
		String time = request.getParameter("time");
		session.setAttribute("No", No);
		session.setAttribute("reply_id", reply_id);
		session.setAttribute("name", name);
		session.setAttribute("contents", contents);
		session.setAttribute("time", time);

		int No2 = Integer.parseInt(reply_id.replace("＞＞",""));
		session.setAttribute("No2", No2);
		List<ResBean> replylist = ResBean.selectAllList2(thread_id, No2);
		session.setAttribute("replylist", replylist);
		response.sendRedirect("/keijiban/jsp/replyContents.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int thread_id = (Integer)session.getAttribute("thread_id");
		int No = Integer.parseInt(request.getParameter("No"));
		String reply_id = request.getParameter("reply_id");
		String name = request.getParameter("name");
		String contents = request.getParameter("contents");
		String path = null;
        boolean check = false;

        if(name.length() == 0) {
			String msgname1 = "・名前が入力されていません。";
			request.setAttribute("msgname1", msgname1);
			check = true;
        }
        if(name.length() > 30) {
			String msgname2 = "・30文字以内で入力してください。";
			request.setAttribute("msgname2", msgname2);
			check = true;
        }
		if(contents.length() == 0) {
			String msgcontents = "・内容が入力されていません。";
			request.setAttribute("msgcontents", msgcontents);
			check = true;
		}

		if(reply_id == null) {
			reply_id = " ";
		}

		if(check) {
			path = "/jsp/keijiban.jsp";
		}else{
			ResBean resbean = new ResBean();
			resbean.setThread_id(thread_id);
			resbean.setNo(No);
			resbean.setReply_id(reply_id);
			resbean.setName(name);
			resbean.setContents(contents);
			ResBean.insertData(resbean);
			List<ResBean> reslist = ResBean.selectAllList(thread_id);
			session.setAttribute("reslist", reslist);
			path = "/jsp/keijiban.jsp";
		}
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
