package modelo.dominio;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Filme implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private static int proxRegistro = 0;
	
	private int registro;
	private String nomeFilme;
	private String descricao;

	private Date dataLancamento;
	private String categoria;
	
	public Filme(String nomeFilme, String descricao, Date dataLancamento, String categoria) {
		super();
		this.registro = ++proxRegistro;
		this.nomeFilme = nomeFilme;
		this.descricao = descricao;
		this.dataLancamento = dataLancamento;
		this.categoria = categoria;
	}
	
	public int getRegistro() {
		return registro;
	}
	
	public void setRegistro(int registro) {
		this.registro = registro;
	}
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Filme(){
		super();
	}

	public String getNomeFilme() {
		return nomeFilme;
	}

	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	
	public String getDataFormatada() {
		if (this.dataLancamento == null)
			return "";
		
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = formatador.format(this.dataLancamento);
		return dataFormatada;
	}
}
