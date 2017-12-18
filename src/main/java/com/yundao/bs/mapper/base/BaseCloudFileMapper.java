package com.yundao.bs.mapper.base;

import com.yundao.bs.model.base.BaseCloudFile;
import com.yundao.bs.model.base.BaseCloudFileExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseCloudFileMapper {
    int countByExample(BaseCloudFileExample example);

    int deleteByExample(BaseCloudFileExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseCloudFile record);

    int insertSelective(BaseCloudFile record);

    List<BaseCloudFile> selectByExample(BaseCloudFileExample example);

    BaseCloudFile selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseCloudFile record, @Param("example") BaseCloudFileExample example);

    BaseCloudFile selectOne(BaseCloudFileExample example);

    int updateByExample(@Param("record") BaseCloudFile record, @Param("example") BaseCloudFileExample example);

    int updateByPrimaryKeySelective(BaseCloudFile record);

    int updateByPrimaryKey(BaseCloudFile record);
}