package br.com.codenation;


import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;

public class DesafioMeuTimeApplicationTest {

    private DesafioMeuTimeApplication meuTime;

    @Before
    public void setUp() {
    	meuTime = new DesafioMeuTimeApplication();
    }
    
    @Test
    public void deveIncluirTime() {
    	meuTime.incluirTime(3L, "Time 3", LocalDate.now(), "Branco", "Azul");
    	meuTime.incluirTime(2L, "Time 2", LocalDate.now(), "Azul", "Verde");
    	meuTime.incluirTime(1L, "Time 1", LocalDate.now(), "Azul", "Branco");
    }
    
    @Test(expected = NullPointerException.class)
    public void deveRetornarErroCasoIdDoTimeSejaNulo() {
    	meuTime.incluirTime(null, "Time 1", LocalDate.now(), "Verde", "Amarelo");
    }
    
    @Test(expected = NullPointerException.class)
    public void deveRetornarErroCasoNomeDoTimeSejaNulo() {
    	meuTime.incluirTime(1L, null, LocalDate.now(), "Verde", "Amarelo");
    }
    
    @Test(expected = NullPointerException.class)
    public void deveRetornarErroCasoDataCriacaoDoTimeSejaNulo() {
    	meuTime.incluirTime(1L, "Time 1", null, "Verde", "Amarelo");
    }
    
    @Test(expected = NullPointerException.class)
    public void deveRetornarErroCasoCorUniformePrinicipalDoTimeSejaNulo() {
    	meuTime.incluirTime(1L, "Time 1", LocalDate.now(), null, "Amarelo");
    }
    
