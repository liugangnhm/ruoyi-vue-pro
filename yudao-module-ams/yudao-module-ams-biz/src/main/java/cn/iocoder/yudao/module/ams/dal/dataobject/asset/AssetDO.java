package cn.iocoder.yudao.module.ams.dal.dataobject.asset;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 资产清单 DO
 *
 * @author 芋道源码
 */
@TableName("ams_asset")
@KeySequence("ams_asset_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssetDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 资产编号
     */
    private String assetId;
    /**
     * 资产名称
     */
    private String name;
    /**
     * 客户名称
     */
    private String customName;
    /**
     * 贸易商
     */
    private String trader;
    /**
     * 厂家
     */
    private String factory;
    /**
     * 订单日期
     */
    private LocalDateTime orderDate;
    /**
     * 预约日期
     */
    private LocalDateTime appointmentDate;
    /**
     * 预发货日期
     */
    private LocalDateTime preShipmentDate;
    /**
     * 订单号
     */
    private String orderId;
    /**
     * 款号
     */
    private String styleNo;
    /**
     * RFID
     */
    private String rfid;
    /**
     * 父级RFID
     */
    private String parentRfid;
    /**
     * 颜色
     */
    private Integer color;
    /**
     * 单位
     */
    private Integer unit;
    /**
     * 码数
     */
    private String size;
    /**
     * 码数标准
     */
    private Integer sizeStandard;
    /**
     * 数量
     */
    private Integer number;
    /**
     * 条形码
     */
    private String barcode;
    /**
     * 父级条形码
     */
    private String parentBarcode;
    /**
     * 状态
     */
    private Integer status;

}