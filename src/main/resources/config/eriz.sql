/*
Navicat MySQL Data Transfer

Source Server         : localhostMySql
Source Server Version : 50612
Source Host           : localhost:3306
Source Database       : eriz

Target Server Type    : MYSQL
Target Server Version : 50612
File Encoding         : 65001

Date: 2019-01-21 09:12:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for app_demo_base
-- ----------------------------
DROP TABLE IF EXISTS `app_demo_base`;
CREATE TABLE `app_demo_base` (
  `id` bigint(20) NOT NULL COMMENT '编号',
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `publish` datetime DEFAULT NULL COMMENT '发布时间',
  `content` mediumtext COMMENT '正文',
  `deleted` bit(1) DEFAULT b'0' COMMENT '删除',
  `version` smallint(6) DEFAULT '0' COMMENT '版本',
  `createAt` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateAt` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `createBy` bigint(20) DEFAULT NULL COMMENT '创建者',
  `updateBy` bigint(20) DEFAULT NULL COMMENT '更新者',
  `price` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='基础表';

-- ----------------------------
-- Records of app_demo_base
-- ----------------------------
INSERT INTO `app_demo_base` VALUES ('1027118616500408321', 'Vue 2.0 Hello World', '2018-08-17 11:59:00', '这是我的征文', '\0', '7', '2018-08-08 17:05:35', '2018-08-22 15:34:46', '1', '1', null);

-- ----------------------------
-- Table structure for module_book
-- ----------------------------
DROP TABLE IF EXISTS `module_book`;
CREATE TABLE `module_book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) DEFAULT NULL COMMENT '书名',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `price` decimal(10,2) DEFAULT '0.00' COMMENT '价格',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='图书表';

-- ----------------------------
-- Records of module_book
-- ----------------------------

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `k` varchar(100) DEFAULT NULL COMMENT '键',
  `v` varchar(1000) DEFAULT NULL COMMENT '值',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `kvType` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('2', 'oss_qiniu', '{\"AccessKey\" : \"8-HMj9EgGNIP-xuOCpSzTn-OMyGOFtR3TxLdn4Uu\",\"SecretKey\" : \"SjpGg3V6PsMdJgn42PeEd5Ik-6aNyuwdqV5CPM6A\",\"bucket\" : \"ifast\",\"AccessUrl\" : \"http://p6r7ke2jc.bkt.clouddn.com/\"}', '七牛对象存储配置', '2018-04-06 14:31:26', '4300');
INSERT INTO `sys_config` VALUES ('3', 'author', 'eriz', '代码生成器配置', '2018-05-27 19:57:04', '4401');
INSERT INTO `sys_config` VALUES ('4', 'email', 'eriz@163.com', '代码生成器配置', '2018-05-27 19:57:04', '4401');
INSERT INTO `sys_config` VALUES ('5', 'package', 'com.eriz', '代码生成器配置', '2018-05-27 19:57:04', '4401');
INSERT INTO `sys_config` VALUES ('6', 'autoRemovePre', 'on', '代码生成器配置', '2018-05-27 19:57:04', '4401');
INSERT INTO `sys_config` VALUES ('7', 'tablePrefix', 'app', '代码生成器配置', '2018-05-27 19:57:04', '4401');
INSERT INTO `sys_config` VALUES ('8', 'tinyint', 'Integer', '代码生成器配置', '2018-05-27 19:57:04', '4400');
INSERT INTO `sys_config` VALUES ('9', 'smallint', 'Integer', '代码生成器配置', '2018-05-27 19:57:04', '4400');
INSERT INTO `sys_config` VALUES ('10', 'mediumint', 'Integer', '代码生成器配置', '2018-05-27 19:57:04', '4400');
INSERT INTO `sys_config` VALUES ('11', 'int', 'Integer', '代码生成器配置', '2018-05-27 19:57:04', '4400');
INSERT INTO `sys_config` VALUES ('12', 'integer', 'Integer', '代码生成器配置', '2018-05-27 19:57:04', '4400');
INSERT INTO `sys_config` VALUES ('13', 'bigint', 'Long', '代码生成器配置', '2018-05-27 19:57:04', '4400');
INSERT INTO `sys_config` VALUES ('14', 'float', 'Float', '代码生成器配置', '2018-05-27 19:57:04', '4400');
INSERT INTO `sys_config` VALUES ('15', 'double', 'Double', '代码生成器配置', '2018-05-27 19:57:04', '4400');
INSERT INTO `sys_config` VALUES ('16', 'decimal', 'BigDecimal', '代码生成器配置', '2018-05-27 19:57:04', '4400');
INSERT INTO `sys_config` VALUES ('17', 'bit', 'Boolean', '代码生成器配置', '2018-05-27 19:57:04', '4400');
INSERT INTO `sys_config` VALUES ('18', 'char', 'String', '代码生成器配置', '2018-05-27 19:57:04', '4400');
INSERT INTO `sys_config` VALUES ('19', 'varchar', 'String', '代码生成器配置', '2018-05-27 19:57:04', '4400');
INSERT INTO `sys_config` VALUES ('20', 'tinytext', 'String', '代码生成器配置', '2018-05-27 19:57:04', '4400');
INSERT INTO `sys_config` VALUES ('21', 'text', 'String', '代码生成器配置', '2018-05-27 19:57:04', '4400');
INSERT INTO `sys_config` VALUES ('22', 'mediumtext', 'String', '代码生成器配置', '2018-05-27 19:57:04', '4400');
INSERT INTO `sys_config` VALUES ('23', 'longtext', 'String', '代码生成器配置', '2018-05-27 19:57:04', '4400');
INSERT INTO `sys_config` VALUES ('24', 'date', 'Date', '代码生成器配置', '2018-05-27 19:57:04', '4400');
INSERT INTO `sys_config` VALUES ('25', 'datetime', 'Date', '代码生成器配置', '2018-05-27 19:57:04', '4400');
INSERT INTO `sys_config` VALUES ('26', 'timestamp', 'Date', '代码生成器配置', '2018-05-27 19:57:04', '4400');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parentId` bigint(20) DEFAULT NULL COMMENT '上级部门ID，一级部门为0',
  `name` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `orderNum` int(11) DEFAULT NULL COMMENT '排序',
  `delFlag` tinyint(4) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='部门管理';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('6', '0', '研发部', '1', '1');
INSERT INTO `sys_dept` VALUES ('7', '6', '研发一部', '1', '1');
INSERT INTO `sys_dept` VALUES ('8', '6', '研发二部', '2', '1');
INSERT INTO `sys_dept` VALUES ('9', '0', '销售部', '2', '1');
INSERT INTO `sys_dept` VALUES ('11', '0', '产品部', '3', '1');
INSERT INTO `sys_dept` VALUES ('12', '11', '产品一部', '1', '1');
INSERT INTO `sys_dept` VALUES ('13', '0', '测试部', '5', '1');
INSERT INTO `sys_dept` VALUES ('14', '13', '测试一部', '1', '1');
INSERT INTO `sys_dept` VALUES ('15', '13', '测试二部', '2', '1');
INSERT INTO `sys_dept` VALUES ('16', '9', '销售一部', '0', '1');
INSERT INTO `sys_dept` VALUES ('18', '13', '测试三部', '1', '1');
INSERT INTO `sys_dept` VALUES ('19', '0', '测试根部门', '1', '1');
INSERT INTO `sys_dept` VALUES ('21', '13', '研发一部测试搜索', '1', '1');

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '标签名',
  `value` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '数据值',
  `type` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '类型',
  `description` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `sort` decimal(10,0) DEFAULT NULL COMMENT '排序（升序）',
  `parentId` bigint(64) DEFAULT '0' COMMENT '父级编号',
  `createBy` int(64) DEFAULT NULL COMMENT '创建者',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `updateBy` bigint(64) DEFAULT NULL COMMENT '更新者',
  `updateDate` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注信息',
  `delFlag` int(1) DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_dict_value` (`value`),
  KEY `sys_dict_label` (`name`),
  KEY `sys_dict_del_flag` (`delFlag`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='字典表';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('1', '正常', '0', 'del_flag', '删除标记', '10', '0', '1', null, '1', null, '测试备注', '0');
INSERT INTO `sys_dict` VALUES ('3', '显示', '1', 'show_hide', '显示/隐藏', '10', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('4', '隐藏', '0', 'show_hide', '显示/隐藏', '20', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('5', '是', '1', 'yes_no', '是/否', '10', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('6', '否', '0', 'yes_no', '是/否', '20', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('7', '红色', 'red', 'color', '颜色值', '10', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('8', '绿色', 'green', 'color', '颜色值', '20', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('9', '蓝色', 'blue', 'color', '颜色值', '30', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('10', '黄色', 'yellow', 'color', '颜色值', '40', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('11', '橙色', 'orange', 'color', '颜色值', '50', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('12', '默认主题', 'default', 'theme', '主题方案', '10', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('13', '天蓝主题', 'cerulean', 'theme', '主题方案', '20', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('14', '橙色主题', 'readable', 'theme', '主题方案', '30', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('15', '红色主题', 'united', 'theme', '主题方案', '40', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('16', 'Flat主题', 'flat', 'theme', '主题方案', '60', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('17', '国家', '1', 'sys_area_type', '区域类型', '10', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('18', '省份、直辖市', '2', 'sys_area_type', '区域类型', '20', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('19', '地市', '3', 'sys_area_type', '区域类型', '30', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('20', '区县', '4', 'sys_area_type', '区域类型', '40', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('21', '公司', '1', 'sys_office_type', '机构类型', '60', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('22', '部门', '2', 'sys_office_type', '机构类型', '70', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('23', '小组', '3', 'sys_office_type', '机构类型', '80', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('24', '其它', '4', 'sys_office_type', '机构类型', '90', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('25', '综合部', '1', 'sys_office_common', '快捷通用部门', '30', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('26', '开发部', '2', 'sys_office_common', '快捷通用部门', '40', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('27', '人力部', '3', 'sys_office_common', '快捷通用部门', '50', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('28', '一级', '1', 'sys_office_grade', '机构等级', '10', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('29', '二级', '2', 'sys_office_grade', '机构等级', '20', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('30', '三级', '3', 'sys_office_grade', '机构等级', '30', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('31', '四级', '4', 'sys_office_grade', '机构等级', '40', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('32', '所有数据', '1', 'sys_data_scope', '数据范围', '10', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('33', '所在公司及以下数据', '2', 'sys_data_scope', '数据范围', '20', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('34', '所在公司数据', '3', 'sys_data_scope', '数据范围', '30', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('35', '所在部门及以下数据', '4', 'sys_data_scope', '数据范围', '40', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('36', '所在部门数据', '5', 'sys_data_scope', '数据范围', '50', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('37', '仅本人数据', '8', 'sys_data_scope', '数据范围', '90', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('38', '按明细设置', '9', 'sys_data_scope', '数据范围', '100', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('39', '系统管理', '1', 'sys_user_type', '用户类型', '10', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('40', '部门经理', '2', 'sys_user_type', '用户类型', '20', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('41', '普通用户', '3', 'sys_user_type', '用户类型', '30', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('42', '基础主题', 'basic', 'cms_theme', '站点主题', '10', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('43', '蓝色主题', 'blue', 'cms_theme', '站点主题', '20', '0', '1', null, '1', null, null, '1');
INSERT INTO `sys_dict` VALUES ('44', '红色主题', 'red', 'cms_theme', '站点主题', '30', '0', '1', null, '1', null, null, '1');
INSERT INTO `sys_dict` VALUES ('45', '文章模型', 'article', 'cms_module', '栏目模型', '10', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('46', '图片模型', 'picture', 'cms_module', '栏目模型', '20', '0', '1', null, '1', null, null, '1');
INSERT INTO `sys_dict` VALUES ('47', '下载模型', 'download', 'cms_module', '栏目模型', '30', '0', '1', null, '1', null, null, '1');
INSERT INTO `sys_dict` VALUES ('48', '链接模型', 'link', 'cms_module', '栏目模型', '40', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('49', '专题模型', 'special', 'cms_module', '栏目模型', '50', '0', '1', null, '1', null, null, '1');
INSERT INTO `sys_dict` VALUES ('50', '默认展现方式', '0', 'cms_show_modes', '展现方式', '10', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('51', '首栏目内容列表', '1', 'cms_show_modes', '展现方式', '20', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('52', '栏目第一条内容', '2', 'cms_show_modes', '展现方式', '30', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('53', '发布', '0', 'cms_del_flag', '内容状态', '10', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('54', '删除', '1', 'cms_del_flag', '内容状态', '20', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('55', '审核', '2', 'cms_del_flag', '内容状态', '15', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('56', '首页焦点图', '1', 'cms_posid', '推荐位', '10', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('57', '栏目页文章推荐', '2', 'cms_posid', '推荐位', '20', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('58', '咨询', '1', 'cms_guestbook', '留言板分类', '10', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('59', '建议', '2', 'cms_guestbook', '留言板分类', '20', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('60', '投诉', '3', 'cms_guestbook', '留言板分类', '30', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('61', '其它', '4', 'cms_guestbook', '留言板分类', '40', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('62', '公休', '1', 'oa_leave_type', '请假类型', '10', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('63', '病假', '2', 'oa_leave_type', '请假类型', '20', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('64', '事假', '3', 'oa_leave_type', '请假类型', '30', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('65', '调休', '4', 'oa_leave_type', '请假类型', '40', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('66', '婚假', '5', 'oa_leave_type', '请假类型', '60', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('67', '接入日志', '1', 'sys_log_type', '日志类型', '30', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('68', '异常日志', '2', 'sys_log_type', '日志类型', '40', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('69', '请假流程', 'leave', 'act_type', '流程类型', '10', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('70', '审批测试流程', 'test_audit', 'act_type', '流程类型', '20', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('71', '分类1', '1', 'act_category', '流程分类', '10', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('72', '分类2', '2', 'act_category', '流程分类', '20', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('73', '增删改查', 'crud', 'gen_category', '代码生成分类', '10', '0', '1', null, '1', null, null, '1');
INSERT INTO `sys_dict` VALUES ('74', '增删改查（包含从表）', 'crud_many', 'gen_category', '代码生成分类', '20', '0', '1', null, '1', null, null, '1');
INSERT INTO `sys_dict` VALUES ('75', '树结构', 'tree', 'gen_category', '代码生成分类', '30', '0', '1', null, '1', null, null, '1');
INSERT INTO `sys_dict` VALUES ('76', '=', '=', 'gen_query_type', '查询方式', '10', '0', '1', null, '1', null, null, '1');
INSERT INTO `sys_dict` VALUES ('77', '!=', '!=', 'gen_query_type', '查询方式', '20', '0', '1', null, '1', null, null, '1');
INSERT INTO `sys_dict` VALUES ('78', '&gt;', '&gt;', 'gen_query_type', '查询方式', '30', '0', '1', null, '1', null, null, '1');
INSERT INTO `sys_dict` VALUES ('79', '&lt;', '&lt;', 'gen_query_type', '查询方式', '40', '0', '1', null, '1', null, null, '1');
INSERT INTO `sys_dict` VALUES ('80', 'Between', 'between', 'gen_query_type', '查询方式', '50', '0', '1', null, '1', null, null, '1');
INSERT INTO `sys_dict` VALUES ('81', 'Like', 'like', 'gen_query_type', '查询方式', '60', '0', '1', null, '1', null, null, '1');
INSERT INTO `sys_dict` VALUES ('82', 'Left Like', 'left_like', 'gen_query_type', '查询方式', '70', '0', '1', null, '1', null, null, '1');
INSERT INTO `sys_dict` VALUES ('83', 'Right Like', 'right_like', 'gen_query_type', '查询方式', '80', '0', '1', null, '1', null, null, '1');
INSERT INTO `sys_dict` VALUES ('84', '文本框', 'input', 'gen_show_type', '字段生成方案', '10', '0', '1', null, '1', null, null, '1');
INSERT INTO `sys_dict` VALUES ('85', '文本域', 'textarea', 'gen_show_type', '字段生成方案', '20', '0', '1', null, '1', null, null, '1');
INSERT INTO `sys_dict` VALUES ('86', '下拉框', 'select', 'gen_show_type', '字段生成方案', '30', '0', '1', null, '1', null, null, '1');
INSERT INTO `sys_dict` VALUES ('87', '复选框', 'checkbox', 'gen_show_type', '字段生成方案', '40', '0', '1', null, '1', null, null, '1');
INSERT INTO `sys_dict` VALUES ('88', '单选框', 'radiobox', 'gen_show_type', '字段生成方案', '50', '0', '1', null, '1', null, null, '1');
INSERT INTO `sys_dict` VALUES ('89', '日期选择', 'dateselect', 'gen_show_type', '字段生成方案', '60', '0', '1', null, '1', null, null, '1');
INSERT INTO `sys_dict` VALUES ('90', '人员选择', 'userselect', 'gen_show_type', '字段生成方案', '70', '0', '1', null, '1', null, null, '1');
INSERT INTO `sys_dict` VALUES ('91', '部门选择', 'officeselect', 'gen_show_type', '字段生成方案', '80', '0', '1', null, '1', null, null, '1');
INSERT INTO `sys_dict` VALUES ('92', '区域选择', 'areaselect', 'gen_show_type', '字段生成方案', '90', '0', '1', null, '1', null, null, '1');
INSERT INTO `sys_dict` VALUES ('93', 'String', 'String', 'gen_java_type', 'Java类型', '10', '0', '1', null, '1', null, null, '1');
INSERT INTO `sys_dict` VALUES ('94', 'Long', 'Long', 'gen_java_type', 'Java类型', '20', '0', '1', null, '1', null, null, '1');
INSERT INTO `sys_dict` VALUES ('95', '仅持久层', 'dao', 'gen_category', '代码生成分类\0\0', '40', '0', '1', null, '1', null, null, '1');
INSERT INTO `sys_dict` VALUES ('96', '男', '1', 'sex', '性别', '10', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('97', '女', '2', 'sex', '性别', '20', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('98', 'Integer', 'Integer', 'gen_java_type', 'Java类型', '30', '0', '1', null, '1', null, null, '1');
INSERT INTO `sys_dict` VALUES ('99', 'Double', 'Double', 'gen_java_type', 'Java类型', '40', '0', '1', null, '1', null, null, '1');
INSERT INTO `sys_dict` VALUES ('100', 'Date', 'java.util.Date', 'gen_java_type', 'Java类型', '50', '0', '1', null, '1', null, null, '1');
INSERT INTO `sys_dict` VALUES ('104', 'Custom', 'Custom', 'gen_java_type', 'Java类型', '90', '0', '1', null, '1', null, null, '1');
INSERT INTO `sys_dict` VALUES ('105', '会议通告', '1', 'oa_notify_type', '通知通告类型', '10', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('106', '奖惩通告', '2', 'oa_notify_type', '通知通告类型', '20', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('107', '活动通告', '3', 'oa_notify_type', '通知通告类型', '30', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('108', '草稿', '0', 'oa_notify_status', '通知通告状态', '10', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('109', '发布', '1', 'oa_notify_status', '通知通告状态', '20', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('110', '未读', '0', 'oa_notify_read', '通知通告状态', '10', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('111', '已读', '1', 'oa_notify_read', '通知通告状态', '20', '0', '1', null, '1', null, null, '0');
INSERT INTO `sys_dict` VALUES ('112', '草稿', '0', 'oa_notify_status', '通知通告状态', '10', '0', '1', null, '1', null, '', '0');
INSERT INTO `sys_dict` VALUES ('113', '删除', '0', 'del_flag', '删除标记', null, null, null, null, null, null, '', '0');
INSERT INTO `sys_dict` VALUES ('118', '关于', 'about', 'blog_type', '博客类型', null, null, null, null, null, null, '全url是:/blog/open/page/about', '0');
INSERT INTO `sys_dict` VALUES ('119', '交流', 'communication', 'blog_type', '博客类型', null, null, null, null, null, null, '', '0');
INSERT INTO `sys_dict` VALUES ('120', '文章', 'article', 'blog_type', '博客类型', null, null, null, null, null, null, '', '0');
INSERT INTO `sys_dict` VALUES ('121', '正常1', '01', 'del_flag1', '删除标记1', '101', '0', null, null, null, null, '测试备注', '0');
INSERT INTO `sys_dict` VALUES ('122', '正常1', '01', 'del_flag1', '删除标记1', '101', '0', null, null, null, null, '测试备注1', '0');

-- ----------------------------
-- Table structure for sys_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL COMMENT '文件类型',
  `url` varchar(200) DEFAULT NULL COMMENT 'URL地址',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件上传';

-- ----------------------------
-- Records of sys_file
-- ----------------------------

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL COMMENT '用户id',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `time` int(11) DEFAULT NULL COMMENT '响应时间',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `gmtCreate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1082572203033104440 DEFAULT CHARSET=utf8mb4 COMMENT='系统日志';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1073149354900017154', '1', 'admin', '登录', '49', 'POST /login', '{\"username\":[\"admin\"],\"password\":[\"1\"]}', '127.0.0.1', '2018-12-13 17:35:19');
INSERT INTO `sys_log` VALUES ('1077863231852232825', '1', 'admin', '登陆', '41', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"mwed\"]}', '127.0.0.1', '2018-12-29 13:19:22');
INSERT INTO `sys_log` VALUES ('1077863231852232826', '1', 'admin', '登陆', '1525', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"fc8a\"]}', '127.0.0.1', '2019-01-02 11:18:37');
INSERT INTO `sys_log` VALUES ('1077863231852232827', '1', 'admin', '登陆', '90', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"fc8a\"]}', '127.0.0.1', '2019-01-02 11:20:16');
INSERT INTO `sys_log` VALUES ('1077863231852232828', '1', 'admin', '用户管理', '1', 'POST /sys/online/list', '{\"page\":[\"1\"],\"limit\":[\"10\"]}', '127.0.0.1', '2019-01-02 11:20:20');
INSERT INTO `sys_log` VALUES ('1077863231852232829', '1', 'admin', '登陆', '91', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"fc8a\"]}', '127.0.0.1', '2019-01-02 11:22:03');
INSERT INTO `sys_log` VALUES ('1077863231852232830', '1', 'admin', '登陆', '85', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"fc8a\"]}', '127.0.0.1', '2019-01-02 11:24:17');
INSERT INTO `sys_log` VALUES ('1077863231852232832', '1', 'admin', '登陆', '81', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"fc8a\"]}', '127.0.0.1', '2019-01-02 11:59:26');
INSERT INTO `sys_log` VALUES ('1077863231852232833', '1', 'admin', '登陆', '115', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"fc8a\"]}', '127.0.0.1', '2019-01-02 15:07:46');
INSERT INTO `sys_log` VALUES ('1077863231852232834', '1', 'admin', '登陆', '378', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"wnfw\"]}', '127.0.0.1', '2019-01-02 18:23:14');
INSERT INTO `sys_log` VALUES ('1077863231852232835', '1', 'admin', '登陆', '1044', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"wnfw\"]}', '127.0.0.1', '2019-01-02 18:23:14');
INSERT INTO `sys_log` VALUES ('1077863231852232836', '1', 'admin', '登陆', '7', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"wnfw\"]}', '127.0.0.1', '2019-01-02 18:25:51');
INSERT INTO `sys_log` VALUES ('1077863231852232837', '1', 'admin', '登陆', '89', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"wnfw\"]}', '127.0.0.1', '2019-01-03 09:01:31');
INSERT INTO `sys_log` VALUES ('1077863231852232838', '1', 'admin', '登陆', '191', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"a\"]}', '127.0.0.1', '2019-01-03 09:47:50');
INSERT INTO `sys_log` VALUES ('1077863231852232839', '1', 'admin', '登陆', '6', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"a\"]}', '127.0.0.1', '2019-01-03 10:00:35');
INSERT INTO `sys_log` VALUES ('1077863231852232840', '1', 'admin', '登陆', '71', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"a\"]}', '127.0.0.1', '2019-01-03 10:01:57');
INSERT INTO `sys_log` VALUES ('1077863231852232841', '1', 'admin', '登陆', '99', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"a\"]}', '127.0.0.1', '2019-01-03 10:05:26');
INSERT INTO `sys_log` VALUES ('1077863231852232842', '1', 'admin', '登陆', '71', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"a\"]}', '127.0.0.1', '2019-01-03 10:31:35');
INSERT INTO `sys_log` VALUES ('1077863231852232843', '1', 'admin', '登陆', '72', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"a\"]}', '127.0.0.1', '2019-01-03 10:32:42');
INSERT INTO `sys_log` VALUES ('1077863231852232844', '1', 'admin', '登陆', '112', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"a\"]}', '127.0.0.1', '2019-01-03 10:34:44');
INSERT INTO `sys_log` VALUES ('1077863231852232845', '1', 'admin', '登陆', '90', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"a\"]}', '127.0.0.1', '2019-01-03 10:59:44');
INSERT INTO `sys_log` VALUES ('1080662220293029890', '-1', '', '登录', '180', 'POST /login', '{\"username\":[\"admin\"],\"password\":[\"11\"]}', '127.0.0.1', '2019-01-03 11:08:45');
INSERT INTO `sys_log` VALUES ('1080662231718313986', '1', 'admin', '登录', '21', 'POST /login', '{\"username\":[\"admin\"],\"password\":[\"1\"]}', '127.0.0.1', '2019-01-03 11:08:48');
INSERT INTO `sys_log` VALUES ('1080662336898875393', '1', 'admin', '更新代码生成配置', '2666', 'POST /common/generator/update', '{\"author\":[\"Aron\"],\"email\":[\"eriz@163.com\"],\"package\":[\"com.eriz\"],\"autoRemovePre\":[\"on\"],\"tablePrefix\":[\"app\"],\"tinyint\":[\"Integer1\"],\"smallint\":[\"Integer\"],\"mediumint\":[\"Integer\"],\"int\":[\"Integer\"],\"integer\":[\"Integer\"],\"bigint\":[\"Long\"],\"float\":[\"Float\"],\"double\":[\"Double\"],\"decimal\":[\"BigDecimal\"],\"bit\":[\"Boolean\"],\"char\":[\"String\"],\"varchar\":[\"String\"],\"tinytext\":[\"String\"],\"text\":[\"String\"],\"mediumtext\":[\"String\"],\"longtext\":[\"String\"],\"date\":[\"Date\"],\"datetime\":[\"Date\"],\"timestamp\":[\"Date\"]}', '127.0.0.1', '2019-01-03 11:09:14');
INSERT INTO `sys_log` VALUES ('1080662424891179009', '1', 'admin', '更新代码生成配置', '1976', 'POST /common/generator/update', '{\"author\":[\"Aron\"],\"email\":[\"eriz@163.com\"],\"package\":[\"com.eriz\"],\"autoRemovePre\":[\"on\"],\"tablePrefix\":[\"app\"],\"tinyint\":[\"Integer\"],\"smallint\":[\"Integer\"],\"mediumint\":[\"Integer\"],\"int\":[\"Integer\"],\"integer\":[\"Integer\"],\"bigint\":[\"Long\"],\"float\":[\"Float\"],\"double\":[\"Double\"],\"decimal\":[\"BigDecimal\"],\"bit\":[\"Boolean\"],\"char\":[\"String\"],\"varchar\":[\"String\"],\"tinytext\":[\"String\"],\"text\":[\"String\"],\"mediumtext\":[\"String\"],\"longtext\":[\"String\"],\"date\":[\"Date\"],\"datetime\":[\"Date\"],\"timestamp\":[\"Date\"]}', '127.0.0.1', '2019-01-03 11:09:34');
INSERT INTO `sys_log` VALUES ('1080662917872893953', '1', 'admin', '更新代码生成配置', '89195', 'POST /common/generator/update', '{\"author\":[\"eriz\"],\"email\":[\"eriz@163.com\"],\"package\":[\"com.eriz\"],\"autoRemovePre\":[\"on\"],\"tablePrefix\":[\"app\"],\"tinyint\":[\"Integer1\"],\"smallint\":[\"Integer\"],\"mediumint\":[\"Integer\"],\"int\":[\"Integer\"],\"integer\":[\"Integer\"],\"bigint\":[\"Long\"],\"float\":[\"Float\"],\"double\":[\"Double\"],\"decimal\":[\"BigDecimal\"],\"bit\":[\"Boolean\"],\"char\":[\"String\"],\"varchar\":[\"String\"],\"tinytext\":[\"String\"],\"text\":[\"String\"],\"mediumtext\":[\"String\"],\"longtext\":[\"String\"],\"date\":[\"Date\"],\"datetime\":[\"Date\"],\"timestamp\":[\"Date\"]}', '127.0.0.1', '2019-01-03 11:11:32');
INSERT INTO `sys_log` VALUES ('1080662917872893954', '1', 'admin', '登陆', '12', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"a\"]}', '127.0.0.1', '2019-01-03 11:30:27');
INSERT INTO `sys_log` VALUES ('1080662917872893955', '1', 'admin', '登陆', '154', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"a\"]}', '127.0.0.1', '2019-01-03 11:35:44');
INSERT INTO `sys_log` VALUES ('1080662917872893956', '1', 'admin', '登陆', '88', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"a\"]}', '127.0.0.1', '2019-01-03 11:41:03');
INSERT INTO `sys_log` VALUES ('1080662917872893957', '1', 'admin', '登陆', '90', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"a\"]}', '127.0.0.1', '2019-01-03 11:46:09');
INSERT INTO `sys_log` VALUES ('1080662917872893958', '1', 'admin', '用户列表', '7', 'POST /sys/user/userList', '{\"deptId\":[\"\"]}', '127.0.0.1', '2019-01-03 11:46:29');
INSERT INTO `sys_log` VALUES ('1080662917872893959', '1', 'admin', '用户列表', '16', 'POST /sys/user/userList', '{\"deptId\":[\"12\"]}', '127.0.0.1', '2019-01-03 11:46:38');
INSERT INTO `sys_log` VALUES ('1080662917872893960', '1', 'admin', '用户列表', '13', 'POST /sys/user/userList', '{\"deptId\":[\"7\"]}', '127.0.0.1', '2019-01-03 11:46:39');
INSERT INTO `sys_log` VALUES ('1080662917872893961', '1', 'admin', '登陆', '33', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"a\"]}', '127.0.0.1', '2019-01-03 12:34:25');
INSERT INTO `sys_log` VALUES ('1080662917872893962', '1', 'admin', '登陆', '90', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"a\"]}', '127.0.0.1', '2019-01-03 14:23:28');
INSERT INTO `sys_log` VALUES ('1080662917872893963', '1', 'admin', '登陆', '87', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"a\"]}', '127.0.0.1', '2019-01-03 15:25:52');
INSERT INTO `sys_log` VALUES ('1080662917872893964', '1', 'admin', '登陆', '88', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"a\"]}', '127.0.0.1', '2019-01-03 15:29:07');
INSERT INTO `sys_log` VALUES ('1080662917872893965', '1', 'admin', '登陆', '12545', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"a\"]}', '127.0.0.1', '2019-01-03 15:30:05');
INSERT INTO `sys_log` VALUES ('1080662917872893966', '1', 'admin', '登陆', '5266', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"a\"]}', '127.0.0.1', '2019-01-03 15:33:18');
INSERT INTO `sys_log` VALUES ('1080662917872893967', '1', 'admin', '登陆', '16', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"a\"]}', '127.0.0.1', '2019-01-03 15:37:30');
INSERT INTO `sys_log` VALUES ('1080662917872893968', '1', 'admin', '登陆', '94', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"a\"]}', '127.0.0.1', '2019-01-03 15:43:39');
INSERT INTO `sys_log` VALUES ('1080662917872893969', '1', 'admin', '登陆', '99', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"a\"]}', '127.0.0.1', '2019-01-03 15:48:32');
INSERT INTO `sys_log` VALUES ('1080662917872893970', '1', 'admin', '登陆', '407', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"a\"]}', '127.0.0.1', '2019-01-04 09:11:41');
INSERT INTO `sys_log` VALUES ('1080662917872893971', '1', 'admin', '登陆', '9', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"a\"]}', '127.0.0.1', '2019-01-04 09:39:42');
INSERT INTO `sys_log` VALUES ('1080662917872893972', '1', 'admin', '登陆', '11', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"a\"]}', '127.0.0.1', '2019-01-04 10:36:26');
INSERT INTO `sys_log` VALUES ('1080662917872893973', '1', 'admin', '登陆', '210', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"a\"]}', '127.0.0.1', '2019-01-04 11:49:40');
INSERT INTO `sys_log` VALUES ('1080662917872893974', '1', 'admin', '登陆', '657', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-07 15:20:25');
INSERT INTO `sys_log` VALUES ('1080662917872893975', '1', 'admin', '登陆', '466', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-07 15:29:09');
INSERT INTO `sys_log` VALUES ('1080662917872893976', '1', 'admin', '用户管理', '2', 'POST /sys/online/list', '{\"page\":[\"1\"],\"limit\":[\"10\"]}', '127.0.0.1', '2019-01-07 15:30:07');
INSERT INTO `sys_log` VALUES ('1080662917872893977', '1', 'admin', '登陆', '305', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-07 15:46:43');
INSERT INTO `sys_log` VALUES ('1080662917872893978', '1', 'admin', '登陆', '240', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-07 15:48:33');
INSERT INTO `sys_log` VALUES ('1080662917872893979', '1', 'admin', '登陆', '34', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-07 15:51:36');
INSERT INTO `sys_log` VALUES ('1080662917872893980', '1', 'admin', '添加', '6332', 'POST /common/config/save', '{\"k\":[\"测试1\"],\"v\":[\"测试1\"],\"remark\":[\"测试1\"],\"createtime\":[\"2019-01-07 16:11:28\"],\"kvtype\":[\"10022\"]}', '127.0.0.1', '2019-01-07 16:11:39');
INSERT INTO `sys_log` VALUES ('1080662917872893981', '1', 'admin', '添加', '4004', 'POST /common/config/save', '{\"k\":[\"测试1\"],\"v\":[\"测试1\"],\"remark\":[\"测试1\"],\"createtime\":[\"2019-01-30 15:59:36\"],\"kvtype\":[\"10022\"]}', '127.0.0.1', '2019-01-07 16:13:09');
INSERT INTO `sys_log` VALUES ('1080662917872893982', '1', 'admin', '添加', '137', 'POST /common/config/save', '{\"k\":[\"测试1\"],\"v\":[\"测试1\"],\"remark\":[\"测试1\"],\"createtime\":[\"2019-01-30 15:59:36\"],\"kvtype\":[\"10022\"]}', '127.0.0.1', '2019-01-07 16:14:33');
INSERT INTO `sys_log` VALUES ('1080662917872893983', '1', 'admin', '删除', '9728', 'POST /common/config/remove', '{\"ids\":[\"29\"]}', '127.0.0.1', '2019-01-07 16:15:09');
INSERT INTO `sys_log` VALUES ('1080662917872893984', '1', 'admin', '登陆', '10', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-07 16:21:18');
INSERT INTO `sys_log` VALUES ('1080662917872893985', '1', 'admin', '批量删除', '4797', 'POST /common/config/batchRemove', '{\"ids\":[\"29\"]}', '127.0.0.1', '2019-01-07 16:21:27');
INSERT INTO `sys_log` VALUES ('1080662917872893986', '1', 'admin', '登陆', '10', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-07 16:24:43');
INSERT INTO `sys_log` VALUES ('1080662917872893987', '1', 'admin', '添加', '116', 'POST /common/config/save', '{\"k\":[\"测试1\"],\"v\":[\"测试1\"],\"remark\":[\"测试1\"],\"createtime\":[\"2019-01-30 15:59:36\"],\"kvtype\":[\"10022\"]}', '127.0.0.1', '2019-01-07 16:24:54');
INSERT INTO `sys_log` VALUES ('1080662917872893988', '1', 'admin', '删除', '1029', 'POST /common/config/remove', '{\"id\":[\"30\"]}', '127.0.0.1', '2019-01-07 16:25:01');
INSERT INTO `sys_log` VALUES ('1080662917872893989', '1', 'admin', '登陆', '896', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-08 09:14:53');
INSERT INTO `sys_log` VALUES ('1080662917872893990', '1', 'admin', '批量删除', '14211', 'POST /common/config/batchRemove', '{\"ids[]\":[\"28\",\"27\"]}', '127.0.0.1', '2019-01-08 09:15:22');
INSERT INTO `sys_log` VALUES ('1080662917872893991', '1', 'admin', '登陆', '172', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-08 09:41:45');
INSERT INTO `sys_log` VALUES ('1080662917872893992', '1', 'admin', '用户列表', '49', 'POST /sys/user/userList', '{\"deptId\":[\"\"]}', '127.0.0.1', '2019-01-08 09:42:58');
INSERT INTO `sys_log` VALUES ('1080662917872893993', '1', 'admin', '登陆', '184', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-08 09:50:04');
INSERT INTO `sys_log` VALUES ('1080662917872893994', '1', 'admin', '登陆', '198', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-08 09:51:34');
INSERT INTO `sys_log` VALUES ('1080662917872893995', '1', 'admin', '登陆', '11', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-08 09:51:52');
INSERT INTO `sys_log` VALUES ('1080662917872893996', '1', 'admin', '登陆', '8', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-08 09:52:03');
INSERT INTO `sys_log` VALUES ('1080662917872893997', '1', 'admin', '登陆', '239', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-08 09:54:45');
INSERT INTO `sys_log` VALUES ('1080662917872893998', '1', 'admin', '登陆', '190', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-08 09:55:37');
INSERT INTO `sys_log` VALUES ('1080662917872893999', '1', 'admin', '登陆', '191', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-08 09:58:39');
INSERT INTO `sys_log` VALUES ('1080662917872894000', '1', 'admin', '登陆', '168', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-08 09:58:39');
INSERT INTO `sys_log` VALUES ('1080662917872894001', '1', 'admin', '登陆', '8', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-08 10:00:15');
INSERT INTO `sys_log` VALUES ('1080662917872894002', '1', 'admin', '登陆', '9', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-08 10:00:40');
INSERT INTO `sys_log` VALUES ('1080662917872894003', '1', 'admin', '登陆', '222', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-08 10:01:54');
INSERT INTO `sys_log` VALUES ('1080662917872894004', '1', 'admin', '登陆', '159', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-08 10:03:38');
INSERT INTO `sys_log` VALUES ('1080662917872894005', '1', 'admin', '登陆', '518', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-08 11:21:12');
INSERT INTO `sys_log` VALUES ('1080662917872894006', '1', 'admin', '登陆', '175', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-08 11:26:39');
INSERT INTO `sys_log` VALUES ('1080662917872894007', '1', 'admin', '登陆', '598', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-08 14:14:58');
INSERT INTO `sys_log` VALUES ('1080662917872894008', '1', 'admin', '登陆', '250', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-08 14:39:26');
INSERT INTO `sys_log` VALUES ('1080662917872894009', '1', 'admin', '登陆', '248', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-08 14:42:40');
INSERT INTO `sys_log` VALUES ('1080662917872894010', '1', 'admin', '登陆', '215', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-08 14:47:06');
INSERT INTO `sys_log` VALUES ('1080662917872894011', '1', 'admin', '登陆', '273', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-08 14:52:50');
INSERT INTO `sys_log` VALUES ('1080662917872894012', '1', 'admin', '登陆', '320', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-08 16:30:02');
INSERT INTO `sys_log` VALUES ('1080662917872894013', '1', 'admin', '登陆', '681', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-08 17:25:29');
INSERT INTO `sys_log` VALUES ('1080662917872894014', '1', 'admin', '登陆', '353', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-08 17:34:07');
INSERT INTO `sys_log` VALUES ('1082571736811048962', '1', 'admin', '登录', '66', 'POST /login', '{\"username\":[\"admin\"],\"password\":[\"1\"]}', '127.0.0.1', '2019-01-08 17:36:30');
INSERT INTO `sys_log` VALUES ('1082572203033104386', '1', 'admin', '登录', '12', 'POST /login', '{\"username\":[\"admin\"],\"password\":[\"1\"]}', '127.0.0.1', '2019-01-08 17:38:21');
INSERT INTO `sys_log` VALUES ('1082572203033104387', '1', 'admin', '登陆', '149', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-08 17:40:06');
INSERT INTO `sys_log` VALUES ('1082572203033104388', '1', 'admin', '登陆', '641', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-09 09:51:04');
INSERT INTO `sys_log` VALUES ('1082572203033104389', '1', 'admin', '用户列表', '203', 'POST /sys/user/userList', '{\"deptId\":[\"\"]}', '127.0.0.1', '2019-01-09 09:51:32');
INSERT INTO `sys_log` VALUES ('1082572203033104390', '1', 'admin', '用户列表', '6', 'POST /sys/user/userList', '{\"deptId\":[\"\"]}', '127.0.0.1', '2019-01-09 09:51:39');
INSERT INTO `sys_log` VALUES ('1082572203033104391', '1', 'admin', '用户列表', '5', 'POST /sys/user/userList', '{\"deptId\":[\"\"]}', '127.0.0.1', '2019-01-09 09:51:40');
INSERT INTO `sys_log` VALUES ('1082572203033104392', '1', 'admin', '用户管理', '1', 'POST /sys/online/list', '{\"page\":[\"1\"],\"limit\":[\"10\"]}', '127.0.0.1', '2019-01-09 09:53:08');
INSERT INTO `sys_log` VALUES ('1082572203033104393', '1', 'admin', '登陆', '203', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-09 09:57:51');
INSERT INTO `sys_log` VALUES ('1082572203033104394', '1', 'admin', '登陆', '1128', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-09 12:08:16');
INSERT INTO `sys_log` VALUES ('1082572203033104395', '1', 'admin', '用户列表', '507', 'POST /sys/user/userList', '{\"roleIds\":[\"1\"]}', '127.0.0.1', '2019-01-09 12:10:14');
INSERT INTO `sys_log` VALUES ('1082572203033104396', '1', 'admin', '用户管理', '10', 'POST /sys/online/list', '{}', '127.0.0.1', '2019-01-09 12:17:38');
INSERT INTO `sys_log` VALUES ('1082572203033104397', '1', 'admin', '登陆', '347', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-09 14:22:30');
INSERT INTO `sys_log` VALUES ('1082572203033104398', '1', 'admin', '登陆', '384', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-09 14:28:36');
INSERT INTO `sys_log` VALUES ('1082572203033104399', '1', 'admin', 'api测试-登录', '56150', 'POST /api/user/login', '{\"uname\":[\"admin\"],\"passwd\":[\"1\"]}', '127.0.0.1', '2019-01-09 14:30:56');
INSERT INTO `sys_log` VALUES ('1082572203033104400', '1', 'admin', '登陆', '346', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-09 14:39:50');
INSERT INTO `sys_log` VALUES ('1082572203033104401', '1', 'admin', '登陆', '355', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-09 14:43:44');
INSERT INTO `sys_log` VALUES ('1082572203033104402', '1', 'admin', '登陆', '348', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-09 14:46:46');
INSERT INTO `sys_log` VALUES ('1082572203033104403', '1', 'admin', '登陆', '356', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-09 14:50:10');
INSERT INTO `sys_log` VALUES ('1082572203033104404', '1', 'admin', '登陆', '7', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-09 14:51:41');
INSERT INTO `sys_log` VALUES ('1082572203033104405', '1', 'admin', '登陆', '6', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-09 14:53:07');
INSERT INTO `sys_log` VALUES ('1082572203033104406', '1', 'admin', 'api测试-需要认证才能访问', '1', 'GET /api/user/require_auth', '{}', '127.0.0.1', '2019-01-09 14:53:37');
INSERT INTO `sys_log` VALUES ('1082572203033104407', '1', 'admin', '登陆', '334', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-09 15:12:59');
INSERT INTO `sys_log` VALUES ('1082572203033104408', '1', 'admin', '登陆', '372', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-09 15:14:28');
INSERT INTO `sys_log` VALUES ('1082572203033104409', '1', 'admin', '登陆', '486', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-09 16:30:07');
INSERT INTO `sys_log` VALUES ('1082572203033104410', '1', 'admin', '登陆', '568', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-09 17:23:44');
INSERT INTO `sys_log` VALUES ('1082572203033104411', '1', 'admin', '登陆', '968', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"ss\"]}', '127.0.0.1', '2019-01-17 09:04:33');
INSERT INTO `sys_log` VALUES ('1082572203033104412', '1', 'admin', '用户列表', '93', 'null null', '{}', null, '2019-01-17 09:04:40');
INSERT INTO `sys_log` VALUES ('1082572203033104413', '1', 'admin', '用户列表', '6', 'null null', '{}', null, '2019-01-17 09:04:52');
INSERT INTO `sys_log` VALUES ('1082572203033104414', '1', 'admin', '用户列表', '304', 'null null', '{}', null, '2019-01-17 09:04:56');
INSERT INTO `sys_log` VALUES ('1082572203033104415', '1', 'admin', '用户列表', '9', 'null null', '{}', null, '2019-01-17 09:04:58');
INSERT INTO `sys_log` VALUES ('1082572203033104416', '1', 'admin', '登陆', '375', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-17 09:23:19');
INSERT INTO `sys_log` VALUES ('1082572203033104417', '1', 'admin', '登陆', '579', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"123\"]}', '127.0.0.1', '2019-01-18 11:57:30');
INSERT INTO `sys_log` VALUES ('1082572203033104418', '1', 'admin', '用户管理', '1', 'POST /sys/online/list', '{\"page\":[\"1\"],\"limit\":[\"10\"]}', '127.0.0.1', '2019-01-18 11:57:40');
INSERT INTO `sys_log` VALUES ('1082572203033104419', '1', 'admin', '登陆', '418', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"123\"]}', '127.0.0.1', '2019-01-18 12:05:01');
INSERT INTO `sys_log` VALUES ('1082572203033104420', '1', 'admin', '登陆', '398', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-18 12:06:54');
INSERT INTO `sys_log` VALUES ('1082572203033104421', '1', 'admin', '用户列表', '42', 'POST /sys/user/userList', '{\"deptId\":[\"\"]}', '127.0.0.1', '2019-01-18 12:07:02');
INSERT INTO `sys_log` VALUES ('1082572203033104422', '1', 'admin', '用户列表', '6', 'POST /sys/user/userList', '{\"deptId\":[\"\"]}', '127.0.0.1', '2019-01-18 12:07:05');
INSERT INTO `sys_log` VALUES ('1082572203033104423', '1', 'admin', '用户列表', '5', 'POST /sys/user/userList', '{\"deptId\":[\"\"]}', '127.0.0.1', '2019-01-18 12:07:07');
INSERT INTO `sys_log` VALUES ('1082572203033104424', '1', 'admin', '用户列表', '130', 'POST /sys/user/userList', '{\"deptId\":[\"7\"]}', '127.0.0.1', '2019-01-18 12:07:10');
INSERT INTO `sys_log` VALUES ('1082572203033104425', '1', 'admin', '用户列表', '7', 'POST /sys/user/userList', '{\"deptId\":[\"8\"]}', '127.0.0.1', '2019-01-18 12:07:12');
INSERT INTO `sys_log` VALUES ('1082572203033104426', '1', 'admin', '用户列表', '6', 'POST /sys/user/userList', '{\"deptId\":[\"7\"]}', '127.0.0.1', '2019-01-18 12:07:13');
INSERT INTO `sys_log` VALUES ('1082572203033104427', '1', 'admin', '用户列表', '5', 'POST /sys/user/userList', '{\"deptId\":[\"16\"]}', '127.0.0.1', '2019-01-18 12:07:14');
INSERT INTO `sys_log` VALUES ('1082572203033104428', '1', 'admin', '用户列表', '4', 'POST /sys/user/userList', '{\"deptId\":[\"12\"]}', '127.0.0.1', '2019-01-18 12:07:15');
INSERT INTO `sys_log` VALUES ('1082572203033104429', '1', 'admin', '用户列表', '3', 'POST /sys/user/userList', '{\"deptId\":[\"14\"]}', '127.0.0.1', '2019-01-18 12:07:17');
INSERT INTO `sys_log` VALUES ('1082572203033104430', '1', 'admin', '用户列表', '6', 'POST /sys/user/userList', '{\"deptId\":[\"15\"]}', '127.0.0.1', '2019-01-18 12:07:18');
INSERT INTO `sys_log` VALUES ('1082572203033104431', '1', 'admin', '用户列表', '3', 'POST /sys/user/userList', '{\"deptId\":[\"18\"]}', '127.0.0.1', '2019-01-18 12:07:18');
INSERT INTO `sys_log` VALUES ('1082572203033104432', '1', 'admin', '用户列表', '4', 'POST /sys/user/userList', '{\"deptId\":[\"21\"]}', '127.0.0.1', '2019-01-18 12:07:19');
INSERT INTO `sys_log` VALUES ('1082572203033104433', '1', 'admin', '用户列表', '3', 'POST /sys/user/userList', '{\"deptId\":[\"19\"]}', '127.0.0.1', '2019-01-18 12:07:20');
INSERT INTO `sys_log` VALUES ('1082572203033104434', '1', 'admin', '用户列表', '5', 'POST /sys/user/userList', '{\"deptId\":[\"\"]}', '127.0.0.1', '2019-01-18 12:07:37');
INSERT INTO `sys_log` VALUES ('1082572203033104435', '1', 'admin', '用户列表', '11', 'POST /sys/user/userList', '{\"deptId\":[\"7\"]}', '127.0.0.1', '2019-01-18 12:08:03');
INSERT INTO `sys_log` VALUES ('1082572203033104436', '1', 'admin', '登陆', '728', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-20 23:07:38');
INSERT INTO `sys_log` VALUES ('1082572203033104437', '1', 'admin', '用户管理', '1', 'POST /sys/online/list', '{\"page\":[\"1\"],\"limit\":[\"10\"]}', '127.0.0.1', '2019-01-20 23:07:42');
INSERT INTO `sys_log` VALUES ('1082572203033104438', '1', 'admin', '登陆', '379', 'POST /loginFrom', '{\"username\":[\"admin\"],\"password\":[\"1\"],\"kaptcha\":[\"1\"]}', '127.0.0.1', '2019-01-20 23:08:16');
INSERT INTO `sys_log` VALUES ('1082572203033104439', '1', 'admin', '用户管理', '0', 'POST /sys/online/list', '{\"page\":[\"1\"],\"limit\":[\"10\"]}', '127.0.0.1', '2019-01-20 23:08:19');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parentId` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `orderNum` int(11) DEFAULT NULL COMMENT '排序',
  `gmtCreate` datetime DEFAULT NULL COMMENT '创建时间',
  `gmtModified` datetime DEFAULT NULL COMMENT '修改时间',
  `delFlag` int(11) DEFAULT '0' COMMENT '是否删除。0-否，1-是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=215 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '基础管理', '', '', '0', 'fa fa-bars', '0', '2017-08-09 22:49:47', null, '0');
INSERT INTO `sys_menu` VALUES ('2', '3', '系统菜单', 'sys/menu/', 'sys:menu:menu', '1', 'fa fa-th-list', '2', '2017-08-09 22:55:15', null, '0');
INSERT INTO `sys_menu` VALUES ('3', '0', '系统管理', null, null, '0', 'fa fa-desktop', '1', '2017-08-09 23:06:55', '2017-08-14 14:13:43', '0');
INSERT INTO `sys_menu` VALUES ('6', '3', '用户管理', 'sys/user/', 'sys:user:user', '1', 'fa fa-user', '0', '2017-08-10 14:12:11', null, '0');
INSERT INTO `sys_menu` VALUES ('7', '3', '角色管理', 'sys/role/', 'sys:role:role', '1', 'fa fa-paw', '1', '2017-08-10 14:13:19', null, '0');
INSERT INTO `sys_menu` VALUES ('12', '6', '新增', '', 'sys:user:add', '2', '', '0', '2017-08-14 10:51:35', null, '0');
INSERT INTO `sys_menu` VALUES ('13', '6', '编辑', '', 'sys:user:edit', '2', '', '0', '2017-08-14 10:52:06', null, '0');
INSERT INTO `sys_menu` VALUES ('14', '6', '删除', null, 'sys:user:remove', '2', null, '0', '2017-08-14 10:52:24', null, '0');
INSERT INTO `sys_menu` VALUES ('15', '7', '新增', '', 'sys:role:add', '2', '', '0', '2017-08-14 10:56:37', null, '0');
INSERT INTO `sys_menu` VALUES ('20', '2', '新增', '', 'sys:menu:add', '2', '', '0', '2017-08-14 10:59:32', null, '0');
INSERT INTO `sys_menu` VALUES ('21', '2', '编辑', '', 'sys:menu:edit', '2', '', '0', '2017-08-14 10:59:56', null, '0');
INSERT INTO `sys_menu` VALUES ('22', '2', '删除', '', 'sys:menu:remove', '2', '', '0', '2017-08-14 11:00:26', null, '0');
INSERT INTO `sys_menu` VALUES ('24', '6', '批量删除', '', 'sys:user:batchRemove', '2', '', '0', '2017-08-14 17:27:18', null, '0');
INSERT INTO `sys_menu` VALUES ('25', '6', '停用', null, 'sys:user:disable', '2', null, '0', '2017-08-14 17:27:43', null, '0');
INSERT INTO `sys_menu` VALUES ('26', '6', '重置密码', '', 'sys:user:resetPwd', '2', '', '0', '2017-08-14 17:28:34', null, '0');
INSERT INTO `sys_menu` VALUES ('27', '91', '系统日志', 'common/log/', 'common:log', '1', 'fa fa-warning', '0', '2017-08-14 22:11:53', null, '0');
INSERT INTO `sys_menu` VALUES ('28', '27', '刷新', null, 'sys:log:list', '2', null, '0', '2017-08-14 22:30:22', null, '0');
INSERT INTO `sys_menu` VALUES ('29', '27', '删除', null, 'sys:log:remove', '2', null, '0', '2017-08-14 22:30:43', null, '0');
INSERT INTO `sys_menu` VALUES ('30', '27', '清空', null, 'sys:log:clear', '2', null, '0', '2017-08-14 22:31:02', null, '0');
INSERT INTO `sys_menu` VALUES ('48', '77', '代码生成', 'common/generator/', 'common:generator', '1', 'fa fa-code', '3', null, null, '0');
INSERT INTO `sys_menu` VALUES ('55', '7', '编辑', '', 'sys:role:edit', '2', '', null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('56', '7', '删除', '', 'sys:role:remove', '2', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('57', '91', '运行监控', '/druid/index.html', '', '1', 'fa fa-caret-square-o-right', '1', null, null, '0');
INSERT INTO `sys_menu` VALUES ('61', '2', '批量删除', '', 'sys:menu:batchRemove', '2', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('62', '7', '批量删除', '', 'sys:role:batchRemove', '2', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('71', '1', '文件管理', '/common/sysFile', 'oss:file:file', '1', 'fa fa-folder-open', '2', null, null, '0');
INSERT INTO `sys_menu` VALUES ('72', '77', '计划任务', 'common/job', 'common:taskScheduleJob', '1', 'fa fa-hourglass-1', '4', null, null, '1');
INSERT INTO `sys_menu` VALUES ('73', '3', '部门管理', '/sys/dept/', 'system:sysDept:sysDept', '1', 'fa fa-users', '3', null, null, '0');
INSERT INTO `sys_menu` VALUES ('74', '73', '增加', '/sys/dept/add', 'system:sysDept:add', '2', null, '1', null, null, '0');
INSERT INTO `sys_menu` VALUES ('75', '73', '刪除', 'sys/dept/remove', 'system:sysDept:remove', '2', null, '2', null, null, '0');
INSERT INTO `sys_menu` VALUES ('76', '73', '编辑', '/sys/dept/edit', 'system:sysDept:edit', '2', null, '3', null, null, '0');
INSERT INTO `sys_menu` VALUES ('77', '0', '系统工具', '', '', '0', 'fa fa-gear', '4', null, null, '0');
INSERT INTO `sys_menu` VALUES ('78', '1', '数据字典', '/base/dict/', 'common:sysDict:sysDict', '1', 'fa fa-book', '1', null, null, '0');
INSERT INTO `sys_menu` VALUES ('79', '78', '增加', '/common/sysDict/add', 'common:sysDict:add', '2', null, '2', null, null, '0');
INSERT INTO `sys_menu` VALUES ('80', '78', '编辑', '/common/sysDict/edit', 'common:sysDict:edit', '2', null, '2', null, null, '0');
INSERT INTO `sys_menu` VALUES ('81', '78', '删除', '/common/sysDict/remove', 'common:sysDict:remove', '2', '', '3', null, null, '0');
INSERT INTO `sys_menu` VALUES ('83', '78', '批量删除', '/common/sysDict/batchRemove', 'common:sysDict:batchRemove', '2', '', '4', null, null, '0');
INSERT INTO `sys_menu` VALUES ('91', '0', '系统监控', '', '', '0', 'fa fa-video-camera', '5', null, null, '0');
INSERT INTO `sys_menu` VALUES ('92', '91', '在线用户', 'sys/online/', '', '1', 'fa fa-user', null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('97', '0', '图表管理', '', '', '0', 'fa fa-bar-chart', '7', null, null, '0');
INSERT INTO `sys_menu` VALUES ('98', '97', '百度chart', '/chart/graph_echarts.html', '', '1', 'fa fa-area-chart', null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('175', '1', '系统配置', '/common/config/', null, '1', 'fa fa-file-code-o', '6', null, null, '0');
INSERT INTO `sys_menu` VALUES ('176', '175', '查看', null, 'common:config:config', '2', null, '6', null, null, '0');
INSERT INTO `sys_menu` VALUES ('177', '175', '新增', null, 'common:config:add', '2', null, '6', null, null, '0');
INSERT INTO `sys_menu` VALUES ('178', '175', '修改', null, 'common:config:edit', '2', null, '6', null, null, '0');
INSERT INTO `sys_menu` VALUES ('179', '175', '删除', null, 'common:config:remove', '2', null, '6', null, null, '0');
INSERT INTO `sys_menu` VALUES ('180', '175', '批量删除', null, 'common:config:batchRemove', '2', null, '6', null, null, '0');
INSERT INTO `sys_menu` VALUES ('181', '199', '公众号管理', '/wxmp/mpConfig', null, '1', 'fa fa-file-code-o', '6', null, null, '0');
INSERT INTO `sys_menu` VALUES ('182', '181', '查看', null, 'wxmp:mpConfig:mpConfig', '2', null, '6', null, null, '0');
INSERT INTO `sys_menu` VALUES ('183', '181', '新增', null, 'wxmp:mpConfig:add', '2', null, '6', null, null, '0');
INSERT INTO `sys_menu` VALUES ('184', '181', '修改', null, 'wxmp:mpConfig:edit', '2', null, '6', null, null, '0');
INSERT INTO `sys_menu` VALUES ('185', '181', '删除', null, 'wxmp:mpConfig:remove', '2', null, '6', null, null, '0');
INSERT INTO `sys_menu` VALUES ('186', '181', '批量删除', null, 'wxmp:mpConfig:batchRemove', '2', null, '6', null, null, '0');
INSERT INTO `sys_menu` VALUES ('187', '199', '微信粉丝表', '/wxmp/mpFans', null, '1', 'fa fa-file-code-o', '6', null, null, '0');
INSERT INTO `sys_menu` VALUES ('188', '187', '查看', null, 'wxmp:mpFans:mpFans', '2', null, '6', null, null, '0');
INSERT INTO `sys_menu` VALUES ('189', '187', '新增', null, 'wxmp:mpFans:add', '2', null, '6', null, null, '0');
INSERT INTO `sys_menu` VALUES ('190', '187', '修改', null, 'wxmp:mpFans:edit', '2', null, '6', null, null, '0');
INSERT INTO `sys_menu` VALUES ('191', '187', '删除', null, 'wxmp:mpFans:remove', '2', null, '6', null, null, '0');
INSERT INTO `sys_menu` VALUES ('192', '187', '批量删除', null, 'wxmp:mpFans:batchRemove', '2', null, '6', null, null, '0');
INSERT INTO `sys_menu` VALUES ('193', '71', '增加', '/common/sysFile/add', 'oss:file:add', '2', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('194', '71', '列表', '/common/sysFile/list', 'oss:file:list', '2', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('195', '71', '编辑', '/common/sysFile/edit', 'oss:file:update', '2', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('196', '71', '查询', '/common/sysFile/info', 'oss:file:info', '2', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('197', '71', '删除', '/common/sysFile/remove', 'oss:file:remove', '2', null, null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('199', '0', '微信公众号', null, null, '0', 'fa fa-file-code-o', '3', null, null, '0');
INSERT INTO `sys_menu` VALUES ('205', '187', '同步', null, 'wxmp:mpFans:sync', '2', 'fa fa-refresh', '5', null, null, '0');
INSERT INTO `sys_menu` VALUES ('206', '1', '[Demo]基础表', '/demo/demoBase', '', '1', 'fa fa-file-code-o', '6', null, null, '0');
INSERT INTO `sys_menu` VALUES ('207', '206', '查看', null, 'demo:demoBase:demoBase', '2', null, '6', null, null, '0');
INSERT INTO `sys_menu` VALUES ('208', '206', '新增', null, 'demo:demoBase:add', '2', null, '6', null, null, '0');
INSERT INTO `sys_menu` VALUES ('209', '206', '修改', null, 'demo:demoBase:edit', '2', null, '6', null, null, '0');
INSERT INTO `sys_menu` VALUES ('210', '206', '删除', null, 'demo:demoBase:remove', '2', null, '6', null, null, '0');
INSERT INTO `sys_menu` VALUES ('211', '206', '批量删除', null, 'demo:demoBase:batchRemove', '2', null, '6', null, null, '0');
INSERT INTO `sys_menu` VALUES ('212', '0', 'api测试-用户更新', '', 'api:user:update', '2', '', null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('213', '0', 'api测试-appUser角色', '', 'api:user:role', '2', '', null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('214', '213', '测试下级123', '测试地址', '测试标识', '1', '1', '1', null, null, '0');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `roleSign` varchar(100) DEFAULT NULL COMMENT '角色标识',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `userIdCreate` bigint(255) DEFAULT NULL COMMENT '创建用户id',
  `gmtCreate` datetime DEFAULT NULL COMMENT '创建时间',
  `gmtModified` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级用户角色', 'adminRole', '超级管理员', '2', '2017-08-12 00:43:52', '2017-08-12 19:14:59');
INSERT INTO `sys_role` VALUES ('2', '前端API', 'apiRole', '前端API', null, null, null);
INSERT INTO `sys_role` VALUES ('56', '普通用户', null, '普通用户', null, null, null);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleId` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menuId` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5210 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('367', '44', '1');
INSERT INTO `sys_role_menu` VALUES ('368', '44', '32');
INSERT INTO `sys_role_menu` VALUES ('369', '44', '33');
INSERT INTO `sys_role_menu` VALUES ('370', '44', '34');
INSERT INTO `sys_role_menu` VALUES ('371', '44', '35');
INSERT INTO `sys_role_menu` VALUES ('372', '44', '28');
INSERT INTO `sys_role_menu` VALUES ('373', '44', '29');
INSERT INTO `sys_role_menu` VALUES ('374', '44', '30');
INSERT INTO `sys_role_menu` VALUES ('375', '44', '38');
INSERT INTO `sys_role_menu` VALUES ('376', '44', '4');
INSERT INTO `sys_role_menu` VALUES ('377', '44', '27');
INSERT INTO `sys_role_menu` VALUES ('378', '45', '38');
INSERT INTO `sys_role_menu` VALUES ('379', '46', '3');
INSERT INTO `sys_role_menu` VALUES ('380', '46', '20');
INSERT INTO `sys_role_menu` VALUES ('381', '46', '21');
INSERT INTO `sys_role_menu` VALUES ('382', '46', '22');
INSERT INTO `sys_role_menu` VALUES ('383', '46', '23');
INSERT INTO `sys_role_menu` VALUES ('384', '46', '11');
INSERT INTO `sys_role_menu` VALUES ('385', '46', '12');
INSERT INTO `sys_role_menu` VALUES ('386', '46', '13');
INSERT INTO `sys_role_menu` VALUES ('387', '46', '14');
INSERT INTO `sys_role_menu` VALUES ('388', '46', '24');
INSERT INTO `sys_role_menu` VALUES ('389', '46', '25');
INSERT INTO `sys_role_menu` VALUES ('390', '46', '26');
INSERT INTO `sys_role_menu` VALUES ('391', '46', '15');
INSERT INTO `sys_role_menu` VALUES ('392', '46', '2');
INSERT INTO `sys_role_menu` VALUES ('393', '46', '6');
INSERT INTO `sys_role_menu` VALUES ('394', '46', '7');
INSERT INTO `sys_role_menu` VALUES ('598', '50', '38');
INSERT INTO `sys_role_menu` VALUES ('632', '38', '42');
INSERT INTO `sys_role_menu` VALUES ('737', '51', '38');
INSERT INTO `sys_role_menu` VALUES ('738', '51', '39');
INSERT INTO `sys_role_menu` VALUES ('739', '51', '40');
INSERT INTO `sys_role_menu` VALUES ('740', '51', '41');
INSERT INTO `sys_role_menu` VALUES ('741', '51', '4');
INSERT INTO `sys_role_menu` VALUES ('742', '51', '32');
INSERT INTO `sys_role_menu` VALUES ('743', '51', '33');
INSERT INTO `sys_role_menu` VALUES ('744', '51', '34');
INSERT INTO `sys_role_menu` VALUES ('745', '51', '35');
INSERT INTO `sys_role_menu` VALUES ('746', '51', '27');
INSERT INTO `sys_role_menu` VALUES ('747', '51', '28');
INSERT INTO `sys_role_menu` VALUES ('748', '51', '29');
INSERT INTO `sys_role_menu` VALUES ('749', '51', '30');
INSERT INTO `sys_role_menu` VALUES ('750', '51', '1');
INSERT INTO `sys_role_menu` VALUES ('1064', '54', '53');
INSERT INTO `sys_role_menu` VALUES ('1095', '55', '2');
INSERT INTO `sys_role_menu` VALUES ('1096', '55', '6');
INSERT INTO `sys_role_menu` VALUES ('1097', '55', '7');
INSERT INTO `sys_role_menu` VALUES ('1098', '55', '3');
INSERT INTO `sys_role_menu` VALUES ('1099', '55', '50');
INSERT INTO `sys_role_menu` VALUES ('1100', '55', '49');
INSERT INTO `sys_role_menu` VALUES ('1101', '55', '1');
INSERT INTO `sys_role_menu` VALUES ('1856', '53', '28');
INSERT INTO `sys_role_menu` VALUES ('1857', '53', '29');
INSERT INTO `sys_role_menu` VALUES ('1858', '53', '30');
INSERT INTO `sys_role_menu` VALUES ('1859', '53', '27');
INSERT INTO `sys_role_menu` VALUES ('1860', '53', '57');
INSERT INTO `sys_role_menu` VALUES ('1861', '53', '71');
INSERT INTO `sys_role_menu` VALUES ('1862', '53', '48');
INSERT INTO `sys_role_menu` VALUES ('1863', '53', '72');
INSERT INTO `sys_role_menu` VALUES ('1864', '53', '1');
INSERT INTO `sys_role_menu` VALUES ('1865', '53', '7');
INSERT INTO `sys_role_menu` VALUES ('1866', '53', '55');
INSERT INTO `sys_role_menu` VALUES ('1867', '53', '56');
INSERT INTO `sys_role_menu` VALUES ('1868', '53', '62');
INSERT INTO `sys_role_menu` VALUES ('1869', '53', '15');
INSERT INTO `sys_role_menu` VALUES ('1870', '53', '2');
INSERT INTO `sys_role_menu` VALUES ('1871', '53', '61');
INSERT INTO `sys_role_menu` VALUES ('1872', '53', '20');
INSERT INTO `sys_role_menu` VALUES ('1873', '53', '21');
INSERT INTO `sys_role_menu` VALUES ('1874', '53', '22');
INSERT INTO `sys_role_menu` VALUES ('2247', '63', '-1');
INSERT INTO `sys_role_menu` VALUES ('2248', '63', '84');
INSERT INTO `sys_role_menu` VALUES ('2249', '63', '85');
INSERT INTO `sys_role_menu` VALUES ('2250', '63', '88');
INSERT INTO `sys_role_menu` VALUES ('2251', '63', '87');
INSERT INTO `sys_role_menu` VALUES ('2252', '64', '84');
INSERT INTO `sys_role_menu` VALUES ('2253', '64', '89');
INSERT INTO `sys_role_menu` VALUES ('2254', '64', '88');
INSERT INTO `sys_role_menu` VALUES ('2255', '64', '87');
INSERT INTO `sys_role_menu` VALUES ('2256', '64', '86');
INSERT INTO `sys_role_menu` VALUES ('2257', '64', '85');
INSERT INTO `sys_role_menu` VALUES ('2258', '65', '89');
INSERT INTO `sys_role_menu` VALUES ('2259', '65', '88');
INSERT INTO `sys_role_menu` VALUES ('2260', '65', '86');
INSERT INTO `sys_role_menu` VALUES ('2262', '67', '48');
INSERT INTO `sys_role_menu` VALUES ('2263', '68', '88');
INSERT INTO `sys_role_menu` VALUES ('2264', '68', '87');
INSERT INTO `sys_role_menu` VALUES ('2265', '69', '89');
INSERT INTO `sys_role_menu` VALUES ('2266', '69', '88');
INSERT INTO `sys_role_menu` VALUES ('2267', '69', '86');
INSERT INTO `sys_role_menu` VALUES ('2268', '69', '87');
INSERT INTO `sys_role_menu` VALUES ('2269', '69', '85');
INSERT INTO `sys_role_menu` VALUES ('2270', '69', '84');
INSERT INTO `sys_role_menu` VALUES ('2271', '70', '85');
INSERT INTO `sys_role_menu` VALUES ('2272', '70', '89');
INSERT INTO `sys_role_menu` VALUES ('2273', '70', '88');
INSERT INTO `sys_role_menu` VALUES ('2274', '70', '87');
INSERT INTO `sys_role_menu` VALUES ('2275', '70', '86');
INSERT INTO `sys_role_menu` VALUES ('2276', '70', '84');
INSERT INTO `sys_role_menu` VALUES ('2277', '71', '87');
INSERT INTO `sys_role_menu` VALUES ('2278', '72', '59');
INSERT INTO `sys_role_menu` VALUES ('2279', '73', '48');
INSERT INTO `sys_role_menu` VALUES ('2280', '74', '88');
INSERT INTO `sys_role_menu` VALUES ('2281', '74', '87');
INSERT INTO `sys_role_menu` VALUES ('2282', '75', '88');
INSERT INTO `sys_role_menu` VALUES ('2283', '75', '87');
INSERT INTO `sys_role_menu` VALUES ('2284', '76', '85');
INSERT INTO `sys_role_menu` VALUES ('2285', '76', '89');
INSERT INTO `sys_role_menu` VALUES ('2286', '76', '88');
INSERT INTO `sys_role_menu` VALUES ('2287', '76', '87');
INSERT INTO `sys_role_menu` VALUES ('2288', '76', '86');
INSERT INTO `sys_role_menu` VALUES ('2289', '76', '84');
INSERT INTO `sys_role_menu` VALUES ('2292', '78', '88');
INSERT INTO `sys_role_menu` VALUES ('2293', '78', '87');
INSERT INTO `sys_role_menu` VALUES ('2294', '78', null);
INSERT INTO `sys_role_menu` VALUES ('2295', '78', null);
INSERT INTO `sys_role_menu` VALUES ('2296', '78', null);
INSERT INTO `sys_role_menu` VALUES ('2308', '80', '87');
INSERT INTO `sys_role_menu` VALUES ('2309', '80', '86');
INSERT INTO `sys_role_menu` VALUES ('2310', '80', '-1');
INSERT INTO `sys_role_menu` VALUES ('2311', '80', '84');
INSERT INTO `sys_role_menu` VALUES ('2312', '80', '85');
INSERT INTO `sys_role_menu` VALUES ('2328', '79', '72');
INSERT INTO `sys_role_menu` VALUES ('2329', '79', '48');
INSERT INTO `sys_role_menu` VALUES ('2330', '79', '77');
INSERT INTO `sys_role_menu` VALUES ('2331', '79', '84');
INSERT INTO `sys_role_menu` VALUES ('2332', '79', '89');
INSERT INTO `sys_role_menu` VALUES ('2333', '79', '88');
INSERT INTO `sys_role_menu` VALUES ('2334', '79', '87');
INSERT INTO `sys_role_menu` VALUES ('2335', '79', '86');
INSERT INTO `sys_role_menu` VALUES ('2336', '79', '85');
INSERT INTO `sys_role_menu` VALUES ('2337', '79', '-1');
INSERT INTO `sys_role_menu` VALUES ('2338', '77', '89');
INSERT INTO `sys_role_menu` VALUES ('2339', '77', '88');
INSERT INTO `sys_role_menu` VALUES ('2340', '77', '87');
INSERT INTO `sys_role_menu` VALUES ('2341', '77', '86');
INSERT INTO `sys_role_menu` VALUES ('2342', '77', '85');
INSERT INTO `sys_role_menu` VALUES ('2343', '77', '84');
INSERT INTO `sys_role_menu` VALUES ('2344', '77', '72');
INSERT INTO `sys_role_menu` VALUES ('2345', '77', '-1');
INSERT INTO `sys_role_menu` VALUES ('2346', '77', '77');
INSERT INTO `sys_role_menu` VALUES ('3178', '56', '68');
INSERT INTO `sys_role_menu` VALUES ('3179', '56', '60');
INSERT INTO `sys_role_menu` VALUES ('3180', '56', '59');
INSERT INTO `sys_role_menu` VALUES ('3181', '56', '58');
INSERT INTO `sys_role_menu` VALUES ('3182', '56', '51');
INSERT INTO `sys_role_menu` VALUES ('3183', '56', '50');
INSERT INTO `sys_role_menu` VALUES ('3184', '56', '49');
INSERT INTO `sys_role_menu` VALUES ('3185', '56', '-1');
INSERT INTO `sys_role_menu` VALUES ('4544', '1034088931742957569', '1034089959238385666');
INSERT INTO `sys_role_menu` VALUES ('4545', '1034088931742957569', '1034090238251876354');
INSERT INTO `sys_role_menu` VALUES ('4546', '1034088931742957569', '-1');
INSERT INTO `sys_role_menu` VALUES ('4547', '1074171417978761218', '57');
INSERT INTO `sys_role_menu` VALUES ('4548', '1074171417978761218', '92');
INSERT INTO `sys_role_menu` VALUES ('4549', '1074171417978761218', '29');
INSERT INTO `sys_role_menu` VALUES ('4550', '1074171417978761218', '28');
INSERT INTO `sys_role_menu` VALUES ('4551', '1074171417978761218', '30');
INSERT INTO `sys_role_menu` VALUES ('4633', '1074183961095254018', '176');
INSERT INTO `sys_role_menu` VALUES ('4634', '1074183961095254018', '177');
INSERT INTO `sys_role_menu` VALUES ('4635', '1074183961095254018', '178');
INSERT INTO `sys_role_menu` VALUES ('4636', '1074183961095254018', '179');
INSERT INTO `sys_role_menu` VALUES ('4637', '1074183961095254018', '180');
INSERT INTO `sys_role_menu` VALUES ('4638', '1074183961095254018', '207');
INSERT INTO `sys_role_menu` VALUES ('4639', '1074183961095254018', '209');
INSERT INTO `sys_role_menu` VALUES ('4640', '1074183961095254018', '210');
INSERT INTO `sys_role_menu` VALUES ('4641', '1074183961095254018', '211');
INSERT INTO `sys_role_menu` VALUES ('4642', '1074183961095254018', '208');
INSERT INTO `sys_role_menu` VALUES ('4643', '1074183961095254018', '193');
INSERT INTO `sys_role_menu` VALUES ('4644', '1074183961095254018', '197');
INSERT INTO `sys_role_menu` VALUES ('4645', '1074183961095254018', '194');
INSERT INTO `sys_role_menu` VALUES ('4646', '1074183961095254018', '196');
INSERT INTO `sys_role_menu` VALUES ('4647', '1074183961095254018', '195');
INSERT INTO `sys_role_menu` VALUES ('4648', '1074183961095254018', '83');
INSERT INTO `sys_role_menu` VALUES ('4649', '1074183961095254018', '81');
INSERT INTO `sys_role_menu` VALUES ('4650', '1074183961095254018', '79');
INSERT INTO `sys_role_menu` VALUES ('4651', '1074183961095254018', '80');
INSERT INTO `sys_role_menu` VALUES ('4899', '1', '1');
INSERT INTO `sys_role_menu` VALUES ('4900', '1', '71');
INSERT INTO `sys_role_menu` VALUES ('4901', '1', '193');
INSERT INTO `sys_role_menu` VALUES ('4902', '1', '194');
INSERT INTO `sys_role_menu` VALUES ('4903', '1', '195');
INSERT INTO `sys_role_menu` VALUES ('4904', '1', '196');
INSERT INTO `sys_role_menu` VALUES ('4905', '1', '197');
INSERT INTO `sys_role_menu` VALUES ('4906', '1', '78');
INSERT INTO `sys_role_menu` VALUES ('4907', '1', '79');
INSERT INTO `sys_role_menu` VALUES ('4908', '1', '80');
INSERT INTO `sys_role_menu` VALUES ('4909', '1', '81');
INSERT INTO `sys_role_menu` VALUES ('4910', '1', '83');
INSERT INTO `sys_role_menu` VALUES ('4911', '1', '175');
INSERT INTO `sys_role_menu` VALUES ('4912', '1', '176');
INSERT INTO `sys_role_menu` VALUES ('4913', '1', '177');
INSERT INTO `sys_role_menu` VALUES ('4914', '1', '178');
INSERT INTO `sys_role_menu` VALUES ('4915', '1', '179');
INSERT INTO `sys_role_menu` VALUES ('4916', '1', '180');
INSERT INTO `sys_role_menu` VALUES ('4917', '1', '206');
INSERT INTO `sys_role_menu` VALUES ('4918', '1', '207');
INSERT INTO `sys_role_menu` VALUES ('4919', '1', '208');
INSERT INTO `sys_role_menu` VALUES ('4920', '1', '209');
INSERT INTO `sys_role_menu` VALUES ('4921', '1', '210');
INSERT INTO `sys_role_menu` VALUES ('4922', '1', '211');
INSERT INTO `sys_role_menu` VALUES ('4923', '1', '3');
INSERT INTO `sys_role_menu` VALUES ('4924', '1', '2');
INSERT INTO `sys_role_menu` VALUES ('4925', '1', '20');
INSERT INTO `sys_role_menu` VALUES ('4926', '1', '21');
INSERT INTO `sys_role_menu` VALUES ('4927', '1', '22');
INSERT INTO `sys_role_menu` VALUES ('4928', '1', '61');
INSERT INTO `sys_role_menu` VALUES ('4929', '1', '6');
INSERT INTO `sys_role_menu` VALUES ('4930', '1', '12');
INSERT INTO `sys_role_menu` VALUES ('4931', '1', '13');
INSERT INTO `sys_role_menu` VALUES ('4932', '1', '14');
INSERT INTO `sys_role_menu` VALUES ('4933', '1', '24');
INSERT INTO `sys_role_menu` VALUES ('4934', '1', '25');
INSERT INTO `sys_role_menu` VALUES ('4935', '1', '26');
INSERT INTO `sys_role_menu` VALUES ('4936', '1', '7');
INSERT INTO `sys_role_menu` VALUES ('4937', '1', '15');
INSERT INTO `sys_role_menu` VALUES ('4938', '1', '55');
INSERT INTO `sys_role_menu` VALUES ('4939', '1', '56');
INSERT INTO `sys_role_menu` VALUES ('4940', '1', '62');
INSERT INTO `sys_role_menu` VALUES ('4941', '1', '73');
INSERT INTO `sys_role_menu` VALUES ('4942', '1', '74');
INSERT INTO `sys_role_menu` VALUES ('4943', '1', '75');
INSERT INTO `sys_role_menu` VALUES ('4944', '1', '76');
INSERT INTO `sys_role_menu` VALUES ('4945', '1', '77');
INSERT INTO `sys_role_menu` VALUES ('4946', '1', '48');
INSERT INTO `sys_role_menu` VALUES ('4947', '1', '72');
INSERT INTO `sys_role_menu` VALUES ('4948', '1', '91');
INSERT INTO `sys_role_menu` VALUES ('4949', '1', '27');
INSERT INTO `sys_role_menu` VALUES ('4950', '1', '28');
INSERT INTO `sys_role_menu` VALUES ('4951', '1', '29');
INSERT INTO `sys_role_menu` VALUES ('4952', '1', '30');
INSERT INTO `sys_role_menu` VALUES ('4953', '1', '57');
INSERT INTO `sys_role_menu` VALUES ('4954', '1', '92');
INSERT INTO `sys_role_menu` VALUES ('4955', '1074194776175218690', '1');
INSERT INTO `sys_role_menu` VALUES ('4956', '1074194776175218690', '175');
INSERT INTO `sys_role_menu` VALUES ('4957', '1074194776175218690', '176');
INSERT INTO `sys_role_menu` VALUES ('4958', '1074194776175218690', '177');
INSERT INTO `sys_role_menu` VALUES ('4959', '1074194776175218690', '178');
INSERT INTO `sys_role_menu` VALUES ('4960', '1074194776175218690', '179');
INSERT INTO `sys_role_menu` VALUES ('4961', '1074194776175218690', '180');
INSERT INTO `sys_role_menu` VALUES ('4962', '1074194776175218690', '206');
INSERT INTO `sys_role_menu` VALUES ('4963', '1074194776175218690', '207');
INSERT INTO `sys_role_menu` VALUES ('4964', '1074194776175218690', '209');
INSERT INTO `sys_role_menu` VALUES ('4965', '1074194776175218690', '210');
INSERT INTO `sys_role_menu` VALUES ('4966', '1074194776175218690', '211');
INSERT INTO `sys_role_menu` VALUES ('4967', '1074194776175218690', '208');
INSERT INTO `sys_role_menu` VALUES ('4968', '1074194776175218690', '71');
INSERT INTO `sys_role_menu` VALUES ('4969', '1074194776175218690', '193');
INSERT INTO `sys_role_menu` VALUES ('4970', '1074194776175218690', '197');
INSERT INTO `sys_role_menu` VALUES ('4971', '1074194776175218690', '194');
INSERT INTO `sys_role_menu` VALUES ('4972', '1074194776175218690', '196');
INSERT INTO `sys_role_menu` VALUES ('4973', '1074194776175218690', '195');
INSERT INTO `sys_role_menu` VALUES ('4974', '1074194776175218690', '78');
INSERT INTO `sys_role_menu` VALUES ('4975', '1074194776175218690', '83');
INSERT INTO `sys_role_menu` VALUES ('4976', '1074194776175218690', '81');
INSERT INTO `sys_role_menu` VALUES ('4977', '1074194776175218690', '79');
INSERT INTO `sys_role_menu` VALUES ('4978', '1074194776175218690', '80');
INSERT INTO `sys_role_menu` VALUES ('4979', '1074194776175218690', '77');
INSERT INTO `sys_role_menu` VALUES ('4980', '1074194776175218690', '72');
INSERT INTO `sys_role_menu` VALUES ('4981', '1074194776175218690', '48');
INSERT INTO `sys_role_menu` VALUES ('5202', '1074201842218528770', '213');
INSERT INTO `sys_role_menu` VALUES ('5203', '1074201842218528770', '212');
INSERT INTO `sys_role_menu` VALUES ('5204', '1074201842218528771', '213');
INSERT INTO `sys_role_menu` VALUES ('5205', '1074201842218528771', '212');
INSERT INTO `sys_role_menu` VALUES ('5206', '57', '213');
INSERT INTO `sys_role_menu` VALUES ('5207', '57', '212');
INSERT INTO `sys_role_menu` VALUES ('5208', '58', '213');
INSERT INTO `sys_role_menu` VALUES ('5209', '59', '213');

-- ----------------------------
-- Table structure for sys_task
-- ----------------------------
DROP TABLE IF EXISTS `sys_task`;
CREATE TABLE `sys_task` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cronExpression` varchar(255) DEFAULT NULL COMMENT 'cron表达式',
  `methodName` varchar(255) DEFAULT NULL COMMENT '任务调用的方法名',
  `isConcurrent` varchar(255) DEFAULT NULL COMMENT '任务是否有状态',
  `description` varchar(255) DEFAULT NULL COMMENT '任务描述',
  `updateBy` varchar(64) DEFAULT NULL COMMENT '更新者',
  `beanClass` varchar(255) DEFAULT NULL COMMENT '任务执行时调用哪个类的方法 包名+类名',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `jobStatus` varchar(255) DEFAULT NULL COMMENT '任务状态',
  `jobGroup` varchar(255) DEFAULT NULL COMMENT '任务分组',
  `updateDate` datetime DEFAULT NULL COMMENT '更新时间',
  `createBy` varchar(64) DEFAULT NULL COMMENT '创建者',
  `springBean` varchar(255) DEFAULT NULL COMMENT 'Spring bean',
  `jobName` varchar(255) DEFAULT NULL COMMENT '任务名',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1020572889410367491 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_task
-- ----------------------------
INSERT INTO `sys_task` VALUES ('2', '0/10 * * * * ?', 'run1', '1', '', '4028ea815a3d2a8c015a3d2f8d2a0002', 'com.ifast.job.TestJob', '2017-05-19 18:30:56', '0', 'group1', '2017-05-19 18:31:07', null, '', 'TestJob');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `name` varchar(100) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `deptId` bigint(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(255) DEFAULT NULL COMMENT '状态 0:禁用，1:正常',
  `userIdCreate` bigint(255) DEFAULT NULL COMMENT '创建用户id',
  `gmtCreate` datetime DEFAULT NULL COMMENT '创建时间',
  `gmtModified` datetime DEFAULT NULL COMMENT '修改时间',
  `sex` bigint(32) DEFAULT NULL COMMENT '性别',
  `birth` datetime DEFAULT NULL COMMENT '出身日期',
  `picId` bigint(32) DEFAULT NULL,
  `liveAddress` varchar(500) DEFAULT NULL COMMENT '现居住地',
  `hobby` varchar(255) DEFAULT NULL COMMENT '爱好',
  `province` varchar(255) DEFAULT NULL COMMENT '省份',
  `city` varchar(255) DEFAULT NULL COMMENT '所在城市',
  `district` varchar(255) DEFAULT NULL COMMENT '所在地区',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '超级管理员', '33808479d49ca8a3cdc93d4f976d1e3d', '7', 'eriz@163.com', '15814525912', '1', '1', '2017-08-15 21:40:39', '2017-08-15 21:41:00', '96', '2018-04-02 00:00:00', '151', '创客基地', '', '广东省', '广州市', '番禺区');
INSERT INTO `sys_user` VALUES ('2', 'test', '临时用户', 'b132f5f968c9373261f74025c23c2222', '7', 'test@ifast.com', '15278792752', '1', '1', '2017-08-14 13:43:05', '2017-08-14 21:15:36', '96', '2018-08-22 00:00:00', null, '', '', '北京市', '北京市市辖区', '东城区');
INSERT INTO `sys_user` VALUES ('4', 'eriz', '测试', '123123', '15', 'eriz@163.com', null, '1', null, null, null, '0', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for sys_user_copy
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_copy`;
CREATE TABLE `sys_user_copy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户名',
  `name` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '密码',
  `deptId` bigint(20) DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '手机号',
  `status` tinyint(255) DEFAULT NULL COMMENT '状态 0:禁用，1:正常',
  `userIdCreate` bigint(255) DEFAULT NULL COMMENT '创建用户id',
  `gmtCreate` datetime DEFAULT NULL COMMENT '创建时间',
  `gmtModified` datetime DEFAULT NULL COMMENT '修改时间',
  `sex` bigint(2) DEFAULT NULL COMMENT '性别',
  `birth` datetime DEFAULT NULL COMMENT '出身日期',
  `picId` bigint(32) DEFAULT NULL,
  `liveAddress` varchar(500) CHARACTER SET utf8 DEFAULT NULL COMMENT '现居住地',
  `hobby` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '爱好',
  `province` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '省份',
  `city` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '所在城市',
  `district` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '所在地区',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_user_copy
-- ----------------------------
INSERT INTO `sys_user_copy` VALUES ('1', 'admin', '超级管理员', '33808479d49ca8a3cdc93d4f976d1e3d', '6', 'izenglong@163.com', '15277778888', '1', '1', '2017-08-15 21:40:39', '2017-08-15 21:41:00', '96', '2018-04-02 00:00:00', '151', '创客基地', '', '广东省', '广州市', '番禺区');
INSERT INTO `sys_user_copy` VALUES ('2', 'test', '临时用户', 'b132f5f968c9373261f74025c23c2222', '6', 'test@ifast.com', '15278792752', '1', '1', '2017-08-14 13:43:05', '2017-08-14 21:15:36', '96', '2018-08-22 00:00:00', null, '', '', '北京市', '北京市市辖区', '东城区');
INSERT INTO `sys_user_copy` VALUES ('3', 'appUser', 'user', 'fc4d8bf7d69f03344a58f9381dd75dfe', '12', 'appUser@ifast.com', null, '1', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_user_copy` VALUES ('4', 'eriz', '测试', '123123', '15', 'eriz@163.com', null, null, null, null, null, '0', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `roleId` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=141 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('73', '56', '48');
INSERT INTO `sys_user_role` VALUES ('74', '30', '49');
INSERT INTO `sys_user_role` VALUES ('75', '30', '50');
INSERT INTO `sys_user_role` VALUES ('76', '31', '48');
INSERT INTO `sys_user_role` VALUES ('77', '31', '49');
INSERT INTO `sys_user_role` VALUES ('78', '31', '52');
INSERT INTO `sys_user_role` VALUES ('79', '32', '48');
INSERT INTO `sys_user_role` VALUES ('80', '32', '49');
INSERT INTO `sys_user_role` VALUES ('81', '32', '50');
INSERT INTO `sys_user_role` VALUES ('82', '32', '51');
INSERT INTO `sys_user_role` VALUES ('83', '32', '52');
INSERT INTO `sys_user_role` VALUES ('84', '33', '38');
INSERT INTO `sys_user_role` VALUES ('85', '33', '49');
INSERT INTO `sys_user_role` VALUES ('86', '33', '52');
INSERT INTO `sys_user_role` VALUES ('87', '34', '50');
INSERT INTO `sys_user_role` VALUES ('88', '34', '51');
INSERT INTO `sys_user_role` VALUES ('89', '34', '52');
INSERT INTO `sys_user_role` VALUES ('110', '1', '1');
INSERT INTO `sys_user_role` VALUES ('111', '2', '1');
INSERT INTO `sys_user_role` VALUES ('117', '135', '56');
INSERT INTO `sys_user_role` VALUES ('120', '134', '1');
INSERT INTO `sys_user_role` VALUES ('121', '134', '48');
INSERT INTO `sys_user_role` VALUES ('124', null, '48');
INSERT INTO `sys_user_role` VALUES ('127', null, '1');
INSERT INTO `sys_user_role` VALUES ('128', null, '1');
INSERT INTO `sys_user_role` VALUES ('129', null, '1');
INSERT INTO `sys_user_role` VALUES ('131', '137', '57');
INSERT INTO `sys_user_role` VALUES ('139', '1073159779293106178', '1');
INSERT INTO `sys_user_role` VALUES ('140', '1073159779293106178', '1034088931742957569');

-- ----------------------------
-- Table structure for wx_mp_config
-- ----------------------------
DROP TABLE IF EXISTS `wx_mp_config`;
CREATE TABLE `wx_mp_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `token` varchar(120) DEFAULT NULL,
  `appId` varchar(64) NOT NULL COMMENT 'APPID',
  `appSecret` varchar(128) NOT NULL COMMENT 'AppSecret',
  `msgMode` int(11) DEFAULT NULL COMMENT '1加密 0不加密',
  `msgSecret` varchar(128) DEFAULT NULL,
  `mpName` varchar(250) DEFAULT NULL COMMENT '公众号名字',
  `appType` int(11) NOT NULL COMMENT '公众号类型： 1.订阅号 2.服务号 3.企业号 4.小程序 5. 测试号',
  `isAuth` int(11) DEFAULT NULL COMMENT '认证授权：1已认证 0未认证',
  `subscribeUrl` varchar(500) DEFAULT NULL COMMENT '提示订阅URL',
  `appKey` varchar(100) DEFAULT NULL COMMENT '开放的公众号key',
  `logo` varchar(255) DEFAULT NULL,
  `createTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COMMENT='微信配置表';

-- ----------------------------
-- Records of wx_mp_config
-- ----------------------------
INSERT INTO `wx_mp_config` VALUES ('11', '72597b9628704ab09e8b9e8cbe9b540a', 'wxeb5638d307d3df71', '03b1501c72a91f2935037336e43e67e6', '0', '', '源码在线-测试', '5', '0', 'http://xxx.com/test', 'ymhTest', 'http://p6r7ke2jc.bkt.clouddn.com/ifast/20180822/photo_s-1534922328124.png', '2017-11-03 17:32:53');

-- ----------------------------
-- Table structure for wx_mp_fans
-- ----------------------------
DROP TABLE IF EXISTS `wx_mp_fans`;
CREATE TABLE `wx_mp_fans` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `mpId` bigint(11) NOT NULL COMMENT '公众号id',
  `openid` varchar(100) DEFAULT NULL COMMENT '用户的标识，对当前公众号唯一',
  `nickname` varchar(100) DEFAULT NULL COMMENT '昵称',
  `subscribe` tinyint(4) DEFAULT NULL COMMENT '用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。0未关注，1已关注',
  `subscribeTime` datetime DEFAULT NULL COMMENT '用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间',
  `subscribeKey` varchar(100) DEFAULT NULL COMMENT '关注来源',
  `sex` tinyint(4) DEFAULT NULL COMMENT '用户的性别，值为1时是男性，值为2时是女性，值为0时是未知',
  `city` varchar(100) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `province` varchar(100) DEFAULT NULL,
  `language` varchar(100) DEFAULT NULL COMMENT '语言',
  `headimgurl` varchar(500) DEFAULT NULL COMMENT '用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。',
  `unionid` varchar(125) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL COMMENT '公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注',
  `groupid` int(20) DEFAULT NULL COMMENT '分组ID',
  `status` tinyint(11) DEFAULT NULL COMMENT '用户状态 1:正常，0：禁用',
  `tagidList` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2905 DEFAULT CHARSET=utf8mb4 COMMENT='微信粉丝表';

-- ----------------------------
-- Records of wx_mp_fans
-- ----------------------------
INSERT INTO `wx_mp_fans` VALUES ('2899', '5', 'oorK7v4LWw3GMbwt_Ck6PuQ_8_D8', '你是我的眼', '0', null, null, '2', '广州', '中国', '广东', 'zh_CN', 'http://wx.qlogo.cn/mmopen/A7sq8BD8oewx50myY72SwetEVkBXbXDvT5jj6ytorRxqyGwtBu1XTnWGohGXhdTtTwh6VSAbUEUSWpibddJDChg/0', 'oI55m1o8VxrTFvV57WkzEFTHLRIM', null, null, '0', null);
INSERT INTO `wx_mp_fans` VALUES ('2902', '7', 'otO0P09bRa-YRLNlPbJEL1bdDjkQ', 'Aron', '1', '2017-11-24 11:14:28', '', '1', '广州', '中国', '广东', 'zh_CN', 'http://wx.qlogo.cn/mmopen/BQD9yxMcK6CicIrF6tU8Pqucb2VgYicn1iaTMTwm9war1KLT9RlibbsJ9cYal7yypERODjt6XGXC4dVJdVs9woJZBHwI0ibmaGQxY/0', 'oVzGa0kCIhSXljL9wDALjN00ylOs', '', '0', '0', null);
INSERT INTO `wx_mp_fans` VALUES ('2904', '9', 'ozbGr0vZhCS8Pe1lpTuy1tq9Wlls', 'SuSu', '0', '2017-11-26 21:03:25', '', '1', '江北', '中国', '重庆', 'zh_CN', 'http://wx.qlogo.cn/mmopen/8o7KgbIM6ibFyF3coD1mMMdm91kic6Tb68P0hq9lDccec0TllUm5MnBa4WEesfiaW1HUXWqNqCTNUsrYM5iceq9gnesbSPSaE0Yw/0', 'oJitl0bd590o0ONtSt1nB7hFh0Bo', '', '0', null, null);

-- ----------------------------
-- Table structure for wx_mp_menu
-- ----------------------------
DROP TABLE IF EXISTS `wx_mp_menu`;
CREATE TABLE `wx_mp_menu` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `parentIdx` bigint(20) DEFAULT NULL,
  `menuType` varchar(50) NOT NULL COMMENT '菜单类型：1主菜单，2链接，3文本，4关键字，5扫码，6发图，7发送位置',
  `menuName` varchar(128) NOT NULL,
  `menuKey` varchar(64) DEFAULT NULL,
  `menuUrl` varchar(500) DEFAULT NULL COMMENT '菜单链接',
  `replyContent` varchar(500) DEFAULT NULL,
  `scanType` int(4) DEFAULT NULL COMMENT '扫码类型：1扫码带事件，2扫码带提示',
  `pictureType` int(4) DEFAULT NULL COMMENT '发图类型：1，系统拍照发图；2,，拍照或者相册发图；3，微信相册发图',
  `location` varchar(255) DEFAULT NULL COMMENT '发送位置',
  `sort` int(11) DEFAULT NULL COMMENT '菜单排序',
  `status` int(4) DEFAULT NULL COMMENT '菜单状态',
  `createBy` bigint(20) DEFAULT NULL COMMENT '创建人',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateBy` bigint(20) DEFAULT NULL COMMENT '更新人',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  `mpId` bigint(20) NOT NULL COMMENT '微信配置ID',
  `idx` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信菜单表';

-- ----------------------------
-- Records of wx_mp_menu
-- ----------------------------

-- ----------------------------
-- Table structure for wx_mp_wechat_keys
-- ----------------------------
DROP TABLE IF EXISTS `wx_mp_wechat_keys`;
CREATE TABLE `wx_mp_wechat_keys` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mpId` bigint(20) NOT NULL COMMENT '公众号id',
  `mediaId` varchar(50) DEFAULT NULL COMMENT '素材Id',
  `keyword` varchar(200) DEFAULT NULL COMMENT '关键字，以#,#隔开',
  `type` tinyint(4) DEFAULT NULL COMMENT '回复类型，1：关键字 2：关注自动回复 3：默认回复',
  `replyType` varchar(20) DEFAULT NULL COMMENT '回复类型，文字：text 图文：news 图片： image 语音：voice 音乐：music 视频：video',
  `content` text COMMENT '内容',
  `newsId` bigint(20) DEFAULT NULL COMMENT '图文素材Id',
  `musicTitle` varchar(100) DEFAULT NULL COMMENT '音乐标题',
  `musicCover` varchar(255) DEFAULT NULL COMMENT '音乐封面',
  `musicUrl` varchar(255) DEFAULT NULL COMMENT '音乐url',
  `musicDesc` varchar(255) DEFAULT NULL COMMENT '音乐描述',
  `imageUrl` varchar(255) DEFAULT NULL COMMENT '图片URL',
  `voiceUrl` varchar(255) DEFAULT NULL COMMENT '音频URL',
  `videoTitle` varchar(100) DEFAULT NULL COMMENT '视频标题',
  `videoUrl` varchar(255) DEFAULT NULL COMMENT '视频url',
  `videoDesc` varchar(255) DEFAULT NULL COMMENT '视频描述',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态 0：禁用 1：启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='微信-关键字回复';

-- ----------------------------
-- Records of wx_mp_wechat_keys
-- ----------------------------
