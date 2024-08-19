-- 资产信息登记表
DROP table if exists ams_asset_register;
CREATE TABLE `ams_asset_register`
(
    `id`          bigint      NOT NULL AUTO_INCREMENT COMMENT '编号',
    `register_id` varchar(64) NOT NULL COMMENT '资产登记单号',                  -- uk
    `status`      int         NOT NULL COMMENT '当前状态:待处理，已取消，已登记', -- status enum
    `creator`     varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime    NOT NULL                                         DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater`     varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime    NOT NULL                                         DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`     bit(1)      NOT NULL                                         DEFAULT b'0' COMMENT '是否删除',
    `tenant_id`   bigint      NOT NULL                                         DEFAULT '0' COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='资产信息登记表';


-- 资产信息登记详情表
DROP table if exists ams_asset_register_detail;
CREATE TABLE `ams_asset_register_detail`
(
    `id`          bigint   NOT NULL AUTO_INCREMENT COMMENT '编号',
    `register_id` bigint   NOT NULL COMMENT '资产信息登记表ID',
    `asset_id`    bigint   NOT NULL COMMENT '资产ID', -- uk
    `creator`     varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
    `create_time` datetime NOT NULL                                            DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater`     varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
    `update_time` datetime NOT NULL                                            DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`     bit(1)   NOT NULL                                            DEFAULT b'0' COMMENT '是否删除',
    `tenant_id`   bigint   NOT NULL                                            DEFAULT '0' COMMENT '租户编号',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='资产信息登记详情表';

-- 资产清单
DROP table if exists ams_asset;
CREATE TABLE `ams_asset`
(
    `id`                bigint                                                        NOT NULL AUTO_INCREMENT COMMENT '编号',
    `asset_id`          varchar(64)                                                   NOT NULL COMMENT '资产编号',          -- uk
    `name`              varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '资产名称',
    `custom_name`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci          DEFAULT '' COMMENT '客户名称',
    `trader`            varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci          DEFAULT '' COMMENT '贸易商',
    `factory`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci          DEFAULT '' COMMENT '厂家',
    `order_date`        datetime                                                               DEFAULT NULL COMMENT '订单日期',
    `appointment_date`  datetime                                                               DEFAULT NULL COMMENT '预约日期',
    `pre_shipment_date` datetime                                                               DEFAULT NULL COMMENT '预发货日期',
    `order_id`          varchar(255)                                                           DEFAULT '' COMMENT '订单号',
    `style_no`          varchar(255)                                                           DEFAULT '' COMMENT '款号',
    `rfid`              varchar(512)                                                           DEFAULT '' COMMENT 'RFID',   -- uk
    `parent_rfid`       varchar(512)                                                           DEFAULT '' COMMENT '父级RFID',
    `color`             int                                                                    DEFAULT NULL COMMENT '颜色',
    `unit`              int                                                                    DEFAULT NULL COMMENT '单位',
    `size`              varchar(10)                                                            DEFAULT NULL COMMENT '码数',
    `size_standard`     int                                                                    DEFAULT NULL COMMENT '码数标准',
    `number`            int                                                                    DEFAULT NULL COMMENT '数量',
    `barcode`           varchar(512)                                                           DEFAULT '' COMMENT '条形码', -- uk
    `parent_barcode`    varchar(512)                                                           DEFAULT '' COMMENT '父级条形码',
    `status`            int                                                           NOT NULL DEFAULT 0 COMMENT '状态',    -- status enum
    `creator`           varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci           DEFAULT '' COMMENT '创建者',
    `create_time`       datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updater`           varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci           DEFAULT '' COMMENT '更新者',
    `update_time`       datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `deleted`           bit(1)                                                        NOT NULL DEFAULT b'0' COMMENT '是否删除',
    `tenant_id`         bigint                                                        NOT NULL DEFAULT '0' COMMENT '租户编号',
    INDEX `idx_asset_id` (`asset_id` ASC) USING BTREE,
    INDEX `idx_rfid` (`rfid` ASC) USING BTREE,
    INDEX `idx_barcode` (`barcode` ASC) USING BTREE,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT ='资产清单';