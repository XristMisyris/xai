/*
MySQL Data Transfer
Source Host: 83.212.118.22
Source Database: mixaniki
Target Host: 83.212.118.22
Target Database: mixaniki
Date: 29/1/2016 7:27:42 PM
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for anakoinwseis
-- ----------------------------
DROP TABLE IF EXISTS `anakoinwseis`;
CREATE TABLE `anakoinwseis` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL,
  `sxolio` varchar(150) DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for dromologia
-- ----------------------------
DROP TABLE IF EXISTS `dromologia`;
CREATE TABLE `dromologia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `anaxwrisi` varchar(20) NOT NULL,
  `proorismos` varchar(20) NOT NULL,
  `wra` time NOT NULL,
  `kanonikiTimi` double(10,2) NOT NULL,
  `foititikiTimi` double(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for eisitiria
-- ----------------------------
DROP TABLE IF EXISTS `eisitiria`;
CREATE TABLE `eisitiria` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `anaxwrisi` varchar(20) NOT NULL,
  `proorismos` varchar(20) NOT NULL,
  `date` date NOT NULL,
  `thesi` int(20) NOT NULL,
  `tiposEisitiriou` int(10) NOT NULL,
  `timi` double(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `usermode` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `anakoinwseis` VALUES ('1', 'Αλλαγή Δρομολογίου', 'Σας ενημερώνουμε οτι σήμερα 9/12 το δρομολόγιο Καρπενήσι - Θεσσαλονίκη μεταφέρετε 15 λεπτά αργότερα. (08:30).', '2015-12-09 00:38:14');
INSERT INTO `anakoinwseis` VALUES ('2', 'Καρπενήσι-Αγρίνιο', 'Απο σήμερα 9/12 δημιουργίσαμε ένα νέο δρομολόγιο από και προς Αγρίνιο.', '2015-12-09 01:33:07');
INSERT INTO `anakoinwseis` VALUES ('3', 'Νέο Δρομολόγιο', 'Προστέθηκε το Δρομολόγιο Καρπενήσι - Πάτρα.', '2016-01-29 19:26:11');
INSERT INTO `dromologia` VALUES ('1', 'Καρπενησι', 'Αθήνα', '07:20:00', '25.00', '12.50');
INSERT INTO `dromologia` VALUES ('2', 'Αθήνα', 'Καρπενήσι', '09:15:00', '25.00', '12.50');
INSERT INTO `dromologia` VALUES ('3', 'Καρπενήσι', 'Αγρίνιο', '07:45:00', '20.00', '10.00');
INSERT INTO `dromologia` VALUES ('4', 'Αγρίνιο', 'Καρπενήσι', '07:40:00', '20.00', '10.00');
INSERT INTO `dromologia` VALUES ('5', 'Καρπενησι', 'Θεσσαλονικη', '08:15:00', '30.00', '15.00');
INSERT INTO `dromologia` VALUES ('6', 'Θεσσαλονίκη', 'Καρπενήσι', '08:00:00', '30.00', '15.00');
INSERT INTO `dromologia` VALUES ('7', 'Καρπενήσι', 'Πάτρα', '15:30:00', '25.00', '12.50');
INSERT INTO `eisitiria` VALUES ('18', 'Καρπενησι', 'Αθηνα', '2015-12-09', '1', '0', '25.00');
INSERT INTO `eisitiria` VALUES ('23', 'Αγρίνιο', 'Καρπενήσι', '2015-12-25', '3', '0', '20.00');
INSERT INTO `eisitiria` VALUES ('24', 'Καρπενησι', 'Αθηνα', '2015-12-09', '4', '0', '25.00');
INSERT INTO `eisitiria` VALUES ('25', 'Καρπενήσι', 'Πάτρα', '2015-12-14', '30', '1', '12.50');
INSERT INTO `eisitiria` VALUES ('26', 'Αθήνα', 'Καρπενήσι', '2016-01-18', '2', '0', '25.00');
INSERT INTO `users` VALUES ('1', 'admin', 'admin', '999');
INSERT INTO `users` VALUES ('2', 'tamias', 'tamias', '1');
