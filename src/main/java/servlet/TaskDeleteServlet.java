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
		HttpSession session = request.getSession();
		TaskDeleteDAO dao = new TaskDeleteDAO();
		
		// 削除するtaskId
		String[] taskIdArray = request.getParameterValues("taskId");
		//削除結果
		boolean deleted = false;
		
		// 削除実行
		try {
			for(String id : taskIdArray) {
				dao.deleteTask(Integer.parseInt(id));
			}
		}
		catch(SQLException|ClassNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("deleteConfirm.jsp");
		rd.forward(request, response);
	}

	
}
