package com.ark.fileuploaddb.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ark.fileuploaddb.model.Chantier;
import com.ark.fileuploaddb.repository.ChantierRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class ChantierService {
	@Autowired
	ChantierRepository cr;
	
	public void create(Chantier Chantier ){
		cr.save(Chantier );
	}
	
	
	public List<Chantier > getAllChantier(){
		List<Chantier> list = new ArrayList<>();
		

		return (List<Chantier>) this.cr.findAll();
			
	}
	public void deleteChantier(Long id) {
	     cr.deleteById(id);
	}

	public Chantier updateChantier(Chantier s) {
		return cr.save(s);
	}
	
	
}
	
	


