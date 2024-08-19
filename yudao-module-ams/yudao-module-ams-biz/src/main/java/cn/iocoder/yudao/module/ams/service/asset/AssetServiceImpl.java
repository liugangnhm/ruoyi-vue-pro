package cn.iocoder.yudao.module.ams.service.asset;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.ams.controller.admin.asset.vo.*;
import cn.iocoder.yudao.module.ams.dal.dataobject.asset.AssetDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.ams.dal.mysql.asset.AssetMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.ams.enums.ErrorCodeConstants.*;

/**
 * 资产清单 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class AssetServiceImpl implements AssetService {

    @Resource
    private AssetMapper assetMapper;

    @Override
    public Long createAsset(AssetSaveReqVO createReqVO) {
        // 插入
        AssetDO asset = BeanUtils.toBean(createReqVO, AssetDO.class);
        assetMapper.insert(asset);
        // 返回
        return asset.getId();
    }

    @Override
    public void updateAsset(AssetSaveReqVO updateReqVO) {
        // 校验存在
        validateAssetExists(updateReqVO.getId());
        // 更新
        AssetDO updateObj = BeanUtils.toBean(updateReqVO, AssetDO.class);
        assetMapper.updateById(updateObj);
    }

    @Override
    public void deleteAsset(Long id) {
        // 校验存在
        validateAssetExists(id);
        // 删除
        assetMapper.deleteById(id);
    }

    private void validateAssetExists(Long id) {
        if (assetMapper.selectById(id) == null) {
            throw exception(ASSET_NOT_EXISTS);
        }
    }

    @Override
    public AssetDO getAsset(Long id) {
        return assetMapper.selectById(id);
    }

    @Override
    public PageResult<AssetDO> getAssetPage(AssetPageReqVO pageReqVO) {
        return assetMapper.selectPage(pageReqVO);
    }

}