package br.com.gerenciador.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;

public class MostraEmpresas implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("mostrando dados da empresas");
		
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		System.out.println(id);

		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaId(id);
		
		request.setAttribute("empresa", empresa);
		
		return "forward:formAlteraEmpresa.jsp";
		
//		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
//		
//		rd.forward(request, response);
		
	}

}
