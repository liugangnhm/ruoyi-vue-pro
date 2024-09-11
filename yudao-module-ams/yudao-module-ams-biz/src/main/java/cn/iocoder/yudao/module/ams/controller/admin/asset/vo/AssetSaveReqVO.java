package cn.iocoder.yudao.module.ams.controller.admin.asset.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 资产清单新增/修改 Request VO")
@Data
public class AssetSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "31571")
    private Long id;

    @Schema(description = "资产编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "5074")
    @NotEmpty(message = "资产编号不能为空")
    private String assetId;

    @Schema(description = "资产名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "张三")
    @NotEmpty(message = "资产名称不能为空")
    private String name;

    @Schema(description = "客户名称", example = "李四")
    private String customName;

    @Schema(description = "贸易商")
    private String trader;

    @Schema(description = "厂家")
    private String factory;

    @Schema(description = "订单日期")
    private LocalDateTime orderDate;

    @Schema(description = "预约日期")
    private LocalDateTime appointmentDate;

    @Schema(description = "预发货日期")
    private LocalDateTime preShipmentDate;

    @Schema(description = "订单号", example = "19151")
    private String orderId;

    @Schema(description = "款号")
    private String styleNo;

    @Schema(description = "RFID", example = "20416")
    private String rfid;

    @Schema(description = "父级RFID", example = "1740")
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

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "状态不能为空")
    private Integer status;

}