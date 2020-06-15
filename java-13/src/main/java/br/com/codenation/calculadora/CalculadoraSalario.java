package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		if (salarioBase < 1039)
			return 0;
		
		double salarioBruto = calcularInss(salarioBase);
		double salarioLiquido = calcularIrrf(salarioBruto);
		
		return Math.round(salarioLiquido);
	}
	
	private double calcularInss(double salarioBase) {
		if (salarioBase <= 1500)
			return salarioBase * 0.92;
		
		if (salarioBase <= 4000)
			return salarioBase * 0.91;
		
		return salarioBase * 0.89;
	}
	
	private double calcularIrrf(double salarioBruto) {
		if (salarioBruto <= 3000)
			return salarioBruto;
		
		if (salarioBruto <= 6000)
			return salarioBruto * 0.925;
		
		return salarioBruto * 0.85;
	}

}
