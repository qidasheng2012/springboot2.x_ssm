DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
  `id`   bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) COMMENT '姓名',
  `age`  int(3) COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;


INSERT INTO `USER`VALUES (1, '张三', 23);
INSERT INTO `USER`VALUES (2, '李四', 24);