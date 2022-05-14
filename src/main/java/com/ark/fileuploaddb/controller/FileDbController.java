package com.ark.fileuploaddb.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ark.fileuploaddb.model.FileDb;
import com.ark.fileuploaddb.model.FileResponse;
import com.ark.fileuploaddb.service.FileDbService;

@RestController
@RequestMapping("file")
public class FileDbController {
	
	@Autowired
	private FileDbService fileDbService;
	// http://localhost:8060/file
	@PostMapping
	public FileResponse uploadFile(@RequestParam("file") MultipartFile  file) throws IOException {
		return fileDbService.store(file);
	}
	// http://localhost:8060/file/{id}
	@GetMapping("/{id}")
	public FileDb getFile(@PathVariable String id) {
		
		return fileDbService.getFileById(id);
		
	}
	// http://localhost:8060/file/list
	@GetMapping("/list")
	public List<FileResponse> getFileList(){
		return fileDbService.getFileList();
	}
	// http://localhost:8060/file/d/{id}
	@GetMapping("d/{id}")
	public ResponseEntity<ByteArrayResource> getFilee(@PathVariable String id) {
		
		FileDb fileDB=fileDbService.getFileById(id);
	
	 return ResponseEntity.ok()
             .contentType(MediaType.parseMediaType(fileDB.getType()))
             .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename= "+fileDB.getName())
             .body(new ByteArrayResource(fileDB.getData()));
 }
}
