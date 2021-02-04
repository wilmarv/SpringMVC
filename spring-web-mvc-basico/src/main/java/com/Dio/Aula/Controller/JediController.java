package com.Dio.Aula.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Dio.Aula.Model.Jedi;
import com.Dio.Aula.Repository.JediRepository;

@Controller
public class JediController {
	@Autowired
    private JediRepository repository;
	
	@GetMapping("/Jedi")
	public ModelAndView Jedi() {
		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Jedi");
		modelAndView.addObject("allJedi",repository.getAll());
		
		return modelAndView;
	}
	
	@GetMapping("/new-jedi")
	public ModelAndView newJedi() {
		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("NewJedi");
		
		modelAndView.addObject("jedi",new Jedi());
		return modelAndView;
	}
	@PostMapping("/Jedi")
    public String createJedi( @ModelAttribute Jedi jedi, BindingResult result, RedirectAttributes redirect) {

        if (result.hasErrors()) {
            return "NewJedi";
        }
        repository.add(jedi);
        redirect.addFlashAttribute("message", "Jedi successfully created.");

        return "redirect:Jedi";
    }
}
