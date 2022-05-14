package com.ark.fileuploaddb.controller;

import java.util.List;

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
import com.ark.fileuploaddb.service.ChantierService;



@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/chantier")
public class ChantierController{
	@Autowired
	ChantierService StockService;
	// http://localhost:8089/chantier/show
	@GetMapping("/show")
	@ResponseBody
	public List<Chantier> getAllChantier() {
	List<Chantier> listStock = StockService.getAllChantier();
	return listStock;
	}
	
	// http://localhost:8089/chantier/add
	
	@PostMapping("/add")
	public void create(@RequestBody Chantier Stock)
	{
	 StockService.create(Stock);
	
	
	}
	// http://localhost:8089/chantier/Deletechantier/{idStock}
	@DeleteMapping("/Deletechantier/{idStock}")
	@ResponseBody
	public void DeleteChantier(@PathVariable("idStock") long id)
	{
		StockService.deleteChantier(id);
	}
	
	// http://localhost:8089/chantier/update
	 @PutMapping("/update")
	 @ResponseBody
	 public void updateChantier(@RequestBody Chantier stock)
	 {
	  StockService.updateChantier(stock);
	  }
}
