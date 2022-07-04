package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Moto;
import com.example.demo.repository.MotoRepository;

@Controller
public class IndexController {

    @Autowired
    private MotoRepository motoRepository;


    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping(value="/cadastrar", method=RequestMethod.GET)
    public String formAddMoto(){
        return "form";
    }

    // postman
	// @RequestMapping(value="/cadastrar", method=RequestMethod.POST)
	// public String form(@RequestBody Moto moto){
	// 	motoRepository.save(moto);
	// 	return "redirect: /motos";
	// }

    //form
    @RequestMapping(value="/motos", method=RequestMethod.POST)
	public String form2( Moto moto){
		motoRepository.save(moto);
		return "redirect:/motos";
	}

    @RequestMapping("/motos")
	public ModelAndView listaMotos(){
		ModelAndView mv = new ModelAndView("listMotos");
		Iterable<Moto> motos = motoRepository.findAll();
		mv.addObject("motos", motos);
		return mv;
	}
}
