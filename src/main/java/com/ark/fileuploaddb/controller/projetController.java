package com.ark.fileuploaddb.controller;



import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ark.fileuploaddb.model.IspDefultNames;
import com.ark.fileuploaddb.repository.IspDefaultNamesRepo;
import com.ark.fileuploaddb.repository.projetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ark.fileuploaddb.model.Chantier;
import com.ark.fileuploaddb.model.projet;
import com.ark.fileuploaddb.model.projet_isp;
import com.ark.fileuploaddb.service.ChantierService;
import com.ark.fileuploaddb.service.projetService;
import com.ark.fileuploaddb.service.projet_ispService;



@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/p")
public class projetController{
	@Autowired
	projetService StockService;
	// http://localhost:8089/p/show


	@Autowired
	IspDefaultNamesRepo ispDefaultNamesRepo ;


@Autowired
	projetRepository ProjetRep;
	@GetMapping("/show")
	@ResponseBody
	public List<projet> getAllprojet() {
		List<projet> listStock = StockService.getAllprojet();
		return listStock;
	}
	
	// http://localhost:8089/p/add
	
	@PostMapping("/add")
	public void create(@RequestBody projet Stock)
	{
		System.out.println((Stock.getISPDefultNames()));

		Set <IspDefultNames> listIspDegfaultNames = new HashSet<>() ;
	List	<IspDefultNames>listIspDegfaultName =  this.ispDefaultNamesRepo.findAll();
		for (IspDefultNames x : listIspDegfaultName)
			x.getProjet().add(Stock);

		System.out.println(listIspDegfaultNames);
		Stock.setISPDefultNames(listIspDegfaultNames);
		Stock.getISPDefultNames().addAll(listIspDegfaultNames);
		System.out.println(Stock.getISPDefultNames());
		System.out.println(Stock.getChantier());
	 StockService.create(Stock,listIspDegfaultNames);
	
	
	}
	// http://localhost:8089/p/Delete/{idStock}
	@DeleteMapping("/Delete/{idStock}")
	@ResponseBody
	public void Deleteprojet(@PathVariable("idStock") long id)
	{
		StockService.deleteprojet(id);
	}
	
	// http://localhost:8089/p/update/{id}
	 @PutMapping("/update/{id}")
	 @ResponseBody
	 public void updateprojet(@RequestBody projet stock , @PathVariable Long id )
	 {
	  StockService.updateprojet(stock , id);
	  }


	  @GetMapping ("/{id}")
	  public projet getAllISPByProjet(@PathVariable Long id ) {
		  projet proj  = ProjetRep.findById(id).orElse(null);
		  return proj;
	  }
}

