package com.sarra.etudiants.repos;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sarra.etudiants.entities.Etudiant;
import com.sarra.etudiants.entities.Institut;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
   List<Etudiant>findByNom(String n);
   List<Etudiant>findByNomContains(String n);
   
  /* @Query("select e from Etudiant e where e.nom like %?1 and e.idEtudiant> ?2")
   List<Etudiant> findByIdNom (String nom, Long id );*/
   
   @Query("select e from Etudiant e where e.nom like %:nom and e.idEtudiant > :id")
   List<Etudiant> findByIdNom (@Param("nom") String nom,@Param("id") Long id);
   
   @Query("select e from Etudiant e where e.institut = ?1")
   List<Etudiant> findByInstitut (Institut institut);
   List<Etudiant> findByInstitutIdIns(Long id);
   
   List<Etudiant> findByOrderByNomAsc();
   @Query("select p from Etudiant p order by p.nom ASC, p.prenom DESC")
   List<Etudiant> trierEtudiantsNomPrenom ();
}
