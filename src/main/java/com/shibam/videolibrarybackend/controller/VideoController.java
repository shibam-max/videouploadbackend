package com.shibam.videolibrarybackend.controller;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shibam.videolibrarybackend.dtos.FileModel;
import com.shibam.videolibrarybackend.entity.VideoEntity;
import com.shibam.videolibrarybackend.exception.ResourceNotFoundException;
import com.shibam.videolibrarybackend.repository.VideoRepository;
import com.shibam.videolibrarybackend.service.FileService;
import com.shibam.videolibrarybackend.service.VideoService;

import jakarta.persistence.criteria.Path;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class VideoController {
	
	@Value("${project.video")
	private String path;
	
	@Autowired
	private VideoService videoService;
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private VideoRepository videoRepository;
	
	
	@PostMapping("/save")
	public ResponseEntity<?> saveVideo(@RequestBody VideoEntity video) {
		
			return new ResponseEntity<VideoEntity>(videoService.createPost(video), HttpStatus.OK);
		
	}
	
	
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllVideos(){
		return new ResponseEntity<List<VideoEntity>>(videoService.getallPost(),HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public VideoEntity getVideoById(@PathVariable Integer id) {
		return videoService.getById(id);
	}
	
	
	
	@PostMapping("/upload/{id}")
	public VideoEntity uploadingVideo(@RequestParam("video") MultipartFile video,@PathVariable Integer id) 
		throws IOException {
			VideoEntity v = videoService.getById(id);
			FileModel fileModel = fileService.uploadVideo(path,video); 
			v.setVideoName(fileModel.getVideoFileName());
			VideoEntity finallyUpload = videoService.updatePost(v, id);
			return finallyUpload;
		}
	@GetMapping(value = "/play/{id}",produces = MediaType.ALL_VALUE)
	public void playVideo(@PathVariable Integer id, HttpServletResponse response) throws IOException {
		Optional<VideoEntity> video = videoRepository.findById(id);
		InputStream resource = fileService.getVideoFile(path, video.get().getVideoName(),id);
		response.setContentType(MediaType.ALL_VALUE);
		StreamUtils.copy(resource, response.getOutputStream());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteVideo(@PathVariable Integer id) {
	    try {
	        // Assuming your VideoService has a method for deleting videos
	        videoService.deleteVideos(id);
	        return ResponseEntity.ok("Video deleted successfully");
	    } catch (ResourceNotFoundException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Video not found");
	    }
	}
	
	
	@PutMapping("/update/{id}")
	public VideoEntity updateVideo(@RequestBody VideoEntity videoEntity, @PathVariable Integer id) {
	    return videoService.updatePost(videoEntity, id);
	}
	

}



