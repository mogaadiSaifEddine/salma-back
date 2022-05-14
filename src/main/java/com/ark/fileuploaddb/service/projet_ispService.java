package com.ark.fileuploaddb.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ark.fileuploaddb.model.projet_isp;

import com.ark.fileuploaddb.repository.projet_ispRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class projet_ispService {
	@Autowired
	projet_ispRepository cr;
	
	public void create(projet_isp p){
		cr.save(p );
	}
	
	
	public List<projet_isp > getAllprojet_isp(){
		List<projet_isp> list = new ArrayList<>();
		
		this.cr.findAll().forEach(i->list.add(i));
		return list;
			
	}
	public void deleteprojet_isp(Long id) {
	     cr.deleteById(id);
	}

	public projet_isp updateprojet_isp(projet_isp s) {
		return cr.save(s);
	}
	
	
}
	
	


