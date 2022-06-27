package br.com.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<Empresa>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();
	private static Integer chavesequencial = 1;

	// carrega uma lista logo quando inicia o servidor
	static {
		Empresa empresa = new Empresa();
		empresa.setId(chavesequencial++);
		empresa.setNome("Elo");

		Empresa empresa2 = new Empresa();
		empresa2.setId(chavesequencial++);
		empresa2.setNome("Alura");

		lista.add(empresa);
		lista.add(empresa2);

		Usuario u1 = new Usuario();
		u1.setLogin("nico");
		u1.setSenha("12345");

		Usuario u2 = new Usuario();
		u2.setLogin("ana");
		u2.setSenha("12345");

		listaUsuarios.add(u1);
		listaUsuarios.add(u2);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chavesequencial++);
		Banco.lista.add(empresa);

	}

	public List<Empresa> getEmpresas() {
		return Banco.lista;

	}

	public void removerEmpresas(Integer id) {

		// No lugar do For no while --> enquanto houver o proximo remover caso o getId
		// ofr igual ao id
		Iterator<Empresa> it = lista.iterator();

		while (it.hasNext()) {
			Empresa emp = it.next();
			if (emp.getId() == id) {
				it.remove();
			}
		}

	}

	public Empresa buscaEmpresaId(Integer id) {

		for (Empresa empresa : lista) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {

		for (Usuario usuario : listaUsuarios) {
			if (usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}

//	
//	for (Usuario usuario : listaUsuarios) {
//		if(usuario.Ehilgual(login, senha)) {
//			return usuario;
//		}
//	}

}
