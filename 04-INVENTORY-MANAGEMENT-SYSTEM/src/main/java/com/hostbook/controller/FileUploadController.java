package com.hostbook.controller;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.hostbook.dto.ItemDTO;
import com.hostbook.service.FileUploadService;
import com.hostbook.service.ItemService;
import org.springframework.http.MediaType;

@RestController
public class FileUploadController {

	@Autowired
	private FileUploadService fileUploadservice;

	@PostMapping(value="/upload-file",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	//public ResponseEntity<String> uploadFile( @RequestPart MultipartFile file) {

	public ResponseEntity<String> uploadFile(@RequestBody MultipartFile file,ItemDTO itemDTO) {
	    fileUploadservice.uploadFile(file);
	

		return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/")
				.path(file.getOriginalFilename()).toUriString());
	}

}
