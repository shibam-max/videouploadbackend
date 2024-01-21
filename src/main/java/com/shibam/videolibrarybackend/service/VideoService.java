package com.shibam.videolibrarybackend.service;



import java.util.List;

import com.shibam.videolibrarybackend.entity.VideoEntity;


public interface VideoService {
	
	public VideoEntity createPost(VideoEntity videoEntity);
	public VideoEntity getById(Integer id);
	public VideoEntity updatePost(VideoEntity videoEntity,Integer id);
	public void deleteVideos(Integer id);
	public List<VideoEntity> getallPost();
	

}
