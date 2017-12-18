package com.yundao.bs.mapper.base;

import com.yundao.bs.model.base.BaseSmsHistory;
import com.yundao.bs.model.base.BaseSmsHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseSmsHistoryMapper {
    int countByExample(BaseSmsHistoryExample example);

    int deleteByExample(BaseSmsHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseSmsHistory record);

    int insertSelective(BaseSmsHistory record);

    List<BaseSmsHistory> selectByExample(BaseSmsHistoryExample example);

    BaseSmsHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseSmsHistory record, @Param("example") BaseSmsHistoryExample example);

    BaseSmsHistory selectOne(BaseSmsHistoryExample example);

    int updateByExample(@Param("record") BaseSmsHistory record, @Param("example") BaseSmsHistoryExample example);

    int updateByPrimaryKeySelective(BaseSmsHistory record);

    int updateByPrimaryKey(BaseSmsHistory record);
}