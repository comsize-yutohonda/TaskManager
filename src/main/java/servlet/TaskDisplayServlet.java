package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.TaskDisplayDAO;
import model.entity.TaskDisplayBean;
import model.entity.UserBean;

/**
 * Servlet implementation class Taski
 */
@WebServlet("/task-display-servlet")
public class TaskDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskDisplayServlet() {
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
		
		// 仮のログインユーザー
		UserBean userBean = new UserBean();
		userBean.setPassword("password");
		userBean.setUserId("honda");
		session.setAttribute("LoginUserBean", userBean);
		
		UserBean loginUserBean = (UserBean)session.getAttribute("LoginUserBean");
		if(loginUserBean == null) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
		// 全タスク情報を取得
		TaskDisplayDAO dao = new TaskDisplayDAO();
		List<TaskDisplayBean> beanList = null;
		try {
			beanList = dao.selectAllTask();
		}
		catch(SQLException|ClassNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		session.setAttribute("taskDisplayBeanList", beanList);
		RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
		rd.forward(request, response);
	}

	
}
