package br.com.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.gerenciador.controller.Acao;

/**
 * Servlet Filter implementation class AutorizacaoFilter filtros não tem ordem, para odena-los necessario ordenar pelo xml.
 */
//@WebFilter("/entrada")
public class ControllerFilter extends HttpFilter implements Filter {
       


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
	
		System.out.println("Controlador filter");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		 
		String parametroAcao = request.getParameter("acao");
		

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

	}

}
