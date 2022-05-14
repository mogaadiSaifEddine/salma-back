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
import com.ark.fileuploaddb.model.projet_isp;
import com.ark.fileuploaddb.service.ChantierService;
import com.ark.fileuploaddb.service.projet_ispService;



@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/p_isp")
public class projet_ispController{
	@Autowired
	projet_ispService StockService;
	// http://localhost:8089/p_isp/show
	@GetMapping("/show")
	@ResponseBody
	public List<projet_isp> getAllprojet_isp() {
	List<projet_isp> listStock = StockService.getAllprojet_isp();
	return listStock;
	}
	
	// http://localhost:8089/p_isp/add
	
	@PostMapping("/add")
	public void create(@RequestBody projet_isp Stock)
	{
	 StockService.create(Stock);
	
	
	}
	// http://localhost:8089/p_isp/Delete/{idStock}
	@DeleteMapping("/Delete/{idStock}")
	@ResponseBody
	public void Deleteprojet_isp(@PathVariable("idStock") long id)
	{
		StockService.deleteprojet_isp(id);
	}
	
	// http://localhost:8089/p_isp/update
	 @PutMapping("/update")
	 @ResponseBody
	 public void updateprojet_isp(@RequestBody projet_isp stock)
	 {
	  StockService.updateprojet_isp(stock);
	  }
}


