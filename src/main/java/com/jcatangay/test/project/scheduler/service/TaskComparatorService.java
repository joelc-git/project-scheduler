package com.jcatangay.test.project.scheduler.service;

import java.util.Comparator;

import org.springframework.stereotype.Service;

import com.jcatangay.test.project.scheduler.model.Task;

@Service
public class TaskComparatorService implements Comparator<Task> {

	@Override
	public int compare(Task o1, Task o2) {
		if(o1.getStartDate().before(o2.getStartDate())){
			return -1;
		}else if(o1.getStartDate().after(o2.getStartDate())){
			return 1;
		}else{
			return 0;
		}
	}

}
