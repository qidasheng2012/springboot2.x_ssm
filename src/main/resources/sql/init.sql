SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_operation_log
-- ----------------------------
DROP TABLE IF EXISTS `t_operation_log`;
CREATE TABLE `t_operation_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `http_method` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `uri` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `resouce` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `param_json` text COLLATE utf8mb4_unicode_ci,
  `status` int(1) DEFAULT NULL,
  `operation_user_id` int(11) DEFAULT NULL,
  `operation_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '张三', '23');
INSERT INTO `t_user` VALUES ('2', '李四', '24');
INSERT INTO `t_user` VALUES ('3', '王五', '25');
INSERT INTO `t_user` VALUES ('4', '赵六', '26');
