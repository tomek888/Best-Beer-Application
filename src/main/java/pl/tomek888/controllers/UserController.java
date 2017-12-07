package pl.tomek888.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.swing.JSpinner.DateEditor;
import javax.validation.Valid;
import javax.validation.Validator;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.tomek888.entities.Beer;
import pl.tomek888.entities.User;
import pl.tomek888.repositories.BeerRepository;
import pl.tomek888.repositories.UserRepository;



@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BeerRepository beerRepository;

	@Autowired
	Validator validator;

	@RequestMapping(method = RequestMethod.GET,value="/userReg")
	public String addUser1(Model model) {
		model.addAttribute("user", new User());

		return "addUser";
	}

	@RequestMapping(method = RequestMethod.POST,value="/userReg")
	public String addUser2(@Valid User user, BindingResult result,Model model,HttpSession session) {
		if (result.hasErrors()) {

			return "addUser";


		}else {
			try {

				user.setSalt(BCrypt.gensalt());	
				String password = BCrypt.hashpw(user.getPassword(), user.getSalt());
				user.setPassword(password);
				userRepository.save(user);
			}catch(JpaSystemException e) {
				model.addAttribute("user", new User());
				return "addUser";
			}
			
			session.setAttribute("user", user);
			return "redirect:/userLog";
		}
	}

	@RequestMapping(method = RequestMethod.GET,value="/userLog")
	public String loggUser1(Model model) {
		model.addAttribute("user", new User());

		return "logUser";
	}

	@RequestMapping(method = RequestMethod.POST,value="/userLog")
	public String loggUser2(@Valid User user, BindingResult result,Model model,HttpSession session) {
		List<User> users = userRepository.findAll();
		for(User userLog:users) {
			if(user.getUsername().equals(userLog.getUsername())&&BCrypt.checkpw(user.getPassword(),userLog.getPassword())){
				session.setAttribute("user", userLog.getId());
				session.setAttribute("username", userLog.getUsername());
				return "mainPage";
			}

			}
		
		return "redirect:/userLog";
		
		}
	
	
	
	
	@RequestMapping(value="/mainPage")
	public String loggUser1(Model model,HttpSession session) {
		model.addAttribute("user",session.getAttribute("user"));

		return "mainPage";
	}
	
	
	
	@RequestMapping(value="/logOut")
	public String logOut(Model model,HttpSession session) {
		model.addAttribute("user", new User());
		session.removeAttribute("user");
		session.removeAttribute("username");

		return "redirect:/userReg";
	}
	
	@RequestMapping("/myBeers")
	public String myBeers(Model model,HttpSession session) {
		
		User user = userRepository.findOne((Long) session.getAttribute("user"));
		List<Beer> beers = user.getBeers();
		model.addAttribute("beers", beers);
		return "myBeers";
	}
	
	
	}
