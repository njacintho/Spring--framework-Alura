package br.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.acao.AlterarEmpresas;
import br.com.gerenciador.acao.ListaEmpresas;
import br.com.gerenciador.acao.MostraEmpresas;
import br.com.gerenciador.acao.NovaEmpresa;
import br.com.gerenciador.acao.NovaEmpresaForm;
import br.com.gerenciador.acao.RemoveEmpresa;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametroAcao = request.getParameter("acao");

		String nome = null;
		if (parametroAcao.equals("ListaEmpresas")) {

			ListaEmpresas acao = new ListaEmpresas();
			nome = acao.executa(request, response);

		} else if (parametroAcao.equals("RemoveEmpresa")) {

			RemoveEmpresa acao = new RemoveEmpresa();
			nome = acao.executa(request, response);

		} else if (parametroAcao.equals("MostraEmpresas")) {

			MostraEmpresas acao = new MostraEmpresas();
			nome = acao.executa(request, response);

		} else if (parametroAcao.equals("NovaEmpresa")) {

			NovaEmpresa acao = new NovaEmpresa();
			nome = acao.executa(request, response);

		} else if (parametroAcao.equals("AlterarEmpresas")) {

			AlterarEmpresas acao = new AlterarEmpresas();
			nome = acao.executa(request, response);
			
		} else if (parametroAcao.equals("NovaEmpresaForm")) {

			NovaEmpresaForm acao = new NovaEmpresaForm();
			nome = acao.executa(request, response);
		}

		String[] tipoEEndereco = nome.split(":");
		if (tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEEndereco[1]);
		}

//		if(tipoEEndereco[0].equals("forward")) {
//			RequestDispatcher rd = request.getRequestDispatcher(tipoEEndereco[1]);
//			rd.forward(request, response);
//		}else {
//			response.sendRedirect(tipoEEndereco[1]);
//		}
	}

}
