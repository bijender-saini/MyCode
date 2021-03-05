package com.hostbook.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.hostbook.repository.ItemRepository;

@Service
public class FileUploadService {

	@Autowired
	private ItemRepository itemRepository;

	// String upload_Dir = new
	// ClassPathResource("static/image/").getFile().getAbsolutePath();

	String upload_Dir = "D:/sts-0/Hibernate-practice/04-INVENTORY-MANAGEMENT-SYSTEM/src/main/resources/static/image";

	public FileUploadService() throws IOException {
		// TODO Auto-generated constructor stub
	}

	public boolean uploadFile(MultipartFile multipartFile) {

		boolean f = false;

		try {

			// InputStream is = multipartFile.getInputStream();

			Files.copy(multipartFile.getInputStream(),
					Paths.get(upload_Dir + File.separator + multipartFile.getOriginalFilename()),

					StandardCopyOption.REPLACE_EXISTING);

			UriComponentsBuilder uriString = ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/");
			
			

			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
