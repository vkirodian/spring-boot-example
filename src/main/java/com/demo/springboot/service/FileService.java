package com.demo.springboot.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	void uploadFile(MultipartFile file) throws IOException;

	ResponseEntity<Object> downloadFile() throws FileNotFoundException;

}