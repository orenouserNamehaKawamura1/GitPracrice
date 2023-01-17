package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.AccountRegister;

/**
 * Servlet implementation class Kadai01RegisterConfirmServlet
 */
@WebServlet("/Kadai01RegisterConfirmServlet")
public class Kadai01RegisterConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kadai01RegisterConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("NAME");
		String agestr = request.getParameter("AGE");
		int age = Integer.parseInt(agestr);
		String gen = request.getParameter("GENDER");
		String gender = gen.equals("0") ? "男性" : "女性";
		String tel = request.getParameter("TEL");
		String mail = request.getParameter("MAILADRESS");
		String pw = request.getParameter("PW");
		
		AccountRegister account = new AccountRegister(-1,name,age,gender,tel,mail,pw,null,null);
		
		
		
		HttpSession session = request.getSession();
		session.setAttribute("data", account);
		
		
		
		String view = "WEB-INF/view/Kadai01Confirm.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
