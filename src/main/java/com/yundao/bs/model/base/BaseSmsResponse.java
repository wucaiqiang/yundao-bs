package com.yundao.bs.model.base;

import com.yundao.core.base.model.BaseModel;
import java.io.Serializable;

public class BaseSmsResponse extends BaseModel implements Serializable {
    /**
	 * 短信签名签名
	 */
    private String sign;

    /**
	 * 模版CODE
	 */
    private String templateCode;

    /**
	 * 模版参数
	 */
    private String templateParam;

    /**
	 * 流水号
	 */
    private String seqId;

    /**
	 * 业务id，发送回执id
	 */
    private String bizId;

    /**
	 * 状态码
	 */
    private String code;

    /**
	 * 短信类型；1：验证码，2：通知，3：群发推广
	 */
    private Integer smstype;

    /**
	 * 状态码描述
	 */
    private String message;

    private static final long serialVersionUID = 1L;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getTemplateParam() {
        return templateParam;
    }

    public void setTemplateParam(String templateParam) {
        this.templateParam = templateParam;
    }

    public String getSeqId() {
        return seqId;
    }

    public void setSeqId(String seqId) {
        this.seqId = seqId;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getSmstype() {
        return smstype;
    }

    public void setSmstype(Integer smstype) {
        this.smstype = smstype;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}