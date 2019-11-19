SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher` (
                           `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                           `name` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES ('1', '赵老师');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
                        `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                        `name` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
                        `age` int(3) DEFAULT NULL COMMENT '年龄',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '张三', '23');
INSERT INTO `t_user` VALUES ('2', '李四', '24');
INSERT INTO `t_user` VALUES ('3', '王五', '25');
INSERT INTO `t_user` VALUES ('4', '赵六', '26');
