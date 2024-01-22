package com.shibam.videolibrarybackend.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.shibam.videolibrarybackend.entity.VideoEntity;
import com.shibam.videolibrarybackend.exception.ResourceNotFoundException;
import com.shibam.videolibrarybackend.repository.VideoRepository;

@Service
public class VideoServiceImpl implements VideoService {
	
	@Autowired
	private VideoRepository videoRepository ;

	
	@Override
	public VideoEntity createPost(VideoEntity videoEntity) {
		
		if(videoEntity.getTitle().isEmpty()) {
			throw new ResourceNotFoundException(false,"video title can not be null or empty");
		}
		try {
			videoEntity.setAddedDate(new Date());
			VideoEntity video = videoRepository.save(videoEntity);
			
			return video;
			
		}catch(Exception e) {
			throw new ResourceNotFoundException(false  ,"something went wrong");
		}
		
		
	}
	
	@Override
	public VideoEntity getById(Integer id) {
		if (id == null) {
	        throw new ResourceNotFoundException(false, "Video id must not be null");
	    }

	    VideoEntity video = videoRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException(false, "Video with id " + id + " not found"));
	    
	    return video;
	}
	
	@Override
	public VideoEntity updatePost(VideoEntity videoEntity,Integer id) {
		VideoEntity video = videoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(false,"video id not found"));
	    video.setDescription(videoEntity.getDescription());
	    video.setTitle(videoEntity.getTitle());
	    video.setAddedDate(videoEntity.getAddedDate());
	    video.setTags(videoEntity.getTags());
	    VideoEntity updateVideosFields = videoRepository.save(video);
	    return updateVideosFields;
	}
	
	@Override
    public void deleteVideos(Integer id) {
        // Check if the video exists
        if (!videoRepository.existsById(id)) {
            throw new ResourceNotFoundException(false, "Video not found for deletion");
        }

        // Video exists, delete it
        videoRepository.deleteById(id);
    }
	
	
	
	@Override
	public List<VideoEntity> getallPost(){
		return videoRepository.findAll();
	}
	
	 @Override
	 public void mergeVideos(List<Integer> videoIds) {
	        if (videoIds.size() < 2) {
	            throw new IllegalArgumentException("At least two videos are required for merging.");
	        }

	        // Fetch videos from the database
	        List<VideoEntity> videosToMerge = new ArrayList<>();
	        for (Integer videoId : videoIds) {
	            VideoEntity video = videoRepository.findById(videoId)
	                    .orElseThrow(() -> new ResourceNotFoundException(false, "Video with id " + videoId + " not found"));
	            videosToMerge.add(video);
	        }

	        // Implement video merging logic here
	        // For simplicity, you can update the first video with merged content
	        VideoEntity mergedVideo = videosToMerge.get(0);
	        mergedVideo.setTitle("Merged Video");
	        mergedVideo.setDescription("This is a merged video containing content from multiple videos.");
	        mergedVideo.setTags("Merged, Multi-Video");

	        // Save the merged video
	        videoRepository.save(mergedVideo);

	        // Delete the other videos after merging
	        for (int i = 1; i < videosToMerge.size(); i++) {
	            VideoEntity videoToDelete = videosToMerge.get(i);
	            videoRepository.deleteById(videoToDelete.getId());
	        }
	    }
	}


