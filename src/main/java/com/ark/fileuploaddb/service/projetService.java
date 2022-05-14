package com.ark.fileuploaddb.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ark.fileuploaddb.model.projet;

import com.ark.fileuploaddb.repository.projetRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class projetService {
	@Autowired
	projetRepository cr;
	
	public void create(projet projet ){
		cr.save(projet );
	}
	
	
	public List<projet > getAllprojet(){
		List<projet> list = new ArrayList<>();
		
		this.cr.findAll().forEach(i->list.add(i));
		return list;
			
	}
	public void deleteprojet(Long id) {
	     cr.deleteById(id);
	}

	public projet updateprojet(projet s , Long id ) {
		projet pro  = cr.findById(id).orElse(null);
		pro.setChantier(s.getChantier());
		pro.setNom(s.getNom());
		pro.setUsers(s.getUsers());
		return cr.save(pro);
	}
	
	
}
	
	


