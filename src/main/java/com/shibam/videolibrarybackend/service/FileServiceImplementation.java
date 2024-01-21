package com.shibam.videolibrarybackend.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shibam.videolibrarybackend.dtos.FileModel;

@Service
public class FileServiceImplementation implements FileService {
	
	@Override
	public FileModel uploadVideo(String path, MultipartFile file) throws IOException {
		FileModel fileModel = new FileModel();
		//Fetch file original name .
		String fileName = file.getOriginalFilename();
		//try to generate random file name .
		String randomId = UUID.randomUUID().toString();
		String finalName = randomId.concat(fileName.substring(fileName.indexOf(".")));
		
		//File full path .
		String filePath = path + File.separator + finalName ;
		
		//Create folder to store file .you can create any where you want .
		File f = new File(path);
		if(!f.exists()) {
			f.mkdir();
		}

		Files.copy(file.getInputStream(),Paths.get(filePath));
	
		fileModel.setVideoFileName(finalName);
		
		return fileModel;
	}
	
	@Override
	public InputStream getVideoFile(String path, String fileName, int id) throws  FileNotFoundException {
		String fullPath = path+File.separator+fileName ;
		InputStream inputStream = new FileInputStream(fullPath);
		return inputStream ;
	}

}
