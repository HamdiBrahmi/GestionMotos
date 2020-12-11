package com.hamdi.motos.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hamdi.motos.entities.Moto;
import com.hamdi.motos.service.MotoService;

@Controller
public class MotoController {
	@Autowired
		MotoService motoService;
	@RequestMapping("/showCreate")
		public String showCreate()
		{
			return "createMoto";
		}
	@RequestMapping("/saveMoto")
	public String saveProduit(@ModelAttribute("moto") Moto moto,
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateCreation = dateformat.parse(String.valueOf(date));
	moto.setDateCreation(dateCreation);
	Moto saveMoto = motoService.saveMoto(moto);
	String msg ="produit enregistré avec Id "+saveMoto.getIdMoto();
	modelMap.addAttribute("msg", msg);
	return "createMoto";
	}
	
	@RequestMapping("/ListeMotos")
	public String listeMotos(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "4") int size)
	{
		Page<Moto> m = motoService.getAllMotosParPage(page, size);
		modelMap.addAttribute("motos", m);
		modelMap.addAttribute("pages", new int[m.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeMotos";
	}
	
	@RequestMapping("/supprimerMoto")
	public String supprimerMoto(@RequestParam("id") Long id,ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size
			)
	{
	motoService.deleteMotoById(id);
	Page<Moto> m = motoService.getAllMotosParPage(page, size);
	modelMap.addAttribute("motos", m);
	modelMap.addAttribute("pages", new int[m.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeMotos";
	}
	
	@RequestMapping("/modifierMoto")
	public String editerMoto(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Moto m= motoService.getMoto(id);
		modelMap.addAttribute("moto", m);
		return "editerProduit";
	}
	@RequestMapping("/updateMoto")
	public String updateProduit(@ModelAttribute("moto") Moto produit,
	@RequestParam("date") String date,ModelMap modelMap) throws ParseException{
		//conversion de la date 
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		produit.setDateCreation(dateCreation);
		motoService.updateMoto(produit);
		List<Moto> m = motoService.getAllMotos();
		modelMap.addAttribute("motos", m);
		return "listeMotos";
		}
}
