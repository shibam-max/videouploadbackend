package com.shibam.videolibrarybackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shibam.videolibrarybackend.entity.VideoEntity;



@Repository
public interface VideoRepository extends JpaRepository<VideoEntity, Integer> {
	
	
	
	
	

	

}