package br.com.codenation;

import java.util.Arrays;

public class StatisticUtil {

	public static int average(int[] elements) {
		int sum = elements[0];
		
		for (int i = 1; i < elements.length; i++) {
			sum += elements[i];
		}
		
		return sum / elements.length;
	}

	public static int mode(int[] elements) {
		int mode = elements[0];
		int total = 0;
		
		for (int i = 0; i < elements.length; i++) {
			int count = 0;
	        for (int j = 0; j < elements.length; j++) {
	            if (elements[j] == elements[i]) ++count;
	        }
	        if (count > total) {
	        	mode = elements[i];
	        	total = count;
	        }
		}
		
		return mode;
	}

	public static int median(int[] elements) {
		Arrays.sort(elements);
		
		int middle = elements.length / 2;
		
	    if (elements.length % 2 == 0)
	    	return (elements[middle-1] + elements[middle]) / 2;
	    else
	    	return elements[middle];
	        
	}
}