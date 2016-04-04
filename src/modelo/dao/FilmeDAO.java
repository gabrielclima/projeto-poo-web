package modelo.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import modelo.dominio.Filme;

public class FilmeDAO {
	
	private static ArrayList<Filme> lista = new ArrayList<Filme>();
	
	static
	{
		lerArquivo();
	}
	
	@SuppressWarnings("unchecked")
	private static void lerArquivo()
	{
		try {
			FileInputStream arquivo = new FileInputStream("lista.obj");
			ObjectInputStream obj = new ObjectInputStream(arquivo);
			lista = (ArrayList<Filme>) obj.readObject();
			obj.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void salvarArquivo()
	{
		try {
			FileOutputStream arquivo = new FileOutputStream("lista.obj");
			ObjectOutputStream obj = new ObjectOutputStream(arquivo);
			obj.writeObject(lista);
			obj.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void incluir(Filme filme)
	{
		lista.add(filme);
		salvarArquivo();
	}
	
	public void alterar(Filme filme)
	{
		String nomePesquisa = filme.getNomeFilme();
		Filme gravado = this.obter(nomePesquisa);
		if (gravado == null){
			lista.add(filme);
		}
		else{
			lista.remove(gravado);
			lista.add(filme);
		}
		salvarArquivo();
	}

	
	public void excluir(Filme filme)
	{
		lista.remove(filme);
		salvarArquivo();
	}
	
	public Filme obter(String nomeFilme)
	{
		for (Filme filme : lista) {
			if (filme.getNomeFilme().equals(nomeFilme))
				return filme;
		}
		return null;
	}
	
	public List<Filme> listar() {
		return lista;
	}

}
