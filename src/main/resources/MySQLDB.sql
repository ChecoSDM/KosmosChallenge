-- -----------------------------------------------------
-- Schema demo-app-kosmos
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `demo-app-kosmos`;

CREATE SCHEMA `demo-app-kosmos`;
USE `demo-app-kosmos` ;


-- -----------------------------------------------------
-- Schema demo-app-kosmos
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `demo-app-kosmos`;

CREATE SCHEMA `demo-app-kosmos`;
USE `demo-app-kosmos` ;



-- -----------------------------------------------------
-- Table `demo-app-kosmos`.`doctor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `demo-app-kosmos`.`doctor` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) DEFAULT NULL,
  `first_surname` VARCHAR(255) DEFAULT NULL,
  `second_surname` VARCHAR(255) DEFAULT NULL,
  `specialty` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 
ENGINE=InnoDB
AUTO_INCREMENT = 1;

-- -----------------------------------------------------
-- Table `demo-app-kosmos`.`office`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `demo-app-kosmos`.`office` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `office_number` INT(11) DEFAULT NULL,
  `floor_number` INT(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 
ENGINE=InnoDB
AUTO_INCREMENT = 1;

-- -----------------------------------------------------
-- Table `demo-app-kosmos`.`appointment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `demo-app-kosmos`.`appointment` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `office_number` INT(11) DEFAULT NULL,
  `appointment_date` DATETIME(6) DEFAULT NULL,
  `patient_name` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 
ENGINE=InnoDB
AUTO_INCREMENT = 1;