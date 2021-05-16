package controlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import Entities.credentialsC;
import dao.CredentialsDAO;

/**
 * Servlet implementation class loginControlers
 */
@WebServlet("/LoginControlers")
public class LoginControlers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public LoginControlers() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String tlogin = request.getParameter("tlogin");
		String tpassword = request.getParameter("tpassword");

		credentialsC cr = CredentialsDAO.checkcrdentials(tlogin, tpassword);

		if (cr != null) {

			HttpSession ss = request.getSession();
			ss.setAttribute("cred", cr);
			response.sendRedirect("index.jsp");
		} else {

			request.setAttribute("ERROR", "Login ou Mot de passe incorrecte");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		

	}

}
