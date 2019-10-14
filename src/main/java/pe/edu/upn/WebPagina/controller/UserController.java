package pe.edu.upn.WebPagina.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upn.WebPagina.model.entity.User;
import pe.edu.upn.WebPagina.service.UserService;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<User>users=userService.findAll();
			model.addAttribute("users", users);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/user/inicio";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable ("id") int id,Model model) {
		try {
			Optional<User>optional=userService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("user", optional.get());
			}
			else {
				return "redirect:/user";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/user/edit";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("user")User user, Model model,SessionStatus status) {
	     try {
			userService.save(user);
			status.setComplete();
		} catch (Exception e) {
			// TODO: handle exception
		}
	     return "redirect:/user";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		User user=new User();
		model.addAttribute("user", user);
		return "/user/nuevo";
	}
	
	@RequestMapping("/logearse")
	public String login(HttpServletRequest request) {
		return "login";
	}
	
	
	/*
	@RequestMapping("/login-user")
	public String loginUser(@ModelAttribute ("user")User user,HttpServletRequest request) {
		 
		if(userService.findByUsernameAndPassword(user.getUsername(), user.getPassword())!=null) {
				
				return "/user/inicio";
		}
		else {
		request.setAttribute("error", "invalid Username or password");
		return "login";
		}
		 
	
		
	}
		
	*/
	
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id")int id, Model model) {
		try {
			Optional<User>user=userService.findById(id);
			if(user.isPresent()) {
				userService.deleteById(id);
			}
		} catch (Exception e) {
			 model.addAttribute("dangerDel","ERROR");
			 try {
				List<User>users=userService.findAll();
				model.addAttribute("users", users);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			 return "/user/inicio";
		}
		return "redirect:/user";
	}
	
}
