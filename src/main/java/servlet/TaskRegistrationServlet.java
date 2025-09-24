package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		/*ログインセッションの確認
		
		HttpSession session = request.getSession();
		UserBean userBean = (UserBean)sesson.setAttribute("LoginUserBean");
		
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
		

		
			
			//期限の日付をDATA型に変換
			
            SimpleDateFormat limitFormat = new SimpleDateFormat("yyyy-MM-dd ");
            Date limitDate = limitFormat.parse(limit);

	
			//DAOに接続
			TaskDAO dao = new TaskDAO();
			
			
			//カテゴリ名からカテゴリIDを取得			
			int categoryId = dao.categoryId(categoryName);
			
			
			//ユーザ名からユーザIDを取得
			String userId = dao.userId(userName);
			
			
			//ステータス名からステータスコードを取得
			String statusCode = dao.statusCode(statusName);
			
			
			//現在日時を取得
			LocalDateTime nowDatetime = LocalDateTime.now();
			
			//現在日時→String型に
			DateTimeFormatter nowFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String formatNowDate = nowFormat.format(nowDatetime);
			
			//String型からDate型に
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date dateNowDate = dateFormat.parse(formatNowDate);
			
			//Date型からTimestamp型に		
			Timestamp createTime = new Timestamp(dateNowDate.getTime());
	
			
	
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter pw = response.getWriter();
			
			//レスポンスの書き出し
			pw.println("<!DOCTIPE html><html>");
			pw.println("<head><title>代金表示</title></head>");
			pw.println("<body>あ");
			pw.println(taskName+limitDate+memo+createTime);
			pw.println("</body>");
			pw.println("</html>");

			
			/*
			//TIMESTAMP型に変換
			DateTimeFormatter todayTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        LocalDateTime dateTime = LocalDateTime.parse(formatNowDate, todayTime);
	
	        Timestamp createDatetime = Timestamp.valueOf(dateTime);
	        */
			
			//TaskBeanに登録する情報を詰める
			
			TaskBean bean = new TaskBean();
			
			bean.setTaskName(taskName);
			bean.setCategoryId(categoryId);
			bean.setLimitDate(limitDate);
			bean.setUserId(userId);
			bean.setStatusCode(statusCode);
			bean.setMemo(memo);
			
			
		} catch (ClassNotFoundException | SQLException | ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
