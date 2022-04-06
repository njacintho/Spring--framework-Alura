package br.com.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/alterarEmpresa")
public class AlterarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ALterando empresa");
		
		String nomeEmpresa = request.getParameter("nome");
		String dataAberEmpresa = request.getParameter("data");
		String paramid = request.getParameter("id");
		Integer id = Integer.valueOf(paramid);
		
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(dataAberEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		System.out.println(id);
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaId(id);
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		response.sendRedirect("listaEmpresa");
	}

}
