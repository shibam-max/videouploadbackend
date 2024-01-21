package com.shibam.videolibrarybackend.dtos;


	
	
	public class FileModel {

	    private String videoFileName;

	    public FileModel() {
	        // Default constructor
	    }
	    
	    public FileModel(String videoFileName) {
	        this.videoFileName = videoFileName;
	    }

	    public String getVideoFileName() {
	        return videoFileName;
	    }

	    public void setVideoFileName(String videoFileName) {
	        this.videoFileName = videoFileName;
	    }
	}

	

