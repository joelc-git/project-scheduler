package com.jcatangay.test.project.scheduler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jcatangay.test.project.scheduler.model.Project;
import com.jcatangay.test.project.scheduler.service.ProjectService;

@RestController
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@GetMapping(value = "/project/{id}", produces = "application/json")
	public ResponseEntity<Object> getProject(@PathVariable("id") final int id) {
		Project project = projectService.getProject(id);
		if (project != null) {
			return new ResponseEntity<Object>(project, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("Project id: " + id
					+ " not found", HttpStatus.NOT_FOUND);
		}
	}
}
