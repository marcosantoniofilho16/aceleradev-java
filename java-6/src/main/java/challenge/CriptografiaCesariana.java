package challenge;

public class CriptografiaCesariana implements Criptografia {

	public static final int NUMBER_OF_LETTERS = 26;
	public static final int SHIFT = 3;

	private void isValid(String text) {
		if (text == null)
			throw new NullPointerException("text is null");

		if (text.isEmpty())
			throw new IllegalArgumentException("text is empty");
	}
	
	private String crypto(String input, Boolean reverse) {
		isValid(input);

		input = input.toLowerCase();
		String output = "";

		for (int i = 0; i < input.length(); i++) {
			char character = input.charAt(i);
			if (character >= 97 && character <= 122) {
				int j = reverse ? (character - 97) - SHIFT : (character - 97) + SHIFT;
				output += String.valueOf(((char) ((j % NUMBER_OF_LETTERS + NUMBER_OF_LETTERS) % NUMBER_OF_LETTERS + 97)));
			} else
				output += String.valueOf(character);
		}

		return output;
	}

	@Override
	public String criptografar(String texto) {
		return crypto(texto, false);
	}

	@Override
	public String descriptografar(String texto) {
		return crypto(texto, true);
	}

}