    @Test(expected = NullPointerException.class)
    public void deveRetornarErroCasoCorUniformeSecundarioDoTimeSejaNulo() {
    	meuTime.incluirTime(1L, "Time 1", LocalDate.now(), "Verde", null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void deveRetornarErroCasoIdDoTimeSejaNegativo() {
    	meuTime.incluirTime(-1L, "Time 1", LocalDate.now(), "Verde", "Amarelo");
    }

    @Test(expected = IdentificadorUtilizadoException.class)
    public void deveRetornarErroCasoIdentificadorDoTimeJaExista() {
    	deveIncluirTime();
    	meuTime.incluirTime(1L, "Time 2", LocalDate.now(), "Verde", "Amarelo");
    }
    
    @Test
    public void deveIncluirJogador() {
    	deveIncluirTime();
    	
    	// Time 2
    	meuTime.incluirJogador(12L, 2L, "Jogador 12", LocalDate.of(1994, 8, 10), 100, BigDecimal.valueOf(15000));
    	meuTime.incluirJogador(11L, 2L, "Jogador 11", LocalDate.of(1994, 8, 10), 60, BigDecimal.valueOf(15000));
    	meuTime.incluirJogador(10L, 2L, "Jogador 10", LocalDate.of(1993, 1, 3), 70, BigDecimal.valueOf(5000));
    	meuTime.incluirJogador(9L, 2L, "Jogador 9", LocalDate.of(1995, 11, 27), 80, BigDecimal.valueOf(10000));
    	meuTime.incluirJogador(8L, 2L, "Jogador 8", LocalDate.of(1994, 8, 10), 90, BigDecimal.valueOf(15000));
    	meuTime.incluirJogador(7L, 2L, "Jogador 7", LocalDate.of(1993, 1, 3), 100, BigDecimal.valueOf(13000));
    	
    	// Time 1
    	meuTime.incluirJogador(6L, 1L, "Jogador 6", LocalDate.of(1994, 8, 10), 100, BigDecimal.valueOf(15000));
    	meuTime.incluirJogador(5L, 1L, "Jogador 5", LocalDate.of(1994, 8, 10), 60, BigDecimal.valueOf(15000));
    	meuTime.incluirJogador(4L, 1L, "Jogador 4", LocalDate.of(1993, 1, 3), 70, BigDecimal.valueOf(5000));
    	meuTime.incluirJogador(3L, 1L, "Jogador 3", LocalDate.of(1995, 11, 27), 80, BigDecimal.valueOf(10000));
    	meuTime.incluirJogador(2L, 1L, "Jogador 2", LocalDate.of(1994, 8, 10), 90, BigDecimal.valueOf(15000));
    	meuTime.incluirJogador(1L, 1L, "Jogador 1", LocalDate.of(1993, 1, 3), 100, BigDecimal.valueOf(13000));
    	
    }
    
    @Test(expected = NullPointerException.class)
    public void deveRetornarErroCasoIdDoJogadorSejaNulo() {
    	deveIncluirTime();
    	meuTime.incluirJogador(null, 1L, "Jogador 1", LocalDate.of(1993, 1, 3), 100, BigDecimal.valueOf(13000));
    }
    
    @Test(expected = NullPointerException.class)
    public void deveRetornarErroCasoIdTimeDoJogadorSejaNulo() {
    	deveIncluirTime();
    	meuTime.incluirJogador(1L, null, "Jogador 1", LocalDate.of(1993, 1, 3), 100, BigDecimal.valueOf(13000));
    }
    
    @Test(expected = NullPointerException.class)
    public void deveRetornarErroCasoNomeDoJogadorSejaNulo() {
    	deveIncluirTime();
    	meuTime.incluirJogador(1L, 1L, null, LocalDate.of(1993, 1, 3), 100, BigDecimal.valueOf(13000));
    }
    
    @Test(expected = NullPointerException.class)
    public void deveRetornarErroCasoDataNascimentoDoJogadorSejaNulo() {
    	deveIncluirTime();
    	meuTime.incluirJogador(1L, 1L, "Jogador 1", null, 100, BigDecimal.valueOf(13000));
    }
    
    @Test(expected = NullPointerException.class)
    public void deveRetornarErroCasoNivelHabilidadeDoJogadorSejaNulo() {
    	deveIncluirTime();
    	meuTime.incluirJogador(1L, 1L, "Jogador 1", LocalDate.of(1993, 1, 3), null, BigDecimal.valueOf(13000));
    }
    
    @Test(expected = NullPointerException.class)
    public void deveRetornarErroCasoSalarioDoJogadorSejaNulo() {
    	deveIncluirTime();
    	meuTime.incluirJogador(1L, 1L, "Jogador 1", LocalDate.of(1993, 1, 3), 100, null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void deveRetornarErroCasoSalarioDoJogadorSejaNegativo() {
    	deveIncluirTime();
    	meuTime.incluirJogador(1L, 1L, "Jogador 1", LocalDate.of(1993, 1, 3), 100, BigDecimal.valueOf(-13000));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void deveRetornarErroHabilidadeDoJogadorSejaNegativo() {
    	deveIncluirTime();
    	meuTime.incluirJogador(1L, 1L, "Jogador 1", LocalDate.of(1993, 1, 3), -1, BigDecimal.valueOf(13000));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void deveRetornarErroHabilidadeDoJogadorSejaAcimaDe100() {
    	deveIncluirTime();
    	meuTime.incluirJogador(1L, 1L, "Jogador 1", LocalDate.of(1993, 1, 3), 200, BigDecimal.valueOf(13000));
    }

    @Test(expected = IdentificadorUtilizadoException.class)
    public void deveRetornarErroCasoIdentificadorDoJogadorJaExista() {
    	deveIncluirJogador();
    	meuTime.incluirJogador(1L, 1L, "Jogador 1", LocalDate.of(1995, 11, 27), 100, BigDecimal.valueOf(10000));
    }
    
    @Test(expected = TimeNaoEncontradoException.class)
    public void deveRetornarErroCasoIncluirJogadorComTimeNaoEncontrado() {
    	meuTime.incluirJogador(1L, 1L, "Jogador 1", LocalDate.of(1995, 11, 27), 100, BigDecimal.valueOf(10000));
    }
    
    @Test
    public void deveDefinirCapitao() {
    	deveIncluirJogador();
    	meuTime.definirCapitao(1L);
    }
    
    @Test(expected = JogadorNaoEncontradoException.class)
    public void deveRetornarErroCasoDefinirCapitaoComJogadorNaoEncontrado() {
    	meuTime.definirCapitao(1L);
    }
    
    @Test
    public void deveBuscarCapitaoDoTime() {
    	deveDefinirCapitao();
    	assertEquals(Long.valueOf(1L), meuTime.buscarCapitaoDoTime(1L));
    }
    
    @Test(expected = TimeNaoEncontradoException.class)
    public void deveRetornarErroCasoBuscarCapitaoDoTimeComTimeNaoEncontrado() {
    	meuTime.buscarCapitaoDoTime(1L);
    }
    
    @Test
    public void deveBuscarNomeDoJogador() {
    	deveIncluirJogador();
    	assertEquals("Jogador 1", meuTime.buscarNomeJogador(1L));
    }
    
    @Test(expected = JogadorNaoEncontradoException.class)
    public void deveRetornarErroCasoBuscarNomeDoJogadorComJogadorNaoEncontrado() {
    	meuTime.buscarNomeJogador(1L);
    }
    
    @Test
    public void deveBuscarNomeDoTime() {
    	deveIncluirTime();
    	assertEquals("Time 1", meuTime.buscarNomeTime(1L));
    }
    
    @Test(expected = TimeNaoEncontradoException.class)
    public void deveRetornarErroCasoBuscarNomeDoTimeComTimeNaoEncontrado() {
    	meuTime.buscarNomeTime(1L);
    }
    
    @Test
    public void deveBuscarJogadoresDoTime() {
    	deveIncluirJogador();
    	assertEquals(Long.valueOf(3L), meuTime.buscarJogadoresDoTime(1L).get(2));
    }
    
    @Test
    public void deveBuscarJogadoresDoTimeIgnorandoCapitoes() {
    	deveDefinirCapitao();
    	assertEquals(Long.valueOf(1L), meuTime.buscarJogadoresDoTime(1L).get(0));
    }
    
    @Test(expected = TimeNaoEncontradoException.class)
    public void deveRetornarErroCasoBuscarJogadoresDoTimeComTimeNaoEncontrado() {
    	meuTime.buscarJogadoresDoTime(1L);
    }
    
    @Test
    public void deveBuscarMelhorJogadorDoTime() {
    	deveIncluirJogador();
    	assertEquals(Long.valueOf(1L), meuTime.buscarMelhorJogadorDoTime(1L));
    }
    
    @Test(expected = TimeNaoEncontradoException.class)
    public void deveRetornarErroCasoBuscarMelhorJogadorDoTimeComTimeNaoEncontrado() {
    	meuTime.buscarMelhorJogadorDoTime(1L);
    }
    
    @Test
    public void deveBuscarJogadorMaisVelho() {
    	deveIncluirJogador();
    	assertEquals(Long.valueOf(1L), meuTime.buscarJogadorMaisVelho(1L));
    }
    
    @Test(expected = TimeNaoEncontradoException.class)
    public void deveRetornarErroCasoBuscarJogadorMaisVelhoComTimeNaoEncontrado() {
    	meuTime.buscarJogadorMaisVelho(1L);
    }
    
    @Test
    public void deveBuscarTimes() {
    	deveIncluirTime();
    	assertEquals(Long.valueOf(2L), meuTime.buscarTimes().get(1));
    }
    
    @Test
    public void deveDeveRetornarListaVaziaQuandoBuscarTimesNaoCadastrados() {
    	assertEquals(true, meuTime.buscarTimes().isEmpty());
    }
    
    @Test
    public void deveBuscarJogadorComMaiorSalario() {
    	deveIncluirJogador();
    	assertEquals(Long.valueOf(2L), meuTime.buscarJogadorMaiorSalario(1L));
    }
    
    @Test(expected = TimeNaoEncontradoException.class)
    public void deveRetornarErroCasoBuscarJogadorComMaiorSalarioComTimeNaoEncontrado() {
    	meuTime.buscarJogadorMaiorSalario(1L);
    }
    
    @Test
    public void deveBuscarSalarioDoJogador() {
    	deveIncluirJogador();
    	assertEquals(BigDecimal.valueOf(13000), meuTime.buscarSalarioDoJogador(1L));
    }
    
    @Test(expected = JogadorNaoEncontradoException.class)
    public void deveRetornarErroCasoBuscarSalarioDoJogadorComJogadorNaoEncontrado() {
    	meuTime.buscarSalarioDoJogador(1L);
    }
    
    @Test
    public void deveBuscarTopJogadores() {
    	deveIncluirJogador();
    	assertEquals(5, meuTime.buscarTopJogadores(5).size());
    	assertEquals(Long.valueOf(1L), meuTime.buscarTopJogadores(5).get(0));
    	assertEquals(Long.valueOf(6L), meuTime.buscarTopJogadores(5).get(1));
    }
    
    @Test
    public void deveDeveRetornarListaVaziaQuandoBuscarTopJogadoresNaoCadastrados() {
    	assertEquals(true, meuTime.buscarTopJogadores(5).isEmpty());
    }
    
    @Test
    public void deveBuscarCorCamisaTimeDeFora() {
    	deveIncluirJogador();
    	assertEquals("Verde", meuTime.buscarCorCamisaTimeDeFora(1L, 2L));
    	assertEquals("Branco", meuTime.buscarCorCamisaTimeDeFora(2L, 1L));
    	assertEquals("Branco", meuTime.buscarCorCamisaTimeDeFora(1L, 3L));
    }
    
    @Test(expected = TimeNaoEncontradoException.class)
    public void deveRetornarErroCasoBuscarCorCamisaTimeDeForaComTimeNaoEncontrado() {
    	meuTime.buscarCorCamisaTimeDeFora(1L, 2L);
    }

}
