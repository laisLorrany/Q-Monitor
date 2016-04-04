package br.edu.ifpb.Monitoria.Service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifpb.Monitoria.DAO.MonitorDAO;

/**
 * Servlet implementation class QuadroServlet
 */
@WebServlet("/quadroServlet")
public class QuadroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuadroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*
		 * Consulta do bd aqui
		 * */
		MonitorDAO monitor = new MonitorDAO();
		ArrayList<String> quadro = new ArrayList<String>();
		
		quadro = monitor.nomeMonitores();
		
		HttpSession session = request.getSession();
		session.setAttribute("quadro", quadro);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Quadro.jsp");
		dispatcher.forward(request, response);
		
	}

}
