package pl.tomek888.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import pl.tomek888.entities.Rating;
import pl.tomek888.entities.User;
import pl.tomek888.repositories.RatingRepository;
import pl.tomek888.repositories.UserRepository;


@Controller
public class RatingController {
	
	@Autowired
	RatingRepository ratingRepository;
	@Autowired
	UserRepository userRepository;

	@Autowired
	Validator validator;

	@RequestMapping(method = RequestMethod.GET,value="/rateBeer")
	public String rateBeer1(Model model) {
		Rating rating = new Rating();
		model.addAttribute("rating",rating);
		return "rateBeer";
	}
	
	@RequestMapping(method = RequestMethod.POST,value="/rateBeer")
	public String rateBeer1(Model model,@ModelAttribute Rating rating ) {
		ratingRepository.save(rating);

		return "rateBeer";
	}

	
	@ModelAttribute("notes")
	public List<Integer> notes() {
	List<Integer> notes = new ArrayList<>();
	for(int i=1;i<11;i++) {
		notes.add(i);
	}
	return notes;
	}
	
	@ModelAttribute("users")
	public List<User> getUsers(){
		return userRepository.findAll();
	}
}
