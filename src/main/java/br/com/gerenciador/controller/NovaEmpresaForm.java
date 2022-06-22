package br.com.gerenciador.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;

public class NovaEmpresaForm implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
		return "forward:formNovaEmpresa.jsp";
		
		//Redireciona para o Cliente site 
//		response.sendRedirect("entrada?acao=ListaEmpresas");
		
		//Obs: necessario mudoficar o form --> formNovaEmpresa.jsp
		//e apontar para essa classe 
		
	}
	
}
