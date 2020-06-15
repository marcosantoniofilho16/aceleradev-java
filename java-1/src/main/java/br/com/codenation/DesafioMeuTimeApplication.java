package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private List<Time> times = new ArrayList<Time>();

	private List<Jogador> jogadores = new ArrayList<Jogador>();

	private void checkIdUnicoExistente(Identificador identificador, List<? extends Identificador> identificadores) {
		if (identificador == null)
			throw new NullPointerException("O identificador é nulo");

		if (identificador.getId() == null)
			throw new NullPointerException("O id é nulo");

		if (identificador.getId().compareTo(1L) < 0)
			throw new IllegalArgumentException("O id é <= 0");

		if (identificadores.contains(identificador))
			throw new IdentificadorUtilizadoException("O identificador já existe");
	}

	private void checkIdUnicoNaoExistente(Identificador identificador, List<? extends Identificador> identificadores) {
		if (identificador == null)
			throw new NullPointerException("O identificador é nulo");

		if (identificador.getId() == null)
			throw new NullPointerException("O id é nulo");

		if (identificador.getId().compareTo(1L) < 0)
			throw new IllegalArgumentException("O id é <= 0");

		if (!identificadores.contains(identificador))
			throw new IdentificadorUtilizadoException("O identificador não existe");
	}

	private void checkTimeNaoExistente(Long idTime) {
		if (idTime == null)
			throw new NullPointerException("O idTime é nulo");

		if (idTime.compareTo(1L) < 0)
			throw new IllegalArgumentException("O idTime é <= 0");

		try {
			checkIdUnicoNaoExistente(new Identificador(idTime), times);
		} catch (IdentificadorUtilizadoException e) {
			throw new TimeNaoEncontradoException("O time não foi encontrado");
		}
	}

	private void checkJogadorNaoExistente(Long idJogador) {
		if (idJogador == null)
			throw new NullPointerException("O idJogador é nulo");

		if (idJogador.compareTo(1L) < 0)
			throw new IllegalArgumentException("O idJogador é <= 0");

		try {
			checkIdUnicoNaoExistente(new Identificador(idJogador), jogadores);
		} catch (IdentificadorUtilizadoException e) {
			throw new JogadorNaoEncontradoException("O jogador não foi encontrado");
		}
	}

	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal,
			String corUniformeSecundario) {

		if (id == null)
			throw new NullPointerException("O id é nulo");

		if (nome == null)
			throw new NullPointerException("O nome é nulo");

		if (dataCriacao == null)
			throw new NullPointerException("O dataCriacao é nulo");

		if (corUniformePrincipal == null)
			throw new NullPointerException("O corUniformePrincipal é nulo");

		if (corUniformeSecundario == null)
			throw new NullPointerException("O corUniformeSecundario é nulo");

		Time time = new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);

		checkIdUnicoExistente(time, times);

		times.add(time);
	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade,
			BigDecimal salario) {

		if (id == null)
			throw new NullPointerException("O id é nulo");

		if (idTime == null)
			throw new NullPointerException("O idTime é nulo");

		if (nome == null)
			throw new NullPointerException("O nome é nulo");

		if (dataNascimento == null)
			throw new NullPointerException("O dataNascimento é nulo");

		if (nivelHabilidade == null)
			throw new NullPointerException("O nivelHabilidade é nulo");

		if (salario == null)
			throw new NullPointerException("O salario é nulo");

		if (salario.compareTo(BigDecimal.ZERO) < 0)
			throw new IllegalArgumentException("O salario é < 0");

		if (nivelHabilidade < 0 || nivelHabilidade > 100)
			throw new IllegalArgumentException("O nivelHabilidade está fora do intervalo [0, 100]");

		Jogador jogador = new Jogador(id, nome, idTime, dataNascimento, nivelHabilidade, salario);

		checkIdUnicoExistente(jogador, jogadores);
		checkTimeNaoExistente(idTime);
		jogadores.add(jogador);
	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {
		checkJogadorNaoExistente(idJogador);

		Jogador jogador = jogadores.get(jogadores.indexOf(new Identificador(idJogador)));
		jogador.setCapitao(true);

		jogadores.forEach(j -> {
			if (!jogador.getId().equals(j.getId()) && jogador.getIdTime().equals(j.getIdTime())) {
				j.setCapitao(false);
			}
		});

	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {
		checkTimeNaoExistente(idTime);

		return jogadores.stream().filter(j -> j.getIdTime().equals(idTime) && j.isCapitao()).mapToLong(j -> j.getId())
				.findAny().orElseThrow(CapitaoNaoInformadoException::new);
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {
		checkJogadorNaoExistente(idJogador);

		Jogador jogador = jogadores.get(jogadores.indexOf(new Identificador(idJogador)));

		return jogador.getNome();
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {
		checkTimeNaoExistente(idTime);

		Time time = times.get(times.indexOf(new Identificador(idTime)));

		return time.getNome();
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		checkTimeNaoExistente(idTime);

		return jogadores.stream().filter(j -> j.getIdTime().equals(idTime)).map(j -> j.getId()).sorted()
				.collect(Collectors.toList());
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		checkTimeNaoExistente(idTime);

		return jogadores.stream().filter(j -> j.getIdTime().equals(idTime))
				.sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed().thenComparing(Jogador::getId))
				.findFirst().map(Jogador::getId).get();
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		checkTimeNaoExistente(idTime);

		return jogadores.stream().filter(j -> j.getIdTime().equals(idTime))
				.sorted(Comparator.comparing(Jogador::getDataNascimento).thenComparing(Jogador::getId)).findFirst()
				.map(Jogador::getId).get();
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		return times.stream().map(Time::getId).sorted().collect(Collectors.toList());
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
		checkTimeNaoExistente(idTime);

		return jogadores.stream().filter(j -> j.getIdTime().equals(idTime))
				.sorted(Comparator.comparing(Jogador::getSalario).reversed().thenComparing(Jogador::getId)).findFirst()
				.map(Jogador::getId).get();
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		checkJogadorNaoExistente(idJogador);

		Jogador jogador = jogadores.get(jogadores.indexOf(new Identificador(idJogador)));
		return jogador.getSalario();
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {
		return jogadores.stream()
				.sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed().thenComparing(Jogador::getId))
				.limit(top).map(Jogador::getId).collect(Collectors.toList());
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
		checkTimeNaoExistente(timeDaCasa);
		checkTimeNaoExistente(timeDeFora);

		Time timeCasa = times.get(times.indexOf(new Identificador(timeDaCasa)));
		Time timeFora = times.get(times.indexOf(new Identificador(timeDeFora)));

		return timeCasa.getCorUniformePrincipal().equals(timeFora.getCorUniformePrincipal())
				? timeFora.getCorUniformeSecundario()
				: timeFora.getCorUniformePrincipal();
	}

}
