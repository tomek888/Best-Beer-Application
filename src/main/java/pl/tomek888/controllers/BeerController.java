package pl.tomek888.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.tomek888.entities.Beer;
import pl.tomek888.repositories.BeerRepository;
import pl.tomek888.repositories.UserRepository;


@Controller

public class BeerController {
	
	@Autowired
	BeerRepository beerRepository;
	
	@RequestMapping("/top10beers")
	public String top10beers(Model model,HttpSession session) {
		
		model.addAttribute("user",session.getAttribute("user"));
		List<Beer> beers = beerRepository.findAll();
		model.addAttribute("beers", beers);
		return "top10beers";
	}

}
