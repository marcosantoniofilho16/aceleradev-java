package com.challenge.desafio;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

public class CalculadorDeClasses implements Calculavel {

	private void validar(Object objeto) {
		if (objeto == null)
			throw new IllegalArgumentException("o objeto é nulo");
	}

	private BigDecimal calcular(Object objeto, Class<? extends Annotation> notacao) {
		validar(objeto);
		
		BigDecimal total = BigDecimal.ZERO;

		Field[] fields = objeto.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			if (field.isAnnotationPresent(notacao) && field.getType().equals(BigDecimal.class)) {
				try {
					total = total.add((BigDecimal) field.get(objeto));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}

		return total;
	}

	@Override
	public BigDecimal somar(Object objeto) {

		return calcular(objeto, Somar.class);
	}

	@Override
	public BigDecimal subtrair(Object objeto) {

		return calcular(objeto, Subtrair.class);
	}

	@Override
	public BigDecimal totalizar(Object objeto) {
		BigDecimal somaTotal = somar(objeto);
		BigDecimal saldoTotal = subtrair(objeto);

		return somaTotal.subtract(saldoTotal);
	}

}
