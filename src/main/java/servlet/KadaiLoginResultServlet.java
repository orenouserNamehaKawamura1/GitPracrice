package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Kadaidao;
import dto.AccountRegister;
import util.GenerateHashedPw;

/**
 * Servlet implementation class KadaiLoginResultServlet
 */
@WebServlet("/KadaiLoginResultServlet")
public class KadaiLoginResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KadaiLoginResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.getParameter("UTF-8");
		
		String mail = request.getParameter("MAILADRESS");
		String pw = request.getParameter("PW");
		
		// 入力されたIDをもとにソルトを取得する。
		String salt = Kadaidao.getSalt(mail);
		
		// 取得したソルトがnullの場合は対象のユーザがいないので、Errorでログイン画面に戻す
		if(salt == null) {
			String view = "WEB-INF/view/LoginForm.jsp?error=1";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
			return;
		}
		
		// 取得したソルトを使って入力したPWをハッシュ
		String hashpw = GenerateHashedPw.getSafetyPassword(pw, salt);
		
		System.out.println("ログイン時のソルト"+salt);
		System.out.println("ログイン時のハッシュ"+hashpw);
		
		// 入力されたID、ハッシュしたPWに一致するユーザを検索する
		AccountRegister account = Kadaidao.login(mail, hashpw);
		
		// 一致するユーザがいなければ、ログイン失敗
		if(account == null) {
			String view = "WEB-INF/view/LoginForm.jsp?error=1";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		} else {
			String view = "WEB-INF/view/success.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
