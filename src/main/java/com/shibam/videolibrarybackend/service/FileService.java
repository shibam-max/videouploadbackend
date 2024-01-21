package com.shibam.videolibrarybackend.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

import com.shibam.videolibrarybackend.dtos.FileModel;


public interface FileService {
	
	FileModel uploadVideo(String path,MultipartFile file) throws IOException;
	
	InputStream getVideoFile(String path,String fileName,int id) throws FileNotFoundException;

}
