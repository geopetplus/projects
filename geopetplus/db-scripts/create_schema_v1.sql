-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
SHOW WARNINGS;
-- -----------------------------------------------------
-- Schema geopetplus_dev
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `geopetplus_dev` ;

-- -----------------------------------------------------
-- Schema geopetplus_dev
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `geopetplus_dev` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `geopetplus_dev` ;

-- -----------------------------------------------------
-- Table `facilitydemographics`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facilitydemographics` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `facilitydemographics` (
  `facilityid` VARCHAR(11) NOT NULL,
  `facilityname` VARCHAR(50) NOT NULL,
  `contactlastname` VARCHAR(45) NOT NULL,
  `contactfirstname` VARCHAR(45) NOT NULL,
  `versionid` VARCHAR(4) NOT NULL,
  `mailaddr1` VARCHAR(100) NOT NULL,
  `mailaddr2` VARCHAR(100) NULL DEFAULT NULL,
  `mailinglocation` VARCHAR(45) NOT NULL,
  `mailingcity` VARCHAR(45) NOT NULL,
  `mailingstate` VARCHAR(45) NOT NULL,
  `mailingpincode` VARCHAR(10) NOT NULL,
  `billaddr1` VARCHAR(100) NOT NULL,
  `billaddr2` VARCHAR(100) NULL DEFAULT NULL,
  `billlocation` VARCHAR(45) NOT NULL,
  `billcity` VARCHAR(45) NOT NULL,
  `billstate` VARCHAR(45) NOT NULL,
  `billpincode` VARCHAR(10) NOT NULL,
  `facilityphone` VARCHAR(10) NOT NULL,
  `facilityaltphone` VARCHAR(10) NULL DEFAULT NULL,
  `facilymobilenum` VARCHAR(10) NOT NULL,
  `facilitywhatsappnum` VARCHAR(10) NOT NULL,
  `facilityemail1` VARCHAR(50) NOT NULL,
  `facilityemail2` VARCHAR(50) NULL DEFAULT NULL,
  `facilityurl` VARCHAR(50) NULL DEFAULT NULL,
  `facilityregstartdate` DATETIME NOT NULL,
  `facilityregenddate` DATETIME NOT NULL,
  `lastupdatedate` DATETIME NOT NULL,
  `auditid` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`facilityid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE UNIQUE INDEX `facilityid_UNIQUE` ON `facilitydemographics` (`facilityid` ASC);

SHOW WARNINGS;
CREATE UNIQUE INDEX `facilityphone_UNIQUE` ON `facilitydemographics` (`facilityphone` ASC);

SHOW WARNINGS;
CREATE UNIQUE INDEX `facilymobilenum_UNIQUE` ON `facilitydemographics` (`facilymobilenum` ASC);

