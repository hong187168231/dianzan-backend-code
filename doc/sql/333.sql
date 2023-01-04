/*
 Navicat MySQL Data Transfer

 Source Server         : likes
 Source Server Type    : MySQL
 Source Server Version : 80024
 Source Host           : 45.207.49.136:3306
 Source Schema         : likes

 Target Server Type    : MySQL
 Target Server Version : 80024
 File Encoding         : 65001

 Date: 05/01/2023 02:32:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for agent_user
-- ----------------------------
DROP TABLE IF EXISTS `agent_user`;
CREATE TABLE `agent_user`  (
                               `agent_id` int(0) NOT NULL AUTO_INCREMENT,
                               `accno` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                               `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                               `singel_add_money` int(0) NULL DEFAULT NULL,
                               `create_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                               `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
                               `update_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                               `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
                               PRIMARY KEY (`agent_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

-- ----------------------------
-- Table structure for bd_user
-- ----------------------------
DROP TABLE IF EXISTS `bd_user`;
CREATE TABLE `bd_user`  (
  `bduserid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `accno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '会员标识号',
  `bdusername` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
  `phoneno` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话',
  `wechat` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '微信号 多条以“，”分隔',
  `email` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电子邮件',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `acclogin` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '系统账号(登录用)',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登陆密码',
  `passwordmd5` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '登录密码MD5',
  `loginnum` int(0) NULL DEFAULT NULL COMMENT '登录总次数',
  `accstatus` decimal(1, 0) NOT NULL COMMENT '账号状态 1正常 9禁止登陆 ',
  `clintipadd` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登录ip地址',
  `lastlogindate` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`bduserid`) USING BTREE,
  INDEX `idx_no`(`accno`, `is_delete`, `create_time`) USING BTREE,
  INDEX `idx_phone`(`phoneno`, `is_delete`, `create_time`) USING BTREE,
  INDEX `idx_delete`(`is_delete`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '后台系统用户信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bd_user
-- ----------------------------
INSERT INTO `bd_user` VALUES (1, '28883d4a8d584128a9443111ac0c93fe', '后台管理员', '13800000001', '15800000001', '', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:20', '065d4aed0b4a47bc9406d39ae182g3e6', '2023-01-05 01:20:49', 'supermanage', '96e79218965eb72c92a549dd5a330112', '96e79218965eb72c92a549dd5a330112', 199, 1, '117.20.115.151', '2023-01-05 01:20:52');

-- ----------------------------
-- Table structure for coin_deposit
-- ----------------------------
DROP TABLE IF EXISTS `coin_deposit`;
CREATE TABLE `coin_deposit`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `coin_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
  `coin_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
  `image_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
  `status` int(0) NULL DEFAULT 1,
  `del_status` int(0) NULL DEFAULT 0,
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `create_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for dz_broker_message
-- ----------------------------
DROP TABLE IF EXISTS `dz_broker_message`;
CREATE TABLE `dz_broker_message`  (
  `message_Id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `message` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `try_count` int(0) NULL DEFAULT 0,
  `status` int(0) NULL DEFAULT NULL,
  `next_retry` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`message_Id`) USING BTREE,
  INDEX `idx_id`(`message_Id`) USING BTREE,
  INDEX `idx_status`(`status`) USING BTREE,
  INDEX `idx_next_retry`(`next_retry`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for dz_coin
-- ----------------------------
DROP TABLE IF EXISTS `dz_coin`;
CREATE TABLE `dz_coin`  (
  `coin_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '币种id',
  `coin_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '币种名称',
  `main_coin_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '主币种类型',
  `coin_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '币种类型',
  `main_symbol` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '币种单位',
  `symbol` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '主币种单位',
  `token_status` int(0) NULL DEFAULT NULL COMMENT '0： 主币 1：代币',
  PRIMARY KEY (`coin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for dz_level_record
-- ----------------------------
DROP TABLE IF EXISTS `dz_level_record`;
CREATE TABLE `dz_level_record`  (
  `level_record_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `accno` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `user_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `head_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `superior_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `before_level` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `current_level` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `change_amount` decimal(10, 2) NULL DEFAULT NULL,
  `change_type` int(0) NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL,
  `update_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`level_record_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for dz_task
-- ----------------------------
DROP TABLE IF EXISTS `dz_task`;
CREATE TABLE `dz_task`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `category_id` int(0) NULL DEFAULT NULL COMMENT '分类id',
  `language` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '语言',
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务标题',
  `sort` int(0) NULL DEFAULT 999 COMMENT '排序字段',
  `price` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '任务单价',
  `pump_price` decimal(10, 2) NULL DEFAULT NULL,
  `total_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '任务总价',
  `apiece_num` int(0) NULL DEFAULT 1 COMMENT ' 每人能领取次数',
  `task_type` int(0) NULL DEFAULT NULL COMMENT '任务类型 1 必须任务 2 常规 任务',
  `task_url` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务链接',
  `task_level` tinyint(1) NULL DEFAULT NULL COMMENT '任务等级',
  `task_level_ids` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `condition` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '认证条件,号分隔',
  `send_sdk_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sample_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '样例url',
  `info` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务描述',
  `create_mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL,
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '任务到期时间',
  `finish_date` timestamp(0) NULL DEFAULT NULL,
  `status` tinyint(1) NULL DEFAULT 1 COMMENT '任务状态 1 审核中 2 未通过 3 进行中 4 已撤销 5 已完成',
  `max_num` int(0) NULL DEFAULT 0 COMMENT '可接任务人数',
  `apply_num` int(0) NULL DEFAULT 0 COMMENT '已申请人数',
  `surplus_num` int(0) NULL DEFAULT NULL COMMENT '剩余数量',
  `task_require` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务要求',
  `video_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '视频图链接',
  `step_Info` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务步骤。保存json数据',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id_index`(`id`) USING BTREE,
  INDEX `category_id_index`(`category_id`) USING BTREE,
  INDEX `Idx_level_ids`(`task_level_ids`, `apiece_num`, `finish_date`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for dz_task_category
-- ----------------------------
DROP TABLE IF EXISTS `dz_task_category`;
CREATE TABLE `dz_task_category`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类名称',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类说明',
  `en_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `en_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sp_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sp_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ab_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ab_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fn_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fn_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `in_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `in_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sort` int(0) NULL DEFAULT 999 COMMENT '排序字段',
  `icon` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `status` tinyint(1) NULL DEFAULT 1 COMMENT '0-关闭 1-开启',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '任务到期时间',
  `create_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id_index`(`id`) USING BTREE,
  INDEX `name_index`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dz_task_category
-- ----------------------------
INSERT INTO `dz_task_category` VALUES (1, 'Facebook', '11', 'Facebook', '', 'Facebook', '', 'Facebook', '', 'Facebook', '', NULL, NULL, 1, 'https://img.kxwwd.com/picture/icon/facebook.png', 1, '2022-04-24 23:59:52', '2022-04-26 02:11:14', '28883d4a8d584128a9443111ac0c93fe', '28883d4a8d584128a9443111ac0c93fe', NULL);
INSERT INTO `dz_task_category` VALUES (2, 'You Tube', '1', 'You Tube', '', 'You Tube', '', 'You Tube', '', 'You Tube', '', NULL, NULL, 2, 'https://img.kxwwd.com/picture/icon/youtube.png', 1, '2022-04-25 00:00:22', '2022-04-26 02:06:01', '28883d4a8d584128a9443111ac0c93fe', '28883d4a8d584128a9443111ac0c93fe', NULL);
INSERT INTO `dz_task_category` VALUES (3, 'TikTok', '1', 'TikTok', '', 'TikTok', '', 'TikTok', '', 'TikTok', '', NULL, NULL, 3, 'https://img.kxwwd.com/picture/icon/tiktok.png', 1, '2022-04-25 00:00:52', '2022-04-26 02:17:05', '28883d4a8d584128a9443111ac0c93fe', '28883d4a8d584128a9443111ac0c93fe', NULL);
INSERT INTO `dz_task_category` VALUES (4, 'Instagram', '1', 'Instagram', '', 'Instagram', '', 'Instagram', '', 'Instagram', '', NULL, NULL, 4, 'https://img.kxwwd.com/picture/icon/instagram.png', 1, '2022-04-25 00:04:26', '2022-04-26 02:06:09', 'a3e5bb5fa2fe429f9f2677efb8316bf6', '28883d4a8d584128a9443111ac0c93fe', NULL);

-- ----------------------------
-- Table structure for dz_task_order
-- ----------------------------
DROP TABLE IF EXISTS `dz_task_order`;
CREATE TABLE `dz_task_order`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `order_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单号',
  `mem_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员no',
  `task_id` bigint(0) NULL DEFAULT NULL COMMENT '任务id',
  `receive_level` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receive_price` decimal(10, 2) NULL DEFAULT NULL,
  `task_type` tinyint(1) NULL DEFAULT 0 COMMENT '任务类型 0 常规任务 1 必领任务',
  `mobile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `submit_sample` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sort` int(0) NULL DEFAULT NULL COMMENT '排序字段',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '任务状态1 进行中  2 审核中 3 已完成 ',
  `send_status` int(0) NULL DEFAULT 0,
  `create_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '更吓人',
  `end_time` timestamp(0) NULL DEFAULT NULL COMMENT '任务到期时间',
  `update_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `id_index`(`id`) USING BTREE,
  INDEX `order_no_index`(`order_no`) USING BTREE,
  INDEX `mem_no_index`(`mem_no`) USING BTREE,
  INDEX `task_id_index`(`task_id`) USING BTREE,
  INDEX `idex_create_time`(`create_time`) USING BTREE,
  INDEX `status_create_index`(`status`, `create_time`, `mem_no`) USING BTREE,
  INDEX `status_update_index_m`(`status`, `update_time`, `mem_no`, `send_status`) USING BTREE,
  INDEX `idx_status`(`status`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for dz_task_reward_fail
-- ----------------------------
DROP TABLE IF EXISTS `dz_task_reward_fail`;
CREATE TABLE `dz_task_reward_fail`  (
  `fail_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `task_id` bigint(0) NULL DEFAULT NULL,
  `error_msg` varchar(20000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL,
  `update_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`fail_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for dz_udun_order
-- ----------------------------
DROP TABLE IF EXISTS `dz_udun_order`;
CREATE TABLE `dz_udun_order`  (
  `undu_order_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'udun 订单id',
  `accno` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '会员标识',
  `coin_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '币种名称',
  `main_coin_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '主币种类型',
  `coin_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '币种类型',
  `amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '金额',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '钱包地址',
  `fee` decimal(10, 2) NULL DEFAULT NULL COMMENT '矿工费',
  `trade_Id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT 'udun 交易id',
  `tx_id` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '区块链交易哈希',
  `business_Id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '平台业务id （流水号）',
  `trade_type` int(0) NULL DEFAULT NULL COMMENT '交易类型1 充值 2 提现',
  `trade_status` int(0) NULL DEFAULT NULL COMMENT '1 成功 2 失败',
  `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL,
  `update_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`undu_order_id`) USING BTREE,
  INDEX `idx_acc`(`accno`, `coin_name`, `main_coin_type`) USING BTREE,
  INDEX `idx_buId`(`business_Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for every_day_report
-- ----------------------------
DROP TABLE IF EXISTS `every_day_report`;
CREATE TABLE `every_day_report`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `create_date` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `recharge` decimal(10, 2) NULL DEFAULT NULL,
  `withdrawal` decimal(10, 0) NULL DEFAULT NULL,
  `add_vip_num` int(0) NULL DEFAULT NULL,
  `sub_task_amount` decimal(10, 2) NULL DEFAULT NULL,
  `task_amount` decimal(10, 2) NULL DEFAULT NULL,
  `vip_amount` decimal(10, 2) NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL,
  `update_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for finance_balance_adjustment
-- ----------------------------
DROP TABLE IF EXISTS `finance_balance_adjustment`;
CREATE TABLE `finance_balance_adjustment`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `type` int(0) NULL DEFAULT NULL COMMENT '55手动入款  56手动出款',
  `accno` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员标识',
  `amount` decimal(20, 0) NULL DEFAULT NULL COMMENT '加扣款金额',
  `dama` bit(1) NULL DEFAULT b'0' COMMENT '是否记打码量 0不计入，1计入',
  `dama_ratio` decimal(20, 0) NULL DEFAULT 1 COMMENT '打码倍率',
  `clean` bit(1) NULL DEFAULT b'0' COMMENT '是否已经体现，0：未提，1已提',
  `orderno` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单编号，记录关联的体现订单',
  `remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加款原因',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `accno`(`accno`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '财务管理手动加款表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for finance_dama_adjustment
-- ----------------------------
DROP TABLE IF EXISTS `finance_dama_adjustment`;
CREATE TABLE `finance_dama_adjustment`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `type` int(0) NULL DEFAULT NULL COMMENT '加码:1,减码:-1',
  `accno` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员标识',
  `damaliang` decimal(20, 0) NULL DEFAULT NULL COMMENT '加扣打码量',
  `remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加扣打码原因',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `accno`(`accno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '财务管理手动加码表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for first_recharge_gift
-- ----------------------------
DROP TABLE IF EXISTS `first_recharge_gift`;
CREATE TABLE `first_recharge_gift`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `order_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '订单号',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '会员id',
  `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '会员账号',
  `topup_money` int(0) NULL DEFAULT NULL COMMENT '充值金额',
  `gift_money` int(0) NULL DEFAULT NULL COMMENT '赠送礼金',
  `got_money` int(0) NULL DEFAULT NULL COMMENT '已领取金额',
  `status` int(0) NULL DEFAULT 0 COMMENT '状态:0,未领完; 1,已领完',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '首充礼金管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for first_recharge_gift_back
-- ----------------------------
DROP TABLE IF EXISTS `first_recharge_gift_back`;
CREATE TABLE `first_recharge_gift_back`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `order_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '订单号',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '会员id',
  `account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '会员账号',
  `money` int(0) NULL DEFAULT 0 COMMENT '金额(单位:分)',
  `bet_money` int(0) NULL DEFAULT 0 COMMENT '投注金额(单位:分)',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '首充礼金返还记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for help_manual
-- ----------------------------
DROP TABLE IF EXISTS `help_manual`;
CREATE TABLE `help_manual`  (
  `id` int(0) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `sort` int(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for inf_push
-- ----------------------------
DROP TABLE IF EXISTS `inf_push`;
CREATE TABLE `inf_push`  (
  `bdpushid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '推送id',
  `pushtype` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '推送类型',
  `pushtitle` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '推送标题',
  `pushbody` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '推送摘要',
  `pushdate` datetime(0) NULL DEFAULT NULL COMMENT '推送时间',
  `sortby` int(0) NULL DEFAULT NULL COMMENT '排序权重',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`bdpushid`) USING BTREE,
  INDEX `idx1`(`pushtype`, `is_delete`, `create_time`) USING BTREE,
  INDEX `idx2`(`is_delete`, `create_time`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'APP系统推送' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for inf_sysnotice
-- ----------------------------
DROP TABLE IF EXISTS `inf_sysnotice`;
CREATE TABLE `inf_sysnotice`  (
  `noticeid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '公告id',
  `type` decimal(1, 0) NULL DEFAULT NULL COMMENT '消息类型 1滚动消息 2首页公告',
  `accno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '会员标识号',
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '消息标题',
  `notebody` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '消息内容',
  `en_notice` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '英文公告',
  `sp_notice` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '西班牙语公告',
  `ab_notice` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '阿拉伯语公告',
  `fn_notice` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '法语公告',
  `vi_notice` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '越南语公告',
  `params` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '消息参数',
  `expirydates` datetime(0) NULL DEFAULT NULL COMMENT '有效期起',
  `expirydatee` datetime(0) NULL DEFAULT NULL COMMENT '有效期止',
  `sortby` int(0) NULL DEFAULT NULL COMMENT '排序权重',
  `work_status` bit(1) NOT NULL DEFAULT b'1' COMMENT '0 关闭  1 开启',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`noticeid`) USING BTREE,
  INDEX `idx1`(`type`, `accno`, `is_delete`, `expirydates`, `expirydatee`) USING BTREE,
  INDEX `idx2`(`type`, `is_delete`, `expirydates`, `expirydatee`) USING BTREE,
  INDEX `idx3`(`accno`, `is_delete`, `expirydates`, `expirydatee`) USING BTREE,
  INDEX `idx4`(`is_delete`, `expirydates`, `expirydatee`) USING BTREE,
  INDEX `idx_d_w_t_s_e`(`is_delete`, `work_status`, `type`, `expirydates`, `expirydatee`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统公告' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of inf_sysnotice
-- ----------------------------
INSERT INTO `inf_sysnotice` VALUES (1, 1, '', 'app顶部轮播文字', '', 'Xin chào  tất cả mọi người đang sử dụng nền tảng của chúng tôi.Mọi người có thể kiếm thêm thu nhập bằng cách mời bạn bè tham gia vào nền tảng\n\n', 'Los agentes internacionales dejarán de dar vip1 gratis a las 00:00 del 15 de junio, hora de México', 'سيتوقف الوكلاء الدوليون عن منح vip1 مجانًا في الساعة 00:00 يوم 15 يونيو بتوقيت المكسيك', 'Les agents internationaux cesseront de donner gratuitement vip1 à 00h00 le 15 juin, heure du Mexique', '', '', NULL, NULL, 0, b'1', b'0', 'a3e5bb5fa2fe429f9f2677efb8316bf6', '2022-05-24 23:05:43', '28883d4a8d584128a9443111ac0c93fe', '2022-05-24 23:21:03');
INSERT INTO `inf_sysnotice` VALUES (2, 2, '', 'app首页启动公告', '', 'Xin chào tất cả mọi người .kênh mua hàng VIP đã chính thức được mở ! VIP1-VIP5 đã được khởi chạy thành công.', 'Estimados usuarios: El primer concurso internacional de agencias del 15 de mayo al 15 de agosto\nOrganizador: Smart Part-Time Unidad participante: Agente internacional\n    Premio Campeón: $1,280,000\n    El bono de finalista 680000USDT\n    Tercer Premio: $380,000\n  4-10 Bono $120,000 USD\n  11-30 Bono $60,000\n30-100 bono de $30,000\n\nLos agentes internacionales dejarán de regalar VIP1 a las 00:00 horas del 15 de junio, hora de México\nAl mismo tiempo, Smart Part-Time dejará de emitir el bono de invitación de $20 y abrirá el canal de compra VIP4 el 15 de junio.\nEstén atentos para más anuncios oficiales\n', 'علان: مسابقة الوكالة الدولية الأولى 15 مايو - 15 أغسطس\nالمنظم: الوحدات المشاركة الذكية بدوام جزئي: الوكلاء الدوليون\n    البطل باونتي 1280000USDT\n    الجائزة الثانية 680000 دولار أمريكي\n    الجائزة الثالثة 380000 دولارًا أمريكيًا\n  4-10 مكافأة نقدية 120000 دولارًا أمريكيًا\n  11-30 مكافأة 60000 دولارًا أمريكيًا\n30-100 مكافأة نقدية 30000 دولارًا أمريكيًا\n\nسيتوقف الوكلاء الدوليون عن تقديم VIP1 مجانًا في تمام الساعة 00:00 يوم 15 يونيو بتوقيت المكسيك\nفي الوقت نفسه ، سيفتح Smart Part-Time قناة شراء VIP4!\nترقبوا المزيد من الإعلانات الرسمية', 'Chers utilisateurs : Le premier concours international d\'agences du 15 mai au 15 août\nOrganisateur : Unité participante intelligente à temps partiel : Agent international\n    Prix ​​des champions : 1 280 000 $\n    Le bonus finaliste 680000USDT\n    Troisième prix : 380 000 $\n  Prime 4-10 120 000 $\n  11-30 Prime 60 000 $\nPrime 30-100 30 000 $\n\nLes agents internationaux cesseront de distribuer VIP1 à 00h00 le 15 juin, heure du Mexique\nDans le même temps, Smart Part-Time cessera d\'émettre un bonus d\'invitation de 20 $ le 15 juin et ouvrira le canal d\'achat VIP4.\nRestez à l\'écoute pour plus d\'annonces officielles', '', '', NULL, NULL, 2, b'1', b'0', 'a3e5bb5fa2fe429f9f2677efb8316bf6', '2022-05-24 23:06:14', '28883d4a8d584128a9443111ac0c93fe', '2022-12-22 01:14:51');

-- ----------------------------
-- Table structure for inf_sysremindinfo
-- ----------------------------
DROP TABLE IF EXISTS `inf_sysremindinfo`;
CREATE TABLE `inf_sysremindinfo`  (
  `rmdid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '消息id',
  `bdpushid` bigint(0) NULL DEFAULT NULL COMMENT '推送id',
  `sender` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '发送者accno',
  `rmtype` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '提醒信息类型：order订单提醒  pay 支付消息，auditvideo视频审核提醒 ,auditimg图文审核提醒 other通用提醒comment评论system系统systemnotice 主播发送微信',
  `recipienter` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '接收人：accno',
  `uuid` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '识别码（群发标识符）',
  `rmpics` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '通知图片 多张以“,”分隔',
  `rmtitle` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '消息标题',
  `senddate` datetime(0) NULL DEFAULT NULL COMMENT '发送时间',
  `remindtxt` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '提醒消息',
  `refparm` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '相关参数id、code',
  `refaddlink` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '相关链接',
  `rmdateexp` datetime(0) NULL DEFAULT NULL COMMENT '提醒失效时间 一般提醒7天 重要提醒30天',
  `issee` decimal(1, 0) NULL DEFAULT NULL COMMENT '是否查看0已查看 9未查看',
  `istodo` decimal(1, 0) NULL DEFAULT NULL COMMENT '是否处理0已处理 9未处理',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`rmdid`) USING BTREE,
  INDEX `fk_relationship_337`(`bdpushid`) USING BTREE,
  INDEX `index_num`(`recipienter`, `issee`, `is_delete`, `rmtype`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统提醒消息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for kill_config
-- ----------------------------
DROP TABLE IF EXISTS `kill_config`;
CREATE TABLE `kill_config`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '彩种名称',
  `lottery_id` int(0) NOT NULL COMMENT '彩种id',
  `platfom` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '配置杀号平台(ALL,CPT,HKC,XGC,XYE,LHT,LLB)',
  `ratio` double(5, 2) NOT NULL COMMENT '杀号比例',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx01_create_time`(`create_time`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '帖子' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mem_bank
-- ----------------------------
DROP TABLE IF EXISTS `mem_bank`;
CREATE TABLE `mem_bank`  (
  `mem_bank_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `accno` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `bank_id` int(0) NULL DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `bank_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `bank_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `bank_card_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `bank_branch` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `city` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`mem_bank_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mem_bankaccount
-- ----------------------------
DROP TABLE IF EXISTS `mem_bankaccount`;
CREATE TABLE `mem_bankaccount`  (
  `bankaccid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '银行账户id',
  `accno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '会员标识号',
  `familyid` bigint(0) NULL DEFAULT NULL COMMENT '家族id',
  `accounttype` decimal(1, 0) NULL DEFAULT NULL COMMENT '账号类型  1支付宝 2微信   3银联',
  `bankaddress` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '开户行 如 某某支行',
  `bankname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '银行名称标识符 如ICBC',
  `accountname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '银行/支付宝/微信开户人姓名',
  `accountno` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '银行卡/支付宝/微信账号',
  `accidcardno` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '持卡人身份证号',
  `idcardpic1` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '持卡人身份证正面图',
  `idcardpic2` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '持卡人身份证背面图',
  `checkstatus` decimal(1, 0) NULL DEFAULT NULL COMMENT '审核状态 1未审核  8审核通过 9审核未通过',
  `checknote` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '审核说明',
  `emailaddress` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱地址',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`bankaccid`) USING BTREE,
  INDEX `idx1`(`accno`, `accounttype`, `is_delete`) USING BTREE,
  INDEX `idx2`(`familyid`, `is_delete`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '提现账户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mem_baseinfo
-- ----------------------------
DROP TABLE IF EXISTS `mem_baseinfo`;
CREATE TABLE `mem_baseinfo`  (
                                 `memid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '用户id',
                                 `unique_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '0' COMMENT '会员ID',
                                 `superior_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                                 `accno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '会员标识号',
                                 `nickname` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '呢称',
                                 `memname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '真实姓名',
                                 `mobileno` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '手机号码',
                                 `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
                                 `sex` decimal(1, 0) NULL DEFAULT NULL COMMENT '性别 1男 2女 3保密',
                                 `level` int(0) NULL DEFAULT 0 COMMENT '等级',
                                 `agent_level` int(0) NULL DEFAULT 0,
                                 `idcardtype` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '证件类型DDINFO',
                                 `idcardno` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '证件号码',
                                 `idcardfront` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '证件照片正面',
                                 `idcardback` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '证件照片反面',
                                 `birthday` date NULL DEFAULT NULL COMMENT '出生日期',
                                 `nationality` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '国籍DDINFO',
                                 `headimg` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
                                 `registerdate` timestamp(0) NULL DEFAULT NULL COMMENT '注册日期',
                                 `recomcode` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '推荐码',
                                 `describes` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '描述',
                                 `tag` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '登录地址城市',
                                 `clintipadd` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '登录ip地址',
                                 `register_ip` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '注册ip',
                                 `register_dev` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '注册设备',
                                 `last_login_dev` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '登录设备',
                                 `logincountry` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '登录国家',
                                 `memfeatures` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '会员特征(兴趣)',
                                 `memorgin` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '来源 recommend推荐  regist注册  operator运营人员',
                                 `fansnum` bigint(0) NULL DEFAULT NULL COMMENT '粉丝数量',
                                 `goldnum` decimal(16, 3) NULL DEFAULT 0.000 COMMENT '用户乐币数量',
                                 `wait_amount` decimal(20, 3) NOT NULL DEFAULT 0.000 COMMENT '待开奖金额（元）',
                                 `withdrawal_remainder` decimal(20, 3) NOT NULL DEFAULT 0.000 COMMENT '可提现余额',
                                 `bet_amount` decimal(20, 3) NOT NULL DEFAULT 0.000 COMMENT '累计投注  (元)',
                                 `pay_amount` decimal(20, 3) NOT NULL DEFAULT 0.000 COMMENT '累计充值（元）',
                                 `pay_max` decimal(20, 3) NOT NULL DEFAULT 0.000 COMMENT '最大充值金额',
                                 `pay_first` decimal(20, 3) NOT NULL DEFAULT 0.000 COMMENT '首次充值金额',
                                 `pay_num` int(0) NOT NULL DEFAULT 0 COMMENT '充值总次数',
                                 `withdrawal_amount` decimal(20, 3) NOT NULL DEFAULT 0.000 COMMENT '累计提现（元)',
                                 `withdrawal_max` decimal(20, 3) NOT NULL DEFAULT 0.000 COMMENT '最大提现金额',
                                 `withdrawal_first` decimal(20, 3) NOT NULL DEFAULT 0.000 COMMENT '首次提现金额',
                                 `withdrawal_num` int(0) NOT NULL DEFAULT 0 COMMENT '提现总次数',
                                 `consume_amount` decimal(20, 3) NOT NULL DEFAULT 0.000 COMMENT '总消费(打码量)',
                                 `no_withdrawal_amount` decimal(20, 3) NOT NULL DEFAULT 0.000 COMMENT '不可提现金额(元)',
                                 `chat_status` int(0) NULL DEFAULT 1 COMMENT '聊天状态: 0,不允许;1,允许',
                                 `freeze_status` int(0) NULL DEFAULT 0 COMMENT '冻结状态: 0,不冻结;1,冻结',
                                 `bet_status` int(0) NULL DEFAULT 1 COMMENT '投注状态: 0,不允许;1,允许',
                                 `backwater_status` int(0) NULL DEFAULT 1 COMMENT '返水状态: 0,不允许;1,允许',
                                 `share_order_status` int(0) NULL DEFAULT 1 COMMENT '晒单状态(圈子使用): 0,不允许;1,允许',
                                 `logintype` decimal(2, 0) NULL DEFAULT NULL COMMENT '账户类型  普通会员1      主播2   家族长3   运营后台管理员8    第三方登录7   服务注册中心管理员9  聚合站点后台管理员10',
                                 `openId` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '第三方登录时返回的唯一标识',
                                 `sitearea` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '所在地(省市区)12位区域编码code',
                                 `wechat` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '微信号',
                                 `chatnickname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '微信昵称',
                                 `forbid_talk_type` int(0) NULL DEFAULT NULL COMMENT '禁言类型 0未禁言1临时2永久',
                                 `forbid_talk_start` timestamp(0) NULL DEFAULT NULL COMMENT '禁言开始时间',
                                 `forbid_talk_end` timestamp(0) NULL DEFAULT NULL COMMENT '禁言结束时间',
                                 `forbid_in_type` int(0) NULL DEFAULT NULL COMMENT '禁入类型 0未禁入1临时2永久',
                                 `forbid_in_start` timestamp(0) NULL DEFAULT NULL COMMENT '禁入开始时间',
                                 `forbid_in_end` timestamp(0) NULL DEFAULT NULL COMMENT '禁入结束时间',
                                 `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
                                 `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
                                 `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
                                 `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT '' COMMENT '最后修改人',
                                 `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
                                 `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
                                 `cg_nickname` bit(1) NULL DEFAULT b'0' COMMENT '0:未修改,1:已经修改过1次',
                                 `proxy_url` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '代理跳转url',
                                 PRIMARY KEY (`memid`) USING BTREE,
                                 UNIQUE INDEX `i_accno`(`accno`, `is_delete`) USING BTREE,
                                 UNIQUE INDEX `uk_recomcode`(`recomcode`) USING BTREE,
                                 INDEX `idx_supper_d`(`superior_id`, `is_delete`) USING BTREE,
                                 INDEX `idx_gold`(`accno`, `goldnum`, `is_delete`) USING BTREE,
                                 INDEX `idx_email_d`(`email`, `is_delete`, `create_time`) USING BTREE,
                                 INDEX `idx_name_mb_d`(`email`, `is_delete`, `unique_id`, `register_ip`) USING BTREE,
                                 INDEX `idx_time`(`is_delete`, `registerdate`, `accno`) USING BTREE,
                                 INDEX `idx_level`(`level`, `is_delete`, `registerdate`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员基本信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mem_baseinfo
-- ----------------------------
INSERT INTO `mem_baseinfo` VALUES (1, '0', '0', 'root', 'root', 'root', '973559275', 'root', NULL, 0, 0, '1', NULL, NULL, NULL, NULL, NULL, 'https://img.kxwwd.com/picture/headImage/1.png', '2023-01-05 01:05:43', 'fff666', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0.000, 0.000, 0.000, 0.000, 0.000, 0.000, 0, 0.000, 0.000, 0.000, 0, 0.000, 0.000, 1, 0, 1, 1, 1, NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, b'0', '', '2022-04-18 00:51:39', '', '2023-01-05 01:29:48', NULL, b'0', NULL);

SET FOREIGN_KEY_CHECKS = 1;

-- ----------------------------
-- Table structure for mem_certification
-- ----------------------------
DROP TABLE IF EXISTS `mem_certification`;
CREATE TABLE `mem_certification`  (
  `certid` bigint(0) NOT NULL AUTO_INCREMENT,
  `accno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '会员标识号',
  `certstatus` decimal(1, 0) NULL DEFAULT NULL COMMENT '认证状态 0已通过 1待审核 9未通过',
  `certdesc` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '认证说明（未通过原因等）',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`certid`) USING BTREE,
  INDEX `idx1`(`accno`, `certstatus`, `is_delete`, `create_time`) USING BTREE,
  INDEX `idx2`(`accno`, `is_delete`, `create_time`) USING BTREE,
  INDEX `idx3`(`is_delete`, `create_time`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '主播认证表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mem_daily_report
-- ----------------------------
DROP TABLE IF EXISTS `mem_daily_report`;
CREATE TABLE `mem_daily_report`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `date_str` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `recharge` decimal(16, 2) NULL DEFAULT NULL,
  `withdrawal` decimal(16, 2) NULL DEFAULT NULL,
  `task_award` decimal(16, 2) NULL DEFAULT NULL,
  `buy_vip` decimal(16, 2) NULL DEFAULT NULL,
  `task_brokerage` decimal(16, 2) NULL DEFAULT NULL,
  `vip_brokerage` decimal(16, 2) NULL DEFAULT NULL,
  `accno` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `top1_accno` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `top2_accno` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `top3_accno` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL,
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mem_faceset
-- ----------------------------
DROP TABLE IF EXISTS `mem_faceset`;
CREATE TABLE `mem_faceset`  (
  `faceid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '美颜id',
  `accno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '会员标识号',
  `beauty` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '美颜参数设置 （json）',
  `filter` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '滤镜参数设置（json）',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`faceid`) USING BTREE,
  INDEX `idx1`(`accno`, `is_delete`, `create_time`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '美颜滤镜设置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mem_family
-- ----------------------------
DROP TABLE IF EXISTS `mem_family`;
CREATE TABLE `mem_family`  (
  `familyid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '家族id',
  `familyname` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '家族名称',
  `accno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '会员标识符',
  `familyman` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '家族长姓名',
  `idcardno` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '证件号码',
  `telephone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '行动电话',
  `memnums` bigint(0) NOT NULL COMMENT '家族主播数量 默认为0',
  `royaltypercent` decimal(16, 2) NULL DEFAULT NULL COMMENT '提成比例',
  `bettingpercentage` decimal(16, 3) NULL DEFAULT NULL COMMENT '投注分成比例',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`familyid`) USING BTREE,
  INDEX `idx1`(`familyname`, `is_delete`, `create_time`) USING BTREE,
  INDEX `idx2`(`accno`, `is_delete`, `create_time`) USING BTREE,
  INDEX `idx3`(`is_delete`, `create_time`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '家族信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mem_familymem
-- ----------------------------
DROP TABLE IF EXISTS `mem_familymem`;
CREATE TABLE `mem_familymem`  (
  `familymemid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '家族成员id',
  `familyid` bigint(0) NULL DEFAULT NULL COMMENT '家族id',
  `accno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '会员标识号',
  `nickname` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '成员暱称',
  `royaltypercent` decimal(16, 2) NULL DEFAULT NULL COMMENT '提成比例 两位小数',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`familymemid`) USING BTREE,
  INDEX `fk_reference_42`(`familyid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '家族成员信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mem_follow
-- ----------------------------
DROP TABLE IF EXISTS `mem_follow`;
CREATE TABLE `mem_follow`  (
  `followid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '关注id',
  `memid` bigint(0) NULL DEFAULT NULL COMMENT '被关注用户id',
  `accno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '会员标识号',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`followid`) USING BTREE,
  INDEX `fk_reference_37`(`memid`, `is_delete`, `create_time`) USING BTREE,
  INDEX `idx2`(`accno`, `is_delete`, `create_time`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员关注' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mem_goldchange
-- ----------------------------
DROP TABLE IF EXISTS `mem_goldchange`;
CREATE TABLE `mem_goldchange`  (
  `goldchangid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '金币变动明细id',
  `refid` bigint(0) NULL DEFAULT NULL COMMENT '相关id 如充值订单id 、 打赏id 、彩票派奖id(ksorderid)  代理结算id',
  `refaccno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '乐币来源主播accno',
  `accno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '会员标识号',
  `superior_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `changetype` int(0) NULL DEFAULT NULL COMMENT '变动类型 1充值 2打赏 3赠送 4签到奖励 5发帖奖励 6 发视频奖励 7 邀请用户 8充值附赠 9 主播分成 10 提现申请 11提现取消 12已提现 13彩票派奖 14彩票下注 15彩票下注取消 16稽核手续费 17稽核手续费取消\r\n18 棋牌转出 19棋牌转入 20代理结算\r\n',
  `goldnum` decimal(16, 3) NULL DEFAULT NULL COMMENT '充值/提现前播币数',
  `quantity` decimal(16, 3) NULL DEFAULT NULL COMMENT '充值/提现播币数量',
  `amount` decimal(16, 3) NULL DEFAULT NULL COMMENT '金额',
  `recgoldnum` decimal(16, 3) NULL DEFAULT NULL COMMENT '充值/提现后播币数',
  `pre_cgdml` decimal(16, 3) NULL DEFAULT NULL COMMENT '变动前打码量',
  `after_cgdml` decimal(16, 3) NULL DEFAULT NULL COMMENT '变动后打码量',
  `opnote` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作说明',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `snow_sn` bigint(0) NULL DEFAULT 0 COMMENT '雪花排序号',
  `source` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '来源：Android | IOS | WEB',
  PRIMARY KEY (`goldchangid`) USING BTREE,
  INDEX `fk_relationship_28`(`refid`, `is_delete`) USING BTREE,
  INDEX `idx_type_delete`(`changetype`, `is_delete`) USING BTREE,
  INDEX `idx_time`(`create_time`) USING BTREE,
  INDEX `idx_qu`(`quantity`) USING BTREE,
  INDEX `idx_qu_chty`(`changetype`, `quantity`, `update_time`) USING BTREE,
  INDEX `idx_accno_type_time`(`accno`, `changetype`, `create_time`, `update_time`) USING BTREE,
  INDEX `idx_refaccno`(`refaccno`, `changetype`, `is_delete`, `create_time`, `update_time`) USING BTREE,
  INDEX `idx_time_up`(`update_time`) USING BTREE,
  INDEX `idx_changtype`(`changetype`, `create_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员金币变动明细' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mem_level
-- ----------------------------
DROP TABLE IF EXISTS `mem_level`;
CREATE TABLE `mem_level`  (
  `levelid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '等级id',
  `accno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '会员标识号',
  `memlevel` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '当前等级',
  `memscore` decimal(16, 2) NULL DEFAULT NULL COMMENT '会员当前积分',
  `nextlevscore` decimal(16, 2) NULL DEFAULT NULL COMMENT '距离下一级所需积分',
  `levellog` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '等级log',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `locked` bit(1) NOT NULL DEFAULT b'0' COMMENT '0:未锁定,1:锁定',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `expire_time` timestamp(0) NULL DEFAULT NULL COMMENT '过期时间 如 2020年9月10日17:46:55',
  `level_config_id` bigint(0) NULL DEFAULT NULL COMMENT '等级配置表ID',
  PRIMARY KEY (`levelid`, `is_delete`) USING BTREE,
  INDEX `tp_reference_02`(`accno`, `is_delete`, `locked`) USING BTREE,
  INDEX `idx_config`(`accno`, `is_delete`, `update_time`, `expire_time`, `level_config_id`) USING BTREE,
  INDEX `idx_id`(`levelid`, `is_delete`, `expire_time`, `level_config_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '会员等级' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mem_level
-- ----------------------------
INSERT INTO `mem_level` VALUES (1, 'root', '1', 1.00, 1.00, '1', b'0', b'0', '', '2022-04-19 00:47:23', '', '2023-01-05 01:24:32', '2024-10-30 23:53:39', 1);

-- ----------------------------
-- Table structure for mem_level_config
-- ----------------------------
DROP TABLE IF EXISTS `mem_level_config`;
CREATE TABLE `mem_level_config`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '等级id',
  `level` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '当前等级',
  `level_seq` int(0) NULL DEFAULT 0 COMMENT '等级编号',
  `level_icon_url` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '等级图标地址',
  `image_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `recharge_amount` decimal(16, 2) NULL DEFAULT NULL COMMENT '所需购买金额',
  `promote_amount` decimal(16, 2) NULL DEFAULT NULL COMMENT '推广获得金额',
  `do_task_times` int(0) NULL DEFAULT NULL COMMENT '任务次数',
  `expire_time` int(0) NULL DEFAULT NULL COMMENT '有效时长 按月 如 12  ',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `level_seq_key`(`level_seq`) USING BTREE COMMENT '唯一索引',
  INDEX `idx_id`(`id`) USING BTREE,
  INDEX `idx_amount`(`recharge_amount`) USING BTREE,
  INDEX `idx_taskTime`(`do_task_times`) USING BTREE,
  INDEX `idx_up_ex_time`(`expire_time`, `update_time`) USING BTREE,
  INDEX `idx_cr_time`(`create_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '会员等级配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mem_level_config
-- ----------------------------
INSERT INTO `mem_level_config` VALUES (1, 'vip0', 0, NULL, 'http://16.162.80.109:9000/picture/3244fd0f50774153b2ffc9f213e795a9.png', 0.00, 1200.00, 4, 365, b'1', 'supermanage', '2022-04-20 21:14:34', '', '2022-12-21 05:00:17');
INSERT INTO `mem_level_config` VALUES (2, 'vip1', 1, NULL, 'http://16.162.80.109:9000/picture/3244fd0f50774153b2ffc9f213e795a9.png', 350000.00, 1560.00, 5, 365, b'1', 'supermanage', '2022-04-20 21:15:26', '', '2022-12-21 05:11:12');
INSERT INTO `mem_level_config` VALUES (3, 'vip2', 2, NULL, 'http://16.162.80.109:9000/picture/3244fd0f50774153b2ffc9f213e795a9.png', 1050000.00, 3285.00, 7, 365, b'1', 'supermanage', '2022-04-20 21:15:33', '', '2022-12-21 05:11:48');
INSERT INTO `mem_level_config` VALUES (4, 'vip3', 3, NULL, 'http://16.162.80.109:9000/picture/3244fd0f50774153b2ffc9f213e795a9.png', 2100000.00, 3883.00, 12, 365, b'1', 'supermanage', '2022-04-20 21:15:39', '', '2022-12-21 05:12:19');
INSERT INTO `mem_level_config` VALUES (5, 'vip4', 4, '', NULL, 4200000.00, 5185.00, 18, 365, b'1', 'supermanage', '2022-05-24 12:37:21', '', '2022-12-21 05:12:45');
INSERT INTO `mem_level_config` VALUES (6, 'vip5', 5, '', NULL, 10500000.00, 9722.00, 24, 365, b'1', 'supermanage', '2022-05-24 12:39:56', '', '2022-12-21 05:13:16');
INSERT INTO `mem_level_config` VALUES (7, 'vip6', 6, '', NULL, 21000000.00, 12962.00, 36, 365, b'0', 'supermanage', '2022-05-24 12:40:28', '', '2022-12-21 05:14:58');
INSERT INTO `mem_level_config` VALUES (8, 'vip7', 7, '', NULL, 31500000.00, 16666.00, 42, 365, b'0', 'supermanage', '2022-12-21 05:15:53', '', '2022-12-21 19:15:52');
INSERT INTO `mem_level_config` VALUES (9, 'vip8', 8, '', NULL, 63000000.00, 26923.00, 52, 365, b'0', 'supermanage', '2022-12-21 05:16:41', '', '2022-12-21 19:16:40');

-- ----------------------------
-- Table structure for mem_login
-- ----------------------------
DROP TABLE IF EXISTS `mem_login`;
CREATE TABLE `mem_login`  (
  `loginid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '登录账号id',
  `accno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '会员标识号',
  `acclogin` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '会员账号(登录用)',
  `logintype` decimal(2, 0) NULL DEFAULT NULL COMMENT '账户类型  普通会员1      主播2   家族长3 代充人4 运营后台管理员8    第三方登录7   服务注册中心管理员9  聚合站点后台管理员10',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登陆密码',
  `passwordmd5` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '登录密码MD5',
  `paypassword` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付密码md5',
  `accstatus` decimal(1, 0) NOT NULL COMMENT '账号状态 1正常 9禁止登陆 ',
  `lastlogindate` timestamp(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `loginnum` int(0) NULL DEFAULT NULL COMMENT '登录总次数',
  `clintipadd` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登录ip地址',
  PRIMARY KEY (`loginid`) USING BTREE,
  UNIQUE INDEX `i_loginacc`(`acclogin`, `logintype`) USING BTREE,
  INDEX `idx1`(`logintype`, `acclogin`, `accstatus`) USING BTREE,
  INDEX `idx2`(`accstatus`) USING BTREE,
  INDEX `idx3`(`accno`) USING BTREE,
  INDEX `Unique_acclogin`(`acclogin`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员登录账号' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mem_login
-- ----------------------------
INSERT INTO `mem_login` VALUES (1, 'root', 'root', 1, 'e10adc3949ba59abbe56e057f20f883e', '1b7a346bb100e5010669d3a4dd2bfa1c', '', 1, '2022-04-18 01:13:01', 1, '127.0.0.1');

-- ----------------------------
-- Table structure for mem_relationship
-- ----------------------------
DROP TABLE IF EXISTS `mem_relationship`;
CREATE TABLE `mem_relationship`  (
  `relaid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '关系id',
  `refaccno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '推荐人标识号',
  `parent_id` bigint(0) NULL DEFAULT NULL,
  `accno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '会员标识号',
  `memname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT '0' COMMENT '真实姓名',
  `sub_num` int(0) NULL DEFAULT 0,
  `sup_recomcode` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `head_accno` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`relaid`) USING BTREE,
  INDEX `idx1`(`accno`, `is_delete`) USING BTREE,
  INDEX `idx_refaccno`(`refaccno`) USING BTREE,
  INDEX `idx_accno`(`accno`) USING BTREE,
  INDEX `idx_memname`(`memname`) USING BTREE,
  INDEX `idx_parent_id`(`parent_id`) USING BTREE,
  INDEX `idx_relaid`(`relaid`) USING BTREE,
  INDEX `idx2`(`refaccno`, `is_delete`, `accno`) USING BTREE,
  INDEX `idx_accno_head`(`accno`, `head_accno`, `is_delete`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员推荐关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mem_relationship
-- ----------------------------
INSERT INTO `mem_relationship` VALUES (1, 'ROOT', NULL, 'root', 'root', 0, NULL, NULL, b'0', '', '2022-04-19 01:44:43', '', '2023-01-05 01:25:04');

-- ----------------------------
-- Table structure for mem_repayuser
-- ----------------------------
DROP TABLE IF EXISTS `mem_repayuser`;
CREATE TABLE `mem_repayuser`  (
  `repaymemid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '代充人id',
  `accno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '会员accno',
  `nickname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '代充人昵称',
  `qq` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'QQ',
  `webchat` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '微信',
  `alipay` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付宝账号',
  `mobileno` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `memgold` decimal(16, 3) NULL DEFAULT NULL COMMENT '代充余额',
  `onlinedates` datetime(0) NULL DEFAULT NULL COMMENT '营业时间起',
  `onlinedatee` datetime(0) NULL DEFAULT NULL COMMENT '营业时间止',
  `repaynums` bigint(0) NULL DEFAULT NULL COMMENT '代充次数',
  `discountrag` decimal(5, 2) NULL DEFAULT NULL COMMENT '充值优惠(%)   ',
  `status` decimal(1, 0) NULL DEFAULT NULL COMMENT '启用状态0启用9未启用',
  `is_delete` bit(1) NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '最后修改人',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`repaymemid`) USING BTREE,
  INDEX `mem_repayuser_union1`(`onlinedates`, `onlinedatee`) USING BTREE,
  INDEX `mem_repayuser_accno`(`accno`) USING BTREE,
  INDEX `mem_repayuser_nickname`(`nickname`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '代充人信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mem_signin
-- ----------------------------
DROP TABLE IF EXISTS `mem_signin`;
CREATE TABLE `mem_signin`  (
  `signinid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '签到id',
  `accno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '会员标识号',
  `signinnum` int(0) NULL DEFAULT NULL COMMENT '连续签到天数',
  `signintime` datetime(0) NULL DEFAULT NULL COMMENT '签到时间',
  PRIMARY KEY (`signinid`) USING BTREE,
  INDEX `idx1`(`accno`, `signintime`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员签到记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mem_sub_info
-- ----------------------------
DROP TABLE IF EXISTS `mem_sub_info`;
CREATE TABLE `mem_sub_info`  (
  `accno` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `level_one_agents` json NULL,
  `level_two_agents` json NULL,
  `level_three_agents` json NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `update_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`accno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for mem_wallet_address
-- ----------------------------
DROP TABLE IF EXISTS `mem_wallet_address`;
CREATE TABLE `mem_wallet_address`  (
  `address_id` int(0) NOT NULL AUTO_INCREMENT,
  `accno` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `coin_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `money_address` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `create_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL,
  `update_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `update_time` timestamp(0) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`address_id`) USING BTREE,
  INDEX `idex_a_d`(`accno`, `coin_name`, `money_address`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 54559 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for member_credit
-- ----------------------------
DROP TABLE IF EXISTS `member_credit`;
CREATE TABLE `member_credit`  (
  `id` bigint(0) NULL DEFAULT NULL COMMENT 'id',
  `member_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员标识',
  `integral` int(0) NULL DEFAULT NULL COMMENT '积分',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `update_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `create_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  INDEX `idex_accno`(`member_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for member_credit_change
-- ----------------------------
DROP TABLE IF EXISTS `member_credit_change`;
CREATE TABLE `member_credit_change`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `accno` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `ref_acclogin` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `integral` int(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for member_credit_detail
-- ----------------------------
DROP TABLE IF EXISTS `member_credit_detail`;
CREATE TABLE `member_credit_detail`  (
  `id` int(0) NULL DEFAULT NULL COMMENT 'id',
  `member_no` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员标识',
  `integral` int(0) NULL DEFAULT NULL COMMENT '积分',
  `type` int(0) NULL DEFAULT NULL COMMENT '1 增加 2 扣除',
  `source` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '来源',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `update_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for member_device_calc
-- ----------------------------
DROP TABLE IF EXISTS `member_device_calc`;
CREATE TABLE `member_device_calc`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `total_count` int(0) NOT NULL DEFAULT 0 COMMENT '总人数',
  `android_count` int(0) NOT NULL DEFAULT 0 COMMENT '安卓在线人数',
  `ios_count` int(0) NOT NULL DEFAULT 0 COMMENT 'ios人数',
  `h5_count` int(0) NOT NULL DEFAULT 0 COMMENT 'h5人数',
  `web_count` int(0) NOT NULL DEFAULT 0 COMMENT 'pc人数',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '在线设备统计(包括游客)' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for member_online_calc
-- ----------------------------
DROP TABLE IF EXISTS `member_online_calc`;
CREATE TABLE `member_online_calc`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `total_count` int(0) NOT NULL DEFAULT 0 COMMENT '总人数',
  `android_count` int(0) NOT NULL DEFAULT 0 COMMENT '安卓在线人数',
  `ios_count` int(0) NOT NULL DEFAULT 0 COMMENT 'ios人数',
  `h5_count` int(0) NOT NULL DEFAULT 0 COMMENT 'h5人数',
  `web_count` int(0) NOT NULL DEFAULT 0 COMMENT 'pc人数',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '在线人数统计' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for onelhc_lottery_sg
-- ----------------------------
DROP TABLE IF EXISTS `onelhc_lottery_sg`;
CREATE TABLE `onelhc_lottery_sg`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `date` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '日期',
  `issue` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '第几期',
  `number` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '开奖号码',
  `time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '更新时间',
  `ideal_time` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '官方开奖时间',
  `open_status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT 'WAIT' COMMENT '状态：WAIT 等待开奖 | AUTO 自动开奖 | HANDLE 手动开奖',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UN1_issue`(`issue`) USING BTREE,
  INDEX `idx1_ideal_time`(`ideal_time`) USING BTREE,
  INDEX `idx_o_i`(`open_status`, `ideal_time`) USING BTREE,
  INDEX `idx_o_i_i`(`open_status`, `issue`, `ideal_time`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '六合彩的开奖结果' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for operate_sensitive_log
-- ----------------------------
DROP TABLE IF EXISTS `operate_sensitive_log`;
CREATE TABLE `operate_sensitive_log`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `uid` int(0) NOT NULL DEFAULT 0 COMMENT '用户id',
  `account` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '用户帐号',
  `operate_ip` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '当前登录ip地址',
  `request_type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '0' COMMENT '请求类型，GET，POST',
  `url` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '操作对应的url',
  `module` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '模块名字',
  `methods` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '方法名',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `response_time` bigint(0) NOT NULL DEFAULT 0 COMMENT '响应时间（毫秒）',
  `response_result` int(0) NOT NULL DEFAULT 0 COMMENT '响应结果，0：执行成功，1：执行失败',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '敏感操作日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_append_record
-- ----------------------------
DROP TABLE IF EXISTS `order_append_record`;
CREATE TABLE `order_append_record`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` int(0) NOT NULL COMMENT '用户id',
  `lottery_id` int(0) NOT NULL COMMENT '彩种id',
  `play_id` int(0) NOT NULL COMMENT '玩法id',
  `setting_id` int(0) NOT NULL COMMENT '配置id',
  `first_issue` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '第一期期号',
  `bet_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '投注号码',
  `bet_count` int(0) NOT NULL COMMENT '投注注数',
  `bet_price` decimal(10, 2) NOT NULL COMMENT '单注金额',
  `win_amount` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '累计中奖金额',
  `win_count` int(0) NOT NULL DEFAULT 0 COMMENT '累计中奖注数',
  `bet_multiples` double(10, 2) NOT NULL DEFAULT 2.00 COMMENT '投注倍数',
  `double_multiples` double(10, 2) NOT NULL DEFAULT 1.00 COMMENT '翻倍倍数',
  `append_count` int(0) NOT NULL COMMENT '追号期数',
  `appended_count` int(0) NOT NULL DEFAULT 0 COMMENT '已追期数',
  `type` int(0) NOT NULL COMMENT '类型：1 同倍追号 | 2 翻倍追号',
  `win_stop` bit(1) NOT NULL DEFAULT b'1' COMMENT '中奖后停止追号：1停止 | 0不停止',
  `is_stop` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否已停止追号',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '追号记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_bet_record
-- ----------------------------
DROP TABLE IF EXISTS `order_bet_record`;
CREATE TABLE `order_bet_record`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NOT NULL COMMENT '用户id',
  `order_id` int(0) NOT NULL COMMENT '投注单id',
  `cate_id` int(0) NOT NULL COMMENT '彩种类别id',
  `lottery_id` int(0) NOT NULL COMMENT '彩种id',
  `play_id` int(0) NOT NULL COMMENT '玩法id',
  `setting_id` int(0) NOT NULL COMMENT '玩法配置id',
  `play_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '玩法名称',
  `issue` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '购买的期号',
  `order_sn` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '订单号',
  `bet_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '投注号码',
  `bet_count` int(0) NOT NULL COMMENT '投注总注数',
  `bet_amount` decimal(20, 3) NOT NULL COMMENT '投注金额',
  `win_amount` decimal(20, 3) NOT NULL DEFAULT 0.000 COMMENT '中奖金额',
  `back_amount` decimal(20, 3) NOT NULL DEFAULT 0.000 COMMENT '返点金额',
  `god_order_id` int(0) NOT NULL DEFAULT 0 COMMENT '大神推单id, 0为自主投注',
  `tb_status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT 'WAIT' COMMENT '状态：中奖:WIN | 未中奖:NO_WIN | 等待开奖:WAIT | 和:HE | 撤单:BACK',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `win_count` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT '0' COMMENT '中奖注数',
  `is_push` int(0) NULL DEFAULT 0 COMMENT '是否推单 0 否 1 是',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `source` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '来源：Android | IOS | WEB',
  `familyid` bigint(0) NULL DEFAULT NULL COMMENT '直播间购彩对应的家族id',
  `room_id` bigint(0) NULL DEFAULT NULL COMMENT '直播房间id',
  `type` int(0) NOT NULL DEFAULT 0 COMMENT '0:普通订单 1:试玩订单',
  `trial_id` int(0) NULL DEFAULT NULL COMMENT '试玩房间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx01_play_id`(`play_id`, `lottery_id`, `tb_status`) USING BTREE,
  INDEX `god_order_id`(`god_order_id`, `tb_status`) USING BTREE,
  INDEX `idx02_create_time`(`create_time`) USING BTREE,
  INDEX `idx04_sort1`(`user_id`, `bet_amount`, `create_time`) USING BTREE,
  INDEX `idx05_sort2`(`user_id`, `create_time`) USING BTREE,
  INDEX `idx06_sort3`(`user_id`, `win_amount`, `create_time`) USING BTREE,
  INDEX `idx_order_id`(`order_id`) USING BTREE,
  INDEX `idx07_lottery_id`(`lottery_id`, `tb_status`) USING BTREE,
  INDEX `idx_bet_amount`(`bet_amount`) USING BTREE,
  INDEX `idx_win_amount`(`win_amount`) USING BTREE,
  INDEX `idx_tb_status`(`tb_status`) USING BTREE,
  INDEX `idx_setting_id`(`setting_id`) USING BTREE,
  INDEX `idx_is_push`(`is_push`) USING BTREE,
  INDEX `idx_update_time`(`update_time`) USING BTREE,
  INDEX `idx_cate_id`(`cate_id`) USING BTREE,
  INDEX `idx_order_sn`(`order_sn`) USING BTREE,
  INDEX `idx_issue`(`issue`) USING BTREE,
  INDEX `idx_u_r`(`user_id`, `room_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户投注单-注号记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_record
-- ----------------------------
DROP TABLE IF EXISTS `order_record`;
CREATE TABLE `order_record`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `order_sn` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '订单号',
  `issue` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '购买的期号',
  `user_id` int(0) NOT NULL COMMENT '购彩用户id',
  `lottery_id` int(0) NOT NULL COMMENT '彩种id',
  `append_id` int(0) NOT NULL DEFAULT 0 COMMENT '追号id（为0则为非追号订单）',
  `open_number` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT '' COMMENT '开奖号码',
  `source` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '来源：Android | IOS | WEB',
  `buy_source` int(0) NULL DEFAULT 0 COMMENT '购彩来源',
  `status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT 'NORMAL' COMMENT '订单状态：正常：NORMAL；撤单：BACK;',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `order_sn`(`order_sn`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `idx02_issue`(`issue`, `lottery_id`, `status`, `open_number`) USING BTREE,
  INDEX `idx01_count`(`id`, `create_time`) USING BTREE,
  INDEX `idx03_create_time`(`create_time`) USING BTREE,
  INDEX `idx_issue`(`issue`) USING BTREE,
  INDEX `idx_lottery_id`(`lottery_id`) USING BTREE,
  INDEX `idx_status`(`status`) USING BTREE,
  INDEX `idx_open_number`(`open_number`) USING BTREE,
  INDEX `idx_source`(`source`) USING BTREE,
  INDEX `idx_update_time`(`update_time`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户投注单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_robot_record
-- ----------------------------
DROP TABLE IF EXISTS `order_robot_record`;
CREATE TABLE `order_robot_record`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NULL DEFAULT NULL COMMENT '用户id',
  `order_id` int(0) NOT NULL COMMENT '投注单id',
  `cate_id` int(0) NOT NULL COMMENT '彩种类别id',
  `lottery_id` int(0) NOT NULL COMMENT '彩种id',
  `play_id` int(0) NOT NULL COMMENT '玩法id',
  `setting_id` int(0) NOT NULL COMMENT '玩法配置id',
  `play_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '玩法名称',
  `issue` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '购买的期号',
  `order_sn` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '订单号',
  `bet_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '投注号码',
  `bet_count` int(0) NOT NULL COMMENT '投注总注数',
  `bet_amount` decimal(20, 2) NOT NULL COMMENT '投注金额',
  `win_amount` decimal(20, 2) NOT NULL DEFAULT 0.00 COMMENT '中奖金额',
  `back_amount` decimal(20, 2) NOT NULL DEFAULT 0.00 COMMENT '返点金额',
  `is_roboter` int(0) NOT NULL DEFAULT 0 COMMENT '是否机器人注单, 0是 1否',
  `tb_status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT 'WAIT' COMMENT '状态：中奖:WIN | 未中奖:NO_WIN | 等待开奖:WAIT | 和:HE | 撤单:BACK',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `win_count` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT '0' COMMENT '中奖注数',
  `is_push` int(0) NULL DEFAULT 0 COMMENT '是否推单 0 否 1 是',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `source` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '来源：Android | IOS | WEB',
  `familyid` bigint(0) NULL DEFAULT NULL COMMENT '直播间购彩对应的家族id',
  `room_id` bigint(0) NULL DEFAULT NULL COMMENT '直播房间id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx01_play_id`(`play_id`, `lottery_id`, `tb_status`) USING BTREE,
  INDEX `god_order_id`(`is_roboter`, `tb_status`) USING BTREE,
  INDEX `idx02_create_time`(`create_time`) USING BTREE,
  INDEX `idx04_sort1`(`user_id`, `bet_amount`, `create_time`) USING BTREE,
  INDEX `idx05_sort2`(`user_id`, `create_time`) USING BTREE,
  INDEX `idx06_sort3`(`user_id`, `win_amount`, `create_time`) USING BTREE,
  INDEX `idx_order_id`(`order_id`) USING BTREE,
  INDEX `idx07_lottery_id`(`lottery_id`, `tb_status`) USING BTREE,
  INDEX `idx_bet_amount`(`bet_amount`) USING BTREE,
  INDEX `idx_win_amount`(`win_amount`) USING BTREE,
  INDEX `idx_tb_status`(`tb_status`) USING BTREE,
  INDEX `idx_setting_id`(`setting_id`) USING BTREE,
  INDEX `idx_is_push`(`is_push`) USING BTREE,
  INDEX `idx_update_time`(`update_time`) USING BTREE,
  INDEX `idx_cate_id`(`cate_id`) USING BTREE,
  INDEX `idx_order_sn`(`order_sn`) USING BTREE,
  INDEX `idx_issue`(`issue`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '机器人投注中奖模板记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for org_adminprivilege
-- ----------------------------
DROP TABLE IF EXISTS `org_adminprivilege`;
CREATE TABLE `org_adminprivilege`  (
  `ogadid` bigint(0) NOT NULL COMMENT '子账号id',
  `sfunid` bigint(0) NOT NULL COMMENT '功能id',
  PRIMARY KEY (`ogadid`, `sfunid`) USING BTREE,
  INDEX `fk_reference_33`(`sfunid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '子账号功能权限' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pay_bank
-- ----------------------------
DROP TABLE IF EXISTS `pay_bank`;
CREATE TABLE `pay_bank`  (
  `bank_id` int(0) NOT NULL AUTO_INCREMENT,
  `bank_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `bank_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT 0,
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`bank_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pay_bank
-- ----------------------------
INSERT INTO `pay_bank` VALUES (1, 'Vietcombank', '越南外贸股份商业银行', 1, '2023-01-03 16:00:43');
INSERT INTO `pay_bank` VALUES (2, 'Vietinbank', '越南工商银行', 1, '2023-01-03 16:00:44');
INSERT INTO `pay_bank` VALUES (3, 'Techcombank ', '越南科技与商业股份银行', 1, '2023-01-03 16:00:45');
INSERT INTO `pay_bank` VALUES (4, 'MBBank', '越南军队银行', 1, '2023-01-03 16:00:46');
INSERT INTO `pay_bank` VALUES (5, 'ACB', '亚洲商业银行', 1, '2023-01-03 16:00:46');
INSERT INTO `pay_bank` VALUES (6, 'BIDV', '越南投资发展银行', 1, '2023-01-03 16:00:47');
INSERT INTO `pay_bank` VALUES (7, 'Agribank', '越南农业与农村发展银行', 1, '2023-01-03 16:00:49');

-- ----------------------------
-- Table structure for pay_merchant
-- ----------------------------
DROP TABLE IF EXISTS `pay_merchant`;
CREATE TABLE `pay_merchant`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `pay_chan_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `pay_chan_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `merchant_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `merchant_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT 0,
  `merchant_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `page_back_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `notify_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `create_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_user` varchar(0) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pay_merchant
-- ----------------------------
INSERT INTO `pay_merchant` VALUES (1, '1', '1', '1', 'CS', 1, 'd2fb04d8103613b8d391ebc2d34228bd', 'https://wegrty.com', 'http://45.207.49.109:5858/cs/callback', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for pay_recharge_order
-- ----------------------------
DROP TABLE IF EXISTS `pay_recharge_order`;
CREATE TABLE `pay_recharge_order`  (
  `recharge_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `accno` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `amount` decimal(19, 2) NULL DEFAULT 0.00,
  `trade_Id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `order_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '',
  `order_status` int(0) NULL DEFAULT NULL,
  `trade_status` int(0) NULL DEFAULT NULL,
  `create_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_user` varchar(0) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`recharge_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pay_type
-- ----------------------------
DROP TABLE IF EXISTS `pay_type`;
CREATE TABLE `pay_type`  (
  `id` int(0) NOT NULL,
  `merchant_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `pay_type_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `pay_type_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `pay_type_name_viet` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `pay_type_name_en` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT 0,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pay_type
-- ----------------------------
INSERT INTO `pay_type` VALUES (1, 'CS', 'OnlineBank', '账户转账', 'Tài khoản chuyển tiền', 'OnlineBank', 1, NULL, NULL);
INSERT INTO `pay_type` VALUES (2, 'CS', 'ScanCode', '银行扫码付', 'Quét mã thanh toán', 'ScanCode', 0, NULL, NULL);
INSERT INTO `pay_type` VALUES (3, 'CS', 'DirectBank', '网银直连', 'Liên kết trực tiếp ngân hàng', 'DirectBank', 0, NULL, NULL);

-- ----------------------------
-- Table structure for pcegg_lottery_sg
-- ----------------------------
DROP TABLE IF EXISTS `pcegg_lottery_sg`;
CREATE TABLE `pcegg_lottery_sg`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `issue` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '期号',
  `number` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '开奖号码',
  `cpk_number` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '彩票控开奖结果',
  `kcw_number` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '开彩网开奖结果',
  `time` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '实际开奖时间',
  `ideal_time` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '理想开奖时间',
  `open_status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT 'WAIT' COMMENT '状态：WAIT 等待开奖 | AUTO 自动开奖 | HANDLE 手动开奖',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `Unique_issue`(`issue`) USING BTREE,
  INDEX `idx2_open_status`(`open_status`) USING BTREE,
  INDEX `idx1_ideal_time`(`ideal_time`) USING BTREE,
  INDEX `idx_o_i`(`open_status`, `ideal_time`) USING BTREE,
  INDEX `idx_o_i_i`(`open_status`, `issue`, `ideal_time`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for platform_goldchange
-- ----------------------------
DROP TABLE IF EXISTS `platform_goldchange`;
CREATE TABLE `platform_goldchange`  (
  `pgoldid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '抽成记录id',
  `refid` bigint(0) NULL DEFAULT NULL COMMENT '相关id 如充值订单id 、 打赏id',
  `refaccno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '乐币来源主播accno',
  `scale` decimal(16, 2) NULL DEFAULT NULL COMMENT '提成比例（如0.25）',
  `goldnum` decimal(16, 2) NULL DEFAULT NULL COMMENT '提成获得乐币数',
  `opnote` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作说明',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`pgoldid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '平台抽成记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for return_lottery_set
-- ----------------------------
DROP TABLE IF EXISTS `return_lottery_set`;
CREATE TABLE `return_lottery_set`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `lottery_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '彩种名称',
  `lottery_category_id` int(0) NULL DEFAULT NULL,
  `lottery_id` int(0) NULL DEFAULT NULL COMMENT '彩种ID',
  `water_amout` int(0) NULL DEFAULT NULL COMMENT '返水比例',
  `amount` decimal(20, 3) NULL DEFAULT NULL COMMENT '金额',
  `edit_user` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '修改人',
  `edit_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `index_category_lottery`(`lottery_category_id`, `lottery_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '购彩返水' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for return_third_set
-- ----------------------------
DROP TABLE IF EXISTS `return_third_set`;
CREATE TABLE `return_third_set`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `type` int(0) NULL DEFAULT NULL COMMENT '类型  1开元  2 AG 3 电竞',
  `water_amout` int(0) NULL DEFAULT NULL COMMENT '返水比例',
  `amount` decimal(20, 3) NULL DEFAULT NULL COMMENT '金额',
  `edit_user` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '修改人',
  `edit_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '返水设置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for return_water_set
-- ----------------------------
DROP TABLE IF EXISTS `return_water_set`;
CREATE TABLE `return_water_set`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `type` int(0) NULL DEFAULT NULL COMMENT '类型  1 购彩 2 开元 3 AG 4 电竞',
  `is_start` int(0) NULL DEFAULT NULL COMMENT '是否开启',
  `edit_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `edit_user` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '返水设置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_agentinfo
-- ----------------------------
DROP TABLE IF EXISTS `sys_agentinfo`;
CREATE TABLE `sys_agentinfo`  (
  `agentid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '代理id',
  `agentname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '代理名称',
  `minamt` decimal(16, 3) NULL DEFAULT NULL COMMENT '业绩最低标准额(日)',
  `maxamt` decimal(16, 3) NULL DEFAULT NULL COMMENT '业绩最高标准额',
  `commission` decimal(5, 2) NULL DEFAULT NULL COMMENT '返佣比(%)',
  `sortby` int(0) NULL DEFAULT NULL COMMENT '排序权重',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`agentid`) USING BTREE,
  INDEX `idx1`(`agentname`, `is_delete`, `create_time`) USING BTREE,
  INDEX `idx2`(`agentid`, `is_delete`, `create_time`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '推广代理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_anchortenlive
-- ----------------------------
DROP TABLE IF EXISTS `sys_anchortenlive`;
CREATE TABLE `sys_anchortenlive`  (
  `roomid` bigint(0) NULL DEFAULT NULL COMMENT '主播房间',
  `accno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '主播会员标识号',
  `status` decimal(1, 0) NULL DEFAULT NULL COMMENT '启用状态0启用9未启用',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  INDEX `fk_reference_90`(`roomid`) USING BTREE,
  CONSTRAINT `sys_anchortenlive_ibfk_1` FOREIGN KEY (`roomid`) REFERENCES `bas_anchorroom` (`roomid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '騰訊云主播表(騰訊云開播主播關聯表)' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_app_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_app_info`;
CREATE TABLE `sys_app_info`  (
  `appid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '升级id',
  `appname` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'app名称',
  `version` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '版本',
  `versionname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '版本名称',
  `appsize` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'app安装包大小（单位M）',
  `versioninfo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '版本说明',
  `isnew` int(0) NULL DEFAULT 9 COMMENT '是否最新版本 0 是 9 否',
  `appdownurl` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'app下载地址',
  `is_force` int(0) NULL DEFAULT 9 COMMENT '是否强制 0是 9否',
  `app_type` int(0) NULL DEFAULT NULL COMMENT '平台类型 1 安卓 2 IOS',
  `publishedtime` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`appid`) USING BTREE,
  INDEX `idx_d_n_t`(`is_delete`, `isnew`, `app_type`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'APP版本升级信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_appface
-- ----------------------------
DROP TABLE IF EXISTS `sys_appface`;
CREATE TABLE `sys_appface`  (
  `funbuttonid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '按钮id',
  `funbuttonkind` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '按钮类别  发现页上部功能组 funfxtop',
  `funbuttonname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '按钮名称',
  `funbuttonlog` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '按钮图标',
  `funbuttonlink` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '按钮点击跳转链接',
  `fbrefpara` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '相关参数',
  `browsnum` bigint(0) NULL DEFAULT NULL COMMENT '浏览量',
  `sortby` int(0) NULL DEFAULT NULL COMMENT '排序权重',
  `buttonnote` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注说明',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`funbuttonid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'APP界面图标按钮（预留）' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_bduserrole
-- ----------------------------
DROP TABLE IF EXISTS `sys_bduserrole`;
CREATE TABLE `sys_bduserrole`  (
  `refurid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '用户角色关系id',
  `sysroleid` bigint(0) NULL DEFAULT NULL COMMENT '角色id',
  `accno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '会员标识号',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`refurid`) USING BTREE,
  INDEX `fk_relationship_259`(`sysroleid`) USING BTREE,
  INDEX `fk_relationship_260`(`accno`, `is_delete`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '后台用户角色关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_bduserrole
-- ----------------------------
INSERT INTO `sys_bduserrole` VALUES (1, 1, '28883d4a8d584128a9443111ac0c93fe', b'0', '', '2023-01-04 23:40:36', '', '2023-01-04 23:41:01');

-- ----------------------------
-- Table structure for sys_busparameter
-- ----------------------------
DROP TABLE IF EXISTS `sys_busparameter`;
CREATE TABLE `sys_busparameter`  (
  `busparamid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '业务参数ID',
  `busparamcode` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '业务参数代码',
  `pbusparamcode` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '业务参数父代码',
  `busparamname` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '业务参数名称',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '参数说明',
  `status` decimal(1, 0) NULL DEFAULT 0 COMMENT '系统参数启用状态0启用9未启用',
  `sortby` int(0) NOT NULL DEFAULT 1 COMMENT '排序权重',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`busparamid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '业务参数' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_busparameter
-- ----------------------------
INSERT INTO `sys_busparameter` VALUES (1, 'h5_language', 'dianzai', 'zh', NULL, 0, 1, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-20 19:16:50', '28883d4a8d584128a9443111ac0c93fe', '2022-12-29 06:32:23');
INSERT INTO `sys_busparameter` VALUES (2, 'manage_title', 'dianzai', 'likes', NULL, 0, 1, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-20 19:17:59', '28883d4a8d584128a9443111ac0c93fe', '2022-12-29 06:32:22');
INSERT INTO `sys_busparameter` VALUES (3, 'admin_title', 'dianzai', '10', NULL, 0, 1, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-20 19:19:17', '28883d4a8d584128a9443111ac0c93fe', '2022-12-29 06:32:23');
INSERT INTO `sys_busparameter` VALUES (4, 'auto_audit', 'dianzai', '1', NULL, 0, 1, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-20 19:19:44', '28883d4a8d584128a9443111ac0c93fe', '2022-12-29 06:32:23');
INSERT INTO `sys_busparameter` VALUES (5, 'rebate1', 'dianzai', '0.00', NULL, 0, 1, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-20 19:20:03', '28883d4a8d584128a9443111ac0c93fe', '2022-12-29 06:32:23');
INSERT INTO `sys_busparameter` VALUES (6, 'rebate2', 'dianzai', '0.00', NULL, 0, 1, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-20 19:20:21', '28883d4a8d584128a9443111ac0c93fe', '2022-12-29 06:32:23');
INSERT INTO `sys_busparameter` VALUES (7, 'rebate3', 'dianzai', '0.00', NULL, 0, 1, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-20 19:20:24', '28883d4a8d584128a9443111ac0c93fe', '2022-12-29 06:32:22');
INSERT INTO `sys_busparameter` VALUES (8, 'f_min_w', 'dianzai', '3.00', NULL, 0, 1, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-20 19:20:36', '28883d4a8d584128a9443111ac0c93fe', '2022-12-29 06:32:23');
INSERT INTO `sys_busparameter` VALUES (9, 'is_b', 'dianzai', '1.00', NULL, 0, 1, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-20 19:20:45', '28883d4a8d584128a9443111ac0c93fe', '2022-12-29 06:32:23');
INSERT INTO `sys_busparameter` VALUES (10, 'commission', 'dianzai', '1.00', NULL, 0, 1, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-20 19:20:54', '28883d4a8d584128a9443111ac0c93fe', '2022-12-29 06:32:23');
INSERT INTO `sys_busparameter` VALUES (11, 'service_url', 'dianzai', 'https://t.me/+OpZ30yGp4qY0MjI9\n', NULL, 0, 1, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-20 19:21:02', '28883d4a8d584128a9443111ac0c93fe', '2022-12-29 06:32:23');
INSERT INTO `sys_busparameter` VALUES (12, 'idcode', 'dianzai', '123112', NULL, 0, 1, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-20 19:21:10', '28883d4a8d584128a9443111ac0c93fe', '2022-12-29 06:32:22');
INSERT INTO `sys_busparameter` VALUES (13, 'video_url', 'dianzai', '12312', NULL, 0, 1, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-20 19:21:17', '28883d4a8d584128a9443111ac0c93fe', '2022-12-29 06:32:22');
INSERT INTO `sys_busparameter` VALUES (14, 'day_w_num', 'dianzai', '1', NULL, 0, 1, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-20 19:21:26', '28883d4a8d584128a9443111ac0c93fe', '2022-12-29 06:32:23');
INSERT INTO `sys_busparameter` VALUES (15, 'f_max_w', 'dianzai', '', NULL, 0, 1, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-20 19:21:53', '28883d4a8d584128a9443111ac0c93fe', '2022-12-29 06:32:22');
INSERT INTO `sys_busparameter` VALUES (16, 'regment', 'dianzai', '0.00', NULL, 0, 1, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-20 19:21:55', '28883d4a8d584128a9443111ac0c93fe', '2022-12-29 06:32:22');
INSERT INTO `sys_busparameter` VALUES (17, 'day_w_num', 'dianzai', '1', NULL, 0, 1, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-20 19:37:40', '28883d4a8d584128a9443111ac0c93fe', '2022-12-29 06:32:23');
INSERT INTO `sys_busparameter` VALUES (18, 'manage_ip_white', 'dianzai', '1', NULL, 0, 1, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-20 19:40:20', '28883d4a8d584128a9443111ac0c93fe', '2022-12-29 06:32:22');
INSERT INTO `sys_busparameter` VALUES (19, 'w_audit_amout', 'dianzai', '2000', NULL, 0, 1, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-05-19 07:25:03', '28883d4a8d584128a9443111ac0c93fe', '2022-12-29 06:32:23');
INSERT INTO `sys_busparameter` VALUES (20, 'service_group_url', 'dianzai', 'https://t.me/+OpZ30yGp4qY0MjI9', NULL, 0, 1, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-06-08 03:43:44', '28883d4a8d584128a9443111ac0c93fe', '2022-12-29 06:32:23');
INSERT INTO `sys_busparameter` VALUES (21, 'android_url', 'dianzai', 'https://down.wegrty.com/Wealth.apk', NULL, 0, 1, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-12-28 02:29:01', '28883d4a8d584128a9443111ac0c93fe', '2022-12-29 06:32:23');
INSERT INTO `sys_busparameter` VALUES (22, 'ios_url', 'dianzai', 'https://98xdrd.com/xPe8.app', NULL, 0, 1, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-12-28 02:29:07', '28883d4a8d584128a9443111ac0c93fe', '2022-12-29 06:32:23');

-- ----------------------------
-- Table structure for sys_cdn
-- ----------------------------
DROP TABLE IF EXISTS `sys_cdn`;
CREATE TABLE `sys_cdn`  (
  `cdnid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'cdnid',
  `cdnstore` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'cdn商家 可以没有',
  `domain` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '域名名称',
  `secretkey` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '访问加密key',
  `domainkind` int(0) NULL DEFAULT NULL COMMENT '域名类型： 0：app域名 1：管理后台域名 2：web域名 3：下载域名 4：幽兰web域名 5幽兰管理后台域名 6：awsS3视频资源 7：awsS3图片资源  8：三分时时彩',
  `region` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '适用区域或国家 如：北方/南方/柬埔寨....',
  `cname` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'CDN CNAME',
  `note` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注说明',
  `status` decimal(1, 0) NULL DEFAULT NULL COMMENT '系统参数启用状态0启用9未启用',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`cdnid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'CDN分发配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_domain
-- ----------------------------
DROP TABLE IF EXISTS `sys_domain`;
CREATE TABLE `sys_domain`  (
  `id` int(0) NOT NULL,
  `domain_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `type` int(0) NULL DEFAULT NULL,
  `invitation_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `status` tinyint(1) NULL DEFAULT NULL,
  `is_delete` bit(1) NULL DEFAULT NULL,
  `create_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `update_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `update_time` timestamp(0) NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_errorlog
-- ----------------------------
DROP TABLE IF EXISTS `sys_errorlog`;
CREATE TABLE `sys_errorlog`  (
  `errlogid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `systemname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '系统代码：来源系统代码',
  `modelname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模块名称',
  `optcontent` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '日志内容',
  `optuser` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作用户',
  `optip` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作客户端ip',
  `level` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '日志等级DDINFO：     正常normal  系统错误error',
  `serverip` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '当前服务器ip',
  `serverstatus` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '当前服务器负载:cpu%,io%,网络带宽占用情况等',
  `orginfo` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '来源信息(md5)',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`errlogid`) USING BTREE,
  INDEX `idx1`(`systemname`, `modelname`, `serverstatus`, `create_time`) USING BTREE,
  INDEX `idx2`(`serverstatus`, `create_time`) USING BTREE,
  INDEX `idx3`(`systemname`, `modelname`, `optuser`, `level`, `serverstatus`, `create_time`) USING BTREE,
  INDEX `idx4`(`systemname`, `level`, `serverstatus`, `create_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '异常错误日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_feedback
-- ----------------------------
DROP TABLE IF EXISTS `sys_feedback`;
CREATE TABLE `sys_feedback`  (
  `feedid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '意见id',
  `feedtype` decimal(1, 0) NULL DEFAULT NULL COMMENT '意见类型 1普通 2财务',
  `accno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '会员标识号',
  `unique_id` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '会员ID',
  `feedbody` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '意见内容 10-200字描述',
  `feedimgs` varchar(4096) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '反馈图片 多张以“,”分隔',
  `status` decimal(1, 0) NULL DEFAULT NULL COMMENT '处理状态 0已处理 9未处理',
  `handlenote` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '处理结果说明',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`feedid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '意见反馈' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_funcinterface
-- ----------------------------
DROP TABLE IF EXISTS `sys_funcinterface`;
CREATE TABLE `sys_funcinterface`  (
  `itfcid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '接口id',
  `ofsystem` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '所属系统 likes-manage likes-app likes',
  `itfcname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '接口名称',
  `itfcurl` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '接口地址',
  `itfcdesc` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '接口说明',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`itfcid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '后台系统接口信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_functionorg
-- ----------------------------
DROP TABLE IF EXISTS `sys_functionorg`;
CREATE TABLE `sys_functionorg`  (
  `sfunid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '功能id',
  `parsfunid` bigint(0) NULL DEFAULT NULL COMMENT '父功能id',
  `ofsystem` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '所属系统  likes-manage运营管理后台',
  `sfuntype` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '功能类别  menu菜单   button按钮   tabTAB',
  `sfunname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '功能名称',
  `sfunstatus` decimal(1, 0) NULL DEFAULT NULL COMMENT '功能状态 0正常   9停用',
  `sfunurl` varchar(56) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '功能url或参数',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`sfunid`) USING BTREE,
  INDEX `fk_relationship_255`(`parsfunid`, `is_delete`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 284 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '后台系统(运营后台)功能' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_functionorg
-- ----------------------------
INSERT INTO `sys_functionorg` VALUES (1, NULL, 'live-manage', 'menu', '系统首页', 0, '/Home', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:12', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:12');
INSERT INTO `sys_functionorg` VALUES (2, NULL, 'live-manage', 'menu', '资源发布', 0, '/Resource', b'1', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:12', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:12');
INSERT INTO `sys_functionorg` VALUES (3, NULL, 'live-manage', 'menu', '直播管理', 0, '/Live', b'1', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:12', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 01:42:26');
INSERT INTO `sys_functionorg` VALUES (4, NULL, 'live-manage', 'menu', '广告管理', 0, '/Ad', b'1', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:12', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 01:42:16');
INSERT INTO `sys_functionorg` VALUES (5, NULL, 'live-manage', 'menu', '标签管理', 0, '/Title', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:12', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:12');
INSERT INTO `sys_functionorg` VALUES (6, NULL, 'live-manage', 'menu', '审核管理', 0, '/Review', b'1', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:13', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:13');
INSERT INTO `sys_functionorg` VALUES (7, NULL, 'live-manage', 'menu', '财务管理', 0, '/Finance', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:13', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:13');
INSERT INTO `sys_functionorg` VALUES (13, NULL, 'live-manage', 'menu', '会员管理', 0, '/User', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:13', 'a3e5bb5fa2fe429f9f2677efb8316bf6', '2023-01-05 00:22:35');
INSERT INTO `sys_functionorg` VALUES (14, NULL, 'live-manage', 'menu', '权限管理', 0, '/Auth', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:14', '065d4aed0b4a47bc9406d39ae182g3e6', '2023-01-05 00:22:31');
INSERT INTO `sys_functionorg` VALUES (15, NULL, 'live-manage', 'menu', '系统管理', 0, '/System', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:14', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:14');
INSERT INTO `sys_functionorg` VALUES (125, 13, 'live-manage', 'menu', '代理报表', 0, '/ProxyStats', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:26', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:26');
INSERT INTO `sys_functionorg` VALUES (126, 13, 'live-manage', 'menu', '代理设置', 0, '/ProxySettings', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:26', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:26');
INSERT INTO `sys_functionorg` VALUES (127, 122, 'live-manage', 'button', '普通用户禁用启用', 0, 'Status', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:27', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:27');
INSERT INTO `sys_functionorg` VALUES (128, 122, 'live-manage', 'button', '普通用户删除', 0, 'Delete', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:27', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:27');
INSERT INTO `sys_functionorg` VALUES (138, 125, 'live-manage', 'button', '代理报表查看下级', 0, 'Subordinate', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:28', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:28');
INSERT INTO `sys_functionorg` VALUES (139, 125, 'live-manage', 'button', '代理报表查看明细', 0, 'Detail', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:28', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:28');
INSERT INTO `sys_functionorg` VALUES (140, 126, 'live-manage', 'button', '代理设置新增', 0, 'Create', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:28', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:28');
INSERT INTO `sys_functionorg` VALUES (141, 126, 'live-manage', 'button', '代理设置编辑', 0, 'Update', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:28', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:28');
INSERT INTO `sys_functionorg` VALUES (142, 126, 'live-manage', 'button', '代理设置删除', 0, 'Delete', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:28', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:28');
INSERT INTO `sys_functionorg` VALUES (143, 14, 'live-manage', 'menu', '模块管理', 0, '/System-Modules', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:28', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:28');
INSERT INTO `sys_functionorg` VALUES (144, 14, 'live-manage', 'menu', '角色管理', 0, '/System-Roles', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:28', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:28');
INSERT INTO `sys_functionorg` VALUES (145, 14, 'live-manage', 'menu', '用户管理', 0, '/System-Users', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:29', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:29');
INSERT INTO `sys_functionorg` VALUES (146, 143, 'live-manage', 'button', '模块新增', 0, 'Create', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:29', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:29');
INSERT INTO `sys_functionorg` VALUES (147, 143, 'live-manage', 'button', '模块编辑', 0, 'Update', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:29', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:29');
INSERT INTO `sys_functionorg` VALUES (148, 143, 'live-manage', 'button', '模块删除', 0, 'Delete', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:29', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:29');
INSERT INTO `sys_functionorg` VALUES (149, 143, 'live-manage', 'button', '模块禁用启用', 0, 'Status', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:29', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:29');
INSERT INTO `sys_functionorg` VALUES (150, 144, 'live-manage', 'button', '角色新增', 0, 'Create', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:29', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:29');
INSERT INTO `sys_functionorg` VALUES (151, 144, 'live-manage', 'button', '角色编辑', 0, 'Update', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:29', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:29');
INSERT INTO `sys_functionorg` VALUES (152, 144, 'live-manage', 'button', '角色删除', 0, 'Delete', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:29', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:29');
INSERT INTO `sys_functionorg` VALUES (153, 144, 'live-manage', 'button', '管理用户', 0, 'Manage', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:30', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:30');
INSERT INTO `sys_functionorg` VALUES (154, 144, 'live-manage', 'button', '配置权限', 0, 'Setting', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:30', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:30');
INSERT INTO `sys_functionorg` VALUES (155, 145, 'live-manage', 'button', '系统用户新增', 0, 'Create', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:30', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:30');
INSERT INTO `sys_functionorg` VALUES (156, 145, 'live-manage', 'button', '系统用户编辑', 0, 'Update', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:30', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:30');
INSERT INTO `sys_functionorg` VALUES (157, 145, 'live-manage', 'button', '系统用户删除', 0, 'Delete', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:30', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:30');
INSERT INTO `sys_functionorg` VALUES (158, 145, 'live-manage', 'button', '系统用户禁用启用', 0, 'Status', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:30', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:30');
INSERT INTO `sys_functionorg` VALUES (159, 15, 'live-manage', 'menu', '版本管理', 0, '/System-Version', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:30', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:30');
INSERT INTO `sys_functionorg` VALUES (160, 15, 'live-manage', 'menu', '系统通知', 0, '/System-Notification', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:30', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:30');
INSERT INTO `sys_functionorg` VALUES (161, 15, 'live-manage', 'menu', '短信管理', 0, '/System-Sms', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:30', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:30');
INSERT INTO `sys_functionorg` VALUES (162, 15, 'live-manage', 'menu', '会员业务参数', 0, '/System-MemberBus', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:31', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:31');
INSERT INTO `sys_functionorg` VALUES (163, 15, 'live-manage', 'menu', '会员系统参数', 0, '/System-MemberParmas', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:31', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:31');
INSERT INTO `sys_functionorg` VALUES (164, 15, 'live-manage', 'menu', '意见反馈', 0, '/System-Feeds', b'1', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:31', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 01:43:52');
INSERT INTO `sys_functionorg` VALUES (165, 15, 'live-manage', 'menu', '系统错误日志', 0, '/System-ErrorsLog', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:31', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:31');
INSERT INTO `sys_functionorg` VALUES (166, 15, 'live-manage', 'menu', '系统日志', 0, '/System-Logs', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:31', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:31');
INSERT INTO `sys_functionorg` VALUES (167, 15, 'live-manage', 'menu', 'CDN管理', 0, '/System-CDN', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:31', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:31');
INSERT INTO `sys_functionorg` VALUES (168, 15, 'live-manage', 'menu', '白名单', 0, '/System-IPManage', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:31', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:31');
INSERT INTO `sys_functionorg` VALUES (169, 15, 'live-manage', 'menu', '直播服务器管理', 0, '/System-LiveServer', b'1', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:31', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 01:43:58');
INSERT INTO `sys_functionorg` VALUES (170, 15, 'live-manage', 'menu', '公告管理', 0, '/System-Notice', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:31', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:31');
INSERT INTO `sys_functionorg` VALUES (171, 15, 'live-manage', 'menu', '缓存管理', 0, '/System-Cache', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:32', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:32');
INSERT INTO `sys_functionorg` VALUES (172, 159, 'live-manage', 'button', '发布新版本', 0, 'Create', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:32', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:32');
INSERT INTO `sys_functionorg` VALUES (173, 159, 'live-manage', 'button', '版本编辑', 0, 'Update', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:32', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:32');
INSERT INTO `sys_functionorg` VALUES (174, 160, 'live-manage', 'button', '发送通知', 0, 'Create', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:32', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:32');
INSERT INTO `sys_functionorg` VALUES (175, 160, 'live-manage', 'button', '通知删除', 0, 'Delete', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:32', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:32');
INSERT INTO `sys_functionorg` VALUES (176, 162, 'live-manage', 'button', '业务参数保存', 0, 'Create', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:32', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:32');
INSERT INTO `sys_functionorg` VALUES (177, 162, 'live-manage', 'button', '业务参数编辑', 0, 'Update', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:32', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:32');
INSERT INTO `sys_functionorg` VALUES (178, 162, 'live-manage', 'button', '业务参数删除', 0, 'Delete', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:32', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:32');
INSERT INTO `sys_functionorg` VALUES (179, 162, 'live-manage', 'button', '业务参数禁用启用', 0, 'Status', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:32', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:32');
INSERT INTO `sys_functionorg` VALUES (180, 163, 'live-manage', 'button', '系统参数保存', 0, 'Create', b'1', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:33', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:33');
INSERT INTO `sys_functionorg` VALUES (181, 163, 'live-manage', 'button', '会员系统参数编辑', 0, 'Update', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:33', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:33');
INSERT INTO `sys_functionorg` VALUES (182, 163, 'live-manage', 'button', '系统参数删除', 0, 'Delete', b'1', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:33', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:33');
INSERT INTO `sys_functionorg` VALUES (186, 167, 'live-manage', 'button', 'CDN保存', 0, 'Create', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:33', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:33');
INSERT INTO `sys_functionorg` VALUES (187, 167, 'live-manage', 'button', 'CDN编辑', 0, 'Update', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:33', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:33');
INSERT INTO `sys_functionorg` VALUES (188, 167, 'live-manage', 'button', 'CDN删除', 0, 'Delete', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:33', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:33');
INSERT INTO `sys_functionorg` VALUES (189, 167, 'live-manage', 'button', 'CDN禁用启用', 0, 'Status', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:34', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:34');
INSERT INTO `sys_functionorg` VALUES (190, 167, 'live-manage', 'button', '刷新CDN', 0, 'Refresh', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:34', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:34');
INSERT INTO `sys_functionorg` VALUES (191, 168, 'live-manage', 'button', '白名单保存', 0, 'Create', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:34', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:34');
INSERT INTO `sys_functionorg` VALUES (192, 168, 'live-manage', 'button', '白名单编辑', 0, 'Update', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:34', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:34');
INSERT INTO `sys_functionorg` VALUES (193, 168, 'live-manage', 'button', '白名单删除', 0, 'Delete', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:34', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:34');
INSERT INTO `sys_functionorg` VALUES (199, 170, 'live-manage', 'button', '公告新增', 0, 'Create', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:35', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:35');
INSERT INTO `sys_functionorg` VALUES (200, 170, 'live-manage', 'button', '公告编辑', 0, 'Update', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:35', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:35');
INSERT INTO `sys_functionorg` VALUES (201, 170, 'live-manage', 'button', '公告删除', 0, 'Delete', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:35', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:35');
INSERT INTO `sys_functionorg` VALUES (202, NULL, 'live-manage', 'menu', '统计', 0, '/Statistic', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:35', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:35');
INSERT INTO `sys_functionorg` VALUES (203, 202, 'live-manage', 'menu', '账变记录', 0, '/Record-Stat', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:35', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:35');
INSERT INTO `sys_functionorg` VALUES (204, 202, 'live-manage', 'menu', '出入账目汇总', 0, '/Acount-Total', b'1', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:35', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 01:44:13');
INSERT INTO `sys_functionorg` VALUES (205, 202, 'live-manage', 'menu', '报表统计', 0, '/Report-Stat', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:35', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:35');
INSERT INTO `sys_functionorg` VALUES (206, 13, 'live-manage', 'menu', ' 返水管理', 0, '/Back-Water', b'1', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:35', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 01:43:35');
INSERT INTO `sys_functionorg` VALUES (207, 13, 'live-manage', 'menu', '会员等级', 0, '/User-Level', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:36', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:36');
INSERT INTO `sys_functionorg` VALUES (210, 207, 'live-manage', 'button', '会员等级创建', 0, 'Create', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:36', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:36');
INSERT INTO `sys_functionorg` VALUES (211, 207, 'live-manage', 'button', '会员等级编辑', 0, 'Update', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:36', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:36');
INSERT INTO `sys_functionorg` VALUES (212, 207, 'live-manage', 'button', '会员等级删除', 0, 'Delete', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:36', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:36');
INSERT INTO `sys_functionorg` VALUES (213, 7, 'live-manage', 'menu', '会员加款/扣款', 0, '/Member-Deduct', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:36', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:36');
INSERT INTO `sys_functionorg` VALUES (214, 7, 'live-manage', 'menu', '会员加减可提', 0, '/Member-Withdraw', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:36', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:36');
INSERT INTO `sys_functionorg` VALUES (215, 213, 'live-manage', 'button', '加款', 0, 'Create', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:36', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:36');
INSERT INTO `sys_functionorg` VALUES (216, 213, 'live-manage', 'button', '扣款', 0, 'Update', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:37', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:37');
INSERT INTO `sys_functionorg` VALUES (217, 213, 'live-manage', 'button', '批量加款', 0, 'BatchCreate', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:37', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:37');
INSERT INTO `sys_functionorg` VALUES (218, 213, 'live-manage', 'button', '批量扣款', 0, 'BatchUpdate', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:37', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:37');
INSERT INTO `sys_functionorg` VALUES (219, 214, 'live-manage', 'button', '加码', 0, 'Create', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:37', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:37');
INSERT INTO `sys_functionorg` VALUES (220, 214, 'live-manage', 'button', '减码', 0, 'Update', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:37', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:37');
INSERT INTO `sys_functionorg` VALUES (221, 214, 'live-manage', 'button', '批量加码', 0, 'BatchCreate', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:37', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:37');
INSERT INTO `sys_functionorg` VALUES (222, 214, 'live-manage', 'button', '批量减码', 0, 'BatchUpdate', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:37', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:37');
INSERT INTO `sys_functionorg` VALUES (223, 15, 'live-manage', 'menu', '系统维护', 0, '/System-Maintenance', b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:37', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:37');
INSERT INTO `sys_functionorg` VALUES (224, 202, 'happyrun', 'menu', '资金报表', 0, '/Fund-Statement', b'0', 'c9b2ea2a8f94476684f39b31203d44bd', '2020-09-13 14:32:38', 'c9b2ea2a8f94476684f39b31203d44bd', '2020-09-13 14:32:38');
INSERT INTO `sys_functionorg` VALUES (225, 13, 'happyrun', 'menu', '会员状态管理', 0, '/MemberStatus', b'0', 'c9b2ea2a8f94476684f39b31203d44bd', '2020-09-13 14:32:38', 'c9b2ea2a8f94476684f39b31203d44bd', '2020-09-13 14:32:38');
INSERT INTO `sys_functionorg` VALUES (226, 225, 'happyrun', 'button', '解除', 0, 'Clear', b'0', 'c9b2ea2a8f94476684f39b31203d44bd', '2020-09-13 14:32:38', 'c9b2ea2a8f94476684f39b31203d44bd', '2020-09-13 14:32:38');
INSERT INTO `sys_functionorg` VALUES (238, 237, 'happyrun', 'button', '打款', 0, 'BatchCreate', b'0', 'c9b2ea2a8f94476684f39b31203d44bd', '2020-09-13 14:32:39', 'c9b2ea2a8f94476684f39b31203d44bd', '2020-09-13 14:32:39');
INSERT INTO `sys_functionorg` VALUES (239, 237, 'happyrun', 'button', '确认', 0, 'Subordinate', b'0', 'c9b2ea2a8f94476684f39b31203d44bd', '2020-09-13 14:32:39', 'c9b2ea2a8f94476684f39b31203d44bd', '2020-09-13 14:32:39');
INSERT INTO `sys_functionorg` VALUES (240, 122, 'happyrun', 'button', '手机号权限', 0, 'Manage', b'0', 'c9b2ea2a8f94476684f39b31203d44bd', '2020-09-13 14:32:39', 'c9b2ea2a8f94476684f39b31203d44bd', '2020-09-13 14:32:39');
INSERT INTO `sys_functionorg` VALUES (241, 122, 'happyrun', 'button', '查看备注', 0, 'Detail', b'0', 'c9b2ea2a8f94476684f39b31203d44bd', '2020-09-13 14:32:40', 'c9b2ea2a8f94476684f39b31203d44bd', '2020-09-13 14:32:40');
INSERT INTO `sys_functionorg` VALUES (242, 122, 'happyrun', 'button', '普通用户编辑', 0, 'Update', b'0', 'c9b2ea2a8f94476684f39b31203d44bd', '2020-09-13 14:32:40', 'c9b2ea2a8f94476684f39b31203d44bd', '2020-09-13 14:32:40');
INSERT INTO `sys_functionorg` VALUES (243, 125, 'happyrun', 'button', '编辑渠道链接', 0, 'Update', b'0', 'c9b2ea2a8f94476684f39b31203d44bd', '2020-09-13 14:32:40', 'c9b2ea2a8f94476684f39b31203d44bd', '2020-09-13 14:32:40');
INSERT INTO `sys_functionorg` VALUES (244, 125, 'happyrun', 'button', '查看全部代理', 0, 'Create', b'0', 'c9b2ea2a8f94476684f39b31203d44bd', '2020-09-13 14:32:40', 'c9b2ea2a8f94476684f39b31203d44bd', '2020-09-13 14:32:40');
INSERT INTO `sys_functionorg` VALUES (246, 224, 'happyrun', 'button', '资金报表导出', 0, 'Manage', b'0', 'c9b2ea2a8f94476684f39b31203d44bd', '2020-09-13 14:32:40', 'c9b2ea2a8f94476684f39b31203d44bd', '2020-09-13 14:32:40');
INSERT INTO `sys_functionorg` VALUES (259, 202, 'happyrun', 'menu', '入款报表', 0, '/Payment-Report', b'0', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:42', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:42');
INSERT INTO `sys_functionorg` VALUES (260, 259, 'happyrun', 'button', '入款报表查看', 0, 'Detail', b'0', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:42', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:42');
INSERT INTO `sys_functionorg` VALUES (261, 259, 'happyrun', 'menu', '会员报表', 0, '/Member-Report', b'1', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:42', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:42');
INSERT INTO `sys_functionorg` VALUES (262, 202, 'happyrun', 'menu', '会员报表', 0, '/Member-Report', b'0', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:42', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:42');
INSERT INTO `sys_functionorg` VALUES (263, 262, 'happyrun', 'button', '明细', 0, 'Detail', b'0', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:42', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:42');
INSERT INTO `sys_functionorg` VALUES (264, 7, 'happyrun', 'menu', '代充入款订单', 0, '/Finance-Surrogate', b'1', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:42', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 01:42:47');
INSERT INTO `sys_functionorg` VALUES (265, 7, 'happyrun', 'menu', '代充银行卡', 0, '/Surrogate-Bank-Card', b'1', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:42', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 01:42:53');
INSERT INTO `sys_functionorg` VALUES (266, 265, 'happyrun', 'button', '代充银行卡删除', 0, 'Delete', b'0', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:42', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:42');
INSERT INTO `sys_functionorg` VALUES (267, 265, 'happyrun', 'button', '代充银行卡启用禁用', 0, 'Status', b'0', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:42', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:42');
INSERT INTO `sys_functionorg` VALUES (268, 265, 'happyrun', 'button', '编辑', 0, 'Update', b'0', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:43', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:43');
INSERT INTO `sys_functionorg` VALUES (269, 265, 'happyrun', 'button', '创建', 0, 'Create', b'0', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:43', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:43');
INSERT INTO `sys_functionorg` VALUES (270, 7, 'happyrun', 'menu', '代充人入款', 0, '/Surrogate-Person', b'1', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:43', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 01:43:01');
INSERT INTO `sys_functionorg` VALUES (271, 270, 'happyrun', 'button', '代充人入款查看', 0, 'Detail', b'0', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:43', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:43');
INSERT INTO `sys_functionorg` VALUES (272, 270, 'happyrun', 'button', '代充人入款处理', 0, 'Apply', b'0', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:43', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:43');
INSERT INTO `sys_functionorg` VALUES (273, 7, 'happyrun', 'menu', '代充人管理', 0, '/Surrogate-Management', b'1', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:43', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 01:43:19');
INSERT INTO `sys_functionorg` VALUES (274, 273, 'happyrun', 'button', '代充人管理启用禁用', 0, 'Status', b'0', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:43', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:43');
INSERT INTO `sys_functionorg` VALUES (275, 273, 'happyrun', 'button', '代充人管理编辑', 0, 'Update', b'0', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:43', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:43');
INSERT INTO `sys_functionorg` VALUES (276, 273, 'happyrun', 'button', '代充人管理创建', 0, 'Create', b'0', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:43', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:43');
INSERT INTO `sys_functionorg` VALUES (277, 7, 'happyrun', 'menu', '代充存提', 0, '/Surrogate-Save', b'1', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:44', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 01:43:27');
INSERT INTO `sys_functionorg` VALUES (278, 277, 'happyrun', 'button', '代充存提提出', 0, 'Lottery', b'0', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:44', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:44');
INSERT INTO `sys_functionorg` VALUES (279, 277, 'happyrun', 'button', '代充存提存入', 0, 'Refresh', b'0', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:44', 'a60534baa8e9496abf9554af3ffb1ac7', '2020-09-13 14:32:44');

-- ----------------------------
-- Table structure for sys_functionorgs
-- ----------------------------
DROP TABLE IF EXISTS `sys_functionorgs`;
CREATE TABLE `sys_functionorgs`  (
  `sfunid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '功能id',
  `parsfunid` bigint(0) NULL DEFAULT NULL COMMENT '父功能id',
  `ofsystem` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '所属系统  live-manage运营管理后台',
  `sfuntype` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '功能类别  menu菜单   button按钮   tabTAB',
  `sfunname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '功能名称',
  `sfunstatus` decimal(1, 0) NULL DEFAULT NULL COMMENT '功能状态 0正常   9停用',
  `sfunurl` varchar(56) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '功能url或参数',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`sfunid`) USING BTREE,
  INDEX `fk_relationship_255`(`parsfunid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '后台系统(运营后台)功能' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_infolog
-- ----------------------------
DROP TABLE IF EXISTS `sys_infolog`;
CREATE TABLE `sys_infolog`  (
  `logid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `accno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作用户',
  `systemname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '系统代码：来源系统代码',
  `modelname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模块名称',
  `optcontent` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '日志内容',
  `optip` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作客户端ip',
  `serverip` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '当前服务器ip',
  `longitude` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '经度',
  `latitude` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '纬度',
  `orginfo` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '来源信息',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`logid`) USING BTREE,
  INDEX `idx1`(`systemname`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2366115 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '登录信息日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_infolog
-- ----------------------------
INSERT INTO `sys_infolog` VALUES (2366115, '28883d4a8d584128a9443111ac0c93fe', 'live-manage', '后台用户登录', '【supermanage】登录', '117.20.115.151', '10.6.225.5', NULL, NULL, 'login', '2023-01-05 01:20:49');

-- ----------------------------
-- Table structure for sys_likesserver
-- ----------------------------
DROP TABLE IF EXISTS `sys_likesserver`;
CREATE TABLE `sys_likesserver`  (
  `likesid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '直播服务器id',
  `servername` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '服务器名称',
  `serverurl` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '服务器地址',
  `weight` int(0) NOT NULL COMMENT '服务器权重',
  `region` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '服务器所在区域名称\r\n\r\n南方：江苏 安徽 湖北 重庆 四川 西藏 云南 贵州 湖南 江西 广西 广东 福建 浙江 上海 海南（台港澳）\r\n\r\n北方：山东 河南 山西 陕西 甘肃 青海 新疆 河北 天津 北京 内蒙古 辽宁 吉林 黑龙江 宁夏。',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`likesid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '直播服务器节点表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_liveserver
-- ----------------------------
DROP TABLE IF EXISTS `sys_liveserver`;
CREATE TABLE `sys_liveserver`  (
  `liveid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '直播服务器id',
  `servername` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '服务器名称',
  `serverurl` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '服务器地址',
  `weight` int(0) NOT NULL COMMENT '服務器權重',
  `region` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '服務器所在區域名稱\r\n\r\n南方：江苏 安徽 湖北 重庆 四川 西藏 云南 贵州 湖南 江西 广西 广东 福建 浙江 上海 海南（台港澳）\r\n\r\n北方：山东 河南 山西 陕西 甘肃 青海 新疆 河北 天津 北京 内蒙古 辽宁 吉林 黑龙江 宁夏。',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`liveid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '直播服务器节点表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_operdatalog
-- ----------------------------
DROP TABLE IF EXISTS `sys_operdatalog`;
CREATE TABLE `sys_operdatalog`  (
  `oplogid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `accno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作用户',
  `dbname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '数据库名称',
  `modulename` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模块名称',
  `refcollname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '表或集合名称',
  `optcontent` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '日志内容',
  `beforedata` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '操作前数据',
  `lastdate` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '操作后数据',
  `operstatus` decimal(1, 0) NULL DEFAULT NULL COMMENT '操作状态0成功 9失败',
  `operdate` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oplogid`) USING BTREE,
  INDEX `idx1`(`accno`, `operstatus`, `operdate`) USING BTREE,
  INDEX `idx2`(`modulename`, `operstatus`, `operdate`) USING BTREE,
  INDEX `idx3`(`operstatus`, `operdate`) USING BTREE,
  INDEX `idx4`(`operdate`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '重要数据操作日志：\r\n重要数据定义：修改金币数量，取消订单、' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_operlog
-- ----------------------------
DROP TABLE IF EXISTS `sys_operlog`;
CREATE TABLE `sys_operlog`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `acclogin` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `accno` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `operation_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `method` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `params` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL,
  `ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_parameter
-- ----------------------------
DROP TABLE IF EXISTS `sys_parameter`;
CREATE TABLE `sys_parameter`  (
  `sysparamid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '系统参数id',
  `sysparamcode` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '系统参数代码',
  `sysparamname` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '系统参数名称',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '参数说明',
  `sysparamvalue` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '系统参数值',
  `sortby` int(0) NOT NULL DEFAULT 1 COMMENT '排序值,值越小越靠前',
  `status` decimal(1, 0) NULL DEFAULT NULL COMMENT '系统参数启用状态0启用9未启用',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`sysparamid`) USING BTREE,
  INDEX `FK_sysparam_1`(`sysparamcode`, `is_delete`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 140 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统参数' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_parameter
-- ----------------------------
INSERT INTO `sys_parameter` VALUES (140, 'SESSION_TIME', 'App的token有效期', '单位分钟', '7200', 1, 0, b'0', NULL, '2020-09-13 14:32:44', NULL, '2020-09-13 14:32:44');
INSERT INTO `sys_parameter` VALUES (141, 'SHORTMSG_LIMIT', '同IP同手机号短信发送限制条数', '单位条数', '10', 1, 0, b'0', NULL, '2020-09-13 14:32:45', NULL, '2020-09-13 14:32:45');
INSERT INTO `sys_parameter` VALUES (142, 'SESSION_TIME_BACK', '后台token有效期', '单位分钟', '120', 1, 0, b'0', NULL, '2020-09-13 14:32:46', NULL, '2020-09-13 14:32:46');
INSERT INTO `sys_parameter` VALUES (143, 'MANAGE_ISIP', '后台是否启用白名单', '后台是否启用白名单(0,否；1是)', '1', 1, 0, b'0', NULL, '2020-09-13 14:32:47', NULL, '2020-09-13 14:32:47');
INSERT INTO `sys_parameter` VALUES (144, 'rebate1', 'rebate1', '一级下属任务佣金比例', '3', 1, 0, b'0', '', '2022-04-18 23:41:03', '28883d4a8d584128a9443111ac0c93fe', '2022-04-19 04:21:57');
INSERT INTO `sys_parameter` VALUES (145, 'rebate2', 'rebate2', '二级下属任务佣金比例', '2', 1, 0, b'0', '', '2022-04-18 23:41:26', '28883d4a8d584128a9443111ac0c93fe', '2022-04-19 04:21:56');
INSERT INTO `sys_parameter` VALUES (146, 'rebate3', 'rebate3', '三级下属任务佣金比例', '1', 1, 0, b'0', '', '2022-04-18 23:42:08', '28883d4a8d584128a9443111ac0c93fe', '2022-04-18 23:43:38');
INSERT INTO `sys_parameter` VALUES (147, 'vip1_rebate', 'vip1_rebate', 'vip1_rebate', '10', 1, 0, b'0', '', '2022-04-19 00:16:16', '', '2022-04-19 00:18:07');
INSERT INTO `sys_parameter` VALUES (148, 'vip2_rebate', 'vip2_rebate', 'vip2_rebate', '5', 1, 0, b'0', '', '2022-04-19 00:16:46', '', '2022-04-19 00:18:09');
INSERT INTO `sys_parameter` VALUES (149, 'vip3_rebate', 'vip3_rebate', 'vip3_rebate', '3', 1, 0, b'0', '', '2022-04-19 00:17:23', '28883d4a8d584128a9443111ac0c93fe', '2022-04-19 00:18:10');
INSERT INTO `sys_parameter` VALUES (150, 'SAME_IP_REGISTER_NUM', 'SAME_IP_REGISTER_NUM', '相同ip 注册次数', '1111', 1, 0, b'0', '', '2022-05-02 23:37:29', 'a3e5bb5fa2fe429f9f2677efb8316bf6', '2022-05-02 23:38:18');
INSERT INTO `sys_parameter` VALUES (151, 'SAME_DEVICE_REGISTER_NUM', 'SAME_DEVICE_REGISTER_NUM', '相同设备号注册次数', '1111', 1, 0, b'0', '', '2022-05-02 23:37:46', 'a3e5bb5fa2fe429f9f2677efb8316bf6', '2022-05-02 23:38:20');
INSERT INTO `sys_parameter` VALUES (152, 'VIP_OPEN', 'VIP_OPEN', 'VIP_OPEN', '2022-05-24 18:00:00', 1, 0, b'0', '', '2022-05-24 03:48:27', 'a3e5bb5fa2fe429f9f2677efb8316bf6', '2022-05-24 03:48:31');
INSERT INTO `sys_parameter` VALUES (153, 'TARGET_TABLE', 'TARGET_TABLE', '分库逻辑表名', '1', 1, 0, b'0', '', '2022-06-09 05:07:56', 'a3e5bb5fa2fe429f9f2677efb8316bf6', '2022-06-09 05:08:02');
INSERT INTO `sys_parameter` VALUES (154, 'REGISTER_GIVE_AMOUNT', 'REGISTER_GIVE_AMOUNT', '注册赠送金额', '10000', 1, 0, b'0', '', '2022-12-29 13:30:41', 'a3e5bb5fa2fe429f9f2677efb8316bf6', '2022-12-29 13:30:58');

-- ----------------------------
-- Table structure for sys_payaccount
-- ----------------------------
DROP TABLE IF EXISTS `sys_payaccount`;
CREATE TABLE `sys_payaccount`  (
  `bankid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '银行账户id',
  `accounttype` decimal(1, 0) NULL DEFAULT NULL COMMENT '账号类型  1支付宝 2微信   3银联',
  `accountno` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '银行卡/支付宝/微信账号',
  `accountname` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '银行/支付宝/微信开户人姓名',
  `bankname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '银行名称标识符 如ICBC',
  `bankaddress` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '开户行 如 某某支行',
  `nickname` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '微信、支付宝暱称',
  `minamt` decimal(16, 3) NULL DEFAULT NULL COMMENT '单笔最低金额',
  `maxamt` decimal(16, 3) NULL DEFAULT NULL COMMENT '单笔入账最高金额',
  `minmemlevel` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '启用会员最低等级',
  `maxmemlevel` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '启用会员最高等级',
  `stopamt` decimal(16, 3) NULL DEFAULT NULL COMMENT '停用此卡上限金额',
  `easyrecharge` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '快捷充值套餐金额, 多条以\",\"分隔',
  `isinput` decimal(1, 0) NULL DEFAULT NULL COMMENT '是否允许输入金额  0允许 9禁止 ',
  `status` decimal(1, 0) NOT NULL COMMENT '启用状态: 0启用 9停用',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `sys_status` bit(1) NULL DEFAULT b'1' COMMENT '系统启用禁用',
  `total_amount` decimal(16, 2) NULL DEFAULT 0.00 COMMENT '累计充值金额',
  PRIMARY KEY (`bankid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '入款账户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_payprovider
-- ----------------------------
DROP TABLE IF EXISTS `sys_payprovider`;
CREATE TABLE `sys_payprovider`  (
  `providerid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '支付商id',
  `provider` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '支付商名称',
  `providercode` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商户code',
  `paydns` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付域名',
  `backurl` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '返回地址',
  `allowips` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '回调白名单  多个ip以逗号分隔',
  `torderurl` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '三方支付订单查询地址',
  `paygateway` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付网关',
  `accountno` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商户ID  多个以英文逗号分隔',
  `secretcode` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商户秘钥',
  `pubsecret` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商户公钥',
  `prisecret` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商户私钥',
  `serversecret` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '伺服器公钥',
  `status` decimal(1, 0) NOT NULL COMMENT '启用状态: 0启用 9停用',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`providerid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '支付商设置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_payset
-- ----------------------------
DROP TABLE IF EXISTS `sys_payset`;
CREATE TABLE `sys_payset`  (
  `paysetid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '支付设定id',
  `setname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '设置名称',
  `settype` decimal(1, 0) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '设定类型 1线上入款设定(微信/支付宝)  2公司入款设定',
  `rechargetype` decimal(1, 0) NULL DEFAULT NULL COMMENT '入款优惠频率 1首次充值优惠 2每次充值优惠',
  `giftrate` decimal(3, 2) NULL DEFAULT NULL COMMENT '额外赠送率     %',
  `maxgift` decimal(16, 3) NULL DEFAULT NULL COMMENT '优惠上限金额',
  `auditper` decimal(3, 2) NULL DEFAULT NULL COMMENT '常态性稽核（百分比）',
  `auditfree` decimal(16, 3) NOT NULL COMMENT '常态性稽核放宽额度（元）',
  `administrative` decimal(3, 2) NULL DEFAULT NULL COMMENT '常态性稽核行政费率（百分值）',
  `freechargenums` int(0) NULL DEFAULT NULL COMMENT '单日出款免手续费次数',
  `servicecharge` decimal(16, 3) NOT NULL COMMENT '单笔出款手续费（元） 0为不要手续费',
  `maxchargeamt` decimal(16, 3) NULL DEFAULT NULL COMMENT '单笔出款上限金额',
  `minchargeamt` decimal(16, 3) NULL DEFAULT NULL COMMENT '单笔出款下限金额',
  `status` decimal(1, 0) NOT NULL COMMENT '系统参数启用状态0启用9未启用',
  `sortby` int(11) UNSIGNED ZEROFILL NOT NULL COMMENT '排序权重',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`paysetid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '支付设定(提现)' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_record
-- ----------------------------
DROP TABLE IF EXISTS `sys_record`;
CREATE TABLE `sys_record`  (
  `recordid` int(0) NOT NULL AUTO_INCREMENT,
  `operationer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `operationdate` timestamp(0) NULL DEFAULT NULL,
  `recordevent` int(0) NULL DEFAULT NULL,
  `recordremark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`recordid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_reffuncinitfc
-- ----------------------------
DROP TABLE IF EXISTS `sys_reffuncinitfc`;
CREATE TABLE `sys_reffuncinitfc`  (
  `itfcid` bigint(0) NOT NULL COMMENT '接口id',
  `sfunid` bigint(0) NOT NULL COMMENT '功能id',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`itfcid`, `sfunid`) USING BTREE,
  INDEX `fk_relationship_257`(`sfunid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '功能接口关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_repayaccount
-- ----------------------------
DROP TABLE IF EXISTS `sys_repayaccount`;
CREATE TABLE `sys_repayaccount`  (
  `bankid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '银行账户id',
  `nickname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '帐号名称',
  `bankname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '银行名称标识符 如ICBC',
  `accountno` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '银行卡账号',
  `bankaddress` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '开户行 如 某某支行',
  `accountname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '收款人姓名',
  `minamt` decimal(16, 3) NULL DEFAULT NULL COMMENT '单笔最低金额',
  `maxamt` decimal(16, 3) NULL DEFAULT NULL COMMENT '单笔入账最高金额',
  `stopamt` decimal(16, 3) NULL DEFAULT NULL COMMENT '停用次卡上限金额',
  `status` decimal(1, 0) NULL DEFAULT NULL COMMENT '启用状态: 0启用 9停用',
  `is_delete` bit(1) NULL DEFAULT b'0' COMMENT '删除标志 0或空未删除 9已删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '最后修改人',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`bankid`) USING BTREE,
  INDEX `sys_repayaccount_union1`(`minamt`, `maxamt`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '代充银行卡表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_rolefunc
-- ----------------------------
DROP TABLE IF EXISTS `sys_rolefunc`;
CREATE TABLE `sys_rolefunc`  (
  `rolefuncid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '角色功能id',
  `sysroleid` bigint(0) NOT NULL COMMENT '角色id',
  `sfunid` bigint(0) NOT NULL COMMENT '功能id',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`rolefuncid`, `sysroleid`, `sfunid`) USING BTREE,
  INDEX `fk_relationship_260`(`sysroleid`) USING BTREE,
  INDEX `fk_relationship_261`(`sfunid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 349 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色拥有功能' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_rolefunc
-- ----------------------------
INSERT INTO `sys_rolefunc` VALUES (1, 1, 1, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:48', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:48');
INSERT INTO `sys_rolefunc` VALUES (2, 1, 2, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:48', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:48');
INSERT INTO `sys_rolefunc` VALUES (3, 1, 3, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:48', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:48');
INSERT INTO `sys_rolefunc` VALUES (4, 1, 4, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:48', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:48');
INSERT INTO `sys_rolefunc` VALUES (5, 1, 5, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:49', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:49');
INSERT INTO `sys_rolefunc` VALUES (6, 1, 6, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:49', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:49');
INSERT INTO `sys_rolefunc` VALUES (7, 1, 7, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:49', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:49');
INSERT INTO `sys_rolefunc` VALUES (8, 1, 8, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:49', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:49');
INSERT INTO `sys_rolefunc` VALUES (9, 1, 9, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:49', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:49');
INSERT INTO `sys_rolefunc` VALUES (10, 1, 10, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:49', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:49');
INSERT INTO `sys_rolefunc` VALUES (11, 1, 11, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:49', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:49');
INSERT INTO `sys_rolefunc` VALUES (12, 1, 12, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:49', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:49');
INSERT INTO `sys_rolefunc` VALUES (13, 1, 13, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:50', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:50');
INSERT INTO `sys_rolefunc` VALUES (14, 1, 14, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:50', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:50');
INSERT INTO `sys_rolefunc` VALUES (15, 1, 15, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:50', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:50');
INSERT INTO `sys_rolefunc` VALUES (16, 1, 16, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:50', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:50');
INSERT INTO `sys_rolefunc` VALUES (17, 1, 17, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:50', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:50');
INSERT INTO `sys_rolefunc` VALUES (18, 1, 21, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:50', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:50');
INSERT INTO `sys_rolefunc` VALUES (19, 1, 22, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:50', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:50');
INSERT INTO `sys_rolefunc` VALUES (20, 1, 23, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:50', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:50');
INSERT INTO `sys_rolefunc` VALUES (21, 1, 32, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:50', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:50');
INSERT INTO `sys_rolefunc` VALUES (22, 1, 33, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:51', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:51');
INSERT INTO `sys_rolefunc` VALUES (23, 1, 41, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:51', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:51');
INSERT INTO `sys_rolefunc` VALUES (24, 1, 42, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:51', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:51');
INSERT INTO `sys_rolefunc` VALUES (25, 1, 49, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:51', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:51');
INSERT INTO `sys_rolefunc` VALUES (26, 1, 50, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:51', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:51');
INSERT INTO `sys_rolefunc` VALUES (27, 1, 53, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:51', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:51');
INSERT INTO `sys_rolefunc` VALUES (28, 1, 54, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:51', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:51');
INSERT INTO `sys_rolefunc` VALUES (29, 1, 55, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:51', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:51');
INSERT INTO `sys_rolefunc` VALUES (30, 1, 56, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:51', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:51');
INSERT INTO `sys_rolefunc` VALUES (31, 1, 57, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:51', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:51');
INSERT INTO `sys_rolefunc` VALUES (32, 1, 58, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:52', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:52');
INSERT INTO `sys_rolefunc` VALUES (33, 1, 59, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:52', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:52');
INSERT INTO `sys_rolefunc` VALUES (34, 1, 60, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:52', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:52');
INSERT INTO `sys_rolefunc` VALUES (35, 1, 88, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:52', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:52');
INSERT INTO `sys_rolefunc` VALUES (36, 1, 89, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:52', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:52');
INSERT INTO `sys_rolefunc` VALUES (37, 1, 90, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:52', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:52');
INSERT INTO `sys_rolefunc` VALUES (38, 1, 91, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:52', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:52');
INSERT INTO `sys_rolefunc` VALUES (39, 1, 104, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:52', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:52');
INSERT INTO `sys_rolefunc` VALUES (40, 1, 105, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:52', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:52');
INSERT INTO `sys_rolefunc` VALUES (41, 1, 106, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:53', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:53');
INSERT INTO `sys_rolefunc` VALUES (42, 1, 107, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:53', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:53');
INSERT INTO `sys_rolefunc` VALUES (43, 1, 108, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:53', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:53');
INSERT INTO `sys_rolefunc` VALUES (44, 1, 111, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:53', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:53');
INSERT INTO `sys_rolefunc` VALUES (45, 1, 112, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:53', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:53');
INSERT INTO `sys_rolefunc` VALUES (46, 1, 113, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:53', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:53');
INSERT INTO `sys_rolefunc` VALUES (47, 1, 120, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:53', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:53');
INSERT INTO `sys_rolefunc` VALUES (48, 1, 121, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:53', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:53');
INSERT INTO `sys_rolefunc` VALUES (49, 1, 122, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:53', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:53');
INSERT INTO `sys_rolefunc` VALUES (50, 1, 123, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:53', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:53');
INSERT INTO `sys_rolefunc` VALUES (51, 1, 124, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:54', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:54');
INSERT INTO `sys_rolefunc` VALUES (52, 1, 125, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:54', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:54');
INSERT INTO `sys_rolefunc` VALUES (53, 1, 126, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:54', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:54');
INSERT INTO `sys_rolefunc` VALUES (54, 1, 143, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:54', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:54');
INSERT INTO `sys_rolefunc` VALUES (55, 1, 144, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:54', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:54');
INSERT INTO `sys_rolefunc` VALUES (56, 1, 145, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:54', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:54');
INSERT INTO `sys_rolefunc` VALUES (57, 1, 159, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:54', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:54');
INSERT INTO `sys_rolefunc` VALUES (58, 1, 160, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:54', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:54');
INSERT INTO `sys_rolefunc` VALUES (59, 1, 161, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:54', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:54');
INSERT INTO `sys_rolefunc` VALUES (60, 1, 162, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:55', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:55');
INSERT INTO `sys_rolefunc` VALUES (61, 1, 163, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:55', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:55');
INSERT INTO `sys_rolefunc` VALUES (62, 1, 164, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:55', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:55');
INSERT INTO `sys_rolefunc` VALUES (63, 1, 165, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:55', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:55');
INSERT INTO `sys_rolefunc` VALUES (64, 1, 166, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:55', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:55');
INSERT INTO `sys_rolefunc` VALUES (65, 1, 167, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:55', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:55');
INSERT INTO `sys_rolefunc` VALUES (66, 1, 168, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:55', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:55');
INSERT INTO `sys_rolefunc` VALUES (67, 1, 169, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:55', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:55');
INSERT INTO `sys_rolefunc` VALUES (68, 1, 170, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:55', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:55');
INSERT INTO `sys_rolefunc` VALUES (69, 1, 171, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:55', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:55');
INSERT INTO `sys_rolefunc` VALUES (70, 1, 18, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:56', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:56');
INSERT INTO `sys_rolefunc` VALUES (71, 1, 19, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:56', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:56');
INSERT INTO `sys_rolefunc` VALUES (72, 1, 20, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:56', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:56');
INSERT INTO `sys_rolefunc` VALUES (73, 1, 24, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:56', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:56');
INSERT INTO `sys_rolefunc` VALUES (74, 1, 25, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:56', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:56');
INSERT INTO `sys_rolefunc` VALUES (75, 1, 26, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:56', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:56');
INSERT INTO `sys_rolefunc` VALUES (76, 1, 27, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:56', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:56');
INSERT INTO `sys_rolefunc` VALUES (77, 1, 28, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:56', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:56');
INSERT INTO `sys_rolefunc` VALUES (78, 1, 29, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:56', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:56');
INSERT INTO `sys_rolefunc` VALUES (79, 1, 30, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:57', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:57');
INSERT INTO `sys_rolefunc` VALUES (80, 1, 31, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:57', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:57');
INSERT INTO `sys_rolefunc` VALUES (81, 1, 34, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:57', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:57');
INSERT INTO `sys_rolefunc` VALUES (82, 1, 35, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:57', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:57');
INSERT INTO `sys_rolefunc` VALUES (83, 1, 36, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:57', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:57');
INSERT INTO `sys_rolefunc` VALUES (84, 1, 37, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:57', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:57');
INSERT INTO `sys_rolefunc` VALUES (85, 1, 38, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:57', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:57');
INSERT INTO `sys_rolefunc` VALUES (86, 1, 39, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:57', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:57');
INSERT INTO `sys_rolefunc` VALUES (87, 1, 40, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:57', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:57');
INSERT INTO `sys_rolefunc` VALUES (88, 1, 46, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:58', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:58');
INSERT INTO `sys_rolefunc` VALUES (89, 1, 47, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:58', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:58');
INSERT INTO `sys_rolefunc` VALUES (90, 1, 48, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:58', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:58');
INSERT INTO `sys_rolefunc` VALUES (91, 1, 43, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:58', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:58');
INSERT INTO `sys_rolefunc` VALUES (92, 1, 44, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:58', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:58');
INSERT INTO `sys_rolefunc` VALUES (93, 1, 45, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:58', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:58');
INSERT INTO `sys_rolefunc` VALUES (94, 1, 51, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:58', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:58');
INSERT INTO `sys_rolefunc` VALUES (95, 1, 52, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:58', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:58');
INSERT INTO `sys_rolefunc` VALUES (96, 1, 61, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:58', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:58');
INSERT INTO `sys_rolefunc` VALUES (97, 1, 62, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:58', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:58');
INSERT INTO `sys_rolefunc` VALUES (98, 1, 63, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:59', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:59');
INSERT INTO `sys_rolefunc` VALUES (99, 1, 64, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:59', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:59');
INSERT INTO `sys_rolefunc` VALUES (100, 1, 65, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:59', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:59');
INSERT INTO `sys_rolefunc` VALUES (101, 1, 66, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:59', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:59');
INSERT INTO `sys_rolefunc` VALUES (102, 1, 67, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:59', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:59');
INSERT INTO `sys_rolefunc` VALUES (103, 1, 68, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:59', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:59');
INSERT INTO `sys_rolefunc` VALUES (104, 1, 69, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:59', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:59');
INSERT INTO `sys_rolefunc` VALUES (105, 1, 70, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:59', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:59');
INSERT INTO `sys_rolefunc` VALUES (106, 1, 71, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:59', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:32:59');
INSERT INTO `sys_rolefunc` VALUES (107, 1, 72, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:00', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:00');
INSERT INTO `sys_rolefunc` VALUES (108, 1, 73, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:00', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:00');
INSERT INTO `sys_rolefunc` VALUES (109, 1, 74, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:00', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:00');
INSERT INTO `sys_rolefunc` VALUES (110, 1, 75, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:00', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:00');
INSERT INTO `sys_rolefunc` VALUES (111, 1, 76, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:00', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:00');
INSERT INTO `sys_rolefunc` VALUES (112, 1, 77, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:00', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:00');
INSERT INTO `sys_rolefunc` VALUES (113, 1, 78, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:00', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:00');
INSERT INTO `sys_rolefunc` VALUES (114, 1, 79, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:00', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:00');
INSERT INTO `sys_rolefunc` VALUES (115, 1, 80, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:00', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:00');
INSERT INTO `sys_rolefunc` VALUES (116, 1, 81, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:01', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:01');
INSERT INTO `sys_rolefunc` VALUES (117, 1, 82, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:01', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:01');
INSERT INTO `sys_rolefunc` VALUES (118, 1, 83, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:01', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:01');
INSERT INTO `sys_rolefunc` VALUES (119, 1, 84, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:01', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:01');
INSERT INTO `sys_rolefunc` VALUES (120, 1, 85, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:01', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:01');
INSERT INTO `sys_rolefunc` VALUES (121, 1, 86, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:01', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:01');
INSERT INTO `sys_rolefunc` VALUES (122, 1, 87, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:01', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:01');
INSERT INTO `sys_rolefunc` VALUES (123, 1, 92, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:01', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:01');
INSERT INTO `sys_rolefunc` VALUES (124, 1, 93, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:01', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:01');
INSERT INTO `sys_rolefunc` VALUES (125, 1, 94, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:02', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:02');
INSERT INTO `sys_rolefunc` VALUES (126, 1, 99, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:02', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:02');
INSERT INTO `sys_rolefunc` VALUES (127, 1, 100, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:02', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:02');
INSERT INTO `sys_rolefunc` VALUES (128, 1, 101, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:02', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:02');
INSERT INTO `sys_rolefunc` VALUES (129, 1, 102, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:02', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:02');
INSERT INTO `sys_rolefunc` VALUES (130, 1, 103, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:02', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:02');
INSERT INTO `sys_rolefunc` VALUES (131, 1, 95, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:02', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:02');
INSERT INTO `sys_rolefunc` VALUES (132, 1, 96, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:02', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:02');
INSERT INTO `sys_rolefunc` VALUES (133, 1, 97, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:02', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:02');
INSERT INTO `sys_rolefunc` VALUES (134, 1, 98, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:03', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:03');
INSERT INTO `sys_rolefunc` VALUES (135, 1, 109, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:03', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:03');
INSERT INTO `sys_rolefunc` VALUES (136, 1, 110, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:03', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:03');
INSERT INTO `sys_rolefunc` VALUES (137, 1, 114, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:03', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:03');
INSERT INTO `sys_rolefunc` VALUES (138, 1, 115, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:03', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:03');
INSERT INTO `sys_rolefunc` VALUES (139, 1, 116, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:03', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:03');
INSERT INTO `sys_rolefunc` VALUES (140, 1, 117, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:03', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:03');
INSERT INTO `sys_rolefunc` VALUES (141, 1, 118, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:03', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:03');
INSERT INTO `sys_rolefunc` VALUES (142, 1, 119, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:03', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:03');
INSERT INTO `sys_rolefunc` VALUES (143, 1, 127, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:03', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:03');
INSERT INTO `sys_rolefunc` VALUES (144, 1, 128, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:04', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:04');
INSERT INTO `sys_rolefunc` VALUES (145, 1, 129, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:04', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:04');
INSERT INTO `sys_rolefunc` VALUES (146, 1, 130, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:04', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:04');
INSERT INTO `sys_rolefunc` VALUES (147, 1, 131, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:04', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:04');
INSERT INTO `sys_rolefunc` VALUES (148, 1, 132, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:04', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:04');
INSERT INTO `sys_rolefunc` VALUES (149, 1, 133, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:04', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:04');
INSERT INTO `sys_rolefunc` VALUES (150, 1, 134, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:04', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:04');
INSERT INTO `sys_rolefunc` VALUES (151, 1, 135, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:04', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:04');
INSERT INTO `sys_rolefunc` VALUES (152, 1, 138, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:05', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:05');
INSERT INTO `sys_rolefunc` VALUES (153, 1, 139, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:05', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:05');
INSERT INTO `sys_rolefunc` VALUES (154, 1, 140, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:05', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:05');
INSERT INTO `sys_rolefunc` VALUES (155, 1, 141, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:05', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:05');
INSERT INTO `sys_rolefunc` VALUES (156, 1, 142, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:05', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:05');
INSERT INTO `sys_rolefunc` VALUES (157, 1, 136, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:05', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:05');
INSERT INTO `sys_rolefunc` VALUES (158, 1, 137, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:05', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:05');
INSERT INTO `sys_rolefunc` VALUES (159, 1, 146, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:05', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:05');
INSERT INTO `sys_rolefunc` VALUES (160, 1, 147, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:05', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:05');
INSERT INTO `sys_rolefunc` VALUES (161, 1, 148, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:06', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:06');
INSERT INTO `sys_rolefunc` VALUES (162, 1, 149, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:06', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:06');
INSERT INTO `sys_rolefunc` VALUES (163, 1, 150, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:06', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:06');
INSERT INTO `sys_rolefunc` VALUES (164, 1, 151, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:06', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:06');
INSERT INTO `sys_rolefunc` VALUES (165, 1, 152, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:06', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:06');
INSERT INTO `sys_rolefunc` VALUES (166, 1, 153, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:06', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:06');
INSERT INTO `sys_rolefunc` VALUES (167, 1, 154, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:06', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:06');
INSERT INTO `sys_rolefunc` VALUES (168, 1, 155, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:06', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:06');
INSERT INTO `sys_rolefunc` VALUES (169, 1, 156, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:07', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:07');
INSERT INTO `sys_rolefunc` VALUES (170, 1, 157, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:07', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:07');
INSERT INTO `sys_rolefunc` VALUES (171, 1, 158, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:07', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:07');
INSERT INTO `sys_rolefunc` VALUES (172, 1, 172, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:07', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:07');
INSERT INTO `sys_rolefunc` VALUES (173, 1, 173, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:07', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:07');
INSERT INTO `sys_rolefunc` VALUES (174, 1, 174, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:07', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:07');
INSERT INTO `sys_rolefunc` VALUES (175, 1, 175, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:07', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:07');
INSERT INTO `sys_rolefunc` VALUES (176, 1, 176, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:07', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:07');
INSERT INTO `sys_rolefunc` VALUES (177, 1, 177, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:07', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:07');
INSERT INTO `sys_rolefunc` VALUES (178, 1, 178, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:08', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:08');
INSERT INTO `sys_rolefunc` VALUES (179, 1, 179, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:08', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:08');
INSERT INTO `sys_rolefunc` VALUES (180, 1, 180, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:08', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:08');
INSERT INTO `sys_rolefunc` VALUES (181, 1, 181, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:08', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:08');
INSERT INTO `sys_rolefunc` VALUES (182, 1, 182, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:08', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:08');
INSERT INTO `sys_rolefunc` VALUES (183, 1, 183, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:08', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:08');
INSERT INTO `sys_rolefunc` VALUES (184, 1, 184, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:08', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:08');
INSERT INTO `sys_rolefunc` VALUES (185, 1, 185, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:08', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:08');
INSERT INTO `sys_rolefunc` VALUES (186, 1, 186, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:09', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:09');
INSERT INTO `sys_rolefunc` VALUES (187, 1, 187, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:09', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:09');
INSERT INTO `sys_rolefunc` VALUES (188, 1, 188, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:09', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:09');
INSERT INTO `sys_rolefunc` VALUES (189, 1, 189, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:09', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:09');
INSERT INTO `sys_rolefunc` VALUES (190, 1, 190, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:09', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:09');
INSERT INTO `sys_rolefunc` VALUES (191, 1, 191, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:09', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:09');
INSERT INTO `sys_rolefunc` VALUES (192, 1, 192, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:09', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:09');
INSERT INTO `sys_rolefunc` VALUES (193, 1, 193, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:09', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:09');
INSERT INTO `sys_rolefunc` VALUES (194, 1, 194, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:09', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:09');
INSERT INTO `sys_rolefunc` VALUES (195, 1, 195, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:10', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:10');
INSERT INTO `sys_rolefunc` VALUES (196, 1, 196, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:10', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:10');
INSERT INTO `sys_rolefunc` VALUES (197, 1, 197, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:10', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:10');
INSERT INTO `sys_rolefunc` VALUES (198, 1, 198, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:10', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:10');
INSERT INTO `sys_rolefunc` VALUES (199, 1, 199, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:10', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:10');
INSERT INTO `sys_rolefunc` VALUES (200, 1, 200, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:10', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:10');
INSERT INTO `sys_rolefunc` VALUES (201, 1, 201, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:10', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:10');
INSERT INTO `sys_rolefunc` VALUES (202, 1, 202, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:10', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:10');
INSERT INTO `sys_rolefunc` VALUES (203, 1, 203, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:11', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:11');
INSERT INTO `sys_rolefunc` VALUES (204, 1, 204, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:11', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:11');
INSERT INTO `sys_rolefunc` VALUES (205, 1, 205, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:11', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:11');
INSERT INTO `sys_rolefunc` VALUES (206, 1, 206, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:11', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:11');
INSERT INTO `sys_rolefunc` VALUES (207, 1, 207, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:11', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:11');
INSERT INTO `sys_rolefunc` VALUES (208, 1, 208, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:11', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:11');
INSERT INTO `sys_rolefunc` VALUES (209, 1, 209, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:11', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:11');
INSERT INTO `sys_rolefunc` VALUES (210, 1, 210, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:11', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:11');
INSERT INTO `sys_rolefunc` VALUES (211, 1, 211, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:12', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:12');
INSERT INTO `sys_rolefunc` VALUES (212, 1, 212, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:12', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:12');
INSERT INTO `sys_rolefunc` VALUES (213, 1, 213, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:12', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:12');
INSERT INTO `sys_rolefunc` VALUES (214, 1, 214, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:12', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:12');
INSERT INTO `sys_rolefunc` VALUES (215, 1, 215, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:13', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:13');
INSERT INTO `sys_rolefunc` VALUES (216, 1, 216, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:13', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:13');
INSERT INTO `sys_rolefunc` VALUES (217, 1, 217, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:14', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:14');
INSERT INTO `sys_rolefunc` VALUES (218, 1, 218, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:14', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:14');
INSERT INTO `sys_rolefunc` VALUES (219, 1, 219, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:14', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:14');
INSERT INTO `sys_rolefunc` VALUES (220, 1, 220, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:14', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:14');
INSERT INTO `sys_rolefunc` VALUES (221, 1, 221, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:15', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:15');
INSERT INTO `sys_rolefunc` VALUES (222, 1, 222, b'0', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:15', '065d4aed0b4a47bc9406d39ae182g3e6', '2020-09-13 14:33:15');
INSERT INTO `sys_rolefunc` VALUES (223, 2, 7, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (224, 2, 213, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (225, 2, 215, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (226, 2, 216, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (227, 2, 217, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (228, 2, 218, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (229, 2, 214, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (230, 2, 219, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (231, 2, 220, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (232, 2, 221, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (233, 2, 222, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (234, 2, 13, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (235, 2, 125, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (236, 2, 138, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (237, 2, 139, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (238, 2, 243, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (239, 2, 244, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (240, 2, 126, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (241, 2, 140, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (242, 2, 141, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (243, 2, 142, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (244, 2, 207, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (245, 2, 210, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (246, 2, 211, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (247, 2, 212, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (248, 2, 225, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (249, 2, 226, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (250, 2, 202, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (251, 2, 203, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (252, 2, 205, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (253, 2, 224, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (254, 2, 246, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (255, 2, 259, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (256, 2, 260, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (257, 2, 262, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');
INSERT INTO `sys_rolefunc` VALUES (258, 2, 263, b'0', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20', '28883d4a8d584128a9443111ac0c93fe', '2022-04-26 02:08:20');

-- ----------------------------
-- Table structure for sys_rolefuncs
-- ----------------------------
DROP TABLE IF EXISTS `sys_rolefuncs`;
CREATE TABLE `sys_rolefuncs`  (
  `rolefuncid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '角色功能id',
  `sysroleid` bigint(0) NOT NULL COMMENT '角色id',
  `sfunid` bigint(0) NOT NULL COMMENT '功能id',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`rolefuncid`, `sysroleid`, `sfunid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色拥有功能' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_roleinfo
-- ----------------------------
DROP TABLE IF EXISTS `sys_roleinfo`;
CREATE TABLE `sys_roleinfo`  (
  `sysroleid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `sysrolename` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `sysrolestatus` decimal(1, 0) NULL DEFAULT NULL COMMENT '角色状态  0正常  9停用',
  PRIMARY KEY (`sysroleid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '后台系统角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_roleinfo
-- ----------------------------
INSERT INTO `sys_roleinfo` VALUES (1, '超级系统管理员', 0);
INSERT INTO `sys_roleinfo` VALUES (2, '运营管理', 0);

-- ----------------------------
-- Table structure for sys_sensitive_word
-- ----------------------------
DROP TABLE IF EXISTS `sys_sensitive_word`;
CREATE TABLE `sys_sensitive_word`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `word` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '敏感词',
  `status` decimal(1, 0) NULL DEFAULT 0 COMMENT '敏感词启用状态0启用9未启用',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '敏感词' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_shortmsg
-- ----------------------------
DROP TABLE IF EXISTS `sys_shortmsg`;
CREATE TABLE `sys_shortmsg`  (
  `shortmsgid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '短信ID',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号码',
  `msgtype` decimal(1, 0) NULL DEFAULT NULL COMMENT '短信類型 1短信登陆 ;2找回密码 ;3注册；4.修改密码 8提醒  9其他普通短信',
  `masdate` datetime(0) NULL DEFAULT NULL COMMENT '短信發送时间',
  `masbody` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '短信内容',
  `msgcode` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '相关编码 对应存储相关类型的编码，如验证码，提醒相关id或订单编号',
  `masstatus` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态 0发送成功 8已使用 9发送失败 ',
  `ipaddress` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '發送短信ip地址',
  PRIMARY KEY (`shortmsgid`) USING BTREE,
  INDEX `idx1`(`email`, `msgtype`, `msgcode`, `masstatus`) USING BTREE,
  INDEX `idx2`(`email`, `msgtype`, `masstatus`) USING BTREE,
  INDEX `idx3`(`email`, `msgtype`, `masdate`, `masstatus`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '短信收发记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_tags
-- ----------------------------
DROP TABLE IF EXISTS `sys_tags`;
CREATE TABLE `sys_tags`  (
  `tagid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '标签id',
  `tagname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标签名称',
  `tagtype` decimal(1, 0) NULL DEFAULT NULL COMMENT '标签分类 1系统标签 2图文主题',
  `sortby` int(0) NULL DEFAULT NULL COMMENT '排序权重',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`tagid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '主题、系统标签' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_tenlikesserver
-- ----------------------------
DROP TABLE IF EXISTS `sys_tenlikesserver`;
CREATE TABLE `sys_tenlikesserver`  (
  `tlikesid` bigint(0) NOT NULL COMMENT '直播服务器id',
  `servername` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '服务器名称',
  `serverurl` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '服务器地址',
  `weight` int(0) NULL DEFAULT 1 COMMENT '服务器权重',
  `servertype` decimal(1, 0) NULL DEFAULT NULL COMMENT '服务类型  1:  推流域名 2: 播放域名',
  `ptlikesid` bigint(0) NULL DEFAULT NULL COMMENT '所属推流服务器id',
  `region` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '服务器所在区域名称',
  `primarykey` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '鉴权主key',
  `backupkey` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '鉴权备用key',
  `status` decimal(1, 0) NULL DEFAULT NULL COMMENT '启用状态0启用9未启用',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`tlikesid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '腾讯云直播服务器节点表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_tenliveserver
-- ----------------------------
DROP TABLE IF EXISTS `sys_tenliveserver`;
CREATE TABLE `sys_tenliveserver`  (
  `tliveid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '直播服务器id',
  `servername` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '服务器名称',
  `serverurl` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '服务器地址',
  `weight` int(0) NULL DEFAULT 1 COMMENT '服務器權重',
  `servertype` decimal(1, 0) NULL DEFAULT NULL COMMENT '服務類型  1:  推流域名 2: 播放域名',
  `ptliveid` bigint(0) NULL DEFAULT NULL COMMENT '所屬推流服務器id',
  `region` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '服務器所在區域名稱',
  `primarykey` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '鉴权主key',
  `backupkey` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '鑒權備用key',
  `status` decimal(1, 0) NULL DEFAULT NULL COMMENT '启用状态0启用9未启用',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`tliveid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '騰訊云直播服务器节点表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_threepayset
-- ----------------------------
DROP TABLE IF EXISTS `sys_threepayset`;
CREATE TABLE `sys_threepayset`  (
  `tpaysetid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '三方账户id',
  `providerid` bigint(0) NULL DEFAULT NULL COMMENT '支付商id',
  `tpayname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '设定名称 如 支付宝  微信  银联',
  `paytype` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '支付方式  NETBANK 网银转账  WECHAT 微信收款  ALIPAY 支付宝支付',
  `paycode` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '支付方式  wechatangel 微信话费扫码  wechatangelwap  微信话费H5  alipay   支付宝  alipayangel  支付宝话费扫码H5  alipaylst  支付宝转卡',
  `payvalue` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付设置值',
  `minamt` decimal(16, 3) NULL DEFAULT NULL COMMENT '单笔最低金额',
  `maxamt` decimal(16, 3) NULL DEFAULT NULL COMMENT '单笔入账最高金额',
  `minmemlevel` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '启用会员最低等级',
  `maxmemlevel` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '启用会员最高等级',
  `stopamt` decimal(16, 3) NULL DEFAULT NULL COMMENT '停用次卡上限金额',
  `easyrecharge` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '快捷充值套餐金额, 多条以\",\"分隔',
  `isinput` decimal(1, 0) NULL DEFAULT NULL COMMENT '是否允许输入金额  0允许 9禁止 ',
  `status` decimal(1, 0) NULL DEFAULT NULL COMMENT '启用状态: 0启用 9停用',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`tpaysetid`) USING BTREE,
  INDEX `fk_reference_75`(`providerid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '三方支付设定表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_whitelist
-- ----------------------------
DROP TABLE IF EXISTS `sys_whitelist`;
CREATE TABLE `sys_whitelist`  (
  `whiteid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '白名单id',
  `syscode` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '系统识别码code',
  `sysname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '系统名称',
  `ipaddress` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'ip地址',
  `status` decimal(1, 0) NULL DEFAULT NULL COMMENT '启用状态0启用9未启用',
  `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`whiteid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统登录白名单管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tra_agentclearing
-- ----------------------------
DROP TABLE IF EXISTS `tra_agentclearing`;
CREATE TABLE `tra_agentclearing`  (
  `cleanid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '结算id',
  `agentid` bigint(0) NULL DEFAULT NULL COMMENT '代理id',
  `accno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '代理会员标识号',
  `cleantype` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '结算类型 day日结 week周结 month月结',
  `refids` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '关联订单id 多条以逗号分隔',
  `chargeamt` decimal(16, 3) NULL DEFAULT NULL COMMENT '充值总金额',
  `reverseamt` decimal(16, 3) NULL DEFAULT NULL COMMENT '返点总金额',
  `commission` decimal(5, 2) NULL DEFAULT NULL COMMENT '返佣比(%)',
  `buttonnote` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注说明',
  `daily_withdrawal` decimal(16, 3) NOT NULL DEFAULT 0.000 COMMENT '本日提现总金额',
  `daily_pay_users` int(0) NOT NULL DEFAULT 0 COMMENT '本日首充人数',
  `daily_pay_total` decimal(16, 3) NOT NULL DEFAULT 0.000 COMMENT '本日新增首充金额',
  `daily_new_users` int(0) NOT NULL DEFAULT 0 COMMENT '本日下级人数',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`cleanid`) USING BTREE,
  INDEX `fk_reference_77`(`agentid`, `cleantype`, `is_delete`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '代理结算表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tra_anchor
-- ----------------------------
DROP TABLE IF EXISTS `tra_anchor`;
CREATE TABLE `tra_anchor`  (
  `traanchorid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主播结算id',
  `accno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主播会员标识号',
  `apycid` bigint(0) NULL DEFAULT NULL COMMENT '提现申请id',
  `anconlineid` bigint(0) NULL DEFAULT NULL COMMENT '主播在线id',
  `familyid` bigint(0) NULL DEFAULT NULL COMMENT '家族id',
  `giftincome` decimal(16, 3) NULL DEFAULT NULL COMMENT '礼物收入',
  `betsincome` decimal(16, 3) NULL DEFAULT NULL COMMENT '投注分成',
  `buttonnote` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注说明',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `onlinedate` datetime(0) NULL DEFAULT NULL COMMENT '上线时间',
  `offlinedate` datetime(0) NULL DEFAULT NULL COMMENT '下线时间',
  PRIMARY KEY (`traanchorid`) USING BTREE,
  INDEX `fk_reference_78`(`apycid`, `is_delete`, `create_time`) USING BTREE,
  INDEX `fk_reference_79`(`anconlineid`, `is_delete`, `create_time`) USING BTREE,
  INDEX `fk_reference_80`(`familyid`, `is_delete`, `create_time`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '主播结算收入明细' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tra_anchortracking
-- ----------------------------
DROP TABLE IF EXISTS `tra_anchortracking`;
CREATE TABLE `tra_anchortracking`  (
  `antrackingid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '追踪id',
  `anconlineid` bigint(0) NULL DEFAULT NULL COMMENT '主播在线id',
  `orderid` bigint(0) NULL DEFAULT NULL COMMENT '订单id',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`antrackingid`) USING BTREE,
  INDEX `fk_reference_81`(`anconlineid`) USING BTREE,
  INDEX `fk_reference_82`(`orderid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '主播结算追踪表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tra_applyaudit
-- ----------------------------
DROP TABLE IF EXISTS `tra_applyaudit`;
CREATE TABLE `tra_applyaudit`  (
  `apauditid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '提现稽核对账表',
  `apycid` bigint(0) NULL DEFAULT NULL COMMENT '提现申请id',
  `orderid` bigint(0) NULL DEFAULT NULL COMMENT '充值订单id',
  `paysetid` bigint(0) NULL DEFAULT NULL COMMENT '支付设定id',
  `auditamt` decimal(16, 3) NULL DEFAULT NULL COMMENT '常态性稽核费（元）',
  `codesize` decimal(16, 3) NULL DEFAULT NULL COMMENT '打码量',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`apauditid`) USING BTREE,
  INDEX `fk_reference_61`(`apycid`) USING BTREE,
  INDEX `fk_reference_62`(`orderid`) USING BTREE,
  INDEX `fk_reference_74`(`paysetid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '提现稽核对账表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tra_applycash
-- ----------------------------
DROP TABLE IF EXISTS `tra_applycash`;
CREATE TABLE `tra_applycash`  (
  `apycid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '提现申请id',
  `bankaccid` bigint(0) NULL DEFAULT NULL COMMENT '银行账户id',
  `orderid` bigint(0) NULL DEFAULT NULL COMMENT '订单id',
  `accno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '会员标识号',
  `apycdate` datetime(0) NULL DEFAULT NULL COMMENT '申请时间',
  `apycgold` decimal(16, 3) NULL DEFAULT NULL COMMENT '申请总金额',
  `apycamt` decimal(16, 3) NULL DEFAULT NULL COMMENT '打款金额',
  `apycstatus` decimal(1, 0) NULL DEFAULT NULL COMMENT '申请状态  1提交申请  2提现处理中  4已打款    8已到账  9已取消',
  `paymemname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '打款人',
  `paydate` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `damaliang` decimal(16, 3) NULL DEFAULT 0.000 COMMENT '打码量',
  `xingzhengfei` decimal(16, 3) NULL DEFAULT 0.000 COMMENT '行政费',
  `bet_amount` decimal(16, 3) NULL DEFAULT 0.000 COMMENT '投注金额充值金额',
  `no_withdrawal_amount` decimal(16, 3) NULL DEFAULT 0.000 COMMENT '当前所需打码量',
  `ordertype` decimal(2, 0) NULL DEFAULT NULL COMMENT '提现类型，12投注分成，13礼物分成',
  `payimg` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付凭证截图 多张以“，”分隔',
  `orderno` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '第3方支付返回流水号',
  PRIMARY KEY (`apycid`) USING BTREE,
  INDEX `fk_reference_25`(`bankaccid`) USING BTREE,
  INDEX `fk_reference_44`(`orderid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '提现申请' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tra_artrepayorder
-- ----------------------------
DROP TABLE IF EXISTS `tra_artrepayorder`;
CREATE TABLE `tra_artrepayorder`  (
  `artorderid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '人工存提id',
  `orderid` bigint(0) NULL DEFAULT NULL COMMENT '订单id',
  `logintype` decimal(2, 0) NULL DEFAULT NULL COMMENT '账户类型  代充人4 ',
  `ordertype` decimal(1, 0) NULL DEFAULT NULL COMMENT '存提类型  0 存入 1提出',
  `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `memaccount` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '帐号ID mem_baseinfo 的 unique_id',
  `accno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '会员识别号',
  `optamt` decimal(16, 3) NULL DEFAULT NULL COMMENT '存提金额 #.###',
  `giftamt` decimal(16, 3) NULL DEFAULT NULL COMMENT '优惠金额  #.###',
  `auditper` decimal(16, 2) NULL DEFAULT NULL COMMENT '打码倍数(常态性稽核）##.##   ',
  `note` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注说明',
  `is_delete` bit(1) NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '最后修改人',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`artorderid`) USING BTREE,
  INDEX `tra_artrepayorder_fk1`(`orderid`) USING BTREE,
  INDEX `tra_artrepayorder_memaccount`(`memaccount`) USING BTREE,
  INDEX `tra_artrepayorder_nickname`(`nickname`) USING BTREE,
  INDEX `tra_artrepayorder_accno`(`accno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '代充存提订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tra_orderaccount
-- ----------------------------
DROP TABLE IF EXISTS `tra_orderaccount`;
CREATE TABLE `tra_orderaccount`  (
  `accno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '会员标识号',
  `bankid` bigint(0) NULL DEFAULT NULL COMMENT '银行账户id',
  `orderid` bigint(0) NULL DEFAULT NULL COMMENT '订单id',
  `is_delete` bit(1) NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '最后修改人',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  INDEX `tra_orderaccount_fk1`(`orderid`) USING BTREE,
  INDEX `tra_orderaccount_accno`(`accno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '代充人入款订单银行卡' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tra_orderinfom
-- ----------------------------
DROP TABLE IF EXISTS `tra_orderinfom`;
CREATE TABLE `tra_orderinfom`  (
  `orderid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `mealid` bigint(0) NULL DEFAULT NULL COMMENT '充值套餐id',
  `bankid` bigint(0) NULL DEFAULT NULL COMMENT '入款账户id',
  `mem_bank_id` bigint(0) NULL DEFAULT NULL,
  `roomid` bigint(0) NULL DEFAULT NULL COMMENT '主播房间id',
  `lotkindid` bigint(0) NULL DEFAULT NULL COMMENT '彩种id',
  `sschistoryid` bigint(0) NULL DEFAULT NULL COMMENT '时时彩开奖id',
  `oddsid` bigint(0) NULL DEFAULT NULL COMMENT '投注项id',
  `chekindid` bigint(0) NULL DEFAULT NULL COMMENT '棋牌分类id',
  `tpaysetid` bigint(0) NULL DEFAULT NULL COMMENT '三方支付id',
  `ordertype` decimal(2, 0) NULL DEFAULT NULL COMMENT '订单类型 1在线支付 2线下支付 3在线提现 4线下提现 5彩票购彩 6彩票兑奖 7棋牌上分 8棋牌下分 9其他收入(发帖/推荐)  10其他支出(打赏)  11代理结算收入 14 代充人入款 15代充人给会员充值 16代充存入 17代充提出\r\n',
  `orderno` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '订单编号4码年+2码月+8码流水号，生成逻辑：取当前年月，然后从数据库中取当前年月最大订单号，然后将后面8位流水号+1',
  `accno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '会员标识号',
  `paycode` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '支付标示第三方支付标示号，如支付宝的订单号或微信的prepay_id等',
  `orderdate` timestamp(0) NULL DEFAULT NULL COMMENT '订单日期',
  `expiredate` timestamp(0) NULL DEFAULT NULL COMMENT '过期时间',
  `paytype` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '支付方式  JSAPI--公众号支付、NATIVE--原生扫码支付、APP--app支付   NETBANK 网银转账  WECHAT 微信收款  ALIPAY 支付宝支付',
  `oldamt` decimal(16, 3) NULL DEFAULT NULL COMMENT '订单原价',
  `sumamt` decimal(16, 3) NULL DEFAULT NULL COMMENT '订单总金额',
  `realamt` decimal(16, 3) NULL DEFAULT NULL COMMENT '实付金额',
  `isinvoice` decimal(1, 0) NULL DEFAULT NULL COMMENT '是否开具发票0是 9否',
  `orderstatus` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '订单状态 ord01新订单 ord04待付款 ord05提现申请 ord06提现取消 ord07提现处理中 ord08已付款  ord09用户取消 ord10已评价  ord11已退款 ord12已提现  ord98已拉取棋牌订单 ord99已过期   ',
  `accountstatus` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '结算状态 acc04待结算（未打码）  acc08已结算（已打码）  acc99已取消（不可结算）',
  `cancelreason` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '取消订单原因',
  `payimg` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '支付凭证截图 多张以“，”分隔',
  `pay_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `transfer_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `paywechat` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '支付处理微信号',
  `paydate` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `payuser` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '汇款姓名',
  `paynote` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '汇款备注',
  `ordernote` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '备注',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `source` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '来源 Android | IOS | WEB',
  `cleanid` bigint(0) NULL DEFAULT 0 COMMENT '代理结算id,大于0，表示结算过，可追溯被何处结算',
  `buy_vip` bigint(0) NULL DEFAULT NULL COMMENT '购买VIP的等级,为空则表示不购买等级',
  PRIMARY KEY (`orderid`) USING BTREE,
  INDEX `fk_reference_43`(`mealid`) USING BTREE,
  INDEX `fk_reference_44`(`bankid`) USING BTREE,
  INDEX `fk_reference_59`(`roomid`) USING BTREE,
  INDEX `fk_reference_52`(`lotkindid`) USING BTREE,
  INDEX `fk_reference_58`(`oddsid`) USING BTREE,
  INDEX `fk_reference_64`(`chekindid`) USING BTREE,
  INDEX `fk_reference_76`(`tpaysetid`) USING BTREE,
  INDEX `tp_reference_01`(`ordertype`) USING BTREE,
  INDEX `tp_reference_02`(`orderstatus`, `accountstatus`, `is_delete`) USING BTREE,
  INDEX `tp_reference_03`(`accno`) USING BTREE,
  INDEX `tp_reference_04`(`orderno`) USING BTREE,
  INDEX `idx_t_d_r_t`(`ordertype`, `is_delete`, `roomid`, `create_time`) USING BTREE,
  INDEX `idx_d`(`is_delete`) USING BTREE,
  INDEX `idx_r_o`(`roomid`, `ordertype`) USING BTREE,
  INDEX `idx_ac_ot_os`(`accno`, `ordertype`, `orderstatus`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14810 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单信息主' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tra_ordertracking
-- ----------------------------
DROP TABLE IF EXISTS `tra_ordertracking`;
CREATE TABLE `tra_ordertracking`  (
  `trackid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '追踪id',
  `orderid` bigint(0) NULL DEFAULT NULL COMMENT '订单id',
  `trackdate` datetime(0) NULL DEFAULT NULL COMMENT '处理时间',
  `trackbody` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '处理内容',
  `operuse` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作人',
  `orderstatus` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单状态 ord01新订单 ord04已审核待付款  ord08已付款待评价 ord12已发货 ord16已完成（已收货） ord10已评价 ord99已取消  ord07退款中  ord11已退款  ',
  PRIMARY KEY (`trackid`) USING BTREE,
  INDEX `fk_relationship_37`(`orderid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单追踪' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tra_paymentinfo
-- ----------------------------
DROP TABLE IF EXISTS `tra_paymentinfo`;
CREATE TABLE `tra_paymentinfo`  (
  `payid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '支付id',
  `orderid` bigint(0) NULL DEFAULT NULL COMMENT '订单id',
  `paycode` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付标示第三方支付标示号，如支付宝的订单号或微信的prepay_id等',
  `paydate` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `paydatee` datetime(0) NULL DEFAULT NULL COMMENT '支付完成时间',
  `serialno` bigint(0) NULL DEFAULT NULL COMMENT '流水号：8位年月日+8位数字，如2016052800001200',
  `accno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '会员标识号',
  `orderno` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单编号4码年+2码月+8码流水号，生成逻辑：取当前年月，然后从数据库中取当前年月最大订单号，然后将后面8位流水号+1',
  `paykind` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付类别 weixin微信支付 alipay支付宝支付',
  `paytype` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付方式  JSAPI--公众号支付、NATIVE--原生扫码支付、APP--app支付   NETBANK 网银转账',
  `tradingno` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '交易标识号',
  `payamt` decimal(16, 3) NULL DEFAULT NULL COMMENT '支付金额',
  `payscore` int(0) NULL DEFAULT NULL COMMENT '支付积分',
  `paystatus` decimal(1, 0) NULL DEFAULT NULL COMMENT '支付状态0支付成功/退款成功   1支付中/退款中     9支付失败/退款失败',
  `payerrdesc` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付错误描述 不用格式自己定义，如微信支付可以存错误代码$$错误描述',
  `systemname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '系统代码：来源系统代码',
  `paycodeurl` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '支付标示二维码(页面)',
  `paynote` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注 退款时把原支付id写到这里',
  `payrefundtype` decimal(1, 0) NULL DEFAULT NULL COMMENT '支付退款类型  0或null 支付  9 退款',
  `refundnote` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '退款说明',
  `refundcode` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '退款标示号 uuid',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `provider_id` bigint(0) NULL DEFAULT NULL COMMENT '商户配置ID',
  PRIMARY KEY (`payid`) USING BTREE,
  INDEX `fk_relationship_26`(`orderid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '支付信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tra_rechargeaudit
-- ----------------------------
DROP TABLE IF EXISTS `tra_rechargeaudit`;
CREATE TABLE `tra_rechargeaudit`  (
  `recauditid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '充值对账id',
  `orderid` bigint(0) NULL DEFAULT NULL COMMENT '订单id',
  `paysetid` bigint(0) NULL DEFAULT NULL COMMENT '支付设定id',
  `giftamt` decimal(16, 3) NULL DEFAULT NULL COMMENT '优惠赠送金额',
  `buttonnote` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注说明',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`recauditid`) USING BTREE,
  INDEX `fk_reference_87`(`orderid`) USING BTREE,
  INDEX `fk_reference_88`(`paysetid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '入款对账表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tra_rechargemeal
-- ----------------------------
DROP TABLE IF EXISTS `tra_rechargemeal`;
CREATE TABLE `tra_rechargemeal`  (
  `mealid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '充值套餐id',
  `realamt` decimal(16, 3) NULL DEFAULT NULL COMMENT '充值金额',
  `rechargegold` decimal(16, 3) NULL DEFAULT NULL COMMENT '充值播币数',
  `givegold` decimal(16, 3) NULL DEFAULT NULL COMMENT '赠送播币数',
  `givepercent` decimal(16, 3) NULL DEFAULT NULL COMMENT '赠送率  三位小数',
  `expirydates` datetime(0) NULL DEFAULT NULL COMMENT '有效期起',
  `expirydatee` datetime(0) NULL DEFAULT NULL COMMENT '有效期止',
  `mealnote` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `sortby` int(0) NULL DEFAULT NULL COMMENT '排序权重 默认为0  数字越大排序越靠前',
  `is_delete` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建人',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后修改人',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`mealid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '充值套餐' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tra_repayorder
-- ----------------------------
DROP TABLE IF EXISTS `tra_repayorder`;
CREATE TABLE `tra_repayorder`  (
  `reorderid` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '代充订单id',
  `orderid` bigint(0) NULL DEFAULT NULL COMMENT '订单id',
  `refaccno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '代充人accno',
  `refaccount` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '代充人帐号',
  `accno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '充值人accno',
  `memaccount` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '充值人UNIQUE_ID',
  `nickname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '充值人昵称',
  `realamt` decimal(16, 3) NULL DEFAULT NULL COMMENT '入款金额',
  `orderstatus` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单状态 ord01新订单 ord04待付款 ord08已付款  ord09用户取消 ord11已退款 ord99已过期   ',
  `note` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注说明',
  `is_delete` bit(1) NULL DEFAULT b'0' COMMENT '是否删除',
  `create_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_user` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '最后修改人',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`reorderid`) USING BTREE,
  INDEX `tra_repayorder_fk1`(`orderid`) USING BTREE,
  INDEX `tra_repayorder_accno`(`accno`) USING BTREE,
  INDEX `tra_repayorder_memaccount`(`memaccount`) USING BTREE,
  INDEX `tra_repayorder_refaccno`(`refaccno`) USING BTREE,
  INDEX `tra_repayorder_nickname`(`nickname`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '代充订单表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
