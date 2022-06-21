package br.com.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;

public class AlterarEmpresas {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
		String nomeEmpresa = request.getParameter("nome");
		String dataAberEmpresa = request.getParameter("data");
		String paramid = request.getParameter("id");
		Integer id = Integer.valueOf(paramid);
		
		System.out.println("ALterando empresa em acao" + id);
		
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(dataAberEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
	
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaId(id);
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		return "redirect:entrada?acao=ListaEmpresas";
		
//		response.sendRedirect("entrada?acao=ListaEmpresas");
		
		//Obs: necessario mudoficar o form --> formAlteraEmpresa.jsp
		//e apontar para essa classe 
	}
}
