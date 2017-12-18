package com.yundao.bs.constant.url;

import com.yundao.bs.enums.UrlEnum;
import com.yundao.core.utils.ConfigUtils;

/**
 * 调用 公共管理系统的URL地址常量
 *
 * @author jan
 * @create 2017-06-21 PM8:02
 **/
public interface ScmUrlConstant {

    /**
     * HOST地址
     */
    String BASE_URL = ConfigUtils.getValue(UrlEnum.SCM_URL.getKey());
    ;

    /**
     * 获取租户数据源
     */
    String GET_DATA_SOURCE = BASE_URL + "/datasource/get_tenant";

    /**
     * 获取租户部门初始化数据
     */
    String GET_TENANT_DEPARTMENT_INIT_DATA = BASE_URL + "/tenantinitdepartment/get_tenant_department";


    /**
     * 获取租户角色初始化数据
     */
    String GET_TENANT_ROLE_INIT_DATA = BASE_URL + "/tenantinitrole/get_tenant_role";


    /**
     * 获取租户角色初始化数据
     */
    String GET_TENANT = BASE_URL + "/tenant/get";

    /**
     * 检查手机号码是否存在
     */
    String CHECK_MOBILE_EXIST = BASE_URL + "/tenant/user/check_mobile_exist";

    /**
     * 检查用户名和密码
     */
    String CHECK_USER_PASSWORD = BASE_URL + "/tenant/user/check_user_password";
    String USER_LOGIN = BASE_URL + "/user/login";
    String USER_LOGINOUT = BASE_URL + "/user/logout";
    String TICKET_VALIDATE = BASE_URL + "/ticket/validate";

    String ADD_USERACCOUNT_ADD = BASE_URL + "/tenant/user/add";

    /**
     * 修改用户密码
     */
    String UPDATE_USER_PASSWORD = BASE_URL + "/tenant/user/update_user_password";
    /**
     * 获取租户密钥对
     */
    String KEY_PAIR_GET_BY_TENANT_ID = BASE_URL + "/keypair/get_by_tenant_id";

    /**
     * 获取所有任何或待办任务
     */
    String WORK_FLOW_GETS = BASE_URL + "/task/gets";

    /**
     * 获取指定流程任务
     */
    String WORK_FLOW_GET_BY_RESOURCE = BASE_URL + "/task/gets_by_resource_name";

    /**
     * 审核工作流
     */
    String WORK_FLOW_DO = BASE_URL + "/task/complete";

    /**
     * 启动流程
     */
    String WORK_FLOW_START = BASE_URL + "/process/start";
}
