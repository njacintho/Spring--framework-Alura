package br.com.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	 private static List<Empresa> lista = new ArrayList<Empresa>();
	
	 public void adiciona(Empresa empresa) {
		lista.add(empresa);

	}
	 
	 private List<Empresa> getEmpresas() {
		return Banco.lista;

	}


	
	
	
	
}
