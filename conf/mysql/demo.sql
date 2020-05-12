/*
Navicat MySQL Data Transfer

Source Server         : docker_mysql
Source Server Version : 50730
Source Host           : 192.168.99.100:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50730
File Encoding         : 65001

Date: 2020-05-12 18:23:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int(4) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '11name', null, null);
SET FOREIGN_KEY_CHECKS=1;
