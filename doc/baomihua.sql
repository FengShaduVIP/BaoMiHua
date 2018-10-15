/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50723
Source Host           : 127.0.0.1:3306
Source Database       : baomihua

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-10-15 17:02:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bmh_award_log
-- ----------------------------
DROP TABLE IF EXISTS `bmh_award_log`;
CREATE TABLE `bmh_award_log` (
  `id` varchar(50) NOT NULL,
  `user_name` varchar(50) DEFAULT NULL COMMENT '中奖者名称',
  `phone_num` varchar(50) DEFAULT NULL COMMENT '手机号',
  `price_num` varchar(10) DEFAULT NULL COMMENT '奖品号码',
  `price_name` varchar(255) DEFAULT NULL COMMENT '奖品名称',
  `create_time` int(20) DEFAULT NULL COMMENT '抽奖时间',
  `award_id` varchar(50) DEFAULT NULL COMMENT '抽奖表id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bmh_award_log
-- ----------------------------
INSERT INTO `bmh_award_log` VALUES ('1', '2', '17826800412', '1', 'iphone 9', '4', '4');
INSERT INTO `bmh_award_log` VALUES ('2', '3', '17826800412', '2', '手机', '3', '3');

-- ----------------------------
-- Table structure for bmh_order_manage
-- ----------------------------
DROP TABLE IF EXISTS `bmh_order_manage`;
CREATE TABLE `bmh_order_manage` (
  `id` varchar(50) NOT NULL,
  `order_typ` varchar(50) DEFAULT NULL COMMENT '快递商家',
  `order_num` varchar(50) DEFAULT NULL COMMENT '快递单号',
  `vip_name` varchar(50) DEFAULT NULL COMMENT '客户姓名',
  `phone_num` varchar(100) DEFAULT NULL COMMENT '手机号',
  `province` varchar(20) DEFAULT NULL COMMENT '客户省份',
  `city` varchar(20) DEFAULT NULL COMMENT '客户城市',
  `create_user` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `award_times` int(5) DEFAULT '0' COMMENT '抽奖次数',
  `price_num` varchar(5) DEFAULT NULL COMMENT '中奖号码',
  `is_del` int(2) DEFAULT '0' COMMENT '是否已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bmh_order_manage
-- ----------------------------
INSERT INTO `bmh_order_manage` VALUES ('012db728-c923-11e8-8d18-a81e845c032c', '6', '6', '6', '17823455432', '6', '6', 'admin', '1538803297', '75', null, '0');
INSERT INTO `bmh_order_manage` VALUES ('1', '2', '2', '2', '17826800412', '2', '2', 'admin', '1538802746', '84', '1', '0');
INSERT INTO `bmh_order_manage` VALUES ('2', '3', '4', '4', '5', '5', '5', 'admin', '1538802253', '67', null, '0');
INSERT INTO `bmh_order_manage` VALUES ('8b23d0ce-c7a2-11e8-8d18-a81e845c032c', '4', '4', '4', '12345678901', '4', '4', 'admin', '1538802624', '21', '1', '0');
INSERT INTO `bmh_order_manage` VALUES ('cab44a61-c95c-11e8-8d18-a81e845c032c', '12', '12', '12', '12', '12', '12', 'admin', '1538826083', '12', '12', '0');

-- ----------------------------
-- Table structure for bmh_prize
-- ----------------------------
DROP TABLE IF EXISTS `bmh_prize`;
CREATE TABLE `bmh_prize` (
  `id` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL COMMENT '奖品名称',
  `pic_url` varchar(100) DEFAULT NULL COMMENT '奖品图片地址',
  `sort` int(2) DEFAULT '0' COMMENT '排序',
  `user_id` varchar(50) DEFAULT NULL COMMENT '创建人',
  `user_name` varchar(50) DEFAULT NULL COMMENT '创建人名称',
  `create_time` int(20) DEFAULT NULL COMMENT '创建时间',
  `is_del` int(2) DEFAULT '0' COMMENT '是否显示（1：是 0：否）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bmh_prize
-- ----------------------------
INSERT INTO `bmh_prize` VALUES ('0a558536-c95e-11e8-8d18-a81e845c032c', '520现金红包', 'upload/pricePic/VfNSSmGQMk.png', '5', 'admin', null, '1538826620', '1');
INSERT INTO `bmh_prize` VALUES ('1f384577-c95e-11e8-8d18-a81e845c032c', '谢谢参与', 'upload/pricePic/lpdISmqGff.png', '6', 'admin', null, '1538826655', '1');
INSERT INTO `bmh_prize` VALUES ('3b7299e9-c95e-11e8-8d18-a81e845c032c', '再接再励', 'upload/pricePic/BFnIImqraW.png', '7', 'admin', null, '1538826702', '1');
INSERT INTO `bmh_prize` VALUES ('4788310e-c95e-11e8-8d18-a81e845c032c', '手机号', 'upload/pricePic/bPdsSMGRcC.png', '8', 'admin', null, '1538826722', '1');
INSERT INTO `bmh_prize` VALUES ('6b837ea1-c95d-11e8-8d18-a81e845c032c', '888现金红包', 'upload/pricePic/VPDSswqnPN.png', '4', 'admin', null, '1538826353', '1');
INSERT INTO `bmh_prize` VALUES ('7f477a42-c959-11e8-8d18-a81e845c032c', 'iphone8 plus 一台', 'upload/pricePic/lPDSSWoGgi.png', '1', 'admin', null, '1538824668', '1');
INSERT INTO `bmh_prize` VALUES ('8476a313-c95c-11e8-8d18-a81e845c032c', '苹果笔记本', 'upload/pricePic/vpNsICFJQg.png', '2', 'admin', null, '1538825966', '1');
INSERT INTO `bmh_prize` VALUES ('a3ec0653-c95c-11e8-8d18-a81e845c032c', '苹果Ipad', 'upload/pricePic/LpDsscgAls.png', '3', 'admin', null, '1538826018', '1');

-- ----------------------------
-- Table structure for bmh_video_info
-- ----------------------------
DROP TABLE IF EXISTS `bmh_video_info`;
CREATE TABLE `bmh_video_info` (
  `id` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '视频主键',
  `video_type` varchar(6) CHARACTER SET utf8 DEFAULT '' COMMENT '视频类型',
  `video_name` varchar(50) CHARACTER SET utf8 DEFAULT '' COMMENT '视频名称',
  `video_time` varchar(10) CHARACTER SET utf8 DEFAULT '' COMMENT '视频时长',
  `video_size` int(15) DEFAULT '0' COMMENT '视频大小',
  `video_url` varchar(50) CHARACTER SET utf8 DEFAULT '' COMMENT '视频资源路径',
  `video_pic` varchar(50) CHARACTER SET utf8 DEFAULT '' COMMENT '视频封面图',
  `upload_user` varchar(30) CHARACTER SET utf8 DEFAULT '' COMMENT '上传人',
  `create_time` int(20) DEFAULT NULL COMMENT '上传时间',
  `is_deleted` tinyint(2) DEFAULT '0' COMMENT '是否已删除（0 未删除，1 已删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of bmh_video_info
-- ----------------------------

-- ----------------------------
-- Table structure for schedule_job
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job`;
CREATE TABLE `schedule_job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
  `method_name` varchar(100) DEFAULT NULL COMMENT '方法名',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `cron_expression` varchar(100) DEFAULT NULL COMMENT 'cron表达式',
  `status` tinyint(4) DEFAULT NULL COMMENT '任务状态',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务';

-- ----------------------------
-- Records of schedule_job
-- ----------------------------

-- ----------------------------
-- Table structure for schedule_job_log
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job_log`;
CREATE TABLE `schedule_job_log` (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志id',
  `job_id` bigint(20) NOT NULL COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
  `method_name` varchar(100) DEFAULT NULL COMMENT '方法名',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `status` tinyint(4) NOT NULL COMMENT '任务状态    0：成功    1：失败',
  `error` varchar(2000) DEFAULT NULL COMMENT '失败信息',
  `times` int(11) NOT NULL COMMENT '耗时(单位：毫秒)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`log_id`),
  KEY `job_id` (`job_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务日志';

-- ----------------------------
-- Records of schedule_job_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `key` varchar(50) DEFAULT NULL COMMENT 'key',
  `value` varchar(2000) DEFAULT NULL COMMENT 'value',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态   0：隐藏   1：显示',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key` (`key`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统配置信息表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('1', 'CLOUD_STORAGE_CONFIG_KEY', '{\"aliyunAccessKeyId\":\"\",\"aliyunAccessKeySecret\":\"\",\"aliyunBucketName\":\"\",\"aliyunDomain\":\"\",\"aliyunEndPoint\":\"\",\"aliyunPrefix\":\"\",\"qcloudBucketName\":\"\",\"qcloudDomain\":\"\",\"qcloudPrefix\":\"\",\"qcloudSecretId\":\"\",\"qcloudSecretKey\":\"\",\"qiniuAccessKey\":\"NrgMfABZxWLo5B-YYSjoE8-AZ1EISdi1Z3ubLOeZ\",\"qiniuBucketName\":\"ios-app\",\"qiniuDomain\":\"http://7xqbwh.dl1.z0.glb.clouddn.com\",\"qiniuPrefix\":\"upload\",\"qiniuSecretKey\":\"uIwJHevMRWU0VLxFvgy0tAcOdGqasdtVlJkdy6vV\",\"type\":1}', '0', '云存储配置信息');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='系统日志';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1', 'admin', '暂停定时任务', 'com.baomihua.controller.ScheduleJobController.pause()', '[2,1]', '0:0:0:0:0:0:0:1', '2017-09-24 16:47:34');
INSERT INTO `sys_log` VALUES ('2', 'admin', '保存角色', 'com.baomihua.controller.SysRoleController.save()', '{\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22],\"remark\":\"2\",\"roleName\":\"2\"}', '0:0:0:0:0:0:0:1', '2017-10-25 16:11:25');
INSERT INTO `sys_log` VALUES ('3', 'admin', '保存菜单', 'com.baomihua.controller.SysMenuController.save()', '{\"name\":\"课程管理\",\"orderNum\":0,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":0}', '0:0:0:0:0:0:0:1', '2017-10-25 17:01:49');
INSERT INTO `sys_log` VALUES ('4', 'admin', '保存菜单', 'com.baomihua.controller.SysMenuController.save()', '{\"icon\":\"fa fa-book\",\"name\":\"授课计划管理\",\"orderNum\":2,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":0}', '0:0:0:0:0:0:0:1', '2017-10-25 17:06:48');
INSERT INTO `sys_log` VALUES ('5', 'admin', '保存菜单', 'com.baomihua.controller.SysMenuController.save()', '{\"icon\":\"fa fa-window-restore\",\"name\":\"教学大纲管理\",\"orderNum\":3,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":0}', '0:0:0:0:0:0:0:1', '2017-10-25 17:07:43');
INSERT INTO `sys_log` VALUES ('6', 'admin', '保存菜单', 'com.baomihua.controller.SysMenuController.save()', '{\"icon\":\"fa fa-bar-chart\",\"name\":\"学生成绩管理\",\"orderNum\":0,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":0}', '0:0:0:0:0:0:0:1', '2017-10-25 17:09:23');
INSERT INTO `sys_log` VALUES ('7', 'admin', '删除菜单', 'com.baomihua.controller.SysMenuController.delete()', '[31]', '0:0:0:0:0:0:0:1', '2017-10-25 17:09:33');
INSERT INTO `sys_log` VALUES ('8', 'admin', '修改菜单', 'com.baomihua.controller.SysMenuController.update()', '{\"icon\":\"fa fa-bar-chart\",\"menuId\":34,\"name\":\"学生成绩管理\",\"orderNum\":5,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":0}', '0:0:0:0:0:0:0:1', '2017-10-25 17:09:43');
INSERT INTO `sys_log` VALUES ('9', 'admin', '修改菜单', 'com.baomihua.controller.SysMenuController.update()', '{\"icon\":\"fa fa-cog\",\"menuId\":1,\"name\":\"系统管理\",\"orderNum\":99,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":0}', '0:0:0:0:0:0:0:1', '2017-10-25 17:10:14');
INSERT INTO `sys_log` VALUES ('10', 'admin', '修改菜单', 'com.baomihua.controller.SysMenuController.update()', '{\"icon\":\"fa fa-cog\",\"menuId\":1,\"name\":\"系统配置管理\",\"orderNum\":99,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":0}', '0:0:0:0:0:0:0:1', '2017-10-25 17:10:40');
INSERT INTO `sys_log` VALUES ('11', 'admin', '保存菜单', 'com.baomihua.controller.SysMenuController.save()', '{\"name\":\"班级列表\",\"orderNum\":0,\"parentId\":34,\"parentName\":\"学生成绩管理\",\"type\":1,\"url\":\"stuclassinfo/stuclassinfo.html\"}', '0:0:0:0:0:0:0:1', '2017-11-02 15:04:50');
INSERT INTO `sys_log` VALUES ('12', 'admin', '删除菜单', 'com.baomihua.controller.SysMenuController.delete()', '[35,32,33,34]', '0:0:0:0:0:0:0:1', '2018-09-27 16:29:32');
INSERT INTO `sys_log` VALUES ('13', 'admin', '保存菜单', 'com.baomihua.controller.SysMenuController.save()', '{\"name\":\"demo\",\"orderNum\":0,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":0}', '0:0:0:0:0:0:0:1', '2018-09-27 16:31:17');
INSERT INTO `sys_log` VALUES ('14', 'admin', '保存菜单', 'com.baomihua.controller.SysMenuController.save()', '{\"name\":\"demo演示\",\"orderNum\":0,\"parentId\":36,\"parentName\":\"demo\",\"type\":1}', '0:0:0:0:0:0:0:1', '2018-09-27 16:31:52');
INSERT INTO `sys_log` VALUES ('15', 'admin', '保存菜单', 'com.baomihua.controller.SysMenuController.save()', '{\"name\":\"demo演示\",\"orderNum\":0,\"parentId\":36,\"parentName\":\"demo\",\"type\":1,\"url\":\"/demo/demo.html\"}', '0:0:0:0:0:0:0:1', '2018-09-27 16:32:55');
INSERT INTO `sys_log` VALUES ('16', 'admin', '修改菜单', 'com.baomihua.controller.SysMenuController.update()', '{\"menuId\":37,\"name\":\"demo演示\",\"orderNum\":0,\"parentId\":36,\"parentName\":\"demo\",\"type\":1,\"url\":\"demo/demo.html\"}', '0:0:0:0:0:0:0:1', '2018-09-27 16:33:09');
INSERT INTO `sys_log` VALUES ('17', 'admin', '保存菜单', 'com.baomihua.controller.SysMenuController.save()', '{\"name\":\"水印制作\",\"orderNum\":0,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":1,\"url\":\"markPic/MarkPic.html\"}', '0:0:0:0:0:0:0:1', '2018-09-29 16:04:13');
INSERT INTO `sys_log` VALUES ('18', 'admin', '保存菜单', 'com.baomihua.controller.SysMenuController.save()', '{\"name\":\"抽奖设置\",\"orderNum\":0,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":0}', '0:0:0:0:0:0:0:1', '2018-10-02 17:22:39');
INSERT INTO `sys_log` VALUES ('19', 'admin', '保存菜单', 'com.baomihua.controller.SysMenuController.save()', '{\"name\":\"奖品列表管理\",\"orderNum\":0,\"parentId\":39,\"parentName\":\"抽奖设置\",\"type\":1,\"url\":\"/price/bmhprize.html\"}', '0:0:0:0:0:0:0:1', '2018-10-02 17:23:09');
INSERT INTO `sys_log` VALUES ('20', 'admin', '保存菜单', 'com.baomihua.controller.SysMenuController.save()', '{\"name\":\"奖品新增\",\"orderNum\":0,\"parentId\":40,\"parentName\":\"奖品列表管理\",\"perms\":\"bmhprize:save\",\"type\":2}', '0:0:0:0:0:0:0:1', '2018-10-02 17:24:03');
INSERT INTO `sys_log` VALUES ('21', 'admin', '保存菜单', 'com.baomihua.controller.SysMenuController.save()', '{\"name\":\"奖品编辑\",\"orderNum\":0,\"parentId\":40,\"parentName\":\"奖品列表管理\",\"perms\":\"bmhprize:update\",\"type\":2}', '0:0:0:0:0:0:0:1', '2018-10-02 17:24:24');
INSERT INTO `sys_log` VALUES ('22', 'admin', '保存菜单', 'com.baomihua.controller.SysMenuController.save()', '{\"name\":\"奖品管理\",\"orderNum\":0,\"parentId\":40,\"parentName\":\"奖品列表管理\",\"perms\":\"bmhprize:save;bmhprize:update;bmhprize:delete\",\"type\":2}', '0:0:0:0:0:0:0:1', '2018-10-02 17:25:08');
INSERT INTO `sys_log` VALUES ('23', 'admin', '删除菜单', 'com.baomihua.controller.SysMenuController.delete()', '[41,42]', '0:0:0:0:0:0:0:1', '2018-10-02 17:25:22');
INSERT INTO `sys_log` VALUES ('24', 'admin', '修改角色', 'com.baomihua.controller.SysRoleController.update()', '{\"createTime\":1508919085000,\"createUserId\":1,\"menuIdList\":[39,40,43,1,2,15,16,17,18,3,19,20,21,22],\"remark\":\"2\",\"roleId\":1,\"roleName\":\"2\"}', '0:0:0:0:0:0:0:1', '2018-10-02 17:25:31');
INSERT INTO `sys_log` VALUES ('25', 'admin', '修改角色', 'com.baomihua.controller.SysRoleController.update()', '{\"createTime\":1508919085000,\"createUserId\":1,\"menuIdList\":[36,37,38,39,40,43,1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,30,29,28],\"remark\":\"2\",\"roleId\":1,\"roleName\":\"2\"}', '0:0:0:0:0:0:0:1', '2018-10-02 17:25:55');
INSERT INTO `sys_log` VALUES ('26', 'admin', '保存菜单', 'com.baomihua.controller.SysMenuController.save()', '{\"name\":\"抽奖人员设置\",\"orderNum\":0,\"parentId\":39,\"parentName\":\"抽奖设置\",\"perms\":\"bmhordermanage:save,bmhordermanage:update,bmhordermanage:delete\",\"type\":1,\"url\":\"/generator/bmhordermanage.html\"}', '0:0:0:0:0:0:0:1', '2018-10-04 14:54:58');
INSERT INTO `sys_log` VALUES ('27', 'admin', '修改角色', 'com.baomihua.controller.SysRoleController.update()', '{\"createTime\":1508919085000,\"createUserId\":1,\"menuIdList\":[36,37,38,39,40,43,44,1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,30,29,28],\"remark\":\"2\",\"roleId\":1,\"roleName\":\"2\"}', '0:0:0:0:0:0:0:1', '2018-10-04 14:56:26');
INSERT INTO `sys_log` VALUES ('28', 'admin', '保存角色', 'com.baomihua.controller.SysRoleController.save()', '{\"menuIdList\":[39,40,43,44],\"remark\":\"普通用户\",\"roleName\":\"普通用户\"}', '0:0:0:0:0:0:0:1', '2018-10-04 15:03:00');
INSERT INTO `sys_log` VALUES ('29', 'admin', '保存用户', 'com.baomihua.controller.SysUserController.save()', '{\"mobile\":\"\",\"roleIdList\":[2],\"status\":1,\"username\":\"baomihua_01\"}', '0:0:0:0:0:0:0:1', '2018-10-04 15:03:30');
INSERT INTO `sys_log` VALUES ('30', 'admin', '保存用户', 'com.baomihua.controller.SysUserController.save()', '{\"email\":\"123@123.com\",\"mobile\":\"\",\"roleIdList\":[2],\"status\":1,\"username\":\"baomihua_01\"}', '0:0:0:0:0:0:0:1', '2018-10-04 15:03:38');
INSERT INTO `sys_log` VALUES ('31', 'admin', '修改角色', 'com.baomihua.controller.SysRoleController.update()', '{\"createTime\":1508919085000,\"createUserId\":1,\"menuIdList\":[36,37,38,39,40,43,44,1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,30,29,28],\"remark\":\"2\",\"roleId\":1,\"roleName\":\"2\"}', '0:0:0:0:0:0:0:1', '2018-10-04 17:35:49');
INSERT INTO `sys_log` VALUES ('32', 'admin', '修改菜单', 'com.baomihua.controller.SysMenuController.update()', '{\"menuId\":44,\"name\":\"抽奖人员设置\",\"orderNum\":0,\"parentId\":39,\"parentName\":\"抽奖设置\",\"perms\":\"bmhordermanage:list,bmhordermanage:save,bmhordermanage:update,bmhordermanage:delete\",\"type\":1,\"url\":\"/generator/bmhordermanage.html\"}', '0:0:0:0:0:0:0:1', '2018-10-04 17:36:52');
INSERT INTO `sys_log` VALUES ('33', 'admin', '修改菜单', 'com.baomihua.controller.SysMenuController.update()', '{\"menuId\":44,\"name\":\"抽奖人员设置\",\"orderNum\":0,\"parentId\":39,\"parentName\":\"抽奖设置\",\"perms\":\"bmhordermanage:list,bmhordermanage:save,bmhordermanage:update,bmhordermanage:delete,bmhordermanage:info\",\"type\":1,\"url\":\"/generator/bmhordermanage.html\"}', '0:0:0:0:0:0:0:1', '2018-10-04 17:38:52');
INSERT INTO `sys_log` VALUES ('34', 'admin', '保存菜单', 'com.baomihua.controller.SysMenuController.save()', '{\"name\":\"抽奖活动页面\",\"orderNum\":0,\"parentId\":39,\"parentName\":\"抽奖设置\",\"type\":1,\"url\":\"price/award.html\"}', '0:0:0:0:0:0:0:1', '2018-10-05 15:27:03');
INSERT INTO `sys_log` VALUES ('35', 'admin', '修改菜单', 'com.baomihua.controller.SysMenuController.update()', '{\"menuId\":45,\"name\":\"抽奖活动页面\",\"orderNum\":0,\"parentId\":39,\"parentName\":\"抽奖设置\",\"type\":1,\"url\":\"/price/award.html\"}', '0:0:0:0:0:0:0:1', '2018-10-05 15:28:28');
INSERT INTO `sys_log` VALUES ('36', 'admin', '保存菜单', 'com.baomihua.controller.SysMenuController.save()', '{\"name\":\"抽奖页面\",\"orderNum\":0,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":1,\"url\":\"award/award.html\"}', '0:0:0:0:0:0:0:1', '2018-10-06 14:12:53');
INSERT INTO `sys_log` VALUES ('37', 'admin', '保存菜单', 'com.baomihua.controller.SysMenuController.save()', '{\"name\":\"抽奖记录\",\"orderNum\":0,\"parentId\":39,\"parentName\":\"抽奖设置\",\"perms\":\"bmhawardlog:save,bmhawardlog:list,bmhawardlog:delete,bmhawardlog:info,bmhawardlog:update\",\"type\":1,\"url\":\"generator/awardlog.html\"}', '0:0:0:0:0:0:0:1', '2018-10-06 19:07:27');
INSERT INTO `sys_log` VALUES ('38', 'admin', '修改角色', 'com.baomihua.controller.SysRoleController.update()', '{\"createTime\":1508919085000,\"createUserId\":1,\"menuIdList\":[36,37,38,39,40,43,44,45,47,1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,30,29,28],\"remark\":\"2\",\"roleId\":1,\"roleName\":\"2\"}', '0:0:0:0:0:0:0:1', '2018-10-06 19:07:36');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '系统配置管理', null, null, '0', 'fa fa-cog', '99');
INSERT INTO `sys_menu` VALUES ('2', '1', '管理员列表', 'sys/user.html', null, '1', 'fa fa-user', '1');
INSERT INTO `sys_menu` VALUES ('3', '1', '角色管理', 'sys/role.html', null, '1', 'fa fa-user-secret', '2');
INSERT INTO `sys_menu` VALUES ('4', '1', '菜单管理', 'sys/menu.html', null, '1', 'fa fa-th-list', '3');
INSERT INTO `sys_menu` VALUES ('5', '1', 'SQL监控', 'druid/sql.html', null, '1', 'fa fa-bug', '4');
INSERT INTO `sys_menu` VALUES ('6', '1', '定时任务', 'sys/schedule.html', null, '1', 'fa fa-tasks', '5');
INSERT INTO `sys_menu` VALUES ('7', '6', '查看', null, 'sys:schedule:list,sys:schedule:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('8', '6', '新增', null, 'sys:schedule:save', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('9', '6', '修改', null, 'sys:schedule:update', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('10', '6', '删除', null, 'sys:schedule:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('11', '6', '暂停', null, 'sys:schedule:pause', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('12', '6', '恢复', null, 'sys:schedule:resume', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('13', '6', '立即执行', null, 'sys:schedule:run', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('14', '6', '日志列表', null, 'sys:schedule:log', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('15', '2', '查看', null, 'sys:user:list,sys:user:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('16', '2', '新增', null, 'sys:user:save,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('17', '2', '修改', null, 'sys:user:update,sys:role:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('18', '2', '删除', null, 'sys:user:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('19', '3', '查看', null, 'sys:role:list,sys:role:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('20', '3', '新增', null, 'sys:role:save,sys:menu:perms', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('21', '3', '修改', null, 'sys:role:update,sys:menu:perms', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('22', '3', '删除', null, 'sys:role:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('23', '4', '查看', null, 'sys:menu:list,sys:menu:info', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('24', '4', '新增', null, 'sys:menu:save,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('25', '4', '修改', null, 'sys:menu:update,sys:menu:select', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('26', '4', '删除', null, 'sys:menu:delete', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('27', '1', '参数管理', 'sys/config.html', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', '1', 'fa fa-sun-o', '6');
INSERT INTO `sys_menu` VALUES ('28', '1', '代码生成器', 'sys/generator.html', 'sys:generator:list,sys:generator:code', '1', 'fa fa-rocket', '8');
INSERT INTO `sys_menu` VALUES ('29', '1', '系统日志', 'sys/log.html', 'sys:log:list', '1', 'fa fa-file-text-o', '7');
INSERT INTO `sys_menu` VALUES ('30', '1', '文件上传', 'sys/oss.html', 'sys:oss:all', '1', 'fa fa-file-image-o', '6');
INSERT INTO `sys_menu` VALUES ('36', '0', 'demo', null, null, '0', null, '0');
INSERT INTO `sys_menu` VALUES ('37', '36', 'demo演示', 'demo/demo.html', null, '1', null, '0');
INSERT INTO `sys_menu` VALUES ('38', '0', '水印制作', 'markPic/MarkPic.html', null, '1', null, '0');
INSERT INTO `sys_menu` VALUES ('39', '0', '抽奖设置', null, null, '0', null, '0');
INSERT INTO `sys_menu` VALUES ('40', '39', '奖品列表管理', '/price/bmhprize.html', 'bmhprize:list,bmhprize:save,bmhprize:update,bmhprize:delete', '1', null, '0');
INSERT INTO `sys_menu` VALUES ('43', '40', '奖品管理', null, '', '2', null, '0');
INSERT INTO `sys_menu` VALUES ('44', '39', '抽奖人员设置', '/generator/bmhordermanage.html', 'bmhordermanage:list,bmhordermanage:save,bmhordermanage:update,bmhordermanage:delete,bmhordermanage:info', '1', null, '0');
INSERT INTO `sys_menu` VALUES ('45', '39', '抽奖活动页面', '/price/award.html', null, '1', null, '0');
INSERT INTO `sys_menu` VALUES ('46', '0', '抽奖页面', 'award/award.html', null, '1', null, '0');
INSERT INTO `sys_menu` VALUES ('47', '39', '抽奖记录', 'generator/awardlog.html', 'bmhawardlog:save,bmhawardlog:list,bmhawardlog:delete,bmhawardlog:info,bmhawardlog:update', '1', null, '0');

-- ----------------------------
-- Table structure for sys_oss
-- ----------------------------
DROP TABLE IF EXISTS `sys_oss`;
CREATE TABLE `sys_oss` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) DEFAULT NULL COMMENT 'URL地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件上传';

-- ----------------------------
-- Records of sys_oss
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '2', '2', '1', '2017-10-25 16:11:25');
INSERT INTO `sys_role` VALUES ('2', '普通用户', '普通用户', '1', '2018-10-04 15:03:00');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=179 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('99', '2', '39');
INSERT INTO `sys_role_menu` VALUES ('100', '2', '40');
INSERT INTO `sys_role_menu` VALUES ('101', '2', '43');
INSERT INTO `sys_role_menu` VALUES ('102', '2', '44');
INSERT INTO `sys_role_menu` VALUES ('140', '1', '36');
INSERT INTO `sys_role_menu` VALUES ('141', '1', '37');
INSERT INTO `sys_role_menu` VALUES ('142', '1', '38');
INSERT INTO `sys_role_menu` VALUES ('143', '1', '39');
INSERT INTO `sys_role_menu` VALUES ('144', '1', '40');
INSERT INTO `sys_role_menu` VALUES ('145', '1', '43');
INSERT INTO `sys_role_menu` VALUES ('146', '1', '44');
INSERT INTO `sys_role_menu` VALUES ('147', '1', '45');
INSERT INTO `sys_role_menu` VALUES ('148', '1', '47');
INSERT INTO `sys_role_menu` VALUES ('149', '1', '1');
INSERT INTO `sys_role_menu` VALUES ('150', '1', '2');
INSERT INTO `sys_role_menu` VALUES ('151', '1', '15');
INSERT INTO `sys_role_menu` VALUES ('152', '1', '16');
INSERT INTO `sys_role_menu` VALUES ('153', '1', '17');
INSERT INTO `sys_role_menu` VALUES ('154', '1', '18');
INSERT INTO `sys_role_menu` VALUES ('155', '1', '3');
INSERT INTO `sys_role_menu` VALUES ('156', '1', '19');
INSERT INTO `sys_role_menu` VALUES ('157', '1', '20');
INSERT INTO `sys_role_menu` VALUES ('158', '1', '21');
INSERT INTO `sys_role_menu` VALUES ('159', '1', '22');
INSERT INTO `sys_role_menu` VALUES ('160', '1', '4');
INSERT INTO `sys_role_menu` VALUES ('161', '1', '23');
INSERT INTO `sys_role_menu` VALUES ('162', '1', '24');
INSERT INTO `sys_role_menu` VALUES ('163', '1', '25');
INSERT INTO `sys_role_menu` VALUES ('164', '1', '26');
INSERT INTO `sys_role_menu` VALUES ('165', '1', '5');
INSERT INTO `sys_role_menu` VALUES ('166', '1', '6');
INSERT INTO `sys_role_menu` VALUES ('167', '1', '7');
INSERT INTO `sys_role_menu` VALUES ('168', '1', '8');
INSERT INTO `sys_role_menu` VALUES ('169', '1', '9');
INSERT INTO `sys_role_menu` VALUES ('170', '1', '10');
INSERT INTO `sys_role_menu` VALUES ('171', '1', '11');
INSERT INTO `sys_role_menu` VALUES ('172', '1', '12');
INSERT INTO `sys_role_menu` VALUES ('173', '1', '13');
INSERT INTO `sys_role_menu` VALUES ('174', '1', '14');
INSERT INTO `sys_role_menu` VALUES ('175', '1', '27');
INSERT INTO `sys_role_menu` VALUES ('176', '1', '30');
INSERT INTO `sys_role_menu` VALUES ('177', '1', '29');
INSERT INTO `sys_role_menu` VALUES ('178', '1', '28');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'root@renren.io', '13612345678', '1', '1', '2016-11-11 11:11:11');
INSERT INTO `sys_user` VALUES ('2', 'baomihua_01', '44ea8f9dd90ae5fcadf8a1b76d267b299f700adf777f6355adca9b0a246d0737', '123@123.com', '', '1', '1', '2018-10-04 15:03:38');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '2', '2');

-- ----------------------------
-- Table structure for tb_token
-- ----------------------------
DROP TABLE IF EXISTS `tb_token`;
CREATE TABLE `tb_token` (
  `user_id` bigint(20) NOT NULL,
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户Token';

-- ----------------------------
-- Records of tb_token
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `mobile` varchar(20) NOT NULL COMMENT '手机号',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'mark', '13612345678', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '2017-03-23 22:37:41');
