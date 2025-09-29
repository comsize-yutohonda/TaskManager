package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.TaskDAO;
import model.entity.TaskBean; 

/**
 * Servlet implementation class TaskRegistrationServlet
 */
@WebServlet("/task-register-servlet")
public class TaskRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskRegistrationServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		
		
		
		// ログインの確認 ログインしていない場合ログイン画面に遷移する
        HttpSession session = request.getSession();
        /*
        UserBean loginUserBean = (UserBean)session.getAttribute("LoginUserBean");
        if(loginUserBean == null) {
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
		*/


		
		try {
			
			//リクエスト受取
			
			request.setCharacterEncoding("UTF-8");
			
			String taskName = request.getParameter("taskName");
			String categoryName = request.getParameter("categoryName");
			String limit = request.getParameter("limit");
			String userName = request.getParameter("userName");
			String statusName = request.getParameter("statusName");
			String memo = request.getParameter("memo");
		
			
            	
			//DAOに接続
			TaskDAO dao = new TaskDAO();
						
			
			//カテゴリ名からカテゴリIDを取得			
			int categoryId = dao.categoryId(categoryName);

			
			//ユーザ名からユーザIDを取得
			String userId = dao.userId(userName);
			
			
			//ステータス名からステータスコードを取得
			String statusCode = dao.statusCode(statusName);
			
			
		
			
			Date limitDate = null;
			
			String url = null;
			
			TaskBean bean = new TaskBean();
			
			int count ;
			
			
			if(limit.isEmpty()) {
				
				limitDate = null;
				
				bean.setTaskName(taskName);
				bean.setCategoryId(categoryId);
				bean.setLimitDate(limitDate);
				bean.setUserId(userId);
				bean.setStatusCode(statusCode);
				bean.setMemo(memo);
				
				count = dao.insert(bean);
				
				//遷移
					
				if(count==1) {
					
					url = "task-registration-success.jsp";
	
					
				}else {
					
					url = "task-registration-error.jsp";
				}


				
			}else {
				
				//期限の日付をDATA型に変換
				limitDate = Date.valueOf(limit);

				//受け取った期限をString型→LocalDate型に
				LocalDate ld1 = LocalDate.parse(limit);

				//今日の期限の設定
				LocalDate ld2 = LocalDate.now();
				
				
				if(ld1.isBefore(ld2)) {
					
					//指定した期限が今日以前なら失敗に遷移
					
					url = "task-registration-error.jsp";
					
					
				}else {
				
					//指定した期限が今日以降なら登録する
					
					//TaskBeanに登録する情報を詰める
					
					bean.setTaskName(taskName);
					bean.setCategoryId(categoryId);
					bean.setLimitDate(limitDate);
					bean.setUserId(userId);
					bean.setStatusCode(statusCode);
					bean.setMemo(memo);
					
					count = dao.insert(bean);
					

					//遷移
					
					if(count==1) {
						
						url = "task-registration-success.jsp";
		
						
					}else {
						
						url = "task-registration-error.jsp";
					}
				}
				
			}
			//セッション設定
			
			session.setAttribute("taskName",taskName);
			session.setAttribute("categoryName", categoryName);
			session.setAttribute("limit", limit);
			session.setAttribute("userName",userName);
			session.setAttribute("statusName",statusName);
			session.setAttribute("memo", memo);

			
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
			
		
			
			
		} catch (ClassNotFoundException | SQLException  e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		
			RequestDispatcher rd = request.getRequestDispatcher("task-registration-error.jsp");
			rd.forward(request, response);
			
		}
	}
}
