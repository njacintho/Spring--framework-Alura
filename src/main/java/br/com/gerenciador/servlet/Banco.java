package br.com.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	 private static List<Empresa> lista = new ArrayList<Empresa>();
	 
	 //carrega uma lista logo quando inicia o servidor 
	 static {
		 Empresa empresa = new Empresa();
		 empresa.setNome("Elo");
		 Empresa empresa2 = new Empresa();
		 empresa2.setNome("Alura");
		 lista.add(empresa);
		 lista.add(empresa2);
	 }
	
	 public void adiciona(Empresa empresa) {
		Banco.lista.add(empresa);

	}
	 
	 public List<Empresa> getEmpresas() {
		return Banco.lista;

	}


	
	
	
	
}
