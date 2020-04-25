package com.jcatangay.test.project.scheduler.model;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Task {
	@Id
	private int id;
	private int projectId;
	private String name;
	private int  duration;
	
	@Transient
	private Date startDate;
	@Transient
	private Date endDate;
	
	@Transient
	@JsonIgnore
	private List<Task> dependsOn;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public List<Task> getDependsOn() {
		if(dependsOn == null){
			dependsOn = new ArrayList<Task>();
		}
		return dependsOn;
	}
	public void setDependsOn(List<Task> dependsOn) {
		this.dependsOn = dependsOn;
	}
	
	
}
