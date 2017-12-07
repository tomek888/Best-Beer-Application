package pl.tomek888.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.tomek888.entities.Rating;
import pl.tomek888.entities.User;
import pl.tomek888.repositories.BeerRepository;
import pl.tomek888.repositories.RatingRepository;
import pl.tomek888.repositories.UserRepository;


@Controller
public class RatingController {
	
	@Autowired
	RatingRepository ratingRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	BeerRepository beerRepository;

	@Autowired
	Validator validator;

	@RequestMapping(method = RequestMethod.GET,value="/rateBeer/{id}")
	public String rateBeer1(Model model,@PathVariable long id) {
		Rating rating = new Rating();
		
		model.addAttribute("rating",rating);
		model.addAttribute("beerId",id);
		return "rateBeer";
	}
	
	@RequestMapping(method = RequestMethod.POST,value="/rateBeer/{id}")
	public String rateBeer1(Model model,@ModelAttribute Rating rating,@RequestParam long id,HttpSession ses ) {
		
		rating.setBeer(beerRepository.findOne(id));
		User user = userRepository.findOne((Long) ses.getAttribute("user")); 
		rating.setUser(user);
		ratingRepository.save(rating);

		return "redirect:/top10beers";
	}

	
	@ModelAttribute("users")
	public List<User> getUsers(){
		return userRepository.findAll();
	}
}
