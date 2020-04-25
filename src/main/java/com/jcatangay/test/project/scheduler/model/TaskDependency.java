package com.jcatangay.test.project.scheduler.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TaskDependency {
	@Id
	private int id;
	private int taskId;
	private int dependsOn;
	private int projectId;
	
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public int getDependsOn() {
		return dependsOn;
	}
	public void setDependsOn(int dependsOn) {
		this.dependsOn = dependsOn;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
}
