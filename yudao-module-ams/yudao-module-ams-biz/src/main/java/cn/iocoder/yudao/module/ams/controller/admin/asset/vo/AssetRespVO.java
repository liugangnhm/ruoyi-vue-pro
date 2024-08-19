package cn.iocoder.yudao.module.ams.controller.admin.asset.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 资产清单 Response VO")
@Data
@ExcelIgnoreUnannotated
public class AssetRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "28985")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "资产编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "12295")
    @ExcelProperty("资产编号")
    private String assetId;

    @Schema(description = "资产名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "李四")
    @ExcelProperty("资产名称")
    private String name;

    @Schema(description = "客户名称", example = "赵六")
    @ExcelProperty("客户名称")
    private String customName;

    @Schema(description = "贸易商")
    @ExcelProperty("贸易商")
    private String trader;

    @Schema(description = "厂家")
    @ExcelProperty("厂家")
    private String factory;

    @Schema(description = "订单日期")
    @ExcelProperty("订单日期")
    private LocalDateTime orderDate;

    @Schema(description = "预约日期")
    @ExcelProperty("预约日期")
    private LocalDateTime appointmentDate;

    @Schema(description = "预发货日期")
    @ExcelProperty("预发货日期")
    private LocalDateTime preShipmentDate;

    @Schema(description = "订单号", example = "3894")
    @ExcelProperty("订单号")
    private String orderId;

    @Schema(description = "款号")
    @ExcelProperty("款号")
    private String styleNo;

    @Schema(description = "RFID", example = "29152")
    @ExcelProperty("RFID")
    private String rfid;

    @Schema(description = "父级RFID", example = "29798")
    @ExcelProperty("父级RFID")
    private String parentRfid;

    @Schema(description = "颜色")
    @ExcelProperty("颜色")
    private Integer color;

    @Schema(description = "单位")
    @ExcelProperty("单位")
    private Integer unit;

    @Schema(description = "码数")
    @ExcelProperty("码数")
    private String size;

    @Schema(description = "码数标准")
    @ExcelProperty("码数标准")
    private Integer sizeStandard;

    @Schema(description = "数量")
    @ExcelProperty("数量")
    private Integer number;

    @Schema(description = "条形码")
    @ExcelProperty("条形码")
    private String barcode;

    @Schema(description = "父级条形码")
    @ExcelProperty("父级条形码")
    private String parentBarcode;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}