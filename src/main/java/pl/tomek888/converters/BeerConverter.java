package pl.tomek888.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.tomek888.entities.Beer;
import pl.tomek888.repositories.BeerRepository;



public class BeerConverter implements Converter<String, Beer> {
	@Autowired
	private BeerRepository beerRepository;
	
	@Override
	public Beer convert(String source) {
	Beer beer = beerRepository.findOne(Long.parseLong(source));
	return beer;
	}

}
