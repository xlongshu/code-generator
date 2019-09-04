CREATE TABLE table_tpl (
  id bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  yn tinyint(2) DEFAULT 1 COMMENT '数据是否有效',
  created_date datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建时间',
  modified_date datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '数据修改时间',

  KEY idx_yn (yn) USING BTREE,
  PRIMARY KEY (id)
) ENGINE=InnoDB COMMENT='表模板';
