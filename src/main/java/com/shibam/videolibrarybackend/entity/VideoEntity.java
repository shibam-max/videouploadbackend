package com.shibam.videolibrarybackend.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "videoUpload")
public class VideoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 50)
    private String title;

    @Column(length = 200)
    private String description;

    @Column
    private String tags;

    @Column
    private String videoName;

    @Column
    private Date addedDate;

    public VideoEntity() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public VideoEntity(Integer id, String title, String description, String tags, String videoName, Date addedDate) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.tags = tags;
        this.videoName = videoName;
        this.addedDate = addedDate;
    }

    @Override
    public String toString() {
        return "VideoEntity [id=" + id + ", title=" + title + ", description=" + description +
                ", tags=" + tags + ", videoName=" + videoName + ", addedDate=" + addedDate + "]";
    }
}
