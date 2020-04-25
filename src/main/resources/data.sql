DROP TABLE IF EXISTS project;
DROP TABLE IF EXISTS task;
DROP TABLE IF EXISTS task_dependency;

CREATE TABLE project (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  start_date DATE NOT NULL
);

INSERT INTO project (id, name, start_date) VALUES
  (1, 'Project 1', TO_DATE( '1-MAY-2020', 'DD-MON-YYYY' ));

CREATE TABLE task (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  project_id INT NOT NULL,
  name VARCHAR(250) NOT NULL,
  duration int NOT NULL
);

INSERT INTO task (id, project_id, name, duration) VALUES
  (1, 1, 'Task 1', 3),
  (2, 1, 'Task 2', 4),
  (3, 1, 'Task 3', 2),
  (4, 1, 'Task 4', 1),
  (5, 1, 'Task 5', 5),
  (6, 1, 'Task 6', 2),
  (7, 1, 'Task 7', 1),
  (8, 1, 'Task 8', 2),
  (9, 1, 'Task 9', 7),
  (10, 1, 'Task 10', 4);

CREATE TABLE task_dependency (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  task_id INT NOT NULL,
  depends_on INT NOT NULL,
  project_id INT NOT NULL
);

INSERT INTO task_dependency (task_id, depends_on, project_id) VALUES
  (1,5,1),
  (1,2,1),
  (2,5,1),
  (2,3,1),
  (3,4,1),
  (4,8,1),
  (5,10,1),
  (6,4,1),
  (6,8,1),
  (7,2,1),
  (7,10,1),
  (9,1,1),
  (10,6,1);