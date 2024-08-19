package cn.iocoder.yudao.module.ams.controller.admin.asset.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 资产清单分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AssetPageReqVO extends PageParam {

    @Schema(description = "资产编号", example = "12295")
    private String assetId;

    @Schema(description = "资产名称", example = "李四")
    private String name;

    @Schema(description = "客户名称", example = "赵六")
    private String customName;

    @Schema(description = "贸易商")
    private String trader;

    @Schema(description = "厂家")
    private String factory;

    @Schema(description = "订单日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] orderDate;

    @Schema(description = "预约日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] appointmentDate;

    @Schema(description = "预发货日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] preShipmentDate;

    @Schema(description = "订单号", example = "3894")
    private String orderId;

    @Schema(description = "款号")
    private String styleNo;

    @Schema(description = "RFID", example = "29152")
    private String rfid;

    @Schema(description = "父级RFID", example = "29798")
    private String parentRfid;

    @Schema(description = "颜色")
    private Integer color;

    @Schema(description = "单位")
    private Integer unit;

    @Schema(description = "码数")
    private String size;

    @Schema(description = "码数标准")
    private Integer sizeStandard;

    @Schema(description = "数量")
    private Integer number;

    @Schema(description = "条形码")
    private String barcode;

    @Schema(description = "父级条形码")
    private String parentBarcode;

    @Schema(description = "状态", example = "2")
    private Integer status;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}