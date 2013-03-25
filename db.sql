SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `solancercom` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `solancercom` ;

-- -----------------------------------------------------
-- Table `solancercom`.`artists`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `solancercom`.`artists` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `solancercom`.`genres`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `solancercom`.`genres` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(128) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `solancercom`.`albums`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `solancercom`.`albums` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `artist_id` INT NOT NULL ,
  `genre_id` INT NOT NULL ,
  `name` VARCHAR(128) NOT NULL ,
  `al_release` DATE NULL ,
  `info` TEXT NULL ,
  `image` TEXT NULL ,
  PRIMARY KEY (`id`, `artist_id`, `genre_id`) ,
  INDEX `fk_album_artist_idx` (`artist_id` ASC) ,
  INDEX `fk_album_category1_idx` (`genre_id` ASC) ,
  CONSTRAINT `fk_album_artist`
    FOREIGN KEY (`artist_id` )
    REFERENCES `solancercom`.`artists` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_album_category1`
    FOREIGN KEY (`genre_id` )
    REFERENCES `solancercom`.`genres` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `solancercom`.`tracks`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `solancercom`.`tracks` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `album_id` INT NOT NULL ,
  `name` VARCHAR(128) NOT NULL ,
  `time` DECIMAL NOT NULL ,
  PRIMARY KEY (`id`, `album_id`) ,
  INDEX `fk_track_album1_idx` (`album_id` ASC) ,
  CONSTRAINT `fk_track_album1`
    FOREIGN KEY (`album_id` )
    REFERENCES `solancercom`.`albums` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `solancercom` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
