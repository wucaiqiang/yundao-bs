package com.yundao.bs.dto.sms;

import java.io.Serializable;
import java.util.List;

/**
 * 短信分组dto
 *
 * @author jan
 * @create 2017-06-19 AM8:22
 **/
public class SmsGroupDto implements Serializable {


    /**
     * 流水号
     */
    private String seqNo;

    /**
     * 按每100个号码分批次
     */
    private List<SmsBatchDto> batchs;

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public List<SmsBatchDto> getBatchs() {
        return batchs;
    }

    public void setBatchs(List<SmsBatchDto> batchs) {
        this.batchs = batchs;
    }
}
