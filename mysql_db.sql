CREATE SCHEMA IF NOT EXISTS `learn2db` DEFAULT CHARACTER SET utf8 ;
USE `learn2db` ;

-- !!! remove all !!!
DROP TRIGGER IF EXISTS employee_before_insert;
DROP TRIGGER IF EXISTS employee_before_update;
DROP TRIGGER IF EXISTS project_before_insert;
DROP TRIGGER IF EXISTS project_before_update;
DROP function IF EXISTS `generateSeoUrl`;

drop table IF EXISTS `learn2db`.`employee_has_project`;
drop TABLE IF EXISTS `learn2db`.`employeeRating`;
drop TABLE IF EXISTS `learn2db`.`projectRequirement`;

drop table IF EXISTS `learn2db`.`employee`;
drop table IF EXISTS `learn2db`.`project`;
drop table IF EXISTS `learn2db`.`skill`;
drop table IF EXISTS `learn2db`.`role`;

-- !!! build all !!!
CREATE TABLE IF NOT EXISTS `learn2db`.`employee` (
  `employeeId` INT AUTO_INCREMENT PRIMARY KEY,
  `seoUrl` VARCHAR(90),
  `name` VARCHAR(45) NOT NULL);

CREATE TABLE IF NOT EXISTS `learn2db`.`project` (
  `projectId` INT AUTO_INCREMENT PRIMARY KEY,
  `seoUrl` VARCHAR(90),
  `name` VARCHAR(45) NOT NULL,
  `teamSize` INT NOT NULL);

CREATE TABLE IF NOT EXISTS `learn2db`.`skill` (
  `skillId` INT AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(45) NOT NULL);

CREATE TABLE IF NOT EXISTS `learn2db`.`role` (
  `roleId` INT AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(45) NOT NULL);

CREATE TABLE IF NOT EXISTS `learn2db`.`employee_has_project` (
	`employeeId` INT NOT NULL,
	`projectId` INT NOT NULL,
	`roleId` INT NOT NULL,
	PRIMARY KEY (`employeeId`, `projectId`),
    FOREIGN KEY (`employeeId`)
		REFERENCES `learn2db`.`employee` (`employeeId`)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION,
	FOREIGN KEY (`projectId`)
		REFERENCES `learn2db`.`project` (`projectId`)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION,
	FOREIGN KEY (`roleId`)
		REFERENCES `learn2db`.`role` (`roleId`)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION);
	
CREATE TABLE IF NOT EXISTS `learn2db`.`employeeRating` (
	`employeeId` INT NOT NULL,
	`skillId` INT NOT NULL,
	`rating` INT NOT NULL,
	PRIMARY KEY (`employeeId`, `skillId`),
    FOREIGN KEY (`employeeId`)
		REFERENCES `learn2db`.`employee` (`employeeId`)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION,
	FOREIGN KEY (`skillId`)
		REFERENCES `learn2db`.`skill` (`skillId`)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `learn2db`.`projectRequirement` (
	`projectId` INT NOT NULL,
	`skillId` INT NOT NULL,
	`rating` INT NOT NULL,
	PRIMARY KEY (`projectId`, `skillId`),
    FOREIGN KEY (`projectId`)
		REFERENCES `learn2db`.`project` (`projectId`)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION,
	FOREIGN KEY (`skillId`)
		REFERENCES `learn2db`.`skill` (`skillId`)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION);

-- !!! add functions and trigger !!!
SET GLOBAL log_bin_trust_function_creators = 1;
DELIMITER $$
CREATE FUNCTION `generateSeoUrl` (name varchar(45))
	RETURNS varchar(90)
	BEGIN
	-- REPLACE(str,from_str,to_str)
    -- LCASE(str)
    -- RTrom(str)
    -- LTRIM(str)
    -- CONCAT(LCASE(REPLACE(name,' ','-')),'-'id)
	RETURN CONCAT(LCASE(REPLACE(name,' ','-')),'-');
END$$

CREATE TRIGGER `employee_before_insert` before INSERT 
	ON `employee` FOR EACH ROW
    BEGIN
		SET NEW.seoUrl = generateSeoUrl(new.name);
    END$$
    
CREATE TRIGGER `employee_before_update` before update 
	ON `employee` FOR EACH ROW
    BEGIN
		SET NEW.seoUrl = generateSeoUrl(new.name);
    END$$
    
CREATE TRIGGER `project_before_insert` before INSERT 
	ON `project` FOR EACH ROW
    BEGIN
		SET NEW.seoUrl = generateSeoUrl(new.name);
    END$$
    
CREATE TRIGGER `project_before_update` before update 
	ON `project` FOR EACH ROW
    BEGIN
		SET NEW.seoUrl = generateSeoUrl(new.name);
    END$$
DELIMITER ;

-- !!! add mock data !!!
insert into employee(name)
values
	('Mathias Schoepke'),
    ('Max Mustermann');
insert into project(name,teamSize)
values
	('Some Project',4),
    ('Another Project 2020',7);
insert into skill(name)
values
	('Leader'),
    ('Skill A'),
    ('Skill B'),
    ('Skill C');
insert into role(name)
values
	('Project Manager'),
    ('Worker'),
    ('QA');
insert into employee_has_project(employeeId,projectId,roleId)
values
	(1,1,1),
    (1,2,3),
    (2,1,1);
insert into employeeRating(employeeId,skillId,rating)
values
	(1,1,3),
    (1,2,4),
    (1,3,2),
    (2,1,2),
    (2,4,5);
insert into projectRequirement(projectId,skillId,rating)
values
	(1,1,2),
    (1,2,1),
    (1,3,1),
    (2,1,3),
    (2,4,3);