package com.jcatangay.test.project.scheduler.repository;

import org.springframework.data.repository.CrudRepository;

import com.jcatangay.test.project.scheduler.model.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer> {

	Project findById(int id);
}
