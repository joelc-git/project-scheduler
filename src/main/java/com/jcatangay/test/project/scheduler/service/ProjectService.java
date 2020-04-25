package com.jcatangay.test.project.scheduler.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcatangay.test.project.scheduler.model.Project;
import com.jcatangay.test.project.scheduler.model.Task;
import com.jcatangay.test.project.scheduler.model.TaskDependency;
import com.jcatangay.test.project.scheduler.repository.ProjectRepository;
import com.jcatangay.test.project.scheduler.repository.TaskDependencyRepository;
import com.jcatangay.test.project.scheduler.repository.TaskRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private TaskDependencyRepository taskDependencyRepository;
	
	@Autowired
	private ComputeScheduleService computeScheduleService;
	
	@Autowired
	private TaskComparatorService taskComparatorService;
	
	
	public Project getProject(int id){
		Project project = projectRepository.findById(id);
		if(project != null){
			List<Task> tasks = taskRepository.findByProjectId(project.getId());
			List<TaskDependency> taskDependencies = taskDependencyRepository.findByProjectId(project.getId());
			mapTasks(tasks, taskDependencies);
			computeScheduleService.compute(tasks, project.getStartDate());
			Collections.sort(tasks, taskComparatorService);
			project.setTasks(tasks);
		}
		return project;
	}
	
	private static void mapTasks(List<Task> tasks, List<TaskDependency> taskDependencies){
		Map<Integer, Task> taskMap = new HashMap<Integer, Task>(tasks.size());
		tasks.forEach(task -> taskMap.putIfAbsent(task.getId(), task));
		taskDependencies.forEach(taskDependency -> {
			Task task = taskMap.get(taskDependency.getTaskId());
			Task dependsOn = taskMap.get(taskDependency.getDependsOn());
			task.getDependsOn().add(dependsOn);
		});
		
	}
}
