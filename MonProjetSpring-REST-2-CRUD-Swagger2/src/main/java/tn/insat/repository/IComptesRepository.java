package tn.insat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.insat.domain.Compte;

public interface IComptesRepository 
          extends JpaRepository<Compte, String>{

}
