package com.jcatangay.test.project.scheduler.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jcatangay.test.project.scheduler.model.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> {

	List<Task> findByProjectId(int projectId);
}
