package com.yundao.bs.mapper.base;

import com.yundao.bs.model.base.BaseSmsResponse;
import com.yundao.bs.model.base.BaseSmsResponseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseSmsResponseMapper {
    int countByExample(BaseSmsResponseExample example);

    int deleteByExample(BaseSmsResponseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseSmsResponse record);

    int insertSelective(BaseSmsResponse record);

    List<BaseSmsResponse> selectByExample(BaseSmsResponseExample example);

    BaseSmsResponse selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseSmsResponse record, @Param("example") BaseSmsResponseExample example);

    BaseSmsResponse selectOne(BaseSmsResponseExample example);

    int updateByExample(@Param("record") BaseSmsResponse record, @Param("example") BaseSmsResponseExample example);

    int updateByPrimaryKeySelective(BaseSmsResponse record);

    int updateByPrimaryKey(BaseSmsResponse record);
}