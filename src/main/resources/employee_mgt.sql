/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : employee_mgt

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-05-17 15:57:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL DEFAULT '',
  `LOCATION` varchar(255) DEFAULT '',
  `OPENPOSITIONS` int(11) NOT NULL,
  `PARENTDEPT` bigint(20) DEFAULT NULL,
  `MANAGER` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('3', 'department003', 'location003', '7', '0', '0');
INSERT INTO `department` VALUES ('4', 'department004', 'location004', '6', '3', '0');
INSERT INTO `department` VALUES ('5', 'department005', 'location005', '8', '3', '0');
INSERT INTO `department` VALUES ('6', 'department006', 'location006', '6', '3', '0');
INSERT INTO `department` VALUES ('7', 'department007', 'location007', '6', '3', '0');
INSERT INTO `department` VALUES ('8', 'department008', 'location008', '6', '3', '0');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `ID` bigint(20) NOT NULL,
  `FIRSTNAME` varchar(32) DEFAULT NULL,
  `LASTNAME` varchar(32) DEFAULT NULL,
  `LDAPUSERNAME` varchar(32) DEFAULT NULL,
  `GENDER` varchar(32) DEFAULT NULL,
  `BIRTHDAY` date DEFAULT NULL,
  `TITLE` varchar(32) DEFAULT NULL,
  `GRADE` varchar(32) DEFAULT NULL,
  `DEPARTMENT_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
