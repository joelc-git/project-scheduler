package com.jcatangay.test.project.scheduler.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jcatangay.test.project.scheduler.model.TaskDependency;

public interface TaskDependencyRepository extends CrudRepository<TaskDependency, Integer> {

	List<TaskDependency> findByProjectId(int projectId);
}
