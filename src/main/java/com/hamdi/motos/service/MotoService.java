package com.hamdi.motos.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.hamdi.motos.entities.Categorie;
import com.hamdi.motos.entities.Moto;

public interface MotoService {

	Moto saveMoto(Moto m);
	Moto updateMoto(Moto m);
	void deleteMoto(Moto m);
	void deleteMotoById(Long id);
	Moto getMoto(Long id);
	List<Moto> getAllMotos();
	
	Page<Moto> getAllMotosParPage(int page, int size);
	
	List<Moto> findByNomMoto(String nom);
	List<Moto> findByNomMotoContains(String nom);
	List<Moto> findByNomPrix (String nom, Double prix);
	List<Moto> findByCategorie (Categorie categorie);
	List<Moto> findByCategorieIdCat(Long id);
	List<Moto> findByOrderByNomMotoAsc();
	List<Moto> trierMotosNomsPrix();
	
}
