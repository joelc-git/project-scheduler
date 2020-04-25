# project-scheduler

To install:

1. Clone or download as zip the project into local directory.
	a. If zip is used, extract the zip file.
2. In the command line, go to the the project's home directory.
2. Type command 'mvnw clean install' to build the project.

To run:

1. From the project's home directory type command 'java -jar target/project-scheduler-0.0.1-SNAPSHOT.jar'

To access the web service:

1. In the browser or Postman, access the service via GET http://localhost:8080/project-scheduler-rest/project/1

This will return json response of the Project with id=1, and the tasks with the scheduled dates.

Notes:
1. Test data is configured in src/main/resources/data.sql
2. Test data is created on  H2 database (an in-memory relational database) everytime the application is started.
3. The code assumes that tasks dependencies are not circualar. That is, if task A is dependent on task B, task B or any tasks that B depends on does not depends on A. It is assumed that this constraint will be handled on the data entry.
4. Start date is defined on the project table.
5. Duration is in unit of days.
6. A task's start date is 1 day after the end date of the task it depends on. In case a task does not depend on any task, it starts on the project's start date.
7. The Task's end date is deterimined by start date + duration - 1 day. That is, a task with duration of 1 day will be started and finished on the same day.
8. Computation of start and end date skips weekend (Saturday and Sunday).Example, if a task starts on Friday with a duration of 2 days, it will end on Monday.




