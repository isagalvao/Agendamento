package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/inserir", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans agendamento = new JavaBeans();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			agendamentos(request, response);
		}  else if (action.equals("/inserir")) {
			novoAgendamento(request, response);
		} else if (action.equals("/delete")) {
			removerAgendamento(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// listagem de agendamentos
	protected void agendamentos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// objeto com os dados do JavaBeans
		ArrayList<JavaBeans> lista = dao.listarAgendamentos();
		// encaminhando a lista para o documento agendamento.jsp
		request.setAttribute("agendamento", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agendamento.jsp");
		rd.forward(request, response);

		// teste lista
		// for(int i = 0; i < lista.size(); i++) {
		// System.out.println(lista.get(i).getIdagendamento());
		// System.out.println(lista.get(i).getIdmorador());
		// System.out.println(lista.get(i).getData());
		// System.out.println(lista.get(i).getHora());
		// }

	}

	// novo agendamento
	protected void novoAgendamento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// teste form
		// System.out.println(request.getParameter("data"));
		// System.out.println(request.getParameter("hora"));
		// setar variáveis
		agendamento.setData(request.getParameter("data"));
		agendamento.setHora(request.getParameter("hora"));
		// invocar método inserirAgendamento
		dao.inserirAgendamento(agendamento);
		// redirecionando para a pagina inicial
		response.sendRedirect("main");
	}

	// remover agendamento
	protected void removerAgendamento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idagendamento = request.getParameter("idagendamento");
		// teste recebimento
		// System.out.println(idagendamento);
		// setando variavel idagendamento Javabeans
		agendamento.setIdagendamento(idagendamento);
		// executar metodo deletarAgendamento
		dao.deletarAgendamento(agendamento);
		// redirecionando para a pagina inicial
		response.sendRedirect("main");
	}

	

}
