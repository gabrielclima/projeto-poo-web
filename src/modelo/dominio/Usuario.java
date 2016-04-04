package modelo.dominio;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static int proxId = 0;
	
	private int id;
	private String login;
	private String senha;
	private String nome;
	private String cpf;
	private Date dataNascimento;
	private boolean admin;

	public Usuario() {
		super();
	}

	public Usuario(String login, String senha, String nome, String cpf, Date dataNascimento) {
		super();
		this.id = ++proxId;
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Usuario [login=" + login + ", senha=" + senha + ", nome="
				+ nome + "]";
	}

	public boolean verificaSenha(String senhaDigitada) {
		if (senhaDigitada.equals("123")) {
			return true;
		}
		else
			return false;
	}
	
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}








