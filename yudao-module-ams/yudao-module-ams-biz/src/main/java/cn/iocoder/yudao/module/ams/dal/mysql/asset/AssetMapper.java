package cn.iocoder.yudao.module.ams.dal.mysql.asset;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.ams.dal.dataobject.asset.AssetDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.ams.controller.admin.asset.vo.*;

/**
 * 资产清单 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface AssetMapper extends BaseMapperX<AssetDO> {

    default PageResult<AssetDO> selectPage(AssetPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<AssetDO>()
                .eqIfPresent(AssetDO::getAssetId, reqVO.getAssetId())
                .likeIfPresent(AssetDO::getName, reqVO.getName())
                .likeIfPresent(AssetDO::getCustomName, reqVO.getCustomName())
                .eqIfPresent(AssetDO::getTrader, reqVO.getTrader())
                .eqIfPresent(AssetDO::getFactory, reqVO.getFactory())
                .betweenIfPresent(AssetDO::getOrderDate, reqVO.getOrderDate())
                .betweenIfPresent(AssetDO::getAppointmentDate, reqVO.getAppointmentDate())
                .betweenIfPresent(AssetDO::getPreShipmentDate, reqVO.getPreShipmentDate())
                .eqIfPresent(AssetDO::getOrderId, reqVO.getOrderId())
                .eqIfPresent(AssetDO::getStyleNo, reqVO.getStyleNo())
                .eqIfPresent(AssetDO::getRfid, reqVO.getRfid())
                .eqIfPresent(AssetDO::getParentRfid, reqVO.getParentRfid())
                .eqIfPresent(AssetDO::getColor, reqVO.getColor())
                .eqIfPresent(AssetDO::getUnit, reqVO.getUnit())
                .eqIfPresent(AssetDO::getSize, reqVO.getSize())
                .eqIfPresent(AssetDO::getSizeStandard, reqVO.getSizeStandard())
                .eqIfPresent(AssetDO::getNumber, reqVO.getNumber())
                .eqIfPresent(AssetDO::getBarcode, reqVO.getBarcode())
                .eqIfPresent(AssetDO::getParentBarcode, reqVO.getParentBarcode())
                .eqIfPresent(AssetDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(AssetDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(AssetDO::getId));
    }

}