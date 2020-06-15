package br.com.codenation;

import java.time.LocalDate;

public class Time extends Identificador {

	private LocalDate dataCriacao;

	private String corUniformePrincipal;

	private String corUniformeSecundario;
	
	public Time(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal,
			String corUniformeSecundario) {
		super(id, nome);
		this.dataCriacao = dataCriacao;
		this.corUniformePrincipal = corUniformePrincipal;
		this.corUniformeSecundario = corUniformeSecundario;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getCorUniformePrincipal() {
		return corUniformePrincipal;
	}

	public void setCorUniformePrincipal(String corUniformePrincipal) {
		this.corUniformePrincipal = corUniformePrincipal;
	}

	public String getCorUniformeSecundario() {
		return corUniformeSecundario;
	}

	public void setCorUniformeSecundario(String corUniformeSecundario) {
		this.corUniformeSecundario = corUniformeSecundario;
	}

	@Override
	public String toString() {
		return "Time [dataCriacao=" + dataCriacao + ", corUniformePrincipal=" + corUniformePrincipal
				+ ", corUniformeSecundario=" + corUniformeSecundario + ", id=" + getId() + ", nome="
				+ getNome() + "]\n";
	}

}
