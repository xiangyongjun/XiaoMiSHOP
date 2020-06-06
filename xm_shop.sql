/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 100316
 Source Host           : localhost:3306
 Source Schema         : xm_shop

 Target Server Type    : MySQL
 Target Server Version : 100316
 File Encoding         : 65001

 Date: 22/12/2019 00:09:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for banner
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `src` varchar(255) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT current_timestamp(),
  `update_time` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of banner
-- ----------------------------
BEGIN;
INSERT INTO `banner` VALUES (1, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/a38b1d56409913d5dc869023ade36d94.jpg?w=2452&h=920', '#', '2019-12-19 23:01:10', '2019-12-19 23:01:10');
INSERT INTO `banner` VALUES (2, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/f69f6975b7def933aa0856340df34548.jpg?w=2452&h=920', '#', '2019-12-19 23:12:41', '2019-12-19 23:12:41');
INSERT INTO `banner` VALUES (3, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/d1599ed57cd3ca8751966105f86571e6.jpg?w=2452&h=920', '#', '2019-12-19 23:12:50', '2019-12-19 23:12:50');
INSERT INTO `banner` VALUES (4, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/e5b37cdb85b3b93b5938cc508a10c906.jpg?w=2452&h=920', '#', '2019-12-19 23:13:04', '2019-12-19 23:13:04');
INSERT INTO `banner` VALUES (5, 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/6731e5a37682eec528729d7c05a9b581.jpg?w=2452&h=920', '#', '2019-12-19 23:13:17', '2019-12-19 23:13:17');
COMMIT;

-- ----------------------------
-- Table structure for dropdown
-- ----------------------------
DROP TABLE IF EXISTS `dropdown`;
CREATE TABLE `dropdown` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sid` int(11) DEFAULT NULL COMMENT 'sidebar id',
  `gid` int(11) DEFAULT NULL COMMENT 'good id',
  `create_time` datetime DEFAULT current_timestamp(),
  `update_time` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=248 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dropdown
-- ----------------------------
BEGIN;
INSERT INTO `dropdown` VALUES (1, 1, 1, '2019-12-20 17:57:05', '2019-12-20 17:57:05');
INSERT INTO `dropdown` VALUES (2, 1, 1, '2019-12-20 18:27:37', '2019-12-20 18:27:59');
INSERT INTO `dropdown` VALUES (3, 1, 1, '2019-12-20 18:27:42', '2019-12-20 18:27:58');
INSERT INTO `dropdown` VALUES (4, 1, 8, '2019-12-20 18:27:44', '2019-12-20 19:02:28');
INSERT INTO `dropdown` VALUES (5, 1, 1, '2019-12-20 18:27:50', '2019-12-20 18:28:00');
INSERT INTO `dropdown` VALUES (6, 1, 1, '2019-12-20 18:27:53', '2019-12-20 18:28:00');
INSERT INTO `dropdown` VALUES (7, 2, 2, '2019-12-20 18:35:49', '2019-12-20 18:35:49');
INSERT INTO `dropdown` VALUES (8, 2, 2, '2019-12-20 18:35:53', '2019-12-20 18:35:53');
INSERT INTO `dropdown` VALUES (9, 2, 2, '2019-12-20 18:35:55', '2019-12-20 18:35:55');
INSERT INTO `dropdown` VALUES (10, 2, 2, '2019-12-20 18:35:58', '2019-12-20 18:35:58');
INSERT INTO `dropdown` VALUES (11, 2, 2, '2019-12-20 18:36:01', '2019-12-20 18:36:01');
INSERT INTO `dropdown` VALUES (12, 2, 2, '2019-12-20 18:36:06', '2019-12-20 18:36:18');
INSERT INTO `dropdown` VALUES (13, 3, 3, '2019-12-20 18:36:22', '2019-12-20 18:36:22');
INSERT INTO `dropdown` VALUES (14, 3, 3, '2019-12-20 18:36:24', '2019-12-20 18:36:24');
INSERT INTO `dropdown` VALUES (15, 3, 3, '2019-12-20 18:36:27', '2019-12-20 18:36:27');
INSERT INTO `dropdown` VALUES (16, 3, 3, '2019-12-20 18:36:30', '2019-12-20 18:36:30');
INSERT INTO `dropdown` VALUES (17, 3, 3, '2019-12-20 18:36:32', '2019-12-20 18:36:32');
INSERT INTO `dropdown` VALUES (18, 3, 3, '2019-12-20 18:36:34', '2019-12-20 18:36:34');
INSERT INTO `dropdown` VALUES (19, 4, 4, '2019-12-20 18:36:44', '2019-12-20 18:36:44');
INSERT INTO `dropdown` VALUES (20, 4, 4, '2019-12-20 18:36:47', '2019-12-20 18:36:47');
INSERT INTO `dropdown` VALUES (21, 4, 4, '2019-12-20 18:36:52', '2019-12-20 18:36:52');
INSERT INTO `dropdown` VALUES (22, 4, 4, '2019-12-20 18:37:43', '2019-12-20 18:37:46');
INSERT INTO `dropdown` VALUES (23, 4, 4, '2019-12-20 18:37:50', '2019-12-20 18:37:57');
INSERT INTO `dropdown` VALUES (24, 4, 4, '2019-12-20 18:37:55', '2019-12-20 18:37:59');
INSERT INTO `dropdown` VALUES (25, 5, 5, '2019-12-20 18:38:04', '2019-12-20 18:38:04');
INSERT INTO `dropdown` VALUES (26, 5, 5, '2019-12-20 18:38:07', '2019-12-20 18:38:16');
INSERT INTO `dropdown` VALUES (27, 5, 5, '2019-12-20 18:38:13', '2019-12-20 18:38:13');
INSERT INTO `dropdown` VALUES (28, 5, 5, '2019-12-20 18:38:20', '2019-12-20 18:38:23');
INSERT INTO `dropdown` VALUES (29, 5, 5, '2019-12-20 18:38:30', '2019-12-20 18:38:30');
INSERT INTO `dropdown` VALUES (30, 5, 5, '2019-12-20 18:38:32', '2019-12-20 18:38:52');
INSERT INTO `dropdown` VALUES (228, 6, 6, '2019-12-20 18:39:32', '2019-12-20 18:39:32');
INSERT INTO `dropdown` VALUES (229, 6, 6, '2019-12-20 18:39:36', '2019-12-20 18:39:36');
INSERT INTO `dropdown` VALUES (230, 6, 6, '2019-12-20 18:39:39', '2019-12-20 18:39:39');
INSERT INTO `dropdown` VALUES (231, 6, 6, '2019-12-20 18:39:43', '2019-12-20 18:39:43');
INSERT INTO `dropdown` VALUES (232, 6, 6, '2019-12-20 18:39:47', '2019-12-20 18:39:47');
INSERT INTO `dropdown` VALUES (233, 6, 6, '2019-12-20 18:39:51', '2019-12-20 18:39:51');
INSERT INTO `dropdown` VALUES (234, 7, 7, '2019-12-20 18:39:54', '2019-12-20 18:39:54');
INSERT INTO `dropdown` VALUES (235, 7, 7, '2019-12-20 18:39:59', '2019-12-20 18:39:59');
INSERT INTO `dropdown` VALUES (236, 7, 7, '2019-12-20 18:40:07', '2019-12-20 18:40:07');
INSERT INTO `dropdown` VALUES (237, 7, 7, '2019-12-20 18:40:11', '2019-12-20 18:40:11');
INSERT INTO `dropdown` VALUES (238, 7, 7, '2019-12-20 18:40:16', '2019-12-20 18:40:16');
INSERT INTO `dropdown` VALUES (239, 7, 7, '2019-12-20 18:40:19', '2019-12-20 18:40:19');
COMMIT;

-- ----------------------------
-- Table structure for good
-- ----------------------------
DROP TABLE IF EXISTS `good`;
CREATE TABLE `good` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `src` varchar(255) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `old_price` double(10,2) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT current_timestamp(),
  `update_time` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of good
-- ----------------------------
BEGIN;
INSERT INTO `good` VALUES (1, '小米9', 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/be92bc4baa572bf467fc9e881fd4be2a.png', 1000.00, 2000.00, '小米9，掉电无敌屌', '2019-12-20 17:12:02', '2019-12-20 21:39:06');
INSERT INTO `good` VALUES (2, '小米9 Pro 5G', 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/41c566d825a3ae3b5751a78d4c7cffdb.png', 1234.00, 4321.00, '没有任何介绍', '2019-12-20 17:12:41', '2019-12-20 21:09:25');
INSERT INTO `good` VALUES (3, '小米CC9', 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/f515ab05232ed14ccd78ec67e024495a.png', 888.00, 8888.00, '没有任何介绍', '2019-12-20 17:13:10', '2019-12-20 21:09:26');
INSERT INTO `good` VALUES (4, '小米CC9e', 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/df9b3e7a562e02a33eb069b3f0119815.png', 999.00, 9999.00, '没有任何介绍', '2019-12-20 17:13:27', '2019-12-20 21:09:28');
INSERT INTO `good` VALUES (5, '红米8', 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/6a25f895ad6019c3fae32fd1f48a2c7c.png', 1800.00, 2000.00, '超新', '2019-12-21 17:58:35', '2019-12-21 18:15:42');
INSERT INTO `good` VALUES (6, '超级吊炸天手机', 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/d712f71b3c4a3b562601c2b956a660ad.png', 333.00, 444.00, '没有任何介绍', '2019-12-21 18:16:02', '2019-12-21 18:16:28');
INSERT INTO `good` VALUES (7, '无敌手机', 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/e3fb0886fdb13e5ae784b9713b9a0038.jpg', 444.00, 9999999.00, '无敌手机，就是这么牛逼', '2019-12-20 18:41:39', '2019-12-20 21:24:20');
INSERT INTO `good` VALUES (8, '红米', 'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/c1937ecb7e9b8e1aee11d6936e19d53c.png', 8888.00, 10000.00, '没有任何介绍', '2019-12-20 19:01:58', '2019-12-20 21:09:40');
INSERT INTO `good` VALUES (9, '爆炸电视机', 'https://cdn.cnbj0.fds.api.mi-img.com/b2c-mimall-media/e8f4e22f6d591825f8f150b3309c750b.png', 9.00, 878787.00, '这个电视机爆炸威力很大', '2019-12-20 21:24:01', '2019-12-20 21:29:07');
COMMIT;

-- ----------------------------
-- Table structure for sidebar
-- ----------------------------
DROP TABLE IF EXISTS `sidebar`;
CREATE TABLE `sidebar` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT current_timestamp(),
  `update_time` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sidebar
-- ----------------------------
BEGIN;
INSERT INTO `sidebar` VALUES (1, '小米手机', NULL, '2019-12-20 16:50:47', '2019-12-20 16:50:47');
INSERT INTO `sidebar` VALUES (2, 'Redmi 红米', NULL, '2019-12-20 16:50:59', '2019-12-20 16:50:59');
INSERT INTO `sidebar` VALUES (3, '电视', NULL, '2019-12-20 16:51:09', '2019-12-20 16:51:09');
INSERT INTO `sidebar` VALUES (4, '笔记本', NULL, '2019-12-20 16:51:16', '2019-12-20 16:51:16');
INSERT INTO `sidebar` VALUES (5, '家电', NULL, '2019-12-20 16:51:20', '2019-12-20 16:51:20');
INSERT INTO `sidebar` VALUES (6, '路由器', NULL, '2019-12-20 16:51:26', '2019-12-20 16:51:26');
INSERT INTO `sidebar` VALUES (7, '智能硬件', NULL, '2019-12-20 16:51:31', '2019-12-20 16:51:31');
INSERT INTO `sidebar` VALUES (8, '服务', 'https://www.mi.com/service/', '2019-12-20 16:51:34', '2019-12-20 16:51:34');
INSERT INTO `sidebar` VALUES (9, '社区', 'http://www.xiaomi.cn/', '2019-12-20 16:51:40', '2019-12-20 17:40:20');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT current_timestamp(),
  `update_time` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'admin', 'admin', '管理员', '2019-12-21 10:47:27', '2019-12-21 10:47:27');
INSERT INTO `user` VALUES (18, 'test', 'test', 'test', '2019-12-21 22:52:23', '2019-12-21 22:52:23');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
