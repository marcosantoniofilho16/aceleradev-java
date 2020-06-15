package challenge;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository repository;

	@Override
	public Quote getQuote() {
		List<Quote> quotes = repository.findAll();
		Random random = new Random();
		
		return quotes.get(random.nextInt(quotes.size()));
	}

	@Override
	public Quote getQuoteByActor(String actor) {
		List<Quote> quotes = repository.findByActor(actor);
		Random random = new Random();
		
		return quotes.get(random.nextInt(quotes.size()));
	}

}
