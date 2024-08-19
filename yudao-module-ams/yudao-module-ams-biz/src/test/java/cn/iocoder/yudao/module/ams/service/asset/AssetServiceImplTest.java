package cn.iocoder.yudao.module.ams.service.asset;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import jakarta.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.ams.controller.admin.asset.vo.*;
import cn.iocoder.yudao.module.ams.dal.dataobject.asset.AssetDO;
import cn.iocoder.yudao.module.ams.dal.mysql.asset.AssetMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.iocoder.yudao.module.ams.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.LocalDateTimeUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * {@link AssetServiceImpl} 的单元测试类
 *
 * @author 芋道源码
 */
@Import(AssetServiceImpl.class)
public class AssetServiceImplTest extends BaseDbUnitTest {

    @Resource
    private AssetServiceImpl assetService;

    @Resource
    private AssetMapper assetMapper;

    @Test
    public void testCreateAsset_success() {
        // 准备参数
        AssetSaveReqVO createReqVO = randomPojo(AssetSaveReqVO.class).setId(null);

        // 调用
        Long assetId = assetService.createAsset(createReqVO);
        // 断言
        assertNotNull(assetId);
        // 校验记录的属性是否正确
        AssetDO asset = assetMapper.selectById(assetId);
        assertPojoEquals(createReqVO, asset, "id");
    }

    @Test
    public void testUpdateAsset_success() {
        // mock 数据
        AssetDO dbAsset = randomPojo(AssetDO.class);
        assetMapper.insert(dbAsset);// @Sql: 先插入出一条存在的数据
        // 准备参数
        AssetSaveReqVO updateReqVO = randomPojo(AssetSaveReqVO.class, o -> {
            o.setId(dbAsset.getId()); // 设置更新的 ID
        });

        // 调用
        assetService.updateAsset(updateReqVO);
        // 校验是否更新正确
        AssetDO asset = assetMapper.selectById(updateReqVO.getId()); // 获取最新的
        assertPojoEquals(updateReqVO, asset);
    }

    @Test
    public void testUpdateAsset_notExists() {
        // 准备参数
        AssetSaveReqVO updateReqVO = randomPojo(AssetSaveReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> assetService.updateAsset(updateReqVO), ASSET_NOT_EXISTS);
    }

    @Test
    public void testDeleteAsset_success() {
        // mock 数据
        AssetDO dbAsset = randomPojo(AssetDO.class);
        assetMapper.insert(dbAsset);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbAsset.getId();

        // 调用
        assetService.deleteAsset(id);
       // 校验数据不存在了
       assertNull(assetMapper.selectById(id));
    }

    @Test
    public void testDeleteAsset_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> assetService.deleteAsset(id), ASSET_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAssetPage() {
       // mock 数据
       AssetDO dbAsset = randomPojo(AssetDO.class, o -> { // 等会查询到
           o.setAssetId(null);
           o.setName(null);
           o.setCustomName(null);
           o.setTrader(null);
           o.setFactory(null);
           o.setOrderDate(null);
           o.setAppointmentDate(null);
           o.setPreShipmentDate(null);
           o.setOrderId(null);
           o.setStyleNo(null);
           o.setRfid(null);
           o.setParentRfid(null);
           o.setColor(null);
           o.setUnit(null);
           o.setSize(null);
           o.setSizeStandard(null);
           o.setNumber(null);
           o.setBarcode(null);
           o.setParentBarcode(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       assetMapper.insert(dbAsset);
       // 测试 assetId 不匹配
       assetMapper.insert(cloneIgnoreId(dbAsset, o -> o.setAssetId(null)));
       // 测试 name 不匹配
       assetMapper.insert(cloneIgnoreId(dbAsset, o -> o.setName(null)));
       // 测试 customName 不匹配
       assetMapper.insert(cloneIgnoreId(dbAsset, o -> o.setCustomName(null)));
       // 测试 trader 不匹配
       assetMapper.insert(cloneIgnoreId(dbAsset, o -> o.setTrader(null)));
       // 测试 factory 不匹配
       assetMapper.insert(cloneIgnoreId(dbAsset, o -> o.setFactory(null)));
       // 测试 orderDate 不匹配
       assetMapper.insert(cloneIgnoreId(dbAsset, o -> o.setOrderDate(null)));
       // 测试 appointmentDate 不匹配
       assetMapper.insert(cloneIgnoreId(dbAsset, o -> o.setAppointmentDate(null)));
       // 测试 preShipmentDate 不匹配
       assetMapper.insert(cloneIgnoreId(dbAsset, o -> o.setPreShipmentDate(null)));
       // 测试 orderId 不匹配
       assetMapper.insert(cloneIgnoreId(dbAsset, o -> o.setOrderId(null)));
       // 测试 styleNo 不匹配
       assetMapper.insert(cloneIgnoreId(dbAsset, o -> o.setStyleNo(null)));
       // 测试 rfid 不匹配
       assetMapper.insert(cloneIgnoreId(dbAsset, o -> o.setRfid(null)));
       // 测试 parentRfid 不匹配
       assetMapper.insert(cloneIgnoreId(dbAsset, o -> o.setParentRfid(null)));
       // 测试 color 不匹配
       assetMapper.insert(cloneIgnoreId(dbAsset, o -> o.setColor(null)));
       // 测试 unit 不匹配
       assetMapper.insert(cloneIgnoreId(dbAsset, o -> o.setUnit(null)));
       // 测试 size 不匹配
       assetMapper.insert(cloneIgnoreId(dbAsset, o -> o.setSize(null)));
       // 测试 sizeStandard 不匹配
       assetMapper.insert(cloneIgnoreId(dbAsset, o -> o.setSizeStandard(null)));
       // 测试 number 不匹配
       assetMapper.insert(cloneIgnoreId(dbAsset, o -> o.setNumber(null)));
       // 测试 barcode 不匹配
       assetMapper.insert(cloneIgnoreId(dbAsset, o -> o.setBarcode(null)));
       // 测试 parentBarcode 不匹配
       assetMapper.insert(cloneIgnoreId(dbAsset, o -> o.setParentBarcode(null)));
       // 测试 status 不匹配
       assetMapper.insert(cloneIgnoreId(dbAsset, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       assetMapper.insert(cloneIgnoreId(dbAsset, o -> o.setCreateTime(null)));
       // 准备参数
       AssetPageReqVO reqVO = new AssetPageReqVO();
       reqVO.setAssetId(null);
       reqVO.setName(null);
       reqVO.setCustomName(null);
       reqVO.setTrader(null);
       reqVO.setFactory(null);
       reqVO.setOrderDate(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setAppointmentDate(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setPreShipmentDate(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setOrderId(null);
       reqVO.setStyleNo(null);
       reqVO.setRfid(null);
       reqVO.setParentRfid(null);
       reqVO.setColor(null);
       reqVO.setUnit(null);
       reqVO.setSize(null);
       reqVO.setSizeStandard(null);
       reqVO.setNumber(null);
       reqVO.setBarcode(null);
       reqVO.setParentBarcode(null);
       reqVO.setStatus(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<AssetDO> pageResult = assetService.getAssetPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbAsset, pageResult.getList().get(0));
    }

}