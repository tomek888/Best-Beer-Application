package pl.tomek888.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
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

import pl.tomek888.entities.User;
import pl.tomek888.repositories.UserRepository;



@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	Validator validator;

	@RequestMapping(method = RequestMethod.GET,value="/userReg")
	public String addUser1(Model model) {
		model.addAttribute("user", new User());

		return "addUser";
	}

	@RequestMapping(method = RequestMethod.POST,value="/userReg")
	public String addUser2(@Valid User user, BindingResult result,Model model) {
		if (result.hasErrors()) {
			user.setPassword();
			model.addAttribute("user", user);
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
			return "mainPage";
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
			
				return "mainPage";
			}

			}
		session.setAttribute("user", user);
		return "redirect:/mainPage";
		
		}
	
	@RequestMapping(value="/mainPage")
	public String loggUser1(Model model,HttpSession session) {
		model.addAttribute(session.getAttribute("user"));

		return "mainPage";
	}
	}
