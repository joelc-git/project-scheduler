package com.jcatangay.test.project.scheduler.service;

import java.sql.Date;
import java.util.Calendar;
//import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.jcatangay.test.project.scheduler.model.Task;

@Service 
public class ComputeScheduleService {

	
	private static Calendar calendar = Calendar.getInstance();
	
	public void compute(List<Task> tasks, Date projectStartDate){
		for(Task task : tasks){
			computeTaskSchedule(task, projectStartDate);
			
		}
	}
	
	private void computeTaskSchedule(Task task, Date projectStartDate){
		if(task.getStartDate() == null && task.getEndDate() == null){
			if(CollectionUtils.isEmpty(task.getDependsOn())){
				task.setStartDate(projectStartDate);
				task.setEndDate(addDaysSkippingWeekend(task.getStartDate(), task.getDuration()-1));
			}else{
				Date maxEndDate = null;
				for(Task dependsOnTask : task.getDependsOn()){
					if(dependsOnTask.getStartDate() == null && dependsOnTask.getEndDate() == null){
						computeTaskSchedule(dependsOnTask, projectStartDate);
					}
					if(maxEndDate == null){
						maxEndDate = dependsOnTask.getEndDate();
					}else{
						if(maxEndDate.before(dependsOnTask.getEndDate())){
							maxEndDate = dependsOnTask.getEndDate();
						}
					}
				}
				task.setStartDate(addDaysSkippingWeekend(maxEndDate, 1));
				task.setEndDate(addDaysSkippingWeekend(task.getStartDate(), task.getDuration()-1));
			}
		}
		
	}
	
	private static Date addDaysSkippingWeekend(Date startDate, int days){
		calendar.setTime(startDate);
		int addedDays = 0;
		while (addedDays < days) {
	        calendar.add(Calendar.DATE, 1);
	        if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY &&  calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
	            ++addedDays;
	        }
	    }
		return new Date(calendar.getTimeInMillis());
	}
}
