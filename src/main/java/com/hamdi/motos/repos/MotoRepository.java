package com.hamdi.motos.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hamdi.motos.entities.Categorie;
import com.hamdi.motos.entities.Moto;

public interface MotoRepository extends JpaRepository<Moto, Long> {
	List<Moto> findByNomMoto(String nom);
	List<Moto> findByNomMotoContains(String nom);
	
	/*@Query("select m from Moto m where m.nomMoto like %?1 and m.prixMoto > ?2") List<Moto> findByNomPrix (String nom, Double prix);*/
	
	@Query("select m from Moto m where m.nomMoto like %:nom and m.prixMoto > :prix")
	List<Moto> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	
	@Query("select p from Moto p where p.categorie = ?1") List<Moto> findByCategorie (Categorie categorie);
	
	List<Moto> findByCategorieIdCat(Long id);
	
	List<Moto> findByOrderByNomMotoAsc();
	
	@Query("select m from Moto m order by m.nomMoto ASC, m.prixMoto DESC")
	List<Moto> trierMotosNomsPrix ();
}
