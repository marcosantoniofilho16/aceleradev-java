package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Jogador extends Identificador {
	
	private Long idTime;
	
	private LocalDate dataNascimento;
	
	private Integer nivelHabilidade;
	
	private BigDecimal salario;
	
	private Boolean capitao;

	public Jogador(Long id, String nome, Long idTime, LocalDate dataNascimento, Integer nivelHabilidade,
			BigDecimal salario) {
		super(id, nome);
		this.idTime = idTime;
		this.dataNascimento = dataNascimento;
		this.nivelHabilidade = nivelHabilidade;
		this.salario = salario;
		this.capitao = false;
	}

	public Long getIdTime() {
		return idTime;
	}

	public void setIdTime(Long idTime) {
		this.idTime = idTime;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getNivelHabilidade() {
		return nivelHabilidade;
	}

	public void setNivelHabilidade(Integer nivelHabilidade) {
		this.nivelHabilidade = nivelHabilidade;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Boolean isCapitao() {
		return capitao;
	}

	public void setCapitao(Boolean capitao) {
		this.capitao = capitao;
	}

	@Override
	public String toString() {
		return "Jogador [idTime=" + idTime + ", dataNascimento=" + dataNascimento + ", nivelHabilidade="
				+ nivelHabilidade + ", salario=" + salario + ", capitao=" + capitao + ", id=" + getId() +  "]\n";
	}

}
