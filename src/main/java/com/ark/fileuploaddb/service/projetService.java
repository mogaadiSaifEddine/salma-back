package com.ark.fileuploaddb.service;
import com.ark.fileuploaddb.model.IspDefultNames;
import com.ark.fileuploaddb.repository.IspDefaultNamesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ark.fileuploaddb.model.projet;

import com.ark.fileuploaddb.repository.projetRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
public class projetService {
	@Autowired
	projetRepository cr;


	@Autowired
	IspDefaultNamesRepo ispDefaultNamesRepo ;

	public void create(projet projet , Set<IspDefultNames> ispDefultNamesSet){
		projet.setState(true);
		System.out.println(projet) ;
		System.out.println(projet) ;
		System.out.println(projet) ;
		projet.setISPDefultNames(ispDefultNamesSet);
		projet eprojet =   cr.save(projet );
		eprojet.getISPDefultNames().addAll(ispDefultNamesSet);
		cr.save(eprojet );
	}
	
	
	public List<projet > getAllprojet(){
		List<projet> list = new ArrayList<>();

		return (List<projet>)	this.cr.findAll();

			
	}
	public void deleteprojet(Long id) {
//	     cr.deleteById(id);
		 projet p = cr.findById(id).orElse(null);
		 p.setState(false);
		 cr.save(p);
	}

	public projet updateprojet(projet s , Long id ) {
		projet pro  = cr.findById(id).orElse(null);
		pro.setChantier(s.getChantier());
		pro.setNom(s.getNom());
		pro.setUsers(s.getUsers());
		return cr.save(pro);
	}
	
	
}
	
	


