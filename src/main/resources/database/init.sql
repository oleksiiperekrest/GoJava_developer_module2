create schema homework1;
USE homework1;

CREATE TABLE developers (
  id         INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name  VARCHAR(50) NOT NULL,
  salary DECIMAL(13,4) NOT NULL
);

CREATE TABLE skills (
  id          INT AUTO_INCREMENT PRIMARY KEY,
  description VARCHAR(50) NOT NULL
);

CREATE TABLE projects (
  id          INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50),
  description VARCHAR(100),
  cost DECIMAL(13,4)
);

CREATE TABLE companies (
  id          INT AUTO_INCREMENT PRIMARY KEY,
  name        VARCHAR(50),
  country     VARCHAR(20),
  description VARCHAR(100)
);

CREATE TABLE customers (
  id         INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(50)  NOT NULL,
  last_name  VARCHAR(50)  NOT NULL,
  info       VARCHAR(100) NOT NULL
);


CREATE TABLE developers_skills (
  developer_id INT NOT NULL,
  skill_id     INT NOT NULL,
  PRIMARY KEY (developer_id, skill_id)
);

CREATE TABLE projects_developers (
  project_id   INT NOT NULL,
  developer_id INT NOT NULL,
  PRIMARY KEY (project_id,developer_id)
);

CREATE TABLE developers_companies (
  developer_id INT NOT NULL,
  company_id  INT NOT NULL,
  PRIMARY KEY (developer_id, company_id)
);

CREATE TABLE customers_projects (
  customer_id INT NOT NULL,
  project_id  INT NOT NULL,
  PRIMARY KEY (customer_id, project_id)
);







