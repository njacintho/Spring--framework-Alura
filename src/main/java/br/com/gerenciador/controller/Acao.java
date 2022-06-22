package br.com.gerenciador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Tem que ser cirada dentro do pacote que ira procurar as classes 
 * 
 */
public interface Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
