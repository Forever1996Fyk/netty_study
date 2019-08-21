/*
Navicat MySQL Data Transfer

Source Server         : project_fyk
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : webchat-dev

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-08-22 00:26:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `chat_msg`
-- ----------------------------
DROP TABLE IF EXISTS `chat_msg`;
CREATE TABLE `chat_msg` (
  `id` varchar(64) NOT NULL,
  `send_user_id` varchar(64) DEFAULT NULL,
  `accept_user_id` varchar(64) DEFAULT NULL,
  `msg` varchar(255) DEFAULT NULL,
  `sign_flag` int(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '聊天记录表'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chat_msg
-- ----------------------------

-- ----------------------------
-- Table structure for `freiends_request`
-- ----------------------------
DROP TABLE IF EXISTS `freiends_request`;
CREATE TABLE `freiends_request` (
  `id` varchar(64) NOT NULL,
  `send_user_id` varchar(64) DEFAULT NULL,
  `accept_user_id` varchar(64) DEFAULT NULL,
  `request_date_time` datetime DEFAULT NULL COMMENT '用户请求表'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of freiends_request
-- ----------------------------

-- ----------------------------
-- Table structure for `my_friends`
-- ----------------------------
DROP TABLE IF EXISTS `my_friends`;
CREATE TABLE `my_friends` (
  `id` varchar(64) NOT NULL,
  `my_user_id` varchar(64) DEFAULT NULL,
  `my_friend_user_id` varchar(64) DEFAULT NULL COMMENT '我的朋友表'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of my_friends
-- ----------------------------

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` varchar(64) NOT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `face_image` varchar(255) DEFAULT NULL,
  `face_image_big` varchar(255) DEFAULT NULL,
  `nick_name` varchar(20) DEFAULT NULL,
  `qrcode` varchar(255) DEFAULT NULL,
  `cid` varchar(64) DEFAULT NULL COMMENT '用户表'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
