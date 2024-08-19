package cn.iocoder.yudao.module.ams.service.asset;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.ams.controller.admin.asset.vo.*;
import cn.iocoder.yudao.module.ams.dal.dataobject.asset.AssetDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 资产清单 Service 接口
 *
 * @author 芋道源码
 */
public interface AssetService {

    /**
     * 创建资产清单
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createAsset(@Valid AssetSaveReqVO createReqVO);

    /**
     * 更新资产清单
     *
     * @param updateReqVO 更新信息
     */
    void updateAsset(@Valid AssetSaveReqVO updateReqVO);

    /**
     * 删除资产清单
     *
     * @param id 编号
     */
    void deleteAsset(Long id);

    /**
     * 获得资产清单
     *
     * @param id 编号
     * @return 资产清单
     */
    AssetDO getAsset(Long id);

    /**
     * 获得资产清单分页
     *
     * @param pageReqVO 分页查询
     * @return 资产清单分页
     */
    PageResult<AssetDO> getAssetPage(AssetPageReqVO pageReqVO);

}