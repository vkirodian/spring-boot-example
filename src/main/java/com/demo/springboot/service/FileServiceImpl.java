package com.demo.springboot.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Service class for File Controller.
 * 
 * @author Vijesh Kirodian
 *
 */
@Service
public class FileServiceImpl implements FileService {

	@Override
	public void uploadFile(MultipartFile file) throws IOException {
		File inboundFile = new File("images/" + file.getOriginalFilename());
		inboundFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(inboundFile);
		fout.write(file.getBytes());
		fout.close();
	}

	@Override
	public ResponseEntity<Object> downloadFile() throws FileNotFoundException {
		String filename = "images/imagefordownload.jpg";
		File file = new File(filename);
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		HttpHeaders headers = new HttpHeaders();

		headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length())
				.contentType(MediaType.parseMediaType("application/txt")).body(resource);
		return responseEntity;
	}
}
