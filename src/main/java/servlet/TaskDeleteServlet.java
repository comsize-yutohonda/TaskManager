package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.TaskDeleteDAO;
import model.entity.TaskDisplayBean;
import model.entity.UserBean;

/**
 * Servlet implementation class Taski
 */
@WebServlet("/task-delete-servlet")
public class TaskDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskDeleteServlet() {
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
		
		TaskDeleteDAO dao = new TaskDeleteDAO();
		
		// 削除するタスクのビーンを取得
		TaskDisplayBean deleteBean = (TaskDisplayBean)session.getAttribute("deleteBean");
		//削除結果
		boolean deleted = false;
		
		
		// 削除実行
		try {
			// 削除するタスクがログインユーザー本人のタスクのときのみ削除を行う
			if(deleteBean.getUserId().equals(loginUserBean.getUserId()))
			{
				deleted = dao.deleteTask(deleteBean.getTaskId());
			}
			
		}
		catch(SQLException|ClassNotFoundException|NullPointerException e) {
			System.out.println(e);
			e.printStackTrace();
		}
			
		// 削除結果により転送先を分岐
		String path;
		if(deleted) {
			path = "deleted.jsp"; 
		}
		else {
			path = "deleteError.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	
}
