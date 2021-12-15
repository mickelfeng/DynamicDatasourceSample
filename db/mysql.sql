CREATE TABLE mg_dict
(
    id          BIGINT(20)   NOT NULL COMMENT '主键',
    NAME        VARCHAR(512) NOT NULL COMMENT '名称',
    VALUE       TEXT COMMENT '值',
    remark      TEXT COMMENT '备注',
    create_id   BIGINT(20)   NOT NULL COMMENT '创建人',
    update_id   BIGINT(20) DEFAULT NULL COMMENT '更新人',
    create_time DATETIME     NOT NULL COMMENT '创建时间',
    update_time DATETIME   DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (id),
    UNIQUE uk_name (NAME),
    INDEX idx_create_time (create_time)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8mb4 COMMENT ='字典表';