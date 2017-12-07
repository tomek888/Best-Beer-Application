package pl.tomek888.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.tomek888.entities.Beer;
import pl.tomek888.entities.Rating;
import pl.tomek888.entities.User;
import pl.tomek888.repositories.BeerRepository;
import pl.tomek888.repositories.UserRepository;


@Controller

public class BeerController {
	
	@Autowired
	BeerRepository beerRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/top10beers")
	public String top10beers(Model model,HttpSession session) {
		
		
		List<Beer> beers = beerRepository.findAll();
		model.addAttribute("beers", beers);
		return "top10beers";
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/findBeer")
	public String findBeer1(Model model,HttpSession session) {
		
		List<Beer> beers = new ArrayList<>();
		model.addAttribute("beers", beers);
		
		return "findBeer";
	}
	
	@RequestMapping(method = RequestMethod.POST,value="/findBeer")
	public String findBeer2(Model model,HttpSession session,@RequestParam String options, @RequestParam String search) {
		
		if(options.equals("beerName")) {
			List<Beer> beers = beerRepository.findByBeerName(search);
			model.addAttribute("beers", beers);
		}else if(options.equals("brewery")) {
			List<Beer> beers = beerRepository.findByBreweryName(search);
			model.addAttribute("beers", beers);
		}else if(options.equals("style")) {
			List<Beer> beers = beerRepository.findByBeerStyle(search);
			model.addAttribute("beers", beers);
		}else if(options.equals("alcohol1")) {
			List<Beer> beers = beerRepository.findByAlcoholPercentMore(Long.parseLong(search));
			model.addAttribute("beers", beers);
		}else if(options.equals("alcohol2")) {
			List<Beer> beers = beerRepository.findByAlcoholPercentLess(Long.parseLong(search));
			model.addAttribute("beers", beers);
		}
		
		
		
		return "findBeer";
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/addBeer")
	public String addBeer1(Model model,HttpSession session) {
		Beer beer = new Beer();
		model.addAttribute("beer",beer);
		
		
		return "addBeer";
	}
	
	@RequestMapping(method = RequestMethod.POST,value="/addBeer")
	public String addBeer2(@ModelAttribute Beer beer) {
		beerRepository.save(beer);
		
		
		return "addBeer";
	}
	

	
	@RequestMapping(method = RequestMethod.GET,value="/addMyBeer/{id}")
	public String addMeBeer(Model model,@PathVariable long id,HttpSession session) {
		
		Beer beer =beerRepository.findOne(id);
		User user = userRepository.findOne((Long) session.getAttribute("user")); 
		user.getBeers().add(beer);
		userRepository.save(user);
		

		return "redirect:/top10beers";
	}
	
	@RequestMapping(method = RequestMethod.GET,value="/deleteBeer/{id}")
	public String deleteBeer(Model model,@PathVariable long id,HttpSession session) {
		
		Beer beer =beerRepository.findOne(id);
		
		beerRepository.delete(beer);
		

		return "redirect:/top10beers";
	}
	
	@RequestMapping(value="/deleteMyBeer/{id}")
	public String deleteMyBeer(Model model,@PathVariable long id,HttpSession session) {
		
		Beer beer =beerRepository.findOne(id);
		User user = userRepository.findOne((Long) session.getAttribute("user")); 
		List<Beer> remBerr=user.getBeers();
		remBerr.remove(beer);

		user.setBeers(remBerr);
		userRepository.save(user);
		

		return "redirect:/myBeers";
	}
	
	@ModelAttribute("skills")
	public List<String> options() {
	List<String> options = new ArrayList<>();
	options.add("beer name");
	options.add("brewery");
	options.add("style");
	return options;
	}

}
