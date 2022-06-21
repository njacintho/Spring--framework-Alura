package br.com.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;

public class RemoveEmpresa {
	
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Removendo empresas");

		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		System.out.println(id);

		Banco banco = new Banco();
		banco.removerEmpresas(id);
		
		return "redirect:entrada?acao=ListaEmpresas";
		
		
//		response.sendRedirect("entrada?acao=ListaEmpresas");
	}

}
