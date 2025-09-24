package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();
		//チェックボックスで選択されたタスクの配列をセッションで管理
		String[] taskIdArrayString = request.getParameterValues("taskId");
		int[] taskIdArray = new int[taskIdArrayString.length];
		for(int i = 0; i < taskIdArray.length; i++) {
			taskIdArray[i] = Integer.parseInt(taskIdArrayString[i]);
		}
		session.setAttribute("deleteIdArray", taskIdArray);
		RequestDispatcher rd = request.getRequestDispatcher("deleteConfirm.jsp");
		rd.forward(request, response);
	}

	
}