SHOW WARNINGS;
CREATE UNIQUE INDEX `facilityemail1_UNIQUE` ON `facilitydemographics` (`facilityemail1` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `login`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `login` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `login` (
  `facilityid` VARCHAR(11) NOT NULL,
  `versionid` VARCHAR(4) NOT NULL,
  `userid` VARCHAR(11) NOT NULL,
  `password` VARCHAR(10) NOT NULL,
  `lastupdated` DATETIME NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  `status` VARCHAR(3) NOT NULL,
  `auditid` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`facilityid`),
  CONSTRAINT `facilityid_fk1`
    FOREIGN KEY (`facilityid`)
    REFERENCES `facilitydemographics` (`facilityid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE UNIQUE INDEX `facilityid_UNIQUE` ON `login` (`facilityid` ASC);

SHOW WARNINGS;
CREATE UNIQUE INDEX `userid_UNIQUE` ON `login` (`userid` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `admindemographics`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `admindemographics` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `admindemographics` (
  `adminid` VARCHAR(11) NOT NULL,
  `adminfirstname` VARCHAR(45) NOT NULL,
  `adminlastname` VARCHAR(45) NOT NULL,
  `adminaddr1` VARCHAR(100) NOT NULL,
  `adminaddr2` VARCHAR(100) NULL DEFAULT NULL,
  `admincity` VARCHAR(45) NOT NULL,
  `adminstate` VARCHAR(45) NOT NULL,
  `adminpincode` VARCHAR(10) NOT NULL,
  `admincontact` VARCHAR(10) NOT NULL,
  `adminaltcontact` VARCHAR(10) NULL DEFAULT NULL,
  `adminmobilecontact` VARCHAR(10) NOT NULL,
  `adminemail` VARCHAR(50) NOT NULL,
  `adminregstart` DATETIME NOT NULL,
  `adminregend` DATETIME NOT NULL,
  `lastupdatedate` DATETIME NOT NULL,
  `status` VARCHAR(3) NOT NULL,
  `auditid` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`adminid`),
  CONSTRAINT `adminid_fk1`
    FOREIGN KEY (`adminid`)
    REFERENCES `login` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE UNIQUE INDEX `adminid_UNIQUE` ON `admindemographics` (`adminid` ASC);

SHOW WARNINGS;
CREATE INDEX `status_fk1_idx` ON `admindemographics` (`status` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `audit`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `audit` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `audit` (
  `auditid` VARCHAR(36) NOT NULL,
  `typeofrequest` VARCHAR(200) NOT NULL,
  `transaction` VARCHAR(200) NOT NULL,
  `adminid` VARCHAR(11) NOT NULL,
  `requestchannel` VARCHAR(10) NOT NULL,
  `useragent` VARCHAR(200) NOT NULL,
  `facilityid` VARCHAR(11) NOT NULL,
  `requestdate` DATETIME NOT NULL,
  PRIMARY KEY (`auditid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE UNIQUE INDEX `auditid_UNIQUE` ON `audit` (`auditid` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `dbproperty`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dbproperty` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `dbproperty` (
  `id` VARCHAR(45) NOT NULL,
  `value` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE UNIQUE INDEX `id_UNIQUE` ON `dbproperty` (`id` ASC);

SHOW WARNINGS;
CREATE UNIQUE INDEX `value_UNIQUE` ON `dbproperty` (`value` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `discountcodes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `discountcodes` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `discountcodes` (
  `discountid` VARCHAR(6) NOT NULL,
  `discountpercent` INT(3) NOT NULL,
  `effectivedate` DATETIME NOT NULL,
  `enddate` DATETIME NOT NULL,
  PRIMARY KEY (`discountid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE UNIQUE INDEX `discountid_UNIQUE` ON `discountcodes` (`discountid` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `facilitylatestversion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facilitylatestversion` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `facilitylatestversion` (
  `facilityid` VARCHAR(11) NOT NULL,
  `latestAddrVersion` VARCHAR(4) NOT NULL,
  `latestloginVersion` VARCHAR(4) NOT NULL,
  `policyid` VARCHAR(11) NOT NULL,
  `latesttermid` VARCHAR(6) NOT NULL,
  `latesttransactionseqnbr` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`facilityid`),
  CONSTRAINT `facilityid_fk2`
    FOREIGN KEY (`facilityid`)
    REFERENCES `login` (`facilityid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE UNIQUE INDEX `facilityid_UNIQUE` ON `facilitylatestversion` (`facilityid` ASC);

SHOW WARNINGS;
CREATE UNIQUE INDEX `policyid_UNIQUE` ON `facilitylatestversion` (`policyid` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `facilityterm`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `facilityterm` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `facilityterm` (
  `id` BIGINT(200) NOT NULL,
  `facilityid` VARCHAR(11) NOT NULL,
  `policyid` VARCHAR(11) NOT NULL,
  `termid` VARCHAR(6) NOT NULL,
  `transactionseqnbr` VARCHAR(11) NOT NULL,
  `status` VARCHAR(3) NOT NULL,
  `termeffectivedate` DATETIME NOT NULL,
  `termenddate` DATETIME NOT NULL,
  `autorenewind` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `getsequence`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `getsequence` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `getsequence` (
  `name` VARCHAR(11) NOT NULL,
  `value` BIGINT(200) NOT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `ratecard`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ratecard` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `ratecard` (
  `serviceid` VARCHAR(4) NOT NULL,
  `serviceplan` VARCHAR(10) NOT NULL,
  `term` VARCHAR(3) NOT NULL,
  `usagelimit` INT(10) NOT NULL,
  `ratecard` INT(10) NOT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `services`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `services` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `services` (
  `serviceid` VARCHAR(4) NOT NULL,
  `servicename` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`serviceid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE UNIQUE INDEX `serviceid_UNIQUE` ON `services` (`serviceid` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `statusdetail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `statusdetail` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `statusdetail` (
  `status` VARCHAR(3) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`status`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;
CREATE UNIQUE INDEX `status_UNIQUE` ON `statusdetail` (`status` ASC);

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `transactionservices`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `transactionservices` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `transactionservices` (
  `id` BIGINT(200) NOT NULL AUTO_INCREMENT,
  `facilityid` VARCHAR(11) NOT NULL,
  `policyid` VARCHAR(11) NOT NULL,
  `termid` VARCHAR(6) NOT NULL,
  `transactionseqnbr` VARCHAR(11) NOT NULL,
  `serviceid` VARCHAR(4) NOT NULL,
  `serviceseqnbr` VARCHAR(11) NOT NULL,
  `servicesubplantype` VARCHAR(10) NOT NULL,
  `status` VARCHAR(3) NOT NULL,
  `serviceeffectivedate` DATETIME NOT NULL,
  `serviceenddate` DATETIME NOT NULL,
  `serviceoriginalamt` INT(10) NOT NULL,
  `servicediscountcode` INT(6) NULL DEFAULT NULL,
  `servicediscountamt` INT(10) NULL DEFAULT NULL,
  `servicefinalamt` INT(10) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `transactionsummary`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `transactionsummary` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `transactionsummary` (
  `id` BIGINT(200) NOT NULL AUTO_INCREMENT,
  `transactionseqnr` VARCHAR(11) NOT NULL,
  `transactiondate` DATETIME NOT NULL,
  `termamountbeforediscount` INT(12) NOT NULL,
  `servicetotdiscountamt` INT(12) NOT NULL,
  `discountcode` VARCHAR(6) NOT NULL,
  `discountamt` INT(10) NOT NULL,
  `termamountafterdiscount` INT(12) NOT NULL,
  `previoustermamount` INT(12) NOT NULL,
  `finaltransactionamountdebit` INT(12) NOT NULL,
  `finaltransactionamountcredit` INT(12) NOT NULL,
  `modeofpayment` VARCHAR(10) NOT NULL,
  `paymentstatus` VARCHAR(3) NOT NULL,
  `auditid` VARCHAR(36) NOT NULL,
  `remarks` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
