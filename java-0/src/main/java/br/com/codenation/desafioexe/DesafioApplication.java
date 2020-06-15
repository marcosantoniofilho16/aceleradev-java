package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {
		List<Integer> fibo = new ArrayList<Integer>();
		fibo.add(0);
		fibo.add(1);
		
		int i = 1;
		Integer num = 0;
		do {
			num = fibo.get(i) + fibo.get(i - 1);
			fibo.add(num);
			i++;
		} while(num < 350);
		
		return fibo;
	}

	public static Boolean isFibonacci(Integer a) {
		return fibonacci().contains(a);
	}

}