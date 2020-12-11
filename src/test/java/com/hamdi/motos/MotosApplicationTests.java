package com.hamdi.motos;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.hamdi.motos.entities.Categorie;
import com.hamdi.motos.entities.Moto;
import com.hamdi.motos.repos.MotoRepository;
import com.hamdi.motos.service.MotoService;

import lombok.Data;

@SpringBootTest
class MotosApplicationTests {
	@Autowired
	private MotoRepository motoRepository;
	@Autowired
	private MotoService motoService;
	@Test
	public void testCreateProduit() {
	Moto mZ1000 = new Moto("h2r",5000.0,new Date());
	motoRepository.save(mZ1000);
	}
	
	@Test
	public void testFindProduit()
	{ 
	Moto p = motoRepository.findById(1L).get(); 
	System.out.println(p);
	}
	
	@Test
	public void testUpdateProduit()
	{
	Moto p = motoRepository.findById(1L).get();
	p.setPrixMoto(3000.0);
	motoRepository.save(p);
	}
	
	@Test
	public void testDeleteProduit()
	{ 
	motoRepository.deleteById(1L);;
	}
	
	@Test
	public void testListerTousProduits()
	{
	List<Moto> motos = motoRepository.findAll();
		for (Moto m : motos)
		{
		System.out.println(m);
		}

	}
	
	@Test
	public void testFindByNomMotoContains()
	{
	Page<Moto> m = motoService.getAllMotosParPage(0,2);
	System.out.println(m.getSize());
	System.out.println(m.getTotalElements()); System.out.println(m.getTotalPages());
	m.getContent().forEach(p -> {System.out.println(p.toString());
	});
	/*ou bien
	for (Produit p : prods)
	{
	System.out.println(p);
	} */
	}
	
	@Test
	public void testFindByNomMoto()
	{
	List<Moto> m = motoRepository.findByNomMoto("Harley-Davidson");
	for (Moto p : m)
	{
	System.out.println(p);
	}
	}
	@Test
	public void findByNomMotoContains ()
	{
	List<Moto> m=motoRepository.findByNomMotoContains("Z");
	for (Moto p : m)
	{
	System.out.println(p);
	} }
	
	@Test
	public void testfindByNomPrix()
	{
	List<Moto> m = motoRepository.findByNomPrix("Harley-Davidson", 5000.0);
	for (Moto p : m)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void testfindByCategorie()
	{
	Categorie cat = new Categorie();
	cat.setIdCat(1L);
	List<Moto> m = motoRepository.findByCategorie(cat);
	for (Moto p : m)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void findByCategorieIdCat()
	{
	List<Moto> m = motoRepository.findByCategorieIdCat(1L);
	for (Moto p : m)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void testfindByOrderByNomMotoAsc()
	{
	List<Moto> m = motoRepository.findByOrderByNomMotoAsc();
	for (Moto p : m)
	{
	System.out.println(p);
	}
	}
	
	@Test public void testTrierMotosNomsPrix()
	{
	List<Moto> prods = motoRepository.trierMotosNomsPrix();
	for (Moto p : prods)
	{
	System.out.println(p);
	}
	}
}
