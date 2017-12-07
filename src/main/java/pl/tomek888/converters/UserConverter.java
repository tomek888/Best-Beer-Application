package pl.tomek888.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.tomek888.entities.Beer;
import pl.tomek888.entities.User;
import pl.tomek888.repositories.BeerRepository;
import pl.tomek888.repositories.UserRepository;



public class UserConverter implements Converter<String, User> {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User convert(String source) {
	User user = userRepository.findOne(Long.parseLong(source));
	return user;
	}

}
