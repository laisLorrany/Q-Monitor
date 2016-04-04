package br.edu.ifpb.Monitoria.Service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
import javax.servlet.RequestDispatcher;

import br.edu.ifpb.Monitoria.DAO.*;
import br.edu.ifpb.Monitoria.Entidades.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioDAO usuario = new UsuarioDAO();
		Usuario user = new Usuario();
		String home = null;
		
		//home = new String("boasVindas.jsp");
		//Recuperando valores do formulário
		user.setLogin(request.getParameter("nome"));
		user.setSenha(request.getParameter("senha"));

		// Validação do Usuário admin no BD
		
		if(usuario.consultaUser(user)){
			HttpSession session = request.getSession();
			session.setAttribute("nome", user.getLogin());
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("index.html");
		}
				
		
	}

}
