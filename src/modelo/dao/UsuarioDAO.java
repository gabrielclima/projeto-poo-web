package modelo.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import modelo.dominio.Filme;
import modelo.dominio.Usuario;

public class UsuarioDAO {
	
	private static ArrayList<Usuario> lista = new ArrayList<Usuario>();
	
	static
	{
		lerArquivo();
	}
	
	@SuppressWarnings("unchecked")
	private static void lerArquivo()
	{
		try {
			FileInputStream arquivo = new FileInputStream("usuarios.obj");
			ObjectInputStream obj = new ObjectInputStream(arquivo);
			lista = (ArrayList<Usuario>) obj.readObject();
			obj.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void salvarArquivo()
	{
		try {
			FileOutputStream arquivo = new FileOutputStream("usuarios.obj");
			ObjectOutputStream obj = new ObjectOutputStream(arquivo);
			obj.writeObject(lista);
			obj.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void incluir(Usuario usuario)
	{
		lista.add(usuario);
		salvarArquivo();
	}
	
	public void alterar(Usuario usuario)
	{
		String login = usuario.getLogin();
		Usuario gravado = this.obter(login);
		if (gravado == null){
			lista.add(usuario);
		}else{
			lista.remove(gravado);
			lista.add(usuario);
		}
		salvarArquivo();
	}

	
	public void excluir(Usuario usuario)
	{
		lista.remove(usuario);
		salvarArquivo();
	}
	
	public Usuario obter(String login)
	{
		for (Usuario usuario : lista) {
			if (usuario.getLogin().equals(login))
				return usuario;
		}
		return null;
	}
	
	public List<Usuario> listar() {
		return lista;
	}

}
