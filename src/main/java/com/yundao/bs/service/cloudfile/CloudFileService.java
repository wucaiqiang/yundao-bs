package com.yundao.bs.service.cloudfile;

import com.yundao.core.code.Result;
import com.yundao.core.pagination.PaginationSupport;
import com.yundao.bs.dto.AbstractBasePageDto;
import com.yundao.bs.dto.cloudfile.CloudFileUploadReqDto;
import com.yundao.bs.model.base.BaseCloudFile;

import java.io.InputStream;


public interface CloudFileService{


    public Result<Integer> add(BaseCloudFile cloudFile) throws Exception;


    public Result<Integer> update(BaseCloudFile cloudFile) throws Exception;


    public Result<Integer> delete(Long id) throws Exception;


    public Result<BaseCloudFile> get(Long id) throws Exception;

    public Result<PaginationSupport<BaseCloudFile>> getPage(BaseCloudFile baseCloudFile, AbstractBasePageDto pageDto) throws Exception;

    Result<BaseCloudFile> add(InputStream is, String originalName, CloudFileUploadReqDto reqDto) throws Exception;
}
