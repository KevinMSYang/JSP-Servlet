package login_form.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login_form.model.Login;
import longin_form.dao.LoginDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDAO loginDAO;
	
	public void init()
	{
		loginDAO = new LoginDAO();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username = request.getParameter("username");
		String passowrd = request.getParameter("password");
		Login login = new Login();
		login.setUsername(username);
		login.setPassword(passowrd);
		
		try
		{
			if (loginDAO.validate(login))
			{
				response.sendRedirect("login-success.jsp");
			}
			else
			{
				HttpSession session = request.getSession();
				response.sendRedirect("login.jsp");
			}
		} catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}

}
