package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entity.TaskDisplayBean;
import model.entity.UserBean;

/**
 * Servlet implementation class Taski
 */
@WebServlet("/task-delete-confirm-servlet")
public class TaskDeleteConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskDeleteConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		// ログインの確認 ログインしていない場合ログイン画面に遷移する
		HttpSession session = request.getSession();
		UserBean loginUserBean = (UserBean)session.getAttribute("LoginUserBean");
		if(loginUserBean == null) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
		//タスク一覧から遷移した場合,削除対象のビーンをセッションにセット
		String deleteId =request.getParameter("taskId");
		if(deleteId != null) {
			List<TaskDisplayBean> beanList = (ArrayList<TaskDisplayBean>)session.getAttribute("taskDisplayBeanList");
			for(TaskDisplayBean bean : beanList) {
				if(bean.getTaskId() == Integer.parseInt(deleteId)) {
					TaskDisplayBean deleteBean = bean;
					session.setAttribute("deleteBean", deleteBean);
				}
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("deleteConfirm.jsp");
		rd.forward(request, response);
	}

	
}
