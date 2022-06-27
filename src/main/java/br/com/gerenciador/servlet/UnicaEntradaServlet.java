package br.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.gerenciador.controller.Acao;
import br.com.gerenciador.controller.AlterarEmpresas;
import br.com.gerenciador.controller.ListaEmpresas;
import br.com.gerenciador.controller.MostraEmpresas;
import br.com.gerenciador.controller.NovaEmpresa;
import br.com.gerenciador.controller.NovaEmpresaForm;
import br.com.gerenciador.controller.RemoveEmpresa;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String parametroAcao = request.getParameter("acao");
		
		HttpSession sessao = request.getSession();
		boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
		boolean acaoProtegida = !(parametroAcao.equals("Login") || parametroAcao.equals("LoginForm"));
		
		
		if(acaoProtegida && usuarioNaoEstaLogado) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}
		
		

		String nomeDaClasse = "br.com.gerenciador.controller." + parametroAcao;
		
		String nome;
		try {
			Class classe = Class.forName(nomeDaClasse); // carrega a classe com o nome da String
			Acao acao = (Acao)  classe.newInstance();   // cria a intancia da Acao já fazendo um cast pra interface
			nome = acao.executa(request,response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);		
		}
		
		String[] tipoEEndereco = nome.split(":");
		if (tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEEndereco[1]);
		}
		
//		parametroAcao.executa(req, res);
		
		
//		// Possuui a mesma a ação então pode ser criada uma interface 
//		String nome = null;
//		if (parametroAcao.equals("ListaEmpresas")) {
//
//			ListaEmpresas acao = new ListaEmpresas();
//			nome = acao.executa(request, response);
//
//		} else if (parametroAcao.equals("RemoveEmpresa")) {
//
//			RemoveEmpresa acao = new RemoveEmpresa();
//			nome = acao.executa(request, response);
//
//		} else if (parametroAcao.equals("MostraEmpresas")) {
//
//			MostraEmpresas acao = new MostraEmpresas();
//			nome = acao.executa(request, response);
//
//		} else if (parametroAcao.equals("NovaEmpresa")) {
//
//			NovaEmpresa acao = new NovaEmpresa();
//			nome = acao.executa(request, response);
//
//		} else if (parametroAcao.equals("AlterarEmpresas")) {
//
//			AlterarEmpresas acao = new AlterarEmpresas();
//			nome = acao.executa(request, response);
//			
//		} else if (parametroAcao.equals("NovaEmpresaForm")) {
//
//			NovaEmpresaForm acao = new NovaEmpresaForm();
//			nome = acao.executa(request, response);
//		}

//		String[] tipoEEndereco = nome.split(":");
//		if (tipoEEndereco[0].equals("forward")) {
//			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
//			rd.forward(request, response);
//		} else {
//			response.sendRedirect(tipoEEndereco[1]);
//		}

//		if(tipoEEndereco[0].equals("forward")) {
//			RequestDispatcher rd = request.getRequestDispatcher(tipoEEndereco[1]);
//			rd.forward(request, response);
//		}else {
//			response.sendRedirect(tipoEEndereco[1]);
//		}
	}

}
