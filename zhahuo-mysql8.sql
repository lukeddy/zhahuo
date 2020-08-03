/*
 Navicat Premium Data Transfer

 Source Server         : docker-mysql8
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3307
 Source Schema         : zhahuo

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 03/08/2020 14:28:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for zh_cart
-- ----------------------------
DROP TABLE IF EXISTS `zh_cart`;
CREATE TABLE `zh_cart` (
  `cart_id` int(20) NOT NULL,
  `cart_product_name` varchar(255) NOT NULL,
  `cart_product_color` varchar(255) NOT NULL,
  `cart_product_size` varchar(255) NOT NULL,
  `cart_product_mp` varchar(255) NOT NULL,
  `cart_product_count` varchar(255) NOT NULL,
  `pid` int(20) NOT NULL,
  `uid` int(20) NOT NULL,
  `cart_product_image` varchar(255) NOT NULL,
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for zh_category
-- ----------------------------
DROP TABLE IF EXISTS `zh_category`;
CREATE TABLE `zh_category` (
  `cid` int(20) NOT NULL,
  `cname` varchar(255) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for zh_category_tow
-- ----------------------------
DROP TABLE IF EXISTS `zh_category_tow`;
CREATE TABLE `zh_category_tow` (
  `bid` int(20) NOT NULL,
  `bname` varchar(255) NOT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for zh_image
-- ----------------------------
DROP TABLE IF EXISTS `zh_image`;
CREATE TABLE `zh_image` (
  `imageid` int(20) NOT NULL,
  `image_addr` varchar(255) NOT NULL,
  `image_color` varchar(255) NOT NULL,
  `image_size` varchar(255) NOT NULL,
  `pid` int(20) NOT NULL,
  PRIMARY KEY (`imageid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for zh_order
-- ----------------------------
DROP TABLE IF EXISTS `zh_order`;
CREATE TABLE `zh_order` (
  `oid` int(20) NOT NULL,
  `ordertime` date NOT NULL,
  `total` double(255,0) NOT NULL,
  `state` int(2) NOT NULL,
  `address` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `telephone` varchar(20) NOT NULL,
  `uid` int(20) NOT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for zh_orderitem
-- ----------------------------
DROP TABLE IF EXISTS `zh_orderitem`;
CREATE TABLE `zh_orderitem` (
  `itemid` int(20) NOT NULL,
  `count` int(10) NOT NULL,
  `subtotal` double NOT NULL,
  `size` varchar(255) NOT NULL,
  `color` varchar(255) NOT NULL,
  `oid` int(20) NOT NULL,
  `pid` int(20) NOT NULL,
  PRIMARY KEY (`itemid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for zh_product
-- ----------------------------
DROP TABLE IF EXISTS `zh_product`;
CREATE TABLE `zh_product` (
  `pid` int(20) NOT NULL,
  `pname` varchar(255) NOT NULL,
  `market_price` double(10,2) NOT NULL,
  `shop_price` double(10,2) NOT NULL,
  `pimage` varchar(255) NOT NULL,
  `pdate` date NOT NULL,
  `is_hot` int(2) NOT NULL,
  `pdesc` varchar(255) NOT NULL,
  `bid` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for zh_user
-- ----------------------------
DROP TABLE IF EXISTS `zh_user`;
CREATE TABLE `zh_user` (
  `uid` int(20) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telephone` varchar(20) NOT NULL,
  `birthday` date NOT NULL,
  `sex` int(10) NOT NULL,
  `state` int(11) NOT NULL,
  `code` varchar(255) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
