/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : ams

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-04-06 16:32:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `administrator`
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL,
  `password` varchar(255) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES ('1', 'mao', '123');

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `gno` int(10) NOT NULL AUTO_INCREMENT,
  `gname` varchar(20) NOT NULL,
  `price` double(10,0) NOT NULL,
  `type` varchar(20) NOT NULL,
  `owner` varchar(20) NOT NULL,
  `information` varchar(255) DEFAULT NULL,
  `addtime` datetime DEFAULT NULL,
  `images` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`gno`),
  KEY `owner` (`owner`)
) ENGINE=InnoDB AUTO_INCREMENT=179 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('158', '零食', '198', '小吃零食', '觉者自知', '很便宜的的速度撒打算发三个法师噶伤感情歌第三个', '2017-03-24 00:00:00', '170324001645.jpg');
INSERT INTO `goods` VALUES ('175', '山地车', '599', '交通工具', '123', '大四学长要毕业了出售自己的山地车，已使用1年。车子保养得还不错，可以联系我来试骑，价格可议。', '2017-05-18 00:00:00', '170518145345.jpg');
INSERT INTO `goods` VALUES ('176', '夹克', '299', '电子产品', '123', '上个月500块买的，只需要一半价格就可以带走。质量不错，只是自己不喜欢穿夹克了，最低250。', '2017-05-18 00:00:00', '170518145536.jpg');
INSERT INTO `goods` VALUES ('178', '白夜行', '28', '书籍资料', '123', '这本书很好看，我看完了便宜出售。', '2017-05-18 00:00:00', '170518145742.jpg');

-- ----------------------------
-- Table structure for `record`
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `recordId` int(10) NOT NULL AUTO_INCREMENT,
  `gname` varchar(20) NOT NULL,
  `images` varchar(255) DEFAULT NULL,
  `type` varchar(10) NOT NULL,
  `price` double(10,0) NOT NULL,
  `owner` varchar(20) NOT NULL,
  `buyer` varchar(20) NOT NULL,
  `buytime` datetime(6) NOT NULL,
  PRIMARY KEY (`recordId`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('2', '2', '170321231216.jpg', '2', '2', '2', '2', '2017-03-23 22:23:15.000000');
INSERT INTO `record` VALUES ('32', '512', '170324001556.jpg', '电子产品', '521', '觉者自知', '123', '2017-03-24 22:23:15.000000');
INSERT INTO `record` VALUES ('33', '412', '170328223341.jpg', '电子产品', '312', '412', '123', '2017-03-28 23:31:05.000000');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(10) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) NOT NULL,
  `password` varchar(20) CHARACTER SET latin1 NOT NULL,
  `college` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `addtime` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `account` (`account`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('136', '大神一指轻松', '123', '山东大学', '毛篇篇', '13538849513', '41255512312', '男', '2015-11-26 12:20:11.000000');
INSERT INTO `user` VALUES ('137', '123', '123', '山东大学', '毛篇篇', '12312312', '4024125521', '男', '2015-11-26 12:21:05.000000');
INSERT INTO `user` VALUES ('143', '321', '321', '1231312312', '', '', '', '男', '2017-03-24 10:51:04.000000');
INSERT INTO `user` VALUES ('148', '5125', '123', '512', '521', '512', '512', '男', '2017-04-02 10:01:13.000000');
DROP TRIGGER IF EXISTS `deleteuser`;
DELIMITER ;;
CREATE TRIGGER `deleteuser` AFTER DELETE ON `user` FOR EACH ROW begin
delete from goods where owner='OLD.owner';
 END
;;
DELIMITER ;
